package Davenrun;

import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;

import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class OutsidehouseController implements Initializable {
public static boolean[] Sidequests = new boolean[20];
    private Inside_good_storeController lists;
    public static LinkedList<goodItem> gooditem = new LinkedList<>();
   // public static LinkedList<Weapon> Weaponitem = new LinkedList<>();
    public static Weaponlinklist Weaponitem = new Weaponlinklist();
    public static Armorlinklist Armoritem = new Armorlinklist();
    public static int MapHeight = 4;
    public static int MapWidth = 3;
    public static ArrayList<Character> row1 = new ArrayList<Character>(MapWidth);
    public static ArrayList<Character> row2 = new ArrayList<Character>(MapWidth);
    public static ArrayList<Character> row3 = new ArrayList<Character>(MapWidth);
    public static ArrayList<Character> row4 = new ArrayList<Character>(MapWidth);
    goodItem ring = new goodItem("1", "Ring", "Taladones ancient rings of the Northen woods. Said to links back to the warriors to carves them from the depths of caves of the northen woods", 10, 30);
    goodItem ruby = new goodItem("0", "ruby", "Ruby", 0, 10);
    Weapon sword5 = new Weapon("4", "sword", "sword", 140, 30);

    Weapon ax = new Weapon("5", "ake", "ake", 100, 30);

    Armor plate = new Armor("0", "armor", "armor", 100, 30);
    Armor plate2 = new Armor("1", "armor", "armor", 100, 30);
    String intro = "Your house is in the town of Davenrun \n in the center of the great mysterious island on the Irish sea. \n The year is 1215. Davenrun is the flesh and blood of Talendone,\n  the mysterious island that rules this land. \n The island is where adventurers like yourself can go to escape the \n harsh realities of life. \n There are rumors of the creatures that are thought to be tales told to us when we kids. \n The island would be a hell where sinful men go to die, \n but is a haven of adventure and opportunity if you are willing to risk everything, \n even your life to do so. \n As you walk outside, you are ready to explore your new home. \n You came from a land form away from Talendone. "
            + "\n You were picked on in your youth and considered weak. \n When your wife left you, you knew deep down, \n there was nothing left for you, so you packed all you could carried and went \n on a crowded ship to talendone. \n This is your new life and now you must make use of it, for you are an adventurer…. \n Or a fool. That is a faith that is up to you for decide.\n You are at the most Northern part of the town.\n You can either go south, west, or east. \n You notice a group of five people standing in your neighborhood. \n What would like you to do?";
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

    public OutsidehouseController() {

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
        
         this.Actions = new ComboBox();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        intionalize();
        prompt.setPrefHeight(150);
        prompt.setText(intro);
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
        Actions.getItems().addAll("Steve Helderhan", "Unkown Person", "Adrian Holderson", "Joel Orion", "Nigal Williams");
        Actions.setValue("Talk to");

        button.setOnAction(event -> {
            try {
                //Call a method to determine which item in the list the user has selected
                doAction(Actions.getValue().toString()); //Send the selected item to the method
            } catch (IOException ex) {
                Logger.getLogger(OutsidehouseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
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

    private void doAction(String listItem) throws IOException {
        switch (listItem) {
            case "Steve Helderhan": //Action for this item
                steve_helderhan();
                break;
            case "Unkown Person":
                unkown_person();
                break;
            case "Adrian Holderson": //Action for this item
                Adrian_Hoderson();
                break;
            case "Joel Orion": //Action for this item
                Joel_Orion();
                break;
            case "Nigal Williams":
                Nigel_williams();
                break;
            default: //Default action
                break;
        }
    }

    public void go_inside() throws IOException {
        Stage Stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Insidehouse.fxml"));
        Stage.setTitle("Insidehouse");
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
        closeWindow();
    }

    public void go_south() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Boldsman_areana");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Boldsman_areana.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));

        Stage.show();
        closeWindow();
    }

    public void go_West() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Venus Well");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Venus_well.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    public void go_East() throws IOException {
        Stage Stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Fordlands_general_good_store.fxml"));
        Stage.setTitle("Good store");
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    public void steve_helderhan() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Steve Helderhan");

        alert.setContentText("Hello laddy, how are you today?");

        ButtonType buttonTypeOne = new ButtonType("I'm good how are you?");
        ButtonType buttonTypeTwo = new ButtonType("I’m busy right now.");
        ButtonType buttonTypeCancel = new ButtonType("Exit", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            alert.setHeight(275);
            alert.setContentText("Ah the land here is great! My name is Steve Helderhan. In my youth, I was an adventure like you. \n I traveled here to this great and spend my enntire life here. I am growing old now.\n My time here is short. I hope you have a good day. ");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                steve_helderhan();
            }
        }
        if (result.get() == buttonTypeTwo) {
            alert.setContentText("Suit yourself then.");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
    }

    public void unkown_person() throws IOException {
        if (Sidequests[0] == true){
             Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alert!");

        alert.setContentText("Side Quest already completed");
          ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
        else {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Unknown_person");

        alert.setContentText("Unkown person: (Stares at you immensely)");

        ButtonType buttonTypeOne = new ButtonType("Why are you staying at me?");

        ButtonType buttonTypeCancel = new ButtonType("Walk away", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
           Stage Stage = new Stage();
        Stage.setTitle("The stalker");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/The_stalker.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow(); 

        }
        
    }
        
    }
    public void Adrian_Hoderson() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Adrian Hoderson");

        alert.setContentText("Adrian Hoderson: I'm busy right now. Go away.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Joel_Orion() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Joel Orion");

        alert.setContentText("Hello laddy, how are you today?");

        ButtonType buttonTypeOne = new ButtonType("What can you tell me about Davenrun?");
        ButtonType buttonTypeTwo = new ButtonType("Where are you from?");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            alert.setHeight(500);
            alert.setContentText(" What can I not tell you about Davenrun? This town is the heart and blood of taledone. \n This is the town where lost souls looking for adventure go to die. The greed from the casino makes the Jarl and \n the town leaders rich and leaves the rest of us to die. You are unbearably niave if you think this is an Island of oppritnity and adventure. \n The casino owns half the wealth in the town and they use it on booze while the rest of us are left to starve. \n The lucky ones who work stores and Davenrun Inn barley have enough to feed thier famlies, the arena is dangerous \n and kills people everyday and they take creatures from the island to get rich. This town is greedy. \n It’s the arse of the Irish sea. I wish you luck if god can give it to you. ‘");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                Joel_Orion();
            }
        }
        if (result.get() == buttonTypeTwo) {
            alert.setHeight(500);
            alert.setContentText("Joel Orion: I am from Scotland far away. At least the people in the north are hornable. I owned a store in the far away land for many years. \n It wasn’t anything like Boldsmans Areana or the Casino, but it put food on the table. Unfourtanly, times got hard and I sold the store. \n My wife left me and took my daughter and son with her. \n With nothing left, I came to Taladone and roamed here for several years, fighting great monsters, but time takes its toll on an adventure. I stopped adventuring 10 years ago. \n My days are now limited and I retire here till I lay on my death bed.");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                Joel_Orion();
            }
        }
        if (result.get() == buttonTypeCancel) {
            alert.setContentText("Well Alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }

    }

    public void Nigel_williams() throws IOException {
         if (Sidequests[1] == true){
             Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alert!");

        alert.setContentText("Side Quest already completed");
          ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
         else {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Nigel Williams");

        alert.setContentText("Oh dear. That is unfouratute. I seemed to have misplaced my book. It’s a book I need to my experments. Is it all possible for you to get it for me? \n It's a spell book in a cave not to far outside of town. Just a short walk! There are also... some... creatures... so be warned traveler");

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeTwo = new ButtonType("No");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

           Stage Stage = new Stage();
        Stage.setTitle("The stalker");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Attack_bookcave_room1.fxml"));
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
    public void stats() {

        player.getPlayer();

        String Output = "Player stats are: \n Health: " + player.gethealth() + "\n Bank:" + player.getbank() + "\n Attack damage:" + player.getattackdamage() + "\n Armor" + player.getarmor() + "\n Game level" + player.getJarl_level_count();
        stats.setText(Output);
    }

    public void intionalize() {
        gooditem.clear();
        Armoritem.clearList();
        Weaponitem.clearList();
        gooditem.addFirst(ruby);
        gooditem.addFirst(ring);
        Armoritem.addFirst(plate);
        Armoritem.addFirst(plate2);
        Weaponitem.addFirst(sword5);
        Weaponitem.addFirst(ax);
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
}
