package com.crylol.morevillagers.init;

import com.crylol.morevillagers.EntityTest.TestEntity;
import com.crylol.morevillagers.MoreVillagers;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MoreVillagers.MOD_ID);
    public static final RegistryObject<EntityType<TestEntity>> TEST_ENTITY_TYPE = ENTITY_TYPES.register("test",
            ()->EntityType.Builder.of(TestEntity::new, EntityClassification.MONSTER).sized(1f,1f).fireImmune().build(MoreVillagers.MOD_ID + "_test"));
}
