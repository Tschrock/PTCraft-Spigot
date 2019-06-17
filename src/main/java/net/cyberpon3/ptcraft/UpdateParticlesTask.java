package net.cyberpon3.ptcraft;

import org.bukkit.scheduler.BukkitRunnable;

public class UpdateParticlesTask extends BukkitRunnable {

    private final PtCraft plugin;

    public UpdateParticlesTask(PtCraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        this.plugin.particleService.processPlayerParticles();

    }

}
