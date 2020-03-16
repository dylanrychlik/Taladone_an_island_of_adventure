package Davenrun;

import static Davenrun.OutsidehouseController.Sidequests;
import DavenrunCrabs.Crabs;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.awt.*;
import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ArrayList;

import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class GameroomController implements Initializable {

    Poker game = new Poker();
    Slotmachine test = new Slotmachine();
    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    @FXML
    private TextArea prompt;
    @FXML
    private Button lobby;
    @FXML
    private Button Management_center;
    @FXML
    private ComboBox Actions;
    @FXML
    private ComboBox Game;
    @FXML
    private Button Exit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        prompt.setText("Welcome to the Game room! \n Here you can play games and bet.");
        prompt.setEditable(false);
        Actions.getItems().addAll("Allison Swanson", "Chris Gimmerman", "Racheal Paige", "Quincy Johner", "Mac Black", "Victoria Dove");
        prompt.setPrefHeight(80);
        Game.getItems().addAll("Black Jack", "Poker", "Tictactoe", "Janken");
        Actions.setValue("Talk to");
        Game.setValue("Play game");
    }

    public GameroomController() {
        this.lobby = new Button();
        this.Management_center = new Button();
        this.Actions = new ComboBox();
        this.Game = new ComboBox();

        this.Exit = new Button();
    }

    public void victoria_dove() throws IOException {
        if (Sidequests[9] == true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Side quest already completed!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Victora Dove");

            alert.setContentText("Can you help? There is a man following me. I'm afraid he is going to hurt me. \n Can you help me? ");

            ButtonType buttonTypeOne = new ButtonType("Yes");
            ButtonType buttonTypeTwo = new ButtonType("No");
            ButtonType buttonTypeCancel = new ButtonType("Exit");
            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == buttonTypeOne) {

                Stage Stage = new Stage();
                Stage.setTitle("The Follwer");
                Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Talk_victoria_dove.fxml"));
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

    public void racheal_paige() throws IOException {
        if (Sidequests[15] == true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Side quest already completed!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Racheal Paige");

            alert.setContentText("You: Hey you just stoled from me! Get back here! ");

            ButtonType buttonTypeOne = new ButtonType("Ok");

            alert.getButtonTypes().setAll(buttonTypeOne);
            Optional<ButtonType> result = alert.showAndWait();

            Stage Stage = new Stage();
            Stage.setTitle("The Thief");
            Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Talk_thief.fxml"));
            Stage.setScene(new Scene(root, 1000, 750));
            Stage.show();
            closeWindow();

        }
    }

    public void quincey() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Quincy Joner: You know, I don’t understand what all the fuss is about the Casino, it’s nice to drink and play some games after a hard days work.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void mac() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Mac Black: Davenrun Run needs to learn how to relax. This is the safest location in the entire island. Step outside the gate, and you are in hell.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void exit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Insidecasino.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Casino");
        Stage.setScene(new Scene(root, 800, 400));
        Stage.show();
        closeWindow();
    }

    public void allison() throws IOException {
        if (Sidequests[14] == true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Side quest already completed!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Allison Swanson");

            alert.setContentText("You're atrative. Would you like to go on date with me? ");

            ButtonType buttonTypeOne = new ButtonType("Yes");
            ButtonType buttonTypeTwo = new ButtonType("No");
            ButtonType buttonTypeCancel = new ButtonType("Exit");
            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == buttonTypeOne) {

                Stage Stage = new Stage();
                Stage.setTitle("The Date");
                Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/The_date.fxml"));
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

    public void chirs() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Chris Gimmerman");

        alert.setContentText("Common, just one more and I'll hit gold!");

        ButtonType buttonTypeOne = new ButtonType("Are you here all the time?");
        ButtonType buttonTypeTwo = new ButtonType("Tell me about your self.");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            alert.setHeight(500);
            alert.setContentText("Yes. It is an addiction. I simply can not stop playing. I have lost everything and regained everything all over again. If I can’t not play, then I go insane. \n I haven’t slept in 3 days. Curse the Jarl for letting this happen. It’s worse than drinking, it’s worse than murder, it’s betting everything you work so hard for to get a little profit.");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                chirs();
            }
        }
        if (result.get() == buttonTypeTwo) {
            alert.setHeight(500);
            alert.setContentText("Yes. Chris: Born and raised here. My father traveled here before the caisno and the areana was greddy. When I was a young boy, my father told me to not risk your hard days work in a card game \n I was too niave to listen to him, he died in the raptor cave. I spend years trying to provide for the mother. When she died and my sister left Taladone, I came to the casino. When I’m tired I sleep, when I’m hungry I eat, \n when I need to piss or shit, I piss or shit, the rest of the time I am here. \n I have nothing else to live for. I have lost everything and gained it all back so many times that it doesn’t phase me anymore.");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                chirs();
            }
        }
        if (result.get() == buttonTypeCancel) {
            alert.setContentText("Chirs: Well alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
    }

    public void crabs() throws InterruptedException, IOException {
        Crabs object = new Crabs();
        object.Crabs();
    }

    public void poker() throws InterruptedException, IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/simplepokerjavafx/PokerUI.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Poker UI");
        stage.show();
        stage.show();
        closeWindow();

    }

    public void blackjack() throws InterruptedException, IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/blackjack/BlackJackUI.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        // scene.getStylesheets().add("/simplepokerjavafx/transactionsystemgui.css");
        stage.setScene(scene);
        stage.setTitle("BlackJack UI");
        stage.show();
    }

    public void tictactoe() throws InterruptedException, Exception {
     TicTacToe game = new TicTacToe();
     
     game.TicTacToe();

    }

    @FXML
    public void rockpapersiccors() throws InterruptedException, IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/janken/JakenGUI.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Jaken");
        stage.show();

    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Actions.getScene().getWindow();
        stage.close();
    }

    public void doAction2() throws InterruptedException, IOException, Exception {
        switch (Game.getValue().toString()) {
            case "Black Jack": //Action for this item
                blackjack();
                break;
            case "Poker": //Action for this item
                poker();
                break;
            case "Tictactoe": //Action for this item
                tictactoe();
                break;
            case "Slot Machine":
                crabs();
                break;
            case "Janken":
                rockpapersiccors();
                break;
            default: //Default action
                break;
        }
    }

    public void doAction() throws IOException {

        switch (Actions.getValue().toString()) {
            //Actions.getItems().addAll("Allison Swanson", "Chris Gimmerman", "Racheal Paige","Quincy Johner","Mac Black","Victoria Dove");
            case "Allison Swanson": //Action for this item
                allison();
                break;
            case "Chris Gimmerman":
                chirs();
                break;
            case "Racheal Paige": //Action for this item
                racheal_paige();
                break;
            case "Quincy Johner": //Action for this item
                quincey();
                break;
            case "Mac Black":
                mac();
                break;
            case "Victoria Dove":
                victoria_dove();
                break;
            default: //Default action
                break;
        }
    }

    public void lobby() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Lobby");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Lobby.fxml"));
        Stage.setScene(new Scene(root, 600, 600));
        Stage.show();
        closeWindow();
    }

    public void Management_center() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Management center");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Management_center.fxml"));

        Stage.setScene(new Scene(root, 600, 600));
        Stage.show();
        closeWindow();
    }

}
