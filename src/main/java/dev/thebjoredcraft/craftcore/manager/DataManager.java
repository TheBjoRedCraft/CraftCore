package dev.thebjoredcraft.craftcore.manager;

import dev.thebjoredcraft.craftcore.CraftCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class DataManager {
    public File dataFile = new File(CraftCore.getInstance().getDataFolder(), "data.yml");
    public FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(dataFile);
    public JavaPlugin instance;

    public DataManager(JavaPlugin instance){
        this.instance = instance;
    }

    public File getDataFile() {
        return dataFile;
    }

    public FileConfiguration getFileConfig() {
        return fileConfig;
    }

    public void saveFileConfiguration() {
        try {
            fileConfig.save(dataFile);
        }catch (IOException e){
            CraftCore.getConsoleManager().sendErrorMessage(e.getMessage());
        }
    }

    public void save(){
        CraftCore.getInstance().saveResource("data.yml", false);
    }
}
