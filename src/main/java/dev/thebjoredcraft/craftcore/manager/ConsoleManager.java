package dev.thebjoredcraft.craftcore.manager;

import dev.thebjoredcraft.craftcore.CraftCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ConsoleManager extends CraftManager{
    public JavaPlugin instance;

    public ConsoleManager(JavaPlugin instance){
        this.instance = instance;
    }


    public void sendMessage(String message){
        Bukkit.getConsoleSender().sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix() + message));
    }
    public void sendErrorMessage(String message){
        Bukkit.getConsoleSender().sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix()  + "<red>" + message));
    }
    public void sendWarnMessage(String message){
        Bukkit.getConsoleSender().sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getPrefix() + "<yellow>" + message));
    }

}
