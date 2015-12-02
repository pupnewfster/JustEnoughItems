package mezz.jei.gui.ingredients;

import javax.annotation.Nonnull;
import java.util.List;

import net.minecraft.item.ItemStack;

import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.util.StackUtil;

public class GuiItemStackGroup extends GuiIngredientGroup<ItemStack, GuiIngredient<ItemStack>> implements IGuiItemStackGroup {
	private static final int baseWidth = 16;
	private static final int baseHeight = 16;
	private static final ItemStackRenderer renderer = new ItemStackRenderer();
	private static final ItemStackHelper helper = new ItemStackHelper();

	public static int getWidth(int padding) {
		return baseWidth + (2 * padding);
	}

	public static int getHeight(int padding) {
		return baseHeight + (2 * padding);
	}

	public static GuiIngredient<ItemStack> createGuiItemStack(boolean input, int xPosition, int yPosition, int padding) {
		return new GuiIngredient<>(renderer, helper, input, xPosition, yPosition, getWidth(padding), getHeight(padding), padding);
	}

	@Override
	public void setFromRecipe(int slotIndex, @Nonnull List ingredients) {
		set(slotIndex, StackUtil.toItemStackList(ingredients));
	}

	@Override
	public void init(int slotIndex, boolean input, int xPosition, int yPosition) {
		init(slotIndex, input, xPosition, yPosition, 1);
	}

	public void init(int index, boolean input, int xPosition, int yPosition, int padding) {
		GuiIngredient<ItemStack> guiIngredient = createGuiItemStack(input, xPosition, yPosition, padding);
		guiIngredients.put(index, guiIngredient);
	}
}
