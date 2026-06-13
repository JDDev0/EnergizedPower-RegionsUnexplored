package me.jddev0.epru.integration.rei;

import me.jddev0.epru.recipe.PeatFarmlandCraftingRecipe;
import me.jddev0.epru.recipe.SiltFarmlandCraftingRecipe;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.forge.REIPluginClient;
import me.shedaniel.rei.plugin.common.displays.crafting.DefaultCraftingDisplay;
import me.shedaniel.rei.plugincompatibilities.api.REIPluginCompatIgnore;
import net.minecraft.core.NonNullList;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.regions_unexplored.block.RuBlocks;

import java.util.Optional;

@REIPluginClient
@REIPluginCompatIgnore
public class EnergizedPowerRUREIPlugin implements REIClientPlugin {
    @Override
    public String getPluginProviderName() {
        return "EnergizedPower RU";
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        //Add aether farmland special crafting recipe if loaded
        {
            Optional<RecipeHolder<CraftingRecipe>> recipeOptional = registry.getRecipeManager().getAllRecipesFor(RecipeType.CRAFTING).stream().
                    filter(recipe -> recipe.value() instanceof PeatFarmlandCraftingRecipe).findFirst();
            if(recipeOptional.isPresent()) {
                ShapelessRecipe recipe = new ShapelessRecipe("", CraftingBookCategory.MISC, new ItemStack(RuBlocks.PEAT_FARMLAND.get()),
                        NonNullList.of(null, new Ingredient[] {
                                Ingredient.of(ItemTags.HOES),
                                Ingredient.of(RuBlocks.PEAT_DIRT.get())
                        }));

                registry.add(DefaultCraftingDisplay.of(new RecipeHolder(recipeOptional.get().id(), recipe)));
            }
        }
        {
            Optional<RecipeHolder<CraftingRecipe>> recipeOptional = registry.getRecipeManager().getAllRecipesFor(RecipeType.CRAFTING).stream().
                    filter(recipe -> recipe.value() instanceof SiltFarmlandCraftingRecipe).findFirst();
            if(recipeOptional.isPresent()) {
                ShapelessRecipe recipe = new ShapelessRecipe("", CraftingBookCategory.MISC, new ItemStack(RuBlocks.SILT_FARMLAND.get()),
                        NonNullList.of(null, new Ingredient[] {
                                Ingredient.of(ItemTags.HOES),
                                Ingredient.of(RuBlocks.SILT_DIRT.get())
                        }));

                registry.add(DefaultCraftingDisplay.of(new RecipeHolder(recipeOptional.get().id(), recipe)));
            }
        }
    }
}
