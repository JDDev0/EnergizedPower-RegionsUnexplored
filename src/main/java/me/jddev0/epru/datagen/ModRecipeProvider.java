package me.jddev0.epru.datagen;

import me.jddev0.ep.datagen.recipe.CrusherFinishedRecipe;
import me.jddev0.ep.datagen.recipe.PlantGrowthChamberFinishedRecipe;
import me.jddev0.ep.datagen.recipe.SawmillFinishedRecipe;
import me.jddev0.ep.util.ItemStackUtils;
import me.jddev0.epru.EnergizedPowerRUMod;
import me.jddev0.ep.recipe.*;
import me.jddev0.epru.registry.tags.CompatibilityItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.item.RegionsUnexploredItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final String REGIONS_UNEXPLORED_MOD_ID = RegionsUnexploredMod.MOD_ID;
    private static final String PATH_PREFIX = "compat/" + REGIONS_UNEXPLORED_MOD_ID + "/";

    public ModRecipeProvider(FabricDataGenerator output) {
        super(output);
    }

    @Override
    public void generateRecipes(Consumer<RecipeJsonProvider> output) {
        buildCrusherRecipes(output);
        buildSawmillRecipes(output);
        buildPlantGrowthChamberRecipes(output);
    }

    private void buildCrusherRecipes(Consumer<RecipeJsonProvider> output) {
        addCrusherRecipe(output, Ingredient.ofItems(RegionsUnexploredBlocks.MOSSY_STONE), new ItemStack(Items.MOSSY_COBBLESTONE),
                "mossy_stone");

        addCrusherRecipe(output, Ingredient.ofItems(RegionsUnexploredBlocks.CHALK_BRICKS, RegionsUnexploredBlocks.POLISHED_CHALK,
                        RegionsUnexploredBlocks.CHALK_PILLAR), new ItemStack(RegionsUnexploredBlocks.CHALK),
                "chalk_variants");
    }

    private void buildSawmillRecipes(Consumer<RecipeJsonProvider> output) {
        addSawmillRecipe(output, Ingredient.fromTag(CompatibilityItemTags.BRANCHES), new ItemStack(Items.STICK, 6), 1,
                getItemPath(Items.STICK), "_branches");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.BAOBAB_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.BAOBAB_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.BAOBAB_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.BAOBAB_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.BAOBAB_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.BAOBAB_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.BAOBAB_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.BAOBAB_SIGN), Ingredient.ofItems(RegionsUnexploredItems.BAOBAB_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.BAOBAB_CHEST_BOAT),
                false, "baobab");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.BLACKWOOD_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.BLACKWOOD_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.BLACKWOOD_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.BLACKWOOD_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.BLACKWOOD_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.BLACKWOOD_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.BLACKWOOD_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.BLACKWOOD_SIGN), Ingredient.ofItems(RegionsUnexploredItems.BLACKWOOD_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.BLACKWOOD_CHEST_BOAT),
                false, "blackwood");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.CHERRY_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.CHERRY_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.CHERRY_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.CHERRY_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.CHERRY_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.CHERRY_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.CHERRY_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.CHERRY_SIGN), Ingredient.ofItems(RegionsUnexploredItems.CHERRY_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.CHERRY_CHEST_BOAT),
                false, "cherry");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.CYPRESS_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.CYPRESS_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.CYPRESS_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.CYPRESS_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.CYPRESS_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.CYPRESS_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.CYPRESS_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.CYPRESS_SIGN), Ingredient.ofItems(RegionsUnexploredItems.CYPRESS_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.CYPRESS_CHEST_BOAT),
                false, "cypress");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.DEAD_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.DEAD_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.DEAD_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.DEAD_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.DEAD_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.DEAD_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.DEAD_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.DEAD_SIGN), Ingredient.ofItems(RegionsUnexploredItems.DEAD_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.DEAD_CHEST_BOAT),
                false, "dead");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.EUCALYPTUS_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.EUCALYPTUS_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.EUCALYPTUS_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.EUCALYPTUS_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.EUCALYPTUS_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.EUCALYPTUS_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.EUCALYPTUS_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.EUCALYPTUS_SIGN), Ingredient.ofItems(RegionsUnexploredItems.EUCALYPTUS_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.EUCALYPTUS_CHEST_BOAT),
                false, "eucalyptus");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.JOSHUA_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.JOSHUA_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.JOSHUA_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.JOSHUA_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.JOSHUA_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.JOSHUA_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.JOSHUA_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.JOSHUA_SIGN), Ingredient.ofItems(RegionsUnexploredItems.JOSHUA_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.JOSHUA_CHEST_BOAT),
                false, "joshua");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.LARCH_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.LARCH_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.LARCH_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.LARCH_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.LARCH_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.LARCH_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.LARCH_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.LARCH_SIGN), Ingredient.ofItems(RegionsUnexploredItems.LARCH_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.LARCH_CHEST_BOAT),
                false, "larch");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.MAPLE_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.MAPLE_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.MAPLE_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.MAPLE_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.MAPLE_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.MAPLE_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.MAPLE_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.MAPLE_SIGN), Ingredient.ofItems(RegionsUnexploredItems.MAPLE_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.MAPLE_CHEST_BOAT),
                false, "maple");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.MAUVE_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.MAUVE_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.MAUVE_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.MAUVE_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.MAUVE_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.MAUVE_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.MAUVE_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.MAUVE_SIGN), Ingredient.ofItems(RegionsUnexploredItems.MAUVE_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.MAUVE_CHEST_BOAT),
                false, "mauve");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.PALM_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.PALM_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.PALM_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.PALM_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.PALM_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.PALM_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.PALM_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.PALM_SIGN), Ingredient.ofItems(RegionsUnexploredItems.PALM_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.PALM_CHEST_BOAT),
                false, "palm");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.PINE_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.PINE_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.PINE_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.PINE_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.PINE_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.PINE_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.PINE_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.PINE_SIGN), Ingredient.ofItems(RegionsUnexploredItems.PINE_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.PINE_CHEST_BOAT),
                false, "pine");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.REDWOOD_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.REDWOOD_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.REDWOOD_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.REDWOOD_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.REDWOOD_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.REDWOOD_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.REDWOOD_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.REDWOOD_SIGN), Ingredient.ofItems(RegionsUnexploredItems.REDWOOD_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.REDWOOD_CHEST_BOAT),
                false, "redwood");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.WILLOW_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.WILLOW_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.WILLOW_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.WILLOW_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.WILLOW_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.WILLOW_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.WILLOW_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.WILLOW_SIGN), Ingredient.ofItems(RegionsUnexploredItems.WILLOW_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.WILLOW_CHEST_BOAT),
                false, "willow");

        addBasicWoodSawmillRecipe(output, new ItemStack(RegionsUnexploredBlocks.SCULKWOOD_PLANKS),
                Ingredient.fromTag(CompatibilityItemTags.SCULKWOOD_LOGS), Ingredient.ofItems(RegionsUnexploredBlocks.SCULKWOOD_FENCE),
                Ingredient.ofItems(RegionsUnexploredBlocks.SCULKWOOD_FENCE_GATE), Ingredient.ofItems(RegionsUnexploredBlocks.SCULKWOOD_DOOR),
                Ingredient.ofItems(RegionsUnexploredBlocks.SCULKWOOD_TRAPDOOR), Ingredient.ofItems(RegionsUnexploredBlocks.SCULKWOOD_PRESSURE_PLATE),
                Ingredient.ofItems(RegionsUnexploredBlocks.SCULKWOOD_SIGN), Ingredient.ofItems(RegionsUnexploredItems.SCULKWOOD_BOAT),
                Ingredient.ofItems(RegionsUnexploredItems.SCULKWOOD_CHEST_BOAT),
                false, "sculkwood");
    }

    private void buildPlantGrowthChamberRecipes(Consumer<RecipeJsonProvider> output) {
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.DAISY, "daisy");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.DORCEL, "dorcel");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.FELICIA_DAISY, "felicia_daisy");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.FIREWEED, "fireweed");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.HYSSOP, "hyssop");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.POPPY_BUSH, "poppy_bush");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.TSUBAKI, "tsubaki");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.WARATAH, "waratah");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.WHITE_TRILLIUM, "white_trillium");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.WILTING_TRILLIUM, "wilting_trillium");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.BLUE_LUPINE, "blue_lupine");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.PINK_LUPINE, "pink_lupine");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.PURPLE_LUPINE, "purple_lupine");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.RED_LUPINE, "red_lupine");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.YELLOW_LUPINE, "yellow_lupine");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.COBALT_EARLIGHT, "cobalt_earlight");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.CAVE_HYSSOP, "cave_hyssop");

        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.BARLEY, "barley");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.CATTAIL, "cattail");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.TASSEL, "tassel");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.GLISTER_BULB, "glister_bulb");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.GLISTER_SPIRE, "glister_spire");
        addBasicFlowerGrowingRecipe(output, RegionsUnexploredBlocks.MYCOTOXIC_DAISY, "mycotoxic_daisy");
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
        addSawmillRecipe(RecipeExporter, logsInput, ItemStackUtils.copyWithCount(planksItem, 6), 1, getItemPath(planksItem.getItem()),
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

        addSawmillRecipe(RecipeExporter, boatInput, ItemStackUtils.copyWithCount(planksItem, 4), 3, getItemPath(planksItem.getItem()),
                woodName + (isRaft?"_raft":"_boat"));
        addSawmillRecipe(RecipeExporter, chestBoatInput, ItemStackUtils.copyWithCount(planksItem, 5), 7, getItemPath(planksItem.getItem()),
                woodName + (isRaft?"_chest_raft":"_chest_boat"));
    }
    private void addBasicWoodWithoutLogsAndBoatsSawmillRecipe(Consumer<RecipeJsonProvider> RecipeExporter, ItemStack planksItem,
                                                              Ingredient fenceInput, Ingredient fenceGateInput,
                                                              Ingredient doorInput, Ingredient trapdoorInput, Ingredient pressurePlateInput,
                                                              Ingredient signInput, String woodName) {
        addSawmillRecipe(RecipeExporter, fenceInput, planksItem, 2, getItemPath(planksItem.getItem()),
                woodName + "_fence");
        addSawmillRecipe(RecipeExporter, fenceGateInput, ItemStackUtils.copyWithCount(planksItem, 2), 3, getItemPath(planksItem.getItem()),
                woodName + "_fence_gate");
        addSawmillRecipe(RecipeExporter, doorInput, planksItem, 3, getItemPath(planksItem.getItem()),
                woodName + "_door");
        addSawmillRecipe(RecipeExporter, trapdoorInput, ItemStackUtils.copyWithCount(planksItem, 2), 3, getItemPath(planksItem.getItem()),
                woodName + "_trapdoor");
        addSawmillRecipe(RecipeExporter, pressurePlateInput, planksItem, 2, getItemPath(planksItem.getItem()),
                woodName + "_pressure_plate");
        addSawmillRecipe(RecipeExporter, signInput, ItemStackUtils.copyWithCount(planksItem, 2), 1, getItemPath(planksItem.getItem()),
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
