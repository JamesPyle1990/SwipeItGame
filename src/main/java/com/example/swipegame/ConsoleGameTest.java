package com.example.swipegame;

import java.util.Scanner;

public class ConsoleGameTest {
    public static void main(String[] args) {

        //Create Scanner
        Scanner scanner = new Scanner(System.in);

        //Create Card with an image
        Card testCard = new Card(Suit.REDX, Rank.ONE);

        //Create Deck
        Deck d1 = new Deck();
        d1.populate();

        //Shuffle Deck
        // d1.shuffle();

        // Create Hands
        Hand player1, player2, player1Pts, player2Pts, discard, imageHand1, imageHand2;
        player1Pts = new Hand();
        player2Pts = new Hand();
        player1 = new Hand();
        player2 = new Hand();
        discard = new Hand();
        imageHand1 = new Hand();
        imageHand2 = new Hand();

        Hand[] hands = {player1, player2};
        Hand[] playerPts = {player1Pts, player2Pts};
        Hand[] discardPile = {discard};
        Hand[] imageTestDeck = {imageHand1, imageHand2};

        //Deal Hands
        d1.populate();
        d1.shuffle();
        d1.drawCardPlayer1(imageTestDeck);
        for (int i = 0; i < imageTestDeck.length; i++) {
            System.out.println("Player 1's Hand is : \n" + imageTestDeck[0].showHand()  + "\n" +
                  "Player 2's Hand is : \n" + imageTestDeck[1].showHand());
             }

            //Swipe player 1's first card and place it in playerPts 2 hand

            boolean quit = false;
            int choice = 0;
            while (!quit) {
                System.out.println("Player 1 turn - Press 0 to swipe, 5 to quit ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        System.out.println("Which Card would you like to swipe? ");
                        player1.swipe(player1.cards.get(scanner.nextInt()), player2Pts);

                        System.out.println("Which Card are you using to swipe it?");
                        player2.swipe(player2.cards.get(scanner.nextInt()), discard);

                        System.out.println("Player 1's Hand is now : \n" + hands[0].showHand() + "\n" +
                                "Player 2's Hand is now: \n" + hands[1].showHand());
                        System.out.println(discard.showDiscard() + "was discarded " + "\n");
                       // System.out.println(player2Pts.getShapeValue());
                        //System.out.println(player2Pts.getColorValue());


                        //Show player 2's pts hand
                        System.out.println("Player 2" +
                                "s pts: " + playerPts[1].showHand());
                        break;
                    case 1:
                        System.out.println(player1.diceRoll());

                    case 2:
                        System.out.println(testCard);


                    case 4:
                        System.out.println(d1);


                    case 5:
                        quit = true;
                        break;

                }

            }


            // for (int i = 0; i < hands.length; i++) {
            //  System.out.println(hands[i].showHand());
            // }




        /* Swipe Move - if Player 1 card is higher than Player 2 card
            Give Player 2 card to player 1 pts deck
            Then Clear or give Player 1 card to discard array

            I need:

            - method to compare card rank in hand
            - compare card rank method
            - put two cards of the same number value to create a swipe card
            - Boolean powerToSwipe = true after drawing a swipe card, prompt player to power up a card, whatever card selected boolean
              powerToSwipe = true

            Visual Stuff

            - Draw card button that adds card to hand
            - Swipe button that discards attacker card and adds defender card to points deck
            -





         */


        }
    }


