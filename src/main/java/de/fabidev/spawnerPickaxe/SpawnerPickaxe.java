package de.fabidev.spawnerPickaxe;

import de.fabidev.spawnerPickaxe.commands.XPBottlesCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnerPickaxe extends JavaPlugin {

    @Override
    public void onEnable(){
        loadCommands();
        loadListeners();
    }

    @Override
    public void onDisable(){

    }




    public void loadCommands(){
        this.getCommand("xpbottles").setExecutor(new XPBottlesCommand());
    }

    public void loadListeners(){

    }


}
