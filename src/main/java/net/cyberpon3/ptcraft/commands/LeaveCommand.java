package net.cyberpon3.ptcraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.cyberpon3.ptcraft.PtCraft;

public class LeaveCommand extends PtCraftCommand {

    public LeaveCommand(PtCraft plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            player.kickPlayer("You've left the game");

        }

        return true;
    }

}
