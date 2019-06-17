package net.cyberpon3.ptcraft.commands;

import net.cyberpon3.ptcraft.MessageChannel;
import net.cyberpon3.ptcraft.PtCraft;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ThinkCommand extends PtCraftCommand {

    public ThinkCommand(PtCraft plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            this.plugin.messageService.sendChatMessage(player, String.join(" ", args), ChatColor.GRAY, MessageChannel.THINK);

        }

        return true;

    }

}
