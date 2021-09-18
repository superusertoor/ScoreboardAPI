package base;

import handler.ScoreboardHandler;
import handler.ScoreboardManager;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class ScoreboardBase {

    private final HashMap<String, ScoreboardTeam> teams = new HashMap<>();
    private final HashMap<UUID, ScoreboardTeam> players = new HashMap<>();
    private final HashMap<String, ScoreboardTeam> ranks = new HashMap<>();
    private final Sidebar bar = new Sidebar();

    public ScoreboardBase() {

    }

    public Sidebar getSidebar() {
        return bar;
    }

    public ScoreboardBase addNewTeam(final String name, final String prefix, final String chat, final String suffix, final String scoreboard, final String priority, String permission) {
        ScoreboardTeam team = new ScoreboardTeam(name, prefix, chat, suffix, scoreboard, priority);
        teams.put(name, team);
        ranks.put(permission, team);
        return this;
    }

    public ScoreboardBase unregisterPlayer(final Player player) {
        ScoreboardManager.getScoreboardHandler(player).destroyScoreboard();
        players.remove(player.getUniqueId());
        return this;
    }

    public ScoreboardTeam getPlayerTeam(final Player player) {
        return players.get(player.getUniqueId());
    }

    public ScoreboardTeam getTeam(String name) {
        return teams.get(name);
    }

    public ScoreboardBase setScoreboard(final Player player) {
        String permission = player.isOp() ? "admin" : "default";
        players.put(player.getUniqueId(), ranks.get(permission));
        new ScoreboardHandler(player).createScoreboard();
        return this;
    }
}