package dev.thebjoredcraft.craftcore.listener;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        event.quitMessage(MiniMessage.miniMessage().deserialize("<red><< <gray>" + event.getPlayer().getName()));
    }
}
