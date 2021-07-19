package com.crylol.morevillagers.event;

import com.crylol.morevillagers.BakedModelTesting.AnimatedBakedModel;
import com.crylol.morevillagers.EntityTest.TestEntityRenderer;
import com.crylol.morevillagers.MoreVillagers;
import com.crylol.morevillagers.init.BlockInit;
import com.crylol.morevillagers.init.EntityTypeInit;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MoreVillagers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void setup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeInit.TEST_ENTITY_TYPE.get(), TestEntityRenderer::new);
        RenderTypeLookup.setRenderLayer(BlockInit.TEST.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void modelRegistry(ModelRegistryEvent event) {
        //ClientRegistry.bindTileEntityRenderer(TileEntityTypeInit.TEST_TE_TYPE.get(), TileEntityRendererAnimation::new);
        ModelLoaderRegistry.registerLoader(new ResourceLocation(MoreVillagers.MOD_ID, "animation"), AnimatedBakedModel.AnimatedModelLoader.INSTANCE);
    }

}
