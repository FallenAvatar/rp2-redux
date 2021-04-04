package fallenavatar.rp2_redux.core.util.managers;

import cofh.lib.fluid.IFluidStackAccess;
import cofh.lib.inventory.FalseIInventory;
import cofh.lib.inventory.IItemStackAccess;
import cofh.lib.inventory.ItemStorageCoFH;
import cofh.lib.util.ComparableItemStack;
import cofh.thermal.lib.util.managers.AbstractManager;
import cofh.thermal.lib.util.managers.IRecipeManager;
import cofh.thermal.lib.util.recipes.IThermalInventory;
import cofh.thermal.lib.util.recipes.ThermalCatalyst;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import cofh.thermal.lib.util.recipes.internal.*;
import fallenavatar.rp2_redux.core.init.RP2RecipeTypes;
import fallenavatar.rp2_redux.core.util.recipes.RP2Recipe;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.*;

import static java.util.Arrays.asList;
import static cofh.lib.util.helpers.ItemHelper.itemsEqual;

public class AlloyFurnaceRecipeManager extends AbstractManager implements IRecipeManager {

	private static final AlloyFurnaceRecipeManager INSTANCE = new AlloyFurnaceRecipeManager();
	protected static final int DEFAULT_ENERGY = 3200;

	protected Object2ObjectOpenHashMap<AlloyFurnaceMapWrapper, IMachineRecipe> recipeMap = new Object2ObjectOpenHashMap<>();
	protected Set<ComparableItemStack> validItems = new ObjectOpenHashSet<>();

	protected int maxInputItems;
	protected int maxOutputItems;

	public static AlloyFurnaceRecipeManager instance() {
		return INSTANCE;
	}

	private AlloyFurnaceRecipeManager() {
		super(DEFAULT_ENERGY);
		this.maxInputItems = 9;
		this.maxOutputItems = 1;
	}

