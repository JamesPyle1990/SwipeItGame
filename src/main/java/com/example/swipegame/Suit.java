package com.example.swipegame;

public enum Suit {
    REDX("red x"),
    BLUEX("blue x"),
    GREENO("green o"),
    PURPLEO("purple o"),
    BLACKS("blackSwipe"),
    GOLDS("goldSwipe"),
    SILVERS("silverSwipe");

    private final String suitText;

    //Constructor
    Suit(String suitText) {
        this.suitText = suitText;
    }

    //Public Method
    public String printSuit() {
        return suitText;
    }
}
