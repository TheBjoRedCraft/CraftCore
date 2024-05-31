package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.manager.message.Messenger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            player.getWorld().setTime(1000);

            Messenger.send("command.day.day", player);
            Messenger.sendToOps("command.day.op", player);
        }
        return false;
    }
}
