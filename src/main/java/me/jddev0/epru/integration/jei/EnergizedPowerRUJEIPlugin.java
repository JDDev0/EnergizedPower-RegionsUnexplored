package me.jddev0.epru.integration.jei;

import me.jddev0.epru.EnergizedPowerRUMod;
import me.jddev0.epru.recipe.PeatFarmlandCraftingRecipe;
import me.jddev0.epru.recipe.SiltFarmlandCraftingRecipe;
import me.shedaniel.rei.plugincompatibilities.api.REIPluginCompatIgnore;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.regions_unexplored.block.RuBlocks;

import java.util.Arrays;
import java.util.Optional;

@JeiPlugin
@REIPluginCompatIgnore
public class EnergizedPowerRUJEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(EnergizedPowerRUMod.MODID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        //Add aether farmland special crafting recipe if loaded
        {
            Optional<RecipeHolder<CraftingRecipe>> recipeOptional = recipeManager.getAllRecipesFor(RecipeType.CRAFTING).stream().
                    filter(recipe -> recipe.value() instanceof PeatFarmlandCraftingRecipe).findFirst();
            if(recipeOptional.isPresent()) {
                ShapelessRecipe recipe = new ShapelessRecipe("", CraftingBookCategory.MISC, new ItemStack(RuBlocks.PEAT_FARMLAND.get()),
                        NonNullList.of(null, new Ingredient[] {
                                Ingredient.of(ItemTags.HOES),
                                Ingredient.of(RuBlocks.PEAT_DIRT.get())
                        }));

                registration.addRecipes(RecipeTypes.CRAFTING, Arrays.asList(new RecipeHolder(recipeOptional.get().id(), recipe)));
            }
        }
        {
            Optional<RecipeHolder<CraftingRecipe>> recipeOptional = recipeManager.getAllRecipesFor(RecipeType.CRAFTING).stream().
                    filter(recipe -> recipe.value() instanceof SiltFarmlandCraftingRecipe).findFirst();
            if(recipeOptional.isPresent()) {
                ShapelessRecipe recipe = new ShapelessRecipe("", CraftingBookCategory.MISC, new ItemStack(RuBlocks.SILT_FARMLAND.get()),
                        NonNullList.of(null, new Ingredient[] {
                                Ingredient.of(ItemTags.HOES),
                                Ingredient.of(RuBlocks.SILT_DIRT.get())
                        }));

                registration.addRecipes(RecipeTypes.CRAFTING, Arrays.asList(new RecipeHolder(recipeOptional.get().id(), recipe)));
            }
        }
    }
}
