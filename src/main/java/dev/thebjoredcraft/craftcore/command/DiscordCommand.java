package dev.thebjoredcraft.craftcore.command;

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
import java.util.Collections;
import java.util.List;

public class DiscordCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 1 && args[0].equalsIgnoreCase("webhook")){
                if(player.hasPermission("craftcore.command.discord.webhook")) {
                    Messenger.sendFromConfig("discord.webhook-url", player);
                }
            }else{
                Messenger.send("command.discord", player);
            }
        }
        return false;
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            if(sender.hasPermission("craftcore.command.discord.webhook")) {
                return StringUtil.copyPartialMatches(args[0], List.of("webhook"), new ArrayList<>());
            }else{
                return StringUtil.copyPartialMatches(args[0], List.of(), new ArrayList<>());
            }
        }
        Collections.sort(completions);
        return completions;
    }
}
