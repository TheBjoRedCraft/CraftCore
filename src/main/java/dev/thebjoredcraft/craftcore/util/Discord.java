package dev.thebjoredcraft.craftcore.util;

import dev.thebjoredcraft.craftcore.CraftCore;
import org.bukkit.Bukkit;
import org.json.simple.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
    public void sendWithBot(String args) {
        String url = "http://localhost:3000/send";
        String channelId = "1244982734334464010";
        String message = "Hello from Java!";

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");

            String jsonInputString = String.format("{\"channelId\": \"%s\", \"message\": \"%s\"}", channelId, message);

            con.setDoOutput(true);
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = con.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK) {
                Bukkit.getConsoleSender().sendMessage(CraftCore.getPrefix() + "<red>Error at HTTP Connection");
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(CraftCore.getPrefix() + "<red>" + e.getMessage());
        }
    }
}
