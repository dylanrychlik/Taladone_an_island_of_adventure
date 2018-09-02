/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package The_eastern_graveyard;

import The_eastern_graveyard.*;
import static Davenrun.OutsidehouseController.Armoritem;
import static Davenrun.OutsidehouseController.MapWidth;
import static Davenrun.OutsidehouseController.Weaponitem;
import static Davenrun.OutsidehouseController.gooditem;
import static Davenrun.OutsidehouseController.row1;
import static Davenrun.OutsidehouseController.row2;
import static Davenrun.OutsidehouseController.row3;
import static Davenrun.OutsidehouseController.row4;
import Davenrun.Player;
import Davenrun.goodItem;
import static The_eastern_graveyard.Cave10Controller.row10;
import static The_eastern_graveyard.Cave10Controller.row11;
import static The_eastern_graveyard.Cave10Controller.row12;
import static The_eastern_graveyard.Cave10Controller.row5;
import static The_eastern_graveyard.Cave10Controller.row6;
import static The_eastern_graveyard.Cave10Controller.row7;
import static The_eastern_graveyard.Cave10Controller.row8;

import static The_eastern_graveyard.Golden_Wine_berry_innController.row9;
import static The_eastern_graveyard.Junction1Controller.row13;
import static The_eastern_graveyard.Northen_bridgeController.locations;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
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

public class Cave2Controller implements Initializable {

    String intro = "Vampire deadhouse: Here is the evil nest of the vampires of the weterns region. \n Here the undead suck the blood of the inocent so they can stay alive. \n The vampire are more classy than skelatons or zombies, but equally as dangours. \n You look into the windows to find a man with a cape \n he opens his mouth to reveal his fangs. \n A bat then appears out of mist and flies into the distance. \n You heart pounds again and you step back with yoru sword drawn, \n it seems like it it time to fight the evil creature that haunt Taladone. \n Do you wish to go inside or continaye or your adventure?";
    public static ArrayList<Character> row5 = new ArrayList<Character>(MapWidth);
    public static ArrayList<Character> row6 = new ArrayList<Character>(MapWidth);
    public static ArrayList<Character> row7 = new ArrayList<Character>(MapWidth);
    public static ArrayList<Character> row8 = new ArrayList<Character>(MapWidth);
    public static ArrayList<Character> row9 = new ArrayList<Character>(MapWidth);
    public static ArrayList<Character> row10 = new ArrayList<Character>(MapWidth);
    public static ArrayList<Character> row11 = new ArrayList<Character>(MapWidth);
    public static ArrayList<Character> row12 = new ArrayList<Character>(MapWidth);

    @FXML
    private TextArea prompt;
    @FXML
    private TextArea current;
    @FXML
    private Button Go_NorthWest;
    @FXML
    private Button Go_SouthEast;
    @FXML
    private Button Go_East;
    @FXML
    private ComboBox Look;
    @FXML
    private Button button2;
    @FXML
    private Button Player_stats;
    @FXML
    private TextArea stats;
    @FXML
    private TextArea Map;
    @FXML
    private Button Go_North;
    @FXML
    private Button Go_Inside;
    Player player;

    public void Cave1Controller() {
        this.Go_NorthWest = new Button();
        this.Player_stats = new Button();
        this.Map = new TextArea();
        this.Go_North = new Button();
        this.Look = new ComboBox();
        this.stats = new TextArea();
        this.Go_Inside = new Button();
        this.Go_East = new Button();
        this.Go_SouthEast = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        prompt.setPrefHeight(150);
        prompt.setText(intro);
        prompt.setText(intro);
        prompt.setEditable(false);
        stats.setEditable(false);
        Map.setEditable(false);
        Map.setPrefHeight(400);
        current.setEditable(false);
        current.setPrefSize(300, 180);
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
        button2.setOnAction(event -> {
            //Call a method to determine which item in the list the user has selected
            doAction2(Look.getValue().toString()); //Send the selected item to the method
        });
        fillmap();
    }

