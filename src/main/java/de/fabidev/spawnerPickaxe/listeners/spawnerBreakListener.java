package de.fabidev.spawnerPickaxe.listeners;

import de.fabidev.spawnerPickaxe.SpawnerPickaxe;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class spawnerBreakListener implements Listener {


    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if (e.getBlock().getType() == Material.SPAWNER){
            if(e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.SILK_TOUCH) == 10){
                int min=0;
                int max = SpawnerPickaxe.wahrscheinlichkeit;
                int result = (int)(Math.random()*(max-min+1));
                if(result == 1){
                    e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.SPAWNER));
                    e.getPlayer().sendMessage("§aHerzlichen Glückwunsch, dir wurde ein Spawner gedroppt!");
                    e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0f, 1.0f);
                }else {
                    e.getPlayer().sendMessage("§4Leider nichts");
                    e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_GHAST_DEATH, 1.0f, 1.0f);
                }
            }
        }
    }




}
