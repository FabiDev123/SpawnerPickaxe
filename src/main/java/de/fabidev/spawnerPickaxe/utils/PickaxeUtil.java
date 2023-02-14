package de.fabidev.spawnerPickaxe.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;

import java.util.ArrayList;

public class PickaxeUtil {

    ItemStack isPick;

    public PickaxeUtil(Material material, String name, ArrayList subtext){

        isPick = new ItemStack(material, 1);
        ItemMeta imPick = isPick.getItemMeta();
        imPick.setDisplayName(name);
        imPick.setLore(subtext);

        Repairable repairable = (Repairable)imPick;
        repairable.setRepairCost(1000);

        isPick.setItemMeta(repairable);

        Short dura = 100;
        isPick.setDurability((short) (isPick.getType().getMaxDurability()-dura));

        isPick.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 10);






    }

    public ItemStack getIsPick(){
        return isPick;
    }




}
