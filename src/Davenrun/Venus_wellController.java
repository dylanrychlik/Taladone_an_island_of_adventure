/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davenrun;

import static Davenrun.OutsidehouseController.row1;
import static Davenrun.OutsidehouseController.row1;
import static Davenrun.OutsidehouseController.row1;
import static Davenrun.OutsidehouseController.Armoritem;
import static Davenrun.OutsidehouseController.Weaponitem;
import static Davenrun.OutsidehouseController.gooditem;
import static Davenrun.OutsidehouseController.MapHeight;
import static Davenrun.OutsidehouseController.MapWidth;
import static Davenrun.OutsidehouseController.Sidequests;
import static Davenrun.OutsidehouseController.row1;
import static Davenrun.OutsidehouseController.row2;
import static Davenrun.OutsidehouseController.row3;
import static Davenrun.OutsidehouseController.row4;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class Venus_wellController implements Initializable {

    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    @FXML
    private TextArea prompt;
    @FXML
    private Button Go_South;
    @FXML
    private Button Go_East;
    @FXML
    private Button Go_SouthEast;
   
    private Button Heal_wounds;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prompt.setPrefSize(850, 50);
prompt.setText("Welcome to Venus well that can heal the sick and wounded");
        prompt.setEditable(false);
         prompt.setEditable(false);
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
        Actions.getItems().addAll("Arnold Warhammar", "Elizibeth qeenston", "Richardson Johnson");

        Actions.setValue("Talk to");

        button.setOnAction(event -> {
            try {
                //Call a method to determine which item in the list the user has selected
                doAction(Actions.getValue().toString()); //Send the selected item to the method
            } catch (IOException ex) {
                Logger.getLogger(Venus_wellController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        button2.setOnAction(event -> {
            //Call a method to determine which item in the list the user has selected
            doAction2(Look.getValue().toString()); //Send the selected item to the method
        });
        fillmap();
    }

    public Venus_wellController() {
        this.prompt = new TextArea();
        this.Go_South = new Button();
        this.Go_East = new Button();
        this.Go_SouthEast = new Button();
      this.Heal_wounds = new Button();
         this.current = new TextArea();
        this.Actions = new ComboBox();
        this.stats = new TextArea();
        this.button = new Button();
        this.Look = new ComboBox();
        this.Player_stats = new Button();
        this.Map = new TextArea();
        this.button2 = new Button();
    }
 public void fillmap() {

        int MapHeight = 4;
        int MapWidth = 3;
        row1.clear();
        row2.clear();
        row3.clear();
        row4.clear();
        row1.add('O');
        row1.add('^');
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

    private void doAction(String listItem) throws IOException {
        switch (listItem) {
            case "Arnold Warhammar":
              Arnold_Warhammar();
                break;
            case "Elizibeth qeenston":
                Elizibeth_queenston();
                break;
            case "Richardson Johnson": //Action for this item
               Richardson_johnson();
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
    public void Go_South() throws IOException {
 Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Armory.fxml"));
         Stage Stage = new Stage();
        Stage.setTitle("Armory");
        Stage.setScene(new Scene(root, 1000,750));
        Stage.show();
        closeWindow();
    }

    public void Go_East() throws IOException {

         Stage Stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Outsidehouse.fxml"));
            Stage.setTitle("Insidehouse");
            Stage.setScene(new Scene(root, 1000,750));
            Stage.show();
            closeWindow();  
    }

    public void Go_SouthEast() throws IOException {
       
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Boldsman_areana.fxml"));
         Stage Stage = new Stage();
        Stage.setTitle("Boldsman_areana");
        Stage.setScene(new Scene(root, 1000,750));
        Stage.show();
        closeWindow();
    }

    public void Richardson_johnson() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Richardson Johnson");

        alert.setContentText("Aye, bless the ancient god's of Taladone");

        ButtonType buttonTypeOne = new ButtonType("What can you tell me about this well??");
        ButtonType buttonTypeTwo = new ButtonType("Where are you from?");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            alert.setHeight(500);
            alert.setContentText("Richardson Johnson: The powers of these ancient well remain a mystery. It is rumored that it is a gift from Venus, \n the goddess of love during the peak of the Roman Empire when a big battle took place in Talandone. \n The well was a gift to the wounded who fought so hard to defend Davenrun back then that way they could make a push to take over Davenrun. \n Some say the well is a blessing and a curse for that’s how all the strange monsters and creatures came to rule");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                Richardson_johnson();
            }
        }
        if (result.get() == buttonTypeTwo) {
            alert.setHeight(500);
            alert.setContentText("Richardson Johnson: Far away from the this cursed island, that is for damn sure.");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                Richardson_johnson();
            }
        }
        if (result.get() == buttonTypeCancel) {
            alert.setContentText("Richardson Johnson: Well alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }

    }

    public void Elizibeth_queenston() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Elizibeth qeenston");

        alert.setContentText("Oh dear, I hope the sick get better soon.");

        ButtonType buttonTypeOne = new ButtonType("What can you tell me about this well??");
        ButtonType buttonTypeTwo = new ButtonType("Whats your opionion on the areana?");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            alert.setHeight(500);
            alert.setContentText("Elzibeth Queenston: I am the protector of this well. I tend to the sick and wounded as they drink from the well. Things in Taledone would be much worse if we didn’t have this well. It’s… a gift from God in an island in Hell.");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                Elizibeth_queenston();
            }
        }
        if (result.get() == buttonTypeTwo) {
            alert.setHeight(500);
            alert.setContentText("Elzibeth Queenston: The Arena doesn’t scare me as much as the Casino. At least the arena has a gold opportunity. The real threat is the Casino.");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                Elizibeth_queenston();
            }
        }
        if (result.get() == buttonTypeCancel) {
            alert.setContentText("Elzibeth Queenston: Well alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
    }

    public void Arnold_Warhammar() throws IOException {
         if (Sidequests[12] == true){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");

        alert.setContentText("Side Quest already completed");
          ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
         else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Arnold Warhammar");

        alert.setContentText("You see a man inguired near the well. ");

        ButtonType buttonTypeOne = new ButtonType("What happened?");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            alert.setHeight(500);
            alert.setContentText("Arnold Hammerhan: Raptors. Thats what happened These 6 foot high walking lizards. They are attacking Davenrun. \n They are in a Cave not to far away from here. This why we need protection in Davenrun. \n We need to build a wall in Davenrun and fix our own problems before we start saving Taladone. \n We need a guard force and an Army to save Taleadone from the forces of evil... and adventurers like yourself. \n Can you clear the raptors from flightless dragon cave. If you don’t die, I will pay you a respectable gold award.");
            buttonTypeOne = new ButtonType("Yes");
            ButtonType buttonTypeTwo = new ButtonType("No");
         
          
            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
          Optional<ButtonType> newresult = alert.showAndWait();
            if (newresult.get() == buttonTypeOne) {

                Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/flightless_dragon_cave_room1.fxml"));
         Stage Stage = new Stage();
        Stage.setTitle("Boldsman_areana");
        Stage.setScene(new Scene(root, 1000,750));
        Stage.show();
        closeWindow();
    }

             if (newresult.get() == buttonTypeTwo) {
                alert.setContentText("I am here is you change your mind...");
                ButtonType ok = new ButtonType("OK");
                alert.getButtonTypes().setAll(ok);
                Optional<ButtonType> new_result = alert.showAndWait();
            }

        }
        if (result.get() == buttonTypeCancel) {
            alert.setContentText("Arnold Warhammar: Well alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }

    }
    }
    
    public void Heal_Wounds() {
        Player.getPlayer(); 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        if (Player.gethealth() < 500){
      Player.addhealth(500);
       
        alert.setContentText("Your health is now " + Player.gethealth());
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        Optional<ButtonType> new_result = alert.showAndWait();
    }
        else {
          alert.setContentText("You already have enough health!");
            ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        Optional<ButtonType> new_result = alert.showAndWait();
        }
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.prompt.getScene().getWindow();
        stage.close();
    }

}
