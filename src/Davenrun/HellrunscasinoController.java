/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davenrun;

import static Davenrun.OutsidehouseController.row1;
import java.io.IOException;
import static Davenrun.OutsidehouseController.Armoritem;
import static Davenrun.OutsidehouseController.Weaponitem;
import static Davenrun.OutsidehouseController.gooditem;
import static Davenrun.OutsidehouseController.MapHeight;
import static Davenrun.OutsidehouseController.MapWidth;
import static Davenrun.OutsidehouseController.row1;
import static Davenrun.OutsidehouseController.row2;
import static Davenrun.OutsidehouseController.row3;
import static Davenrun.OutsidehouseController.row4;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author The flash
 */
public class HellrunscasinoController implements Initializable {

    Player Player;

    @FXML
    private TextArea current;
    @FXML
    private ComboBox Actions;

    @FXML
    private ComboBox Look;
    @FXML
    private Button button;
    @FXML
    private Button button2;
    @FXML
    private Button Player_stats;
    @FXML
    private TextArea stats;
    @FXML
    private TextArea Map;
    Player player;

    @FXML
    private TextArea prompt;
    @FXML
    private Button Go_inside;
    @FXML
    private Button Go_North;
    @FXML
    private Button Go_East;
    @FXML
    private Button Sean_Militen;

    public HellrunscasinoController() {
        this.prompt = new TextArea();
        this.Go_inside = new Button();
        this.Go_North = new Button();
        this.Go_East = new Button();
        this.Sean_Militen = new Button();
        this.current = new TextArea();
        this.Actions = new ComboBox();
        this.stats = new TextArea();
        this.button = new Button();
        this.Look = new ComboBox();
        this.Player_stats = new Button();
        this.Map = new TextArea();
        this.button2 = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      prompt.setPrefHeight(80);

        prompt.setText("Helruns's Casino: Welcome to Helrun’s Casino. This is the entertainment center of \n Davenrun. Here you place casino games and socialize.");
        prompt.setEditable(false);
         prompt.setEditable(false);
        stats.setEditable(false);
        Map.setEditable(false);
        current.setEditable(false);
        current.setPrefSize(300, 300);
//ObservableList<String> people = FXCollections.observableArrayList();
        player.getPlayer();
        if (player.getJarl_level_count() == 0 || player.getJarl_level_count() == 2 || player.getJarl_level_count() == 4 || player.getJarl_level_count() == 6 || player.getJarl_level_count() == 8 || player.getJarl_level_count() == 10) {
            current.setText("Quests: \n You currently have no quests");
        }
        if (player.getJarl_level_count() == 1) {
            current.setText("Quests: Quest 1: The Northen Woods \n Primary Objective: Defeat the Dragon of Taladone \n Secondary Objectives: \n - Clear all 10 caves \n - Clear the Dungeon \n");
        }
        if (player.getJarl_level_count() == 3) {
            current.setText("Quests: Quest 2: The Eastern Graveyard \n Primary Objective: Defeat the Demon of the East \n Secondary Objectives: \n - Clear all 10 deadhouses \n - Clear the Death Dungeon \n");
        }
        if (player.getJarl_level_count() == 5) {
            current.setText("Quests: Quest 3: The Southern Ocean \n Primary Objective: Defeat the Sea Creature \n Secondary Objectives: \n - Clear all 10 caves \n - Clear the Dungeon \n");
        }
        if (player.getJarl_level_count() == 7) {
            current.setText("Quests: Quest 4: The Western Mountain \n Primary Objective: Defeat the Priest of the Western Mountain  \n Secondary Objectives: \n - Clear all 10 caves \n - Clear the Dungeon \n");
        }
        if (player.getJarl_level_count() == 9) {
            current.setText("Quests: Quest 5: The Final Quest \n Primary Objective: Defeat the evil of the Davenrun Church \n Secondary Objective: \n - none. \n");
        }
        Look.getItems().addAll("Good list", "Weapon list", "Armor list");
        Look.setValue("Look");
       
        button.setOnAction(event -> {
            //Call a method to determine which item in the list the user has selected
            doAction2(Look.getValue().toString()); //Send the selected item to the method
        });
      
        
        fillmap();
    }

    public void fillmap() {

        int MapHeight = 4;
        int MapWidth = 3;
        row1.clear();
        row2.clear();
        row3.clear();
        row4.clear();
        row1.add('^');
        row1.add('^');
        row1.add('^');
        row2.add('^');
        row2.add('^');
        row2.add('^');
        row3.add('O');
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
private void doAction(String listItem) {
        switch (listItem) {
            case "Sean Militen":
               Sean_Militen();
                break;
          

            default: //Default action
                break;
        }
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

    public void Sean_Militen() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sean Militen");

        alert.setContentText("Don't let the Davenrun media distract you from the real issues of the island.");

        ButtonType buttonTypeOne = new ButtonType("What can you tell me about the Casino?");
        ButtonType buttonTypeTwo = new ButtonType("Are you a traveler?");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            alert.setHeight(500);
            alert.setContentText("Sean Militen: Helrun’s Casino is made up of half of what is wrong with Davenrun. The other half being Boldmans areana. People come here and get greedy and bet everything they own. \n They drink themselves sick and next thing they know, they are selling their arses on the streets. \n The casino owners are doing nothing about it. As long as they are making money, they don’t care if someone becomes poor or not. It is an addiction.");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                Sean_Militen();
            }
        }
        if (result.get() == buttonTypeTwo) {
            alert.setHeight(600);
            alert.setContentText("Sean Militen: Aye, I am. I came to this land when I was just a little boy. \n My father was killed during the great Taladone war just before I became a man. \n With nothing left, I traveled the islsand for several years. I have recently settled when I found my wife and now we have two kids and a third on its way.\n I don't travel much these days, but when I do my mind goes back to a rather simpler time. A time before greed.\n A time when Jarls wern't influenced by the wealth of the Areana and the Casino. \n A time when people cared for each other and actually made a living. \n When Adventures were free spirits who traveled the Island hunting the creatures for defense and food, and not sport \n That was almost 20 years ago. \n We main lainders have sabatoged the integerity of Davenrun and the rest of Taladone. \n Dark times are coming to Taladone. I feel in my heart and soul \n. Despite my hate for the Jarl, he is going to be the only guide to save Taladone from an unkown force of evil. \n Don't let the areana and casino distract you, go to the Jarls palace and see what you can do. \n Good luck adventure.  ");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                Sean_Militen();
            }
        }
        if (result.get() == buttonTypeCancel) {
            alert.setContentText("Sean Militen: Well, alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }

    }

    public void Go_inside() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Hellruns Casino");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Insidecasino.fxml"));
        Stage.setScene(new Scene(root, 800, 400));
        Stage.show();
        closeWindow();
    }

    public void go_north() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Armory.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Armory");
        Stage.setScene(new Scene(root,  1000,750));
        Stage.show();
        closeWindow();
    }

    public void go_east() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Jarls_palace.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Jarls Palace");
        Stage.setScene(new Scene(root,  1000,750));
        Stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Go_inside.getScene().getWindow();
        stage.close();
    }
}
