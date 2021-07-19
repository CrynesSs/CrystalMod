package com.crylol.Mixins.mixin;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.BlockModel;
import net.minecraft.client.renderer.model.IUnbakedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.animation.ModelBlockAnimation;
import net.minecraftforge.common.model.animation.Clips;
import net.minecraftforge.common.model.animation.IClip;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Clips.class)
public class MixinClips {
    @Inject(at = @At("HEAD"), method = "getModelClipNode(Lnet/minecraft/util/ResourceLocation;Ljava/lang/String;)Lnet/minecraftforge/common/model/animation/IClip;", cancellable = true,remap = false)
    private static void getModelClipNode(ResourceLocation modelLocation, String clipName, CallbackInfoReturnable<IClip> cir) {
        IUnbakedModel model = ModelLoader.defaultModelGetter().apply(modelLocation);
        if(model instanceof BlockModel){
            ResourceLocation armatureLocation = new ResourceLocation(modelLocation.getNamespace(), "armatures/" + modelLocation.getPath() + ".json");
            ModelBlockAnimation animation = ModelBlockAnimation.loadVanillaAnimation(Minecraft.getInstance().getResourceManager(), armatureLocation);
            Optional<? extends IClip> clip = Optional.of(animation.getClips().get(clipName));
            clip.ifPresent(iClip -> cir.setReturnValue(new Clips.ModelClip(iClip, modelLocation, clipName)));
        }
        // FIXME: missing clip?
        cir.setReturnValue(new Clips.ModelClip(Clips.IdentityClip.INSTANCE, modelLocation, clipName));
    }

}
