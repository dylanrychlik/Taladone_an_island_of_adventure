/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janken;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Davenrun.Player;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class JakenGUIController implements Initializable {

    @FXML
    Button Playagain;
    @FXML
    Button Exit;
    @FXML
    Button Bet;
    @FXML
    Label PlayerBet;
    @FXML
    Label PlayerBank;
    @FXML
    TextField BetAmount;
    @FXML
    Button Rock;
    @FXML
    Button Paper;
    @FXML
    Button Sciccors;
    @FXML
    TextArea Result;
    Player player;
    int money;          // Amount of money the user has.
    int bet;
    int num;

    public JakenGUIController() {
        this.Bet = new Button();
        this.BetAmount = new TextField();
        this.Rock = new Button();
        this.Paper = new Button();
        this.Sciccors = new Button();
        this.Result = new TextArea();
        this.PlayerBank = new Label();
        this.PlayerBet = new Label();
        this.Exit = new Button();
        this.Playagain = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player.getPlayer();
        money = player.getbank();
        Result.setText("Welcome to the game of Jaken! \n You may bet if you want to! \n");
        BetAmount.setVisible(false);
        Result.setPrefWidth(250);
        Result.setPrefHeight(150);
        PlayerBank.setText("Player bank: " + money);
    }

    @FXML
    public void Rock() {
        num = 1;
        result();
    }

    @FXML
    public void Sciccors() {
        num = 2;
        result();
    }

    @FXML
    public void Paper() {
        num = 3;
        result();
    }

    public void result() {

        if (num == 1) {
            Result.appendText("You choose Rock! \n");
        } else if (num == 2) {
            Result.appendText("You choose Paper! \n");
        } else if (num == 3) {
            Result.appendText("You choose Sciccors! \n");
        }
        int num2 = (int) (3 * Math.random());
        if (num2 == 1) {
            Result.appendText("Dealer chooses Rock! \n");
        } else if (num2 == 2) {
            Result.appendText("Dealer chooses Paper! \n");
        } else if (num2 == 3) {
            Result.appendText("Dealer chooses Sciccors! \n");
        }
        Winner(num2);
    }

    public void Winner(int num2) {
        if (num == num2) {
            bet = 0;
            Result.appendText("Its a tie!");
        } else if (num == 1 && num2 == 3) {
            Result.appendText("Rock crushes sciccors! You win!");
            money += bet;
        } else if (num == 3 && num2 == 1) {
            Result.appendText("Rock crushes sciccors! Dealer wins!");
            money -= bet;
        } else if (num == 2 && num2 == 1) {
            Result.appendText("Paper covers Rock! You win!");
            money += bet;
        } else if (num == 1 && num2 == 2) {
            Result.appendText("Paper covers Rock! Dealer wins!");
            money -= bet;
        } else if (num == 3 && num2 == 2) {
            Result.appendText("Sciccors Cut Paper! You win!");
            money += bet;
        } else if (num == 2 && num2 == 3) {
            Result.appendText("Sciccors Cut Paper! Dealer wins!");
            money -= bet;
            
        }
        player.setbank(money);
        Rock.setDisable(true);
        Paper.setDisable(true);
        Sciccors.setDisable(true);
        PlayerBet.setVisible(true);
        PlayerBank.setText("Player bank: " + money);
    }

    public void bet() {
        BetAmount.setVisible(true);
        BetAmount.setOnAction(event);
    }
    // action event 
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            try {
                bet = Integer.parseInt(BetAmount.getText());
                if (bet < 0 || bet > player.getbank()) {
                    PlayerBet.setText("Your answer must be between \n 0 and " + money + '.');
                } else {
                    PlayerBet.setText("Player Bet amount: " + bet);
                    PlayerBank.setText("Player Bank amount: " + (money - bet));
                    BetAmount.setVisible(false);
                    Bet.setDisable(true);
                }

            } catch (java.lang.NumberFormatException x) {
                PlayerBet.setText("Answer must be numeric");
            }
        }
    };

    @FXML
    public void playagain() {
        try {
            exit();
        } catch (IOException ex) {
            Logger.getLogger(JakenGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("JakenGUI.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Jaken");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Bet.getScene().getWindow();
        stage.close();
    }
}
