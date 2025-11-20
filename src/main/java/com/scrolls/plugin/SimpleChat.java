package com.scrolls.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class SimpleChat extends JavaPlugin {
    @Override
    public void onEnable() {
         saveDefaultConfig();
         getServer().getPluginManager().registerEvents(new ChatFormatter(this), this);
         getCommand("bracket").setExecutor(new BracketCommand(this));
         getLogger().info("SimpleChat plugin enabled");
         getLogger().info("Bracket style: " + getConfig().getString("bracket-style", "none"));
    }

    @Override
    public void onDisable() {
        getLogger().info("SimpleChat plugin disabled");
    }
}