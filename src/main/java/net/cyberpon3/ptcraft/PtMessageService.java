package net.cyberpon3.ptcraft;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

public class PtMessageService {

    private final PtCraft plugin;

    public PtMessageService(PtCraft plugin) {
        this.plugin = plugin;
    }

    /**
     * Sends a chat message using the PtCraft messaging system.
     * @param sender The message sender
     * @param message The message
     * @param messageColor The message color
     * @param messageChannel The message channel
     */
    public void sendChatMessage(Player sender, String message, ChatColor messageColor, MessageChannel messageChannel) {

        // If it's not party chat, show the chat bubble
        if(messageChannel != MessageChannel.PARTY) {

            // Calculate the bubble duration
            int bubbleDuration = BubbleUtils.calculateMessageDuration(80, 1, message.length(), 300);

            // Create a task to show the bubble and schedule it
            new ShowMessageBubbleTask(sender, message, messageColor, bubbleDuration).runTaskLater(this.plugin, 0);

        }

        // Send the message through the right channel
        switch (messageChannel) {

            case GLOBAL:

                sender.getServer().broadcastMessage(String.format("%s[Global] %s[%s]%s: %s%s", ChatColor.WHITE, ChatColor.GRAY, sender.getDisplayName(), ChatColor.WHITE, messageColor, message));

                break;

            case LOCAL:

                broadcastMessageToNearby(sender, String.format("%s[Local] %s[%s]%s: %s%s", ChatColor.WHITE, ChatColor.GRAY, sender.getDisplayName(), ChatColor.WHITE, messageColor, message));

                break;

            case THINK:

                broadcastMessageToNearby(sender, String.format("%s[Local] %s[%s] thinks%s: %s%s", ChatColor.WHITE, ChatColor.GRAY, sender.getDisplayName(), ChatColor.WHITE, messageColor, message));

                break;

            case PARTY:
            default:

                break;

        }

    }

    private void broadcastMessageToNearby(Player player, String message) {

        // Get nearby entities
        List<Entity> entities = player.getNearbyEntities(50,50,50);

        // For each nearby entity
        for (Entity entity : entities) {

            // If it's a player
            if(entity instanceof Player) {
                Player nearbyPlayer = (Player) entity;

                // Send the message to the player
                nearbyPlayer.sendMessage(message);

            }

        }

        // Mirror the message back to the sender
        player.sendMessage(message);

    }

}
