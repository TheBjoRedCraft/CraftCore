package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.CraftCore;
import dev.thebjoredcraft.craftcore.manager.timer.Timer;
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

public class TimerCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            Timer timer = CraftCore.getTimer();

            if(args.length == 2 && args[0].equalsIgnoreCase("start")){
                timer.setTime(Integer.parseInt(args[1]));
                timer.start();
            }else if(args.length == 1 && args[0].equalsIgnoreCase("pause")){
                timer.setPaused(true);
            }else if(args.length == 1 && args[0].equalsIgnoreCase("resume")){
                timer.setPaused(false);
            }else if(args.length == 1 && args[0].equalsIgnoreCase("countdown")){
                timer.setDown(true);
            }else if(args.length == 1 && args[0].equalsIgnoreCase("counter")){
                timer.setDown(false);
            }else if(args.length == 1 && args[0].equalsIgnoreCase("reset")){
                timer.reset();
            }else if(args.length == 1 && args[0].equalsIgnoreCase("stop")){
                timer.stop();
            }
        }
        return false;
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("start", "pause", "resume", "countdown", "counter", "reset", "stop"), new ArrayList<>());
        }
        Collections.sort(completions);
        return completions;
    }
}
