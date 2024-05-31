package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.CraftCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MessengerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if (args.length == 1) {
                player.sendMessage(MiniMessage.miniMessage().deserialize(CraftCore.getMessages().getString(args[0])));
            }
        }
        return false;
    }
}
