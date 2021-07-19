package com.example.Recipes;

import com.example.Recipes.AlloySmelting.AlloySmeltingRecipe;
import com.example.Recipes.AlloySmelting.AlloySmeltingSerializer;
import com.example.examplemod.ExampleMod;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerInit {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ExampleMod.MOD_ID);
    public static final IRecipeSerializer<AlloySmeltingRecipe> ALLOY_SMELTING_RECIPE_SERIALIZER = new AlloySmeltingSerializer();
    public static final RegistryObject<IRecipeSerializer<?>> ALLOY_SMELTING_SERIALIZER = RECIPE_SERIALIZERS.register("alloysmelting",
            () -> ALLOY_SMELTING_RECIPE_SERIALIZER);

}