	public void addRecipe(RP2Recipe recipe, BaseMachineRecipe.RecipeType type) {
		switch (recipe.getInputItems().size()) {
		case 1:
			for (ItemStack firstInput : recipe.getInputItems().get(0).getMatchingStacks()) {
				addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.singletonList(firstInput),
						recipe.getOutputItems(), type);
			}
			return;
		case 2:
			for (ItemStack firstInput : recipe.getInputItems().get(0).getMatchingStacks()) {
				for (ItemStack secondInput : recipe.getInputItems().get(1).getMatchingStacks()) {
					addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput),
							recipe.getOutputItems(), type);
				}
			}
			return;
		case 3:
			for (ItemStack firstInput : recipe.getInputItems().get(0).getMatchingStacks()) {
				for (ItemStack secondInput : recipe.getInputItems().get(1).getMatchingStacks()) {
					for (ItemStack thirdInput : recipe.getInputItems().get(2).getMatchingStacks()) {
						addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput, thirdInput),
								recipe.getOutputItems(), type);
					}
				}
			}
			return;
		case 4:
			for (ItemStack input1 : recipe.getInputItems().get(0).getMatchingStacks()) {
				for (ItemStack input2 : recipe.getInputItems().get(1).getMatchingStacks()) {
					for (ItemStack input3 : recipe.getInputItems().get(2).getMatchingStacks()) {
						for (ItemStack input4 : recipe.getInputItems().get(3).getMatchingStacks()) {
							addRecipe(recipe.getEnergy(), recipe.getXp(), asList(input1, input2, input3, input4),
									recipe.getOutputItems(), type);
						}
					}
				}
			}
			return;
		case 5:
			for (ItemStack input1 : recipe.getInputItems().get(0).getMatchingStacks()) {
				for (ItemStack input2 : recipe.getInputItems().get(1).getMatchingStacks()) {
					for (ItemStack input3 : recipe.getInputItems().get(2).getMatchingStacks()) {
						for (ItemStack input4 : recipe.getInputItems().get(3).getMatchingStacks()) {
							for (ItemStack input5 : recipe.getInputItems().get(4).getMatchingStacks()) {
								addRecipe(recipe.getEnergy(), recipe.getXp(),
										asList(input1, input2, input3, input4, input5), recipe.getOutputItems(), type);
							}
						}
					}
				}
			}
			return;
		case 6:
			for (ItemStack input1 : recipe.getInputItems().get(0).getMatchingStacks()) {
				for (ItemStack input2 : recipe.getInputItems().get(1).getMatchingStacks()) {
					for (ItemStack input3 : recipe.getInputItems().get(2).getMatchingStacks()) {
						for (ItemStack input4 : recipe.getInputItems().get(3).getMatchingStacks()) {
							for (ItemStack input5 : recipe.getInputItems().get(4).getMatchingStacks()) {
								for (ItemStack input6 : recipe.getInputItems().get(5).getMatchingStacks()) {
									addRecipe(recipe.getEnergy(), recipe.getXp(),
											asList(input1, input2, input3, input4, input5, input6),
											recipe.getOutputItems(), type);
								}
							}
						}
					}
				}
			}
			return;
		case 7:
			for (ItemStack input1 : recipe.getInputItems().get(0).getMatchingStacks()) {
				for (ItemStack input2 : recipe.getInputItems().get(1).getMatchingStacks()) {
					for (ItemStack input3 : recipe.getInputItems().get(2).getMatchingStacks()) {
						for (ItemStack input4 : recipe.getInputItems().get(3).getMatchingStacks()) {
							for (ItemStack input5 : recipe.getInputItems().get(4).getMatchingStacks()) {
								for (ItemStack input6 : recipe.getInputItems().get(5).getMatchingStacks()) {
									for (ItemStack input7 : recipe.getInputItems().get(6).getMatchingStacks()) {
										addRecipe(recipe.getEnergy(), recipe.getXp(),
												asList(input1, input2, input3, input4, input5, input6, input7),
												recipe.getOutputItems(), type);
									}
								}
							}
						}
					}
				}
			}
			return;
		case 8:
			for (ItemStack input1 : recipe.getInputItems().get(0).getMatchingStacks()) {
				for (ItemStack input2 : recipe.getInputItems().get(1).getMatchingStacks()) {
					for (ItemStack input3 : recipe.getInputItems().get(2).getMatchingStacks()) {
						for (ItemStack input4 : recipe.getInputItems().get(3).getMatchingStacks()) {
							for (ItemStack input5 : recipe.getInputItems().get(4).getMatchingStacks()) {
								for (ItemStack input6 : recipe.getInputItems().get(5).getMatchingStacks()) {
									for (ItemStack input7 : recipe.getInputItems().get(6).getMatchingStacks()) {
										for (ItemStack input8 : recipe.getInputItems().get(7).getMatchingStacks()) {
											addRecipe(
													recipe.getEnergy(), recipe.getXp(), asList(input1, input2, input3,
															input4, input5, input6, input7, input8),
													recipe.getOutputItems(), type);
										}
									}
								}
							}
						}
					}
				}
			}
			return;
		case 9:
			for (ItemStack input1 : recipe.getInputItems().get(0).getMatchingStacks()) {
				for (ItemStack input2 : recipe.getInputItems().get(1).getMatchingStacks()) {
					for (ItemStack input3 : recipe.getInputItems().get(2).getMatchingStacks()) {
						for (ItemStack input4 : recipe.getInputItems().get(3).getMatchingStacks()) {
							for (ItemStack input5 : recipe.getInputItems().get(4).getMatchingStacks()) {
								for (ItemStack input6 : recipe.getInputItems().get(5).getMatchingStacks()) {
									for (ItemStack input7 : recipe.getInputItems().get(6).getMatchingStacks()) {
										for (ItemStack input8 : recipe.getInputItems().get(7).getMatchingStacks()) {
											for (ItemStack input9 : recipe.getInputItems().get(8).getMatchingStacks()) {
												addRecipe(
														recipe.getEnergy(), recipe.getXp(), asList(input1, input2,
																input3, input4, input5, input6, input7, input8, input9),
														recipe.getOutputItems(), type);
											}
										}
									}
								}
							}
						}
					}
				}
			}
			return;
		default:
		}
	}

	public boolean validItem(ItemStack item) {
		return validItems.contains(convert(item));
	}

	public boolean isValid(ItemStack item, int idx, ItemStorageCoFH[] slots) {
		for (int i = 0; i < slots.length; i++) {
			if (i != idx) {
				if (!slots[1].getItemStack().isEmpty() && itemsEqual(item, slots[1].getItemStack()))
					return false;
			}
		}

		return validItem(item);
	}

	protected void clear() {
		recipeMap.clear();
		validItems.clear();
	}

	// region RECIPES
	protected IMachineRecipe getRecipe(List<? extends IItemStackAccess> inputSlots, List<? extends IFluidStackAccess> inputTanks) {
		if (inputSlots.isEmpty()) {
			return null;
		}
		List<ComparableItemStack> convertedItems = new ArrayList<>(maxInputItems);
		for (int i = 0; i < maxInputItems; ++i) {
			if (!inputSlots.get(i).isEmpty()) {
				ComparableItemStack compStack = convert(inputSlots.get(i).getItemStack());
				convertedItems.add(compStack);
			}
		}
		if (convertedItems.isEmpty()) {
			return null;
		}
		return recipeMap.get(new AlloyFurnaceMapWrapper(convertedItems));
	}

	protected IMachineRecipe addRecipe(int energy, float experience, List<ItemStack> inputItems, List<ItemStack> outputItems, BaseMachineRecipe.RecipeType type) {
		if (inputItems.isEmpty() || outputItems.isEmpty() || outputItems.size() > maxOutputItems || energy <= 0) {
			return null;
		}
		for (ItemStack stack : inputItems) {
			if (stack.isEmpty()) {
				return null;
			}
		}
		for (ItemStack stack : outputItems) {
			if (stack.isEmpty()) {
				return null;
			}
		}
		energy = (int) (energy * getDefaultScale());

		List<ComparableItemStack> convertedItems = new ArrayList<>(inputItems.size());
		for (ItemStack stack : inputItems) {
			if (!stack.isEmpty()) {
				ComparableItemStack compStack = convert(stack);
				validItems.add(compStack);
				convertedItems.add(compStack);
			}
		}
		IMachineRecipe recipe = new InternalAlloyFurnaceRecipe(energy, experience, inputItems, outputItems);
		recipeMap.put(new AlloyFurnaceMapWrapper(convertedItems), recipe);
		return recipe;
	}
	// endregion

	// region IRecipeManager
	@Override
	public IMachineRecipe getRecipe(IThermalInventory inventory) {
		return getRecipe(inventory.inputSlots(), inventory.inputTanks());
	}

	@Override
	public List<IMachineRecipe> getRecipeList() {
		return new ArrayList<>(recipeMap.values());
	}
	// endregion

	// region IManager
	@Override
	public void config() {

	}

	@Override
	public void refresh(RecipeManager recipeManager) {

		clear();
		Map<ResourceLocation, IRecipe<FalseIInventory>> recipes = recipeManager
				.getRecipes(RP2RecipeTypes.RECIPE_ALLOY_FURNACE);
		for (Map.Entry<ResourceLocation, IRecipe<FalseIInventory>> entry : recipes.entrySet()) {
			addRecipe((RP2Recipe) entry.getValue(), BaseMachineRecipe.RecipeType.STANDARD);
		}
	}
	// endregion

	// region WRAPPER CLASS
	protected static class AlloyFurnaceMapWrapper {

		Set<Integer> itemHashes;
		int hashCode;

		AlloyFurnaceMapWrapper(List<ComparableItemStack> itemStacks) {

			this.itemHashes = new ObjectOpenHashSet<>(itemStacks.size());
			for (ComparableItemStack itemStack : itemStacks) {
				if (itemStack.hashCode() != 0) {
					this.itemHashes.add(itemStack.hashCode());
					hashCode += itemStack.hashCode();
				}
			}
		}

		@Override
		public boolean equals(Object o) {

			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			AlloyFurnaceMapWrapper that = (AlloyFurnaceMapWrapper) o;
			return itemHashes.size() == that.itemHashes.size() && itemHashes.containsAll(that.itemHashes);
		}

		@Override
		public int hashCode() {

			return hashCode;
		}

	}
	// endregion

	// region CATALYZED RECIPE
	protected static class InternalAlloyFurnaceRecipe extends BaseMachineRecipe {

		public InternalAlloyFurnaceRecipe(int energy, float experience, @Nullable List<ItemStack> inputItems,
				@Nullable List<ItemStack> outputItems) {

			super(energy, experience, inputItems, new ArrayList<FluidStack>(), outputItems, new ArrayList<Float>(),
					new ArrayList<FluidStack>());
		}

	}
	// endregion
}