package de.fabidev.spawnerPickaxe.commands;

import de.fabidev.spawnerPickaxe.utils.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class XPBottlesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            //Code für XP Bottles
            Player p = (Player) sender;
            if(p.hasPermission(Strings.permissionXP)){
                
            }else {
                p.sendMessage(Strings.noPermissionXP);
            }


        }else {
            System.out.println(Strings.notForConsole);
        }


        return false;
    }
}
