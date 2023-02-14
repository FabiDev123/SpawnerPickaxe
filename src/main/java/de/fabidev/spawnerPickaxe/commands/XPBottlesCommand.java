package de.fabidev.spawnerPickaxe.commands;

import de.fabidev.spawnerPickaxe.utils.Strings;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class XPBottlesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            //Code für XP Bottles
            Player p = (Player) sender;
            if (p.hasPermission(Strings.permissionXP)) {
                if (p.getInventory().firstEmpty() != -1) {
                    if (args.length == 1) {
                        int anzahl;
                        try {
                            anzahl = Integer.valueOf(args[0]);
                            if (anzahl >= 1 && anzahl <= 64) {
                                if (p.getLevel() >= anzahl) {
                                    ItemStack isXP = new ItemStack(Material.EXPERIENCE_BOTTLE, anzahl);
                                    p.getInventory().addItem(isXP);
                                    p.setLevel(p.getLevel() - anzahl);
                                    p.sendMessage("§a§lDir wurden erfolgreich " + anzahl + " XP-Bottles ausgezahlt!");
                                } else {
                                    p.sendMessage(Strings.notenoughLevels);
                                }
                            } else {
                                p.sendMessage(Strings.falseint);
                            }
                        } catch (Exception ex) {
                            p.sendMessage(Strings.falseint);
                        }
                    } else {
                        p.sendMessage(Strings.usageXP);
                    }
                } else {
                    p.sendMessage(Strings.noSpaceinInventory);
                }
            } else {
                p.sendMessage(Strings.noPermissionXP);
            }
        } else {
            System.out.println(Strings.notForConsole);
        }
        return false;
    }
}
