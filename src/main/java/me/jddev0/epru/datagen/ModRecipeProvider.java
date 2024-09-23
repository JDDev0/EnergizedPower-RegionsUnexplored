package me.jddev0.epru.datagen;

import io.github.uhq_games.regions_unexplored.RegionsUnexplored;
import io.github.uhq_games.regions_unexplored.block.RuBlocks;
import io.github.uhq_games.regions_unexplored.data.tags.RuTags;
import io.github.uhq_games.regions_unexplored.item.RuItems;
import me.jddev0.ep.datagen.recipe.CrusherFinishedRecipe;
import me.jddev0.ep.datagen.recipe.PlantGrowthChamberFinishedRecipe;
import me.jddev0.ep.datagen.recipe.SawmillFinishedRecipe;
import me.jddev0.epru.EnergizedPowerRUMod;
import me.jddev0.ep.recipe.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final String REGIONS_UNEXPLORED_MOD_ID = RegionsUnexplored.MODID;
    private static final String PATH_PREFIX = "compat/" + REGIONS_UNEXPLORED_MOD_ID + "/";

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> output) {
        buildCrusherRecipes(output);
        buildSawmillRecipes(output);
        buildPlantGrowthChamberRecipes(output);
    }

    private void buildCrusherRecipes(Consumer<RecipeJsonProvider> output) {
        addCrusherRecipe(output, Ingredient.ofItems(RuBlocks.MOSSY_STONE), new ItemStack(Items.MOSSY_COBBLESTONE),
                "mossy_stone");

        addCrusherRecipe(output, Ingredient.ofItems(RuBlocks.CHALK_BRICKS, RuBlocks.POLISHED_CHALK,
                        RuBlocks.CHALK_PILLAR), new ItemStack(RuBlocks.CHALK),
                "chalk_variants");
    }

    private void buildSawmillRecipes(Consumer<RecipeJsonProvider> output) {
        addSawmillRecipe(output, Ingredient.fromTag(RuTags.BRANCHES_ITEM), new ItemStack(Items.STICK, 6), 1,
                getItemPath(Items.STICK), "_branches");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.BAOBAB_PLANKS),
                Ingredient.fromTag(RuTags.BAOBAB_LOGS_ITEM), Ingredient.ofItems(RuBlocks.BAOBAB_FENCE),
                Ingredient.ofItems(RuBlocks.BAOBAB_FENCE_GATE), Ingredient.ofItems(RuBlocks.BAOBAB_DOOR),
                Ingredient.ofItems(RuBlocks.BAOBAB_TRAPDOOR), Ingredient.ofItems(RuBlocks.BAOBAB_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.BAOBAB_SIGN), Ingredient.ofItems(RuItems.BAOBAB_BOAT),
                Ingredient.ofItems(RuItems.BAOBAB_CHEST_BOAT),
                false, "baobab");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.BLACKWOOD_PLANKS),
                Ingredient.fromTag(RuTags.BLACKWOOD_LOGS_ITEM), Ingredient.ofItems(RuBlocks.BLACKWOOD_FENCE),
                Ingredient.ofItems(RuBlocks.BLACKWOOD_FENCE_GATE), Ingredient.ofItems(RuBlocks.BLACKWOOD_DOOR),
                Ingredient.ofItems(RuBlocks.BLACKWOOD_TRAPDOOR), Ingredient.ofItems(RuBlocks.BLACKWOOD_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.BLACKWOOD_SIGN), Ingredient.ofItems(RuItems.BLACKWOOD_BOAT),
                Ingredient.ofItems(RuItems.BLACKWOOD_CHEST_BOAT),
                false, "blackwood");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.CYPRESS_PLANKS),
                Ingredient.fromTag(RuTags.CYPRESS_LOGS_ITEM), Ingredient.ofItems(RuBlocks.CYPRESS_FENCE),
                Ingredient.ofItems(RuBlocks.CYPRESS_FENCE_GATE), Ingredient.ofItems(RuBlocks.CYPRESS_DOOR),
                Ingredient.ofItems(RuBlocks.CYPRESS_TRAPDOOR), Ingredient.ofItems(RuBlocks.CYPRESS_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.CYPRESS_SIGN), Ingredient.ofItems(RuItems.CYPRESS_BOAT),
                Ingredient.ofItems(RuItems.CYPRESS_CHEST_BOAT),
                false, "cypress");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.DEAD_PLANKS),
                Ingredient.fromTag(RuTags.DEAD_LOGS_ITEM), Ingredient.ofItems(RuBlocks.DEAD_FENCE),
                Ingredient.ofItems(RuBlocks.DEAD_FENCE_GATE), Ingredient.ofItems(RuBlocks.DEAD_DOOR),
                Ingredient.ofItems(RuBlocks.DEAD_TRAPDOOR), Ingredient.ofItems(RuBlocks.DEAD_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.DEAD_SIGN), Ingredient.ofItems(RuItems.DEAD_BOAT),
                Ingredient.ofItems(RuItems.DEAD_CHEST_BOAT),
                false, "dead");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.EUCALYPTUS_PLANKS),
                Ingredient.fromTag(RuTags.EUCALYPTUS_LOGS_ITEM), Ingredient.ofItems(RuBlocks.EUCALYPTUS_FENCE),
                Ingredient.ofItems(RuBlocks.EUCALYPTUS_FENCE_GATE), Ingredient.ofItems(RuBlocks.EUCALYPTUS_DOOR),
                Ingredient.ofItems(RuBlocks.EUCALYPTUS_TRAPDOOR), Ingredient.ofItems(RuBlocks.EUCALYPTUS_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.EUCALYPTUS_SIGN), Ingredient.ofItems(RuItems.EUCALYPTUS_BOAT),
                Ingredient.ofItems(RuItems.EUCALYPTUS_CHEST_BOAT),
                false, "eucalyptus");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.JOSHUA_PLANKS),
                Ingredient.fromTag(RuTags.JOSHUA_LOGS_ITEM), Ingredient.ofItems(RuBlocks.JOSHUA_FENCE),
                Ingredient.ofItems(RuBlocks.JOSHUA_FENCE_GATE), Ingredient.ofItems(RuBlocks.JOSHUA_DOOR),
                Ingredient.ofItems(RuBlocks.JOSHUA_TRAPDOOR), Ingredient.ofItems(RuBlocks.JOSHUA_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.JOSHUA_SIGN), Ingredient.ofItems(RuItems.JOSHUA_BOAT),
                Ingredient.ofItems(RuItems.JOSHUA_CHEST_BOAT),
                false, "joshua");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.KAPOK_PLANKS),
                Ingredient.fromTag(RuTags.KAPOK_LOGS_ITEM), Ingredient.ofItems(RuBlocks.KAPOK_FENCE),
                Ingredient.ofItems(RuBlocks.KAPOK_FENCE_GATE), Ingredient.ofItems(RuBlocks.KAPOK_DOOR),
                Ingredient.ofItems(RuBlocks.KAPOK_TRAPDOOR), Ingredient.ofItems(RuBlocks.KAPOK_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.KAPOK_SIGN), Ingredient.ofItems(RuItems.KAPOK_BOAT),
                Ingredient.ofItems(RuItems.KAPOK_CHEST_BOAT),
                false, "kapok");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.LARCH_PLANKS),
                Ingredient.fromTag(RuTags.LARCH_LOGS_ITEM), Ingredient.ofItems(RuBlocks.LARCH_FENCE),
                Ingredient.ofItems(RuBlocks.LARCH_FENCE_GATE), Ingredient.ofItems(RuBlocks.LARCH_DOOR),
                Ingredient.ofItems(RuBlocks.LARCH_TRAPDOOR), Ingredient.ofItems(RuBlocks.LARCH_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.LARCH_SIGN), Ingredient.ofItems(RuItems.LARCH_BOAT),
                Ingredient.ofItems(RuItems.LARCH_CHEST_BOAT),
                false, "larch");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.MAGNOLIA_PLANKS),
                Ingredient.fromTag(RuTags.MAGNOLIA_LOGS_ITEM), Ingredient.ofItems(RuBlocks.MAGNOLIA_FENCE),
                Ingredient.ofItems(RuBlocks.MAGNOLIA_FENCE_GATE), Ingredient.ofItems(RuBlocks.MAGNOLIA_DOOR),
                Ingredient.ofItems(RuBlocks.MAGNOLIA_TRAPDOOR), Ingredient.ofItems(RuBlocks.MAGNOLIA_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.MAGNOLIA_SIGN), Ingredient.ofItems(RuItems.MAGNOLIA_BOAT),
                Ingredient.ofItems(RuItems.MAGNOLIA_CHEST_BOAT),
                false, "magnolia");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.MAPLE_PLANKS),
                Ingredient.fromTag(RuTags.MAPLE_LOGS_ITEM), Ingredient.ofItems(RuBlocks.MAPLE_FENCE),
                Ingredient.ofItems(RuBlocks.MAPLE_FENCE_GATE), Ingredient.ofItems(RuBlocks.MAPLE_DOOR),
                Ingredient.ofItems(RuBlocks.MAPLE_TRAPDOOR), Ingredient.ofItems(RuBlocks.MAPLE_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.MAPLE_SIGN), Ingredient.ofItems(RuItems.MAPLE_BOAT),
                Ingredient.ofItems(RuItems.MAPLE_CHEST_BOAT),
                false, "maple");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.MAUVE_PLANKS),
                Ingredient.fromTag(RuTags.MAUVE_LOGS_ITEM), Ingredient.ofItems(RuBlocks.MAUVE_FENCE),
                Ingredient.ofItems(RuBlocks.MAUVE_FENCE_GATE), Ingredient.ofItems(RuBlocks.MAUVE_DOOR),
                Ingredient.ofItems(RuBlocks.MAUVE_TRAPDOOR), Ingredient.ofItems(RuBlocks.MAUVE_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.MAUVE_SIGN), Ingredient.ofItems(RuItems.MAUVE_BOAT),
                Ingredient.ofItems(RuItems.MAUVE_CHEST_BOAT),
                false, "mauve");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.PALM_PLANKS),
                Ingredient.fromTag(RuTags.PALM_LOGS_ITEM), Ingredient.ofItems(RuBlocks.PALM_FENCE),
                Ingredient.ofItems(RuBlocks.PALM_FENCE_GATE), Ingredient.ofItems(RuBlocks.PALM_DOOR),
                Ingredient.ofItems(RuBlocks.PALM_TRAPDOOR), Ingredient.ofItems(RuBlocks.PALM_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.PALM_SIGN), Ingredient.ofItems(RuItems.PALM_BOAT),
                Ingredient.ofItems(RuItems.PALM_CHEST_BOAT),
                false, "palm");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.PINE_PLANKS),
                Ingredient.fromTag(RuTags.PINE_LOGS_ITEM), Ingredient.ofItems(RuBlocks.PINE_FENCE),
                Ingredient.ofItems(RuBlocks.PINE_FENCE_GATE), Ingredient.ofItems(RuBlocks.PINE_DOOR),
                Ingredient.ofItems(RuBlocks.PINE_TRAPDOOR), Ingredient.ofItems(RuBlocks.PINE_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.PINE_SIGN), Ingredient.ofItems(RuItems.PINE_BOAT),
                Ingredient.ofItems(RuItems.PINE_CHEST_BOAT),
                false, "pine");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.REDWOOD_PLANKS),
                Ingredient.fromTag(RuTags.REDWOOD_LOGS_ITEM), Ingredient.ofItems(RuBlocks.REDWOOD_FENCE),
                Ingredient.ofItems(RuBlocks.REDWOOD_FENCE_GATE), Ingredient.ofItems(RuBlocks.REDWOOD_DOOR),
                Ingredient.ofItems(RuBlocks.REDWOOD_TRAPDOOR), Ingredient.ofItems(RuBlocks.REDWOOD_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.REDWOOD_SIGN), Ingredient.ofItems(RuItems.REDWOOD_BOAT),
                Ingredient.ofItems(RuItems.REDWOOD_CHEST_BOAT),
                false, "redwood");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.SOCOTRA_PLANKS),
                Ingredient.fromTag(RuTags.SOCOTRA_LOGS_ITEM), Ingredient.ofItems(RuBlocks.SOCOTRA_FENCE),
                Ingredient.ofItems(RuBlocks.SOCOTRA_FENCE_GATE), Ingredient.ofItems(RuBlocks.SOCOTRA_DOOR),
                Ingredient.ofItems(RuBlocks.SOCOTRA_TRAPDOOR), Ingredient.ofItems(RuBlocks.SOCOTRA_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.SOCOTRA_SIGN), Ingredient.ofItems(RuItems.SOCOTRA_BOAT),
                Ingredient.ofItems(RuItems.SOCOTRA_CHEST_BOAT),
                false, "socotra");

        addBasicWoodSawmillRecipe(output, new ItemStack(RuBlocks.WILLOW_PLANKS),
                Ingredient.fromTag(RuTags.WILLOW_LOGS_ITEM), Ingredient.ofItems(RuBlocks.WILLOW_FENCE),
                Ingredient.ofItems(RuBlocks.WILLOW_FENCE_GATE), Ingredient.ofItems(RuBlocks.WILLOW_DOOR),
                Ingredient.ofItems(RuBlocks.WILLOW_TRAPDOOR), Ingredient.ofItems(RuBlocks.WILLOW_PRESSURE_PLATE),
                Ingredient.ofItems(RuBlocks.WILLOW_SIGN), Ingredient.ofItems(RuItems.WILLOW_BOAT),
                Ingredient.ofItems(RuItems.WILLOW_CHEST_BOAT),
                false, "willow");

        addSawmillRecipe(output, Ingredient.fromTag(RuTags.BLUE_BIOSHROOM_LOGS_ITEM),
                new ItemStack(RuBlocks.BLUE_BIOSHROOM_PLANKS, 6),
                1, "blue_bioshroom_planks", "blue_bioshroom_stems");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.BLUE_BIOSHROOM_PLANKS),
                Ingredient.ofItems(RuBlocks.BLUE_BIOSHROOM_FENCE), Ingredient.ofItems(RuBlocks.BLUE_BIOSHROOM_FENCE_GATE),
                Ingredient.ofItems(RuBlocks.BLUE_BIOSHROOM_DOOR), Ingredient.ofItems(RuBlocks.BLUE_BIOSHROOM_TRAPDOOR),
                Ingredient.ofItems(RuBlocks.BLUE_BIOSHROOM_PRESSURE_PLATE), Ingredient.ofItems(RuBlocks.BLUE_BIOSHROOM_SIGN),
                "blue_bioshroom");

        addSawmillRecipe(output, Ingredient.fromTag(RuTags.GREEN_BIOSHROOM_LOGS_ITEM),
                new ItemStack(RuBlocks.GREEN_BIOSHROOM_PLANKS, 6),
                1, "green_bioshroom_planks", "green_bioshroom_stems");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.GREEN_BIOSHROOM_PLANKS),
                Ingredient.ofItems(RuBlocks.GREEN_BIOSHROOM_FENCE), Ingredient.ofItems(RuBlocks.GREEN_BIOSHROOM_FENCE_GATE),
                Ingredient.ofItems(RuBlocks.GREEN_BIOSHROOM_DOOR), Ingredient.ofItems(RuBlocks.GREEN_BIOSHROOM_TRAPDOOR),
                Ingredient.ofItems(RuBlocks.GREEN_BIOSHROOM_PRESSURE_PLATE), Ingredient.ofItems(RuBlocks.GREEN_BIOSHROOM_SIGN),
                "green_bioshroom");

        addSawmillRecipe(output, Ingredient.fromTag(RuTags.PINK_BIOSHROOM_LOGS_ITEM),
                new ItemStack(RuBlocks.PINK_BIOSHROOM_PLANKS, 6),
                1, "pink_bioshroom_planks", "pink_bioshroom_stems");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.PINK_BIOSHROOM_PLANKS),
                Ingredient.ofItems(RuBlocks.PINK_BIOSHROOM_FENCE), Ingredient.ofItems(RuBlocks.PINK_BIOSHROOM_FENCE_GATE),
                Ingredient.ofItems(RuBlocks.PINK_BIOSHROOM_DOOR), Ingredient.ofItems(RuBlocks.PINK_BIOSHROOM_TRAPDOOR),
                Ingredient.ofItems(RuBlocks.PINK_BIOSHROOM_PRESSURE_PLATE), Ingredient.ofItems(RuBlocks.PINK_BIOSHROOM_SIGN),
                "pink_bioshroom");

        addSawmillRecipe(output, Ingredient.fromTag(RuTags.YELLOW_BIOSHROOM_LOGS_ITEM),
                new ItemStack(RuBlocks.YELLOW_BIOSHROOM_PLANKS, 6),
                1, "yellow_bioshroom_planks", "yellow_bioshroom_stems");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.YELLOW_BIOSHROOM_PLANKS),
                Ingredient.ofItems(RuBlocks.YELLOW_BIOSHROOM_FENCE), Ingredient.ofItems(RuBlocks.YELLOW_BIOSHROOM_FENCE_GATE),
                Ingredient.ofItems(RuBlocks.YELLOW_BIOSHROOM_DOOR), Ingredient.ofItems(RuBlocks.YELLOW_BIOSHROOM_TRAPDOOR),
                Ingredient.ofItems(RuBlocks.YELLOW_BIOSHROOM_PRESSURE_PLATE), Ingredient.ofItems(RuBlocks.YELLOW_BIOSHROOM_SIGN),
                "yellow_bioshroom");

        addSawmillRecipe(output, Ingredient.fromTag(RuTags.BRIMWOOD_LOGS_ITEM),
                new ItemStack(RuBlocks.BRIMWOOD_PLANKS, 6),
                1, "brimwood_planks", "brimwood_logs");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.BRIMWOOD_PLANKS),
                Ingredient.ofItems(RuBlocks.BRIMWOOD_FENCE), Ingredient.ofItems(RuBlocks.BRIMWOOD_FENCE_GATE),
                Ingredient.ofItems(RuBlocks.BRIMWOOD_DOOR), Ingredient.ofItems(RuBlocks.BRIMWOOD_TRAPDOOR),
                Ingredient.ofItems(RuBlocks.BRIMWOOD_PRESSURE_PLATE), Ingredient.ofItems(RuBlocks.BRIMWOOD_SIGN),
                "brimwood");

        addSawmillRecipe(output, Ingredient.fromTag(RuTags.COBALT_LOGS_ITEM),
                new ItemStack(RuBlocks.COBALT_PLANKS, 6),
                1, "cobalt_planks", "cobalt_logs");
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(output, new ItemStack(RuBlocks.COBALT_PLANKS),
                Ingredient.ofItems(RuBlocks.COBALT_FENCE), Ingredient.ofItems(RuBlocks.COBALT_FENCE_GATE),
                Ingredient.ofItems(RuBlocks.COBALT_DOOR), Ingredient.ofItems(RuBlocks.COBALT_TRAPDOOR),
                Ingredient.ofItems(RuBlocks.COBALT_PRESSURE_PLATE), Ingredient.ofItems(RuBlocks.COBALT_SIGN),
                "cobalt");
    }

    private void buildPlantGrowthChamberRecipes(Consumer<RecipeJsonProvider> output) {
        addBasicFlowerGrowingRecipe(output, RuBlocks.ASTER, "aster");
        addBasicFlowerGrowingRecipe(output, RuBlocks.BLEEDING_HEART, "beleeding_heart");
        addBasicFlowerGrowingRecipe(output, RuBlocks.DAISY, "daisy");
        addBasicFlowerGrowingRecipe(output, RuBlocks.DORCEL, "dorcel");
        addBasicFlowerGrowingRecipe(output, RuBlocks.FELICIA_DAISY, "felicia_daisy");
        addBasicFlowerGrowingRecipe(output, RuBlocks.FIREWEED, "fireweed");
        addBasicFlowerGrowingRecipe(output, RuBlocks.GLISTERING_BLOOM, "glistering_bloom");
        addBasicFlowerGrowingRecipe(output, RuBlocks.HIBISCUS, "hibiscus");
        addBasicFlowerGrowingRecipe(output, RuBlocks.HYSSOP, "hyssop");
        addBasicFlowerGrowingRecipe(output, RuBlocks.MALLOW, "mallow");
        addBasicFlowerGrowingRecipe(output, RuBlocks.POPPY_BUSH, "poppy_bush");
        addBasicFlowerGrowingRecipe(output, RuBlocks.SALMON_POPPY_BUSH, "salmon_poppy_bush");
        addBasicFlowerGrowingRecipe(output, RuBlocks.TSUBAKI, "tsubaki");
        addBasicFlowerGrowingRecipe(output, RuBlocks.WARATAH, "waratah");
        addBasicFlowerGrowingRecipe(output, RuBlocks.WHITE_TRILLIUM, "white_trillium");
        addBasicFlowerGrowingRecipe(output, RuBlocks.WILTING_TRILLIUM, "wilting_trillium");
        addBasicFlowerGrowingRecipe(output, RuBlocks.BLUE_LUPINE, "blue_lupine");
        addBasicFlowerGrowingRecipe(output, RuBlocks.PINK_LUPINE, "pink_lupine");
        addBasicFlowerGrowingRecipe(output, RuBlocks.PURPLE_LUPINE, "purple_lupine");
        addBasicFlowerGrowingRecipe(output, RuBlocks.RED_LUPINE, "red_lupine");
        addBasicFlowerGrowingRecipe(output, RuBlocks.YELLOW_LUPINE, "yellow_lupine");
        addBasicFlowerGrowingRecipe(output, RuBlocks.COBALT_EARLIGHT, "cobalt_earlight");
        addBasicFlowerGrowingRecipe(output, RuBlocks.WHITE_SNOWBELLE, "white_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.LIGHT_GRAY_SNOWBELLE, "light_gray_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.GRAY_SNOWBELLE, "gray_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.RED_SNOWBELLE, "red_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.ORANGE_SNOWBELLE, "orange_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.YELLOW_SNOWBELLE, "yellow_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.LIME_SNOWBELLE, "lime_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.GREEN_SNOWBELLE, "green_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.CYAN_SNOWBELLE, "cyan_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.LIGHT_BLUE_SNOWBELLE, "light_blue_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.BLUE_SNOWBELLE, "blue_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.PURPLE_SNOWBELLE, "purple_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.MAGENTA_SNOWBELLE, "magenta_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.PINK_SNOWBELLE, "pink_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.BROWN_SNOWBELLE, "brown_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.BLACK_SNOWBELLE, "black_snowbelle");
        addBasicFlowerGrowingRecipe(output, RuBlocks.CAVE_HYSSOP, "cave_hyssop");

        addBasicFlowerGrowingRecipe(output, RuBlocks.BARLEY, "barley");
        addBasicFlowerGrowingRecipe(output, RuBlocks.CATTAIL, "cattail");
        addBasicFlowerGrowingRecipe(output, RuBlocks.DAY_LILY, "day_lily");
        addBasicFlowerGrowingRecipe(output, RuBlocks.MEADOW_SAGE, "meadow_sage");
        addBasicFlowerGrowingRecipe(output, RuBlocks.TASSEL, "tassel");
        addBasicFlowerGrowingRecipe(output, RuBlocks.GLISTER_BULB, "glister_bulb");
        addBasicFlowerGrowingRecipe(output, RuBlocks.GLISTER_SPIRE, "glister_spire");
        addBasicFlowerGrowingRecipe(output, RuBlocks.MYCOTOXIC_DAISY, "mycotoxic_daisy");
        addBasicFlowerGrowingRecipe(output, RuBlocks.TALL_COBALT_EARLIGHT, "tall_cobalt_earlight");

        addPlantGrowthChamberRecipe(output, Ingredient.ofItems(RuBlocks.CLOVER), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.CLOVER), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, 16000, "clover", "clover");

        addPlantGrowthChamberRecipe(output, Ingredient.ofItems(RuBlocks.ORANGE_CONEFLOWER), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.ORANGE_CONEFLOWER), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, 16000, "orange_coneflower", "orange_coneflower");

        addPlantGrowthChamberRecipe(output, Ingredient.ofItems(RuBlocks.PURPLE_CONEFLOWER), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.PURPLE_CONEFLOWER), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, 16000, "purple_coneflower", "pruple_coneflower");

        addPlantGrowthChamberRecipe(output, Ingredient.ofItems(RuBlocks.HYACINTH_FLOWERS), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.HYACINTH_FLOWERS), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, 16000, "hyacinth_flowers", "hyacinth_flowers");

        addPlantGrowthChamberRecipe(output, Ingredient.ofItems(RuBlocks.BLUE_MAGNOLIA_FLOWERS), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.BLUE_MAGNOLIA_FLOWERS), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, 16000, "blue_magnolia_flowers", "blue_magnolia_flowers");

        addPlantGrowthChamberRecipe(output, Ingredient.ofItems(RuBlocks.PINK_MAGNOLIA_FLOWERS), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.PINK_MAGNOLIA_FLOWERS), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, 16000, "pink_magnolia_flowers", "pink_magnolia_flowers");

        addPlantGrowthChamberRecipe(output, Ingredient.ofItems(RuBlocks.WHITE_MAGNOLIA_FLOWERS), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuBlocks.WHITE_MAGNOLIA_FLOWERS), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, 16000, "white_magnolia_flowers", "white_magnolia_flowers");

        addPlantGrowthChamberRecipe(output, Ingredient.ofItems(RuItems.SALMONBERRY), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(RuItems.SALMONBERRY), new double[] {
                        1., 1., .33, .17
                })
        }, 16000, "salmonberry", "salmonberry");
    }

    private void addCrusherRecipe(Consumer<RecipeJsonProvider> RecipeExporter, Ingredient input, ItemStack output,
                                  String recipeIngredientName) {
        Identifier recipeId = Identifier.of(EnergizedPowerRUMod.MODID, PATH_PREFIX + "crusher/" +
                getItemPath(output.getItem()) + "_from_crushing_" + recipeIngredientName);

        CrusherFinishedRecipe recipe = new CrusherFinishedRecipe(
                recipeId,
                output, input
        );
        RecipeExporter.accept(recipe);
    }

    private void addBasicWoodSawmillRecipe(Consumer<RecipeJsonProvider> RecipeExporter, ItemStack planksItem,
                                                  Ingredient logsInput, Ingredient fenceInput, Ingredient fenceGateInput,
                                                  Ingredient doorInput, Ingredient trapdoorInput, Ingredient pressurePlateInput,
                                                  Ingredient signInput, Ingredient boatInput, Ingredient chestBoatInput,
                                                  boolean isRaft, String woodName) {
        addSawmillRecipe(RecipeExporter, logsInput, planksItem.copyWithCount(6), 1, getItemPath(planksItem.getItem()),
                woodName + "_logs");

        addBasicWoodWithoutLogsSawmillRecipe(RecipeExporter, planksItem, fenceInput, fenceGateInput, doorInput, trapdoorInput,
                pressurePlateInput, signInput, boatInput, chestBoatInput, isRaft, woodName);
    }
    private void addBasicWoodWithoutLogsSawmillRecipe(Consumer<RecipeJsonProvider> RecipeExporter, ItemStack planksItem,
                                                             Ingredient fenceInput, Ingredient fenceGateInput,
                                                             Ingredient doorInput, Ingredient trapdoorInput, Ingredient pressurePlateInput,
                                                             Ingredient signInput, Ingredient boatInput, Ingredient chestBoatInput,
                                                             boolean isRaft, String woodName) {
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(RecipeExporter, planksItem, fenceInput, fenceGateInput, doorInput,
                trapdoorInput, pressurePlateInput, signInput, woodName);

        addSawmillRecipe(RecipeExporter, boatInput, planksItem.copyWithCount(4), 3, getItemPath(planksItem.getItem()),
                woodName + (isRaft?"_raft":"_boat"));
        addSawmillRecipe(RecipeExporter, chestBoatInput, planksItem.copyWithCount(5), 7, getItemPath(planksItem.getItem()),
                woodName + (isRaft?"_chest_raft":"_chest_boat"));
    }
    private void addBasicWoodWithoutLogsAndBoatsSawmillRecipe(Consumer<RecipeJsonProvider> RecipeExporter, ItemStack planksItem,
                                                              Ingredient fenceInput, Ingredient fenceGateInput,
                                                              Ingredient doorInput, Ingredient trapdoorInput, Ingredient pressurePlateInput,
                                                              Ingredient signInput, String woodName) {
        addSawmillRecipe(RecipeExporter, fenceInput, planksItem, 2, getItemPath(planksItem.getItem()),
                woodName + "_fence");
        addSawmillRecipe(RecipeExporter, fenceGateInput, planksItem.copyWithCount(2), 3, getItemPath(planksItem.getItem()),
                woodName + "_fence_gate");
        addSawmillRecipe(RecipeExporter, doorInput, planksItem, 3, getItemPath(planksItem.getItem()),
                woodName + "_door");
        addSawmillRecipe(RecipeExporter, trapdoorInput, planksItem.copyWithCount(2), 3, getItemPath(planksItem.getItem()),
                woodName + "_trapdoor");
        addSawmillRecipe(RecipeExporter, pressurePlateInput, planksItem, 2, getItemPath(planksItem.getItem()),
                woodName + "_pressure_plate");
        addSawmillRecipe(RecipeExporter, signInput, planksItem.copyWithCount(2), 1, getItemPath(planksItem.getItem()),
                woodName + "_sign");
    }
    private void addSawmillRecipe(Consumer<RecipeJsonProvider> RecipeExporter, Ingredient input, ItemStack output,
                                  int sawdustAmount, String outputName, String recipeIngredientName) {
        Identifier recipeId = Identifier.of(EnergizedPowerRUMod.MODID, PATH_PREFIX + "sawmill/" +
                outputName + "_from_sawing_" + recipeIngredientName);

        SawmillFinishedRecipe recipe = new SawmillFinishedRecipe(
                recipeId,
                output, input, sawdustAmount
        );
        RecipeExporter.accept(recipe);
    }

    private void addBasicFlowerGrowingRecipe(Consumer<RecipeJsonProvider> RecipeExporter, ItemConvertible flowerItem,
                                             String outputName) {
        addPlantGrowthChamberRecipe(RecipeExporter, Ingredient.ofItems(flowerItem), new OutputItemStackWithPercentages[] {
                new OutputItemStackWithPercentages(new ItemStack(flowerItem), new double[] {
                        1., 1., .33
                })
        }, 16000, outputName, getItemPath(flowerItem));
    }
    private void addPlantGrowthChamberRecipe(Consumer<RecipeJsonProvider> RecipeExporter, Ingredient input,
                                             OutputItemStackWithPercentages[] outputs, int ticks,
                                             String outputName, String recipeIngredientName) {
        Identifier recipeId = Identifier.of(EnergizedPowerRUMod.MODID, PATH_PREFIX + "growing/" +
                outputName + "_from_growing_" + recipeIngredientName);

        PlantGrowthChamberFinishedRecipe recipe = new PlantGrowthChamberFinishedRecipe(
                recipeId,
                outputs, input, ticks
        );
        RecipeExporter.accept(recipe);
    }
}
