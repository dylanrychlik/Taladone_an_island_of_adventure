/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package The_northen_woods;

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
import static The_northen_woods.Junction1Controller.row13;
import static The_northen_woods.Northen_bridgeController.locations;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class Junction11Controller implements Initializable {

    String intro = "You travel 11th junction of the northen region. \n There seems to be no enmies you turn around the cornor… it seems quite....  \n There are no emnies in this area!";
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

    public void Junction2Controller() {
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
        row9.clear();
        row10.clear();
        row11.clear();
        row12.clear();
        row13.clear();

        row1.add('X');
        row1.add('X');
        row1.add('X');
        row1.add('O');
        row1.add('X');
        row1.add('X');
        row1.add('X');
        row1.add('X');

        row2.add('X');
        row2.add('X');
        row2.add('X');
        row2.add('O');
        row2.add('X');
        row2.add('X');
        row2.add('X');
        row2.add('X');

        row3.add('X');
        row3.add('X');
        row3.add('O');
        row3.add('X');
        row3.add('O');
        row3.add('X');
        row3.add('X');
        row3.add('X');

        row4.add('X');
        row4.add('X');
        row4.add('O');
        row4.add('X');
        row4.add('O');
        row4.add('X');
        row4.add('X');
        row4.add('X');

        row5.add('O');
        row5.add('O');
        row5.add('X');
        row5.add('X');
        row5.add('X');
        row5.add('O');
        row5.add('O');
        row5.add('O');

        row6.add('O');
        row6.add('O');
        row6.add('X');
        row6.add('X');
        row6.add('X');
        row6.add('X');
        row6.add('O');
        row6.add('O');

        row7.add('O');
        row7.add('O');
        row7.add('X');
        row7.add('X');
        row7.add('X');
        row7.add('X');
        row7.add('O');
        row7.add('O');

        row8.add('X');
        row8.add('O');
        row8.add('X');
        row8.add('X');
        row8.add('X');
        row8.add('X');
        row8.add('O');
        row8.add('X');

        row9.add('X');
        row9.add('O');
        row9.add('X');
        row9.add('X');
        row9.add('X');
        row9.add('X');
        row9.add('O');
        row9.add('X');

        row10.add('X');
        row10.add('O');
        row10.add('X');
        row10.add('X');
        row10.add('X');
        row10.add('X');
        row10.add('O');
        row10.add('^');

        row11.add('X');
        row11.add('O');
        row11.add('X');
        row11.add('X');
        row11.add('X');
        row11.add('X');
        row11.add('O');
        row11.add('X');

        row12.add('X');
        row12.add('O');
        row12.add('X');
        row12.add('X');
        row12.add('X');
        row12.add('X');
        row12.add('O');
        row12.add('X');

        row13.add('X');
        row13.add('X');
        row13.add('X');
        row13.add('X');
        row13.add('O');
        row13.add('X');
        row13.add('X');
        row13.add('X');
        Map.setPrefWidth(300);
         StringBuilder builder = new StringBuilder(row1.size());
        StringBuilder builder2 = new StringBuilder(row2.size());
        StringBuilder builder3 = new StringBuilder(row3.size());
        StringBuilder builder4 = new StringBuilder(row4.size());

        StringBuilder builder5 = new StringBuilder(row5.size());
        StringBuilder builder6 = new StringBuilder(row6.size());
        StringBuilder builder7 = new StringBuilder(row7.size());
        StringBuilder builder8 = new StringBuilder(row8.size());

        StringBuilder builder9 = new StringBuilder(row9.size());
        StringBuilder builder10 = new StringBuilder(row10.size());
        StringBuilder builder11 = new StringBuilder(row11.size());
        StringBuilder builder12 = new StringBuilder(row12.size());
        StringBuilder builder13 = new StringBuilder(row13.size());

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
        for (Character ch : row9) {
            builder9.append("\t" + ch);
        }
        for (Character ch : row10) {
            builder10.append("\t" + ch);
        }
        for (Character ch : row11) {
            builder11.append("\t" + ch);
        }

        for (Character ch : row12) {
            builder12.append("\t" + ch);
        }
        for (Character ch : row13) {
            builder13.append("\t" + ch);
        }
        Map.setText("The NorthenWoods \n ^ represents your current location. \n  O represent a reachable location \n X represent a location that is unreachable \n" + builder13.toString() + "\n" + builder12.toString() + "\n" + builder11.toString() + "\n" + builder10.toString() + "\n" + builder9.toString() + "\n" + builder8.toString() + "\n"
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

    public void go_South() throws IOException {

        Stage Stage = new Stage();
        Stage.setTitle("Cave 6");
        Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/Cave6.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();

    }

    public void go_West() throws IOException {

        if (locations[11] == false) {
            Stage Stage = new Stage();
            Stage.setTitle("Junction 12");
            Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/AttackJunction12.fxml"));
            Stage.setScene(new Scene(root, 1000, 750));
            Stage.show();
            closeWindow();
        }
        if (locations[11] == true) {
            Stage Stage = new Stage();
            Stage.setTitle("Junction 12");
            Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/Junction12.fxml"));
            Stage.setScene(new Scene(root, 1000, 750));
            Stage.show();
            closeWindow();
        }
    }

    public void go_East() throws IOException {

      
            Stage Stage = new Stage();
            Stage.setTitle("Junction 11");
            Parent root = FXMLLoader.load(getClass().getResource("/The_northen_woods/Junction11.fxml"));
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
