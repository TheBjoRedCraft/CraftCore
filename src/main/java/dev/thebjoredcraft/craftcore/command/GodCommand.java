package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.listener.DamageListener;
import dev.thebjoredcraft.craftcore.util.message.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if (args.length == 0) {
                if (DamageListener.gods.contains(player)) {
                    DamageListener.gods.remove(player);

                    Messenger.send("command.god.off", player);
                    Messenger.sendToOps("command.god.op.off", player);
                } else {
                    DamageListener.gods.add(player);

                    Messenger.send("command.god.on", player);
                    Messenger.sendToOps("command.god.op.on", player);

                }
            }else{
                Player target = Bukkit.getPlayer(args[0]);

                if(target != null){
                    if (DamageListener.gods.contains(target)) {
                        DamageListener.gods.remove(target);

                        Messenger.send("command.god.off", target);
                        Messenger.send("command.god.target.off", player);
                        Messenger.sendToOps("command.god.target.op.off", player, target);
                    } else {
                        DamageListener.gods.add(target);

                        Messenger.send("command.god.on", target);
                        Messenger.send("command.god.target.on", player);
                        Messenger.sendToOps("command.god.target.op.on", player, target);
                    }
                }else{
                    Messenger.send("command.not_found.target", player);
                }
            }
        }
        return false;
    }
}
