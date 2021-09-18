package example;

import base.ScoreboardBase;
import base.Sidebar;
import handler.ScoreboardBaseHandler;

public class ScoreboardLoader {

    public void loadExample() {
        ScoreboardBase b = ScoreboardBaseHandler.createNewBase()
                .addNewTeam("Administrator", "§4§lADMIN §f", "§4", "", "§4Administrator", "0001", "admin")
                .addNewTeam("default", "§a§lDEFAULT §f", "", "§a", "§aSpieler", "0002", "default");

        Sidebar bar = b.getSidebar().setTitle("§f§lTITLE");
        bar.addScore("§7§m----------");
        bar.addScore("§fRank");
        bar.addScore("%rank%");
        bar.addScore(" ");
        bar.addScore("§8§7§m----------");
        bar.addScore("§d§oyour.domain");
        bar.reverse();
    }
}