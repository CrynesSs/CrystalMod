package com.crylol.morevillagers.BakedModelTesting;

import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.util.math.vector.Vector3f;

public class AnimationInstance {
    private final int ANIMATION_TIME;
    private final ANIM_MOVEMENT MOVEMENT;
    private final AnimatedBakedModel OWNER;
    private final IBakedModel MODELPART;
    private final Vector3f EFFECT;
    private final boolean LOOP;
    private boolean isPlaying;
    private boolean canPlay;

    public enum ANIM_MOVEMENT {
        ROTATION, TRANSLATION, SCALING
    }

    public AnimationInstance(int animation_time, ANIM_MOVEMENT movement, Vector3f effect, AnimatedBakedModel owner, IBakedModel animatedPart, boolean loop) {
        ANIMATION_TIME = animation_time;
        MOVEMENT = movement;
        OWNER = owner;
        LOOP = loop;
        MODELPART = animatedPart;
        EFFECT = effect;
    }

    private void start() {

    }

    private void startingPos() {

    }

    private void pause() {

    }
}
