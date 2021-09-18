package handler;

import base.ScoreboardBase;

public class ScoreboardBaseHandler {

    private static ScoreboardBase base;

    public static ScoreboardBase createNewBase() {
        base = new ScoreboardBase();
        return base;
    }

    public static ScoreboardBase getBase() {
        return base;
    }
}
