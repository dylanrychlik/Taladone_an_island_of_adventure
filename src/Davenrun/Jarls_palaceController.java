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
import static Davenrun.OutsidehouseController.row1;
import static Davenrun.OutsidehouseController.row2;
import static Davenrun.OutsidehouseController.row3;
import static Davenrun.OutsidehouseController.row4;
import java.io.IOException;
import java.net.URL;
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
public class Jarls_palaceController implements Initializable {

    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    @FXML
    private TextArea prompt;
    @FXML
    private Button Go_inside;
    @FXML
    private Button Go_East;
    @FXML
    private Button Go_West;
    @FXML
    private Button Go_North;
    @FXML
    private Button Go_SouthEast;
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

    public Jarls_palaceController() {
        this.prompt = new TextArea();
     
        this.Go_inside = new Button();
        
        this.Go_SouthEast = new Button();
         this.Go_West = new Button();
        this.Go_North = new Button();
          this.Go_East = new Button();
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
        prompt.setText("Welcome to the Jarls palce! Here you can to talk to the jarl who owns the town \n and everything that goes into it. ");
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
        Actions.getItems().addAll("Justin Raxey", "Wistom Churchold", "Bobbert Frontend");

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
        row3.add('O');
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

    private void doAction(String listItem) {
        switch (listItem) {
            case "Justin Raxey":
                Fred_Wellrun();
                break;
            case "Wistom Churchold":
              Steven_Blake();
                break;
            case "Bobbert Frontend": //Action for this item
               Eastman_Condike();
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
public void go_inside() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Inside_Jarls_palace.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("jarls palace");
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
        closeWindow();
}
    public void Go_West() throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Hellrunscasino.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Helruns Casino");
        Stage.setScene(new Scene(root,  1000,750));
        Stage.show();
        closeWindow();
       
    }
    public void go_north() throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Boldsman_areana.fxml"));
         Stage Stage = new Stage();
        Stage.setTitle("Boldsman_areana");
        Stage.setScene(new Scene(root, 1000,750));
        Stage.show();
        closeWindow();
    }
    public void go_east() throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Davenrun_church.fxml"));

        Stage stage = new Stage();

        stage.setTitle("Church");
        stage.setScene(new Scene(root,  1000,750));
        stage.show();
        closeWindow();
}
    public void Go_SouthEast() throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Gate.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Gate");
        Stage.setScene(new Scene(root,  1000,750));
        Stage.show();
        closeWindow();
       
    }

    public void Fred_Wellrun() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Justin Raxey");

        alert.setContentText("Justin Raxey: The jarl is courrupt. Just like everyone else in this town!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Steven_Blake() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wistom Churchold");

        alert.setContentText("Wistom Churchold: You know, I don’t understand the hate for the jarl, he hasn’t been perfect but things would be much worse if he wasn’t here");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Eastman_Condike() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bobbert Frontend");
        alert.setContentText("Hello world!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Go_inside.getScene().getWindow();
        stage.close();
    }

}
