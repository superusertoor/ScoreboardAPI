package events;

import handler.ScoreboardBaseHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setFormat(ScoreboardBaseHandler.getBase().getPlayerTeam(event.getPlayer()).getChat() + event.getPlayer().getName() + ": §f%2$s");
    }
}
