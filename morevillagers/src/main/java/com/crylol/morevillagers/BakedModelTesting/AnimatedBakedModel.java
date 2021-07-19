package com.crylol.morevillagers.BakedModelTesting;

import com.crylol.morevillagers.Joint;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.*;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.geometry.IModelGeometryPart;
import net.minecraftforge.client.model.geometry.IMultipartModelGeometry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Function;

public class AnimatedBakedModel extends CompositeModel {

    private final ImmutableMap<String, Joint> JOINTS;
    private final ImmutableMap<String, IBakedModel> PARTS;

    private AnimatedBakedModel prevState;

    public AnimatedBakedModel(boolean isGui3d, boolean isSideLit, boolean isAmbientOcclusion, TextureAtlasSprite particle, ImmutableMap<String, IBakedModel> bakedParts, ImmutableMap<String, Joint> joints, IModelTransform combinedTransform, ItemOverrideList overrides) {
        super(isGui3d, isSideLit, isAmbientOcclusion, particle, bakedParts, combinedTransform, overrides);
        JOINTS = joints;
        PARTS = bakedParts;
    }


    //TODO
    public IBakedModel animate() {
        return this;
    }

    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
        return super.getQuads(state, side, rand, extraData);
    }


    public static class AnimatedModelLoader implements IModelLoader<AnimatedModelGeometry> {
        public static final AnimatedModelLoader INSTANCE = new AnimatedModelLoader();

        public AnimatedModelLoader() {
            super();
        }

        @Override
        public void onResourceManagerReload(IResourceManager resourceManager) {

        }

        @Override
        public AnimatedModelGeometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
            if (!modelContents.has("parts"))
                throw new RuntimeException("Composite model requires a \"parts\" element.");
            ImmutableMap.Builder<String, Submodel> parts = ImmutableMap.builder();
            for (Map.Entry<String, JsonElement> part : modelContents.get("parts").getAsJsonObject().entrySet()) {
                IModelTransform modelTransform = SimpleModelTransform.IDENTITY;
                parts.put(part.getKey(), new Submodel(
                        part.getKey(),
                        deserializationContext.deserialize(part.getValue(), BlockModel.class),
                        modelTransform));
            }
            if (!modelContents.has("joints"))
                throw new RuntimeException("Composite model requires a \"joints\" element.");
            ImmutableMap.Builder<String, Joint> joints = ImmutableMap.builder();
            for (Map.Entry<String, JsonElement> part : modelContents.get("joints").getAsJsonObject().entrySet()) {
                joints.put(part.getKey(), new Joint(part.getValue().getAsJsonObject()));
            }

            return new AnimatedModelGeometry(parts.build(), joints.build());
        }
    }

    public static class AnimatedModelGeometry implements IMultipartModelGeometry<AnimatedModelGeometry> {

        private final ImmutableMap<String, Submodel> PARTS;
        private final ImmutableMap<String, Joint> JOINTS;

        public AnimatedModelGeometry(ImmutableMap<String, Submodel> parts, ImmutableMap<String, Joint> joints) {
            this.PARTS = parts;
            JOINTS = joints;
        }

        @Override
        public Collection<? extends IModelGeometryPart> getParts() {
            return PARTS.values();
        }

        @Override
        public Optional<? extends IModelGeometryPart> getPart(String name) {
            return Optional.ofNullable(PARTS.get(name));
        }

        public ImmutableMap<String, Joint> getJOINTS() {
            return JOINTS;
        }

        @Override
        public IBakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<RenderMaterial, TextureAtlasSprite> spriteGetter, IModelTransform modelTransform, ItemOverrideList overrides, ResourceLocation modelLocation) {
            RenderMaterial particleLocation = owner.resolveTexture("particle");
            TextureAtlasSprite particle = spriteGetter.apply(particleLocation);

            ImmutableMap.Builder<String, IBakedModel> bakedParts = ImmutableMap.builder();
            for (Map.Entry<String, Submodel> part : PARTS.entrySet()) {
                Submodel submodel = part.getValue();
                if (!owner.getPartVisibility(submodel))
                    continue;
                bakedParts.put(part.getKey(), submodel.bakeModel(bakery, spriteGetter, modelTransform, modelLocation));
            }
            return new AnimatedBakedModel(owner.isShadedInGui(), owner.isSideLit(), owner.useSmoothLighting(), particle, bakedParts.build(), getJOINTS(), owner.getCombinedTransform(), overrides);
        }
    }

    private static class Submodel implements IModelGeometryPart {
        private final String name;
        private final BlockModel model;
        private final IModelTransform modelTransform;

        private Submodel(String name, BlockModel model, IModelTransform modelTransform) {
            this.name = name;
            this.model = model;
            this.modelTransform = modelTransform;
        }

        @Override
        public String name() {
            return name;
        }

        @Override
        public void addQuads(IModelConfiguration owner, IModelBuilder<?> modelBuilder, ModelBakery bakery, Function<RenderMaterial, TextureAtlasSprite> spriteGetter, IModelTransform modelTransform, ResourceLocation modelLocation) {
            throw new UnsupportedOperationException("Attempted to call adQuads on a Submodel instance. Please don't.");
        }

        public IBakedModel bakeModel(ModelBakery bakery, Function<RenderMaterial, TextureAtlasSprite> spriteGetter, IModelTransform modelTransform, ResourceLocation modelLocation) {
            return model.bake(bakery, spriteGetter, new ModelTransformComposition(this.modelTransform, modelTransform,
                    this.modelTransform.isUvLocked() || modelTransform.isUvLocked()), modelLocation);
        }

        @Override
        public Collection<RenderMaterial> getTextures(IModelConfiguration owner, Function<ResourceLocation, IUnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
            return model.getMaterials(modelGetter, missingTextureErrors);
        }
    }
}
