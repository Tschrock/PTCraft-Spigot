package net.cyberpon3.ptcraft;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

public class ShowMessageBubbleTask extends BukkitRunnable {

    private final Entity entity;
    private final String message;
    private final ChatColor messageColor;
    private final int duration;

    public ShowMessageBubbleTask(Entity entity, String message, ChatColor messageColor, int duration) {
        this.entity = entity;
        this.message = message;
        this.messageColor = messageColor;
        this.duration = duration;
    }

    @Override
    public void run() {

        BubbleUtils.addMessageBubble(entity, message, messageColor, duration);

    }
}
