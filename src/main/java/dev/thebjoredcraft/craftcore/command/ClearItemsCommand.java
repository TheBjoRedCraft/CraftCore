package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.util.message.Messenger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearItemsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            int index = 0;
            for(Entity entity : player.getWorld().getEntities()){
                if(entity.getType().equals(EntityType.DROPPED_ITEM)){
                    player.getWorld().getEntities().remove(entity);
                    index ++;

                    Messenger.send("command.clearitems.clearitems", player, index);
                    Messenger.sendToOps("command.clearitems.clearitems.op", player, index);
                }
            }
        }
        return false;
    }
}
