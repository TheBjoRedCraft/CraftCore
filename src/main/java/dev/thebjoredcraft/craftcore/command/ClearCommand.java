package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.manager.message.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.getInventory().clear();
                Messenger.send("command.clear.clear", player);
                Messenger.sendToOps("command.clear.clear.op", player);
            } else {
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    target.getInventory().clear();
                    Messenger.send("command.clear.clear", target);
                    Messenger.sendToOps("command.clear.clear.op.target", player, target);
                } else {
                    Messenger.send("command.not_found.target", player);
                }
            }
        }
        return false;
    }
}
