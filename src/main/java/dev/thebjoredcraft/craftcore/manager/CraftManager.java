package dev.thebjoredcraft.craftcore.manager;

import dev.thebjoredcraft.craftcore.CraftCore;
import dev.thebjoredcraft.craftcore.manager.emergency.EmergencyManager;

public class CraftManager {
    public static void load(ConsoleManager manager){
        CraftCore.consoleManager = new ConsoleManager(CraftCore.getInstance());
    }
    public static void load(DataManager manager){
        CraftCore.dataManager = new DataManager(CraftCore.getInstance());
    }
    public static void load(EmergencyManager manager){
        CraftCore.emergencyManager = new EmergencyManager();
    }    public static void load(VanishManager manager){
        CraftCore.vanishManager = new VanishManager();
    }

}
