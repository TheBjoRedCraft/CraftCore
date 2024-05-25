package dev.thebjoredcraft.craftcore.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class DamageListener implements Listener {
    public static List<Player> gods = new ArrayList<>();

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player player){
            if(gods.contains(player)){
                event.setCancelled(true);
            }
        }
    }
}
