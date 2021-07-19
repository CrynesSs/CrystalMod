package com.crylol.morevillagers.TERRING;

import com.crylol.morevillagers.BakedModelTesting.AnimatedBakedModel;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public abstract class AnimTE extends TileEntity {
    public AnimTE(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    abstract AnimatedBakedModel getDefaultModel();

}
