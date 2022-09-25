package ovh.rootkovskiy.timaspit;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("TimaSpit Enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("TimaSpit Disabled");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spit") && sender instanceof Player) {
            Player player = (Player)sender;
            if (player.hasPermission("spit.use")) {
                Location location = player.getLocation().toVector().add(player.getLocation().getDirection().multiply(0.8D)).toLocation(player.getWorld()).add(0.0D, 1.0D, 0.0D);
                Entity spitmonster = player.getWorld().spawnEntity(location, EntityType.LLAMA_SPIT);
                spitmonster.setVelocity(player.getEyeLocation().getDirection().multiply(1));
            } else {
                player.sendMessage(ChatColor.RED + "Сори, но у тебя нет права на харчки");
            }
        }

        return false;
    }
}
