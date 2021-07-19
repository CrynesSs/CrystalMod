package com.crylol.morevillagers.EntityTest;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;

import javax.annotation.Nonnull;

public class TestEntityModel<T extends MobEntity> extends EntityModel<TestEntity> {

    private final ModelRenderer bb_main;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;

    public TestEntityModel() {
        texWidth = 16;
        texHeight = 16;

        bb_main = new ModelRenderer(this);
        bb_main.setPos(0.0F, 24.0F, 0.0F);
        bb_main.texOffs(0, 0).addBox(-2.0F, -9.0F, 6.0F, 4.0F, 9.0F, 2.0F, 0.0F, false);
        bb_main.texOffs(0, 0).addBox(-2.0F, -10.0F, -7.0F, 4.0F, 1.0F, 14.0F, 0.0F, false);
        bb_main.texOffs(0, 0).addBox(-2.0F, -19.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, 0.0F, 0.0F);
        bb_main.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
        cube_r1.texOffs(0, 0).addBox(-2.0F, -10.0F, -7.0F, 4.0F, 1.0F, 14.0F, 0.0F, false);
        cube_r1.texOffs(0, 0).addBox(-2.0F, -9.0F, 6.0F, 4.0F, 9.0F, 2.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.0F, 0.0F);
        bb_main.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 1.5708F, 0.0F);
        cube_r2.texOffs(0, 0).addBox(-2.0F, -9.0F, 6.0F, 4.0F, 9.0F, 2.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, 0.0F, 0.0F);
        bb_main.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 3.1416F, 0.0F);
        cube_r3.texOffs(0, 0).addBox(-2.0F, -9.0F, 6.0F, 4.0F, 9.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(@Nonnull TestEntity entity, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }


    @Override
    public void renderToBuffer(@Nonnull MatrixStack matrixStack,@Nonnull IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
