package dev.thebjoredcraft.craftcore.manager;

import dev.thebjoredcraft.craftcore.CraftCore;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class PlayerManager {
    public void addPlayer(OfflinePlayer player, Player executer){
        DataManager manager = CraftCore.getDataManager();

        if(!manager.getFileConfig().getStringList("players").contains(player.getUniqueId().toString())){
            manager.getFileConfig().set("players", manager.getFileConfig().getStringList("players").add(player.getUniqueId().toString()));
        }
    }
}
