/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Side_quests;

import static Davenrun.OutsidehouseController.Armoritem;
import static Davenrun.OutsidehouseController.Weaponitem;
import static Davenrun.OutsidehouseController.gooditem;
import static Davenrun.OutsidehouseController.row1;
import static Davenrun.OutsidehouseController.row2;
import static Davenrun.OutsidehouseController.row3;
import static Davenrun.OutsidehouseController.row4;
import Davenrun.Player;
import Davenrun.goodItem;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class Attack_aliens2Controller implements Initializable {

    private Player you;
    int Enemyhealth = 10;
    Queue<String> enmies = new LinkedList<String>();
    int numhealthptoion = 3;
    int healthpotionhealamount = 30;
    @FXML
    private TextArea prompt;
     String intro = "You go down the ship. You see alot of aduucted people in Taladone. ";
    @FXML
    private TextArea Map;
    @FXML
    private ComboBox Look;
    @FXML
    private Button Attack;
    @FXML
    private Button button;
    Player player;
    @FXML
    private Button button2;
    @FXML
    private Button Player_stats;
    @FXML
    private TextArea stats;
    @FXML
    private TextArea current;
    @FXML
    private Button Drink_potion;
    @FXML
    private Button Run;
    public void AttackspiderController() {
        this.prompt = new TextArea();
        this.Attack = new Button();
        this.Drink_potion = new Button();
        this.Run = new Button();
        this.button = new Button();
        this.current = new TextArea();
        this.Map = new TextArea();
        this.stats = new TextArea();
        this.button = new Button();
        this.Look = new ComboBox();
        this.Player_stats = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

  enmies.add("Alein");
enmies.add("Alein");
enmies.add("Alein");

        intro += "\n Your encounter with " + enmies.toString() + "\n Your health is " + Player.gethealth()
                + "\n You armor is " + Player.getarmor() + "Enemy health is " + Enemyhealth + "\n What will you do?";
        Look.getItems().addAll("Good list", "Weapon list", "Armor list");
        Look.setValue("Look");

        prompt.setText(intro);
        button.setOnAction(event -> {
            //Call a method to determine which item in the list the user has selected
            doAction2(Look.getValue().toString()); //Send the selected item to the method
        });
        current.setText("Quests: \n Side Quest: The Alien \n Objective: Escape from the aliens");
     
        fillmap();
    }

    public void fillmap() {
       row1.clear();
        row2.clear();
        row3.clear();
        row4.clear();
        row1.add('^');
        row1.add('^');
        row1.add('^');
        row2.add('^');
        row2.add('^');
        row2.add('O');
        row3.add('^');
        row3.add('^');
        row3.add('^');
        row4.add('X');
        row4.add('X');
        row4.add('^');
        Map.setPrefWidth(300);
        StringBuilder builder = new StringBuilder(row1.size());
        StringBuilder builder2 = new StringBuilder(row2.size());
        StringBuilder builder3 = new StringBuilder(row3.size());
        StringBuilder builder4 = new StringBuilder(row4.size());
        for (Character ch : row1) {
            builder.append("\t" + ch);
        }
        for (Character ch : row2) {
            builder2.append("\t" + ch);
        }
        for (Character ch : row3) {
            builder3.append("\t" + ch);
        }
        for (Character ch : row4) {
            builder4.append("\t" + ch);
        }

        Map.setText("Davenrun \n Circle represents your current location. \n  Arrow represent a reachable location \n X represent a locations that is unreachable \n" + builder.toString() + "\n" + builder2.toString() + "\n" + builder3.toString() + "\n" + builder4.toString() + "\n");
    }

    public void stats() {

        player.getPlayer();

        String Output = "Player stats are: \n Health: " + player.gethealth() + "\n Bank:" + player.getbank() + "\n Attack damage:" + player.getattackdamage() + "\n Armor" + player.getarmor() + "\n Game level" + player.getJarl_level_count();
        stats.setText(Output);
    }

    private void doAction2(String listItem) {
        switch (listItem) {
            case "Good list": //Action for this item
                goodlist();
                break;
            case "Weapon list":
                weaponlist();
                break;
            case "Armor list": //Action for this item
                Armorlist();
                break;

            default: //Default action
                break;
        }
    }

    public void attack() throws IOException, InterruptedException {

        int damagedealth = Player.getattackdamage();
        int damagetaken;
        int armordamage;
        if (Player.getarmor() > 0) {
            damagetaken = 5;
            armordamage = 10;

        } else {
            intro = " ";
            intro += "\n You have no armor!";
            prompt.clear();
            prompt.setText(intro);
            damagetaken = 10;
            armordamage = 0;

        }
        Enemyhealth -= damagedealth;

        Player.subtracthealth(damagetaken);
        Player.subtractarmor(armordamage);
        intro = " ";
        intro += "\n You strike the Enemy  for" + damagedealth + "damage";
        intro += "\n You reciced " + damagetaken + "in retaliation";
        intro += "\n You recived " + armordamage + "In armor adamage";
        prompt.clear();
        prompt.setText(intro);
        if (Player.gethealth() < 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation!");

            alert.setContentText("You are too weak to go on continure from last check point?");

            ButtonType Yes = new ButtonType("Yes");
            ButtonType No = new ButtonType("No");
            ButtonType Cancel = new ButtonType("Cancle");
            alert.getButtonTypes().setAll(Yes, No, Cancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == Yes) {
                Player.addhealth(100);
                alert.close();
                Stage Stage = new Stage();
                Stage.setTitle("Outside House");
                Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Outsidehouse.fxml"));
                Stage.setScene(new Scene(root, 1000, 750));
                Stage.show();
                closeWindow();

            } else {
                Player.addhealth(100);
                alert.close();
                Stage Stage = new Stage();
                Stage.setTitle("Outside House");
                Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Outsidehouse.fxml"));
                Stage.setScene(new Scene(root, 1000, 750));
                Stage.show();
                closeWindow();
            }

        }
        if (Enemyhealth < 0) {
            intro = " ";
            intro += "\n Enemy was defeated! \n";
            enmies.remove();
            intro += enmies.toString() + "remaining";
            intro += "\n You have " + Player.gethealth() + "left";

            Player.addpotions();
            intro += "\n The eneny dropped the health potion";
            intro += "\n You have " + Player.getpotions() + "left";
            prompt.clear();
            prompt.setText(intro);
            if (enmies.isEmpty()) {

            

                   Stage Stage = new Stage();
        Stage.setTitle("The aliens");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Attack_aliens3.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow(); 

            }
        }
    }

    public void Drink_potion() {
        if (Player.getpotions() > 0) {
            Player.addhealth(healthpotionhealamount);

            Player.subtractpotions();
            intro = " ";
            intro += "\n You drink a health potion to health your self for " + healthpotionhealamount + "Your health is now" + you.gethealth();
            intro += "\n you have " + Player.getpotions() + "left";
            prompt.clear();
            prompt.setText(intro);
        } else {
            intro = " ";
            intro += "You have no health potions! Defeat enmies for health potion!";
            prompt.clear();
            prompt.setText(intro);
        }
    }

    public void run() throws IOException {
        intro = " ";
        intro += "You run away from the enemy!";
        prompt.clear();
        prompt.setText(intro);
        Stage Stage = new Stage();

        Stage.setTitle("Outside House");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Outsidehouse.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    public void goodlist() {

        System.out.println(gooditem.size());
        int limit = gooditem.size();
        String out = " ";
        for (int x = 0; x < limit; x++) {

            out += ((goodItem) gooditem.get(x)).toString() + "\n";
        }
        stats.setText("Your Goods items are \n " + out);
    }

    public void weaponlist() {

        System.out.println(Weaponitem.getSize());
        int limit2 = Weaponitem.getSize();
        String out2 = " ";

        for (int x = 1; x <= limit2; x++) {

            out2 += Weaponitem.getInfo(x).toString() + "\n";
        }
        stats.setText("\n Your Weapon items are \n " + out2);
    }

    public void Armorlist() {

        System.out.println(Armoritem.getSize());
        int limit3 = Armoritem.getSize();
        String out3 = " ";
        for (int x = 1; x <= limit3; x++) {

            out3 += Armoritem.getInfo(x).toString() + "\n";
        }

        stats.setText("\n Your Armor items are in the order  by \n" + out3);
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Look.getScene().getWindow();
        stage.close();
    }
 
      
    
}
