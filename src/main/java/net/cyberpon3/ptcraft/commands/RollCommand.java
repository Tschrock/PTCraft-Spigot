package net.cyberpon3.ptcraft.commands;

import net.cyberpon3.ptcraft.MessageChannel;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.cyberpon3.ptcraft.PtCraft;

import java.util.concurrent.ThreadLocalRandom;

public class RollCommand extends PtCraftCommand {

    public RollCommand(PtCraft plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            int rollStart = 0;
            int rollEnd = 100;

            boolean showRange = false;

            if(args.length == 1) {


                String[] arg1parts = args[0].split("-");

                if(arg1parts.length == 2) {

                    int parsedStart = parseIntOrDefault(arg1parts[0], -1);

                    if(parsedStart >= 0) {

                        int parsedEnd = parseIntOrDefault(arg1parts[1], -1);

                        if(parsedEnd >= 0) {

                            rollStart = parsedStart;
                            rollEnd = parsedEnd;

                            if(rollStart > rollEnd) {
                                rollEnd = rollStart;
                            }

                            showRange = true;

                        }


                    }

                }
                else if(arg1parts.length == 1) {

                    int parsedEnd = parseIntOrDefault(arg1parts[0], -1);

                    if(parsedEnd >= 0) {

                        rollEnd = parsedEnd;

                    }
                }

            }

            int result = ThreadLocalRandom.current().nextInt(rollStart, rollEnd + 1);

            String message;

            if(showRange ) {
                message = String.format("⚄ rolled %d of %d-%d", result, rollStart, rollEnd);
            }
            else {
                message = String.format("⚄ rolled %d of %d", result, rollEnd);
            }

            this.plugin.messageService.sendChatMessage(player, message, ChatColor.GOLD, MessageChannel.LOCAL);

        }

        return true;
    }

    private static int parseIntOrDefault(String input, @SuppressWarnings("SameParameterValue") int defaultValue) {
        try {
            return Integer.parseInt(input, 10);
        }
        catch (NumberFormatException ex) {
            return defaultValue;
        }
    }

}
