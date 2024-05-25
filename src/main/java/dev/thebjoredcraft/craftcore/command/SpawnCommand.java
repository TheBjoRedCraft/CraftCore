package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.util.message.Messenger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            player.teleport(player.getWorld().getSpawnLocation());

            Messenger.send("command.spawn.spawn", player);
            Messenger.sendToOps("command.spawn.op", player);
        }
        return false;
    }
}
