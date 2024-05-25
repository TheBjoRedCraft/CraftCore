package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.util.message.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if (args.length == 0) {
                if (player.getAllowFlight()) {
                    player.setFlying(false);
                    player.setAllowFlight(false);

                    Messenger.send("command.fly.off", player);
                    Messenger.sendToOps("command.fly.op.off", player);
                } else {
                    player.setAllowFlight(true);
                    player.setFlying(true);

                    Messenger.send("command.fly.on", player);
                    Messenger.sendToOps("command.fly.op.on", player);

                }
            }else{
                Player target = Bukkit.getPlayer(args[0]);

                if(target != null){
                    if (target.getAllowFlight()) {
                        target.setFlying(false);
                        target.setAllowFlight(false);

                        Messenger.send("command.fly.off", target);
                        Messenger.send("command.fly.off.target", player);
                        Messenger.sendToOps("command.fly.off.op.target", player, target);
                    } else {
                        target.setAllowFlight(true);
                        target.setFlying(true);

                        Messenger.send("command.fly.on", target);
                        Messenger.send("command.fly.on.target", player);
                        Messenger.sendToOps("command.fly.on.op.target", player, target);
                    }
                }else{
                    Messenger.send("command.not_found.target", player);
                }
            }
        }
        return false;
    }
}
