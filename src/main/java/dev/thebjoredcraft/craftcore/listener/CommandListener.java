package dev.thebjoredcraft.craftcore.listener;

import dev.thebjoredcraft.craftcore.manager.message.Messenger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        String command = event.getMessage();
        Player player = event.getPlayer();

        if(command.equalsIgnoreCase("/plugins" ) || command.equalsIgnoreCase("/pl")){
            if(!player.hasPermission("craftcore.command.plugins.bypass")){
                Messenger.send("command.plugins.block", player);

                event.setCancelled(true);
            }
        }else if(command.equalsIgnoreCase("/version" ) || command.equalsIgnoreCase("/ver")){
            if(!player.hasPermission("craftcore.command.version.bypass")){
                Messenger.send("command.plugins.version", player);

                event.setCancelled(true);
            }
        }
    }
}
