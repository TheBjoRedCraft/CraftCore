package dev.thebjoredcraft.craftcore.listener;

import dev.thebjoredcraft.craftcore.CraftCore;
import dev.thebjoredcraft.craftcore.manager.message.Messenger;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.joinMessage(MiniMessage.miniMessage().deserialize("<green>>> <gray>" + event.getPlayer().getName()));

        CraftCore.getVanishManager().update();
    }
    @EventHandler
    public void onPreLogin(PlayerPreLoginEvent event){
        if(CraftCore.getEmergencyManager().isEmergency) {
            if (!CraftCore.getInstance().getConfig().getStringList("emergency.bypass").contains(event.getName())) {
                event.setResult(PlayerPreLoginEvent.Result.KICK_OTHER);
                event.kickMessage(Messenger.message("command.emergency.join", CraftCore.getEmergencyManager().getEmergency().getPlayer().getPlayer(), CraftCore.getEmergencyManager().getEmergency().getReason()));
            }
        }
        if(CraftCore.getMaintenance().isActive()) {
            if (!CraftCore.getInstance().getConfig().getStringList("maintenance.bypass").contains(event.getName())) {
                event.setResult(PlayerPreLoginEvent.Result.KICK_OTHER);
                event.kickMessage(Messenger.message("command.emergency.join", CraftCore.getMaintenance().getPlayer(), CraftCore.getMaintenance().getReason()));
            }
        }
    }
}
