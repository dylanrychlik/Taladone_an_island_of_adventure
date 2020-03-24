package Davenrun;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author The flash
 */
public class Boldsman_areanaController implements Initializable {

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
    @FXML
    private Button Go_East;
    @FXML
    private Button Go_SouthWest;
    @FXML
    private Button Go_SouthEast;
    @FXML
    private Button Go_NorthWest;
    @FXML
    private Button Go_NorthEast;
    @FXML
    private TextField CharacterPrompt;

    public Boldsman_areanaController() {
        this.prompt = new TextArea();
        this.Go_inside = new Button();
        this.Go_South = new Button();
        this.Go_North = new Button();
        this.Go_West = new Button();
        this.Go_East = new Button();
        this.Go_SouthWest = new Button();
        this.Go_SouthEast = new Button();
        this.Go_NorthWest = new Button();
        this.Go_NorthEast = new Button();
        this.current = new TextArea();
        this.stats = new TextArea();
        this.button = new Button();
        this.Look = new ComboBox();
        this.Player_stats = new Button();
        this.Map = new TextArea();
        this.button2 = new Button();
        this.CharacterPrompt = new TextField();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String intro = "Boldman’s arena: Where the naive go to die and the rich get richer. \n If an adventure like yourself wants to make quick gold and experience \n they can go in and fight evil creatures that haunt the Island of Taladone.";

        prompt.setText(intro);
        prompt.setEditable(false);
        stats.setEditable(false);
        Map.setEditable(false);
        current.setEditable(false);
        current.setPrefSize(300, 300);
        CharacterPrompt.setVisible(false);
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
        Actions.getItems().addAll("Richardson Olderson", "Charles Oakland", "Billiams Welderson", "Bob Welderson", "John Millerman", "Alex Dobious", "Arnold Pepperpan", "Zackary Hamilton", "Elzibeth Ironlung",
                "Emmett Doverman", "Goerge Lincoln", "Sarah Wood", "Sheral the extermonator", "Hannah Kardash",
                "Janic Westman", "Dylan Elberton", "Cindi Henerys", "Emily Wariron", "Smitty Janson", "Renne Johnson");

        Actions.setValue("Talk to");

        button.setOnAction(event -> {
            try {
                //Call a method to determine which item in the list the user has selected
                doAction(Actions.getValue().toString()); //Send the selected item to the method
            } catch (IOException ex) {
                Logger.getLogger(Boldsman_areanaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Boldsman_areanaController.class.getName()).log(Level.SEVERE, null, ex);
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
        row2.add('^');
        row2.add('O');
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

    private void doAction(String listItem) throws IOException, InterruptedException {
        switch (listItem) {
            case "Richardson Olderson": //Action for this item
                Richardson_Olderson();
                break;
            case "Charles Oakland":
                Charles_Oakland();
                break;
            case "Billiams Welderson": //Action for this item
                Billiams_welderson();
                break;
            case "Bob Welderson": //Action for this item
                Bob_welderson();
                break;
            case "John Millerman":
                John_Millerman();
                break;
            case "Alex Dobious": //Action for this item
                Alexander_Dobious();
                break;
            case "Zackary Hamilton":
                Zackary_Hamilton();
                break;
            case "Elzibeth Ironlung": //Action for this item
                Elzibeth_Ironlung();
                break;
            case "Emmett Doverman": //Action for this item
                Emmett_Doverman();
                break;
            case "Goerge Lincoln":
                Goerge_Lincoln();
                break;
            case "Sarah Wood": //Action for this item
                Sarah_Wood();
                break;
            case "Sheral the extermonator":
                Sheral_the_Exterminator();
                break;
            case "Hannah Kardash": //Action for this item
                Hannah_Kardash();
                break;
            case "Janic Westman": //Action for this item
                Janice_Westman();
                break;
            case "Dylan Elberton":
                Dylan_Elberton();
                break;
            case "Cindi Henerys": //Action for this item
                Cindi_Henerys();
                break;
            case "Emily Wariron":
                Emily_Wariron();
                break;
            case "Smitty Janson": //Action for this item
                Smitty_Janson();
                break;
            case "Renne Johnson": //Action for this item
                Renne_Johnson();
                break;
            case "Arnold Pepperpan": //Action for this item
                Arnold_pepperpan();
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

    public void go_inside_boldmans_areana() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Boldsman areana");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Inside_boldmans_areana.fxml"));
        Stage.setScene(new Scene(root, 250, 350));
        Stage.show();
        closeWindow();
    }

    public void go_North() throws IOException {
        //prompt.getScene();

        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Outsidehouse.fxml"));

        Stage stage = new Stage();

//        stage.setTitle("Outside house");
        stage.setScene(new Scene(root, 1000, 750));
        stage.show();
        closeWindow();
    }

    public void go_NorthWest() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Venus_well.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Venus's well");
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    public void go_west() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Armory.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Armory");
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    public void go_east() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Wines Inn");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Wines_inn.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    public void go_Southeast() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Davenrun_church.fxml"));

        Stage stage = new Stage();

        stage.setTitle("Church");
        stage.setScene(new Scene(root, 1000, 750));
        stage.show();
        closeWindow();
    }

