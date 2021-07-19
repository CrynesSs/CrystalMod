package com.crylol.morevillagers.EntityTest;

import com.crylol.morevillagers.MoreVillagers;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class TestEntityRenderer extends MobRenderer<TestEntity,TestEntityModel<TestEntity>> {
    public static final ResourceLocation TEXTURE_LOC = new ResourceLocation(MoreVillagers.MOD_ID,"textures/entity/test/test_texture.png");
    public TestEntityRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new TestEntityModel<>(), 0.7f);
    }

    @Override
    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull TestEntity entity) {
        return TEXTURE_LOC;
    }
}
