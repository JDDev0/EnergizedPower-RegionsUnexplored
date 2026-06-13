package me.jddev0.epru.recipe;

import me.jddev0.epru.EnergizedPowerRUMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class EPRURecipes {
    private EPRURecipes() {}

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, EnergizedPowerRUMod.MODID);
    public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, EnergizedPowerRUMod.MODID);

    public static final Supplier<RecipeSerializer<PeatFarmlandCraftingRecipe>>
            PEAT_FARMLAND_CRAFTING_RECIPE_SERIALIZER = SERIALIZERS.register("peat_farmland_crafting",
            () -> new SimpleCraftingRecipeSerializer<>(PeatFarmlandCraftingRecipe::new));
    public static final Supplier<RecipeSerializer<SiltFarmlandCraftingRecipe>>
            SILT_FARMLAND_CRAFTING_RECIPE_SERIALIZER = SERIALIZERS.register("silt_farmland_crafting",
            () -> new SimpleCraftingRecipeSerializer<>(SiltFarmlandCraftingRecipe::new));

    public static void register(IEventBus modEventBus) {
        SERIALIZERS.register(modEventBus);
        TYPES.register(modEventBus);
    }
}
