package com.example.swipegame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Hand {
    public ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public void clear() {
        cards.clear();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public Image backOfCardImage;


    public String showHand() {
        String str = "";
        for (Card c : cards) {
            str += c.toString() + "\n";

        }
        str += "Total points is: " + getTotalNumberValue() + "\n";
        return str;
    }




    public String showDiscard() {
        String str = "";
        for (Card c : cards) {
            str += c.toString() + "\n";

        }
        return str;
    }

    //Return total points of a hand
    public int getTotalNumberValue() {
        int totalPts = 0;
        for (int i = 0; i < cards.size(); i++) {
            totalPts += cards.get(i).getrank();
        }
        System.out.println("Total Points Value: " + totalPts + " " + "\n");
        return totalPts;
    }

    public String getShapeValue(Card masterCard) {
        String shapeString = "";
        int xCounter = 0;
        int oCounter = 0;
        int j = 0;
        for (int i = 0; i < cards.size(); i++) {
            shapeString += cards.get(i).getSuit();
            if (cards.get(i).getSuit().contains("x")) {
                xCounter++;
                System.out.println("You have : " + xCounter + " x's" + "\n");
            }
            if (cards.get(i).getSuit().contains("o")) {
                oCounter++;
                System.out.println("You have : " + oCounter + " o's" + "\n");
            }

            if(cards.get(i).getSuit().contains("x") && masterCard.getSuit().contains("x")) {
                System.out.println("You have " + xCounter + " x cards that match the master.");
            }


            if(cards.get(i).getSuit().contains("o") && masterCard.getSuit().contains("o")) {
                System.out.println("You have " + oCounter + " o cards that match the master.");
            }

        }


        return shapeString;
    }

    public String getColorValue(Card masterCard) {
        String colorString = "";
        int redCounter = 0;
        int blueCounter = 0;
        int greenCounter = 0;
        int purpleCounter = 0;

        for (int i = 0; i < cards.size(); i++) {
            colorString += cards.get(i).getSuit();
            if (cards.get(i).getSuit().contains("red")) {
                redCounter++;
                System.out.println("You have : " + redCounter + " reds " + "\n");
            }
            if (cards.get(i).getSuit().contains("blue")) {
                blueCounter++;
                System.out.println("You have : " + blueCounter + " blues " + "\n");
            }
            if (cards.get(i).getSuit().contains("green")) {
                greenCounter++;
                System.out.println("You have : " + greenCounter + " greens " + "\n");
            }
            if (cards.get(i).getSuit().contains("purple" )) {
                purpleCounter++;
                System.out.println("You have : " + purpleCounter + " purples " + "\n");
            }

            if(cards.get(i).getSuit().contains("red") && masterCard.getSuit().contains("red")) {
                System.out.println("You have " + redCounter + " cards that match the master");
            }

            if(cards.get(i).getSuit().contains("blue") && masterCard.getSuit().contains("blue")) {
                System.out.println("You have " + blueCounter + " cards that match the master");
            }

            if(cards.get(i).getSuit().contains("green") && masterCard.getSuit().contains("green")) {
                System.out.println("You have " + greenCounter + " cards that match the master");
            }

            if(cards.get(i).getSuit().contains("purple") && masterCard.getSuit().contains("purple")) {
                System.out.println("You have " + purpleCounter + " cards that match the master");
            }

        }
        return colorString;
    }


    //Swipe Method
    public boolean swipe(Card card, Hand otherHand) {
        if (!cards.contains(card)) {
            return false;
        } else {
            // get index position of card
            cards.remove(card);
            otherHand.add(card);
            return true;
        }
    }

    public int diceRoll() {
        int blackDie = (int) (Math.random() * 6) + 1;
        int whiteDie = (int) (Math.random() * 6) + 1;
        int winner = 0;
        for (int i = 0; i < 1; i++) {
            System.out.println("Black Die is : " + blackDie);
            System.out.println("White Die is : " + whiteDie);

            if (blackDie > whiteDie) {
                winner = blackDie;
                System.out.println("Black Die WIN");
            }
            if (blackDie < whiteDie) {
                winner = whiteDie;

                System.out.println("White Die WIN");
            }
            if (blackDie == whiteDie) {
                winner = 0;
                System.out.println("TIE!");
            }
        }
        return winner;
    }

    public Card dealHandImage(int c) {

        return cards.get(c);
    }

    public void matchMaster(Card masterCard) {
        int matchMasterPoints = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getrank() == masterCard.getrank()) {
                System.out.println("Cards that match master " + matchMasterPoints + " " + "\n");
            }

        }
    }
}









