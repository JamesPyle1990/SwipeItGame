package com.example.swipegame;

import javafx.scene.image.Image;

public class Card {


        private Suit suit;
        private Rank rank;
        private Image image;


        private boolean isFaceUp;

    public Image getImage(Card card)
    {
        String fileType = ".jpg";
        String rankName = card.rank.printRank();
        String suitName = card.suit.printSuit();
        Image cardImage = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/" + rankName + " " + suitName + fileType));



        return cardImage;
    }

    public Image getMergedImage(Card powerCard, Card swipeCard)
    {
        String fileType = ".jpg";
        String powerRank = powerCard.rank.printRank();
        String powerSuit = powerCard.suit.printSuit();
        String swipeSuit = swipeCard.suit.printSuit();
        Image cardImage = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/" + powerRank + " " + powerSuit + " " + swipeSuit + fileType));

        return cardImage;
    }


    public String getCardString(Card card){
        String cardName = card.suit.printSuit();
        return cardName;
    }


    public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;


            String fileName = ".jpg";
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

