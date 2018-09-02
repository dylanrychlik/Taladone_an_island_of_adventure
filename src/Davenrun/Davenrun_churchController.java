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

import java.util.ArrayList;
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

public class Davenrun_churchController implements Initializable {

    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    @FXML
    private TextArea prompt;
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
    private Button Go_inside;
    @FXML
    private Button Go_South;
    @FXML
    private Button Go_North;
    @FXML
    private Button Go_West;

    public Davenrun_churchController() {
        this.prompt = new TextArea();
        this.Go_inside = new Button();
        this.Go_South = new Button();
        this.Go_North = new Button();
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
        prompt.setText("Welcome to Davenruns abandoned church!");

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
        Actions.getItems().addAll("Ed Volvo", "Bernie Welteron", "Dan Townsand", "Maderson Runton");

        Actions.setValue("Talk to");

        button.setOnAction(event -> {
            //Call a method to determine which item in the list the user has selected
            doAction(Actions.getValue().toString()); //Send the selected item to the method
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
        row2.add('^');
        row2.add('^');
        row2.add('^');
        row3.add('^');
        row3.add('^');
        row3.add('O');
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

    private void doAction(String listItem) {
        switch (listItem) {
            case "Ed Volvo":
                Fred_Wellrun();
                break;
            case "Bernie Welteron":
                Denice_Cook();
                break;
            case "Dan Townsand": //Action for this item
                Jennifer_Windhelm();
                break;
            case "Maderson Runton": //Action for this item
                Micheal_Angery();
                break;
            case "Nathan Iron":
                Steven_Blake();
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
        alert.setTitle("Ed Volvo");
        ButtonType ok = new ButtonType("OK");
        alert.setContentText("Ed Volvo: I am convinced the church is the centerhold for all of our problems in Taladone. \n There is an evil that is bigger than anything we have ever know within. It is inside, waiting to attack \n Davenrun and destory us all! If you want to be alive tomorrow, I’d suggest you don’t go inside. ");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Steven_Blake() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Nathan Steel");
        alert.setContentText("Nathan Iron: The church is haunted I tell you, some nights, I can hear stange noises from inside the church. Satan has taken over the church. This how people are dying.   ");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Jennifer_Windhelm() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dan Townsand");

        alert.setContentText("Dan Townsand: go inside the Inn to get warm and have a drink God knows every man needs it. ");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Denice_Cook() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bernie Welteron");

        alert.setContentText("Bernie Welterton: I remember when this church was a safe haven to pray to the lord and confess our sins. \n Now it the general of all the evil that it is in Taladone. ");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Micheal_Angery() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Maderson Runton");

        alert.setContentText("Maderson Runton: I am busy. I am sorry");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void go_South() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Gate.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Gate");
        Stage.setScene(new Scene(root,  1000,750));
        Stage.show();
        closeWindow();
    }

    public void go_inside() throws IOException {
        if (Player.getJarl_level_count() < 10){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setContentText("Door is locked...");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
        }
       if (Player.getJarl_level_count() == 10){
              Parent root = FXMLLoader.load(getClass().getResource("/The_final_quest/Junction1.fxml"));

            Stage stage = new Stage();

            stage.setTitle("The Final Quest");
            stage.setScene(new Scene(root, 1000, 750));
            stage.show();
            closeWindow();  
        }
           if (Player.getJarl_level_count() > 10)  {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Gate Guard");
            alert.setContentText("Gate Guard: You already completed this quest! Do you wish to retry it?");

            ButtonType ok = new ButtonType("Yes");
            ButtonType ok2 = new ButtonType("No");
           
            alert.getButtonTypes().setAll(ok,ok2);
           
             Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok){
                 Parent root = FXMLLoader.load(getClass().getResource("/The_final_quest/Junction1.fxml"));

            Stage stage = new Stage();

            stage.setTitle("The Final Quest");
            stage.setScene(new Scene(root, 1000, 750));
            stage.show();
            closeWindow();  
            }
            else {
                Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Davenrun_church.fxml"));

            Stage stage = new Stage();

            stage.setTitle("Gate");
            stage.setScene(new Scene(root, 1000, 750));
            stage.show();
            closeWindow();   
            }
        }

    }

    public void go_West() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Jarls_palace.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Jarls Palace");
        Stage.setScene(new Scene(root,  1000,750));
        Stage.show();
        closeWindow();
    }

    public void go_north() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Wines Inn");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Wines_inn.fxml"));
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
