package com.crylol.morevillagers.Util.Matrix;

import net.minecraft.util.math.vector.Matrix4f;

public class RotationMatrices {
    //Angle to rotate, Angle to EulerAngle : 2Pi
    public static Matrix4f makeRotMatrix_X(int xRot) {
        double eulerAngle = (xRot / 360f) * Math.PI * 2;
        return new Matrix4f(new float[]{
                1, 0, 0, 0,
                0, (float) Math.cos(eulerAngle), (float) -Math.sin(eulerAngle), 0,
                0, (float) Math.sin(eulerAngle), (float) Math.cos(eulerAngle), 0,
                0, 0, 0, 1
        });
    }

    public static Matrix4f makeRotMatrix_Y(int yRot) {
        double eulerAngle = (yRot / 360f) * Math.PI * 2;
        return new Matrix4f(new float[]{
                (float) Math.cos(eulerAngle), 0, (float) Math.sin(eulerAngle), 0,
                0, 1, 0, 0,
                (float) -Math.sin(eulerAngle), 0, (float) Math.cos(eulerAngle), 0,
                0, 0, 0, 1
        });
    }

    public static Matrix4f makeRotMatrix_Z(int zRot) {
        double eulerAngle = (zRot / 360f) * Math.PI * 2;
        return new Matrix4f(new float[]{
                (float) Math.cos(eulerAngle), -(float) Math.sin(eulerAngle), 0, 0,
                (float) Math.sin(eulerAngle), (float) Math.cos(eulerAngle), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        });
    }

    public static Matrix4f rotateMatrix(Matrix4f matrix4f, int xRot, int yRot, int zRot) {
        matrix4f.multiply(makeRotMatrix_X(xRot));
        matrix4f.multiply(makeRotMatrix_Y(yRot));
        matrix4f.multiply(makeRotMatrix_Z(zRot));
        return matrix4f;
    }
}
