package net.cyberpon3.ptcraft.commands;

import net.cyberpon3.ptcraft.PtCraft;
import org.bukkit.command.CommandExecutor;

public abstract class PtCraftCommand implements CommandExecutor {

    protected final PtCraft plugin;

    public PtCraftCommand(PtCraft plugin) {
        this.plugin = plugin;
    }
}
