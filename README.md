ScoreboardAPI - Simply create a scoreboard, a sidebar and register teams.

Create a new ScoreboardBase & sidebar.
ScoreboardBaseHandler.createaNewBase();

Get the base using the ScoreboardBaseHandler
  - ScoreboardBase base = ScoreboardBaseHandler.getBase(); 

Get the sidebar using your base.
  - Sidebar bar = base.getSidebar(); 

Sidebar
  - setTitle(String); - sets the sidebar's title
  - addScore(String); - adds a score
  - reverse(); - reverses the scores (always recommended)
  - getTitle(); - returns the title
  - getScores(); - return all scores
  - setSidebar(Player); - sets sidebar

ScoreboardBase
   - addNewTeam
    - name (Rank's name)
    - prefix (Prefix)
    - chat (Chat prefix)
    - suffix (Tablist suffix)
    - scoreboard (Displayed rank in scoreboard)
    - priority (Priority (0001, 0002, ...))
    - permission (Permission node)
  - getPlayerTeam(Player player); - returns a player's team
  - getTeam(String); - returns a registered team
  - setScoreboard(Player); - sets scoreboard
  - unregisterPlayer(Player); - unregisters a player
  - getSidebar(); - returns sidebar

Placeholders:
%rank% - scoreboard


Your base and sidebar may look like the following:
  - base.addNewTeam("default", "§a§lPLAYER §f", "", "§a", "§aPlayer", "0009", "default");
  - bar.addScore("§7§m----------");
  - bar.addScore("§fRank");
  - bar.addScore("%rank%");
  - bar.addScore(" ");
  - bar.addScore("§8§7§m----------");
  - bar.addScore("§d§oyour.domain");
  - bar.reverse();
