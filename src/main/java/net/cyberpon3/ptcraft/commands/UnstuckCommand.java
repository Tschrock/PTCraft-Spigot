package net.cyberpon3.ptcraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.cyberpon3.ptcraft.PtCraft;

public class UnstuckCommand extends PtCraftCommand {

    public UnstuckCommand(PtCraft plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            player.teleport(player.getWorld().getSpawnLocation());

        }

        return true;
    }

}
