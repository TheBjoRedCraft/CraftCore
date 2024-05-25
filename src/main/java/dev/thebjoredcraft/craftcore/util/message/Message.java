package dev.thebjoredcraft.craftcore.util.message;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public enum Message {
    MESSAGE(MiniMessage.miniMessage().deserialize(""));

    public final Component message;

    Message(Component message){
        this.message = message;
    }
}
