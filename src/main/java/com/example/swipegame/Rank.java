package com.example.swipegame;

public enum Rank {
    ONE(1, "1"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"),
    SIX(6, "6"), SEVEN(7, "7"), EIGHT(8,"8"),  NINE(9, "9"), TEN(10, "10"),
    BLACK(0, "Black"), GOLD(0, "Gold"), SILVER(0, "Silver");


    private final int rankValue;
    private final String rankString;

    Rank(int rankValue, String rankString) {
        this.rankValue = rankValue;
        this.rankString = rankString;
    }

    public int getRank() {
        return rankValue;
    }

    public String printRank(){
        return rankString;
    }
}

