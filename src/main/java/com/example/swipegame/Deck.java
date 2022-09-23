package com.example.swipegame;

import javafx.scene.image.Image;

import java.util.Random;

public class Deck extends Hand {
    Random rand = new Random();
    private Image backImage;


    public void populate() {

        for (Suit suit : Suit.values()) {

            if (!suit.equals(Suit.BLACKS) && !suit.equals(Suit.GOLDS) && !suit.equals(Suit.SILVERS))

                for (Rank rank : Rank.values()) {

                    if (!rank.equals(Rank.BLACK) && (!rank.equals(Rank.GOLD) && (!rank.equals(Rank.SILVER)))) {
                        {
                            Card card = new Card(suit, rank);
                            this.add(card);
                        }


                    }

                }

        }
        for (Suit suit : Suit.values()) {
            if (suit.equals(Suit.BLACKS)) {
                for (Rank rank : Rank.values()) {
                    if (rank.equals(Rank.BLACK)) {
                        for (int i = 0; i < 10; i++)
                            this.add(new Card(suit, rank));
                    }
                }

            }
        }
        for (Suit suit : Suit.values()) {
            if (suit.equals(Suit.GOLDS)) {
                for (Rank rank : Rank.values()) {
                    if (rank.equals(Rank.GOLD)) {
                        for (int i = 0; i < 8; i++)
                            this.add(new Card(suit, rank));


                    }
                }
            }
        }


        for (Suit suit : Suit.values()) {
            if (suit.equals(Suit.SILVERS)) {
                for (Rank rank : Rank.values()) {
                    if (rank.equals(Rank.SILVER)) {
                        for (int i = 0; i < 5; i++)
                            this.add(new Card(suit, rank));


                    }
                }
            }
        }



    }
    public void shuffle(){

        for (int i = cards.size() -1; i > 0; i--) {
            //swap a random card between the beginning and last card of the loop
            int pick = rand.nextInt(i);
            Card randCard = cards.get(pick);
            Card lastCard = cards.get(i);
            cards.set(i, randCard);
            cards.set(pick, lastCard);

        }

    }

    public void drawCardPlayer1(Hand[] hands){
        this.swipe(cards.get(0), hands[0]);
        }

    public void drawCardPlayer2(Hand[] hands){
        this.swipe(cards.get(0), hands[1]);
    }


    public void drawMasterCard(Hand[] hands){
        this.swipe(cards.get(0), hands[2]);
    }



    public Card dealCardImage(Hand[] hands, int numCards) {
        return cards.get(0);

    }





}


