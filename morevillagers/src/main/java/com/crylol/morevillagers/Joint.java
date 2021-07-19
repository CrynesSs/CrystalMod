package com.crylol.morevillagers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;

public class Joint {
    private final Vector3f LOCATION;
    private final JOINT_TYPE TYPE;
    private final Direction.Axis AXIS;

    private enum JOINT_TYPE {
        ROTATION, TRANSLATION, SCALE
    }

    public Joint(JsonObject json) {
        JsonArray arr = json.get("location").getAsJsonArray();
        LOCATION = new Vector3f(arr.get(0).getAsInt(), arr.get(1).getAsInt(), arr.get(2).getAsInt());
        switch (json.get("type").getAsString()) {
            case "rotation":
                TYPE = JOINT_TYPE.ROTATION;
                break;
            case "translation":
                TYPE = JOINT_TYPE.TRANSLATION;
                break;
            case "scale":
                TYPE = JOINT_TYPE.SCALE;
                break;
            default:
                TYPE = null;
        }
        AXIS = Direction.Axis.byName(json.get("axis").getAsString());
    }
}
