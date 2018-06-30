/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davenrun;

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

/**
 * FXML Controller class
 *
 * @author The flash
 */
public class ArmoryController implements Initializable {

    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    @FXML
    private TextArea prompt;
    @FXML
    private Button Go_inside;
    @FXML
    private Button Go_South;
    @FXML
    private Button Go_West;
 
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
    
    public ArmoryController() {
        this.prompt = new TextArea();
        this.Go_inside = new Button();
        this.Go_South = new Button();
        this.Go_West = new Button();
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
        prompt.setPrefSize(550, 50);
        prompt.setText("Welcome to the armory! Here you can buy wepons and armor to \n protect yourself form the evil that haunts Taladone...");
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
       Actions.getItems().addAll("Bill Rates","Sebattin Ran", "Mason Mellman", "Elbert Richardson","Sam Solove","Patrick Laggace");

        Actions.setValue("Talk to");

        button.setOnAction(event -> {
            try {
                //Call a method to determine which item in the list the user has selected
                doAction(Actions.getValue().toString()); //Send the selected item to the method
            } catch (IOException ex) {
                Logger.getLogger(ArmoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        button2.setOnAction(event -> {
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
        row2.add('O');
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
            case "Sebattin Ran":
                 Denice_Cook();
                break;
            case "Mason Mellman":
                Jennifer_Windhelm(); 
                
                break;
            case "Bill Rates": //Action for this item
              Fred_Wellrun();
                break;
            case "Elbert Richardson": //Action for this item
                Micheal_Angery();
                break;
            case "Sam Solove":
                Steven_Blake();
                break;
                    case "Patrick Laggace":
                Patrick_Laggace();
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

    public void Fred_Wellrun() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bill Rates");

        alert.setContentText("Bill Rates: I don’t have time to talk, I need to buy sword.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Steven_Blake() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sam Solove");
        alert.setContentText("Sam Solove: This store is a wonderful thing. Too bad the jarl wants to take it away. How unpatritic. ");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Jennifer_Windhelm() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mason Mellman");

        alert.setContentText("Mason Mellman: These are dark times in davenrun. Gods I hope things get better. ");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Denice_Cook() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sebattin Ran");

        alert.setContentText("Sebattin Ran: Yes? No? Okay!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Micheal_Angery() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Elbert Richarson");

        alert.setContentText("Elbert Richarson: Gods, an adventure! Just like the proficy has forefold!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Jacob_Dixon() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Parkson Warstell");

        alert.setContentText("Parkson Warstell: This store is making people become murders. Murders I tell you!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Patrick_Laggace() throws IOException {
       if (Sidequests[4] == true){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");

        alert.setContentText("Side Quest already completed");
          ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
         else {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Patrick Laggace");

        alert.setContentText("I Could be better. My farm just outside of town is struggling with bussinse. There are coyotes in the farm sacring people away. If I don’t do something, I’m gonna lose profits. Say, do you want to kill the coyotes for me? I don’t have the gold to buy a sword, I gotta use to keep my bussinse alive. I’ll pay you an award, it’s the least I can do.");

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeTwo = new ButtonType("No");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

           Stage Stage = new Stage();
        Stage.setTitle("The farm");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Attack_coyote.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow(); 

        }
        if (result.get() == buttonTypeTwo) {

            alert.setContentText("I am here if you change your mind...");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();

        }
        if (result.get() == buttonTypeCancel) {
            alert.setContentText("Well Alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }

    }
    }

    public void go_inside() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("In armory");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Insidearmory.fxml"));
        Stage.setScene(new Scene(root,  1000,750));
        Stage.show();
        closeWindow();
    }
    public void go_south() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Hellrunscasino.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Helruns Casino");
        Stage.setScene(new Scene(root,  1000,750));
        Stage.show();
        closeWindow();
       
    }
      public void go_east() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Boldsman_areana.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Boldmans Areana");
        Stage.setScene(new Scene(root,  1000,750));
        Stage.show();
        closeWindow();
       
    }
public void go_north() throws IOException{
    Stage Stage = new Stage();
        Stage.setTitle("Venus Well");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Venus_well.fxml"));
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
