package me.enderaura.enderbot.listener;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * @author Enderaura
 * @since 26/10/2018 17:57.
 */
public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        event.getJDA().getPresence().setPresence(OnlineStatus.ONLINE, Game.watching("Ender"));
    }
}
