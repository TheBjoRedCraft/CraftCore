package dev.thebjoredcraft.craftcore.command;

import dev.thebjoredcraft.craftcore.util.message.Messenger;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class RenameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(player.getItemOnCursor().hasItemMeta()){
                StringBuilder msg = new StringBuilder();

                for (String arg : args) {
                    msg.append(arg).append(" ");
                }
                ItemMeta meta = player.getItemOnCursor().getItemMeta();
                meta.displayName(MiniMessage.miniMessage().deserialize(meta.toString()));

                player.getItemOnCursor().setItemMeta(meta);

                Messenger.send("command.rename.rename", player, msg.toString());
                Messenger.sendToOps("command.rename.op", player, msg.toString());
            }
        }
        return false;
    }
}
