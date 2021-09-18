package events;

import handler.ScoreboardBaseHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        ScoreboardBaseHandler.getBase().setScoreboard(event.getPlayer()).getSidebar().setSidebar(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        ScoreboardBaseHandler.getBase().unregisterPlayer(event.getPlayer());
    }

}
