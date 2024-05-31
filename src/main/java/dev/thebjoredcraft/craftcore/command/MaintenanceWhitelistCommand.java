package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.CraftCore;
import dev.thebjoredcraft.craftcore.manager.message.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaintenanceWhitelistCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            FileConfiguration fileConfig = CraftCore.getInstance().getConfig();
            String path = "maintenance.bypass";

            if(args.length == 2){
                if(args[0].equalsIgnoreCase("add")){
                    if(!fileConfig.getStringList(path).contains(args[1])){
                        List<String> players = new ArrayList<>(fileConfig.getStringList(path));

                        players.add(args[1]);
                        fileConfig.set(path, players);
                        CraftCore.getInstance().saveConfig();

                        Messenger.send("command.maintenance.add", player, args[1]);
                        Messenger.sendToOps("command.maintenance.op.add", player, args[1]);
                    }
                }else if(args[0].equalsIgnoreCase("remove")) {
                    if (fileConfig.getStringList(path).contains(args[1])) {
                        List<String> players = new ArrayList<>(fileConfig.getStringList(path));

                        players.remove(args[1]);
                        fileConfig.set(path, players);
                        CraftCore.getInstance().saveConfig();

                        Messenger.send("command.maintenance.remove", player, args[1]);
                        Messenger.sendToOps("command.maintenance.op.remove", player, args[1]);
                    }
                }
            }else if(args.length == 1 && args[0].equalsIgnoreCase("list")){
                StringBuilder msg = new StringBuilder();

                int count = 0;

                for (String pName : fileConfig.getStringList(path)) {
                    msg.append(pName).append(", ");
                    count ++;
                }
                Messenger.send("command.maintenance.list", player, msg.toString(), count);
            }
        }
        return false;
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> onlinePlayers = new ArrayList<>();

        for(Player player : Bukkit.getOnlinePlayers()){
            if(!CraftCore.getInstance().getConfig().getStringList("maintenance.bypass").contains(player.getName())) {
                onlinePlayers.add(player.getName());
            }
        }

        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("add", "remove", "list"), new ArrayList<>());
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("add")) {
                return StringUtil.copyPartialMatches(args[1], onlinePlayers, new ArrayList<>());
            } else if (args[0].equalsIgnoreCase("remove")) {
                return StringUtil.copyPartialMatches(args[1], CraftCore.getInstance().getConfig().getStringList("maintenance.bypass"), new ArrayList<>());
            }
        }
        Collections.sort(completions);
        return completions;
    }
}
