package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.CraftCore;
import dev.thebjoredcraft.craftcore.util.message.Messenger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EmergencyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length >= 1){
                if(!CraftCore.getEmergencyManager().isEmergency) {
                    StringBuilder msg = new StringBuilder();

                    for (String arg : args) {
                        msg.append(arg).append(" ");
                    }
                    CraftCore.getEmergencyManager().create(player, msg.toString());

                    Messenger.send("command.emergency.on", player, msg.toString());
                    Messenger.sendToOps("command.emergency.op.on", player, msg.toString());
                }else{
                    Messenger.send("command.emergency.active", player);
                }
            }else{
                if(CraftCore.getEmergencyManager().isEmergency){
                    CraftCore.getEmergencyManager().isEmergency = false;

                    Messenger.send("command.emergency.off", player);
                    Messenger.sendToOps("command.emergency.op.off", player);
                }else{
                    Messenger.send("command.emergency.inactive", player);
                }
            }
        }
        return false;
    }
}
