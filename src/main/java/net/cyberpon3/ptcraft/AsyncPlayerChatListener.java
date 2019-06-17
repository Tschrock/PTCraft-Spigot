package net.cyberpon3.ptcraft;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    private final PtCraft plugin;

    public AsyncPlayerChatListener(PtCraft plugin) {
        this.plugin = plugin;
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (!event.isCancelled()) {

            // Gather the event info
            Player player = event.getPlayer();
            String message = event.getMessage();

            // Forward the message to the PtChatService
            this.plugin.messageService.sendChatMessage(player, message, ChatColor.WHITE, MessageChannel.LOCAL);

            // Hide the default chat message
            event.setCancelled(true);

        }
    }

}
