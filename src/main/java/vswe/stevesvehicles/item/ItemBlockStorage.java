package vswe.stevesvehicles.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vswe.stevesvehicles.Constants;
import vswe.stevesvehicles.block.StorageBlock;
import vswe.stevesvehicles.tab.CreativeTabLoader;

public class ItemBlockStorage extends ItemBlock {
	public static StorageBlock[] blocks;

	public static void init() {
		blocks = new StorageBlock[] { new StorageBlock(0, "reinforced_metal", ComponentTypes.REINFORCED_METAL.getItemStack()), new StorageBlock(1, "galgadorian", ComponentTypes.GALGADORIAN_METAL.getItemStack()),
				new StorageBlock(2, "enhanced_galgadorian", ComponentTypes.ENHANCED_GALGADORIAN_METAL.getItemStack()), };
	}

	public static void loadRecipes() {
		for (StorageBlock block : blocks) {
			block.loadRecipe();
		}
	}

	// public IIcon[] icons;
	public ItemBlockStorage(Block block) {
		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
		setCreativeTab(CreativeTabLoader.blocks);
	}

	/*
	 * @Override
	 * @SideOnly(Side.CLIENT) public IIcon getIconFromDamage(int dmg) { dmg %=
	 * icons.length; return icons[dmg]; }
	 * @Override
	 * @SideOnly(Side.CLIENT) public void registerIcons(IIconRegister register)
	 * { icons = new IIcon[blocks.length]; for (int i = 0; i < icons.length;
	 * i++) { icons[i] =
	 * register.registerIcon(StevesVehicles.instance.textureHeader + ":storage/"
	 * + blocks[i].getName()); } }
	 */
	public String getName(ItemStack item) {
		if (item == null) {
			return "Unknown";
		} else {
			int dmg = item.getItemDamage();
			dmg %= blocks.length;
			return blocks[dmg].getName();
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack item) {
		if (item != null && item.getItemDamage() >= 0 && item.getItemDamage() < blocks.length) {
			StorageBlock block = blocks[item.getItemDamage()];
			return "steves_vehicles:tile.metal_storage:" + block.getName();
		}
		return Constants.UNKNOWN_ITEM;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, NonNullList items) {
		for (int i = 0; i < blocks.length; i++) {
			items.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int getMetadata(int dmg) {
		return dmg;
	}
}
