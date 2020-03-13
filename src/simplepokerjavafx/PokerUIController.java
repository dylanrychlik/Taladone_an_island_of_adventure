/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplepokerjavafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Davenrun.Player;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class PokerUIController implements Initializable {

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
    Label PlayerResult;
    @FXML
    Label DealerResult;
    @FXML
    Label Winner;
    @FXML
    Button Playagain;
    @FXML
    Button Exit;
    @FXML
    Button Redraw1;
    @FXML
    Button Redraw2;
    @FXML
    Button Redraw3;
    @FXML
    Button Redraw4;
    @FXML
    Button Redraw5;
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
    Image img = new Image("images/" + cardNum() + ".png");
    Player player;

    int money;          // Amount of money the user has.
    int bet;
    int dealermoney = 100;

    int num;

    String Hand[] = new String[5];
    String DealerHand[] = new String[5];

    public PokerUIController() {
        this.Bet = new Button();
        this.BetAmount = new TextField();
        this.PlayerBet = new Label();
        this.PlayerBank = new Label();
        this.DealerBank = new Label();

        this.PlayerResult = new Label();
        this.Winner = new Label();
        this.DealerResult = new Label();
        this.Playagain = new Button();

        this.Exit = new Button();
        this.Redraw1 = new Button();
        this.Redraw2 = new Button();
        this.Redraw3 = new Button();
        this.Redraw4 = new Button();
        this.Redraw5 = new Button();
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

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player.getPlayer();
        money = player.getbank();
        System.out.println(player.getbank());
        PlayerResult.setVisible(false);
        Winner.setVisible(false);
        DealerResult.setVisible(false);
        Playagain.setVisible(false);

        BetAmount.setVisible(false);
        DetermineHand determinehand = new DetermineHand();

        num = cardNum();
        imageView1.setImage(new Image("images/" + num + ".png"));
        int x = determinehand.determineSuit(num);
        Hand[0] = determinehand.initializesuit(x);

        num = cardNum();
        imageView2.setImage(new Image("images/" + num + ".png"));
        x = determinehand.determineSuit(num);
        Hand[1] = determinehand.initializesuit(x);

        num = cardNum();
        imageView3.setImage(new Image("images/" + num + ".png"));
        x = determinehand.determineSuit(num);
        Hand[2] = determinehand.initializesuit(x);

        num = cardNum();
        imageView4.setImage(new Image("images/" + num + ".png"));
        x = determinehand.determineSuit(num);
        Hand[3] = determinehand.initializesuit(x);

        num = cardNum();
        imageView5.setImage(new Image("images/" + num + ".png"));
        x = determinehand.determineSuit(num);
        Hand[4] = determinehand.initializesuit(x);

        PlayerBank.setText("Player bank: " + money);
        DealerBank.setText("Dealer bank: " + dealermoney);
    }
    int pnum, dnum;

    public void PlayHand() {
        Bet.setDisable(true);
        Redraw1.setDisable(true);
        Redraw2.setDisable(true);
        Redraw3.setDisable(true);
        Redraw4.setDisable(true);
        Redraw5.setDisable(true);

        DetermineHand determinehand = new DetermineHand();

        num = cardNum();
        imageView6.setImage(new Image("images/" + num + ".png"));
        int x = determinehand.determineSuit(num);
        DealerHand[0] = determinehand.initializesuit(x);

        num = cardNum();
        imageView7.setImage(new Image("images/" + num + ".png"));
        x = determinehand.determineSuit(num);
        DealerHand[1] = determinehand.initializesuit(x);

        num = cardNum();
        imageView8.setImage(new Image("images/" + num + ".png"));
        x = determinehand.determineSuit(num);
        DealerHand[2] = determinehand.initializesuit(x);

        num = cardNum();
        imageView9.setImage(new Image("images/" + num + ".png"));
        x = determinehand.determineSuit(num);
        DealerHand[3] = determinehand.initializesuit(x);

        num = cardNum();
        imageView10.setImage(new Image("images/" + num + ".png"));
        x = determinehand.determineSuit(num);
        DealerHand[4] = determinehand.initializesuit(x);

        PlayerResult.setVisible(true);
        Winner.setVisible(true);
        DealerResult.setVisible(true);

        int PlayerRank = evaluatePlayer();
        int DealerRank = evaluateDealer();

        if (PlayerRank < DealerRank) {
            Winner.setText("You Win!");
            money += bet;
            dealermoney -= bet;
        } else if (DealerRank < PlayerRank) {
            Winner.setText("Dealer Win!");
            money -= bet;
            dealermoney += bet;
        } else if (PlayerRank == DealerRank && pnum > dnum) {
            Winner.setText("You Win!");
            money += bet;
        } else if (PlayerRank == DealerRank && pnum < dnum) {
            Winner.setText("Dealer Wins!");
            money -= bet;
            dealermoney += bet;
        } else {
            Winner.setText("Its a Tie!");
            bet = 0;

        }

        PlayerBank.setText("Player bank: " + money);
        DealerBank.setText("Dealer bank: " + dealermoney);
        player.setbank(money);
        PlayerBet.setVisible(false);
        Playagain.setVisible(true);
    }

    public int evaluatePlayer() {
        DetermineRank PlayerRank = new DetermineRank(Hand);
        if (PlayerRank.royalFlush()) {
            PlayerResult.setText("You have a royal flush!");
            return 1;
        } else if (PlayerRank.straightFlush()) {
            PlayerResult.setText("You have a straight flush!");
            return 2;
        } else if (PlayerRank.Fourofakind()) {
            PlayerResult.setText("You have four of a kind!");
            return 3;
        } else if (PlayerRank.fullHouse()) {
            PlayerResult.setText("You have a full house!");
            return 4;
        } else if (PlayerRank.Flush()) {
            PlayerResult.setText("You have a flush!");
            return 5;
        } else if (PlayerRank.Sequence()) {
            System.out.println("You have a straight!");
            return 6;
        } else if (PlayerRank.Triple()) {
            PlayerResult.setText("You have a triple!");
            return 7;
        } else if (PlayerRank.twoPairs()) {
            PlayerResult.setText("You have two pairs!");
            return 8;
        } else if (PlayerRank.IsPair()) {
            PlayerResult.setText("You have a pair!");
            return 9;
        } else {
            String result = PlayerRank.DetermineHighCard();
            PlayerResult.setText("Your " + result);
            String[] parry = result.split(" is ");
            pnum = PlayerRank.DetermineHighCard(parry[1]);
            System.out.println(pnum);
            return 10;
        }
    }

    public int evaluateDealer() {
        DetermineRank DealerRank = new DetermineRank(DealerHand);
        if (DealerRank.royalFlush()) {
            DealerResult.setText("Dealer has a royal flush!");
            return 1;
        } else if (DealerRank.straightFlush()) {
            DealerResult.setText("Dealer has a straight flush!");
            return 2;
        } else if (DealerRank.Fourofakind()) {
            DealerResult.setText("Dealer has four of a kind!");
            return 3;
        } else if (DealerRank.fullHouse()) {
            DealerResult.setText("Dealer has a full house!");
            return 4;
        } else if (DealerRank.Flush()) {
            DealerResult.setText("Dealer has a flush!");
            return 5;
        } else if (DealerRank.Sequence()) {
            DealerResult.setText("Dealer has a straight!");
            return 6;
        } else if (DealerRank.Triple()) {
            DealerResult.setText("Dealer has a triple!");
            return 7;
        } else if (DealerRank.twoPairs()) {
            DealerResult.setText("Dealer has two pairs!");
            return 8;
        } else if (DealerRank.IsPair()) {
            DealerResult.setText("Dealer has a pair!");
            return 9;
        } else {

            String result = DealerRank.DetermineHighCard();
            DealerResult.setText("Dealer " + result);
            String[] darry = result.split(" is ");
            dnum = DealerRank.DetermineHighCard(darry[1]);
            System.out.println(dnum);
            return 10;
        }
    }

    public void redraw1() {
        num = cardNum();
        imageView1.setImage(new Image("images/" + num + ".png"));
        Redraw1.setDisable(true);
        DetermineHand determinehand = new DetermineHand();
        int x = determinehand.determineSuit(num);
        Hand[0] = determinehand.initializesuit(x);

    }

    public void redraw2() {
        num = cardNum();
        imageView2.setImage(new Image("images/" + num + ".png"));
        Redraw2.setDisable(true);
        DetermineHand determinehand = new DetermineHand();
        int x = determinehand.determineSuit(num);
        Hand[1] = determinehand.initializesuit(x);

    }

    public void redraw3() {
        num = cardNum();
        imageView3.setImage(new Image("images/" + num + ".png"));
        Redraw3.setDisable(true);
        DetermineHand determinehand = new DetermineHand();
        int x = determinehand.determineSuit(num);
        Hand[2] = determinehand.initializesuit(x);

    }

    public void redraw4() {
        num = cardNum();
        imageView4.setImage(new Image("images/" + num + ".png"));
        Redraw4.setDisable(true);
        DetermineHand determinehand = new DetermineHand();
        int x = determinehand.determineSuit(num);
        Hand[3] = determinehand.initializesuit(x);

    }

    public void redraw5() {
        num = cardNum();
        imageView5.setImage(new Image("images/" + num + ".png"));
        Redraw5.setDisable(true);
        DetermineHand determinehand = new DetermineHand();
        int x = determinehand.determineSuit(num);
        Hand[4] = determinehand.initializesuit(x);

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

    public int cardNum() {
        int Num = (int) Math.ceil(Math.random() * 52);
        return Num;
    }

    @FXML
    public void playagain() {
        try {
            reload();
        } catch (IOException ex) {
            Logger.getLogger(PokerUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void reload() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PokerUI.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Poker UI");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        closeWindow();
    }

    @FXML
    public void exit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Gameroom.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Poker UI");
        Scene scene = new Scene(root);
        stage.setScene(scene);
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
