package dev.thebjoredcraft.craftcore.util.message;

import dev.thebjoredcraft.craftcore.CraftCore;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.SplittableRandom;

public class Messenger {
    public static CraftCore instance = CraftCore.getInstance();

    public static void sendRaw(String message, Player player){
        player.sendMessage(MiniMessage.miniMessage().deserialize(message));
    }
    public static void sendRaw(String message, Player player, Player target){
        player.sendMessage(MiniMessage.miniMessage().deserialize(message.replace("%target%", target.getName())));
    }
    public static void sendFromConfig(String path, Player player){
        player.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString(path, "").replace("%player%", player.getName())));
    }
    public static void send(String path, Player player){
        player.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%player%", player.getName())));
    }
    public static void broadcast(String path, Player player){
        for(Player online : Bukkit.getOnlinePlayers()) {
            online.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%player%", player.getName())));
        }
    }
    public static void send(String path, Player player, int amount){
        player.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." +path, "").replace("%amount%", String.valueOf(amount)).replace("%player%", player.getName())));
    }
    public static void send(String path, Player player, Player target){
        player.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%target%", target.getName()).replace("%player%", player.getName())));
    }
    public static void send(String path, Player player, OfflinePlayer target){
        player.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%target%", target.getName()).replace("%player%", player.getName())));
    }
    public static void send(String path, Player player, String args){
        player.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%args%", args).replace("%player%", player.getName())));
    }
    public static void send(String path, Player player, String args, int amount){
        player.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%args%", args).replace("%player%", player.getName()).replace("%amount%", String.valueOf(amount))));
    }
    public static void sendToOps(String path, Player player, Player target){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if (op.hasPermission("craftcore.notify")) {
                op.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%target%", target.getName()).replace("%player%", player.getName())));
            }
        }
    }
    public static void sendToOps(String path, Player player, OfflinePlayer target){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if (op.hasPermission("craftcore.notify")) {
                op.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%target%", target.getName()).replace("%player%", player.getName())));
            }
        }
    }
    public static void sendToOps(String path, Player player, int amount){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if(op != player) {
                if (op.hasPermission("craftcore.notify")) {
                    op.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%amount%", String.valueOf(amount)).replace("%player%", player.getName())));
                }
            }
        }
    }

    public static void sendToOps(String path, Player player){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if(op != player) {
                if (op.hasPermission("craftcore.notify")) {
                    op.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%player%", player.getName())));
                }
            }
        }
    }
    public static void sendToOps(String path, Player player, String args){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if(op != player) {
                if (op.hasPermission("craftcore.notify")) {
                    op.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%player%", player.getName()).replace("%args%", args)));
                }
            }
        }
    }
    public static void sendToOps(String path, Player player, String args, int amount){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if(op != player) {
                if (op.hasPermission("craftcore.notify")) {
                    op.sendMessage(MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%player%", player.getName()).replace("%args%", args).replace("%amount%", String.valueOf(amount))));
                }
            }
        }
    }
    public static Component message(String path, OfflinePlayer player, String args){
        return MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%player%", player.getName()).replace("%args%", args));
    }
    public static Component message(String path, String args){
        return MiniMessage.miniMessage().deserialize(instance.getConfig().getString("messages." + path, "").replace("%args%", args));
    }
}
