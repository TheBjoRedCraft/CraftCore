package dev.thebjoredcraft.craftcore.manager.message;

import dev.thebjoredcraft.craftcore.CraftCore;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Messenger {
    public static void sendRaw(String message, Player player){
        player.sendMessage(MiniMessage.miniMessage().deserialize(message));
    }
    public static void sendRaw(String message, Player player, Player target){
        player.sendMessage(MiniMessage.miniMessage().deserialize(message.replace("%target%", target.getName())));
    }
    public static void sendFromConfig(String path, Player player){
        player.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%player%", player.getName()).replace("%prefix%", CraftCore.getPrefix())));
    }
    public static void send(String path, Player player){
        player.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%player%", player.getName()).replace("%prefix%", CraftCore.getPrefix())));
    }
    public static void broadcast(String path, Player player){
        for(Player online : Bukkit.getOnlinePlayers()) {
            online.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%player%", player.getName()).replace("%prefix%", CraftCore.getPrefix())));
        }
    }
    public static void send(String path, Player player, int amount){
        player.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%amount%", String.valueOf(amount)).replace("%player%", player.getName()).replace("%prefix%", CraftCore.getPrefix())));
    }
    public static void send(String path, Player player, Player target){
        player.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%target%", target.getName()).replace("%player%", player.getName()).replace("%prefix%", CraftCore.getPrefix())));
    }
    public static void send(String path, Player player, OfflinePlayer target){
        player.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%target%", target.getName()).replace("%player%", player.getName()).replace("%prefix%", CraftCore.getPrefix())));
    }
    public static void send(String path, Player player, String args){
        player.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%args%", args).replace("%player%", player.getName()).replace("%prefix%", CraftCore.getPrefix())));
    }
    public static void send(String path, Player player, String args, int amount){
        player.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%args%", args).replace("%player%", player.getName()).replace("%amount%", String.valueOf(amount)).replace("%prefix%", CraftCore.getPrefix())));
    }
    public static void sendToOps(String path, Player player, Player target){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if (op.hasPermission("craftcore.notify")) {
                op.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%target%", target.getName()).replace("%player%", player.getName()).replace("%prefix%", CraftCore.getPrefix())));
            }
        }
    }
    public static void sendToOps(String path, Player player, OfflinePlayer target){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if (op.hasPermission("craftcore.notify")) {
                op.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%target%", target.getName()).replace("%player%", player.getName()).replace("%prefix%", CraftCore.getPrefix())));
            }
        }
    }
    public static void sendToOps(String path, Player player, int amount){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if(op != player) {
                if (op.hasPermission("craftcore.notify")) {
                    op.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%amount%", String.valueOf(amount)).replace("%player%", player.getName()).replace("%prefix%", CraftCore.getPrefix())));
                }
            }
        }
    }

    public static void sendToOps(String path, Player player){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if(op != player) {
                if (op.hasPermission("craftcore.notify")) {
                    op.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%player%", player.getName()).replace("%prefix%", CraftCore.getPrefix())));
                }
            }
        }
    }
    public static void sendToOps(String path, Player player, String args){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if(op != player) {
                if (op.hasPermission("craftcore.notify")) {
                    op.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%player%", player.getName()).replace("%args%", args).replace("%prefix%", CraftCore.getPrefix())));
                }
            }
        }
    }
    public static void sendToOps(String path, Player player, String args, int amount){
        for(Player op : Bukkit.getOnlinePlayers()) {
            if(op != player) {
                if (op.hasPermission("craftcore.notify")) {
                    op.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + CraftCore.getMessages().getString(path).replace("%player%", player.getName()).replace("%args%", args).replace("%amount%", String.valueOf(amount)).replace("%prefix%", CraftCore.getPrefix())));
                }
            }
        }
    }
    public static Component message(String path, OfflinePlayer player, String args){
        return MiniMessage.miniMessage().deserialize(CraftCore.getMessages().getString(path).replace("%player%", player.getName()).replace("%args%", args).replace("%prefix%", CraftCore.getPrefix()));
    }
    public static Component message(String path, String args){
        return MiniMessage.miniMessage().deserialize(CraftCore.getMessages().getString(path).replace("%args%", args).replace("%prefix%", CraftCore.getPrefix()));
    }
}
