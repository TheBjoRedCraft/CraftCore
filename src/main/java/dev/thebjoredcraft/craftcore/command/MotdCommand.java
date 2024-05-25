package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.util.message.Messenger;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MotdCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            StringBuilder msg = new StringBuilder();

            for (String arg : args) {
                msg.append(arg).append(" ");
            }

            Bukkit.getServer().motd(MiniMessage.miniMessage().deserialize(msg.toString()));

            Messenger.send("command.motd.motd", player, msg.toString());
            Messenger.sendToOps("command.motd.op", player, msg.toString());
        }
        return false;
    }
}
