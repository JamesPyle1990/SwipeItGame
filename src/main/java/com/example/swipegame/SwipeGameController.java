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
    public ImageView PtsDeck;
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

    ArrayList<ImageView> activeImagesArrayP2 = new ArrayList(Arrays.asList(p2ActiveImg1, p2ActiveImg2, p2ActiveImg3, p2ActiveImg4, p2ActiveImg5, p2ActiveImg6, p2ActiveImg7, p2ActiveImg8, p2ActiveImg9, p2ActiveImg10));


    Image backOfCardImage = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/backOfCard.jpg"));
    Image poweredCardTestImage = new Image(getClass().getResourceAsStream("/com/example/swipegame/images/poweredCardTest.png"));
    //ArrayList<ArrayList<Card>> activatedCards = new ArrayList<ArrayList<Card>>();
    ArrayList<Card> a1 = new ArrayList<Card>();
    ArrayList<Card> a2 = new ArrayList<Card>();
    ArrayList<Card> a3 = new ArrayList<Card>();
    ArrayList<Card> a4 = new ArrayList<Card>();
    ArrayList<Card> a5 = new ArrayList<Card>();
    ArrayList<ArrayList<Card>> activatedCards = new ArrayList(Arrays.asList(a1,a2,a3,a4,a5));






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
    int diceRollState = 3;
    private boolean oneRollWin = false;
    int activePowerInt = 0;
    int activeSwipeInt = 0;
    int swipePos = 0;
    int powerPos = 0;





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
        return isMyTurn = true;
    }


    @FXML public boolean isSwiping() {
        System.out.println("Swipe It Baby!");
        return isSwiping = true;
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
        for (Card c : masterHand.cards) {
            MasterCard.setImage(imageTestDeck[2].dealHandImage(i).getImage(imageTestDeck[2].dealHandImage(i)));
            i++;

        }
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
        ArrayList<ImageView> cardImagesP2 = new ArrayList(Arrays.asList(p2Img1, p2Img2, p2Img3, p2Img4, p2Img5, p2Img6, p1Img7, p1Img8, p1Img9, p1Img10));
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
                it.next().setImage(imageTestDeck[0].dealHandImage(i).getImage(imageTestDeck[0].dealHandImage(i)));
                //it.next().setImage(imageTestDeck[0].dealHandImage(i).getMergedImageBlack(imageTestDeck[0].dealHandImage(i)));

                i++;

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
            it.next().setImage(imageTestDeck[1].dealHandImage(i).getImage(imageTestDeck[1].dealHandImage(i)));
            i++;

        }
        System.out.println("Player 1's Hand is now : \n" + imageTestDeck[0].showHand() + "\n" +
                "Player 2's Hand is now: \n" + imageTestDeck[1].showHand());

    }

    @FXML
    public void swipeP1(int pos){
        if(isSwiping && !isMyTurn && imageHand1.cards.get(pos).getrank() < activePowerCardHand.cards.get(0).getrank() + goldRank

                && !imageHand1.cards.get(pos).toString().contains("Swipe")) {

            p2PtsHand.cards.add(imageHand1.cards.get(pos));
            imageHand1.cards.remove(pos);
            resetImagesP1();
            System.out.println("I just swiped your " + p2PtsHand.showHand() + "Mother Effer"+ "\n");

        } else if(imageTestDeck[0].cards.get(pos).toString().isEmpty()) {
            System.out.println("Add Swipe P1 Empty " + "\n");
        }

        else {
            System.out.println("Problem with Swipe p1 " + "\n");
        }
    }

    @FXML
    public void swipeP2(int pos){
        if(isSwiping && isMyTurn && imageHand2.cards.get(pos).getrank() < activePowerCardHand.cards.get(0).getrank() + goldRank

                && !imageHand2.cards.get(pos).toString().contains("Swipe")) {

            p1PtsHand.cards.add(imageHand2.cards.get(pos));
            imageHand2.cards.remove(pos);
            resetImagesP2();
            System.out.println("I just swiped your " + p1PtsHand.showHand() + "Mother Effer"+ "\n");

        }
        else if(imageTestDeck[1].cards.get(pos).toString().isEmpty()) {
            System.out.println("Add Swipe P1 Empty " + "\n");
        }
        else {
            System.out.println("Problem with Swipe p2 " + "\n");
        }
    }


    @FXML
    public void swipeDieP1 (int pos){
        if (isSwiping && !isMyTurn && imageHand1.cards.get(pos).getrank() > activePowerCardHand.cards.get(0).getrank() + goldRank) {
            if (diceRollState == 0) {

                p2PtsHand.cards.add(imageHand1.cards.get(pos));
                imageHand1.cards.remove(pos);
                resetImagesP1();
                System.out.println("I win the dice roll and I just swiped your " + p2PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
            }
            else if (diceRollState == 2) {
                System.out.println("Roll again! We Tied"  + "\n");
            }

            else System.out.println("Roll the dice big hog"  + "\n");
        }

        //Dice Roll if tied

        else if (isSwiping && !isMyTurn && imageHand1.cards.get(pos).getrank() == activePowerCardHand.cards.get(0).getrank() + goldRank) {
            oneRollWin = true;
            if (diceRollState == 0) {

                p2PtsHand.cards.add(imageHand1.cards.get(pos));
                imageHand1.cards.remove(pos);
                resetImagesP1();
                System.out.println("I win the dice roll and I just swiped your " + p2PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
            }
            else if (diceRollState == 2) {
                System.out.println("Roll again! We Tied"  + "\n");
            }

            else System.out.println("Roll the dice big hog"  + "\n");

        }
    }

    @FXML
    public void swipeDieP2 (int pos){
        if (isSwiping && isMyTurn && imageHand2.cards.get(pos).getrank() > activePowerCardHand.cards.get(0).getrank() + goldRank) {
            if (diceRollState == 0) {

                p1PtsHand.cards.add(imageHand2.cards.get(pos));
                imageHand2.cards.remove(pos);
                resetImagesP2();
                System.out.println("I win the dice roll and I just swiped your " + p1PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
            }
            else if (diceRollState == 2) {
                System.out.println("Roll again! We Tied"  + "\n");
            }

            else System.out.println("Roll the dice big hog"  + "\n");
        }

        //Dice Roll if tied

        else if (isSwiping && isMyTurn && imageHand2.cards.get(pos).getrank() == activePowerCardHand.cards.get(0).getrank() + goldRank) {
            oneRollWin = true;
            if (diceRollState == 0) {

                p1PtsHand.cards.add(imageHand2.cards.get(pos));
                imageHand2.cards.remove(pos);
                resetImagesP2();
                System.out.println("I win the dice roll and I just swiped your " + p1PtsHand.showHand() + "Mother Effer " + "\n");
            }

            else if (diceRollState ==1 ){
                System.out.println("You Loooossseeee"  + "\n");
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
            //imageHand1.cards.remove(pos);

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
    public void addSwipeP2(int pos) {

        if (imageHand2.cards.get(pos).toString().contains("Gold goldSwipe") && isPoweringUp && !isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand2.cards.get(pos));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            imageHand2.cards.remove(pos);
            goldRank = 2;
        }
        else if (imageHand2.cards.get(pos).toString().contains("Swipe") && isPoweringUp && !isMyTurn) {
            activeSwipeCardHand.cards.add(imageHand2.cards.get(pos));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
            imageHand2.cards.remove(pos);

            System.out.println("You have " + imageHand2.showHand());
        }
        else if(imageTestDeck[1].cards.get(pos).toString().isEmpty()) {
            System.out.println("Add Swipe P1 Empty " + "\n");
        }

        else {
            System.out.println("Problem with add Swipe " + "\n");
        }

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
    public int addActivePower() {
        Iterator<ArrayList<Card>> it = activatedCards.iterator();
        for(int i= 0; i < 5; i++) {
            if(!it.next().isEmpty())
                activePowerInt++;
            System.out.println(activePowerInt + "first loop ");
        }
        if(!activePowerCardHand.cards.get(0).toString().contains("Swipe")) {
                activatedCards.get(activePowerInt).add(activePowerCardHand.cards.get(0));
                activePowerInt = 0;
            System.out.println(activePowerInt + "second loop ");
            }

         else {
            System.out.println("Problem with active power");
        }

        System.out.println(activatedCards);
        return activePowerInt;
        }




    public int addActiveSwipe(){
        Iterator<ArrayList<Card>> it = activatedCards.iterator();
        for(int i= 0; i < 5; i++) {
            if(it.next().size() == 2)
                activeSwipeInt++;
            System.out.println(activeSwipeInt + "first loop ");
        }
        if (activeSwipeCardHand.cards.get(0).toString().contains("Swipe")) {
            activatedCards.get(activeSwipeInt).add(activeSwipeCardHand.cards.get(0));
            //System.out.println("Player 1 hand is " + imageHand1.cards.toString() + " " + "\n");
            activeSwipeInt = 0;
        } else {
            System.out.println("Problem with active Swipe");
        }
        System.out.println(activatedCards);
        return activeSwipeInt;
    }

    @FXML
    public void setActiveImages(){
        ArrayList<ImageView> activeImagesArrayP1 = new ArrayList(Arrays.asList(p1ActiveImg1, p1ActiveImg2, p1ActiveImg3, p1ActiveImg4, p1ActiveImg5, p1ActiveImg6, p1ActiveImg7, p1ActiveImg8, p1ActiveImg9, p1ActiveImg10));
        Iterator<ImageView> it = activeImagesArrayP1.iterator();
        int i = 0;
        addActivePower();
        addActiveSwipe();
        for(ArrayList arr: activatedCards) {
            if(!activatedCards.get(i).isEmpty()) {
                it.next().setImage(activatedCards.get(i).get(0).getMergedImage(activatedCards.get(i).get(0), activatedCards.get(i).get(1)));
                i++;
            } else {
                System.out.println("Empty " + "\n");
            }
        }
        clearActiveCards();
    }

    @FXML
    public void resetActivatedCards () {
        Iterator<ArrayList<Card>> it = activatedCards.iterator();
        for(int i= 0; i < 4; i++) {
            if (activatedCards.get(i).isEmpty()) {
                if (activatedCards.get(i +1).size() == 2) {
                    activatedCards.get(i).add(activatedCards.get(i +1).get(0));
                    activatedCards.get(i).add(activatedCards.get(i +1).get(1));
                    activatedCards.get(i +1).remove(0);
                    activatedCards.get(i +1).remove(0);
                    System.out.println("I guess it worked? " + activatedCards);
                    i = 0;
                } else {
                    System.out.println("No worky ");
                }

            }
        }
    }

    @FXML
    public void undoSetCards(){
        if(!activePowerCardHand.cards.isEmpty()) {
            imageHand1.cards.add(activePowerCardHand.cards.get(0));
        }
        if (!activeSwipeCardHand.cards.isEmpty()) {
            imageHand1.cards.add(activeSwipeCardHand.cards.get(0));
        }

        resetImagesP1();
        clearActiveCards();
    }



    @FXML
    public void swipeP1Img1() {
        if(!isMyTurn) {
            swipeP1(0);
            swipeDieP1(0);

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

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img2() {

        if(!isMyTurn) {
            swipeP1(1);
            swipeDieP1(1);

        }
        else if (isPoweringUp && !imageHand1.cards.get(1).toString().contains("Swipe")) {
            addPowerP1(1);
        }

        else if (isPoweringUp) {
            addSwipeP1(1);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img3() {

        if(!isMyTurn) {
            swipeP1(2);
            swipeDieP1(2);

        }
        else if (isPoweringUp && !imageHand1.cards.get(2).toString().contains("Swipe")) {
            addPowerP1(2);
        }

        else if (isPoweringUp) {
            addSwipeP1(2);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img4() {

        if(!isMyTurn) {
            swipeP1(3);
            swipeDieP1(3);

        }
        else if (isPoweringUp && !imageHand1.cards.get(3).toString().contains("Swipe")) {
            addPowerP1(3);
        }

        else if (isPoweringUp) {
            addSwipeP1(3);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img5() {

        if(!isMyTurn) {
            swipeP1(4);
            swipeDieP1(4);

        }
        else if (isPoweringUp && !imageHand1.cards.get(4).toString().contains("Swipe")) {
            addPowerP1(4);
        }

        else if (isPoweringUp) {
            addSwipeP1(4);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img6() {

        if(!isMyTurn) {
            swipeP1(5);
            swipeDieP1(5);

        }
        else if (isPoweringUp && !imageHand1.cards.get(5).toString().contains("Swipe")) {
            addPowerP1(5);
        }

        else if (isPoweringUp) {
            addSwipeP1(5);
        }

        resetImagesP1();

    }

    @FXML
    public void swipeP1Img7() {

        if(!isMyTurn) {
            swipeP1(6);
            swipeDieP1(6);

        }
        else if (isPoweringUp && !imageHand1.cards.get(6).toString().contains("Swipe")) {
            addPowerP1(6);
        }

        else if (isPoweringUp) {
            addSwipeP1(6);
        }

        resetImagesP1();

    }

    @FXML
    public void p1A1 () {
        if(!activatedCards.get(0).get(0).toString().isEmpty()) {
            activePowerCardHand.add(activatedCards.get(0).get(0));
            activePowerCard.setImage(activePowerCardHand.dealHandImage(0).getImage(activePowerCardHand.dealHandImage(0)));
        }
        if(!activatedCards.get(0).get(1).toString().isEmpty()) {
            activeSwipeCardHand.add(activatedCards.get(0).get(1));
            activeSwipeCard.setImage(activeSwipeCardHand.dealHandImage(0).getImage(activeSwipeCardHand.dealHandImage(0)));
        }
    }




    @FXML
    public void swipeP2Img1() {
        swipeP2(0);
        swipeDieP2(0);
        addPowerP2(0);
        addSwipeP2(0);
        resetImagesP2();
    }

    @FXML
    public void swipeP2Img2() {
        swipeP2(1);
        swipeDieP2(1);
        addPowerP2(1);
        addSwipeP2(1);
        resetImagesP2();
    }


    @FXML
    public void swipeP2Img3() {
        swipeP2(2);
        swipeDieP2(2);
        addPowerP2(2);
        addSwipeP2(2);
        resetImagesP2();

    }
    @FXML
    public void swipeP2Img4() {
        swipeP2(3);
        swipeDieP2(3);
        addPowerP2(3);
        addSwipeP2(3);
        resetImagesP2();

    }
    @FXML
    public void swipeP2Img5() {
        swipeP2(4);
        swipeDieP2(4);
        addPowerP2(4);
        addSwipeP2(4);
        resetImagesP2();

    }




    //Remember to clear gold rank
    //Pop up messages (can't swipe that, have to roll once or twice, pass turn, draw card)
    //Make Card Image Total 10 for each player
    //Limit on drawing a card
    //Add 2 black swipes together draw another card
    //What to do if you have more than 10 cards
    //Compare total points (shapes, colors) to Master Card
    //Lock in the master card (can't change it once decided)
    //Silver Card Functionality
    //Swipe Card Images for each power and swipe card

    //Don't remove card until turn is passed

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





