package net.cyberpon3.ptcraft;

import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PtParticleService {


    private final PtCraft plugin;


    public PtParticleService(PtCraft plugin) {
        this.plugin = plugin;
    }


    private final ConcurrentMap<UUID, Set<Particle>> activePlayerParticles = new ConcurrentHashMap<>();


    public void addPlayerParticle(UUID playerUUID, Particle particle) {
        activePlayerParticles.compute(
                playerUUID,
                (k, v) -> {

                    if (v == null) v = new HashSet<>();

                    v.add(particle);

                    return v;

                }
        );
    }


    public void removePlayerParticle(UUID playerUUID, Particle particle) {
        activePlayerParticles.compute(
                playerUUID,
                (k, v) -> {
                    if (v == null) return null;

                    v.remove(particle);

                    return v.isEmpty() ? null : v;
                }
        );
    }


    public void togglePlayerParticle(UUID playerUUID, Particle particle) {
        activePlayerParticles.compute(
                playerUUID,
                (k, v) -> {

                    if (v == null) v = new HashSet<>();

                    if (v.contains(particle)) {
                        v.remove(particle);
                    } else {
                        v.add(particle);
                    }

                    return v.isEmpty() ? null : v;

                }
        );
    }


    public void clearPlayerParticles(UUID playerUUID) {
        activePlayerParticles.remove(playerUUID);
    }


    public void processPlayerParticles() {

        for (Map.Entry<UUID, Set<Particle>> playerParticles : activePlayerParticles.entrySet()) {

            UUID playerUUID = playerParticles.getKey();
            Set<Particle> particles = playerParticles.getValue();

            Player player = plugin.getServer().getPlayer(playerUUID);

            if (player == null || !player.isOnline()) {

                clearPlayerParticles(playerUUID);

            } else {

                for (Particle particle : particles) {
                    player.getWorld().spawnParticle(particle, player.getEyeLocation(), 1, 0.4, 0.5, 0.4);
                }

            }

        }

    }


}
