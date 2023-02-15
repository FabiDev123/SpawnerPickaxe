package de.fabidev.spawnerPickaxe;

import de.fabidev.spawnerPickaxe.commands.XPBottlesCommand;
import de.fabidev.spawnerPickaxe.commands.spickCommand;
import de.fabidev.spawnerPickaxe.listeners.spawnerBreakListener;
import de.fabidev.spawnerPickaxe.utils.PickaxeUtil;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class SpawnerPickaxe extends JavaPlugin {

    public static PickaxeUtil pu;

    public static int wahrscheinlichkeit;

    public static SpawnerPickaxe sp;

    @Override
    public void onEnable(){
        sp = this;
        loadCommands();
        loadListeners();
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        wahrscheinlichkeit = getConfig().getInt("wahrscheinlichkeit");
        ArrayList<String> lore = new ArrayList<>();

        String name = getConfig().getString("name");
        String lore1 = getConfig().getString("lore1");
        String lore2 = getConfig().getString("lore2");
        String lore3 = getConfig().getString("lore3");


        lore.add(lore1.replace('&', '§'));
        lore.add(lore2.replace('&', '§'));
        lore.add(lore3.replace('&', '§'));

        pu = new PickaxeUtil(Material.getMaterial(getConfig().getString("material")), name.replace('&', '§'), lore);

    }

    public void reloadPickaxe(){
        reloadConfig();
        wahrscheinlichkeit = getConfig().getInt("wahrscheinlichkeit");
        ArrayList<String> lore = new ArrayList<>();

        String name = getConfig().getString("name");
        String lore1 = getConfig().getString("lore1");
        String lore2 = getConfig().getString("lore2");
        String lore3 = getConfig().getString("lore3");

        lore.add(lore1.replace('&', '§'));
        lore.add(lore2.replace('&', '§'));
        lore.add(lore3.replace('&', '§'));

        pu = new PickaxeUtil(Material.getMaterial(getConfig().getString("material")), name.replace('&', '§'), lore);
    }

    @Override
    public void onDisable(){

    }




    public void loadCommands(){
        this.getCommand("xpbottles").setExecutor(new XPBottlesCommand());
        this.getCommand("spick").setExecutor(new spickCommand());
    }

    public void loadListeners(){
        this.getServer().getPluginManager().registerEvents(new spawnerBreakListener(), this);
    }


}
