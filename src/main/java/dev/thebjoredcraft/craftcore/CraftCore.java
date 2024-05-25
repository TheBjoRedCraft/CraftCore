package dev.thebjoredcraft.craftcore;

import dev.thebjoredcraft.craftcore.command.*;
import dev.thebjoredcraft.craftcore.listener.*;
import dev.thebjoredcraft.craftcore.manager.ConsoleManager;
import dev.thebjoredcraft.craftcore.manager.CraftManager;
import dev.thebjoredcraft.craftcore.manager.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CraftCore extends JavaPlugin {
    public static CraftCore instance;
    public static ConsoleManager consoleManager;
    public static DataManager dataManager;

    public static String PREFIX = "<gray>>> <color:#40d1db>CraftCore <gray>| <color:#3b92d1>";


    @Override
    public void onLoad() {
        instance = this;

    }

    @Override
    public void onEnable() {
        CraftManager.load(consoleManager);
        CraftManager.load(dataManager);

        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("rename").setExecutor(new RenameCommand());
        getCommand("motd").setExecutor(new MotdCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("compass").setExecutor(new CompassCommand());
        getCommand("time").setExecutor(new TimeCommand());
        getCommand("social").setExecutor(new SocialCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("op").setExecutor(new OPCommand());
        getCommand("deop").setExecutor(new DeOPCommand());
        getCommand("help").setExecutor(new HelpCommand());
        getCommand("clear").setExecutor(new ClearCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("messenger").setExecutor(new MessengerCommand());

        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);

        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static CraftCore getInstance() {
        return instance;
    }

    public static ConsoleManager getConsoleManager() {
        return consoleManager;
    }

    public static String getPrefix() {
        return PREFIX;
    }

    public static DataManager getDataManager() {
        return dataManager;
    }
}