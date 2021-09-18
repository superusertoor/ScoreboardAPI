package handler;

import base.ScoreboardBase;
import com.google.common.collect.Maps;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.UUID;

public final class TeamHandler {

    private static final HashMap<String, String> colors = new HashMap<>();
    private static final ScoreboardBase base = ScoreboardBaseHandler.getBase();
    private final TreeMap<UUID, Integer> teamIds = Maps.newTreeMap();

    public String addTeam(Player player) {
        String Id = "";
        int id = this.teamIds.isEmpty() ? 0 : ((this.teamIds.values().stream().max(Integer::compare).get()).intValue() + 1);
        this.teamIds.put(player.getUniqueId(), Integer.valueOf(id));
        Id = getTeamPriority(player) + id;
        return Id;
    }

    public String getTeamName(Player player) {
        return getTeamPriority(player) + this.teamIds.get(player.getUniqueId());
    }

    private String getTeamPriority(Player player) {
        return base.getPlayerTeam(player).getPriority();
    }

    public void remove(Player player) {
        this.teamIds.remove(player.getUniqueId());
    }
}