    public void fillmap() {

      row1.clear();
        row2.clear();
        row3.clear();
        row4.clear();
        row5.clear();
        row6.clear();
        row7.clear();
        row8.clear();

        row1.add('X');
        row1.add('X');
        row1.add('X');
        row1.add('X');
        row1.add('O');
        row1.add('O');
        row1.add('O');
        row1.add('X');
        row1.add('X');
        row1.add('X');
        row1.add('X');
        row1.add('X');
        row1.add('X');

        row2.add('X');
        row2.add('X');
        row2.add('X');
        row2.add('X');
        row2.add('O');
        row2.add('O');
        row2.add('O');
        row2.add('O');
        row2.add('O');
        row2.add('O');
        row2.add('O');
        row2.add('O');
        row2.add('X');

        row3.add('X');
        row3.add('X');
        row3.add('O');
        row3.add('O');
        row3.add('X');
        row3.add('X');
        row3.add('X');
        row3.add('X');
        row3.add('X');
        row3.add('X');
        row3.add('X');
        row3.add('X');
        row3.add('X');

        row4.add('O');
        row4.add('O');
        row4.add('X');
        row4.add('X');
        row4.add('X');
        row4.add('X');
        row4.add('X');
        row4.add('X');
        row4.add('X');
        row4.add('X');
        row4.add('X');
        row4.add('X');
        row4.add('O');

        row5.add('X');
        row5.add('X');
        row5.add('O');
        row5.add('O');
        row5.add('X');
        row5.add('X');
        row5.add('X');
        row5.add('X');
        row5.add('X');
        row5.add('X');
        row5.add('X');
        row5.add('X');
        row5.add('X');

        row6.add('X');
        row6.add('X');
        row6.add('X');
        row6.add('X');
        row6.add('^');
        row6.add('X');
        row6.add('X');
        row6.add('X');
        row6.add('X');
        row6.add('X');
        row6.add('X');
        row6.add('X');
        row6.add('X');

        row7.add('X');
        row7.add('X');
        row7.add('X');
        row7.add('X');
        row7.add('O');
        row7.add('O');
        row7.add('O');
        row7.add('O');
        row7.add('O');
        row7.add('O');
        row7.add('O');
        row7.add('O');
        row7.add('X');

        row8.add('X');
        row8.add('X');
        row8.add('X');
        row8.add('X');
        row8.add('O');
        row8.add('O');
        row8.add('O');
        row8.add('X');
        row8.add('X');
        row8.add('O');
        row8.add('X');
        row8.add('X');
        row8.add('X');
        Map.setPrefWidth(375);
        StringBuilder builder = new StringBuilder(row1.size());
        StringBuilder builder2 = new StringBuilder(row2.size());
        StringBuilder builder3 = new StringBuilder(row3.size());
        StringBuilder builder4 = new StringBuilder(row4.size());

        StringBuilder builder5 = new StringBuilder(row5.size());
        StringBuilder builder6 = new StringBuilder(row6.size());
        StringBuilder builder7 = new StringBuilder(row7.size());
        StringBuilder builder8 = new StringBuilder(row8.size());

     
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
        for (Character ch : row5) {
            builder5.append("\t" + ch);
        }
        for (Character ch : row6) {
            builder6.append("\t" + ch);
        }
        for (Character ch : row7) {
            builder7.append("\t" + ch);
        }
        for (Character ch : row8) {
            builder8.append("\t" + ch);
        }
     
        Map.setText("The Eastern Graveyard \n ^ represents your current location. \n  O represent a reachable location \n X represent a location that is unreachable \n"  + builder8.toString() + "\n"
                + builder7.toString() + "\n" + builder6.toString() + "\n" + builder5.toString() + "\n" + builder4.toString() + "\n"
                + builder3.toString() + "\n" + builder2.toString() + "\n" + builder.toString() + "\n");
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
      public void go_inside_boldmans_areana() throws IOException {
           if(locations[13] == true) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");

        alert.setContentText("Cave already cleared!");

        ButtonType buttonTypeOne = new ButtonType("Ok");
    
      
        alert.getButtonTypes().setAll(buttonTypeOne);
        Optional<ButtonType> result = alert.showAndWait();
       }
          else {
        Stage Stage = new Stage();
        Stage.setTitle("Inside Cave 2");
        Parent root = FXMLLoader.load(getClass().getResource("/The_eastern_graveyard/Cave2room1.fxml"));
        Stage.setScene(new Scene(root, 800, 800));
        Stage.show();
        closeWindow();
    }
      }
    public void go_East() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/The_eastern_graveyard/Cave3.fxml"));

        Stage stage = new Stage();

        stage.setTitle("Cave 3");
        stage.setScene(new Scene(root, 1000, 750));
        stage.show();
        closeWindow();
    }

    public void go_SouthWest() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/The_eastern_graveyard/Cave1.fxml"));

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

    public void go_NorthEast() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Cave 3");
        Parent root = FXMLLoader.load(getClass().getResource("/The_eastern_graveyard/Cave3.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    public void go_West() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Cabin");
        Parent root = FXMLLoader.load(getClass().getResource("/The_eastern_graveyard/Cabin.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Go_North.getScene().getWindow();
        stage.close();
    }
}
