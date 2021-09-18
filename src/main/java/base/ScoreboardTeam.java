package base;

public class ScoreboardTeam {

    private final String name;
    private final String tablist;
    private final String suffix;
    private final String scoreboard;
    private final String priority;
    private final String chat;

    public ScoreboardTeam(final String name, final String tablist, final String chat, final String suffix, final String scoreboard, final String priority) {
        this.name = name;
        this.tablist = tablist;
        this.suffix = suffix;
        this.scoreboard = scoreboard;
        this.priority = priority;
        this.chat = chat;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getScoreboard() {
        return scoreboard;
    }

    public String getChat() {
        return chat;
    }

    public String getTablist() {
        return tablist;
    }

    public String getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }
}
