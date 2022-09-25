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
    public ImageView activeCard;
    public Button diceRoll;

    Image backOfCardImage = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/backOfCard.jpeg"));
    Image poweredCardTestImage = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/poweredCardTest.png"));

    Deck d1 = new Deck();
    Hand imageHand1 = new Hand();
    Hand imageHand2 = new Hand();
    Hand masterHand = new Hand();
    Hand activeTurnHand = new Hand();
    Hand p1PtsHand = new Hand();
    Hand p2PtsHand = new Hand();
    Hand[] imageTestDeck = {imageHand1, imageHand2, masterHand, activeTurnHand, p1PtsHand, p2PtsHand};
    private boolean isPoweringUp = false;
    private boolean isMyTurn = true;
    private boolean isSwiping = false;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        d1.populate();
        d1.shuffle();
        PtsDeck.setImage(backOfCardImage);
    }

    @FXML public boolean isPoweringUp(){
        System.out.println("Am I powered on?" + isPoweringUp);
        return isPoweringUp = true;

    }

    @FXML public boolean isMyTurn(){
        System.out.println("Is it my turn?" + isMyTurn);
        return isMyTurn = false;
    }
    
    @FXML public boolean isSwiping() {
        System.out.println("Am I Swiping? " + isSwiping);
        return isSwiping = true;
    }
    @FXML  public int diceRoll() {
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
            p1Img1.setImage(poweredCardTestImage);
        }

        else if(imageHand1.cards.get(0).toString().contains("Silver silverSwipe") && isPoweringUp && isMyTurn) {
            p1Img1.setImage(poweredCardTestImage);
        }

        else if(imageHand1.cards.get(0).toString().contains("Gold goldSwipe") && isPoweringUp && isMyTurn) {
            p1Img1.setImage(poweredCardTestImage);
        }

        else if (isPoweringUp) {
            activeTurnHand.cards.add(imageHand1.cards.get(0));
            p1Img1.setImage(null);
            activeCard.setImage(activeTurnHand.dealHandImage(0).getImage(activeTurnHand.dealHandImage(0)));
            System.out.println("Active Card is " + activeTurnHand.showHand());
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

        if(imageHand1.cards.get(1).toString().contains("Black blackSwipe")&& isPoweringUp && isMyTurn && activeTurnHand != null) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));

        }

       else if(imageHand1.cards.get(1).toString().contains("Silver silverSwipe")&& isPoweringUp&& isMyTurn) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));


        }

        else if(imageHand1.cards.get(1).toString().contains("Gold goldSwipe")&& isPoweringUp && isMyTurn) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));


        }

        else if (isPoweringUp) {
            activeTurnHand.cards.add(imageHand1.cards.get(1));
            p1Img1.setImage(null);
            activeCard.setImage(activeTurnHand.dealHandImage(0).getImage(activeTurnHand.dealHandImage(0)));
            System.out.println("Active Card is " + activeTurnHand.showHand());

        } else{

            imageHand1.cards.remove(1);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p1Img2.setImage(null);
        }
    }

    @FXML
    public void swipeP1Img3() {

        if(imageHand1.cards.get(2).toString().contains("Black blackSwipe")&& isPoweringUp && isMyTurn && activeTurnHand != null) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));

        }

        else if(imageHand1.cards.get(2).toString().contains("Silver silverSwipe")&& isPoweringUp&& isMyTurn) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));


        }

        else if(imageHand1.cards.get(2).toString().contains("Gold goldSwipe")&& isPoweringUp && isMyTurn) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));


        }

        else if (isPoweringUp) {
            activeTurnHand.cards.add(imageHand1.cards.get(2));
            p1Img1.setImage(null);
            activeCard.setImage(activeTurnHand.dealHandImage(0).getImage(activeTurnHand.dealHandImage(0)));
            System.out.println("Active Card is " + activeTurnHand.showHand());

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

        if(imageHand1.cards.get(3).toString().contains("Black blackSwipe")&& isPoweringUp && isMyTurn && activeTurnHand != null) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));

        }

        else if(imageHand1.cards.get(3).toString().contains("Silver silverSwipe")&& isPoweringUp&& isMyTurn) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));


        }

        else if(imageHand1.cards.get(3).toString().contains("Gold goldSwipe")&& isPoweringUp && isMyTurn) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));


        }

        else if (isPoweringUp) {
            activeTurnHand.cards.add(imageHand1.cards.get(3));
            p1Img1.setImage(null);
            activeCard.setImage(activeTurnHand.dealHandImage(0).getImage(activeTurnHand.dealHandImage(0)));
            System.out.println("Active Card is " + activeTurnHand.showHand());

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

        if (imageHand1.cards.get(4).toString().contains("Black blackSwipe") && isPoweringUp && isMyTurn && activeTurnHand != null) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));

        } else if (imageHand1.cards.get(4).toString().contains("Silver silverSwipe") && isPoweringUp && isMyTurn) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));


        } else if (imageHand1.cards.get(4).toString().contains("Gold goldSwipe") && isPoweringUp && isMyTurn) {
            p1Img2.setImage(imageTestDeck[3].dealHandImage(0).getImage(imageTestDeck[3].dealHandImage(0)));


        } else if (isPoweringUp) {
            activeTurnHand.cards.add(imageHand1.cards.get(4));
            p1Img1.setImage(null);
            activeCard.setImage(activeTurnHand.dealHandImage(0).getImage(activeTurnHand.dealHandImage(0)));
            System.out.println("Active Card is " + activeTurnHand.showHand());


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

        if(isSwiping && imageHand2.cards.get(0).getrank() < activeTurnHand.cards.get(0).getrank()

                && !imageHand2.cards.get(0).toString().contains("Black blackSwipe")
                && !imageHand2.cards.get(0).toString().contains("Silver silverSwipe")
                && !imageHand2.cards.get(0).toString().contains("Gold goldSwipe")) {

            p1PtsHand.cards.add(imageHand2.cards.get(0));
            imageHand2.cards.remove(0);

            System.out.println("I just swiped your " + imageTestDeck[4].showHand() + "Mother Effer"+ "\n");
        } else
            imageHand2.cards.remove(0);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());

            p2Img1.setImage(null);


    }

    @FXML
    public void swipeP2Img2() {

        // Condition if isSwiping = true - remove and add to opposite player pts deck

        if((isSwiping && imageHand2.cards.get(1).getrank() < activeTurnHand.cards.get(0).getrank()

                && !imageHand2.cards.get(1).toString().contains("Black blackSwipe")
                && !imageHand2.cards.get(1).toString().contains("Silver silverSwipe")
                && !imageHand2.cards.get(1).toString().contains("Gold goldSwipe"))) {

            p1PtsHand.cards.add(imageHand2.cards.get(1));
            imageHand2.cards.remove(1);
            System.out.println("I just swiped your " + imageTestDeck[4].showHand() + "Mother Effer"+ "\n");

        }else

            imageHand2.cards.remove(1);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p2Img2.setImage(null);

    }
    @FXML
    public void swipeP2Img3() {

        // Condition if isSwiping = true - remove and add to opposite player pts deck

        if((isSwiping && imageHand2.cards.get(2).getrank() < activeTurnHand.cards.get(0).getrank()

                && !imageHand2.cards.get(2).toString().contains("Black blackSwipe")
                && !imageHand2.cards.get(2).toString().contains("Silver silverSwipe")
                && !imageHand2.cards.get(2).toString().contains("Gold goldSwipe"))) {

            p1PtsHand.cards.add(imageHand2.cards.get(2));
            imageHand2.cards.remove(2);
            System.out.println("I just swiped your " + imageTestDeck[4].showHand() + "Mother Effer"+ "\n");

        } else

            imageHand2.cards.remove(2);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p2Img3.setImage(null);

    }
    @FXML
    public void swipeP2Img4() {

        // Condition if isSwiping = true - remove and add to opposite player pts deck

        if((isSwiping && imageHand2.cards.get(3).getrank() < activeTurnHand.cards.get(0).getrank()

                && !imageHand2.cards.get(3).toString().contains("Black blackSwipe")
                && !imageHand2.cards.get(3).toString().contains("Silver silverSwipe")
                && !imageHand2.cards.get(3).toString().contains("Gold goldSwipe"))) {

            p1PtsHand.cards.add(imageHand2.cards.get(3));
            imageHand2.cards.remove(3);
            System.out.println("I just swiped your " + imageTestDeck[4].showHand() + "Mother Effer"+ "\n");
        } else

            imageHand2.cards.remove(3);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p2Img4.setImage(null);

    }
    @FXML
    public void swipeP2Img5() {

        // Condition if isSwiping = true - remove and add to opposite player pts deck

        if((isSwiping && imageHand2.cards.get(4).getrank() < activeTurnHand.cards.get(0).getrank()

                && !imageHand2.cards.get(4).toString().contains("Black blackSwipe")
                && !imageHand2.cards.get(4).toString().contains("Silver silverSwipe")
                && !imageHand2.cards.get(4).toString().contains("Gold goldSwipe"))) {

            p1PtsHand.cards.add(imageHand2.cards.get(4));
            imageHand2.cards.remove(4);
            System.out.println("I just swiped your " + imageTestDeck[4].showHand() + "Mother Effer"+ "\n");
        } else


            imageHand2.cards.remove(4);

            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());
            p2Img5.setImage(null);

    }

// Functionality to swipe player 2's cards if active card is higher rank
    //Add Dice functionality next


}





