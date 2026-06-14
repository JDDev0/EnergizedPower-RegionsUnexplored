package me.jddev0.epru.datagen;

import me.jddev0.ep.soil.EPSoilTypeTags;
import me.jddev0.ep.soil.EPSoilTypes;
import me.jddev0.ep.soil.SoilType;
import me.jddev0.epru.EnergizedPowerRUMod;
import me.jddev0.ep.recipe.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.regions_unexplored.Constants;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.item.RuItems;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final String REGIONS_UNEXPLORED_MOD_ID = Constants.MOD_ID;
    private static final String PATH_PREFIX = "compat/" + REGIONS_UNEXPLORED_MOD_ID + "/";

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    public void buildRecipes(RecipeOutput output) {
        buildCraftingRecipes(output);
        buildCrusherRecipes(output);
        buildSawmillRecipes(output);
        buildPlantGrowthChamberRecipes(output);
        buildPlantGrowthChamberSoilRecipes(output);
    }
    private void buildCustomCraftingRecipes(RecipeOutput output) {
        addCustomCraftingRecipe(output,
                new FarmlandCraftingRecipe(ingredientOf(RuBlocks.PEAT_DIRT), new ItemStack(RuBlocks.PEAT_FARMLAND.get())),
                "peat_farmland");
        addCustomCraftingRecipe(output,
                new FarmlandCraftingRecipe(ingredientOf(RuBlocks.SILT_DIRT), new ItemStack(RuBlocks.SILT_FARMLAND.get())),
                "silt_farmland");
    }

    private void buildCraftingRecipes(RecipeOutput output) {
        buildCustomCraftingRecipes(output);
    }

    private void buildCrusherRecipes(RecipeOutput output) {
        addCrusherRecipe(output, Ingredient.of(RuBlocks.MOSSY_STONE.get()), new ItemStack(Items.MOSSY_COBBLESTONE),
                "mossy_stone");

        addCrusherRecipe(output, Ingredient.of(RuBlocks.CHALK_BRICKS.get(), RuBlocks.POLISHED_CHALK.get(),
                        RuBlocks.CHALK_PILLAR.get()), new ItemStack(RuBlocks.CHALK.get()),
                "chalk_variants");
    }

    private void buildSawmillRecipes(RecipeOutput output) {
        addSawmillRecipe(output, Ingredient.of(RuTags.BRANCHES_ITEM), new ItemStack(Items.STICK, 6), 1,
                getItemName(Items.STICK), "_branches");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.BAOBAB_PLANKS.get()),
                Ingredient.of(RuTags.BAOBAB_LOGS_ITEM), Ingredient.of(RuBlocks.BAOBAB_FENCE.get()),
                Ingredient.of(RuBlocks.BAOBAB_FENCE_GATE.get()), Ingredient.of(RuBlocks.BAOBAB_DOOR.get()),
                Ingredient.of(RuBlocks.BAOBAB_TRAPDOOR.get()), Ingredient.of(RuBlocks.BAOBAB_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.BAOBAB_SIGN.get()), Ingredient.of(RuItems.BAOBAB_BOAT.get()),
                Ingredient.of(RuItems.BAOBAB_CHEST_BOAT.get()),
                false, "baobab");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.BLACKWOOD_PLANKS.get()),
                Ingredient.of(RuTags.BLACKWOOD_LOGS_ITEM), Ingredient.of(RuBlocks.BLACKWOOD_FENCE.get()),
                Ingredient.of(RuBlocks.BLACKWOOD_FENCE_GATE.get()), Ingredient.of(RuBlocks.BLACKWOOD_DOOR.get()),
                Ingredient.of(RuBlocks.BLACKWOOD_TRAPDOOR.get()), Ingredient.of(RuBlocks.BLACKWOOD_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.BLACKWOOD_SIGN.get()), Ingredient.of(RuItems.BLACKWOOD_BOAT.get()),
                Ingredient.of(RuItems.BLACKWOOD_CHEST_BOAT.get()),
                false, "blackwood");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.CYPRESS_PLANKS.get()),
                Ingredient.of(RuTags.CYPRESS_LOGS_ITEM), Ingredient.of(RuBlocks.CYPRESS_FENCE.get()),
                Ingredient.of(RuBlocks.CYPRESS_FENCE_GATE.get()), Ingredient.of(RuBlocks.CYPRESS_DOOR.get()),
                Ingredient.of(RuBlocks.CYPRESS_TRAPDOOR.get()), Ingredient.of(RuBlocks.CYPRESS_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.CYPRESS_SIGN.get()), Ingredient.of(RuItems.CYPRESS_BOAT.get()),
                Ingredient.of(RuItems.CYPRESS_CHEST_BOAT.get()),
                false, "cypress");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.DEAD_PLANKS.get()),
                Ingredient.of(RuTags.DEAD_LOGS_ITEM), Ingredient.of(RuBlocks.DEAD_FENCE.get()),
                Ingredient.of(RuBlocks.DEAD_FENCE_GATE.get()), Ingredient.of(RuBlocks.DEAD_DOOR.get()),
                Ingredient.of(RuBlocks.DEAD_TRAPDOOR.get()), Ingredient.of(RuBlocks.DEAD_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.DEAD_SIGN.get()), Ingredient.of(RuItems.DEAD_BOAT.get()),
                Ingredient.of(RuItems.DEAD_CHEST_BOAT.get()),
                false, "dead");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.EUCALYPTUS_PLANKS.get()),
                Ingredient.of(RuTags.EUCALYPTUS_LOGS_ITEM), Ingredient.of(RuBlocks.EUCALYPTUS_FENCE.get()),
                Ingredient.of(RuBlocks.EUCALYPTUS_FENCE_GATE.get()), Ingredient.of(RuBlocks.EUCALYPTUS_DOOR.get()),
                Ingredient.of(RuBlocks.EUCALYPTUS_TRAPDOOR.get()), Ingredient.of(RuBlocks.EUCALYPTUS_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.EUCALYPTUS_SIGN.get()), Ingredient.of(RuItems.EUCALYPTUS_BOAT.get()),
                Ingredient.of(RuItems.EUCALYPTUS_CHEST_BOAT.get()),
                false, "eucalyptus");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.JOSHUA_PLANKS.get()),
                Ingredient.of(RuTags.JOSHUA_LOGS_ITEM), Ingredient.of(RuBlocks.JOSHUA_FENCE.get()),
                Ingredient.of(RuBlocks.JOSHUA_FENCE_GATE.get()), Ingredient.of(RuBlocks.JOSHUA_DOOR.get()),
                Ingredient.of(RuBlocks.JOSHUA_TRAPDOOR.get()), Ingredient.of(RuBlocks.JOSHUA_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.JOSHUA_SIGN.get()), Ingredient.of(RuItems.JOSHUA_BOAT.get()),
                Ingredient.of(RuItems.JOSHUA_CHEST_BOAT.get()),
                false, "joshua");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.KAPOK_PLANKS.get()),
                Ingredient.of(RuTags.KAPOK_LOGS_ITEM), Ingredient.of(RuBlocks.KAPOK_FENCE.get()),
                Ingredient.of(RuBlocks.KAPOK_FENCE_GATE.get()), Ingredient.of(RuBlocks.KAPOK_DOOR.get()),
                Ingredient.of(RuBlocks.KAPOK_TRAPDOOR.get()), Ingredient.of(RuBlocks.KAPOK_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.KAPOK_SIGN.get()), Ingredient.of(RuItems.KAPOK_BOAT.get()),
                Ingredient.of(RuItems.KAPOK_CHEST_BOAT.get()),
                false, "kapok");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.LARCH_PLANKS.get()),
                Ingredient.of(RuTags.LARCH_LOGS_ITEM), Ingredient.of(RuBlocks.LARCH_FENCE.get()),
                Ingredient.of(RuBlocks.LARCH_FENCE_GATE.get()), Ingredient.of(RuBlocks.LARCH_DOOR.get()),
                Ingredient.of(RuBlocks.LARCH_TRAPDOOR.get()), Ingredient.of(RuBlocks.LARCH_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.LARCH_SIGN.get()), Ingredient.of(RuItems.LARCH_BOAT.get()),
                Ingredient.of(RuItems.LARCH_CHEST_BOAT.get()),
                false, "larch");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.MAGNOLIA_PLANKS.get()),
                Ingredient.of(RuTags.MAGNOLIA_LOGS_ITEM), Ingredient.of(RuBlocks.MAGNOLIA_FENCE.get()),
                Ingredient.of(RuBlocks.MAGNOLIA_FENCE_GATE.get()), Ingredient.of(RuBlocks.MAGNOLIA_DOOR.get()),
                Ingredient.of(RuBlocks.MAGNOLIA_TRAPDOOR.get()), Ingredient.of(RuBlocks.MAGNOLIA_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.MAGNOLIA_SIGN.get()), Ingredient.of(RuItems.MAGNOLIA_BOAT.get()),
                Ingredient.of(RuItems.MAGNOLIA_CHEST_BOAT.get()),
                false, "magnolia");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.MAPLE_PLANKS.get()),
                Ingredient.of(RuTags.MAPLE_LOGS_ITEM), Ingredient.of(RuBlocks.MAPLE_FENCE.get()),
                Ingredient.of(RuBlocks.MAPLE_FENCE_GATE.get()), Ingredient.of(RuBlocks.MAPLE_DOOR.get()),
                Ingredient.of(RuBlocks.MAPLE_TRAPDOOR.get()), Ingredient.of(RuBlocks.MAPLE_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.MAPLE_SIGN.get()), Ingredient.of(RuItems.MAPLE_BOAT.get()),
                Ingredient.of(RuItems.MAPLE_CHEST_BOAT.get()),
                false, "maple");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.MAUVE_PLANKS.get()),
                Ingredient.of(RuTags.MAUVE_LOGS_ITEM), Ingredient.of(RuBlocks.MAUVE_FENCE.get()),
                Ingredient.of(RuBlocks.MAUVE_FENCE_GATE.get()), Ingredient.of(RuBlocks.MAUVE_DOOR.get()),
                Ingredient.of(RuBlocks.MAUVE_TRAPDOOR.get()), Ingredient.of(RuBlocks.MAUVE_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.MAUVE_SIGN.get()), Ingredient.of(RuItems.MAUVE_BOAT.get()),
                Ingredient.of(RuItems.MAUVE_CHEST_BOAT.get()),
                false, "mauve");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.PALM_PLANKS.get()),
                Ingredient.of(RuTags.PALM_LOGS_ITEM), Ingredient.of(RuBlocks.PALM_FENCE.get()),
                Ingredient.of(RuBlocks.PALM_FENCE_GATE.get()), Ingredient.of(RuBlocks.PALM_DOOR.get()),
                Ingredient.of(RuBlocks.PALM_TRAPDOOR.get()), Ingredient.of(RuBlocks.PALM_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.PALM_SIGN.get()), Ingredient.of(RuItems.PALM_BOAT.get()),
                Ingredient.of(RuItems.PALM_CHEST_BOAT.get()),
                false, "palm");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.PINE_PLANKS.get()),
                Ingredient.of(RuTags.PINE_LOGS_ITEM), Ingredient.of(RuBlocks.PINE_FENCE.get()),
                Ingredient.of(RuBlocks.PINE_FENCE_GATE.get()), Ingredient.of(RuBlocks.PINE_DOOR.get()),
                Ingredient.of(RuBlocks.PINE_TRAPDOOR.get()), Ingredient.of(RuBlocks.PINE_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.PINE_SIGN.get()), Ingredient.of(RuItems.PINE_BOAT.get()),
                Ingredient.of(RuItems.PINE_CHEST_BOAT.get()),
                false, "pine");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.REDWOOD_PLANKS.get()),
                Ingredient.of(RuTags.REDWOOD_LOGS_ITEM), Ingredient.of(RuBlocks.REDWOOD_FENCE.get()),
                Ingredient.of(RuBlocks.REDWOOD_FENCE_GATE.get()), Ingredient.of(RuBlocks.REDWOOD_DOOR.get()),
                Ingredient.of(RuBlocks.REDWOOD_TRAPDOOR.get()), Ingredient.of(RuBlocks.REDWOOD_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.REDWOOD_SIGN.get()), Ingredient.of(RuItems.REDWOOD_BOAT.get()),
                Ingredient.of(RuItems.REDWOOD_CHEST_BOAT.get()),
                false, "redwood");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.SOCOTRA_PLANKS.get()),
                Ingredient.of(RuTags.SOCOTRA_LOGS_ITEM), Ingredient.of(RuBlocks.SOCOTRA_FENCE.get()),
                Ingredient.of(RuBlocks.SOCOTRA_FENCE_GATE.get()), Ingredient.of(RuBlocks.SOCOTRA_DOOR.get()),
                Ingredient.of(RuBlocks.SOCOTRA_TRAPDOOR.get()), Ingredient.of(RuBlocks.SOCOTRA_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.SOCOTRA_SIGN.get()), Ingredient.of(RuItems.SOCOTRA_BOAT.get()),
                Ingredient.of(RuItems.SOCOTRA_CHEST_BOAT.get()),
                false, "socotra");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.WILLOW_PLANKS.get()),
                Ingredient.of(RuTags.WILLOW_LOGS_ITEM), Ingredient.of(RuBlocks.WILLOW_FENCE.get()),
                Ingredient.of(RuBlocks.WILLOW_FENCE_GATE.get()), Ingredient.of(RuBlocks.WILLOW_DOOR.get()),
                Ingredient.of(RuBlocks.WILLOW_TRAPDOOR.get()), Ingredient.of(RuBlocks.WILLOW_PRESSURE_PLATE.get()),
                Ingredient.of(RuBlocks.WILLOW_SIGN.get()), Ingredient.of(RuItems.WILLOW_BOAT.get()),
                Ingredient.of(RuItems.WILLOW_CHEST_BOAT.get()),
                false, "willow");

        addSawmillRecipe(output, Ingredient.of(RuTags.BLUE_BIOSHROOM_LOGS_ITEM),
                new ItemStack(RuBlocks.BLUE_BIOSHROOM_PLANKS.get(), 6),
                1, "blue_bioshroom_planks", "blue_bioshroom_stems");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.BLUE_BIOSHROOM_PLANKS.get()),
                Ingredient.of(RuBlocks.BLUE_BIOSHROOM_FENCE.get()), Ingredient.of(RuBlocks.BLUE_BIOSHROOM_FENCE_GATE.get()),
                Ingredient.of(RuBlocks.BLUE_BIOSHROOM_DOOR.get()), Ingredient.of(RuBlocks.BLUE_BIOSHROOM_TRAPDOOR.get()),
                Ingredient.of(RuBlocks.BLUE_BIOSHROOM_PRESSURE_PLATE.get()), Ingredient.of(RuBlocks.BLUE_BIOSHROOM_SIGN.get()),
                "blue_bioshroom");

        addSawmillRecipe(output, Ingredient.of(RuTags.GREEN_BIOSHROOM_LOGS_ITEM),
                new ItemStack(RuBlocks.GREEN_BIOSHROOM_PLANKS.get(), 6),
                1, "green_bioshroom_planks", "green_bioshroom_stems");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.GREEN_BIOSHROOM_PLANKS.get()),
                Ingredient.of(RuBlocks.GREEN_BIOSHROOM_FENCE.get()), Ingredient.of(RuBlocks.GREEN_BIOSHROOM_FENCE_GATE.get()),
                Ingredient.of(RuBlocks.GREEN_BIOSHROOM_DOOR.get()), Ingredient.of(RuBlocks.GREEN_BIOSHROOM_TRAPDOOR.get()),
                Ingredient.of(RuBlocks.GREEN_BIOSHROOM_PRESSURE_PLATE.get()), Ingredient.of(RuBlocks.GREEN_BIOSHROOM_SIGN.get()),
                "green_bioshroom");

        addSawmillRecipe(output, Ingredient.of(RuTags.PINK_BIOSHROOM_LOGS_ITEM),
                new ItemStack(RuBlocks.PINK_BIOSHROOM_PLANKS.get(), 6),
                1, "pink_bioshroom_planks", "pink_bioshroom_stems");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.PINK_BIOSHROOM_PLANKS.get()),
                Ingredient.of(RuBlocks.PINK_BIOSHROOM_FENCE.get()), Ingredient.of(RuBlocks.PINK_BIOSHROOM_FENCE_GATE.get()),
                Ingredient.of(RuBlocks.PINK_BIOSHROOM_DOOR.get()), Ingredient.of(RuBlocks.PINK_BIOSHROOM_TRAPDOOR.get()),
                Ingredient.of(RuBlocks.PINK_BIOSHROOM_PRESSURE_PLATE.get()), Ingredient.of(RuBlocks.PINK_BIOSHROOM_SIGN.get()),
                "pink_bioshroom");

        addSawmillRecipe(output, Ingredient.of(RuTags.YELLOW_BIOSHROOM_LOGS_ITEM),
                new ItemStack(RuBlocks.YELLOW_BIOSHROOM_PLANKS.get(), 6),
                1, "yellow_bioshroom_planks", "yellow_bioshroom_stems");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.YELLOW_BIOSHROOM_PLANKS.get()),
                Ingredient.of(RuBlocks.YELLOW_BIOSHROOM_FENCE.get()), Ingredient.of(RuBlocks.YELLOW_BIOSHROOM_FENCE_GATE.get()),
                Ingredient.of(RuBlocks.YELLOW_BIOSHROOM_DOOR.get()), Ingredient.of(RuBlocks.YELLOW_BIOSHROOM_TRAPDOOR.get()),
                Ingredient.of(RuBlocks.YELLOW_BIOSHROOM_PRESSURE_PLATE.get()), Ingredient.of(RuBlocks.YELLOW_BIOSHROOM_SIGN.get()),
                "yellow_bioshroom");

        addSawmillRecipe(output, Ingredient.of(RuTags.BRIMWOOD_LOGS_ITEM),
                new ItemStack(RuBlocks.BRIMWOOD_PLANKS.get(), 6),
                1, "brimwood_planks", "brimwood_logs");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.BRIMWOOD_PLANKS.get()),
                Ingredient.of(RuBlocks.BRIMWOOD_FENCE.get()), Ingredient.of(RuBlocks.BRIMWOOD_FENCE_GATE.get()),
                Ingredient.of(RuBlocks.BRIMWOOD_DOOR.get()), Ingredient.of(RuBlocks.BRIMWOOD_TRAPDOOR.get()),
                Ingredient.of(RuBlocks.BRIMWOOD_PRESSURE_PLATE.get()), Ingredient.of(RuBlocks.BRIMWOOD_SIGN.get()),
                "brimwood");

        addSawmillRecipe(output, Ingredient.of(RuTags.COBALT_LOGS_ITEM),
                new ItemStack(RuBlocks.COBALT_PLANKS.get(), 6),
                1, "cobalt_planks", "cobalt_logs");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.COBALT_PLANKS.get()),
                Ingredient.of(RuBlocks.COBALT_FENCE.get()), Ingredient.of(RuBlocks.COBALT_FENCE_GATE.get()),
                Ingredient.of(RuBlocks.COBALT_DOOR.get()), Ingredient.of(RuBlocks.COBALT_TRAPDOOR.get()),
                Ingredient.of(RuBlocks.COBALT_PRESSURE_PLATE.get()), Ingredient.of(RuBlocks.COBALT_SIGN.get()),
                "cobalt");

        addSawmillRecipe(output, Ingredient.of(RuBlocks.ALPHA_LOG.get()),
                new ItemStack(RuBlocks.ALPHA_PLANKS.get()).copyWithCount(6), 1,
                getItemName(RuBlocks.ALPHA_PLANKS.get().asItem()), "alpha_logs");
    }

    private void buildPlantGrowthChamberRecipes(RecipeOutput output) {
        addBasicFlowerGrowingRecipe(output, RuBlocks.ASTER.get(), "aster");
        addBasicFlowerGrowingRecipe(output, RuBlocks.BLEEDING_HEART.get(), "beleeding_heart");
        addBasicFlowerGrowingRecipe(output, RuBlocks.DAISY.get(), "daisy");
        addBasicFlowerGrowingRecipe(output, RuBlocks.DORCEL.get(), "dorcel");
        addBasicFlowerGrowingRecipe(output, RuBlocks.FELICIA_DAISY.get(), "felicia_daisy");
        addBasicFlowerGrowingRecipe(output, RuBlocks.FIREWEED.get(), "fireweed");
        addBasicFlowerGrowingRecipe(output, RuBlocks.GLISTERING_BLOOM.get(), "glistering_bloom");
        addBasicFlowerGrowingRecipe(output, RuBlocks.HIBISCUS.get(), "hibiscus");
        addBasicFlowerGrowingRecipe(output, RuBlocks.HYSSOP.get(), "hyssop");
        addBasicFlowerGrowingRecipe(output, RuBlocks.MALLOW.get(), "mallow");
        addBasicFlowerGrowingRecipe(output, RuBlocks.POPPY_BUSH.get(), "poppy_bush");
        addBasicFlowerGrowingRecipe(output, RuBlocks.SALMON_POPPY_BUSH.get(), "salmon_poppy_bush");
        addBasicFlowerGrowingRecipe(output, RuBlocks.TSUBAKI.get(), "tsubaki");
        addBasicFlowerGrowingRecipe(output, RuBlocks.WARATAH.get(), "waratah");
        addBasicFlowerGrowingRecipe(output, RuBlocks.WHITE_TRILLIUM.get(), "white_trillium");
        addBasicFlowerGrowingRecipe(output, RuBlocks.WILTING_TRILLIUM.get(), "wilting_trillium");
        addBasicFlowerGrowingRecipe(output, RuBlocks.BLUE_LUPINE.get(), "blue_lupine");
        addBasicFlowerGrowingRecipe(output, RuBlocks.PINK_LUPINE.get(), "pink_lupine");
        addBasicFlowerGrowingRecipe(output, RuBlocks.PURPLE_LUPINE.get(), "purple_lupine");
        addBasicFlowerGrowingRecipe(output, RuBlocks.RED_LUPINE.get(), "red_lupine");
        addBasicFlowerGrowingRecipe(output, RuBlocks.YELLOW_LUPINE.get(), "yellow_lupine");
        addBasicFlowerGrowingRecipe(output, RuBlocks.COBALT_EARLIGHT.get(), "cobalt_earlight");
        addBasicFlowerGrowingRecipe(output, RuBlocks.WHITE_SNOWBELLE.get(), "white_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.LIGHT_GRAY_SNOWBELLE.get(), "light_gray_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.GRAY_SNOWBELLE.get(), "gray_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.RED_SNOWBELLE.get(), "red_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.ORANGE_SNOWBELLE.get(), "orange_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.YELLOW_SNOWBELLE.get(), "yellow_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.LIME_SNOWBELLE.get(), "lime_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.GREEN_SNOWBELLE.get(), "green_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.CYAN_SNOWBELLE.get(), "cyan_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.LIGHT_BLUE_SNOWBELLE.get(), "light_blue_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.BLUE_SNOWBELLE.get(), "blue_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.PURPLE_SNOWBELLE.get(), "purple_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.MAGENTA_SNOWBELLE.get(), "magenta_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.PINK_SNOWBELLE.get(), "pink_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.BROWN_SNOWBELLE.get(), "brown_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.BLACK_SNOWBELLE.get(), "black_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.CAVE_HYSSOP.get(), "cave_hyssop");

        addBasicFlowerGrowingRecipe(output, RuBlocks.ALPHA_ROSE.get(), "alpha_rose");
        addBasicFlowerGrowingRecipe(output, RuBlocks.ALPHA_DANDELION.get(), "alpha_dandelion");

        addBasicFlowerGrowingRecipe(output, RuBlocks.BARLEY.get(), "barley");
        addBasicFlowerGrowingRecipe(output, RuBlocks.CATTAIL.get(), "cattail");
        addBasicFlowerGrowingRecipe(output, RuBlocks.DAY_LILY.get(), "day_lily");
        addBasicFlowerGrowingRecipe(output, RuBlocks.MEADOW_SAGE.get(), "meadow_sage");
        addBasicFlowerGrowingRecipe(output, RuBlocks.TASSEL.get(), "tassel");
        addBasicFlowerGrowingRecipe(output, RuBlocks.GLISTER_BULB.get(), "glister_bulb");
        addBasicFlowerGrowingRecipe(output, RuBlocks.GLISTER_SPIRE.get(), "glister_spire");
        addBasicFlowerGrowingRecipe(output, RuBlocks.MYCOTOXIC_DAISY.get(), "mycotoxic_daisy");
        addBasicFlowerGrowingRecipe(output, RuBlocks.TALL_COBALT_EARLIGHT.get(), "tall_cobalt_earlight");

        addPlantGrowthChamberRecipe(output, Ingredient.of(RuBlocks.CLOVER.get()), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.CLOVER.get()), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "clover", "clover");

        addPlantGrowthChamberRecipe(output, Ingredient.of(RuBlocks.ORANGE_CONEFLOWER.get()), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.ORANGE_CONEFLOWER.get()), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "orange_coneflower", "orange_coneflower");

        addPlantGrowthChamberRecipe(output, Ingredient.of(RuBlocks.PURPLE_CONEFLOWER.get()), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.PURPLE_CONEFLOWER.get()), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "purple_coneflower", "pruple_coneflower");

        addPlantGrowthChamberRecipe(output, Ingredient.of(RuBlocks.HYACINTH_FLOWERS.get()), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.HYACINTH_FLOWERS.get()), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000,  "hyacinth_flowers", "hyacinth_flowers");

        addPlantGrowthChamberRecipe(output, Ingredient.of(RuBlocks.BLUE_MAGNOLIA_FLOWERS.get()), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.BLUE_MAGNOLIA_FLOWERS.get()), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000,  "blue_magnolia_flowers", "blue_magnolia_flowers");

        addPlantGrowthChamberRecipe(output, Ingredient.of(RuBlocks.PINK_MAGNOLIA_FLOWERS.get()), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.PINK_MAGNOLIA_FLOWERS.get()), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "pink_magnolia_flowers", "pink_magnolia_flowers");

        addPlantGrowthChamberRecipe(output, Ingredient.of(RuBlocks.WHITE_MAGNOLIA_FLOWERS.get()), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.WHITE_MAGNOLIA_FLOWERS.get()), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "white_magnolia_flowers", "white_magnolia_flowers");

        addPlantGrowthChamberRecipe(output, Ingredient.of(RuItems.SALMONBERRY.get()), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuItems.SALMONBERRY.get()), new double[] {
                        1., 1., .33, .17
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "salmonberry", "salmonberry");
    }

    private void buildPlantGrowthChamberSoilRecipes(RecipeOutput output) {
        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.PEAT_FARMLAND),
                EPSoilTypes.FARMLAND, 1.75, 0.75, 0.7, "peat_farmland");
        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.PEAT_DIRT),
                EPSoilTypes.DIRT, 1.15, 0.75, 0.9, "peat_dirt");
        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.PEAT_COARSE_DIRT),
                EPSoilTypes.COARSE_DIRT, 1.15, 1.0, 0.8, "peat_coarse_dirt");
        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.PEAT_GRASS_BLOCK),
                EPSoilTypes.GRASS, 1.3, 0.75, 0.9, "peat_grass");
        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.PEAT_PODZOL),
                EPSoilTypes.PODZOL, 1.5, 0.75, 0.9, "peat_podzol");
        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.PEAT_MUD),
                EPSoilTypes.MUD, 1.5, 0.35, 0.9, "peat_mud");


        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.SILT_FARMLAND),
                EPSoilTypes.FARMLAND, 1.25, 1.25, 1.0, "silt_farmland");
        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.SILT_DIRT),
                EPSoilTypes.DIRT, 0.75, 1.25, 1.1, "silt_dirt");
        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.SILT_COARSE_DIRT),
                EPSoilTypes.COARSE_DIRT, 0.75, 1.4, 1.0, "silt_coarse_dirt");
        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.SILT_GRASS_BLOCK),
                EPSoilTypes.GRASS, 0.9, 1.25, 1.1, "silt_grass");
        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.SILT_PODZOL),
                EPSoilTypes.PODZOL, 1.0, 1.25, 1.1, "silt_podzol");
        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.SILT_MUD),
                EPSoilTypes.MUD, 1.0, 0.75, 1.1, "silt_mud");

        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.ASHEN_DIRT),
                EPSoilTypes.GRASS, 1.15, 1.1, 0.75, "ashen_dirt");

        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.ALPHA_GRASS_BLOCK),
                EPSoilTypes.GRASS, 1.1, 1.0, 1.0, "alpha_grass");

        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.STONE_GRASS_BLOCK, RuBlocks.DEEPSLATE_GRASS_BLOCK, RuBlocks.ARGILLITE_GRASS_BLOCK, RuBlocks.CHALK_GRASS_BLOCK),
                EPSoilTypes.GRASS, 0.75, 2.0, 2.0, "stone_grass");

        addPlantGrowthChamberSoilRecipe(output, ingredientOf(RuBlocks.ARGILLITE, RuBlocks.CHALK),
                EPSoilTypes.STONE, 0.5, 2.0, 2.0, "stone");
    }
    private void addCustomCraftingRecipe(RecipeOutput recipeOutput, CustomRecipe customRecipe, String recipeIdString) {
        ResourceLocation recipeId = ResourceLocation.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, PATH_PREFIX + "crafting/" +
                recipeIdString);

        recipeOutput.accept(recipeId, customRecipe, null);
    }

    private void addCrusherRecipe(RecipeOutput RecipeExporter, Ingredient input, ItemStack output,
                                  String recipeIngredientName) {
        ResourceLocation recipeId = ResourceLocation.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, PATH_PREFIX + "crusher/" +
                getItemName(output.getItem()) + "_from_crushing_" + recipeIngredientName);

        CrusherRecipe recipe = new CrusherRecipe(output, input);
        RecipeExporter.accept(recipeId, recipe, null);
    }

    private void addBasicWoodSawmillRecipe(RecipeOutput RecipeExporter, ItemStack planksItem,
                                                  Ingredient logsInput, Ingredient fenceInput, Ingredient fenceGateInput,
                                                  Ingredient doorInput, Ingredient trapdoorInput, Ingredient pressurePlateInput,
                                                  Ingredient signInput, Ingredient boatInput, Ingredient chestBoatInput,
                                                  boolean isRaft, String woodName) {
        addSawmillRecipe(RecipeExporter, logsInput, planksItem.copyWithCount(6), 1, getItemName(planksItem.getItem()),
                woodName + "_logs");

        addBasicWoodWithoutLogsSawmillRecipe(RecipeExporter, planksItem, fenceInput, fenceGateInput, doorInput, trapdoorInput,
                pressurePlateInput, signInput, boatInput, chestBoatInput, isRaft, woodName);
    }
    private void addBasicWoodWithoutLogsSawmillRecipe(RecipeOutput RecipeExporter, ItemStack planksItem,
                                                             Ingredient fenceInput, Ingredient fenceGateInput,
                                                             Ingredient doorInput, Ingredient trapdoorInput, Ingredient pressurePlateInput,
                                                             Ingredient signInput, Ingredient boatInput, Ingredient chestBoatInput,
                                                             boolean isRaft, String woodName) {
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(RecipeExporter, planksItem, fenceInput, fenceGateInput, doorInput,
                trapdoorInput, pressurePlateInput, signInput, woodName);

        addSawmillRecipe(RecipeExporter, boatInput, planksItem.copyWithCount(4), 3, getItemName(planksItem.getItem()),
                woodName + (isRaft?"_raft":"_boat"));
        addSawmillRecipe(RecipeExporter, chestBoatInput, planksItem.copyWithCount(5), 7, getItemName(planksItem.getItem()),
                woodName + (isRaft?"_chest_raft":"_chest_boat"));
    }
    private void addBasicWoodWithoutLogsAndBoatsSawmillRecipe(RecipeOutput RecipeExporter, ItemStack planksItem,
                                                              Ingredient fenceInput, Ingredient fenceGateInput,
                                                              Ingredient doorInput, Ingredient trapdoorInput, Ingredient pressurePlateInput,
                                                              Ingredient signInput, String woodName) {
        addSawmillRecipe(RecipeExporter, fenceInput, planksItem, 2, getItemName(planksItem.getItem()),
                woodName + "_fence");
        addSawmillRecipe(RecipeExporter, fenceGateInput, planksItem.copyWithCount(2), 3, getItemName(planksItem.getItem()),
                woodName + "_fence_gate");
        addSawmillRecipe(RecipeExporter, doorInput, planksItem, 3, getItemName(planksItem.getItem()),
                woodName + "_door");
        addSawmillRecipe(RecipeExporter, trapdoorInput, planksItem.copyWithCount(2), 3, getItemName(planksItem.getItem()),
                woodName + "_trapdoor");
        addSawmillRecipe(RecipeExporter, pressurePlateInput, planksItem, 2, getItemName(planksItem.getItem()),
                woodName + "_pressure_plate");
        addSawmillRecipe(RecipeExporter, signInput, planksItem.copyWithCount(2), 1, getItemName(planksItem.getItem()),
                woodName + "_sign");
    }
    private void addSawmillRecipe(RecipeOutput RecipeExporter, Ingredient input, ItemStack output,
                                  int sawdustAmount, String outputName, String recipeIngredientName) {
        ResourceLocation recipeId = ResourceLocation.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, PATH_PREFIX + "sawmill/" +
                outputName + "_from_sawing_" + recipeIngredientName);

        SawmillRecipe recipe = new SawmillRecipe(output, input, sawdustAmount);
        RecipeExporter.accept(recipeId, recipe, null);
    }

    private void addBasicFlowerGrowingRecipe(RecipeOutput recipeExporter, ItemLike flowerItem, String outputName) {
        addPlantGrowthChamberRecipe(recipeExporter, Ingredient.of(flowerItem), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(flowerItem), new double[] {
                        1., 1., .33
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, outputName, getItemName(flowerItem));
    }
    private void addPlantGrowthChamberRecipe(RecipeOutput recipeExporter, Ingredient input,
                                             OutputItemStackWithPercentages[] outputs,
                                             TagKey<SoilType> soilType,
                                             Fluid fluid, double fluidConsumption, int ticks,
                                             String outputName, String recipeIngredientName) {
        addPlantGrowthChamberRecipe(recipeExporter, input, outputs, soilType, new Fluid[] {fluid}, fluidConsumption, ticks, outputName, recipeIngredientName);
    }
    private void addPlantGrowthChamberRecipe(RecipeOutput recipeExporter, Ingredient input,
                                             OutputItemStackWithPercentages[] outputs,
                                             TagKey<SoilType> soilType,
                                             Fluid[] fluid, double fluidConsumption, int ticks,
                                             String outputName, String recipeIngredientName) {
        ResourceLocation recipeId = ResourceLocation.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, PATH_PREFIX + "growing/" +
                outputName + "_from_growing_" + recipeIngredientName);

        PlantGrowthChamberRecipe recipe = new PlantGrowthChamberRecipe(outputs, input, soilType, fluid, fluidConsumption, ticks);
        recipeExporter.accept(recipeId, recipe, null);
    }

    private void addPlantGrowthChamberSoilRecipe(RecipeOutput recipeOutput, Ingredient input,
                                                 ResourceKey<SoilType> soilType,
                                                 double speedMultiplier,
                                                 double fluidConsumptionMultiplier, double energyConsumptionMultiplier,
                                                 String recipeIngredientName) {
        ResourceLocation recipeId = ResourceLocation.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, PATH_PREFIX + "growing/soil/" +
                recipeIngredientName);

        PlantGrowthChamberSoilRecipe recipe = new PlantGrowthChamberSoilRecipe(input, soilType,
                speedMultiplier, fluidConsumptionMultiplier, energyConsumptionMultiplier);
        recipeOutput.accept(recipeId, recipe, null);
    }

    private Ingredient ingredientOf(Supplier<? extends ItemLike> item) {
        return Ingredient.of(item.get());
    }

    private Ingredient ingredientOf(Supplier<? extends ItemLike>... items) {
        return Ingredient.of(Arrays.stream(items).map(Supplier::get).toArray(ItemLike[]::new));
    }

    private Ingredient ingredientOf(ItemLike item) {
        return Ingredient.of(item);
    }

    private Ingredient ingredientOf(ItemLike... items) {
        return Ingredient.of(items);
    }

    private Ingredient ingredientOf(TagKey<Item> tagKey) {
        return Ingredient.of(tagKey);
    }
}
