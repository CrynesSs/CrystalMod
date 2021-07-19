package com.example.Recipes.example;

import com.example.Recipes.AlloySmelting.AlloySmeltingRecipe;
import com.google.gson.JsonObject;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class ExampleRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<  ExampleRecipe> {

    @Override
    public ExampleRecipe fromJson(ResourceLocation recipeID, JsonObject json) {

        return null;
    }

    @Nullable
    @Override
    public ExampleRecipe fromNetwork(ResourceLocation p_199426_1_, PacketBuffer p_199426_2_) {
        return null;
    }

    @Override
    public void toNetwork(PacketBuffer p_199427_1_, ExampleRecipe p_199427_2_) {

    }
}
