package dev.thebjoredcraft.craftcore.manager.file;

import dev.thebjoredcraft.craftcore.CraftCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class MessagesFileManager {
    private final File dataFile = new File(CraftCore.getInstance().getDataFolder(), "messages.yml");
    private final JavaPlugin instance;
    private final FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(dataFile);

    public MessagesFileManager(JavaPlugin instance){
        this.instance = instance;
    }

    public void set(String path, Object value){
        fileConfig.set(path, value);
    }

    public String getString(String path) {
        Object val = get(path);
        if(val != null) {
            return val.toString().replace("\"", "");
        }else{
            return path;
        }
    }

    public Object get(String path){
        return fileConfig.get(path);
    }


    public File getDataFile() {
        return dataFile;
    }

    public FileConfiguration getFileConfig() {
        return fileConfig;
    }

    public void save() {
        try {
            fileConfig.save(dataFile);
        }catch (IOException e){
            CraftCore.getConsoleManager().sendErrorMessage(e.getMessage());
        }
    }

    public void saveFile(){
        CraftCore.getInstance().saveResource("messages.yml", false);
    }

    public JavaPlugin getInstance() {
        return instance;
    }
}
