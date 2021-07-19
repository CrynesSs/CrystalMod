package com.example.GUI;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ExampleButton extends ImageButton {
    public ExampleButton(int p_i51134_1_, int p_i51134_2_, int p_i51134_3_, int p_i51134_4_, int p_i51134_5_, int p_i51134_6_, int p_i51134_7_, ResourceLocation p_i51134_8_, IPressable p_i51134_9_) {
        super(p_i51134_1_, p_i51134_2_, p_i51134_3_, p_i51134_4_, p_i51134_5_, p_i51134_6_, p_i51134_7_, p_i51134_8_, p_i51134_9_);
    }

    public ExampleButton(int p_i51135_1_, int p_i51135_2_, int p_i51135_3_, int p_i51135_4_, int p_i51135_5_, int p_i51135_6_, int p_i51135_7_, ResourceLocation p_i51135_8_, int p_i51135_9_, int p_i51135_10_, IPressable p_i51135_11_) {
        super(p_i51135_1_, p_i51135_2_, p_i51135_3_, p_i51135_4_, p_i51135_5_, p_i51135_6_, p_i51135_7_, p_i51135_8_, p_i51135_9_, p_i51135_10_, p_i51135_11_);
    }

    public ExampleButton(int p_i232261_1_, int p_i232261_2_, int p_i232261_3_, int p_i232261_4_, int p_i232261_5_, int p_i232261_6_, int p_i232261_7_, ResourceLocation p_i232261_8_, int p_i232261_9_, int p_i232261_10_, IPressable p_i232261_11_, ITextComponent p_i232261_12_) {
        super(p_i232261_1_, p_i232261_2_, p_i232261_3_, p_i232261_4_, p_i232261_5_, p_i232261_6_, p_i232261_7_, p_i232261_8_, p_i232261_9_, p_i232261_10_, p_i232261_11_, p_i232261_12_);
    }

    public ExampleButton(int p_i244513_1_, int p_i244513_2_, int p_i244513_3_, int p_i244513_4_, int p_i244513_5_, int p_i244513_6_, int p_i244513_7_, ResourceLocation p_i244513_8_, int p_i244513_9_, int p_i244513_10_, IPressable p_i244513_11_, ITooltip p_i244513_12_, ITextComponent p_i244513_13_) {
        super(p_i244513_1_, p_i244513_2_, p_i244513_3_, p_i244513_4_, p_i244513_5_, p_i244513_6_, p_i244513_7_, p_i244513_8_, p_i244513_9_, p_i244513_10_, p_i244513_11_, p_i244513_12_, p_i244513_13_);
    }

    @Override
    public void renderButton(MatrixStack stack, int p_230431_2_, int p_230431_3_, float p_230431_4_) {
        super.renderButton(stack, p_230431_2_, p_230431_3_, p_230431_4_);
    }

}
