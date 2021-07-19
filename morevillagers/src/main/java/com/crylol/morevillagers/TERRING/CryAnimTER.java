package com.crylol.morevillagers.TERRING;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.crylol.morevillagers.BakedModelTesting.AnimatedBakedModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Random;

public class CryAnimTER extends TileEntityRenderer<AnimTE> {

    public CryAnimTER(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);

    }

    @Override
    public void render(AnimTE tile, float p_225616_2_, @Nonnull MatrixStack stack, IRenderTypeBuffer buffer, int light, int other_light) {
        AnimatedBakedModel defaultModel = tile.getDefaultModel();
        Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(
                Objects.requireNonNull(tile.getLevel()),
                defaultModel.animate(),
                tile.getBlockState(),
                tile.getBlockPos(),
                stack,
                buffer.getBuffer(Atlases.solidBlockSheet()), false, new Random(), 42, light, tile.getModelData());
    }
}
