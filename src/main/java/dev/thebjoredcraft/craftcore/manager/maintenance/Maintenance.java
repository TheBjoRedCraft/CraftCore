package dev.thebjoredcraft.craftcore.manager.maintenance;

import dev.thebjoredcraft.craftcore.manager.message.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Maintenance {
    private String reason;
    private Player player;
    private boolean active;

    public Maintenance(){
        this.reason = "Undefined";
        this.player = null;
        this.active = false;
    }
    public int kickPlayers(){
        int count = 0;
        for(Player target : Bukkit.getOnlinePlayers()){
            if(!target.hasPermission("craftcore.command.maintenance.bypass")){
                count ++;
                target.kick(Messenger.message("command.maintenance.kick", this.getReason()));
            }
        }
        return count;
    }

    public boolean isActive() {
        return active;
    }

    public void enable(){
        this.active = true;
    }

    public void disable(){
        this.active = false;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getReason() {
        return reason;
    }

    public Player getPlayer() {
        return player;
    }
}
