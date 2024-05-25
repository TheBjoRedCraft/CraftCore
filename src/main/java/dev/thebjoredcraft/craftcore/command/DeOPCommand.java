package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.util.message.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DeOPCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 1){
                OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

                target.setOp(false);

                Messenger.send("command.deop.deop", player, target);
                Messenger.sendToOps("command.deop.deop.op.target", player, target);
            }
        }
        return false;
    }
}
