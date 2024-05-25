package dev.thebjoredcraft.craftcore.manager;

import dev.thebjoredcraft.craftcore.CraftCore;

public class CraftManager {
    public static void load(ConsoleManager manager){
        manager = new ConsoleManager(CraftCore.getInstance());
    }
    public static void load(DataManager manager){
        manager = new DataManager(CraftCore.getInstance());
    }
}