    public void go_SouthWest() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Hellrunscasino.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Helruns Casino");
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();

    }

    public void go_Northeast() throws IOException {
        Stage Stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Fordlands_general_good_store.fxml"));
        Stage.setTitle("Good store");
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    public void go_South() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Jarls_palace.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Jarls Palace");
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    public void Richardson_Olderson() {

        stats.setText("Richardson_Olderson: I'm sorry to inform you, too busy to talk right now.");

    }

    public void Charles_Oakland() {

        stats.setText("Charles Oakland: The areana management is always drunk while I barley have enough gold to feed my family.");

    }

    public void Billiams_welderson() throws IOException {
        if (Sidequests[8] == true) {

            stats.setText("Side Quest already completed");
        } else {

            stats.setText("Bill: Just get out Bob! Just get out! \n Bob: After everything I've done for you Bill! \n Consider this bridge burned! \n One of us may have started the fire, \n the other one of us lit the flint!");

            PauseTransition pause = new PauseTransition(Duration.seconds(12));
            pause.setOnFinished(event -> {

                try {
                    Stage Stage = new Stage();
                    Stage.setTitle("Wines Inn");
                    Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Talk_bill.fxml"));
                    Stage.setScene(new Scene(root, 1000, 750));
                    Stage.show();
                    closeWindow();
                } catch (IOException ex) {
                    Logger.getLogger(Boldsman_areanaController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
            pause.play();
        }
    }

    public void Bob_welderson() throws IOException {
        if (Sidequests[8] == true) {

            stats.setText("Side Quest already completed");
        } else {

            stats.setText("Bill: Just get out Bob! Just get out! \n Bob: After everything I've done for you Bill! \n Consider this bridge burned! \n One of us may have started the fire, \n the other one of us lit the flint!");

            PauseTransition pause = new PauseTransition(Duration.seconds(12));
            pause.setOnFinished(event -> {

                try {
                    Stage Stage = new Stage();
                    Stage.setTitle("Wines Inn");
                    Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Talk_bill.fxml"));
                    Stage.setScene(new Scene(root, 1000, 750));
                    Stage.show();
                    closeWindow();
                } catch (IOException ex) {
                    Logger.getLogger(Boldsman_areanaController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
            pause.play();
        }
    }

    public void John_Millerman() {

        stats.setText("Taladone is damned my friend, the church is said to be haunted and nobody goes there to pray /n There are differene places the island that are filled with creatures that need to be stopped! /n Davenrun is too packed and filled with greed. /n Taladone is not the island of adventure it use to be, now people are dying!");
    }

    public void Alexander_Dobious() {
        stats.setText("Alexander Dobious: If you like gossip, check out Wines Inn! If you're like me \n  and hate gossip, meet me at the casino for drinks and games!");
    }

    public void Arnold_pepperpan() {
        stats.setText("Arnold pepperpan: Stop wasting my time! Move along ye trash!");
    }

    public void Zackary_Hamilton() {
        CharacterPrompt.setPrefWidth(50);
        CharacterPrompt.setVisible(true);
        stats.setText("Zackary Hamilton: Damn Davenrun, and all its evil. \n Please choose an interaction with this Character \n "
                + "\n 1). What is wrong with Davenrun? \n 2). Where are you from? \n 3). Exit ");
        CharacterPrompt.setOnAction(event);
    }
    // action event 
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            try {
                int interaction = Integer.parseInt(CharacterPrompt.getText());
                switch (interaction) {
                    case 1: {
                        stats.setText("Zackary Hamilton: The Jarl of Davenrun is doing nothing to save Taledone from troubles, not just in the town, but outside. \n" + "The outside is even worse than the inside. \n Evil haunts Taladone, the Jarl is doing nothing about it."
                                + "\n I heard that he is looking for an adventure to his dirty work. What trash! \n  0). Exit");

                        break;
                    }
                    case 2: {
                        stats.setText("Zackary Hamilton: I am from England, my father owned \n an Inn just off the coast of the Irish Sea. \n  When I became an adult, I told him I wanted to be an adventurer. \n He lauged in my face and kicked me out of the house. \n I came here and went to the arena. Unfourtanly my dreams of being an adventure \n were crushed after I got badly injured. That was 10 years ago. \n I am thankful that I can still walk, but I will never be an adventurer again."
                                + "\n 0). Exit");

                        break;
                    }
                    case 3:
                        stats.setText("Zackary Hamilton: Well alright then!");
                        CharacterPrompt.setVisible(false);

                        break;
                    default:
                        break;
                }
                int ExitFlag = Integer.parseInt(CharacterPrompt.getText());
                if (ExitFlag == 0) {
                    Zackary_Hamilton();
                }
            } catch (java.lang.NumberFormatException x) {
                stats.setText("Answer must be numeric");
                Zackary_Hamilton();
            }
        }
    };

    public void Elzibeth_Ironlung() throws IOException {
        if (Sidequests[10] == true) {

            stats.setText("Side Quest already completed");

        } else {

            stats.setText("Elizbeth Ironlung: They kidnapped her! Just outside town! \n Please adventure! Please do something!"
                    + "\n 1) What Happened? \n 2). Sorry I can't Help. \n 3) Exit.");
            CharacterPrompt.setPrefWidth(50);
            CharacterPrompt.setVisible(true);
            CharacterPrompt.setOnAction(event2);

        }
    }
    // action event 
    EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {

            try {
                String interaction = CharacterPrompt.getText();
                switch (interaction) {
                    case "1":
                        stats.setText("Elizbeth Iron lung: Banits have taken my daughter and took her to deadweb Cave. \n There are rumors to be spiders there! Please can do you do something? \n Please adventurer! The thought of losing her makes me want to vomit! \n Yes/No?");
                        break;

                    case "2":

                        stats.setText("Elizbeth Iron lung: You're a waste of space in this town! \n I'm here if you change your mind");
                        CharacterPrompt.setVisible(false);
                        break;

                    case "3":
                        stats.setText("Elizbeth Iron Lung: Well alright then!");
                        CharacterPrompt.setVisible(false);
                        break;
                    default:
                        break;
                }

                String SideQuest_confirm = CharacterPrompt.getText();
                switch (SideQuest_confirm) {
                    case "Yes":
                    case "yes":
                    case "YES":
                    case "Y":
                        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/deadskullcave_Room1.fxml"));
                        Stage stage = new Stage();
                        stage.setTitle("Deadweb cave");
                        stage.setScene(new Scene(root, 1000, 750));
                        stage.show();
                        closeWindow();
                        break;
                    case "No":
                    case "no":
                    case "NO":
                    case "N":
                        stats.setText("Elizbeth Iron lung: You're a waste of space in this town! \n I'm here if you change your mind");
                        break;
                    default:

                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Boldsman_areanaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    };

    public void Emmett_Doverman() {

        stats.setText("Emmett Doverman: Pray for luck to come to Taladone");

    }

    public void Goerge_Lincoln() {
        stats.setText("Goerge Lincoln: You know what is wrong with Taladone my friend? Greed.");
    }

    public void Sarah_Wood() {
        stats.setText("Sarah Wood: Yes?");

    }

    public void Sheral_the_Exterminator() throws IOException, InterruptedException {
        if (Sidequests[5] == true) {
            stats.setText("Side Quest already completed");
        } else {

            stats.setPromptText("Sheral the Exterminator: I am Sheral the Exterminator: \n I am a Cybrotronic lifeform from the year 2533. \n I have traveled back in time for one mission: \n To destroy you. ");

        }

        PauseTransition pause = new PauseTransition(Duration.seconds(12));
        pause.setOnFinished(event -> {

            try {

                Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Attack_cyborg.fxml"));
                Stage stage = new Stage();

                stage.setTitle("The cyborg");
                stage.setScene(new Scene(root, 1000, 750));
                stage.show();
                closeWindow();
            } catch (IOException ex) {
                Logger.getLogger(Boldsman_areanaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        pause.play();
    }

    public void Hannah_Kardash() {
        stats.setPromptText("Hannah Kardash: If you want some gold, go to the Areana... that is if you can handle fighting monsters and creatures of course...");

    }

    public void Janice_Westman() {

        stats.setText("Janace Westman: Spare a gold for a poor old woman? Y/N?");
        CharacterPrompt.setPrefWidth(50);
        CharacterPrompt.setVisible(true);
        CharacterPrompt.setOnAction(event3);
    }
    // action event 
    EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {

            String interaction = CharacterPrompt.getText();
            if (interaction.equals("YES") || interaction.equals("Yes") || interaction.equals("Y") || interaction.equals("yes")) {
                Player.getPlayer();
                if (player.getbank() < 1) {
                    stats.setText("\n You don't have enough money in bank!");
                    CharacterPrompt.setVisible(false);
                } else {
                    player.subtractbank(1);
                    stats.setText("God bless you!");
                    CharacterPrompt.setVisible(false);
                }
            } else if (interaction.equals("NO") || interaction.equals("No") || interaction.equals("N") || interaction.equals("no")) {

                stats.setText("Don't worry, Im used to it.");
                CharacterPrompt.setVisible(false);

            } else {
                stats.setText("Don't worry, Im used to it.");
                CharacterPrompt.setVisible(false);

            }
        }

    };

    public void Dylan_Elberton() {
        CharacterPrompt.setPrefWidth(50);
        CharacterPrompt.setVisible(true);
        stats.setText("Dylan Elberton: Alomost ready for the next show. \n 1) Are you in charge of this areana? \n 2) Where are you from? \n 3) Exit");
CharacterPrompt.setOnAction(event4);
    }
  // action event 
    EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            try {
                int interaction = Integer.parseInt(CharacterPrompt.getText());
                switch (interaction) {
                    case 1: {
                        stats.setText("Dylan Elberton: Why yes I am! What a great life I live too! \n All I do is drink and go through a girlfriend at least once a week!  \n Tis a good life, and I did it by working hard and educating myself, \n unlike some of the people in this town who complain \n about not having enough gold to feed themselves. \n Mabye if you weren't such a lazy maggot, unlike me, \n mabye life would not be so difficult, \n but alas they watse their money on things I like to do for fun \n poor souls, they will never know what it is like to earn their gold. \n 0). Exit");

                        break;
                    }
                    case 2: {
                        stats.setText("Dylan Elberton: I am from the big city in England far away. \n I went to a college known as Oxford in London. \n I learned about business and ecomonics and used my knowledge to open this arena. \n With hard work, I manipulated the capitalism in Taladone to make a fourtune. \n I am now the richest person in Davenrun and \n one of the richest in the United Kingdom thanks to my hard work. \n I would give to charity, but why should I give my money that \n  I worked my arse off for to give to people who don’t want to work?  \n Makes no logical sense to me. Beggers can’t be choosers my friend. \n I wish Davenrun would start to realize that." + "\n 0). Exit");

                        break;
                    }
                    case 3:
                        stats.setText("Dylan Elberton: Well alright then!");
                        CharacterPrompt.setVisible(false);

                        break;
                    default:
                        break;
                }
                int ExitFlag = Integer.parseInt(CharacterPrompt.getText());
                if (ExitFlag == 0) {
                    Dylan_Elberton();
                }
            } catch (java.lang.NumberFormatException x) {
                stats.setText("Answer must be numeric");
               Dylan_Elberton();
            }
        }
    };

    

    public void Cindi_Henerys() {
       
         stats.setText("Cindi Henerys: I don't know what I'm doing with my life.");
       
    }

    public void Emily_Wariron() {
        
       stats.setText("Emily Wariron: I'm the daughter of John Wariron at the Armory. Stop by anytime!");
       
    }

    public void Smitty_Janson() {
         stats.setText("Smitty Janson: Hello laddy. Good to see a fellow adventurer here in Talendone. \n It's a rare thing these days. We need an adventurer more than ever too. \n People are dying and evil is ruling this land. \n Please talk to the Jarl. I'm sure he is more than willing to give you \n jobs to save the island");
      
    }

    public void Renne_Johnson() {
       
         stats.setText("Renne Johnson: God's blessing will give you light!");
       
    }
    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Go_inside.getScene().getWindow();
        stage.close();
    }

}
