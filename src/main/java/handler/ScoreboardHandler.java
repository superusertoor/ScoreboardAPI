package handler;

import base.ScoreboardBase;
import base.ScoreboardTeam;
import main.ScoreboardAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardHandler {

    private final ScoreboardAPI plugin = ScoreboardAPI.getInstance();
    private final Player player;
    private final TeamHandler teamHandler = plugin.getTeamHandler();
    private final ScoreboardManager manager = plugin.getScoreboardManager();
    private final ScoreboardTeam sbTeam;
    private final ScoreboardBase base = ScoreboardBaseHandler.getBase();
    private Scoreboard scoreboard = null;

    public ScoreboardHandler(Player player) {
        this.player = player;
        this.sbTeam = base.getPlayerTeam(player);
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        ScoreboardManager.addScoreboardHandler(player, this);
    }

    public void createScoreboard() {
        player.setScoreboard(scoreboard);
        registerPlayerTeam();
        addAllTeamsToPlayer();
        registerPlayerTeamForAll();
        manager.put(player, scoreboard);
    }

    public void destroyScoreboard() {
        destroyPlayerTeams();
        removePlayerFromTeams();
        manager.remove(player);
        teamHandler.remove(player);
        ScoreboardManager.removeScoreboardHandler(player);
    }

    private void destroyPlayerTeams() {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }

    private void registerPlayerTeam() {
        final Team playerTeam = scoreboard.registerNewTeam(teamHandler.addTeam(player));
        playerTeam.setPrefix(sbTeam.getTablist());
        playerTeam.addEntry(player.getName());
    }

    private void addAllTeamsToPlayer() {
        Bukkit.getOnlinePlayers().parallelStream().forEach(online -> {
            if (!player.getUniqueId().equals(online.getUniqueId())) {
                final Team allTeam = scoreboard.registerNewTeam(teamHandler.getTeamName(online));
                allTeam.setPrefix(base.getPlayerTeam(online).getTablist());
                allTeam.addEntry(online.getName());
            }
        });
    }

    private void registerPlayerTeamForAll() {
        Bukkit.getOnlinePlayers().parallelStream().forEach(online -> {
            if (!player.getUniqueId().equals(online.getUniqueId())) {
                final Scoreboard allScoreboard = manager.getScoreboard(online);
                final Team playerTeam = allScoreboard.registerNewTeam(teamHandler.getTeamName(player));
                playerTeam.setPrefix(sbTeam.getTablist());
                playerTeam.addEntry(playerTeam.getName());
            }
        });
    }

    private void removePlayerFromTeams() {
        Bukkit.getOnlinePlayers().parallelStream().forEach(online -> {
            if (!player.getUniqueId().equals(online.getUniqueId())) {
                manager.getScoreboard(online).getEntryTeam(player.getName()).unregister();
            }
        });
    }
}