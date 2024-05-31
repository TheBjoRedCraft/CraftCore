package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.manager.message.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand  implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if (args.length == 0) {
                player.setHealth(20);
                Messenger.send("command.heal.heal", player);
                Messenger.sendToOps("command.heal.op", player);
            }else{
                Player target = Bukkit.getPlayer(args[0]);

                if(target != null){
                    target.setHealth(20);
                    Messenger.send("command.heal.heal", target);
                    Messenger.send("command.heal.target.target", player, target);
                    Messenger.send("command.heal.target.op", player, target);
                }else{
                    Messenger.send("command.not_found.target", player);
                }
            }
        }
        return false;
    }
}
