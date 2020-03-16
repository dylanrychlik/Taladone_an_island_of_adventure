/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

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
import Davenrun.Player;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class BlackJackUIController implements Initializable {

    @FXML
    Button Bet;
    @FXML
    TextField BetAmount;
    @FXML
    Label PlayerBet;
    @FXML
    Label PlayerBank;
    @FXML
    Label DealerBank;
    @FXML
    Label DealerTotal;
    @FXML
    Label PlayerTotal;
    @FXML
    Label Winner;
    @FXML
    Button Playagain;
    @FXML
    Button Exit;
    @FXML
    Button Hit;
    @FXML
    Button Stand;
    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private ImageView imageView4;
    @FXML
    private ImageView imageView5;
    @FXML
    private ImageView imageView6;
    @FXML
    private ImageView imageView7;
    @FXML
    private ImageView imageView8;
    @FXML
    private ImageView imageView9;
    @FXML
    private ImageView imageView10;
    @FXML
    private ImageView imageView11;
    @FXML
    private ImageView imageView12;
    @FXML
    private ImageView imageView13;
    @FXML
    private ImageView imageView14;
    @FXML
    private ImageView imageView15;
    @FXML
    private ImageView imageView16;
    @FXML
    private ImageView imageView17;
    @FXML
    private ImageView imageView18;
    DetermineRank rank = new DetermineRank();
    DetermineRank Dealerrank = new DetermineRank();
    Player player;
    int money = 100;          // Amount of money the user has.
    int bet;
    int dealermoney = 100;
    int total;
    int count1 = 2;
    int count2 = 11;

    public BlackJackUIController() {
        player.getPlayer();
        money = player.getbank();
        System.out.println(player.getbank());
        this.Bet = new Button();
        this.BetAmount = new TextField();
        this.PlayerBet = new Label();
        this.PlayerBank = new Label();
        this.DealerBank = new Label();

        this.DealerTotal = new Label();
        this.Winner = new Label();
        this.PlayerTotal = new Label();
        this.Playagain = new Button();
        this.imageView1 = new ImageView();
        this.imageView2 = new ImageView();
        this.imageView3 = new ImageView();
        this.imageView4 = new ImageView();
        this.imageView5 = new ImageView();
        this.imageView6 = new ImageView();
        this.imageView7 = new ImageView();
        this.imageView8 = new ImageView();
        this.imageView9 = new ImageView();
        this.imageView10 = new ImageView();
        this.imageView11 = new ImageView();
        this.imageView12 = new ImageView();
        this.imageView13 = new ImageView();
        this.imageView14 = new ImageView();
        this.imageView15 = new ImageView();
        this.imageView16 = new ImageView();
        this.imageView17 = new ImageView();
        this.imageView18 = new ImageView();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Winner.setVisible(false);

        Playagain.setVisible(false);
        int num1 = rank.cardNum();
        int num2 = rank.cardNum();
        BetAmount.setVisible(false);
        System.out.println(num1);
        imageView1.setImage(new Image("images/" + num1 + ".png"));
        imageView10.setImage(new Image("images/" + num2 + ".png"));
        PlayerBank.setText("Player bank: " + money);
        DealerBank.setText("Dealer bank: " + dealermoney);

        int cardnum = rank.determineSuit(num1);
        System.out.println(cardnum);
        int cardvalue = rank.CardNumber(cardnum);
        System.out.println(cardvalue);
        total = rank.CardTotal();
        PlayerTotal.setText("Player total " + total);

        int cardnum2 = Dealerrank.determineSuit(num2);
        System.out.println("\n Dealer card number " + cardnum2);
        int cardvalue2 = Dealerrank.CardNumber(cardnum2);
        System.out.println("\n Dealer card value " + cardvalue2);
        int Dealertotal = Dealerrank.CardTotal();
        DealerTotal.setText("Dealer total " + Dealertotal);
    }
    int Dealertotal;

    public void bet() {
        BetAmount.setVisible(true);
        BetAmount.setOnAction(event);
    }
    // action event 
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            try {
                bet = Integer.parseInt(BetAmount.getText());
                if (bet < 0 || bet > money) {
                    PlayerBet.setText("Your answer must be between \n 0 and " + money + '.');
                } else {
                    PlayerBet.setText("Player Bet amount: " + bet);
                    PlayerBank.setText("Player Bank amount: " + (money - bet));
                    BetAmount.setVisible(false);
                }

            } catch (java.lang.NumberFormatException x) {
                PlayerBet.setText("Answer must be numeric");
            }
        }
    };

    @FXML
    public void Stand() {
        Stand.setDisable(true);
        int count = 1;
        while (Dealertotal < 21 || count < 4 || Dealertotal < total) {
            int num = rank.cardNum();
            imageView11.setImage(new Image("images/" + num + ".png"));
            int cardnum = Dealerrank.determineSuit(num);
            int cardvalue = Dealerrank.CardNumber(cardnum);
            Dealerrank.getAceValue(cardvalue);
            Dealertotal = Dealerrank.CardTotal();
            System.out.println("Dealer Total " + count + " is " + Dealertotal);
            count++;
            if (Dealertotal >= 21 || Dealertotal > total) {
                break;
            }
        }
        //   PlayerTotal.setText("Final Player Total is " + total);
        DealerTotal.setText("Final Dealer Total is " + Dealertotal);
        if (Dealertotal > 21) {
            if (total > 21) {
                Playagain.setVisible(true);
                Winner.setVisible(true);
                Winner.setText("Dealer Busts out! Its a tie!");    bet = 0;
            } else {
                Playagain.setVisible(true);
                Winner.setVisible(true);
                Winner.setText("Dealer Busts out! Player wins");
                  money += bet;
            }
        } else if (total <= 21 && total > Dealertotal) {
            Playagain.setVisible(true);
            Winner.setVisible(true);
            Winner.setText("Player wins!");
              money += bet;
         
        } else if (total <= 21 && Dealertotal > total) {
            Playagain.setVisible(true);
            Winner.setVisible(true);
            Winner.setText("Dealer wins!");
              money -= bet;
            dealermoney += bet;
        } else if (Dealertotal == 21 && total == 21) {
            Playagain.setVisible(true);
            Winner.setVisible(true);
            Winner.setText("Its a tie!");    bet = 0;
        }
        PlayerBank.setText("Player bank: " + money);
        DealerBank.setText("Dealer bank: " + dealermoney);
        player.setbank(money);
    }

    @FXML
    public void Hit() {
        switch (count1) {
            case 2: {
                int num = rank.cardNum();
                imageView2.setImage(new Image("images/" + num + ".png"));
                count1++;
                int cardnum = rank.determineSuit(num);
                System.out.println(cardnum);
                int cardvalue = rank.CardNumber(cardnum);
                System.out.println(cardvalue);
                rank.getAceValue(cardvalue);
                total = rank.CardTotal();
                if (total > 21) {
                    PlayerTotal.setText("Player Bust! Final Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else if (total == 21) {
                    PlayerTotal.setText("Player Maxed out! Final Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else {
                    PlayerTotal.setText("Player total " + total);
                }
                break;
            }
            case 3: {
                int num = rank.cardNum();
                imageView3.setImage(new Image("images/" + num + ".png"));
                count1++;
                int cardnum = rank.determineSuit(num);
                System.out.println(cardnum);
                int cardvalue = rank.CardNumber(cardnum);
                System.out.println(cardvalue);
                rank.getAceValue(cardvalue);
                total = rank.CardTotal();
                if (total > 21) {
                    PlayerTotal.setText("Player Bust! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else if (total == 21) {
                    PlayerTotal.setText("Player Maxed out! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else {
                    PlayerTotal.setText("Player total " + total);
                }
                break;
            }
            case 4: {
                int num = rank.cardNum();
                imageView4.setImage(new Image("images/" + num + ".png"));
                count1++;
                int cardnum = rank.determineSuit(num);
                System.out.println(cardnum);
                int cardvalue = rank.CardNumber(cardnum);
                System.out.println(cardvalue);
                rank.getAceValue(cardvalue);
                total = rank.CardTotal();
                if (total > 21) {
                    PlayerTotal.setText("Player Bust! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else if (total == 21) {
                    PlayerTotal.setText("Player Maxed out! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else {
                    PlayerTotal.setText("Player total " + total);
                }
                break;
            }
            case 5: {
                int num = rank.cardNum();
                imageView5.setImage(new Image("images/" + num + ".png"));
                count1++;
                int cardnum = rank.determineSuit(num);
                System.out.println(cardnum);
                int cardvalue = rank.CardNumber(cardnum);
                System.out.println(cardvalue);
                rank.getAceValue(cardvalue);
                total = rank.CardTotal();
                if (total > 21) {
                    PlayerTotal.setText("Player Bust! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else if (total == 21) {
                    PlayerTotal.setText("Player Maxed out! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else {
                    PlayerTotal.setText("Player total " + total);
                }
                break;
            }
            case 6: {
                int num = rank.cardNum();
                imageView6.setImage(new Image("images/" + num + ".png"));
                count1++;
                int cardnum = rank.determineSuit(num);
                System.out.println(cardnum);
                int cardvalue = rank.CardNumber(cardnum);
                System.out.println(cardvalue);
                rank.getAceValue(cardvalue);
                total = rank.CardTotal();
                if (total > 21) {
                    PlayerTotal.setText("Player Bust! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else if (total == 21) {
                    PlayerTotal.setText("Player Maxed out! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else {
                    PlayerTotal.setText("Player total " + total);
                }
                break;
            }
            case 7: {
                int num = rank.cardNum();
                imageView7.setImage(new Image("images/" + num + ".png"));

                count1++;
                int cardnum = rank.determineSuit(num);
                System.out.println(cardnum);
                int cardvalue = rank.CardNumber(cardnum);
                System.out.println(cardvalue);
                rank.getAceValue(cardvalue);
                total = rank.CardTotal();
                if (total > 21) {
                    PlayerTotal.setText("Player Bust! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else if (total == 21) {
                    PlayerTotal.setText("Player Maxed out! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else {
                    PlayerTotal.setText("Player total " + total);
                }
                break;
            }
            case 8: {
                int num = rank.cardNum();
                imageView8.setImage(new Image("images/" + num + ".png"));
                count1++;
                int cardnum = rank.determineSuit(num);
                System.out.println(cardnum);
                int cardvalue = rank.CardNumber(cardnum);
                System.out.println(cardvalue);
                rank.getAceValue(cardvalue);
                total = rank.CardTotal();
                if (total > 21) {
                    PlayerTotal.setText("Player Bust! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else if (total == 21) {
                    PlayerTotal.setText("Player Maxed out! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else {
                    PlayerTotal.setText("Player total " + total);
                }
                break;
            }
            case 9: {
                int num = rank.cardNum();
                imageView9.setImage(new Image("images/" + num + ".png"));
                count1++;
                int cardnum = rank.determineSuit(num);
                System.out.println(cardnum);
                int cardvalue = rank.CardNumber(cardnum);
                System.out.println(cardvalue);
                rank.getAceValue(cardvalue);
                total = rank.CardTotal();
                if (total > 21) {
                    PlayerTotal.setText("Player Bust! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else if (total == 21) {
                    PlayerTotal.setText("Player Maxed out! Total is " + total);
                    Hit.setDisable(true);
                    Stand();
                } else {
                    PlayerTotal.setText("Player total " + total);
                }
                break;
            }
            default:
                break;
        }

    }

    @FXML
    public void playagain() {
        try {
            exit();
        } catch (IOException ex) {
            Logger.getLogger(BlackJackUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BlackJackUI.fxml"));
        Stage stage = new Stage();
        stage.setTitle("BlacjJack UI");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BlacjJack UI");
        stage.show();
        stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Bet.getScene().getWindow();
        stage.close();
    }
}
