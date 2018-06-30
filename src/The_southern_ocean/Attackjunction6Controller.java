/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package The_southern_ocean;

import The_southern_ocean.*;
import static The_southern_ocean.Northen_bridgeController.locations;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author The flash
 */
public class Attackjunction6Controller implements Initializable {

 String intro;
    int Enemyhealth = 10;
       int health = 100, attackdamage = 100, armor = 0, bank = 100, Game_ID = 0, Jarl_level_count = 0;
    Queue<String> enmies = new LinkedList<String>();
    int numhealthptoion = 3;
    int healthpotionhealamount = 30;
    @FXML
    private TextArea prompt;
    @FXML
    private Button Attack;
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
 intro = "JOptionPane.showMessageDialog(null,\"You travel east to the fith junction of the northen region\");\n" +
"        JOptionPane.showMessageDialog(null, \" Here the ground feels wet. \\n You notice a swamp not too far away from the Junctions. \\n There is a mist in the fog.\");\n" +
"        JOptionPane.showMessageDialog(null, \"As you sit down to grab a drink from the long walk you see a web near by. \\n Upon further inpection of the web you see a dead body with it blood gone.\");\n" +
"        JOptionPane.showMessageDialog(null, \"You back away from the bodies frighten and draw your sword. \\n You put in yourself in a defense position.. Your skin feels like its gonna crawl. \\n Upon the sawp you see a few figures from the distance. \");\n" +
"        JOptionPane.showMessageDialog(null, \"The figuire are about 5 feet in length and 4 feet long. \\n As the spider draws closer to you you see a web penatral your skin you run to the near by tree to desterpate tae it off.\");\n" +
"       JOptionPane.showMessageDialog(null, \"Your skin is crawling like spider on your skins and this points your take the web off and see three giant spider coming straight towards you draw your sword and prepare for battle. \");";  
 prompt.setText(intro);
       enmies.add("Spider");
enmies.add("Spider");
enmies.add("Spider");
       

        intro += "\n Your encounter with " + enmies.toString() + "\n Your health is " + health
                + "\n You armor is " + armor + "Enemy health is " + Enemyhealth + "\n What will you do?";
        prompt.setText(intro);

    }

    public void attack() throws IOException, InterruptedException {

        int damagedealth = attackdamage;
        int damagetaken;
        int armordamage;
        if (armor > 0) {
            damagetaken = 5;
            armordamage = 10;

        } else {
            intro += "\n You have no armor!";
            prompt.clear();
            prompt.setText(intro);
            damagetaken = 10;
            armordamage = 0;

        }
        Enemyhealth -= damagedealth;

        health -= damagetaken;
        armor -= armordamage;
        intro += "\n You strike the Enemy  for" + damagedealth + "damage";
        intro += "\n You reciced " + damagetaken + "in retaliation";
        intro += "\n You revicie " + armordamage + "In armor adamage";
        prompt.clear();
        prompt.setText(intro);
        if (health < 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation!");

            alert.setContentText("You are too weak to go on continure from last check point?");

            ButtonType Yes = new ButtonType("Yes");
            ButtonType No = new ButtonType("No");
            ButtonType Cancel = new ButtonType("Cancle");
            alert.getButtonTypes().setAll(Yes, No, Cancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == Yes) {
                health = 100;
                  Stage Stage = new Stage();
        Stage.setTitle("Junction 1");
        Parent root = FXMLLoader.load(getClass().getResource("/The_southern_ocean/AttackJunction1.fxml"));
        Stage.setScene(new Scene(root, 1500, 200));
        Stage.show();
        closeWindow();
            } else {
                health = 100;
                alert.close();
                Stage Stage = new Stage();
                Stage.setTitle("Junction 1");
                 Parent root = FXMLLoader.load(getClass().getResource("/The_northen_wood/attackJunction1.fxml"));
                Stage.setScene(new Scene(root, 1500, 200));
                Stage.show();
                closeWindow();
            }

        }
        if (Enemyhealth < 0) {
            intro += "\n Enemy was defeated! \n";
            enmies.remove();
            intro += enmies.toString() + "remaining";
            intro += "\n You have " + health + "left";

            numhealthptoion++;
            intro += "\n The eneny dropped the health potion";
            intro += "\n You have " + numhealthptoion + "left";
            prompt.clear();
            prompt.setText(intro);
            if (enmies.isEmpty()) {
               bank = bank + 30;
                intro += "You add 30 gold. You bank is now " + bank;
                prompt.clear();
                prompt.setText(intro);
 //Thread.sleep(3000);
locations[5] = true;
                 Stage Stage = new Stage();
        Stage.setTitle("Junction 1");
        Parent root = FXMLLoader.load(getClass().getResource("/The_southern_ocean/AttackJunction1.fxml"));
        Stage.setScene(new Scene(root, 1500, 200));
        Stage.show();
        closeWindow();
    }

            }
        }
    

    public void Drink_potion() {
        if (numhealthptoion > 0) {
            health += healthpotionhealamount;
            numhealthptoion--;
            intro += "\n You drink a health potion to health your self for " + healthpotionhealamount + "Your health is now" + health;
            intro += "\n you have " + numhealthptoion + "left";
            prompt.clear();
            prompt.setText(intro);
        } else {
            intro += "You have no health potions! Defeat enmies for health potion!";
            prompt.clear();
            prompt.setText(intro);
        }
    }

    public void run() throws IOException {
        intro += "You run away from the enemy!";
        prompt.clear();
        prompt.setText(intro);
    Stage Stage = new Stage();
        Stage.setTitle("Junction 1");
        Parent root = FXMLLoader.load(getClass().getResource("/The_southern_ocean/AttackJunction1.fxml"));
        Stage.setScene(new Scene(root, 1500, 200));
        Stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Attack.getScene().getWindow();
        stage.close();
    }   
    
    
    
}
