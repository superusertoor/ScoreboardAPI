package handler;

import com.google.common.collect.Maps;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;

public final class ScoreboardManager {

    private static final HashMap<String, ScoreboardHandler> handlers = Maps.newHashMap();
    private final HashMap<String, Scoreboard> scoreboards = Maps.newHashMap();

    public static ScoreboardHandler getScoreboardHandler(Player player) {
        return handlers.get(player.getName());
    }

    public static void removeScoreboardHandler(Player player) {
        handlers.remove(player.getName());
    }

    public static void addScoreboardHandler(Player player, ScoreboardHandler handler) {
        handlers.put(player.getName(), handler);
    }

    public Scoreboard getScoreboard(Player player) {
        return this.scoreboards.get(player.getName());
    }

    public void put(Player player, Scoreboard scoreboard) {
        this.scoreboards.put(player.getName(), scoreboard);
    }

    public void remove(Player player) {
        this.scoreboards.remove(player.getName());
    }

    public void destroy() {
        this.scoreboards.clear();
    }
}