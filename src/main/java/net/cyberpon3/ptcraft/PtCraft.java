package net.cyberpon3.ptcraft;

import net.cyberpon3.ptcraft.commands.*;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class PtCraft extends JavaPlugin {

    public final PtMessageService messageService = new PtMessageService(this);
    public final PtParticleService particleService = new PtParticleService(this);

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(this), this);

        tryRegisterCommand("admin", new AdminCommand(this));
        tryRegisterCommand("cry", new CryCommand(this));
        tryRegisterCommand("drop", new DropCommand(this));
        tryRegisterCommand("fly", new FlyCommand(this));
        tryRegisterCommand("help", new HelpCommand(this));
        tryRegisterCommand("leave", new LeaveCommand(this));
        tryRegisterCommand("love", new LoveCommand(this));
        tryRegisterCommand("mod", new ModCommand(this));
        tryRegisterCommand("party", new PartyCommand(this));
        tryRegisterCommand("roll", new RollCommand(this));
        tryRegisterCommand("s1", new S1Command(this));
        tryRegisterCommand("s2", new S2Command(this));
        tryRegisterCommand("s3", new S3Command(this));
        tryRegisterCommand("say", new SayCommand(this));
        tryRegisterCommand("ss", new SSCommand(this));
        tryRegisterCommand("think", new ThinkCommand(this));
        tryRegisterCommand("turn", new TurnCommand(this));
        tryRegisterCommand("unstuck", new UnstuckCommand(this));

        new UpdateParticlesTask(this).runTaskTimer(this, 10, 10);

    }

    private void tryRegisterCommand(String name, PtCraftCommand commandExecutor) {

        PluginCommand command = this.getCommand(name);

        if(command != null) {
            command.setExecutor(commandExecutor);
        }
        else {
            this.getLogger().warning(String.format("Failed to register '%s' command!", name));
        }

    }

}

