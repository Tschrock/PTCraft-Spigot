package net.cyberpon3.ptcraft.commands;

import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.cyberpon3.ptcraft.PtCraft;

public class LoveCommand extends PtCraftCommand {

    public LoveCommand(PtCraft plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            this.plugin.particleService.togglePlayerParticle(player.getUniqueId(), Particle.HEART);

        }

        return true;
    }

}
