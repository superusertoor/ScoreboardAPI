package main;

import events.ChatListener;
import events.JoinListener;
import example.ScoreboardLoader;
import handler.ScoreboardManager;
import handler.TeamHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ScoreboardAPI extends JavaPlugin {

    private static ScoreboardAPI instance;
    private TeamHandler teamHandler;
    private ScoreboardManager scoreboardManager;

    public static ScoreboardAPI getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.teamHandler = new TeamHandler();
        this.scoreboardManager = new ScoreboardManager();
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        new ScoreboardLoader().loadExample();
    }

    @Override
    public void onDisable() {
        instance = null;
        scoreboardManager.destroy();
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public TeamHandler getTeamHandler() {
        return teamHandler;
    }

}
