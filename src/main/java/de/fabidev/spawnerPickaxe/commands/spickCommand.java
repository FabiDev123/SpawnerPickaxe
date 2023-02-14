package de.fabidev.spawnerPickaxe.commands;

import de.fabidev.spawnerPickaxe.SpawnerPickaxe;
import de.fabidev.spawnerPickaxe.utils.PickaxeUtil;
import de.fabidev.spawnerPickaxe.utils.Strings;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.fabidev.spawnerPickaxe.SpawnerPickaxe.pu;

public class spickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0) {
                if (p.hasPermission(Strings.permissionPickaxe)) {
                    p.getInventory().addItem(pu.getIsPick());
                } else {
                    p.sendMessage("§4§lKeine Rechte!");
                }
            }else if (args.length == 1){
                if (args[0].equalsIgnoreCase("reload")){
                    SpawnerPickaxe.sp.reloadPickaxe();
                    p.sendMessage("§aDie Pickaxe config wurde neu geladen!");
                }
            }

        }else {
            System.out.println(Strings.notForConsole);
        }


        return false;
    }
}
