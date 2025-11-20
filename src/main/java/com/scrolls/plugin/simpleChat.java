package com.scrolls.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class simpleChat extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("SimpleChat plugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("SimpleChat plugin disabled");
    }
}