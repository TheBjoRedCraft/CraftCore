package dev.thebjoredcraft.craftcore.util;

import dev.thebjoredcraft.craftcore.CraftCore;
import org.bukkit.Bukkit;
import org.json.simple.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.net.URL;

public class Discord {
    @SuppressWarnings("unchecked")
    public void send(String content) {
        try{
            JSONObject jsonObject = new JSONObject();
            URL url = new URL(CraftCore.getInstance().getConfig().getString("discord.webhook-url", ""));
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            jsonObject.put("content", content);
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("User-Agent", "Java-DiscordWebhook");
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStream stream = connection.getOutputStream();
            stream.write(jsonObject.toJSONString().getBytes());
            stream.flush();
            stream.close();

            connection.getInputStream().close();
            connection.disconnect();
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(CraftCore.getPrefix() + "<red>" + e.getMessage());
        }
    }
}
