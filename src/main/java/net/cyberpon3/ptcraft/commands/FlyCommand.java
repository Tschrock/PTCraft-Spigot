package net.cyberpon3.ptcraft.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.cyberpon3.ptcraft.PtCraft;

public class FlyCommand extends PtCraftCommand {

    public FlyCommand(PtCraft plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Location location = player.getLocation();

            location.setY(location.getY() + 1.5);

            player.teleport(location);

            player.setFlying(!player.isFlying());

        }

        return true;
    }

}
