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


    public ImageView p1Img1;
    public ImageView p1Img2;
    public ImageView p1Img3;
    public ImageView p1Img4;
    public ImageView p1Img5;
    public ImageView p1Img6;
    public ImageView p1Img7;
    public ImageView p1Img8;
    public ImageView p1Img9;
    public ImageView p1Img10;


    public ImageView p2Img1;
    public ImageView p2Img2;
    public ImageView p2Img3;
    public ImageView p2Img4;
    public ImageView p2Img5;
    public ImageView p2Img6;
    public ImageView p2Img7;
    public ImageView p2Img8;
    public ImageView p2Img9;
    public ImageView p2Img10;


    public ImageView p1ActiveImg1;
    public ImageView p1ActiveImg2;
    public ImageView p1ActiveImg3;
    public ImageView p1ActiveImg4;
    public ImageView p1ActiveImg5;
    public ImageView p1ActiveImg6;
    public ImageView p1ActiveImg7;
    public ImageView p1ActiveImg8;
    public ImageView p1ActiveImg9;
    public ImageView p1ActiveImg10;


    public ImageView p2ActiveImg1;
    public ImageView p2ActiveImg2;
    public ImageView p2ActiveImg3;
    public ImageView p2ActiveImg4;
    public ImageView p2ActiveImg5;
    public ImageView p2ActiveImg6;
    public ImageView p2ActiveImg7;
    public ImageView p2ActiveImg8;
    public ImageView p2ActiveImg9;
    public ImageView p2ActiveImg10;


    public ImageView MasterCard;
    public ImageView P1PtsDeck;
    public Button powerButton;
    public Button passTurn;
    public Button swipeButton;
    public ImageView activePowerCard;
    public Button diceRoll;
    public ImageView activeSwipeCard;
    public ImageView die1;
    public ImageView die2;
    public Button clearActiveCards;
    public Button setActiveImages;
    public Button setMergedCards;
    public Button undoSetCards;
    public Button comparePowerCards;
    public Button resetActiveCards;
    public Button p1Pts;
    public Button p2Pts;
    public Button resetActivatedImages;
    public ImageView P2PtsDeck;
    public ImageView drawCard;
    public Button resetActivatedCards;
    public Button endTurn;

    ArrayList<ImageView> activeImagesArrayP2 = new ArrayList(Arrays.asList(p2ActiveImg1, p2ActiveImg2, p2ActiveImg3, p2ActiveImg4, p2ActiveImg5, p2ActiveImg6, p2ActiveImg7, p2ActiveImg8, p2ActiveImg9, p2ActiveImg10));


    Image backOfCardImage = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/backOfCard.jpg"));
    Image poweredCardTestImage = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/poweredCardTest.png"));

    //ArrayList<ArrayList<Card>> activatedCards = new ArrayList<ArrayList<Card>>();
    ArrayList<Card> p1actvArr1 = new ArrayList<Card>();
    ArrayList<Card> p1actvArr2 = new ArrayList<Card>();
    ArrayList<Card> p1actvArr3 = new ArrayList<Card>();
    ArrayList<Card> p1actvArr4 = new ArrayList<Card>();
    ArrayList<Card> p1actvArr5 = new ArrayList<Card>();
    ArrayList<Card> p1actvArr6 = new ArrayList<Card>();
    ArrayList<Card> p1actvArr7 = new ArrayList<Card>();
    ArrayList<Card> p1actvArr8 = new ArrayList<Card>();
    ArrayList<Card> p1actvArr9 = new ArrayList<Card>();
    ArrayList<Card> p1actvArr10 = new ArrayList<Card>();

    ArrayList<Card> p2actvArr1 = new ArrayList<Card>();
    ArrayList<Card> p2actvArr2 = new ArrayList<Card>();
    ArrayList<Card> p2actvArr3 = new ArrayList<Card>();
    ArrayList<Card> p2actvArr4 = new ArrayList<Card>();
    ArrayList<Card> p2actvArr5 = new ArrayList<Card>();
    ArrayList<Card> p2actvArr6 = new ArrayList<Card>();
    ArrayList<Card> p2actvArr7 = new ArrayList<Card>();
    ArrayList<Card> p2actvArr8 = new ArrayList<Card>();
    ArrayList<Card> p2actvArr9 = new ArrayList<Card>();
    ArrayList<Card> p2actvArr10 = new ArrayList<Card>();

    ArrayList<ArrayList<Card>> activatedCardsP1 = new ArrayList(Arrays.asList(p1actvArr1, p1actvArr2, p1actvArr3, p1actvArr4, p1actvArr5,
            p1actvArr6, p1actvArr7, p1actvArr8, p1actvArr9, p1actvArr10));

    ArrayList<ArrayList<Card>> activatedCardsP2 = new ArrayList(Arrays.asList(p2actvArr1, p2actvArr2, p2actvArr3, p2actvArr4, p2actvArr5,
            p2actvArr6, p2actvArr7, p2actvArr8, p2actvArr9, p2actvArr10));






    Deck d1 = new Deck();
    Hand imageHand1 = new Hand();
    Hand imageHand2 = new Hand();
    Hand masterHand = new Hand();
    Hand activePowerCardHand = new Hand();
    Hand activeSwipeCardHand = new Hand();
    Hand p1PtsHand = new Hand();
    Hand p2PtsHand = new Hand();
    Hand comparePowerCardsP1 = new Hand();
    Hand comparePowerCardsP2 = new Hand();
    Hand[] imageTestDeck = {imageHand1, imageHand2, masterHand, activePowerCardHand, activeSwipeCardHand, p1PtsHand, p2PtsHand};
    private boolean isPoweringUp = true;
    private boolean isMyTurn = true;
    private boolean isSwiping = false;
    private boolean isComparing = false;
    int goldRank = 0;
    int diceRollState = 3;
    private boolean oneRollWin = false;
    int activePowerInt = 0;
    int activeSwipeInt = 0;
    int swipePos = 0;
    int powerPos = 0;
    int compareCardsPos1 = 0;
    int compareCardsPos2 = 0;
    public boolean swipeP1;
    public boolean swipeP2;
    public boolean swipeP1A1;
    public boolean swipeP2A2;
    public boolean endTurnBoolean = false;







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        d1.populate();
        d1.shuffle();
        dealMaster();
        P1PtsDeck.setImage(backOfCardImage);
        P2PtsDeck.setImage(backOfCardImage);
        drawCard.setImage(backOfCardImage);
        isEndTurnBoolean();
    }

    @FXML public boolean isPoweringUp(){
        if(isPoweringUp) {
            System.out.println("Powered off ");
            return isPoweringUp = false;
        }
        else {
            System.out.println("Powered On!");
        }
        return isPoweringUp = true;
    }


    @FXML public boolean isMyTurn(){
       if(isMyTurn){
           System.out.println("Player 2 Turn");
           return isMyTurn = false;
       } else {
           System.out.println("Player 1 Turn");
       }
        diceRollState = 3;
        goldRank = 0;
        activePowerInt = 0;
        activeSwipeInt = 0;
        isSwiping = false;
        isComparing = false;
        return isMyTurn = true;
    }

    @FXML public boolean isEndTurnBoolean() {
        if (endTurnBoolean) {
            System.out.println("Ended Turn - Player 2 Draw "+ "\n");
            return endTurnBoolean = false;
        }
        else {
            System.out.println("Ended Turn - Player 1 Draw "+ "\n");
        }
        return endTurnBoolean = true;
    }

    @FXML public void setCards() {
        if (isMyTurn) {
            setActiveImagesP1();
        }
        else {
            setActiveImagesP2();
        }
    }



    @FXML public boolean drawAndPass(){
        if(isMyTurn){
            System.out.println("Player 2 Turn");
            drawCard2();
            return isMyTurn = false;

        } else {
            System.out.println("Player 1 Turn");
            drawCard1();
        }
        diceRollState = 3;
        goldRank = 0;
        activePowerInt = 0;
        activeSwipeInt = 0;
        isSwiping = false;
        isComparing = false;
        return isMyTurn = true;
    }

    @FXML public void drawCard () {
        if(endTurnBoolean) {
            drawAndPass();
            endTurnBoolean = false;
        }
        else {
            System.out.println("Must end Turn ");
        }
    }


    @FXML public boolean isSwiping() {
        if(isSwiping) {
            System.out.println("Not Swiping ");
            return isSwiping = false;
        }
        else {
            System.out.println("Swipe It Baby!");
        }
        return isSwiping = true;
    }

    @FXML public boolean isComparing() {
        if(isComparing) {
            System.out.println("Compare disabled ");
            isPoweringUp = true;
            return isComparing = false;

        }
        else {
            System.out.println("Compare enabled");
            isPoweringUp = false;
        }
        return isComparing = true;
    }

    @FXML public void clearActiveCards(){
        activeSwipeCardHand.clear();
        activePowerCardHand.clear();
        activePowerCard.setImage(null);
        activeSwipeCard.setImage(null);
        System.out.println("Active Cards Have Been Cleared");
    }


    @FXML  public int diceRoll() {
        int blackDie = (int) (Math.random() * 6) + 1;
        int whiteDie = (int) (Math.random() * 6) + 1;
        for (int i = 0; i < 1; i++) {

            System.out.println("Black Die is : " + blackDie);
            Image dieImage1 = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/" + "Die" + blackDie + ".jpg"));
            die1.setImage(dieImage1);
            System.out.println("White Die is : " + whiteDie);
            Image dieImage2 = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/" + "Die" + whiteDie + ".jpg"));
            die2.setImage(dieImage2);


            if (blackDie < whiteDie) {

                if(oneRollWin) {
                    diceRollState = 0;
                    System.out.println("White Die WIN" + "\n");
                    oneRollWin = false;
                } else {
                    System.out.println("Roll again" + "\n");
                    oneRollWin = true;
                    diceRollState = 3;
                }

            }

           else if (blackDie > whiteDie) {
                System.out.println("Black Die WIN"+ "\n");
                diceRollState = 1;
                oneRollWin = false;
            }

           else if (blackDie == whiteDie) {
               if(oneRollWin) {
                   System.out.println("TIE! " + diceRollState + "\n");
                   diceRollState = 3;
               } else {
                   System.out.println("TIE!" + "\n");
                   diceRollState = 2;
                   oneRollWin = false;
               }

            }
        }
        System.out.println("The state is " + diceRollState + " " + oneRollWin + "\n");
            return diceRollState;


    }


    @FXML
    public void dealMaster() {
        d1.drawMasterCard(imageTestDeck);
        int i = 0;
        if(masterHand.cards.get(0).toString().contains("Swipe")) {
            d1.add(masterHand.cards.get(0));
            masterHand.cards.remove(0);

        }

        for (Card c : masterHand.cards) {
            MasterCard.setImage(imageTestDeck[2].dealHandImage(i).getImage(imageTestDeck[2].dealHandImage(i)));
            i++;

        }
        System.out.println(masterHand.cards.toString() + "\n" + d1.cards.size());
    }


    @FXML
    public void resetImagesP1() {
        int i = 0;
        ArrayList<ImageView> cardImagesP1 = new ArrayList(Arrays.asList(p1Img1, p1Img2, p1Img3, p1Img4, p1Img5, p1Img6, p1Img7, p1Img8, p1Img9, p1Img10));
        Iterator<ImageView> it = cardImagesP1.iterator();

        if (imageTestDeck[0].cards.isEmpty()) {
            cardImagesP1.get(0).setImage(null);
        } else {

            for (Card c : imageHand1.cards) {
                it.next().setImage(imageTestDeck[0].dealHandImage(i).getImage(imageTestDeck[0].dealHandImage(i)));
                i++;
                cardImagesP1.get(i).setImage(null);
            }
        }
    }



    @FXML
    public void resetImagesP2() {
        int i = 0;
        ArrayList<ImageView> cardImagesP2 = new ArrayList(Arrays.asList(p2Img1, p2Img2, p2Img3, p2Img4, p2Img5, p2Img6, p2Img7, p2Img8, p2Img9, p2Img10));
        Iterator<ImageView> it = cardImagesP2.iterator();

        if (imageTestDeck[1].cards.isEmpty()) {
            cardImagesP2.get(0).setImage(null);
        }

        else {

            for (Card c : imageHand2.cards) {

                it.next().setImage(imageTestDeck[1].dealHandImage(i).getImage(imageTestDeck[1].dealHandImage(i)));
                i++;
                cardImagesP2.get(i).setImage(null);
            }
        }
    }




    @FXML
    public void drawCard1() {
        int i = 0;

            d1.drawCardPlayer1(imageTestDeck);
            ArrayList<ImageView> cardImagesP1 = new ArrayList(Arrays.asList(p1Img1, p1Img2, p1Img3, p1Img4, p1Img5, p1Img6, p1Img7, p1Img8, p1Img9, p1Img10));
            Iterator<ImageView> it = cardImagesP1.iterator();

            for (Card c : imageHand1.cards) {
                if (!d1.cards.isEmpty()) {
                    it.next().setImage(imageTestDeck[0].dealHandImage(i).getImage(imageTestDeck[0].dealHandImage(i)));
                    //it.next().setImage(imageTestDeck[0].dealHandImage(i).getMergedImageBlack(imageTestDeck[0].dealHandImage(i)));

                    i++;

                }
                else {
                    System.out.println("Game Over! ");
                }
            }
            System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                    "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());

    }

    @FXML
    public void drawCard2() {
        d1.drawCardPlayer2(imageTestDeck);
        ArrayList<ImageView> cardImagesP2 = new ArrayList(Arrays.asList(p2Img1, p2Img2, p2Img3, p2Img4, p2Img5, p2Img6, p2Img7, p2Img8, p2Img9, p2Img10));
        Iterator<ImageView> it = cardImagesP2.iterator();
        int i = 0;

        for (Card c : imageHand2.cards) {
            if (!d1.cards.isEmpty()) {
                it.next().setImage(imageTestDeck[1].dealHandImage(i).getImage(imageTestDeck[1].dealHandImage(i)));
                i++;

            }
            else {
                System.out.println("Game Over! ");
            }
        }
        System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());

    }

    @FXML
    public void swipeP1(int pos){
        if (!isMyTurn && activeSwipeCardHand.cards.get(0).toString().contains("Gold")) {
            goldRank = 2;
        }

        if(!isMyTurn && imageHand1.cards.get(pos).getrank() < activePowerCardHand.cards.get(0).getrank() + goldRank

                && !imageHand1.cards.get(pos).toString().contains("Swipe")) {

            p2PtsHand.cards.add(imageHand1.cards.get(pos));
            imageHand1.cards.remove(pos);
            resetImagesP1();
            System.out.println("I just swiped your " + p2PtsHand.showHand() + "Mother Effer"+ "\n");
            swipeP1 = true;

        } else if(imageTestDeck[0].cards.get(pos).toString().isEmpty()) {
            System.out.println("Add Swipe P1 Empty " + "\n");
        }

        else {
            System.out.println("Problem with Swipe p1 " + "\n");
            swipeP1 = false;
        }

        goldRank = 0;
    }


    @FXML
    public void swipeP2(int pos){

        if (isMyTurn && activeSwipeCardHand.cards.get(0).toString().contains("Gold")) {
            goldRank = 2;
        }

        if(isMyTurn && imageHand2.cards.get(pos).getrank() < activePowerCardHand.cards.get(0).getrank() + goldRank

                && !imageHand2.cards.get(pos).toString().contains("Swipe")) {

            p1PtsHand.cards.add(imageHand2.cards.get(pos));
            imageHand2.cards.remove(pos);
            resetImagesP2();
            System.out.println("I just swiped your " + p1PtsHand.showHand() + "Mother Effer"+ "\n");
            swipeP2 = true;

        }
        else if(imageTestDeck[1].cards.get(pos).toString().isEmpty()) {
            System.out.println("Add Swipe P1 Empty " + "\n");
        }
        else {
            System.out.println("Problem with Swipe p2 " + "\n");
            swipeP2 = false;
        }

        goldRank = 0;
    }

    @FXML public void swipeP1A1(int pos) {

        if (!isMyTurn && activeSwipeCardHand.cards.get(0).toString().contains("Gold")) {
            goldRank = 2;
        }

        if(isMyTurn && activatedCardsP1.get(pos).get(0).getrank() < activePowerCardHand.cards.get(0).getrank() + goldRank) {

            p2PtsHand.cards.add(activatedCardsP1.get(pos).get(0));
            activatedCardsP1.get(pos).remove(0);
            imageHand1.add(activatedCardsP1.get(pos).get(0));
            activatedCardsP1.get(pos).remove(0);
            clearActiveCards();
            resetImagesP1();
            resetActivatedCardsP1();
            resetActiveImagesP1();
            System.out.println("I just swiped your " + p2PtsHand.showHand() + "Mother Effer"+ "\n");
            swipeP1A1 = true;

        } else if(activatedCardsP1.get(pos).get(0).toString().isEmpty()) {
            System.out.println("Add Swipe P1 Empty " + "\n");
        }

        else {
            System.out.println("Problem with Swipe p1A1 " + "\n");
            swipeP1A1 = false;
        }
        goldRank = 0;
    }

    @FXML public void swipeP2A2(int pos) {

        if (isMyTurn && activeSwipeCardHand.cards.get(0).toString().contains("Gold")) {
            goldRank = 2;
        }

        if(isMyTurn && activatedCardsP2.get(pos).get(0).getrank() < activePowerCardHand.cards.get(0).getrank() + goldRank) {

            p1PtsHand.cards.add(activatedCardsP2.get(pos).get(0));
            activatedCardsP2.get(pos).remove(0);
            imageHand2.add(activatedCardsP2.get(pos).get(0));
            activatedCardsP2.get(pos).remove(0);
            clearActiveCards();
            setActiveImagesP2();
            resetImagesP2();
            resetActivatedCardsP2();
            resetActiveImagesP2();
            System.out.println("I just swiped your " + p1PtsHand.showHand() + "Mother Effer"+ "\n");
            swipeP2A2 = true;

        } else if(activatedCardsP2.get(pos).get(0).toString().isEmpty()) {
            System.out.println("Add Swipe P2 Empty " + "\n");
        }

        else {
            System.out.println("Problem with Swipe p2A2 " + "\n");
            swipeP2A2 = false;
        }

        goldRank = 0;

    }



    @FXML
    public void swipeDieP1 (int pos){

        if (!isMyTurn && activeSwipeCardHand.cards.get(0).toString().contains("Gold")) {
            goldRank = 2;
        }

        if (!isMyTurn && imageHand1.cards.get(pos).getrank() > activePowerCardHand.cards.get(0).getrank() + goldRank) {
            if (diceRollState == 0) {

                p2PtsHand.cards.add(imageHand1.cards.get(pos));
                imageHand1.cards.remove(pos);
                resetImagesP1();
                goldRank = 0;
                System.out.println("I win the dice roll and I just swiped your " + p2PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
                p1PtsHand.add(activePowerCardHand.cards.get(0));
                System.out.println(" I just got your " + activePowerCardHand.cards.get(0) + "\n");
                clearActiveCards();
                goldRank = 0;
            }
            else if (diceRollState == 2) {
                System.out.println("Roll again! We Tied"  + "\n");
            }

            else System.out.println("Roll the dice big hog"  + "\n");
        }

        //Dice Roll if tied

        else if (!isMyTurn && imageHand1.cards.get(pos).getrank() == activePowerCardHand.cards.get(0).getrank() + goldRank) {
            oneRollWin = true;
            if (diceRollState == 0) {

                p2PtsHand.cards.add(imageHand1.cards.get(pos));
                imageHand1.cards.remove(pos);
                resetImagesP1();
                goldRank = 0;
                System.out.println("I win the dice roll and I just swiped your " + p2PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
                goldRank = 0;
            }
            else if (diceRollState == 2) {
                System.out.println("Roll again! We Tied"  + "\n");
            }

            else System.out.println("Roll the dice big hog"  + "\n");

        }
    }

    @FXML
    public void swipeDieP1A1 (int pos){

        if (!isMyTurn && activeSwipeCardHand.cards.get(0).toString().contains("Gold")) {
            goldRank = 2;
        }

        if (!isMyTurn && activatedCardsP1.get(pos).get(0).getrank() > activePowerCardHand.cards.get(0).getrank() + goldRank) {
            if (diceRollState == 0) {

                p2PtsHand.cards.add(activatedCardsP1.get(pos).get(0));
                activatedCardsP1.get(pos).remove(0);
                imageHand1.add(activatedCardsP1.get(pos).get(0));
                activatedCardsP1.get(pos).remove(0);
                clearActiveCards();
                resetImagesP1();
                resetActivatedCardsP1();
                resetActiveImagesP1();
                goldRank = 0;
                System.out.println("I win the dice roll and I just swiped your " + p2PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
                p1PtsHand.add(activePowerCardHand.cards.get(0));
                System.out.println(" I just got your " + activePowerCardHand.cards.get(0) + "\n");
                clearActiveCards();
                goldRank = 0;
            }
            else if (diceRollState == 2) {
                System.out.println("Roll again! We Tied"  + "\n");
            }

            else System.out.println("Roll the dice big hog"  + "\n");
        }

        //Dice Roll if tied

        else if (!isMyTurn && activatedCardsP1.get(pos).get(0).getrank() == activePowerCardHand.cards.get(0).getrank() + goldRank) {
            oneRollWin = true;
            if (diceRollState == 0) {

                p2PtsHand.cards.add(activatedCardsP1.get(pos).get(0));
                activatedCardsP1.get(pos).remove(0);
                imageHand1.add(activatedCardsP1.get(pos).get(0));
                activatedCardsP1.get(pos).remove(0);
                clearActiveCards();
                setActiveImagesP1();
                resetImagesP1();
                goldRank = 0;
                System.out.println("I win the dice roll and I just swiped your " + p2PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
                goldRank = 0;
            }
            else if (diceRollState == 2) {
                System.out.println("Roll again! We Tied"  + "\n");
            }

            else System.out.println("Roll the dice big hog"  + "\n");

        }
    }

    @FXML
    public void swipeDieP2A2 (int pos){

        if (isMyTurn && activeSwipeCardHand.cards.get(0).toString().contains("Gold")) {
            goldRank = 2;
        }

        if (isMyTurn && activatedCardsP2.get(pos).get(0).getrank() > activePowerCardHand.cards.get(0).getrank() + goldRank) {
            if (diceRollState == 0) {

                p1PtsHand.cards.add(activatedCardsP2.get(pos).get(0));
                activatedCardsP2.get(pos).remove(0);
                imageHand2.add(activatedCardsP2.get(pos).get(0));
                activatedCardsP2.get(pos).remove(0);
                clearActiveCards();
                resetImagesP2();
                resetActivatedCardsP2();
                resetActiveImagesP2();
                goldRank = 0;
                System.out.println("I win the dice roll and I just swiped your " + p1PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
                p2PtsHand.add(activePowerCardHand.cards.get(0));
                System.out.println(" I just got your " + activePowerCardHand.cards.get(0) + "\n");
                clearActiveCards();
                goldRank = 0;
            }
            else if (diceRollState == 2) {
                System.out.println("Roll again! We Tied"  + "\n");
            }

            else System.out.println("Roll the dice big hog"  + "\n");
        }

        //Dice Roll if tied

        else if (isMyTurn && activatedCardsP2.get(pos).get(0).getrank() == activePowerCardHand.cards.get(0).getrank() + goldRank) {
            oneRollWin = true;
            if (diceRollState == 0) {

                p1PtsHand.cards.add(activatedCardsP2.get(pos).get(0));
                activatedCardsP2.get(pos).remove(0);
                imageHand2.add(activatedCardsP2.get(pos).get(0));
                activatedCardsP2.get(pos).remove(0);
                clearActiveCards();
                setActiveImagesP2();
                resetImagesP2();
                goldRank = 0;
                System.out.println("I win the dice roll and I just swiped your " + p1PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
                goldRank = 0;
            }
            else if (diceRollState == 2) {
                System.out.println("Roll again! We Tied"  + "\n");
            }

            else System.out.println("Roll the dice big hog"  + "\n");

        }
    }

    @FXML
    public void swipeDieP2 (int pos){

        if (isMyTurn && activeSwipeCardHand.cards.get(0).toString().contains("Gold")) {
            goldRank = 2;
        }

        if (isSwiping && isMyTurn && imageHand2.cards.get(pos).getrank() > activePowerCardHand.cards.get(0).getrank() + goldRank) {
            if (diceRollState == 0) {

                p1PtsHand.cards.add(imageHand2.cards.get(pos));
                imageHand2.cards.remove(pos);
                resetImagesP2();
                goldRank = 0;
                System.out.println("I win the dice roll and I just swiped your " + p1PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
                p2PtsHand.add(activePowerCardHand.cards.get(0));
                System.out.println(" I just got your " + activePowerCardHand.cards.get(0) + "\n");
                clearActiveCards();
                goldRank = 0;
            }
            else if (diceRollState == 2) {
                System.out.println("Roll again! We Tied"  + "\n");
            }

            else System.out.println("Roll the dice big hog"  + "\n");
        }

        //Dice Roll if tied

        else if (isMyTurn && imageHand2.cards.get(pos).getrank() == activePowerCardHand.cards.get(0).getrank() + goldRank) {
            oneRollWin = true;
            if (diceRollState == 0) {

                p1PtsHand.cards.add(imageHand2.cards.get(pos));
                imageHand2.cards.remove(pos);
                resetImagesP2();
                goldRank = 0;
                System.out.println("I win the dice roll and I just swiped your " + p1PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
                goldRank = 0;
            }
            else if (diceRollState == 2) {
                System.out.println("Roll again! We Tied"  + "\n");
            }

            else System.out.println("Roll the dice big hog"  + "\n");

        }
    }

    @FXML
    public int addSwipeP1(int pos) {

        if (imageHand1.cards.get(pos).toString().contains("Gold goldSwipe") && isPoweringUp && isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(pos));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            imageHand1.cards.remove(pos);
            swipePos = pos;
            goldRank = 2;
        }
        else if (imageHand1.cards.get(pos).toString().contains("Swipe") && isPoweringUp && isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand1.cards.get(pos));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            imageHand1.cards.remove(pos);
            swipePos = pos;

            System.out.println("You have " + imageHand1.showHand());

        } else if(imageTestDeck[0].cards.get(pos).toString().isEmpty()) {
            System.out.println("Add Swipe P1 Empty " + "\n");
        }

        else {
            System.out.println("Problem with add Swipe " + "\n");
        }
        return swipePos;
    }

    @FXML
    public int addSwipeP2(int pos) {

        if (imageHand2.cards.get(pos).toString().contains("Gold goldSwipe") && isPoweringUp && !isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand2.cards.get(pos));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            imageHand2.cards.remove(pos);
            swipePos = pos;
            goldRank = 2;
        }
        else if (imageHand2.cards.get(pos).toString().contains("Swipe") && isPoweringUp && !isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand2.cards.get(pos));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            imageHand2.cards.remove(pos);
            swipePos = pos;

            System.out.println("You have " + imageHand2.showHand());
        }
        else if(imageTestDeck[1].cards.get(pos).toString().isEmpty()) {
            System.out.println("Add Swipe P1 Empty " + "\n");
        }

        else {
            System.out.println("Problem with add Swipe " + "\n");
        }
        return swipePos;

    }

    @FXML
    public int addPowerP1(int pos) {

        if (isPoweringUp && isMyTurn && !imageHand1.cards.get(pos).toString().contains("Swipe")) {
            activePowerCardHand.cards.add(imageHand1.cards.get(pos));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
            imageHand1.cards.remove(pos);
            System.out.println("AddPower1 Card is " + activePowerCardHand.showHand());
            powerPos = pos;

        }

        else if(imageTestDeck[0].cards.get(pos).toString().isEmpty()) {
            System.out.println("Add Swipe P1 Empty " + "\n");
        }

        else {
            System.out.println("Problem with add Power " + "\n");
        }
        return powerPos;
    }


    @FXML
    public void addPowerP2(int pos) {
        if (isPoweringUp && !isMyTurn && !imageHand2.cards.get(pos).toString().contains("Swipe")) {
            activePowerCardHand.cards.add(imageHand2.cards.get(pos));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
            imageHand2.cards.remove(pos);
            System.out.println("AddPower 2 Card is " + activePowerCardHand.showHand());

        }

        else if(imageTestDeck[1].cards.get(pos).toString().isEmpty()) {
            System.out.println("Add Swipe P1 Empty " + "\n");
        }

        else {
            System.out.println("Problem with add Power " + "\n");
        }
    }

    @FXML
    public int addActivePowerP1() {
        Iterator<ArrayList<Card>> it = activatedCardsP1.iterator();
        for(int i= 0; i < 10; i++) {
            if(!it.next().isEmpty())
                activePowerInt++;
            System.out.println(activePowerInt + "first loop ");
        }
        if(!activePowerCardHand.cards.get(0).toString().contains("Swipe")) {
                activatedCardsP1.get(activePowerInt).add(activePowerCardHand.cards.get(0));
                activePowerInt = 0;
            System.out.println(activePowerInt + "second loop ");
            }

         else {
            System.out.println("Problem with active power");
        }

        System.out.println(activatedCardsP1);
        return activePowerInt;
        }
    @FXML
    public int addActivePowerP2() {
        Iterator<ArrayList<Card>> it = activatedCardsP2.iterator();
        for(int i= 0; i < 10; i++) {
            if(!it.next().isEmpty())
                activePowerInt++;
            System.out.println(activePowerInt + "first loop ");
        }
        if(!activePowerCardHand.cards.get(0).toString().contains("Swipe")) {
            activatedCardsP2.get(activePowerInt).add(activePowerCardHand.cards.get(0));
            activePowerInt = 0;
            System.out.println(activePowerInt + "second loop ");
        }

        else {
            System.out.println("Problem with active power");
        }

        System.out.println(activatedCardsP2);
        return activePowerInt;
    }



    public int addActiveSwipeP1(){
        Iterator<ArrayList<Card>> it = activatedCardsP1.iterator();
        for(int i= 0; i < 10; i++) {
            if(it.next().size() == 2)
                activeSwipeInt++;
            System.out.println(activeSwipeInt + "first loop ");
        }
        if (activeSwipeCardHand.cards.get(0).toString().contains("Swipe")) {
            activatedCardsP1.get(activeSwipeInt).add(activeSwipeCardHand.cards.get(0));
            //System.out.println("Player 1 hand is " + imageHand1.cards.toString() + " " + "\n");
            activeSwipeInt = 0;
        } else {
            System.out.println("Problem with active Swipe");
        }
        System.out.println(activatedCardsP1);
        return activeSwipeInt;
    }

    public int addActiveSwipeP2(){
        Iterator<ArrayList<Card>> it = activatedCardsP2.iterator();
        for(int i= 0; i < 10; i++) {
            if(it.next().size() == 2)
                activeSwipeInt++;
            System.out.println(activeSwipeInt + "first loop ");
        }
        if (activeSwipeCardHand.cards.get(0).toString().contains("Swipe")) {
            activatedCardsP2.get(activeSwipeInt).add(activeSwipeCardHand.cards.get(0));
            //System.out.println("Player 1 hand is " + imageHand1.cards.toString() + " " + "\n");
            activeSwipeInt = 0;
        } else {
            System.out.println("Problem with active Swipe");
        }
        System.out.println(activatedCardsP2);
        return activeSwipeInt;
    }

    @FXML
    public void setActiveImagesP1(){
        ArrayList<ImageView> activeImagesArrayP1 = new ArrayList(Arrays.asList(p1ActiveImg1, p1ActiveImg2, p1ActiveImg3, p1ActiveImg4, p1ActiveImg5, p1ActiveImg6, p1ActiveImg7, p1ActiveImg8, p1ActiveImg9, p1ActiveImg10));
        Iterator<ImageView> it = activeImagesArrayP1.iterator();
        int i = 0;
        if(isMyTurn && !activePowerCardHand.cards.isEmpty()) {
            addActivePowerP1();
        }
        if(isMyTurn && !activeSwipeCardHand.cards.isEmpty()) {
            addActiveSwipeP1();
        }

        for(ArrayList arr: activatedCardsP1) {
            if(!activatedCardsP1.get(i).isEmpty()) {
                it.next().setImage(activatedCardsP1.get(i).get(0).getMergedImage(activatedCardsP1.get(i).get(0), activatedCardsP1.get(i).get(1)));
                i++;
            } else {
                it.next().setImage(null);
                System.out.println("Empty " + "\n");
                System.out.println(activatedCardsP1.toString());
            }
        }
        clearActiveCards();
    }

    @FXML
    public void resetActiveImagesP1() {
        ArrayList<ImageView> activeImagesArrayP1 = new ArrayList(Arrays.asList(p1ActiveImg1, p1ActiveImg2, p1ActiveImg3, p1ActiveImg4, p1ActiveImg5, p1ActiveImg6, p1ActiveImg7, p1ActiveImg8, p1ActiveImg9, p1ActiveImg10));
        Iterator<ImageView> it = activeImagesArrayP1.iterator();
        int i = 0;
        for(ArrayList arr: activatedCardsP1) {
            if(!activatedCardsP1.get(i).isEmpty()) {
                it.next().setImage(activatedCardsP1.get(i).get(0).getMergedImage(activatedCardsP1.get(i).get(0), activatedCardsP1.get(i).get(1)));
                i++;
            } else {
                it.next().setImage(null);
                System.out.println("Empty " + "\n");
                System.out.println(activatedCardsP1.toString());
            }
        }
    }

    @FXML
    public void setActiveImagesP2(){
        ArrayList<ImageView> activeImagesArrayP2 = new ArrayList(Arrays.asList(p2ActiveImg1, p2ActiveImg2, p2ActiveImg3, p2ActiveImg4, p2ActiveImg5, p2ActiveImg6, p2ActiveImg7, p2ActiveImg8, p2ActiveImg9, p2ActiveImg10));
        Iterator<ImageView> it = activeImagesArrayP2.iterator();
        int i = 0;
        if(!isMyTurn && !activePowerCardHand.cards.isEmpty()) {
            addActivePowerP2();
        }
        if(!isMyTurn && !activePowerCardHand.cards.isEmpty()) {
            addActiveSwipeP2();
        }

        for(ArrayList arr: activatedCardsP2) {
            if(!activatedCardsP2.get(i).isEmpty()) {
                it.next().setImage(activatedCardsP2.get(i).get(0).getMergedImage(activatedCardsP2.get(i).get(0), activatedCardsP2.get(i).get(1)));
                i++;
            } else {
                it.next().setImage(null);
                System.out.println("Empty " + "\n");
                System.out.println(activatedCardsP2.toString());
            }
        }
        clearActiveCards();
    }

    @FXML
    public void resetActiveImagesP2() {
        ArrayList<ImageView> activeImagesArrayP2 = new ArrayList(Arrays.asList(p2ActiveImg1, p2ActiveImg2, p2ActiveImg3, p2ActiveImg4, p2ActiveImg5, p2ActiveImg6, p2ActiveImg7, p2ActiveImg8, p2ActiveImg9, p2ActiveImg10));
        Iterator<ImageView> it = activeImagesArrayP2.iterator();
        int i = 0;
        for(ArrayList arr: activatedCardsP2) {
            if(!activatedCardsP2.get(i).isEmpty()) {
                it.next().setImage(activatedCardsP2.get(i).get(0).getMergedImage(activatedCardsP2.get(i).get(0), activatedCardsP2.get(i).get(1)));
                i++;
            } else {
                it.next().setImage(null);
                System.out.println("Empty " + "\n");
                System.out.println(activatedCardsP2.toString());
            }
        }
    }

    @FXML
    public void resetActivatedCardsP1() {
        Iterator<ArrayList<Card>> it = activatedCardsP1.iterator();
        for(int i= 0; i < 9; i++) {
            if (activatedCardsP1.get(i).isEmpty()) {
                if (activatedCardsP1.get(i +1).size() == 2) {
                    activatedCardsP1.get(i).add(activatedCardsP1.get(i +1).get(0));
                    activatedCardsP1.get(i).add(activatedCardsP1.get(i +1).get(1));
                    activatedCardsP1.get(i +1).remove(0);
                    activatedCardsP1.get(i +1).remove(0);
                    System.out.println("I guess it worked? " + activatedCardsP1);
                    i = 0;
                } else {
                    System.out.println("No worky ");
                }

            }
        }
    }

    @FXML
    public void resetActivatedCardsP2() {
        Iterator<ArrayList<Card>> it = activatedCardsP2.iterator();
        for(int i= 0; i < 9; i++) {
            if (activatedCardsP2.get(i).isEmpty()) {
                if (activatedCardsP2.get(i +1).size() == 2) {
                    activatedCardsP2.get(i).add(activatedCardsP2.get(i +1).get(0));
                    activatedCardsP2.get(i).add(activatedCardsP2.get(i +1).get(1));
                    activatedCardsP2.get(i +1).remove(0);
                    activatedCardsP2.get(i +1).remove(0);
                    System.out.println("I guess it worked? " + activatedCardsP2);
                    i = 0;
                } else {
                    System.out.println("No worky ");
                }

            }
        }
    }

    @FXML
    public void undoSetCards(){

        if(!isMyTurn) {
            if(!activePowerCardHand.cards.isEmpty()) {
                imageHand2.cards.add(activePowerCardHand.cards.get(0));
            }
            if (!activeSwipeCardHand.cards.isEmpty()) {
                imageHand2.cards.add(activeSwipeCardHand.cards.get(0));
            }
            resetImagesP2();
            clearActiveCards();
        }

        else {
            if(!activePowerCardHand.cards.isEmpty()) {
                imageHand1.cards.add(activePowerCardHand.cards.get(0));
            }
            if (!activeSwipeCardHand.cards.isEmpty()) {
                imageHand1.cards.add(activeSwipeCardHand.cards.get(0));
            }
            resetImagesP1();
            clearActiveCards();
        }

    }



    @FXML
    public void swipeP1Img1() {
        if(!isMyTurn) {
            swipeP1(0);
            if(!swipeP1) {
                swipeDieP1(0);
            }


        }
        else if (isPoweringUp && !imageHand1.cards.get(0).toString().contains("Swipe")) {
            addPowerP1(0);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(0).getImage(activatedCards.get(0).get(0)));

        }

        else if (isPoweringUp) {
            addSwipeP1(0);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(1).getImage(activatedCards.get(0).get(1)));
            //activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }

        else if(isComparing && isMyTurn) {
            compareCards(0);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img2() {

        if(!isMyTurn) {
            swipeP1(1);
            if(!swipeP1) {
                swipeDieP1(1);
            }

        }
        else if (isPoweringUp && !imageHand1.cards.get(1).toString().contains("Swipe")) {
            addPowerP1(1);
        }

        else if (isPoweringUp) {
            addSwipeP1(1);
        }

        else if(isComparing  && isMyTurn) {
            compareCards(1);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img3() {

        if(!isMyTurn) {
            swipeP1(2);
            if(!swipeP1) {
                swipeDieP1(2);
            }

        }
        else if (isPoweringUp && !imageHand1.cards.get(2).toString().contains("Swipe")) {
            addPowerP1(2);
        }

        else if (isPoweringUp) {
            addSwipeP1(2);
        }

        else if(isComparing  && isMyTurn) {
            compareCards(2);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img4() {

        if(!isMyTurn) {
            swipeP1(3);
            if(!swipeP1) {
                swipeDieP1(3);
            }

        }
        else if (isPoweringUp && !imageHand1.cards.get(3).toString().contains("Swipe")) {
            addPowerP1(3);
        }

        else if (isPoweringUp) {
            addSwipeP1(3);
        }

        else if(isComparing  && isMyTurn) {
            compareCards(3);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img5() {

        if(!isMyTurn) {
            swipeP1(4);
            if(!swipeP1) {
                swipeDieP1(4);
            }

        }
        else if (isPoweringUp && !imageHand1.cards.get(4).toString().contains("Swipe")) {
            addPowerP1(4);
        }

        else if (isPoweringUp) {
            addSwipeP1(4);
        }
        else if(isComparing  && isMyTurn) {
            compareCards(4);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img6() {

        if(!isMyTurn) {
            swipeP1(5);
            if(!swipeP1) {
                swipeDieP1(5);
            }

        }
        else if (isPoweringUp && !imageHand1.cards.get(5).toString().contains("Swipe")) {
            addPowerP1(5);
        }

        else if (isPoweringUp) {
            addSwipeP1(5);
        }

        else if(isComparing  && isMyTurn) {
            compareCards(5);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img7() {

        if(!isMyTurn) {
            swipeP1(6);
            if(!swipeP1) {
                swipeDieP1(6);
            }

        }
        else if (isPoweringUp && !imageHand1.cards.get(6).toString().contains("Swipe")) {
            addPowerP1(6);
        }

        else if (isPoweringUp) {
            addSwipeP1(6);
        }

        else if(isComparing && isMyTurn) {
            compareCards(6);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img8() {

        if(!isMyTurn) {
            swipeP1(7);
            if(!swipeP1) {
                swipeDieP1(7);
            }

        }
        else if (isPoweringUp && !imageHand1.cards.get(7).toString().contains("Swipe")) {
            addPowerP1(7);
        }

        else if (isPoweringUp) {
            addSwipeP1(7);
        }

        else if(isComparing && isMyTurn) {
            compareCards(7);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img9() {

        if(!isMyTurn) {
            swipeP1(8);
            if(!swipeP1) {
                swipeDieP1(8);
            }

        }
        else if (isPoweringUp && !imageHand1.cards.get(8).toString().contains("Swipe")) {
            addPowerP1(8);
        }

        else if (isPoweringUp) {
            addSwipeP1(8);
        }

        else if(isComparing  && isMyTurn) {
            compareCards(8);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img10() {

        if(!isMyTurn) {
            swipeP1(9);
            if(!swipeP1) {
                swipeDieP1(9);
            }

        }
        else if (isPoweringUp && !imageHand1.cards.get(9).toString().contains("Swipe")) {
            addPowerP1(9);
        }

        else if (isPoweringUp) {
            addSwipeP1(9);
        }

        else if(isComparing  && isMyTurn) {
            compareCards(9);
        }

        resetImagesP1();

    }



    @FXML
    public void p1A1 () {
        if(!activatedCardsP1.get(0).get(0).toString().isEmpty() && isMyTurn) {
            activePowerCardHand.add(activatedCardsP1.get(0).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP1.get(0).get(1).toString().isEmpty() && isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP1.get(0).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP1.get(0).remove(0);
            activatedCardsP1.get(0).remove(0);
            System.out.println(activatedCardsP1.get(0).toString());
            resetActivatedCardsP1();
            resetActiveImagesP1();

        }

        if(!isMyTurn) {
            swipeP1A1(0);
            swipeDieP1A1(0);
        }
    }

    @FXML
    public void p1A2 () {
        if(!activatedCardsP1.get(1).get(0).toString().isEmpty() && isMyTurn) {
            activePowerCardHand.add(activatedCardsP1.get(1).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP1.get(1).get(1).toString().isEmpty() && isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP1.get(1).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP1.get(1).remove(0);
            activatedCardsP1.get(1).remove(0);
            System.out.println(activatedCardsP1.get(1).toString());
            resetActivatedCardsP1();
            resetActiveImagesP1();
        }
        if(!isMyTurn) {
            swipeP1A1(1);
            swipeDieP1A1(1);
        }
    }

    @FXML
    public void p1A3 () {
        if(!activatedCardsP1.get(2).get(0).toString().isEmpty() && isMyTurn) {
            activePowerCardHand.add(activatedCardsP1.get(2).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP1.get(2).get(1).toString().isEmpty() && isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP1.get(2).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP1.get(2).remove(0);
            activatedCardsP1.get(2).remove(0);
            System.out.println(activatedCardsP1.get(2).toString());
            resetActivatedCardsP1();
            resetActiveImagesP1();
        }
        if(!isMyTurn) {
            swipeP1A1(2);
            swipeDieP1A1(2);
        }
    }

    @FXML
    public void p1A4 () {
        if(!activatedCardsP1.get(3).get(0).toString().isEmpty() && isMyTurn) {
            activePowerCardHand.add(activatedCardsP1.get(3).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP1.get(3).get(1).toString().isEmpty() && isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP1.get(3).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP1.get(3).remove(0);
            activatedCardsP1.get(3).remove(0);
            System.out.println(activatedCardsP1.get(3).toString());
            resetActivatedCardsP1();
            resetActiveImagesP1();
        }

        if(!isMyTurn) {
            swipeP1A1(3);
            swipeDieP1A1(3);
        }
    }

    @FXML
    public void p1A5 () {
        if(!activatedCardsP1.get(4).get(0).toString().isEmpty() && isMyTurn) {
            activePowerCardHand.add(activatedCardsP1.get(4).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP1.get(4).get(1).toString().isEmpty() && isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP1.get(4).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP1.get(4).remove(0);
            activatedCardsP1.get(4).remove(0);
            System.out.println(activatedCardsP1.get(4).toString());
            resetActivatedCardsP1();
            resetActiveImagesP1();
        }

        if(!isMyTurn) {
            swipeP1A1(4);
            swipeDieP1A1(4);
        }
    }

    @FXML
    public void p1A6 () {
        if(!activatedCardsP1.get(5).get(0).toString().isEmpty() && isMyTurn) {
            activePowerCardHand.add(activatedCardsP1.get(5).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP1.get(5).get(1).toString().isEmpty() && isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP1.get(5).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP1.get(5).remove(0);
            activatedCardsP1.get(5).remove(0);
            System.out.println(activatedCardsP1.get(5).toString());
            resetActivatedCardsP1();
            resetActiveImagesP1();
        }
        if(!isMyTurn) {
            swipeP1A1(5);
            swipeDieP1A1(5);
        }
    }

    @FXML
    public void p1A7 () {
        if(!activatedCardsP1.get(6).get(0).toString().isEmpty() && isMyTurn) {
            activePowerCardHand.add(activatedCardsP1.get(6).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP1.get(6).get(1).toString().isEmpty() && isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP1.get(6).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP1.get(6).remove(0);
            activatedCardsP1.get(6).remove(0);
            System.out.println(activatedCardsP1.get(6).toString());
            resetActivatedCardsP1();
            resetActiveImagesP1();
        }
        if(!isMyTurn) {
            swipeP1A1(6);
            swipeDieP1A1(6);
        }
    }

    @FXML
    public void p1A8 () {
        if(!activatedCardsP1.get(7).get(0).toString().isEmpty() && isMyTurn) {
            activePowerCardHand.add(activatedCardsP1.get(7).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP1.get(7).get(1).toString().isEmpty() && isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP1.get(7).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP1.get(7).remove(0);
            activatedCardsP1.get(7).remove(0);
            System.out.println(activatedCardsP1.get(7).toString());
            resetActivatedCardsP1();
            resetActiveImagesP1();
        }
        if(!isMyTurn) {
            swipeP1A1(7);
            swipeDieP1A1(7);
        }
    }

    @FXML
    public void p1A9 () {
        if(!activatedCardsP1.get(8).get(0).toString().isEmpty() && isMyTurn) {
            activePowerCardHand.add(activatedCardsP1.get(8).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP1.get(8).get(1).toString().isEmpty() && isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP1.get(8).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP1.get(8).remove(0);
            activatedCardsP1.get(8).remove(0);
            System.out.println(activatedCardsP1.get(8).toString());
            resetActivatedCardsP1();
            resetActiveImagesP1();
        }
        if(!isMyTurn) {
            swipeP1A1(8);
            swipeDieP1A1(8);
        }
    }

    @FXML
    public void p1A10 () {
        if(!activatedCardsP1.get(9).get(0).toString().isEmpty() && isMyTurn) {
            activePowerCardHand.add(activatedCardsP1.get(9).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP1.get(9).get(1).toString().isEmpty() && isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP1.get(9).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP1.get(9).remove(0);
            activatedCardsP1.get(9).remove(0);
            System.out.println(activatedCardsP1.get(9).toString());
            resetActivatedCardsP1();
            resetActiveImagesP1();
        }
        if(!isMyTurn) {
            swipeP1A1(9);
            swipeDieP1A1(9);
        }
    }



    @FXML
    public void swipeP2Img1() {
        if(isMyTurn) {
            swipeP2(0);
            swipeDieP2(0);

        }
        else if (isPoweringUp && !imageHand2.cards.get(0).toString().contains("Swipe")) {
            addPowerP2(0);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(0).getImage(activatedCards.get(0).get(0)));

        }

        else if (isPoweringUp) {
            addSwipeP2(0);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(1).getImage(activatedCards.get(0).get(1)));
            //activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }

        else if(isComparing  && !isMyTurn) {
            compareCards(0);
        }

        resetImagesP2();

    }

    @FXML
    public void swipeP2Img2() {
        if(isMyTurn) {
            swipeP2(1);
            swipeDieP2(1);

        }
        else if (isPoweringUp && !imageHand2.cards.get(1).toString().contains("Swipe")) {
            addPowerP2(1);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(0).getImage(activatedCards.get(0).get(0)));

        }

        else if (isPoweringUp) {
            addSwipeP2(1);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(1).getImage(activatedCards.get(0).get(1)));
            //activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }

        else if(isComparing  && !isMyTurn) {
            compareCards(1);
        }

        resetImagesP2();

    }

    @FXML
    public void swipeP2Img3() {
        if(isMyTurn) {
            swipeP2(2);
            swipeDieP2(2);

        }
        else if (isPoweringUp && !imageHand2.cards.get(2).toString().contains("Swipe")) {
            addPowerP2(2);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(0).getImage(activatedCards.get(0).get(0)));

        }

        else if (isPoweringUp) {
            addSwipeP2(2);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(1).getImage(activatedCards.get(0).get(1)));
            //activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }

        else if(isComparing  && !isMyTurn) {
            compareCards(2);
        }

        resetImagesP2();

    }

    @FXML
    public void swipeP2Img4() {
        if(isMyTurn) {
            swipeP2(3);
            swipeDieP2(3);

        }
        else if (isPoweringUp && !imageHand2.cards.get(3).toString().contains("Swipe")) {
            addPowerP2(3);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(0).getImage(activatedCards.get(0).get(0)));

        }

        else if (isPoweringUp) {
            addSwipeP2(3);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(1).getImage(activatedCards.get(0).get(1)));
            //activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }

        else if(isComparing  && !isMyTurn) {
            compareCards(3);
        }

        resetImagesP2();

    }

    @FXML
    public void swipeP2Img5() {
        if(isMyTurn) {
            swipeP2(4);
            swipeDieP2(4);

        }
        else if (isPoweringUp && !imageHand2.cards.get(4).toString().contains("Swipe")) {
            addPowerP2(4);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(0).getImage(activatedCards.get(0).get(0)));

        }

        else if (isPoweringUp) {
            addSwipeP2(4);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(1).getImage(activatedCards.get(0).get(1)));
            //activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }

        else if(isComparing  && !isMyTurn) {
            compareCards(4);
        }

        resetImagesP2();

    }

    @FXML
    public void swipeP2Img6() {
        if(isMyTurn) {
            swipeP2(5);
            swipeDieP2(5);

        }
        else if (isPoweringUp && !imageHand2.cards.get(5).toString().contains("Swipe")) {
            addPowerP2(5);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(0).getImage(activatedCards.get(0).get(0)));

        }

        else if (isPoweringUp) {
            addSwipeP2(5);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(1).getImage(activatedCards.get(0).get(1)));
            //activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }

        else if(isComparing  && !isMyTurn) {
            compareCards(5);
        }

        resetImagesP2();

    }

    @FXML
    public void swipeP2Img7() {
        if(isMyTurn) {
            swipeP2(6);
            swipeDieP2(6);

        }
        else if (isPoweringUp && !imageHand2.cards.get(6).toString().contains("Swipe")) {
            addPowerP2(6);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(0).getImage(activatedCards.get(0).get(0)));

        }

        else if (isPoweringUp) {
            addSwipeP2(6);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(1).getImage(activatedCards.get(0).get(1)));
            //activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }

        else if(isComparing  && !isMyTurn) {
            compareCards(6);
        }

        resetImagesP2();

    }

    @FXML
    public void swipeP2Img8() {
        if(isMyTurn) {
            swipeP2(7);
            swipeDieP2(7);

        }
        else if (isPoweringUp && !imageHand2.cards.get(7).toString().contains("Swipe")) {
            addPowerP2(7);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(0).getImage(activatedCards.get(0).get(0)));

        }

        else if (isPoweringUp) {
            addSwipeP2(7);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(1).getImage(activatedCards.get(0).get(1)));
            //activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }

        else if(isComparing  && !isMyTurn) {
            compareCards(7);
        }

        resetImagesP2();

    }

    @FXML
    public void swipeP2Img9() {
        if(isMyTurn) {
            swipeP2(8);
            swipeDieP2(8);

        }
        else if (isPoweringUp && !imageHand2.cards.get(8).toString().contains("Swipe")) {
            addPowerP2(8);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(0).getImage(activatedCards.get(0).get(0)));

        }

        else if (isPoweringUp) {
            addSwipeP2(8);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(1).getImage(activatedCards.get(0).get(1)));
            //activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }

        else if(isComparing  && !isMyTurn) {
            compareCards(8);
        }

        resetImagesP2();

    }

    @FXML
    public void swipeP2Img10() {
        if(isMyTurn) {
            swipeP2(9);
            swipeDieP2(9);

        }
        else if (isPoweringUp && !imageHand2.cards.get(9).toString().contains("Swipe")) {
            addPowerP2(9);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(0).getImage(activatedCards.get(0).get(0)));

        }

        else if (isPoweringUp) {
            addSwipeP2(9);
            //p1ActiveImg1.setImage(activatedCards.get(0).get(1).getImage(activatedCards.get(0).get(1)));
            //activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }

        else if(isComparing  && !isMyTurn) {
            compareCards(9);
        }

        resetImagesP2();

    }



    @FXML
    public void p2A1 () {
        if(!activatedCardsP2.get(0).get(0).toString().isEmpty() && !isMyTurn) {
            activePowerCardHand.add(activatedCardsP2.get(0).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP2.get(0).get(1).toString().isEmpty() && !isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP2.get(0).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP2.get(0).remove(0);
            activatedCardsP2.get(0).remove(0);
            System.out.println(activatedCardsP2.get(0).toString());
            resetActivatedCardsP2();
            resetActiveImagesP2();
        }

        if(isMyTurn) {
            swipeP2A2(0);
            resetActiveImagesP2();
            if(!swipeP2A2) {
                swipeDieP2A2(0);
            }
        }

    }

    @FXML
    public void p2A2 () {
        if(!activatedCardsP2.get(1).get(0).toString().isEmpty() && !isMyTurn) {
            activePowerCardHand.add(activatedCardsP2.get(1).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP2.get(1).get(1).toString().isEmpty() && !isMyTurn) {
            activeSwipeCardHand.add(activatedCardsP2.get(1).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP2.get(1).remove(0);
            activatedCardsP2.get(1).remove(0);
            System.out.println(activatedCardsP2.get(1).toString());
            resetActivatedCardsP2();
            resetActiveImagesP2();
        }

        if(isMyTurn) {
            swipeP2A2(1);
            resetActiveImagesP2();
            if(!swipeP2A2) {
                swipeDieP2A2(1);
            }
        }
    }

    @FXML
    public void p2A3 () {
        if(!activatedCardsP2.get(2).get(0).toString().isEmpty()) {
            activePowerCardHand.add(activatedCardsP2.get(2).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP2.get(2).get(1).toString().isEmpty()) {
            activeSwipeCardHand.add(activatedCardsP2.get(2).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP2.get(2).remove(0);
            activatedCardsP2.get(2).remove(0);
            System.out.println(activatedCardsP2.get(2).toString());
            resetActivatedCardsP2();
            resetActiveImagesP2();
        }

        if(isMyTurn) {
            swipeP2A2(2);
            resetActiveImagesP2();
            if(!swipeP2A2) {
                swipeDieP2A2(2);
            }
        }
    }
    @FXML
    public void p2A4 () {
        if(!activatedCardsP2.get(3).get(0).toString().isEmpty()) {
            activePowerCardHand.add(activatedCardsP2.get(3).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP2.get(3).get(1).toString().isEmpty()) {
            activeSwipeCardHand.add(activatedCardsP2.get(3).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP2.get(3).remove(0);
            activatedCardsP2.get(3).remove(0);
            System.out.println(activatedCardsP2.get(3).toString());
            resetActivatedCardsP2();
            resetActiveImagesP2();
        }

        if(isMyTurn) {
            swipeP2A2(3);
            swipeDieP2A2(3);
        }
    }
    @FXML
    public void p2A5 () {
        if(!activatedCardsP2.get(4).get(0).toString().isEmpty()) {
            activePowerCardHand.add(activatedCardsP2.get(4).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP2.get(4).get(1).toString().isEmpty()) {
            activeSwipeCardHand.add(activatedCardsP2.get(4).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP2.get(4).remove(0);
            activatedCardsP2.get(4).remove(0);
            System.out.println(activatedCardsP2.get(4).toString());
            resetActivatedCardsP2();
            resetActiveImagesP2();
        }

        if(isMyTurn) {
            swipeP2A2(4);
            swipeDieP2A2(4);
        }
    }
    @FXML
    public void p2A6 () {
        if(!activatedCardsP2.get(5).get(0).toString().isEmpty()) {
            activePowerCardHand.add(activatedCardsP2.get(5).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP2.get(5).get(1).toString().isEmpty()) {
            activeSwipeCardHand.add(activatedCardsP2.get(5).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP2.get(5).remove(0);
            activatedCardsP2.get(5).remove(0);
            System.out.println(activatedCardsP2.get(5).toString());
            resetActivatedCardsP2();
            resetActiveImagesP2();
        }

        if(isMyTurn) {
            swipeP2A2(5);
            swipeDieP2A2(5);
        }
    }
    @FXML
    public void p2A7 () {
        if(!activatedCardsP2.get(6).get(0).toString().isEmpty()) {
            activePowerCardHand.add(activatedCardsP2.get(6).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP2.get(6).get(1).toString().isEmpty()) {
            activeSwipeCardHand.add(activatedCardsP2.get(6).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP2.get(6).remove(0);
            activatedCardsP2.get(6).remove(0);
            System.out.println(activatedCardsP2.get(6).toString());
            resetActivatedCardsP2();
            resetActiveImagesP2();
        }

        if(isMyTurn) {
            swipeP2A2(6);
            swipeDieP2A2(6);
        }
    }
    @FXML
    public void p2A8 () {
        if(!activatedCardsP2.get(7).get(0).toString().isEmpty()) {
            activePowerCardHand.add(activatedCardsP2.get(7).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP2.get(7).get(1).toString().isEmpty()) {
            activeSwipeCardHand.add(activatedCardsP2.get(7).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP2.get(7).remove(0);
            activatedCardsP2.get(7).remove(0);
            System.out.println(activatedCardsP2.get(7).toString());
            resetActivatedCardsP2();
            resetActiveImagesP2();
        }

        if(isMyTurn) {
            swipeP2A2(7);
            swipeDieP2A2(7);
        }
    }
    @FXML
    public void p2A9 () {
        if(!activatedCardsP2.get(8).get(0).toString().isEmpty()) {
            activePowerCardHand.add(activatedCardsP2.get(8).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP2.get(8).get(1).toString().isEmpty()) {
            activeSwipeCardHand.add(activatedCardsP2.get(8).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP2.get(8).remove(0);
            activatedCardsP2.get(8).remove(0);
            System.out.println(activatedCardsP2.get(8).toString());
            resetActivatedCardsP2();
            resetActiveImagesP2();
        }

        if(isMyTurn) {
            swipeP2A2(8);
            swipeDieP2A2(8);
        }
    }
    @FXML
    public void p2A10 () {
        if(!activatedCardsP2.get(9).get(0).toString().isEmpty()) {
            activePowerCardHand.add(activatedCardsP2.get(9).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCardsP2.get(9).get(1).toString().isEmpty()) {
            activeSwipeCardHand.add(activatedCardsP2.get(9).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            activatedCardsP2.get(9).remove(0);
            activatedCardsP2.get(9).remove(0);
            System.out.println(activatedCardsP2.get(9).toString());
            resetActivatedCardsP2();
            resetActiveImagesP2();
        }

        if(isMyTurn) {
            swipeP2A2(9);
            swipeDieP2A2(9);
        }
    }
    @FXML
    public void doublePowerToSwipe(){
        if(comparePowerCardsP1.cards.size() == 2) {
            if (comparePowerCardsP1.cards.get(0).getrank() == comparePowerCardsP1.cards.get(1).getrank()) {
                imageHand1.cards.remove(compareCardsPos1);
                imageHand1.cards.remove(compareCardsPos2 - 1);
                imageHand1.add(new Card(Suit.BLACKS, Rank.BLACK));
                resetImagesP1();
                comparePowerCardsP1.cards.clear();
                compareCardsPos1 = 0;
                compareCardsPos2 = 0;
            }
            else {
                comparePowerCardsP1.cards.clear();
                compareCardsPos1 = 0;
                compareCardsPos2 = 0;
                System.out.println("Cards do not match ");
            }
        }

            else if(comparePowerCardsP2.cards.size() == 2) {
                if(comparePowerCardsP2.cards.get(0).getrank() == comparePowerCardsP2.cards.get(1).getrank()) {
                    imageHand2.cards.remove(compareCardsPos1);
                    imageHand2.cards.remove(compareCardsPos2 - 1);
                    imageHand2.add(new Card(Suit.BLACKS, Rank.BLACK));
                    resetImagesP2();
                    comparePowerCardsP2.clear();
                    compareCardsPos1 = 0;
                    compareCardsPos2 = 0;
                }
                else {
                    comparePowerCardsP2.cards.clear();
                    compareCardsPos1 = 0;
                    compareCardsPos2 = 0;
                    System.out.println("Cards do not match ");
                }
            }


        else {
            System.out.println("Double Power to Swipe is not working ");
        }

    }


    @FXML public void compareCards(int pos) {
        if (isComparing && isMyTurn) {
            if (comparePowerCardsP1.cards.size() < 1) {
                comparePowerCardsP1.add(imageHand1.cards.get(pos));
                compareCardsPos1 = pos;
                System.out.println(" first loop pos is " + compareCardsPos1 + "\n");

            } else if (comparePowerCardsP1.cards.size() == 1) {
                comparePowerCardsP1.add(imageHand1.cards.get(pos));
                compareCardsPos2 = pos;
                System.out.println(" second loop pos is " + compareCardsPos2 + "\n");
                doublePowerToSwipe();
            }

            System.out.println("Compare Cards P1 is " + comparePowerCardsP1.cards.size() + " " + "\n");
            System.out.println(comparePowerCardsP1.cards.toString());

        } else if (isComparing && !isMyTurn) {

            if (comparePowerCardsP2.cards.size() < 1) {
                comparePowerCardsP2.add(imageHand2.cards.get(pos));
                compareCardsPos1 = pos;
            } else if (comparePowerCardsP2.cards.size() == 1) {
                comparePowerCardsP2.add(imageHand2.cards.get(pos));
                compareCardsPos2 = pos;
                doublePowerToSwipe();
            }
        }

        else {
                System.out.println("Compare Cards is not working ");
            }

        System.out.println(compareCardsPos1 + " " + compareCardsPos2);


        }


    
    @FXML public void deckCount () {
        System.out.println("There are " + d1.cards.size() + " cards left " + "\n");
    }

    @FXML public void getPlayer1Score () {
        p1PtsHand.getColorValue(masterHand.cards.get(0));
        p1PtsHand.getShapeValue(masterHand.cards.get(0));
        p1PtsHand.getTotalNumberValue();
        p1PtsHand.matchMaster(masterHand.cards.get(0));
        System.out.println("Player 1 Pts Deck is " + p1PtsHand.cards.toString() + "\n");
    }

    @FXML public void getPlayer2Score () {
        p2PtsHand.getColorValue(masterHand.cards.get(0));
        p2PtsHand.getShapeValue(masterHand.cards.get(0));
        p2PtsHand.getTotalNumberValue();
        p2PtsHand.matchMaster(masterHand.cards.get(0));
        System.out.println("Player 2 Pts Deck is " + p2PtsHand.cards.toString() + "\n");
    }

    @FXML public void resetActiveCards () {
        if(isMyTurn) {
            resetActivatedCardsP1();
        }
        else {
            resetActivatedCardsP2();
        }
    }








    // put P2A1 functionality on all P1A1's and fo the rest of the P2's

    //Pop up messages (can't swipe that, have to roll once or twice, pass turn, draw card)
    //Limit on drawing a card
    //Add 2 black swipes together draw another card
    //What to do if you have more than 10 cards
    //Silver Card Functionality


    //Error when trying to swipe multiple cards. If a card at index 0 is taken and then
    // you try to take index 1 it will error because the card has moved to index 0



    //Handle any errors
    //Design
    //Home Screen with names and music
    //Export for multiple players
    //AI for single player game


    // Error because it is trying to do the next action and there is no card
    //Either set up a boolean, or make sure card in pos isnt's null

    // See if adding activatedCardList to Arrays as list will work with Iterator. Look at the Other Iterator
    // That's What I did for that.




}





