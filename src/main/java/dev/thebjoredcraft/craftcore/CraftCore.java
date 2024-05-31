package dev.thebjoredcraft.craftcore;

import dev.thebjoredcraft.craftcore.command.*;
import dev.thebjoredcraft.craftcore.listener.*;
import dev.thebjoredcraft.craftcore.manager.ConsoleManager;
import dev.thebjoredcraft.craftcore.manager.CraftManager;
import dev.thebjoredcraft.craftcore.manager.DataManager;
import dev.thebjoredcraft.craftcore.manager.VanishManager;
import dev.thebjoredcraft.craftcore.manager.emergency.EmergencyManager;
import dev.thebjoredcraft.craftcore.manager.file.MessagesFileManager;
import dev.thebjoredcraft.craftcore.manager.maintenance.Maintenance;
import dev.thebjoredcraft.craftcore.manager.timer.Timer;
import dev.thebjoredcraft.craftcore.util.Discord;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CraftCore extends JavaPlugin {
    private static CraftCore instance;
    public static ConsoleManager consoleManager;
    public static DataManager dataManager;
    public static EmergencyManager emergencyManager;
    public static MessagesFileManager messagesFileManager;
    public static VanishManager vanishManager;
    private static Maintenance maintenance;
    private static Discord discord;
    private static Timer timer;

    public static String PREFIX = "<gray>>> <color:#40d1db>CraftCore <gray>| <color:#3b92d1>";


    @Override
    public void onLoad() {

        instance = this;

    }

    @Override
    public void onEnable() {
        CraftManager.load(consoleManager);
        CraftManager.load(dataManager);
        CraftManager.load(emergencyManager);
        CraftManager.load(vanishManager);
        CraftManager.load(messagesFileManager);

        CraftCore.discord = new Discord();
        CraftCore.timer = new Timer(this);
        CraftCore.maintenance = new Maintenance();

        this.saveResource("messages.yml", false);

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
        getCommand("emergency").setExecutor(new EmergencyCommand());
        getCommand("emergencywhitelist").setExecutor(new EmergencyWhitelistCommand());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("youtube").setExecutor(new YouTubeCommand());
        getCommand("reloadconfirm").setExecutor(new ReloadConfirmCommand());
        getCommand("maintenance").setExecutor(new MaintenanceCommand());
        getCommand("maintenancewhitelist").setExecutor(new MaintenanceWhitelistCommand());

        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new CommandListener(), this);

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

    public static EmergencyManager getEmergencyManager() {
        return emergencyManager;
    }

    public static VanishManager getVanishManager() {
        return vanishManager;
    }

    public static Discord getDiscord() {
        return discord;
    }

    public static Timer getTimer() {
        return timer;
    }

    public static Maintenance getMaintenance() {
        return maintenance;
    }

    public static MessagesFileManager getMessages() {
        return messagesFileManager;
    }
}
