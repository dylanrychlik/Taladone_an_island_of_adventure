/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davenrun;

import static Davenrun.OutsidehouseController.Sidequests;
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

/**
 * FXML Controller class
 *
 * @author The flash
 */
public class LobbyController implements Initializable {

    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    @FXML
    private TextArea prompt;
    @FXML
    private Button Game_Room;
    @FXML
    private Button Management_center;
    @FXML
    private ComboBox Actions;

   
   
    @FXML
    private Button Exit;

    public LobbyController() {
        this.prompt = new TextArea();
        this.Management_center = new Button();
        this.Game_Room = new Button();
        this.Actions = new ComboBox();
        this.Exit = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
  prompt.setPrefHeight(80);
        // prompt.setText("Welcome to the Jarls palce! Here you can to talk to the jarl who owns the town and everything that goes into it. ");
        prompt.setEditable(false);
        Actions.getItems().addAll("Joel Adam", "Adam Dumphry", "Kay Parson", "Nathan Irons", "Tori Tucker", "Will Williams", "Zack Arston");
    Actions.setValue("Talk to");
    }

    public void doAction() throws IOException {

        switch (Actions.getValue().toString()) {
            //Actions.getItems().addAll("Allison Swanson", "Chris Gimmerman", "Racheal Paige","Quincy Johner","Mac Black","Victoria Dove");
            case "Joel Adam": //Action for this item
                joel();
                break;
            case "Adam Dumphry":
                adam();
                break;
            case "Kay Parson": //Action for this item
                kay();
                break;
            case "Nathan Irons": //Action for this item
                nathan();
                break;
            case "Tori Tucker":
                tori();
                break;
            case "Will Williams":
                will();
                break;
            case "Zack Arston":
                zack();
            default: //Default action
                break;
        }
    }

    public void management() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Management center");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Management_center.fxml"));
        Stage.setScene(new Scene(root, 600, 600));
        Stage.show();
        closeWindow();
    }

    public void game_Room() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Game room");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Gameroom.fxml"));
        Stage.setScene(new Scene(root, 800, 400));
        Stage.show();
        closeWindow();
    }

    public void zack() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Zack Arston: The gate around Davenrun is weak and doesn’t even remotly secure our borders, we need a wall. A wall I tell you!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void joel() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Joel Adam");

        alert.setContentText("Common, just one more game and I'll hit gold!");

        ButtonType buttonTypeOne = new ButtonType("What do you think of the Casino?");
        ButtonType buttonTypeTwo = new ButtonType("Where are you from?");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            alert.setHeight(500);
            alert.setContentText("Joel: What do I think of it? Entertainment. Something that this world lacks. We can’t always be working, we need to have some down time. \n I think the casino, the inn, and the aerana have brought culture to the cultureless wasteland of this world. I haven’t always lived here in Davenrun..");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                joel();
            }
        }
        if (result.get() == buttonTypeTwo) {
            alert.setHeight(500);
            alert.setContentText("Joel: I am from Ireland laddy. The land is boring and the politics are ridiculous. It is frowned upon to have downtime.\n You will never find something as exciting as Taladone. Some call the Island of Taladone dangerous, I call it opportunity. \n An opportunity to escape life and live in a world of fantasy and imgantination. Ireland has none of it. Just miles and miles of order and illness and dullness. Here, we can actually live life in a dangourus way. \n Life is too short to live a mudane life. ");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                joel();
            }
        }
        if (result.get() == buttonTypeCancel) {
            alert.setContentText("Chirs: Well alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
    }

    public void nathan() throws IOException {
        if (Sidequests[5] == true){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Side quest already completed!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Nathan O'Connor");

        alert.setContentText("I can’t belive this is happening…My dog… he bit my youngest son. I have to put him down, but I can’t morrally do it. I can’t just put a sword through my dog, I just can’t he is my dog. Can you help me? ");

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeTwo = new ButtonType("No");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

           Stage Stage = new Stage();
        Stage.setTitle("The Dog");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Attack_dog.fxml"));
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

    public void adam() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Adam Dumphry");
        alert.setContentText("Adam: I am busy right now. I have figuire out my finincial situation.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void will() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Will Williams");
        alert.setContentText("We need to leave Taladone, the island is going downhill fast!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void kay() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Kay Parson");
        alert.setContentText("In my youth I was an adventure, now I'm just an old woman.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void tori() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Tori Tucker: I’m tired of corrupt politicians keep getting the title of the Jarl. We need a policial revolution and take over this island. ");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void Management_center() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Management center");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Management_center.fxml"));
         Stage.setScene(new Scene(root,  1000,750));
        Stage.show();
        closeWindow();
    }

    public void exit() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Casino");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Hellrunscasino.fxml"));
     Stage.setScene(new Scene(root,  1000,750));
        Stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Game_Room.getScene().getWindow();
        stage.close();
    }
}
