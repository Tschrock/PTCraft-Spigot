package net.cyberpon3.ptcraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.cyberpon3.ptcraft.PtCraft;

public class HelpCommand extends PtCraftCommand {

    public HelpCommand(PtCraft plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            player.sendMessage(
                    "/help - show help\n"
                            + "/roll [[min-]max] - randomize a number\n"
                            + "/s - say\n"
                            + "/p - party chat\n"
                            + "/turn - turn head\n"
                            + "/drop - drop held item\n"
                            + "/unstuck - respawn at spawn point\n"
                            + "/leave - leave the game\n"
                            + "/fly - fly up or fly down\n"
            );

        }

        return true;
    }

}
