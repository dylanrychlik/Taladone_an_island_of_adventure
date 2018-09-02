/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package The_northen_woods;

import static Davenrun.OutsidehouseController.Armoritem;
import static Davenrun.OutsidehouseController.Weaponitem;
import static Davenrun.OutsidehouseController.gooditem;
import Davenrun.Player;
import Davenrun.goodItem;
import static The_northen_woods.Northen_bridgeController.locations;
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
 * @author The flash
 */
public class Cave1_room3Controller implements Initializable {

    private Player you;
    int Enemyhealth = 10;
    String intro;
    Queue<String> enmies = new LinkedList<String>();
    int numhealthptoion = 3;
    int healthpotionhealamount = 30;
    @FXML
    private TextArea prompt;

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
    private Button Drink_potion;
    @FXML
    private Button Run;

    public void AttackspiderController() {
        this.prompt = new TextArea();
        this.Attack = new Button();
        this.Drink_potion = new Button();
        this.Run = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

 intro = " From the ashes of the dead wolves comes the Alpha male. \n He looks at his dead family and howls so loud that it can heard from Davenrun. \n The wolf then stares at you with rage in his eyes. He knows what you did. \n He runs straight towards you ready to gorge his vengence onto you.";
 prompt.setText(intro);
       enmies.add("King Wolf");
 
       
   intro += "\n Your encounter with " + enmies.toString() + "\n Your health is " + Player.gethealth()
                + "\n You armor is " + Player.getarmor() + "Enemy health is " + Enemyhealth + "\n What will you do?";
        Look.getItems().addAll("Good list", "Weapon list", "Armor list");
        Look.setValue("Look");

        prompt.setText(intro);
        button.setOnAction(event -> {
            //Call a method to determine which item in the list the user has selected
            doAction2(Look.getValue().toString()); //Send the selected item to the method
        });
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
                Stage Stage = new Stage();
                Stage.setTitle("Cave 1");
                Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/Cave1.fxml"));
                Stage.setScene(new Scene(root, 800, 800));
                Stage.show();
                closeWindow();

            } else {
                Player.addhealth(100);
                alert.close();
                Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/Northen_bridge.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Northen bridge");
                stage.setScene(new Scene(root, 1000, 750));
                stage.show();
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
                locations[12] = true;
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation!");
Player.addbank(150);
            alert.setContentText("Cave cleared! You add 150 gold. Your gold is now "+ Player.getbank() +  "You find a sword. \n  Do you wish to equip it to add  to your health rating or do to add it to your inventory?"
                    + "");

            ButtonType Yes = new ButtonType("Add to inventory");
            ButtonType No = new ButtonType("Equip");
            ButtonType Cancel = new ButtonType("Cancle");
            alert.getButtonTypes().setAll(Yes, No, Cancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == Yes) {
             goodItem  Cave4Weapon = new   goodItem("5","Sword","Lost sword made by John Wariron himself",110,120);
           gooditem.addLast(Cave4Weapon);
            // Armoritem.addLast(Cave4Armor);
                Stage Stage = new Stage();
                Stage.setTitle("Cave 1");
                Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/Cave1.fxml"));
                Stage.setScene(new Scene(root, 1000, 750));
                Stage.show();
                closeWindow();

            } else {
                Player.addactarmor(100);
                Player.setATTACKDAMAGE(100);
                Stage Stage = new Stage();
                Stage.setTitle("Cave 1");
                Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/Cave1.fxml"));
                Stage.setScene(new Scene(root, 1000, 750));
                Stage.show();
                closeWindow();
            }


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
        
         Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/Cave1.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Cave 1");
                stage.setScene(new Scene(root, 1000, 750));
        stage.show();
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
        Stage stage = (Stage) this.Attack.getScene().getWindow();
        stage.close();
    }
     
    
    
}
  
 
