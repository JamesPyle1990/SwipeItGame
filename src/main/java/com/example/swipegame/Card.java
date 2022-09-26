package com.example.swipegame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Card {


        private Suit suit;
        private Rank rank;
        private Image image;


        private boolean isFaceUp;

    public Image getImage(Card card)
    {
        String fileType = ".jpeg";
        String rankName = card.rank.printRank();
        String suitName = card.suit.printSuit();
        Image cardImage = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/" + rankName + " " + suitName + fileType));



        return cardImage;
    }

    public String getCardString(Card card){
        String cardName = card.suit.printSuit();
        return cardName;
    }


    public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;


            String fileName = ".jpeg";
           // image = new Image("./images/" + fileName);
        }


        public String getSuit() {
            return suit.printSuit();
        }

        public int getrank() {
            return rank.getRank();
        }

        public String printRank(){
            return rank.printRank();
        }


        public String toString(){

            String str = "";
            str+= rank.printRank() + " " + suit.printSuit() + " " ;
            return str;
        }



}

