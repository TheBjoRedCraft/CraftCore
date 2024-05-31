package dev.thebjoredcraft.craftcore.manager.emergency;

import dev.thebjoredcraft.craftcore.CraftCore;
import dev.thebjoredcraft.craftcore.manager.message.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class EmergencyManager {
    public Emergency emergency;
    public boolean isEmergency = false;

    public void handle(Player player, String reason){
        int kicked = 0;

        for(Player online : Bukkit.getOnlinePlayers()){
            if(!online.hasPermission("craftcore.emergency.bypass")){
                online.kick(Messenger.message("command.emergency.kick", player, reason));
                kicked ++;
            }
        }
        Messenger.send("command.emergency.kicked", player, kicked);
        Messenger.sendToOps("command.emergency.op.kicked", player, kicked);
        CraftCore.getDiscord().send("## `Notfall`\n ### **Ein Notfall wurde von** *" + player.getName() + "* **ausgelöst**! \nGrund: **" + reason + "**");
    }
    public void create(Player player, String reason){
        Emergency emergency = new Emergency();
        this.emergency = emergency;

        emergency.setPlayer(player);
        emergency.setReason(reason);

        CraftCore.getEmergencyManager().handle(player, reason);
    }

    public Emergency getEmergency() {
        return emergency;
    }
}
