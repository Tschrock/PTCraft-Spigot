package net.cyberpon3.ptcraft.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.cyberpon3.ptcraft.PtCraft;

public class TurnCommand extends PtCraftCommand {

    public TurnCommand(PtCraft plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Location currentLocation = player.getLocation();

            currentLocation.setYaw(currentLocation.getYaw() - 180);

            player.teleport(currentLocation);

        }

        return true;
    }

}
