package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.CraftCore;
import dev.thebjoredcraft.craftcore.manager.VanishManager;
import dev.thebjoredcraft.craftcore.manager.message.Messenger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            VanishManager vanishManager = CraftCore.getVanishManager();
            if(vanishManager.isVanished(player)){
                vanishManager.show(player);

                Messenger.send("command.vanish.shown", player);
                Messenger.sendToOps("command.vanish.op.shown", player);
                Messenger.broadcast("command.vanish.public.shown", player);
            }else{
                vanishManager.hide(player);

                Messenger.send("command.vanish.vanished", player);
                Messenger.sendToOps("command.vanish.op.vanished", player);
                Messenger.broadcast("command.vanish.public.vanished", player);
            }
        }
        return false;
    }
}
