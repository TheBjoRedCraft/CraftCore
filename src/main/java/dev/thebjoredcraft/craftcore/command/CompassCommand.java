package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.manager.message.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CompassCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);

                if(target != null){
                    player.getInventory().addItem(new ItemStack(Material.COMPASS));
                    player.setCompassTarget(target.getLocation());

                    Messenger.send("command.compass.compass", player);
                    Messenger.sendToOps("command.compass.compass.op", player);
                }else{
                    Messenger.send("command.not_found.target", player);
                }
            }else if(args.length == 2){
                Player target = Bukkit.getPlayer(args[0]);
                Player target2 = Bukkit.getPlayer(args[1]);

                if(target != null && target2 != null){
                    target.getInventory().addItem(new ItemStack(Material.COMPASS));
                    target.setCompassTarget(target2.getLocation());

                    Messenger.send("command.compass.compass", target);
                    Messenger.send("command.compass.target", player);
                    Messenger.sendToOps("command.compass.compass.op.target", player);
                }else{
                    Messenger.send("command.not_found.target", player);
                }
            }
        }
        return false;
    }
}
