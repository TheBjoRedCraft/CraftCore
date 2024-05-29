package dev.thebjoredcraft.craftcore.manager;

import dev.thebjoredcraft.craftcore.CraftCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanishManager {
    private final List<Player> vanished = new ArrayList<>();

    public void hide(Player player){
        vanished.add(player);

        update();
    }
    public void show(Player player){
        vanished.remove(player);

        update();
    }
    public boolean isVanished(Player player){
        return vanished.contains(player);
    }
    public void update() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (Player vanishedPlayer : vanished) {
                if (!player.hasPermission("craftcore.vanish.bypass")) {
                    player.hidePlayer(CraftCore.getInstance(), vanishedPlayer);
                } else {
                    player.showPlayer(CraftCore.getInstance(), vanishedPlayer);
                }
            }

            for (Player visiblePlayer : Bukkit.getOnlinePlayers()) {
                if (!vanished.contains(visiblePlayer)) {
                    player.showPlayer(CraftCore.getInstance(), visiblePlayer);
                }
            }
        }
    }
}
