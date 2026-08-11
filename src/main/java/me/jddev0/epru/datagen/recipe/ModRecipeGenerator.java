package me.jddev0.epru.datagen.recipe;

import me.jddev0.ep.soil.EPSoilTypeTags;
import me.jddev0.ep.soil.EPSoilTypes;
import me.jddev0.ep.soil.SoilType;
import me.jddev0.epru.EnergizedPowerRUMod;
import me.jddev0.ep.recipe.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.registry.RUItems;
import net.regions_unexplored.registry.tag.RUItemTags;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ModRecipeGenerator extends RecipeProvider {
    private static final String REGIONS_UNEXPLORED_MOD_ID = RegionsUnexplored.MOD_ID;
    private static final String PATH_PREFIX = "compat/" + REGIONS_UNEXPLORED_MOD_ID + "/";

    public ModRecipeGenerator(HolderLookup.Provider registries, RecipeOutput exporter) {
        super(registries, exporter);
    }

    @Override
    public void buildRecipes() {
        buildCraftingRecipes();
        buildCrusherRecipes();
        buildSawmillRecipes();
        buildPlantGrowthChamberRecipes();
        buildPlantGrowthChamberSoilRecipes();
    }
    private void buildCustomCraftingRecipes() {
        addCustomCraftingRecipe(() -> new FarmlandCraftingRecipe(ingredientOf(RUBlocks.PEAT_DIRT), itemStackOf(RUBlocks.PEAT_FARMLAND)), "peat_farmland");
        addCustomCraftingRecipe(() -> new FarmlandCraftingRecipe(ingredientOf(RUBlocks.SILT_DIRT), itemStackOf(RUBlocks.SILT_FARMLAND)), "silt_farmland");
    }

    private void buildCraftingRecipes() {
        buildCustomCraftingRecipes();
    }

    private void buildCrusherRecipes() {
        addCrusherRecipe(ingredientOf(RUBlocks.MOSSY_STONE), itemStackOf(Items.MOSSY_COBBLESTONE),
                "mossy_stone");

        addCrusherRecipe(ingredientOf(RUBlocks.CHALK_BRICKS, RUBlocks.POLISHED_CHALK,
                        RUBlocks.CHALK_PILLAR), itemStackOf(RUBlocks.CHALK),
                "chalk_variants");
    }

    private void buildSawmillRecipes() {
        addSawmillRecipe(ingredientOf(RUItemTags.BRANCHES), itemStackOf(Items.STICK, 6), 1,
                getItemName(Items.STICK), "_branches");

        List<SawmillWoodSet> woodSets = Arrays.asList(
                new SawmillWoodSet("baobab", RUBlocks.BAOBAB_WOOD_SET, RUItemTags.BAMBOO_LOGS),
                new SawmillWoodSet("blackwood", RUBlocks.BLACKWOOD_WOOD_SET, RUItemTags.BLACKWOOD_LOGS),
                new SawmillWoodSet("cypress", RUBlocks.CYPRESS_WOOD_SET, RUItemTags.CYPRESS_LOGS),
                new SawmillWoodSet("dead", RUBlocks.DEAD_WOOD_SET, RUItemTags.DEAD_LOGS),
                new SawmillWoodSet("eucalyptus", RUBlocks.EUCALYPTUS_WOOD_SET, RUItemTags.EUCALYPTUS_LOGS),
                new SawmillWoodSet("joshua", RUBlocks.JOSHUA_WOOD_SET, RUItemTags.JOSHUA_LOGS),
                new SawmillWoodSet("kapok", RUBlocks.KAPOK_WOOD_SET, RUItemTags.KAPOK_LOGS),
                new SawmillWoodSet("larch", RUBlocks.LARCH_WOOD_SET, RUItemTags.LARCH_LOGS),
                new SawmillWoodSet("magnolia", RUBlocks.MAGNOLIA_WOOD_SET, RUItemTags.MAGNOLIA_LOGS),
                new SawmillWoodSet("maple", RUBlocks.MAPLE_WOOD_SET, RUItemTags.MAPLE_LOGS),
                new SawmillWoodSet("wisteria", RUBlocks.WISTERIA_WOOD_SET, RUItemTags.WISTERIA_LOGS),
                new SawmillWoodSet("palm", RUBlocks.PALM_WOOD_SET, RUItemTags.PALM_LOGS),
                new SawmillWoodSet("pine", RUBlocks.PINE_WOOD_SET, RUItemTags.PINE_LOGS),
                new SawmillWoodSet("redwood", RUBlocks.REDWOOD_WOOD_SET, RUItemTags.REDWOOD_LOGS),
                new SawmillWoodSet("socotra", RUBlocks.SOCOTRA_WOOD_SET, RUItemTags.SOCOTRA_LOGS),
                new SawmillWoodSet("willow", RUBlocks.WILLOW_WOOD_SET, RUItemTags.WILLOW_LOGS)
        );

        for(SawmillWoodSet woodSet:woodSets) {
            addBasicWoodSawmillRecipe(itemStackOf(woodSet.woodSet.getPlanks()),
                    ingredientOf(woodSet.logsTag), ingredientOf(woodSet.woodSet.getFence()),
                    ingredientOf(woodSet.woodSet.getFenceGate()), ingredientOf(woodSet.woodSet.getDoor()),
                    ingredientOf(woodSet.woodSet.getTrapdoor()), ingredientOf(woodSet.woodSet.getPressurePlate()),
                    ingredientOf(woodSet.woodSet.getSign()), ingredientOf(woodSet.woodSet.getBoat()),
                    ingredientOf(woodSet.woodSet.getChestBoat()),
                    false, woodSet.woodType);
        }

        List<SawmillWoodSet> woodSetsBioshrooms = Arrays.asList(
                new SawmillWoodSet("blue_bioshroom", RUBlocks.BLUE_BIOSHROOM_WOOD_SET, RUItemTags.BLUE_BIOSHROOM_LOGS),
                new SawmillWoodSet("green_bioshroom", RUBlocks.GREEN_BIOSHROOM_WOOD_SET, RUItemTags.GREEN_BIOSHROOM_LOGS),
                new SawmillWoodSet("pink_bioshroom", RUBlocks.PINK_BIOSHROOM_WOOD_SET, RUItemTags.PINK_BIOSHROOM_LOGS),
                new SawmillWoodSet("yellow_bioshroom", RUBlocks.YELLOW_BIOSHROOM_WOOD_SET, RUItemTags.YELLOW_BIOSHROOM_LOGS)
        );

        for(SawmillWoodSet woodSet:woodSetsBioshrooms) {
            addSawmillRecipe(ingredientOf(woodSet.logsTag),
                    itemStackOf(woodSet.woodSet.getPlanks(), 6),
                    1, woodSet.woodType + "_planks", woodSet.woodType + "_stems");

            addBasicWoodWithoutLogsAndBoatsSawmillRecipe(itemStackOf(woodSet.woodSet.getPlanks()),
                    ingredientOf(woodSet.woodSet.getFence()), ingredientOf(woodSet.woodSet.getFenceGate()),
                    ingredientOf(woodSet.woodSet.getDoor()), ingredientOf(woodSet.woodSet.getTrapdoor()),
                    ingredientOf(woodSet.woodSet.getPressurePlate()), ingredientOf(woodSet.woodSet.getSign()),
                    woodSet.woodType);
        }

        List<SawmillWoodSet> woodSetsWithoutBoat = Arrays.asList(
                new SawmillWoodSet("brimwood", RUBlocks.BRIMWOOD_WOOD_SET, RUItemTags.BRIMWOOD_LOGS),
                new SawmillWoodSet("cobalt", RUBlocks.COBALT_WOOD_SET, RUItemTags.COBALT_LOGS)
        );

        for(SawmillWoodSet woodSet:woodSetsWithoutBoat) {
            addSawmillRecipe(ingredientOf(woodSet.logsTag),
                    itemStackOf(woodSet.woodSet.getPlanks(), 6),
                    1, woodSet.woodType + "_planks", woodSet.woodType + "_logs");

            addBasicWoodWithoutLogsAndBoatsSawmillRecipe(itemStackOf(woodSet.woodSet.getPlanks()),
                    ingredientOf(woodSet.woodSet.getFence()), ingredientOf(woodSet.woodSet.getFenceGate()),
                    ingredientOf(woodSet.woodSet.getDoor()), ingredientOf(woodSet.woodSet.getTrapdoor()),
                    ingredientOf(woodSet.woodSet.getPressurePlate()), ingredientOf(woodSet.woodSet.getSign()),
                    woodSet.woodType);
        }

        addSawmillRecipe(ingredientOf(RUBlocks.ALPHA_WOOD_SET.getLog()),
                itemStackOf(RUBlocks.ALPHA_WOOD_SET.getPlanks(), 6), 1,
                getItemName(RUBlocks.ALPHA_WOOD_SET.getPlanks()), "alpha_logs");
    }

    private void buildPlantGrowthChamberRecipes() {
        addBasicFlowerGrowingRecipe(RUBlocks.ASTER, "aster");
        addBasicFlowerGrowingRecipe(RUBlocks.BLEEDING_HEART, "beleeding_heart");
        addBasicFlowerGrowingRecipe(RUBlocks.DAISY, "daisy");
        addBasicFlowerGrowingRecipe(RUBlocks.DORCEL, "dorcel");
        addBasicFlowerGrowingRecipe(RUBlocks.FELICIA_DAISY, "felicia_daisy");
        addBasicFlowerGrowingRecipe(RUBlocks.FIREWEED, "fireweed");
        addBasicFlowerGrowingRecipe(RUBlocks.GLISTERING_BLOOM, "glistering_bloom");
        addBasicFlowerGrowingRecipe(RUBlocks.HIBISCUS, "hibiscus");
        addBasicFlowerGrowingRecipe(RUBlocks.HYSSOP, "hyssop");
        addBasicFlowerGrowingRecipe(RUBlocks.MALLOW, "mallow");
        addBasicFlowerGrowingRecipe(RUBlocks.POPPY_BUSH, "poppy_bush");
        addBasicFlowerGrowingRecipe(RUBlocks.SALMON_POPPY_BUSH, "salmon_poppy_bush");
        addBasicFlowerGrowingRecipe(RUBlocks.TSUBAKI, "tsubaki");
        addBasicFlowerGrowingRecipe(RUBlocks.WARATAH, "waratah");
        addBasicFlowerGrowingRecipe(RUBlocks.WHITE_TRILLIUM, "white_trillium");
        addBasicFlowerGrowingRecipe(RUBlocks.WILTING_TRILLIUM, "wilting_trillium");
        addBasicFlowerGrowingRecipe(RUBlocks.BLUE_LUPINE, "blue_lupine");
        addBasicFlowerGrowingRecipe(RUBlocks.PINK_LUPINE, "pink_lupine");
        addBasicFlowerGrowingRecipe(RUBlocks.PURPLE_LUPINE, "purple_lupine");
        addBasicFlowerGrowingRecipe(RUBlocks.RED_LUPINE, "red_lupine");
        addBasicFlowerGrowingRecipe(RUBlocks.YELLOW_LUPINE, "yellow_lupine");
        addBasicFlowerGrowingRecipe(RUBlocks.COBALT_EARLIGHT, "cobalt_earlight");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getWhite(), "white_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getLightGray(), "light_gray_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getGray(), "gray_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getRed(), "red_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getOrange(), "orange_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getYellow(), "yellow_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getLime(), "lime_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getGreen(), "green_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getCyan(), "cyan_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getLightBlue(), "light_blue_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getBlue(), "blue_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getPurple(), "purple_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getMagenta(), "magenta_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getPink(), "pink_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getBrown(), "brown_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.SNOWBELLES.getBlack(), "black_snowbelle");
        addBasicFlowerGrowingRecipe(RUBlocks.CAVE_HYSSOP, "cave_hyssop");

        addBasicFlowerGrowingRecipe(RUBlocks.ALPHA_ROSE, "alpha_rose");
        addBasicFlowerGrowingRecipe(RUBlocks.ALPHA_DANDELION, "alpha_dandelion");

        addBasicFlowerGrowingRecipe(RUBlocks.BARLEY, "barley");
        addBasicFlowerGrowingRecipe(RUBlocks.CATTAIL, "cattail");
        addBasicFlowerGrowingRecipe(RUBlocks.DAY_LILY, "day_lily");
        addBasicFlowerGrowingRecipe(RUBlocks.MEADOW_SAGE, "meadow_sage");
        addBasicFlowerGrowingRecipe(RUBlocks.TASSEL, "tassel");
        addBasicFlowerGrowingRecipe(RUBlocks.GLISTER_BULB, "glister_bulb");
        addBasicFlowerGrowingRecipe(RUBlocks.GLISTER_SPIRE, "glister_spire");
        addBasicFlowerGrowingRecipe(RUBlocks.MYCOTOXIC_DAISY, "mycotoxic_daisy");
        addBasicFlowerGrowingRecipe(RUBlocks.TALL_COBALT_EARLIGHT, "tall_cobalt_earlight");

        addPlantGrowthChamberRecipe(ingredientOf(RUBlocks.CLOVER), new OutputItemStackTemplateWithPercentages[] {
                new OutputItemStackTemplateWithPercentages(itemStackOf(RUBlocks.CLOVER), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "clover", "clover");

        addPlantGrowthChamberRecipe(ingredientOf(RUBlocks.ORANGE_CONEFLOWER), new OutputItemStackTemplateWithPercentages[] {
                new OutputItemStackTemplateWithPercentages(itemStackOf(RUBlocks.ORANGE_CONEFLOWER), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "orange_coneflower", "orange_coneflower");

        addPlantGrowthChamberRecipe(ingredientOf(RUBlocks.PURPLE_CONEFLOWER), new OutputItemStackTemplateWithPercentages[] {
                new OutputItemStackTemplateWithPercentages(itemStackOf(RUBlocks.PURPLE_CONEFLOWER), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "purple_coneflower", "pruple_coneflower");

        addPlantGrowthChamberRecipe(ingredientOf(RUBlocks.HYACINTH_FLOWERS), new OutputItemStackTemplateWithPercentages[] {
                new OutputItemStackTemplateWithPercentages(itemStackOf(RUBlocks.HYACINTH_FLOWERS), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000,  "hyacinth_flowers", "hyacinth_flowers");

        addPlantGrowthChamberRecipe(ingredientOf(RUBlocks.BLUE_MAGNOLIA_FLOWERS), new OutputItemStackTemplateWithPercentages[] {
                new OutputItemStackTemplateWithPercentages(itemStackOf(RUBlocks.BLUE_MAGNOLIA_FLOWERS), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000,  "blue_magnolia_flowers", "blue_magnolia_flowers");

        addPlantGrowthChamberRecipe(ingredientOf(RUBlocks.PINK_MAGNOLIA_FLOWERS), new OutputItemStackTemplateWithPercentages[] {
                new OutputItemStackTemplateWithPercentages(itemStackOf(RUBlocks.PINK_MAGNOLIA_FLOWERS), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "pink_magnolia_flowers", "pink_magnolia_flowers");

        addPlantGrowthChamberRecipe(ingredientOf(RUBlocks.WHITE_MAGNOLIA_FLOWERS), new OutputItemStackTemplateWithPercentages[] {
                new OutputItemStackTemplateWithPercentages(itemStackOf(RUBlocks.WHITE_MAGNOLIA_FLOWERS), new double[] {
                        1., 1., 1., .67, .33, .33, .15
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "white_magnolia_flowers", "white_magnolia_flowers");

        addPlantGrowthChamberRecipe(ingredientOf(RUItems.SALMONBERRY), new OutputItemStackTemplateWithPercentages[] {
                new OutputItemStackTemplateWithPercentages(itemStackOf(RUItems.SALMONBERRY), new double[] {
                        1., 1., .33, .17
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, "salmonberry", "salmonberry");
    }

    private void buildPlantGrowthChamberSoilRecipes() {
        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.PEAT_FARMLAND),
                EPSoilTypes.FARMLAND, 1.75, 0.75, 0.7, "peat_farmland");
        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.PEAT_DIRT),
                EPSoilTypes.DIRT, 1.15, 0.75, 0.9, "peat_dirt");
        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.PEAT_COARSE_DIRT),
                EPSoilTypes.COARSE_DIRT, 1.15, 1.0, 0.8, "peat_coarse_dirt");
        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.PEAT_GRASS_BLOCK),
                EPSoilTypes.GRASS, 1.3, 0.75, 0.9, "peat_grass");
        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.PEAT_PODZOL),
                EPSoilTypes.PODZOL, 1.5, 0.75, 0.9, "peat_podzol");
        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.PEAT_MUD),
                EPSoilTypes.MUD, 1.5, 0.35, 0.9, "peat_mud");


        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.SILT_FARMLAND),
                EPSoilTypes.FARMLAND, 1.25, 1.25, 1.0, "silt_farmland");
        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.SILT_DIRT),
                EPSoilTypes.DIRT, 0.75, 1.25, 1.1, "silt_dirt");
        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.SILT_COARSE_DIRT),
                EPSoilTypes.COARSE_DIRT, 0.75, 1.4, 1.0, "silt_coarse_dirt");
        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.SILT_GRASS_BLOCK),
                EPSoilTypes.GRASS, 0.9, 1.25, 1.1, "silt_grass");
        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.SILT_PODZOL),
                EPSoilTypes.PODZOL, 1.0, 1.25, 1.1, "silt_podzol");
        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.SILT_MUD),
                EPSoilTypes.MUD, 1.0, 0.75, 1.1, "silt_mud");

        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.ASHEN_DIRT),
                EPSoilTypes.GRASS, 1.15, 1.1, 0.75, "ashen_dirt");

        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.ALPHA_GRASS_BLOCK),
                EPSoilTypes.GRASS, 1.1, 1.0, 1.0, "alpha_grass");

        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.STONE_GRASS_BLOCK, RUBlocks.DEEPSLATE_GRASS_BLOCK, RUBlocks.ARGILLITE_GRASS_BLOCK, RUBlocks.CHALK_GRASS_BLOCK),
                EPSoilTypes.GRASS, 0.75, 2.0, 2.0, "stone_grass");

        addPlantGrowthChamberSoilRecipe(ingredientOf(RUBlocks.ARGILLITE, RUBlocks.CHALK),
                EPSoilTypes.STONE, 0.5, 2.0, 2.0, "stone");
    }
    private void addCustomCraftingRecipe(Supplier<? extends CustomRecipe> customRecipeFactory,
                                         String recipeIdString) {
        Identifier recipeId = Identifier.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, PATH_PREFIX + "crafting/" +
                recipeIdString);

        CustomRecipe recipe = customRecipeFactory.get();
        this.output.accept(getKey(recipeId), recipe, null);
    }

    private void addCrusherRecipe(Ingredient input, ItemStackTemplate output,
                                  String recipeIngredientName) {
        Identifier recipeId = Identifier.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, PATH_PREFIX + "crusher/" +
                getItemName(output.item().value()) + "_from_crushing_" + recipeIngredientName);

        CrusherRecipe recipe = new CrusherRecipe(output, input);
        this.output.accept(getKey(recipeId), recipe, null);
    }

    private void addBasicWoodSawmillRecipe(ItemStackTemplate planksItem,
                                           Ingredient logsInput, Ingredient fenceInput, Ingredient fenceGateInput,
                                           Ingredient doorInput, Ingredient trapdoorInput, Ingredient pressurePlateInput,
                                           Ingredient signInput, Ingredient boatInput,
                                           Ingredient chestBoatInput, boolean isRaft, String woodName) {
        addSawmillRecipe(logsInput, planksItem.withCount(6), 1, getItemName(planksItem.item().value()),
                woodName + "_logs");

        addBasicWoodWithoutLogsSawmillRecipe(planksItem, fenceInput, fenceGateInput, doorInput, trapdoorInput,
                pressurePlateInput, signInput, boatInput, chestBoatInput, isRaft, woodName);
    }
    private void addBasicWoodWithoutLogsSawmillRecipe(ItemStackTemplate planksItem,
                                                      Ingredient fenceInput, Ingredient fenceGateInput,
                                                      Ingredient doorInput, Ingredient trapdoorInput, Ingredient pressurePlateInput,
                                                      Ingredient signInput, Ingredient boatInput,
                                                      Ingredient chestBoatInput, boolean isRaft, String woodName) {
        addBasicWoodWithoutLogsAndBoatsSawmillRecipe(planksItem, fenceInput, fenceGateInput, doorInput,
                trapdoorInput, pressurePlateInput, signInput, woodName);

        addSawmillRecipe(boatInput, planksItem.withCount(4), 3, getItemName(planksItem.item().value()),
                woodName + (isRaft?"_raft":"_boat"));
        addSawmillRecipe(chestBoatInput, planksItem.withCount(5), 7, getItemName(planksItem.item().value()),
                woodName + (isRaft?"_chest_raft":"_chest_boat"));
    }
    private void addBasicWoodWithoutLogsAndBoatsSawmillRecipe(ItemStackTemplate planksItem,
                                                              Ingredient fenceInput, Ingredient fenceGateInput,
                                                              Ingredient doorInput, Ingredient trapdoorInput, Ingredient pressurePlateInput,
                                                              Ingredient signInput, String woodName) {
        addSawmillRecipe(fenceInput, planksItem, 2, getItemName(planksItem.item().value()),
                woodName + "_fence");
        addSawmillRecipe(fenceGateInput, planksItem.withCount(2), 3, getItemName(planksItem.item().value()),
                woodName + "_fence_gate");
        addSawmillRecipe(doorInput, planksItem, 3, getItemName(planksItem.item().value()),
                woodName + "_door");
        addSawmillRecipe(trapdoorInput, planksItem.withCount(2), 3, getItemName(planksItem.item().value()),
                woodName + "_trapdoor");
        addSawmillRecipe(pressurePlateInput, planksItem, 2, getItemName(planksItem.item().value()),
                woodName + "_pressure_plate");
        addSawmillRecipe(signInput, planksItem.withCount(2), 1, getItemName(planksItem.item().value()),
                woodName + "_sign");
    }
    private void addSawmillRecipe(Ingredient input, ItemStackTemplate output,
                                  int sawdustAmount, String outputName, String recipeIngredientName) {
        Identifier recipeId = Identifier.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, PATH_PREFIX + "sawmill/" +
                outputName + "_from_sawing_" + recipeIngredientName);

        SawmillRecipe recipe = new SawmillRecipe(output, input, sawdustAmount);
        this.output.accept(getKey(recipeId), recipe, null);
    }

    private void addBasicFlowerGrowingRecipe(Supplier<? extends ItemLike> flowerItem,
                                             String outputName) {
        addBasicFlowerGrowingRecipe(flowerItem.get(), outputName);
    }
    private void addBasicFlowerGrowingRecipe(ItemLike flowerItem,
                                             String outputName) {
        addPlantGrowthChamberRecipe(ingredientOf(flowerItem), new OutputItemStackTemplateWithPercentages[] {
                new OutputItemStackTemplateWithPercentages(itemStackOf(flowerItem.asItem()), new double[] {
                        1., 1., .33
                })
        }, EPSoilTypeTags.FLOWERS, Fluids.WATER, 0.0625, 4000, outputName, getItemName(flowerItem));
    }
    private void addPlantGrowthChamberRecipe(Ingredient input,
                                             OutputItemStackTemplateWithPercentages[] outputs,
                                             TagKey<SoilType> soilType,
                                             Fluid fluid, double fluidConsumption, int ticks,
                                             String outputName, String recipeIngredientName) {
        addPlantGrowthChamberRecipe(input, outputs, soilType, new Fluid[] {fluid}, fluidConsumption, ticks, outputName, recipeIngredientName);
    }
    private void addPlantGrowthChamberRecipe(Ingredient input,
                                             OutputItemStackTemplateWithPercentages[] outputs,
                                             TagKey<SoilType> soilType,
                                             Fluid[] fluid, double fluidConsumption, int ticks,
                                             String outputName, String recipeIngredientName) {
        addPlantGrowthChamberRecipe(input, outputs, soilType, Arrays.asList(fluid), fluidConsumption, ticks, outputName, recipeIngredientName);
    }
    private void addPlantGrowthChamberRecipe(Ingredient input,
                                             OutputItemStackTemplateWithPercentages[] outputs,
                                             TagKey<SoilType> soilType,
                                             List<Fluid> fluid, double fluidConsumption, int ticks,
                                             String outputName, String recipeIngredientName) {
        addPlantGrowthChamberRecipe(input, outputs, soilType, FluidIngredient.of(fluid), fluidConsumption, ticks, outputName, recipeIngredientName);
    }
    private void addPlantGrowthChamberRecipe(Ingredient input,
                                             OutputItemStackTemplateWithPercentages[] outputs,
                                             TagKey<SoilType> soilType,
                                             TagKey<Fluid> fluid, double fluidConsumption, int ticks,
                                             String outputName, String recipeIngredientName) {
        addPlantGrowthChamberRecipe(input, outputs, soilType, FluidIngredient.of(fluid), fluidConsumption, ticks, outputName, recipeIngredientName);
    }
    private void addPlantGrowthChamberRecipe(Ingredient input,
                                             OutputItemStackTemplateWithPercentages[] outputs,
                                             TagKey<SoilType> soilType,
                                             FluidIngredient fluid, double fluidConsumption, int ticks,
                                             String outputName, String recipeIngredientName) {
        addPlantGrowthChamberRecipe(input, outputs, SoilTypeIngredient.of(soilType), fluid, fluidConsumption, ticks, outputName, recipeIngredientName);
    }
    private void addPlantGrowthChamberRecipe(Ingredient input,
                                             OutputItemStackTemplateWithPercentages[] outputs,
                                             SoilTypeIngredient soilType,
                                             FluidIngredient fluid, double fluidConsumption, int ticks,
                                             String outputName, String recipeIngredientName) {
        Identifier recipeId = Identifier.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, PATH_PREFIX + "growing/" +
                outputName + "_from_growing_" + recipeIngredientName);

        PlantGrowthChamberRecipe recipe = new PlantGrowthChamberRecipe(outputs, input, soilType, fluid, fluidConsumption, ticks);
        this.output.accept(getKey(recipeId), recipe, null);
    }

    private void addPlantGrowthChamberSoilRecipe(Ingredient input,
                                                 ResourceKey<SoilType> soilType,
                                                 double speedMultiplier,
                                                 double fluidConsumptionMultiplier, double energyConsumptionMultiplier,
                                                 String recipeIngredientName) {
        Identifier recipeId = Identifier.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, PATH_PREFIX + "growing/soil/" +
                recipeIngredientName);

        PlantGrowthChamberSoilRecipe recipe = new PlantGrowthChamberSoilRecipe(input, soilType,
                speedMultiplier, fluidConsumptionMultiplier, energyConsumptionMultiplier);
        this.output.accept(getKey(recipeId), recipe, null);
    }

    private Ingredient ingredientOf(Supplier<? extends ItemLike> item) {
        return Ingredient.of(item.get());
    }

    @SafeVarargs
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
        return Ingredient.of(registries.lookupOrThrow(Registries.ITEM).getOrThrow(tagKey));
    }

    private ItemStackTemplate itemStackOf(ItemLike item) {
        return new ItemStackTemplate(item.asItem());
    }

    private ItemStackTemplate itemStackOf(ItemLike item, int count) {
        return new ItemStackTemplate(item.asItem(), count);
    }

    private ItemStackTemplate itemStackOf(Supplier<? extends ItemLike> item) {
        return new ItemStackTemplate(item.get().asItem());
    }

    private ItemStackTemplate itemStackOf(Supplier<? extends ItemLike> item, int count) {
        return new ItemStackTemplate(item.get().asItem(), count);
    }

    private static ResourceKey<Recipe<?>> getKey(Identifier recipeId) {
        return ResourceKey.create(Registries.RECIPE, recipeId);
    }

    private record SawmillWoodSet(String woodType, WoodSet woodSet, TagKey<Item> logsTag) {}
}
