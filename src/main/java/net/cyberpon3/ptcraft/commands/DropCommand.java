package net.cyberpon3.ptcraft.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.cyberpon3.ptcraft.PtCraft;
import org.bukkit.inventory.ItemStack;

public class DropCommand extends PtCraftCommand {

    public DropCommand(PtCraft plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            player.getInventory().setItemInMainHand(new ItemStack(Material.AIR, 0));

        }

        return true;
    }

}
