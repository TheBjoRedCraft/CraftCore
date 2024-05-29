package dev.thebjoredcraft.craftcore.manager.emergency;


import dev.thebjoredcraft.craftcore.CraftCore;
import org.bukkit.OfflinePlayer;

public class Emergency {
    private OfflinePlayer player;
    private String reason;

    public Emergency(){
        this.player = null;
        this.reason = null;

        CraftCore.getEmergencyManager().isEmergency = true;
    }

    public OfflinePlayer getPlayer() {
        return player;
    }

    public String getReason() {
        return reason;
    }

    public void setPlayer(OfflinePlayer player) {
        this.player = player;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public void delete(){
        CraftCore.getEmergencyManager().isEmergency = false;
    }
}
