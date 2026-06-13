package me.jddev0.epru.recipe;

import me.jddev0.epru.EnergizedPowerRUMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

public final class EPRURecipes {
    private EPRURecipes() {}

    public static final RecipeSerializer<PeatFarmlandCraftingRecipe>
            PEAT_FARMLAND_CRAFTING_RECIPE_SERIALIZER = createSerializer("peat_farmland_crafting",
            new SimpleCraftingRecipeSerializer<>(PeatFarmlandCraftingRecipe::new));
    public static final RecipeSerializer<SiltFarmlandCraftingRecipe>
            SILT_FARMLAND_CRAFTING_RECIPE_SERIALIZER = createSerializer("silt_farmland_crafting",
            new SimpleCraftingRecipeSerializer<>(SiltFarmlandCraftingRecipe::new));

    private static <T extends Recipe<?>> RecipeSerializer<T> createSerializer(String name, RecipeSerializer<T> instance) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ResourceLocation.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, name), instance);
    }
    private static <T extends Recipe<?>> RecipeType<T> createRecipeType(String name, RecipeType<T> instance) {
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, ResourceLocation.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, name), instance);
    }
    public static void register() {

    }
}
