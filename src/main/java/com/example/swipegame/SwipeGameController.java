package com.example.swipegame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.*;
import java.util.Iterator;


public class SwipeGameController implements Initializable {
    @FXML
    public ImageView HandImage1;
    public ImageView HandImage2;
    public ImageView MasterImg1;
    public ImageView p2Img1;
    public ImageView p2Img2;
    public ImageView p2Img3;
    public ImageView p2Img4;
    public ImageView p2Img5;
    public ImageView p1Img1;
    public ImageView p1Img2;
    public ImageView p1Img3;
    public ImageView p1Img4;
    public ImageView p1Img5;
    public ImageView MasterCard;
    public ImageView PtsDeck;
    public Button powerButton;
    public Button passTurn;
    public Button swipeButton;
    public ImageView activePowerCard;
    public Button diceRoll;
    public ImageView activeSwipeCard;
    public ImageView die1;
    public ImageView die2;

    Image backOfCardImage = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/backOfCard.jpeg"));
    Image poweredCardTestImage = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/poweredCardTest.png"));



    Deck d1 = new Deck();
    Hand imageHand1 = new Hand();
    Hand imageHand2 = new Hand();
    Hand masterHand = new Hand();
    Hand activePowerCardHand = new Hand();
    Hand activeSwipeCardHand = new Hand();
    Hand p1PtsHand = new Hand();
    Hand p2PtsHand = new Hand();
    Hand[] imageTestDeck = {imageHand1, imageHand2, masterHand, activePowerCardHand, activeSwipeCardHand, p1PtsHand, p2PtsHand};
    private boolean isPoweringUp = false;
    private boolean isMyTurn = true;
    private boolean isSwiping = false;
    int goldRank = 0;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        d1.populate();
        d1.shuffle();
        PtsDeck.setImage(backOfCardImage);
    }

    @FXML public boolean isPoweringUp(){
        System.out.println("Powered On!");
        return isPoweringUp = true;

    }

    @FXML public boolean isMyTurn(){
        System.out.println("Is it my turn?" + isMyTurn);
        return isMyTurn = false;
    }
    
    @FXML public boolean isSwiping() {
        System.out.println("Swipe It Baby!");
        return isSwiping = true;
    }
    @FXML  public int diceRoll() {
        int blackDie = (int) (Math.random() * 6) + 1;
        int whiteDie = (int) (Math.random() * 6) + 1;
        int winner = 0;
        for (int i = 0; i < 1; i++) {
            System.out.println("Black Die is : " + blackDie);
            Image dieImage1 = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/" + "Die" + blackDie + ".jpg"));
            die1.setImage(dieImage1);
            System.out.println("White Die is : " + whiteDie);
            Image dieImage2 = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/" + "Die" + whiteDie + ".jpg"));
            die2.setImage(dieImage2);


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


    @FXML
    public void dealMaster() {
        d1.drawMasterCard(imageTestDeck);
        int i = 0;
        for (Card c : masterHand.cards) {
            MasterCard.setImage(imageTestDeck[2].dealHandImage(i).getImage(imageTestDeck[2].dealHandImage(i)));
            i++;

        }
    }

    @FXML
    public void drawCard1() {
        d1.drawCardPlayer1(imageTestDeck);
        ArrayList<ImageView> cardImagesP1 = new ArrayList(Arrays.asList(p1Img1, p1Img2, p1Img3, p1Img4, p1Img5));
        Iterator<ImageView> it = cardImagesP1.iterator();
        int i = 0;

        for (Card c : imageHand1.cards) {
            it.next().setImage(imageTestDeck[0].dealHandImage(i).getImage(imageTestDeck[0].dealHandImage(i)));
            i++;

        }

        System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
    }

    @FXML
    public void drawCard2() {
        d1.drawCardPlayer2(imageTestDeck);
        ArrayList<ImageView> cardImagesP2 = new ArrayList(Arrays.asList(p2Img1, p2Img2, p2Img3, p2Img4, p2Img5));
        Iterator<ImageView> it = cardImagesP2.iterator();
        int i = 0;

        for (Card c : imageHand1.cards) {
            it.next().setImage(imageTestDeck[1].dealHandImage(i).getImage(imageTestDeck[1].dealHandImage(i)));
            i++;

        }
        System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());

    }

    @FXML
    public void swipeP1Img1() {

        if(imageHand1.cards.get(0).toString().contains("Black blackSwipe") && isPoweringUp && isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(0));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
        }

        else if(imageHand1.cards.get(0).toString().contains("Silver silverSwipe") && isPoweringUp && isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(0));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
        }

        else if(imageHand1.cards.get(0).toString().contains("Gold goldSwipe") && isPoweringUp && isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(0));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            goldRank = 2;
        }

        else if (isPoweringUp) {
            activePowerCardHand.cards.add(imageHand1.cards.get(0));
            p1Img1.setImage(null);
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
            System.out.println("Active Card is " + activePowerCardHand.showHand());
        }



         else {

            imageHand1.cards.remove(0);


            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand() + "Active Turn Hand is " + imageTestDeck[3].showHand() + "\n");
            p1Img1.setImage(null);


        }

    }

    @FXML
    public void swipeP1Img2() {

        // If you are pressing a swipe card and the conditions isPoweringUp and isMyTurn are true then set image of the card
        // previously placed in activeTurnHand (Which will later take that string and use it to find the image of that card with this swipe card

        if(imageHand1.cards.get(1).toString().contains("Black blackSwipe")&& isPoweringUp && isMyTurn && activePowerCardHand != null) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));

        }

       else if(imageHand1.cards.get(1).toString().contains("Silver silverSwipe")&& isPoweringUp&& isMyTurn && activePowerCardHand != null) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));


        }

        else if(imageHand1.cards.get(1).toString().contains("Gold goldSwipe")&& isPoweringUp && isMyTurn && activePowerCardHand != null) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            goldRank = 2;


        }

        else if (isPoweringUp) {
            activePowerCardHand.cards.add(imageHand1.cards.get(1));
            p1Img2.setImage(null);
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
            System.out.println("Active Card is " + activePowerCardHand.showHand());

        } else{

            imageHand1.cards.remove(1);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p1Img2.setImage(null);
        }
    }

    @FXML
    public void swipeP1Img3() {

        if(imageHand1.cards.get(2).toString().contains("Black blackSwipe")&& isPoweringUp && isMyTurn && activePowerCardHand != null) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(2));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));

        }

        else if(imageHand1.cards.get(2).toString().contains("Silver silverSwipe")&& isPoweringUp&& isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(2));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));


        }

        else if(imageHand1.cards.get(2).toString().contains("Gold goldSwipe")&& isPoweringUp && isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(2));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            goldRank = 2;


        }

        else if (isPoweringUp) {
            activePowerCardHand.cards.add(imageHand1.cards.get(2));
            p1Img3.setImage(null);
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
            System.out.println("Active Card is " + activePowerCardHand.showHand());

        }


        else{
            imageHand1.cards.remove(2);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p1Img3.setImage(null);
        }
    }

    @FXML
    public void swipeP1Img4() {

        if(imageHand1.cards.get(3).toString().contains("Black blackSwipe")&& isPoweringUp && isMyTurn && activePowerCardHand != null) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(3));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));

        }

        else if(imageHand1.cards.get(3).toString().contains("Silver silverSwipe")&& isPoweringUp&& isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(3));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));


        }

        else if(imageHand1.cards.get(3).toString().contains("Gold goldSwipe")&& isPoweringUp && isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(3));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            goldRank = 2;


        }

        else if (isPoweringUp) {
            activePowerCardHand.cards.add(imageHand1.cards.get(3));
            p1Img4.setImage(null);
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
            System.out.println("Active Card is " + activePowerCardHand.showHand());

        }

        else{

            imageHand1.cards.remove(3);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p1Img4.setImage(null);
        }
    }

    @FXML
    public void swipeP1Img5() {

        if (imageHand1.cards.get(4).toString().contains("Black blackSwipe") && isPoweringUp && isMyTurn && activePowerCardHand != null) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(4));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));

        } else if (imageHand1.cards.get(4).toString().contains("Silver silverSwipe") && isPoweringUp && isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(4));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));


        } else if (imageHand1.cards.get(4).toString().contains("Gold goldSwipe") && isPoweringUp && isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(4));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            goldRank = 2;


        } else if (isPoweringUp) {
            activePowerCardHand.cards.add(imageHand1.cards.get(4));
            p1Img5.setImage(null);
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
            System.out.println("Active Card is " + activePowerCardHand.showHand());


        } else {

            imageHand1.cards.remove(4);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p1Img5.setImage(null);
        }
    }



    @FXML
    public void swipeP2Img1() {

        // Condition if isSwiping = true and it is not a swipe card then remove and add to opposite player pts deck

        if(isSwiping && imageHand2.cards.get(0).getrank() < activePowerCardHand.cards.get(0).getrank() + goldRank

                && !imageHand2.cards.get(0).toString().contains("Black blackSwipe")
                && !imageHand2.cards.get(0).toString().contains("Silver silverSwipe")
                && !imageHand2.cards.get(0).toString().contains("Gold goldSwipe")) {

            p1PtsHand.cards.add(imageHand2.cards.get(0));
            imageHand2.cards.remove(0);

            System.out.println("I just swiped your " + p1PtsHand.showHand() + "Mother Effer"+ "\n");
        } else
            imageHand2.cards.remove(0);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());

            p2Img1.setImage(null);


    }

    @FXML
    public void swipeP2Img2() {

        // Condition if isSwiping = true - remove and add to opposite player pts deck

        if((isSwiping && imageHand2.cards.get(1).getrank() < activePowerCardHand.cards.get(0).getrank() + goldRank

                && !imageHand2.cards.get(1).toString().contains("Black blackSwipe")
                && !imageHand2.cards.get(1).toString().contains("Silver silverSwipe")
                && !imageHand2.cards.get(1).toString().contains("Gold goldSwipe"))) {

            p1PtsHand.cards.add(imageHand2.cards.get(1));
            imageHand2.cards.remove(1);
            System.out.println("I just swiped your " + p1PtsHand.showHand() + "Mother Effer"+ "\n");

        }else

            imageHand2.cards.remove(1);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p2Img2.setImage(null);

    }
    @FXML
    public void swipeP2Img3() {

        // Condition if isSwiping = true - remove and add to opposite player pts deck

        if((isSwiping && imageHand2.cards.get(2).getrank() < activePowerCardHand.cards.get(0).getrank() + goldRank

                && !imageHand2.cards.get(2).toString().contains("Black blackSwipe")
                && !imageHand2.cards.get(2).toString().contains("Silver silverSwipe")
                && !imageHand2.cards.get(2).toString().contains("Gold goldSwipe"))) {

            p1PtsHand.cards.add(imageHand2.cards.get(2));
            imageHand2.cards.remove(2);
            System.out.println("I just swiped your " + p1PtsHand.showHand() + "Mother Effer"+ "\n");

        } else

            imageHand2.cards.remove(2);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p2Img3.setImage(null);

    }
    @FXML
    public void swipeP2Img4() {

        // Condition if isSwiping = true - remove and add to opposite player pts deck

        if((isSwiping && imageHand2.cards.get(3).getrank() < activePowerCardHand.cards.get(0).getrank() + goldRank

                && !imageHand2.cards.get(3).toString().contains("Black blackSwipe")
                && !imageHand2.cards.get(3).toString().contains("Silver silverSwipe")
                && !imageHand2.cards.get(3).toString().contains("Gold goldSwipe"))) {

            p1PtsHand.cards.add(imageHand2.cards.get(3));
            imageHand2.cards.remove(3);
            System.out.println("I just swiped your " + p1PtsHand.showHand() + "Mother Effer"+ "\n");
        } else

            imageHand2.cards.remove(3);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p2Img4.setImage(null);

    }
    @FXML
    public void swipeP2Img5() {

        // Condition if isSwiping = true - remove and add to opposite player pts deck

        if((isSwiping && imageHand2.cards.get(4).getrank() < activePowerCardHand.cards.get(0).getrank() + goldRank

                && !imageHand2.cards.get(4).toString().contains("Black blackSwipe")
                && !imageHand2.cards.get(4).toString().contains("Silver silverSwipe")
                && !imageHand2.cards.get(4).toString().contains("Gold goldSwipe"))) {

            p1PtsHand.cards.add(imageHand2.cards.get(4));
            imageHand2.cards.remove(4);
            System.out.println("I just swiped your " + p1PtsHand.showHand() + "Mother Effer"+ "\n");
        } else


            imageHand2.cards.remove(4);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p2Img5.setImage(null);

    }

// Functionality to swipe player 2's cards if active card is higher rank
    //Add Dice functionality next
    //Remember to clear gold rank


}





