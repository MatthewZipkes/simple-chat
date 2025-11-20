package com.scrolls.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class BracketCommand implements CommandExecutor, TabCompleter {
    
    private final SimpleChat plugin;
    
    public BracketCommand(SimpleChat plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("simplechat.bracket")) {
            sender.sendMessage("§cYou don't have permission to use this command!");
            return true;
        }
        
        if (args.length == 0) {
            String current = plugin.getConfig().getString("bracket-style", "none");
            sender.sendMessage("§aCurrent bracket style: §f" + current);
            sender.sendMessage("§aAvailable styles: §fnone, angle, square, curly");
            return true;
        }
        
        String style = args[0].toLowerCase();
        
        if (!style.equals("none") && !style.equals("angle") && !style.equals("square") && !style.equals("curly")) {
            sender.sendMessage("§cInvalid style! Use: none, angle, square, or curly");
            return true;
        }
        
        plugin.getConfig().set("bracket-style", style);
        plugin.saveConfig();
        
        sender.sendMessage("§aBracket style changed to: §f" + style);
        sender.sendMessage("§eChanges will apply to new messages!");
        
        return true;
    }
    
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        
        if (args.length == 1) {
            completions.add("none");
            completions.add("angle");
            completions.add("square");
            completions.add("curly");
        }
        
        return completions;
    }
}