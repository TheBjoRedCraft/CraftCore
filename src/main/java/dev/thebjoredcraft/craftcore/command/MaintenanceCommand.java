package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.CraftCore;
import dev.thebjoredcraft.craftcore.manager.maintenance.Maintenance;
import dev.thebjoredcraft.craftcore.manager.message.Messenger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaintenanceCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            Maintenance maintenance = CraftCore.getMaintenance();

            if(args.length >= 2 && args[0].equalsIgnoreCase("activate")){
                if(maintenance.isActive()) {
                    StringBuilder msg = new StringBuilder();

                    for (int i = 1; i < args.length; i++) {
                        msg.append(args[i]).append(" ");
                    }

                    maintenance.setPlayer(player);
                    maintenance.setReason(msg.toString());
                    maintenance.enable();

                    Messenger.send("command.maintenance.activate", player, msg.toString());
                    Messenger.sendToOps("command.maintenance.op.activate", player, msg.toString());
                }else{
                    Messenger.send("command.maintenance.active", player);
                }
            }else if(args.length == 1 && args[0].equalsIgnoreCase("deactivate")){
                if(!maintenance.isActive()) {
                    maintenance.disable();

                    Messenger.send("command.maintenance.deactivate", player);
                    Messenger.sendToOps("command.maintenance.op.deactivate", player);
                }else{
                    Messenger.send("command.maintenance.inactive", player);
                }
            }else if(args.length == 1 && args[0].equalsIgnoreCase("information") || args.length == 1 && args[0].equalsIgnoreCase("info")){
                Messenger.send("command.maintenance.information", player, maintenance.getReason());
            }else if(args.length == 1 && args[0].equalsIgnoreCase("kick")){
                int count = maintenance.kickPlayers();
                Messenger.send("command.maintenance.kicked", player, maintenance.getReason(), count);
            }
        }
        return false;
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("activate", "deactivate", "information", "kick"), new ArrayList<>());
        }
        Collections.sort(completions);
        return completions;
    }
}
