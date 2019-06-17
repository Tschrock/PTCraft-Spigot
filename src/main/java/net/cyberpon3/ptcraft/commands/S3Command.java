package net.cyberpon3.ptcraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.cyberpon3.ptcraft.PtCraft;
import net.cyberpon3.ptcraft.MessageChannel;

public class S3Command extends PtCraftCommand {

    public S3Command(PtCraft plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            this.plugin.messageService.sendChatMessage(player, String.join(" ", args), ChatColor.YELLOW, MessageChannel.LOCAL);

        }

        return true;

    }

}
