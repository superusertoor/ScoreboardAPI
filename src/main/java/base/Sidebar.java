package base;

import handler.ScoreboardBaseHandler;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Sidebar {

    private final List<String> scores = new ArrayList<>();
    private String name = "SCOREBOARD";

    public Sidebar() {

    }

    public String getTitle() {
        return name;
    }

    public Sidebar setTitle(String name) {
        this.name = name;
        return this;
    }

    public Sidebar addScore(String s) {
        scores.add(s);
        return this;
    }

    public List<String> getScores() {
        return scores;
    }

    public Sidebar reverse() {
        Collections.reverse(scores);
        return this;
    }

    public Sidebar setSidebar(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        ScoreboardTeam team = ScoreboardBaseHandler.getBase().getPlayerTeam(player);
        Objective objective = scoreboard.registerNewObjective("SIDEBAR", "dummy");
        objective.setDisplayName(getTitle());
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        AtomicInteger i = new AtomicInteger();
        getScores().forEach(s -> {
            objective.getScore(s.replace("%rank%", team.getScoreboard())).setScore(i.get());
            i.getAndIncrement();
        });
        return this;
    }
}
