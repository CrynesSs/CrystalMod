package com.example.Recipes.AlloySmelting;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

//Same
public class AlloySmeltingSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<AlloySmeltingRecipe> {

    @Override
    @Nonnull
    public AlloySmeltingRecipe fromJson(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
        System.out.println("Reading Alloysmelting");
        JsonObject inputs = JSONUtils.getAsJsonObject(json, "input");
        ItemStack output = CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(json, "output"), true);
        Ingredient input1 = Ingredient.fromJson(inputs.getAsJsonObject("0"));
        Ingredient input2 = Ingredient.fromJson(inputs.getAsJsonObject("1"));
        ItemStack input1stack = CraftingHelper.getItemStack(inputs.getAsJsonObject("0"), true);
        ItemStack input2stack = CraftingHelper.getItemStack(inputs.getAsJsonObject("1"), true);
        Integer smelttime = JSONUtils.getAsInt(json, "smelttime");
        return new AlloySmeltingRecipe(recipeId, input1, input2, output, smelttime, input1stack, input2stack);
    }

    @Nullable
    @Override
    public AlloySmeltingRecipe fromNetwork(@Nonnull ResourceLocation recipeId, PacketBuffer buffer) {
        System.out.println("Reading Alloysmelting");
        ItemStack output = buffer.readItem();
        Ingredient input1 = Ingredient.fromNetwork(buffer);
        Ingredient input2 = Ingredient.fromNetwork(buffer);
        ItemStack input1stack = buffer.readItem();
        ItemStack input2stack = buffer.readItem();
        Integer smelttime = buffer.readInt();
        return new AlloySmeltingRecipe(recipeId, input1, input2, output, smelttime, input1stack, input2stack);
    }

    @Override
    public void toNetwork(PacketBuffer buffer, AlloySmeltingRecipe recipe) {
        Ingredient input1 = recipe.getIngredients().get(0);
        Ingredient input2 = recipe.getIngredients().get(1);
        ItemStack input1s = recipe.getInput1Stack();
        ItemStack input2s = recipe.getInput2Stack();

        buffer.writeItemStack(recipe.getResultItem(), false);
        input1.toNetwork(buffer);
        input2.toNetwork(buffer);
        buffer.writeItemStack(input1s, false);
        buffer.writeItemStack(input2s, false);
        buffer.writeInt(recipe.getSmeltTime());
    }
}
