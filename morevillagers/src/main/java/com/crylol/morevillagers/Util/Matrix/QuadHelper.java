package com.crylol.morevillagers.Util.Matrix;

import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.TransformationMatrix;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.model.QuadTransformer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuadHelper {
    public static BakedQuad scaleQuad(BakedQuad quad, float scaleX, float scaleY, float scaleZ) {
        QuadTransformer transformer = new QuadTransformer(new TransformationMatrix(Matrix4f.createScaleMatrix(scaleX, scaleY, scaleZ)));
        return transformer.processOne(quad);
    }

    public static List<BakedQuad> scaleModel(List<BakedQuad> quads, float scaleX, float scaleY, float scaleZ) {
        QuadTransformer transformer = new QuadTransformer(new TransformationMatrix(Matrix4f.createScaleMatrix(scaleX, scaleY, scaleZ)));
        return transformer.processMany(quads);
    }

    public static BakedQuad rotateQuad(BakedQuad quads, int rotX, int rotY, int rotZ) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.setIdentity();
        QuadTransformer transformer = new QuadTransformer(new TransformationMatrix(RotationMatrices.rotateMatrix(matrix4f, rotX, rotY, rotZ)));
        return transformer.processOne(quads);
    }

    public static List<BakedQuad> rotateModel(List<BakedQuad> quads, int rotX, int rotY, int rotZ) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.setIdentity();
        QuadTransformer transformer = new QuadTransformer(new TransformationMatrix(RotationMatrices.rotateMatrix(matrix4f, rotX, rotY, rotZ)));
        return transformer.processMany(quads);
    }

    public static BakedQuad translateQuad(BakedQuad quad, Vector3f translation) {
        int[] vertexData = quad.getVertices();
        double[] vertexFloats = Arrays.stream(vertexData).mapToDouble(Float::intBitsToFloat).toArray();
        for (int i = 0; i < 4; i++) {
            vertexFloats[i * 8] += translation.x();
            vertexFloats[i * 8 + 1] += translation.y();
            vertexFloats[i * 8 + 2] += translation.z();
        }
        vertexData = Arrays.stream(vertexFloats).distinct().mapToInt(k -> Float.floatToIntBits((float) k)).toArray();
        return new BakedQuad(vertexData, quad.getTintIndex(), quad.getDirection(), quad.getSprite(), quad.isShade());
    }
    public static List<BakedQuad> translateModel(List<BakedQuad> quads, Vector3f translation) {
        return quads.parallelStream().map(k -> translateQuad(k, translation)).collect(Collectors.toList());
    }
}
