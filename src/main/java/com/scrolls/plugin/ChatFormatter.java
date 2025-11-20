package com.scrolls.plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormatter implements Listener {
  private final SimpleChat plugin;

  public chatFormatter(SimpleChat plugin) {
    this.plugin = plugin;
  }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        String bracketStyle = plugin.getConfig().getString("bracket-style", "none");
        String formattedMessage = formatMessage(player, message, bracketStyle);

        event.setFormat(formattedMessage);
    }

    private String formatMessage(Player player, String message, String bracketStyle) {
        String playerName = player.getName();
        
        return switch (bracketStyle) {
            case "angle" -> "<" + playerName + "> " + message;
            case "square" -> "[" + playerName + "] " + message;
            case "curly" -> "{" + playerName + "} " + message;
            case "none" -> playerName + ": " + message;
            default -> playerName + ": " + message;
        };
    }
}