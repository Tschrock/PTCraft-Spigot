package net.cyberpon3.ptcraft;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class BubbleUtils {

    private BubbleUtils() { }

    /**
     * Adds a message bubble above an entity.
     * @param entity The entity
     * @param message The message
     * @param messageColor The color to make the message
     * @param duration The duration of the bubble
     */
    public static void addMessageBubble(Entity entity, String message, ChatColor messageColor, int duration) {

        // Clear any existing bubbles
        clearMessageBubble(entity);

        // Gather location info
        World world = entity.getWorld();
        Location location = entity.getLocation().clone();
        location.setY(0);

        // Get the message lines
        String[] lines = splitMessageLines(message, 50);

        // Limit messages to 5 lines
        int linesToShow = Math.min( lines.length, 5);

        // Now to create the message stack

        // We'll start with the original entity
        Entity lastLine = entity;

        // Loop through the lines from bottom to top
        for (int i = linesToShow - 1; i >= 0; i--) {

            // Create the next line
            Entity nextLine = createMessageBubbleLine(world, location, messageColor + lines[i], duration);

            // Add it as a passenger of the last line
            lastLine.addPassenger(nextLine);

            // Make it the new last line
            lastLine = nextLine;

        }


    }

    /**
     * Clears the message bubble from an entity.
     * @param entity The entity
     */
    public static void clearMessageBubble(Entity entity) {

        // Loop through all passengers
        for (Entity passenger : entity.getPassengers()) {

            // Check if the passenger is an AreaEffectCloud
            if(passenger instanceof AreaEffectCloud) {

                // Remove the passenger from the entity
                entity.removePassenger(passenger);

                // Remove any of it's messages
                clearMessageBubble(passenger);

                // Remove the passenger from the world
                passenger.remove();

            }

        }

    }

    /**
     * Creates a new message bubble line as an in-world entity.
     * @param world The world
     * @param spawnLocation The spawn location
     * @param message The message
     * @param duration The duration
     * @return The new message entity
     */
    public static Entity createMessageBubbleLine(World world, Location spawnLocation, String message, int duration) {

        // Create an AreaEffectCloud to hold our message
        AreaEffectCloud effectCloud = (AreaEffectCloud) world.spawnEntity(spawnLocation, EntityType.AREA_EFFECT_CLOUD);

        // Make it mostly inactive
        effectCloud.setParticle(Particle.TOWN_AURA);
        effectCloud.setRadius(0);
        effectCloud.setWaitTime(0);

        // Set the message
        effectCloud.setCustomName(message);
        effectCloud.setCustomNameVisible(true);

        // Set the message duration
        effectCloud.setDuration(duration);

        // Return the cloud
        return effectCloud;

    }

    /**
     * Splits a string into multiple lines based on length.
     * @param message The string
     * @param maxLength The maximum line length
     * @return An array of strings
     */
    public static String[] splitMessageLines(String message, int maxLength) {

        // Save the message length
        int messageLength = message.length();

        // Calculate how many lines we'll need
        int neededLines = calculateNeededParts(messageLength, maxLength);

        // Create something to store the results
        String[] results = new String[neededLines];

        // For each line
        for (int i = 0; i < neededLines; i++) {

            // Calculate the character offsets
            int firstCharacter = i * maxLength;
            int maxLastCharacter = (i + 1) * maxLength;
            int lastCharacter = Math.min(messageLength, maxLastCharacter);

            // Get the substring
            results[i] = message.substring(firstCharacter, lastCharacter);

        }

        return results;

    }

    /**
     * Calculates the duration, in ticks, that a message bubble should last
     * @param minimumTicks The minimum number of ticks
     * @param ticksPerCharacter The number of ticks per character
     * @param messageLength The number of characters
     * @param maximumTicks The maximum number of ticks
     * @return The number of ticks the message should last
     */
    public static int calculateMessageDuration(int minimumTicks, int ticksPerCharacter, int messageLength, int maximumTicks) {
        return Math.max(Math.min(ticksPerCharacter * messageLength, maximumTicks), minimumTicks);
    }

    /**
     * Calculates the number of parts needed.
     * @param total The total number of items
     * @param maxPerPart The maximum number of items per part
     * @return The parts needed
     */
    private static int calculateNeededParts(int total, int maxPerPart) {
        return (int) Math.ceil( (double) total / (double) maxPerPart );
    }

}
