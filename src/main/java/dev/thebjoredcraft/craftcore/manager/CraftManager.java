package dev.thebjoredcraft.craftcore.manager;

import dev.thebjoredcraft.craftcore.CraftCore;
import dev.thebjoredcraft.craftcore.manager.emergency.EmergencyManager;
import dev.thebjoredcraft.craftcore.manager.file.MessagesFileManager;

public class CraftManager {
    public static void load(ConsoleManager manager){
        CraftCore.consoleManager = new ConsoleManager(CraftCore.getInstance());
    }
    public static void load(DataManager manager){
        CraftCore.dataManager = new DataManager(CraftCore.getInstance());
    }
    public static void load(EmergencyManager manager){
        CraftCore.emergencyManager = new EmergencyManager();
    }
    public static void load(VanishManager manager){
        CraftCore.vanishManager = new VanishManager();
    }
    public static void load(MessagesFileManager manager){
        CraftCore.messagesFileManager = new MessagesFileManager(CraftCore.getInstance());
    }

}
