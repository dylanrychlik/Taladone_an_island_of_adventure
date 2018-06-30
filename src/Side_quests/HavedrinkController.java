/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Side_quests;

import static Davenrun.OutsidehouseController.Armoritem;
import static Davenrun.OutsidehouseController.Sidequests;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class HavedrinkController implements Initializable {

   @FXML
    private TextArea prompt;
    @FXML
    private TextArea current;
    @FXML
    private ComboBox Actions;
    @FXML
    private Button Go_inside;
    @FXML
    private Button Go_South;
    @FXML
    private Button Go_West;
    @FXML
    private Button Go_East;
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
     String intro = "Side quests started: The drink \n ''Feels good to have a drink after a hard days work.'' - the man said. \n ''I have lived in Taladone my entire life, my father raised me to hunt and my mother \n raised me to be an honorable man, 30 years gone is too fast. \n I feel as if I am getting old. \n I want to live forever.'' - he says. \n ''Say you want another dirnk?'' - he asks";
     public void The_stalkerController() {
       
        this.prompt = new TextArea();
       
        this.Go_inside = new Button();
        this.Go_South = new Button();
        this.Go_West = new Button();
        this.Go_East = new Button();
        this.current = new TextArea();
        this.stats = new TextArea();
        this.button = new Button();
        this.Look = new ComboBox();
        this.Player_stats = new Button();
        this.Map = new TextArea();
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       prompt.setPrefHeight(150);
        prompt.setText(intro);
        prompt.setEditable(false);
        stats.setEditable(false);
        Map.setEditable(false);
        current.setEditable(false);
        current.setPrefSize(300, 300);
//ObservableList<String> people = FXCollections.observableArrayList();
        player.getPlayer();
         current.setText("Quests: \n Side Quest: The Drink \n Objective: Have a drink");
            Look.getItems().addAll("Good list", "Weapon list", "Armor list");
        Look.setValue("Look");
           button2.setOnAction(event -> {
            //Call a method to determine which item in the list the user has selected
            doAction2(Look.getValue().toString()); //Send the selected item to the method
        });
        fillmap();
    }  
    public void stats() {

        player.getPlayer();

        String Output = "Player stats are: \n Health: " + player.gethealth() + "\n Bank:" + player.getbank() + "\n Attack damage:" + player.getattackdamage() + "\n Armor" + player.getarmor() + "\n Game level" + player.getJarl_level_count();
        stats.setText(Output);
    }
@FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Go_inside.getScene().getWindow();
        stage.close();
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

        stats.setText("\n Your Armor items are \n" + out3);
    }
    public void fillmap() {
        row1.clear();
        row2.clear();
        row3.clear();
        row4.clear();
        row1.add('^');
        row1.add('O');
        row1.add('^');
        row2.add('^');
        row2.add('^');
        row2.add('^');
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
    public void talk1() throws IOException{
      
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Man"); 
         alert.setHeight(275);
            alert.setContentText("You have another drink, \n You: Screw it I want another one. \n You take a shot. Soon things go burly. \n The man speaks up ''You aright? You're a light weight!'");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
           Stage Stage = new Stage();
        Stage.setTitle("Talk inn keeper");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Talk_inn_keeper.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }
     public void talk2() throws IOException{
        

          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Man"); 
         alert.setHeight(275);
            alert.setContentText("Side quest completed!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
                  Sidequests[7] = true;
        Stage Stage = new Stage();
           Stage.setTitle("Outside House");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Outsidehouse.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }
      public void talk3(){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("The stalker"); 
         alert.setHeight(275);
            alert.setContentText("Because you main landers are all the same, you listen to what your precouse jarl tells\n  you and you kill creatures because you don’tunderstad them. We warrior do. Grew up with them. \n Underastood that they live and breathe as we do and killing them for sport is immoral. ");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();  
    }
       public void talk4() throws IOException{
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("The stalker"); 
         alert.setHeight(275);
            alert.setContentText("Lets go then adventurer ");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
             Stage Stage = new Stage();
        Stage.setTitle("Attack stalker");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Attack_stalker.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }
}
