package Davenrun;

import static Davenrun.OutsidehouseController.Sidequests;
import DavenrunCrabs.Crabs;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.awt.*;
import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ArrayList;

import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class GameroomController implements Initializable {

    Poker game = new Poker();
    Slotmachine test = new Slotmachine();
    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    @FXML
    private TextArea prompt;
    @FXML
    private Button lobby;
    @FXML
    private Button Management_center;
    @FXML
    private ComboBox Actions;
    @FXML
    private ComboBox Game;
    @FXML
    private Button Exit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        prompt.setText("Welcome to the Game room! \n Here you can play games and bet.");
        prompt.setEditable(false);
        Actions.getItems().addAll("Allison Swanson", "Chris Gimmerman", "Racheal Paige", "Quincy Johner", "Mac Black", "Victoria Dove");
prompt.setPrefHeight(80);
        Game.getItems().addAll("Black Jack", "Poker", "Tictactoe", "Crabs", "Rock Paper scissors");
        Actions.setValue("Talk to");
        Game.setValue("Play game");
    }

    public GameroomController() {
        this.lobby = new Button();
        this.Management_center = new Button();
        this.Actions = new ComboBox();
        this.Game = new ComboBox();

        this.Exit = new Button();
    }

    public void victoria_dove() throws IOException {
        if (Sidequests[9] == true){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Side quest already completed!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Victora Dove");

        alert.setContentText("Can you help? There is a man following me. I'm afraid he is going to hurt me. \n Can you help me? ");

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeTwo = new ButtonType("No");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

           Stage Stage = new Stage();
        Stage.setTitle("The Follwer");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Talk_victoria_dove.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow(); 

        }
        if (result.get() == buttonTypeTwo) {

            alert.setContentText("I am here if you change your mind...");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();

        }
        if (result.get() == buttonTypeCancel) {
            alert.setContentText("Well Alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }

    }
    }

    public void racheal_paige() throws IOException {
         if (Sidequests[15] == true){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Side quest already completed!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Racheal Paige");

        alert.setContentText("You: Hey you just stoled from me! Get back here! ");

        ButtonType buttonTypeOne = new ButtonType("Ok");
        
        alert.getButtonTypes().setAll(buttonTypeOne);
        Optional<ButtonType> result = alert.showAndWait();

        
           Stage Stage = new Stage();
        Stage.setTitle("The Thief");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Talk_thief.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow(); 

      

    }
    }

    public void quincey() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Quincy Joner: You know, I don’t understand what all the fuss is about the Casino, it’s nice to drink and play some games after a hard days work.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void mac() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Mac Black: Davenrun Run needs to learn how to relax. This is the safest location in the entire island. Step outside the gate, and you are in hell.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void exit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Insidecasino.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Casino");
        Stage.setScene(new Scene(root, 800, 400));
        Stage.show();
        closeWindow();
    }

    public void allison() throws IOException {
       if (Sidequests[14] == true){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Side quest already completed!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Allison Swanson");

        alert.setContentText("You're atrative. Would you like to go on date with me? ");

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeTwo = new ButtonType("No");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

           Stage Stage = new Stage();
        Stage.setTitle("The Date");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/The_date.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow(); 

        }
        if (result.get() == buttonTypeTwo) {

            alert.setContentText("I am here if you change your mind...");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();

        }
        if (result.get() == buttonTypeCancel) {
            alert.setContentText("Well Alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }

    }
    }

    public void chirs() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Chris Gimmerman");

        alert.setContentText("Common, just one more and I'll hit gold!");

        ButtonType buttonTypeOne = new ButtonType("Are you here all the time?");
        ButtonType buttonTypeTwo = new ButtonType("Tell me about your self.");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            alert.setHeight(500);
            alert.setContentText("Yes. It is an addiction. I simply can not stop playing. I have lost everything and regained everything all over again. If I can’t not play, then I go insane. \n I haven’t slept in 3 days. Curse the Jarl for letting this happen. It’s worse than drinking, it’s worse than murder, it’s betting everything you work so hard for to get a little profit.");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                chirs();
            }
        }
        if (result.get() == buttonTypeTwo) {
            alert.setHeight(500);
            alert.setContentText("Yes. Chris: Born and raised here. My father traveled here before the caisno and the areana was greddy. When I was a young boy, my father told me to not risk your hard days work in a card game \n I was too niave to listen to him, he died in the raptor cave. I spend years trying to provide for the mother. When she died and my sister left Taladone, I came to the casino. When I’m tired I sleep, when I’m hungry I eat, \n when I need to piss or shit, I piss or shit, the rest of the time I am here. \n I have nothing else to live for. I have lost everything and gained it all back so many times that it doesn’t phase me anymore.");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                chirs();
            }
        }
        if (result.get() == buttonTypeCancel) {
            alert.setContentText("Chirs: Well alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
    }

    public void crabs() throws InterruptedException, IOException {
       Crabs object = new Crabs();
            object.Crabs();
    }

   

    public void poker() throws InterruptedException, IOException {

        Poker object = new Poker();
        Stage primaryStage = new Stage();
      object.start(primaryStage);

    }

    public void blackjack() throws InterruptedException {

        int money;          // Amount of money the user has.
        int bet;            // Amount user bets on a game.
        boolean userWins;   // Did the user win the game?

        JOptionPane.showMessageDialog(null, "Welcome to the game of blackjack.");

        money = 100;  // User starts with $100.

        while (true) {
            JOptionPane.showMessageDialog(null, "You have " + money + " dollars.");
            do {
                bet = Integer.parseInt(JOptionPane.showInputDialog("How many dollars do you want to bet?  (Enter 0 to end.)"));

                if (bet < 0 || bet > money) {
                    JOptionPane.showMessageDialog(null, "Your answer must be between 0 and " + money + '.');
                }
            } while (bet < 0 || bet > money);
            if (bet == 0) {
                break;
            }
            userWins = playblackjack();
            if (userWins) {
                money = money + bet;
            } else {
                money = money - bet;
            }

            if (money == 0) {
                JOptionPane.showMessageDialog(null, "Looks like you've are out of money!");

                break;

            }

            JOptionPane.showMessageDialog(null, "You leave with $" + money + '.');
        }

    }

    public boolean playblackjack() {
        Deck deck;                  // A deck of cards.  A new deck for each game.
        blackjackhand dealerHand;   // The dealer's hand.
        blackjackhand userHand;     // The user's hand.

        deck = new Deck();
        dealerHand = new blackjackhand();
        userHand = new blackjackhand();

        /*  Shuffle the deck, then deal two cards to each player. */
        deck.shuffle();
        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        userHand.addCard(deck.dealCard());
        userHand.addCard(deck.dealCard());

        /* Check if one of the players has Blackjack (two cards totaling to 21).
             The player with Blackjack wins the game.  Dealer wins ties.
         */
        if (dealerHand.getBlackjackValue() == 21) {
            JOptionPane.showMessageDialog(null, "Dealer has the " + dealerHand.getCard(0)
                    + " and the " + dealerHand.getCard(1) + ".");
            JOptionPane.showMessageDialog(null, "User has the " + userHand.getCard(0)
                    + " and the " + userHand.getCard(1) + ".");

            JOptionPane.showMessageDialog(null, "Dealer has Blackjack.  Dealer wins.");
            return false;
        }

        if (userHand.getBlackjackValue() == 21) {
            JOptionPane.showMessageDialog(null, "Dealer has the " + dealerHand.getCard(0)
                    + " and the " + dealerHand.getCard(1) + ".");
            JOptionPane.showMessageDialog(null, "User has the " + userHand.getCard(0)
                    + " and the " + userHand.getCard(1) + ".");

            JOptionPane.showMessageDialog(null, "You have Blackjack.  You win.");
            return true;
        }

        /*  If neither player has Blackjack, play the game.  First the user
              gets a chance to draw cards (i.e., to "Hit").  The while loop ends
              when the user chooses to "Stand".  If the user goes over 21,
              the user loses immediately.
         */
        while (true) {

            /* Display user's cards, and let user decide to Hit or Stand. */
            JOptionPane.showMessageDialog(null, "Your cards are:");
            for (int i = 0; i < userHand.getCardCount(); i++) {
                JOptionPane.showMessageDialog(null, "    " + userHand.getCard(i));
            }
            JOptionPane.showMessageDialog(null, "Your total is " + userHand.getBlackjackValue());

            JOptionPane.showMessageDialog(null, "Dealer is showing the " + dealerHand.getCard(0));

            String userAction = JOptionPane.showInputDialog(null, "Hit (H) or Stand (S)? ");
            userAction.toUpperCase();
            char HorS = userAction.charAt(0);
            // User's response, 'H' or 'S'.
            do {

                if (HorS != 'H' && HorS != 'S') {
                    userAction = JOptionPane.showInputDialog(null, "Please respond H or S:  ");
                }
                userAction.toUpperCase();
                HorS = userAction.charAt(0);
            } while (HorS != 'H' && HorS != 'S');

            /* If the user Hits, the user gets a card.  If the user Stands,
                  the loop ends (and it's the dealer's turn to draw cards).
             */
            if (HorS == 'S') {
                // Loop ends; user is done taking cards.
                break;
            } else {  // userAction is 'H'.  Give the user a card.
                // If the user goes over 21, the user loses.
                Card newCard = deck.dealCard();
                userHand.addCard(newCard);

                JOptionPane.showMessageDialog(null, "User hits.");
                JOptionPane.showMessageDialog(null, "Your card is the " + newCard);
                JOptionPane.showMessageDialog(null, "Your total is now " + userHand.getBlackjackValue());
                if (userHand.getBlackjackValue() > 21) {

                    JOptionPane.showMessageDialog(null, "You busted by going over 21.  You lose.");
                    JOptionPane.showMessageDialog(null, "Dealer's other card was the "
                            + dealerHand.getCard(1));
                    return false;
                }
            }

        } // end while loop

        /* If we get to this point, the user has Stood with 21 or less.  Now, it's
             the dealer's chance to draw.  Dealer draws cards until the dealer's
             total is > 16.  If dealer goes over 21, the dealer loses.
         */
        JOptionPane.showMessageDialog(null, "User stands.");
        JOptionPane.showMessageDialog(null, "Dealer's cards are");
        JOptionPane.showMessageDialog(null, "    " + dealerHand.getCard(0));
        JOptionPane.showMessageDialog(null, "    " + dealerHand.getCard(1));
        while (dealerHand.getBlackjackValue() <= 16) {
            Card newCard = deck.dealCard();
            JOptionPane.showMessageDialog(null, "Dealer hits and gets the " + newCard);
            dealerHand.addCard(newCard);
            if (dealerHand.getBlackjackValue() > 21) {

                JOptionPane.showMessageDialog(null, "Dealer busted by going over 21.  You win.");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Dealer's total is " + dealerHand.getBlackjackValue());

        /* If we get to this point, both players have 21 or less.  We
             can determine the winner by comparing the values of their hands. */
        if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
            JOptionPane.showMessageDialog(null, "Dealer wins on a tie.  You lose.");
            return false;
        } else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
            JOptionPane.showMessageDialog(null, "Dealer wins, " + dealerHand.getBlackjackValue()
                    + " points to " + userHand.getBlackjackValue() + ".");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "You win, " + userHand.getBlackjackValue()
                    + " points to " + dealerHand.getBlackjackValue() + ".");
            return true;

        }
    }

    public void piggame() throws InterruptedException {
        int turnScore = 0;
        int totalScore = 0;
        int turnScore2 = 0;
        int totalScore2 = 0;
        final int WIN = 20;
        int dice = 0;
        int dice2 = 0;
        String input = "r";
        String input2 = "r";
        char repeat;

        Scanner keyboard = new Scanner(System.in);
        Scanner s = new Scanner(System.in);

        Random randomNumbers = new Random();

        while (totalScore < WIN && totalScore2 < WIN) {
            //Player 1's turn

            do {
                dice = randomNumbers.nextInt(6) + 1;
                JOptionPane.showMessageDialog(null, "click ok to continuie...");
                JOptionPane.showMessageDialog(null, "You rolled: " + dice);

                if (dice == 1) {
                    turnScore = 0;
                    JOptionPane.showMessageDialog(null, "Turn over.");
                    JOptionPane.showMessageDialog(null, "Player 1 total is " + totalScore);
                    break;
                } else {
                    turnScore = dice; //removed +=??? think it's only the value of dice roll?
                    //either way it's used to compute total, which would be redundant if not
                    totalScore += turnScore; //added to compute totalScore before turn is over
                    JOptionPane.showMessageDialog(null, "Player 1 turn total is " + totalScore + " ");
                    JOptionPane.showMessageDialog(null, "Enter (r)oll or (s)top: ");
                    input = keyboard.nextLine();
                    repeat = input.charAt(0);

                    if (repeat == 's') {
                        JOptionPane.showMessageDialog(null, "Turn over.");
                        JOptionPane.showMessageDialog(null, "Current score: Player 1 has " + totalScore); //previously total wasn't computed
                        JOptionPane.showMessageDialog(null, ", Player 2 has " + totalScore2);
                        break;

                    }
                }
            } while (input.equalsIgnoreCase("r"));

            //totalScore += turnScore; was removed + curly braces that seemed to attach it to the above while loop
            //it isn't needed due to totalScore now being calculated after dice is rolled when !=1(else portion)
            if (totalScore >= WIN) {
                JOptionPane.showMessageDialog(null, "Your total Score is " + totalScore);
                JOptionPane.showMessageDialog(null, "Player 1 wins!");
                break; //added to break the loop if player 1 wins
            }

            //player2's turn
            JOptionPane.showMessageDialog(null, "Press okay to continue...");
            JOptionPane.showMessageDialog(null, "It is Player 2's turn.");

            do {
                dice2 = randomNumbers.nextInt(6) + 1;
                JOptionPane.showMessageDialog(null, "Player 2 rolled: " + dice2);

                if (dice2 == 1) {
                    turnScore2 = 0;
                    JOptionPane.showMessageDialog(null, "Turn over");
                    JOptionPane.showMessageDialog(null, "Player 2 total is " + totalScore2);
                    break;
                } else {
                    turnScore2 = dice2; //removed += ... same as for player 1's turn
                    totalScore2 += turnScore2; //added totalScore2 calculations.
                    JOptionPane.showMessageDialog(null, "Player 2 total is " + totalScore2 + " ");
                    JOptionPane.showMessageDialog(null, "Enter (r)oll or (s)top: ");
                    input = keyboard.nextLine();
                    repeat = input.charAt(0);

                    if (repeat == 's') {
                        JOptionPane.showMessageDialog(null, "Turn over");
                        JOptionPane.showMessageDialog(null, "Current score: Player 1 has " + totalScore);
                        JOptionPane.showMessageDialog(null, ", Player 2 has " + totalScore2);
                        break;
                    }
                }
            } while (input2.equalsIgnoreCase("r")); //{ <- incorrect brace + fixed loop for dice2 !=1, then removed it :P since you already did a check inside the do-while loop

            //totalScore2 += turnScore2; removed, no longer is needed
            //}
            //} <- not needed nor is the brace that was infront of the do while loop.
            if (totalScore2 >= WIN) //removed semicolon since it ended the if statement before it's body
            {
                JOptionPane.showMessageDialog(null, "Player 2 score is " + totalScore2 + "\n");
                JOptionPane.showMessageDialog(null, "Player 2 wins");
                break;
            }

            if (totalScore > totalScore2) //added loops to check which score is higher and terminate
            {
                JOptionPane.showMessageDialog(null, "Player 1 Wins!");
                break;
            } else if (totalScore == totalScore2) {
                JOptionPane.showMessageDialog(null, "It's a Tie!");
                break;
            } else if (totalScore < totalScore2) {
                JOptionPane.showMessageDialog(null, "Player 2 Wins!");
                break;
            }

        }

    }

    public void tictactoe() throws InterruptedException {
        char player = 'o';
        int row, column;
        Scanner k = new Scanner(System.in);
        Game g = new Game();

        g.initializeGame();
        JOptionPane.showMessageDialog(null, "Game ready !\n");

        while (true) {
            player = g.changePlayer(player);
            JOptionPane.showInputDialog(null, "\n" + player + " ,choose your location (row, column):");
            row = k.nextInt();
            column = k.nextInt();

            while (g.checkIfLegal(row, column)) {
                JOptionPane.showMessageDialog(null, "That slot is already taken or out of bounds, please try again (row, column).");
                g.displayBoard();
                row = k.nextInt();
                column = k.nextInt();
            }
            g.changeBoard(player, row, column);
            g.displayBoard();

            if (g.checkIfWinner()) {
                JOptionPane.showMessageDialog(null, "\nThe winner is " + player + " !");
                break;

            }
            if (g.checkIfTie()) {
                JOptionPane.showMessageDialog(null, "\nThe game is a tie !");
                break;

            }
        }

    }

    public void rockpapersiccors() throws InterruptedException {
        String personPlay; //User's play -- "R", "P", or "S"
        String computerPlay = ""; //Computer's play -- "R", "P", or "S"
        int computerInt; //Randomly generated number used to determine
        //computer's play
        String response;

        Random generator = new Random();

        JOptionPane.showMessageDialog(null, "Hey, let's play Rock, Paper, Scissors!\n"
                + "Please enter a move.\n" + "Rock = R, Paper"
                + "= P, and Scissors = S.");

        //Generate computer's play (0,1,2)
        computerInt = generator.nextInt(3) + 1;

        //Translate computer's randomly generated play to
        //string using if //statements
        if (computerInt == 1) {
            computerPlay = "R";
        } else if (computerInt == 2) {
            computerPlay = "P";
        } else if (computerInt == 3) {
            computerPlay = "S";
        }

        //Get player's play from input-- note that this is
        // stored as a string
        personPlay = JOptionPane.showInputDialog(null, "Enter your play: ");

        //Make player's play uppercase for ease of comparison
        personPlay = personPlay.toUpperCase();

        while (!personPlay.equals("R") && !personPlay.equals("P") && !personPlay.equals("S")) {

            //Get player's play from input-- note that this is
            // stored as a string
            personPlay = personPlay = JOptionPane.showInputDialog(null, "Enter your play: ");

            //Make player's play uppercase for ease of comparison
            personPlay = personPlay.toUpperCase();

            if (!personPlay.equals("R") && !personPlay.equals("P") && !personPlay.equals("S")) {
                JOptionPane.showMessageDialog(null, "Invalid move. Try again.");
            }

        }

        //Print computer's play
        JOptionPane.showMessageDialog(null, "Computer play is: " + computerPlay);

        //See who won. Use nested ifs
        if (personPlay.equals(computerPlay)) {
            JOptionPane.showMessageDialog(null, "It's a tie!");
        } else if (personPlay.equals("R")) {
            if (computerPlay.equals("S")) {
                JOptionPane.showMessageDialog(null, "Rock crushes scissors. You win!!");
            } else if (computerPlay.equals("P")) {
                JOptionPane.showMessageDialog(null, "Paper eats rock. You lose!!");
            } else if (personPlay.equals("P")) {
                if (computerPlay.equals("S")) {
                    JOptionPane.showMessageDialog(null, "Scissor cuts paper. You lose!!");
                } else if (computerPlay.equals("R")) {
                    JOptionPane.showMessageDialog(null, "Paper eats rock. You win!!");
                } else if (personPlay.equals("S")) {
                    if (computerPlay.equals("P")) {
                        JOptionPane.showMessageDialog(null, "Scissor cuts paper. You win!!");
                    } else if (computerPlay.equals("R")) {
                        JOptionPane.showMessageDialog(null, "Rock breaks scissors. You lose!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid user input.");
                    }
                }
            }
        }

    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Actions.getScene().getWindow();
        stage.close();
    }

    public void doAction2() throws InterruptedException, IOException {
        switch (Game.getValue().toString()) {
            case "Black Jack": //Action for this item
                blackjack();
                break;
            case "Poker": //Action for this item
                poker();
                break;
            case "Tictactoe": //Action for this item
                tictactoe();
                break;
            case "Crabs":
                crabs();
                break;
            case "Rock Paper scissors":
                rockpapersiccors();
                break;
            default: //Default action
                break;
        }
    }

    public void doAction() throws IOException {

        switch (Actions.getValue().toString()) {
            //Actions.getItems().addAll("Allison Swanson", "Chris Gimmerman", "Racheal Paige","Quincy Johner","Mac Black","Victoria Dove");
            case "Allison Swanson": //Action for this item
                allison();
                break;
            case "Chris Gimmerman":
                chirs();
                break;
            case "Racheal Paige": //Action for this item
                racheal_paige();
                break;
            case "Quincy Johner": //Action for this item
                quincey();
                break;
            case "Mac Black":
                mac();
                break;
            case "Victoria Dove":
                victoria_dove();
                break;
            default: //Default action
                break;
        }
    }
     public void lobby() throws IOException{
      Stage Stage = new Stage();
        Stage.setTitle("Lobby");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Lobby.fxml"));
        Stage.setScene(new Scene(root,600, 600));
        Stage.show();
        closeWindow();    
    }
    public void Management_center() throws IOException{
          Stage Stage = new Stage();
        Stage.setTitle("Management center");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Management_center.fxml"));
        
        Stage.setScene(new Scene(root, 600, 600));
        Stage.show();
        closeWindow();    
    }

}
