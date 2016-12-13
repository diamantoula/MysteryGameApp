package com.example.mysterygameapp.staticData;

import com.example.mysterygameapp.modelsDB.Bonus;

import java.util.ArrayList;

public class BonusData {

    private static ArrayList<Bonus> bonuses = new ArrayList<>();

    public static void setBonuses () {
        bonuses.add(new Bonus(0, "bonusA", 10, "no", 41.089586, 23.551201));
        bonuses.add(new Bonus(1, "bonusB", 15, "no", 41.089222, 23.548862));
        bonuses.add(new Bonus(2, "bonusC", 30, "no", 41.087503, 23.549163));
        bonuses.add(new Bonus(3, "bonusD",30, "no", 41.085894, 23.546664));
        bonuses.add(new Bonus(4, "bonusE", 10, "no", 41.083444, 23.545661));
    }

    public static ArrayList<Bonus> getBonuses () {
        return bonuses;
    }

    public static Bonus getBonus (int pos) { return bonuses.get(pos); }

}
