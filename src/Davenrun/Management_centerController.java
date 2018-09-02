/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davenrun;

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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author The flash
 */
public class Management_centerController implements Initializable {

    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    @FXML
   private TextArea prompt;
    @FXML
  private  Button Bill_rates;
    @FXML
   private Button Ryan_hellgon;
    @FXML
   private Button Victoria_dove;
    @FXML
   private Button Game_Room;
    @FXML
    private Button Go_to_lobby;
    @FXML
   private Button Exit;

    public Management_centerController() {
        this.prompt = new TextArea();
        this.Bill_rates = new Button();
        this.Ryan_hellgon = new Button();
        this.Victoria_dove = new Button();
        this.Game_Room = new Button();
        this.Go_to_lobby = new Button();
        this.Exit = new Button();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prompt.setPrefSize(850, 50);

        //prompt.setText(intro);
        prompt.setEditable(false);
    }

    public void Bill() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Mark Tuckenburg: People in this town are stupid. Betting everything they own, but I can’t control thier addiction. As cold as it is, their addiction is the reason why I have enough gold to feed everyone in this town. \n  But why should I give up everything I worked hard for to feed people who are lazy? I am the first assintiant. Ryan Helgon is the owner and Goerge Willinton is the second assintaint. \n I am in charge of the inner issues of the casino while goerge in charge of outside issues like talking the Jarl. Ryan deals both. Hence why he is the leader.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void Ryan() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Ryan: I am the leader of this casino. I am the reason why the casino is so popular I keep this place in business. Some think of me as an evil man, I think of myself as man of worked hard like all three of us ");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void Goerge() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("I can’t talk right now. I gotta talk go see the Jarl.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void game_Room() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Hellruns Casino");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Gameroom.fxml"));
        Stage.setScene(new Scene(root, 800, 400));
        Stage.show();
        closeWindow();
    }

    public void exit() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Hellruns casino");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Insidecasino.fxml"));
        Stage.setScene(new Scene(root, 800, 400));
        Stage.show();
        closeWindow();
    }

    public void lobby() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Lobby");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Lobby.fxml"));
        Stage.setScene(new Scene(root, 600, 600));
        Stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Bill_rates.getScene().getWindow();
        stage.close();
    }
}
