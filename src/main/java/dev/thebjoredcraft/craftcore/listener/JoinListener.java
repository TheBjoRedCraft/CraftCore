package dev.thebjoredcraft.craftcore.listener;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.joinMessage(MiniMessage.miniMessage().deserialize("<green>>> <gray>" + event.getPlayer().getName()));
    }
}
