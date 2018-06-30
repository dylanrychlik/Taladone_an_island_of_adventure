package Davenrun;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static sun.misc.Signal.handle;

public class Taladone_an_island_of_adventure extends Application {
//Dylan Rychlik 
    //CS410 
    //Taladone: an_ island of adventure is a text based adventure game that takes place on the fictional island of Taladone. The player lives in the Town of Davenrun. In Davenrun, is the main town of the island in the central field. 
    //There 5 sections in the island. The central field, the Northern woods, the Eastern Graveyard, the Southern Ocean, and the Western Mountain.
    //Inside the town, there are dozens of characters you can interact with, two stores to buy and sell weapons, an Arena to fight different creatures. a Casino to play card games, 5 quests under the order of the Jarl of Davenrun in his Palace, 15 side quests, an Inn to hear gossip, a well to health your battle wounds, and your personal house to save your game status. 
    //The town has a gate in which you can travel to different parts of the island for a main quests to fight mysterious creatures as well as the quests boss of the game. In the Final quests, you go to the abandoned church and fight the final boss of the game: The sum of all Diabolical. 

    ButtonType buttonTypeOne = new ButtonType("Yes");
    ButtonType buttonTypeTwo = new ButtonType("No");
    int health = 100, attackdamage = 100, armor = 0, bank = 100, Game_ID = 0, Jarl_level_count = 0;
    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
    TextInputDialog dialog = new TextInputDialog("");
    String test;
    private Player player;
    Optional<String> inputresult;
    // InsidehouseController insidehouse = new InsidehouseController();
    Stage primaryStage = new Stage();
    private Player you;

    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        String title = "Taladone: \n an Island of adventure";
        TextField game_title = new TextField();
        BorderPane pane = new BorderPane();

        game_title.setText(title);

        //A button with an empty text caption.
        Button New_game = new Button("New game");
//A button with the specified text caption.
        Button Load_game = new Button("Load game");
//A button with the specified text caption and icon.
        Button exit = new Button("exit");
//game_title.setScaleY(10);

        pane.setTop(New_game);
        pane.setLeft(Load_game);
//pane.setBottom(Load_game);
        pane.setBottom(exit);

        Scene scene = new Scene(pane, 350, 90);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
        Load_game.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    load_game();
                } catch (IOException ex) {
                    Logger.getLogger(Taladone_an_island_of_adventure.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Taladone_an_island_of_adventure.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Taladone_an_island_of_adventure.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        New_game.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    create_name();
                } catch (IOException ex) {
                    Logger.getLogger(Taladone_an_island_of_adventure.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.exit(0);

            }
        });
    }

    public static void main(String[] args) throws SQLException {
        launch(args);

    }

    public void create_name() throws IOException {
        dialog.setTitle("Input a name");

        dialog.setContentText("What is your name fellow adventurer?");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            confirm_name();
        }
       
    }

    public void confirm_name() throws IOException {
        you.getPlayer();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog with Custom Actions");

        alert.setContentText("Okay " + dialog.getResult() + ", your health is at " + health + ", your attack damage is at " + attackdamage + " and armor is at " + armor + " to start. \n Are you ready to play? \n Click yes to start, click no to reenter name, click cancel to exit.");

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            you.setName(dialog.getResult());
            System.out.println(you.Getname());
            startgame();

        } else if (result.get() == buttonTypeTwo) {
            create_name();
        } else {

        }
    }

    public void startgame() throws IOException {
        Stage Stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Insidehouse.fxml"));
        Stage.setTitle("Insidehouse");
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
        primaryStage.close();
    }

    //Creates a custompane{ in java which allows the output of text for my schedule
    class CustomPane extends StackPane {

        public CustomPane(String title) {
            getChildren().add(new Label(title));
            setStyle("-fx-border-color: red");
            setPadding(new Insets(10, 10, 10, 10));
        }
    }

    public void load_game() throws ClassNotFoundException, IOException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Driver loaded");

//Connect to a database..   the location of the database, the userid, and the password.
//NOTE:  Please use Userid "root" and password ""   to make it easier to grade.
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Taladone?", "root", "sesame");
        System.out.println("Databse connected");
        try {

            String sql = "SELECT * FROM Save";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            int ID = 0, Playtime = 0, Side_Quest_ID = 0, Player_ID = 0;

            String result = " ";

            while (rs.next()) {
                Player_ID = rs.getInt("Player_ID");
                Side_Quest_ID = rs.getInt("Side_Quest_ID");
                Playtime = rs.getInt("Playtime");
                result += "Player_ID: " + rs.getInt("Player_ID") + " Side_quest_ID: " + rs.getInt("Side_Quest_ID") + " Play time: " + rs.getInt("Playtime") + "\n";

            }
            System.out.println("Resultset complete");
            //call outside house method
            TextInputDialog alert = new TextInputDialog("");
            alert.setTitle("Alert!");
            alert.setHeaderText("Alert!");
            alert.setContentText("Please pick a save to load from \n " + result);
            TextArea load = new TextArea();
            load.setText(result);
            load.setEditable(false);
            load.setWrapText(true);

            inputresult = alert.showAndWait();
            sql = "SELECT * FROM Save WHERE Player_ID = " + inputresult.get() + ";";
            statement = connection.prepareStatement(sql);

            rs = statement.executeQuery();

            while (rs.next()) {
                Player_ID = rs.getInt("Player_ID");

                Side_Quest_ID = rs.getInt("Side_Quest_ID");
                Playtime = rs.getInt("Playtime");
                result = Integer.toString(rs.getInt("Player_ID"));

            }
            System.out.println(result);
            System.out.println(inputresult.get());
            System.out.println("Resultset2 complete");
            if (inputresult.get().equals(result)) {

                intionalize_game();
            } else {
                alert.close();
                Alert alert2 = new Alert(AlertType.INFORMATION);
                alert2.setTitle("Error!");

                alert2.setContentText("Error: Incorrect input");
                ButtonType ok = new ButtonType("OK");
                alert2.getButtonTypes().setAll(ok);
                alert2.showAndWait();
            }
        } catch (SQLException e) {
            System.out.println("Error executing the request command: " + e.toString());
            e.printStackTrace();

        }

    }

    public void intionalize_game() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Driver loaded");

//Connect to a database..   the location of the database, the userid, and the password.
//NOTE:  Please use Userid "root" and password ""   to make it easier to grade.
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Taladone?", "root", "sesame");
        System.out.println("Databse connected");
        String sql = "SELECT * FROM Player WHERE Player_ID = " + inputresult.get() + ";";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs2 = statement.executeQuery();

        test = dialog.getContentText();
        while (rs2.next()) {
            String player_ID;
            player_ID = rs2.getString("Player_ID");
            Jarl_level_count = rs2.getInt("Jarl_level_count_ID");
            test = rs2.getString("Player_Name");

            health = rs2.getInt("Player_health");
            attackdamage = rs2.getInt("Player_attack_damage");
            armor = rs2.getInt("Player_armor");
            bank = rs2.getInt("Player_bank");

        }
        Player.getPlayer();

        Player.setName(test);
        Player.setbank(bank);
        Player.setATTACKDAMAGE(attackdamage);
        Player.setarmor(armor);
        Player.sethealth(health);
        Player.setlevel(Jarl_level_count);
        JOptionPane.showMessageDialog(null, "Game load sucessful");
        startgame();
    }

}
