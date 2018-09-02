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
 * @author dylan
 */
public class Attackjunction12Controller implements Initializable {
 
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
 //intro = "You travel to the third junction of the northen region \n The sun is beating on your face like your father when you were a kid. \n As you wipe the sweat on your forehead, you notice a tad bit a red drip on your hand as you wipe it. \n You look up and see blood dripping from the leaves above. \n Upon further inpection, you see the dead body hanged up high from the tree. \n You turn around the cornor and see two more dead. There is a mad man on the loose. \n You grab your sword and scream! \n “Show yourself! I work for the Jarl! You don’t want to fight me!”.You then hear rustling from the leaves from the near by bush. \n Out comes an unarmed man that looks very frighten and scared. \n “Get out of here now! They are coming!” He says. \n An arrow then penatrates him and the man closped to the ground as his breath is cut short and reavles a group of outlaw travelers.forehead, you notice a tad bit a red drip on your hand as you wipe it. \n You look up and see blood dripping from the leaves above. \n Upon further inpection, you see the dead body hanged up high from the tree. \n You turn around the cornor and see two more dead. There is a mad man on the loose. \n You grab your sword and scream! \n “Show yourself! I work for the Jarl! You don’t want to fight me!”.You then hear rustling from the leaves from the near by bush. \n Out comes an unarmed man that looks very frighten and scared. \n “Get out of here now! They are coming!” He says. \n An arrow then penatrates him and the man closped to the ground as his breath is cut short and reavles a group of outlaw travelers.";
 intro =  "You sit to grab another drink. \n From the around the cornor. \n You see a small family of raptors running towards you."; 
 prompt.setText(intro);
       enmies.add("Snake");
  enmies.add("Snake");
    enmies.add("Snake");
       

            
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
                Stage.setTitle("Junction 3");
                Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/attackJunction3.fxml"));
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

               

               
              locations[11] = true;

                Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/Junction12.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Junction 12");
                stage.setScene(new Scene(root, 1000, 750));
                stage.show();
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
        
         Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/Northen_bridge.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Northen bridge");
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
