package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.util.message.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 0) {
                player.setFoodLevel(20);
                Messenger.send("command.feed.feed", player);
                Messenger.sendToOps("command.feed.op", player);
            }else{
                Player target = Bukkit.getPlayer(args[0]);

                if(target != null){
                    target.setFoodLevel(20);

                    Messenger.send("command.feed.feed", target);
                    Messenger.send("command.feed.target.target", player);

                    Messenger.sendToOps("command.feed.target.op", player, target);
                }else{
                    Messenger.send("command.not_found.target", player);
                }
            }
        }
        return false;
    }
}
