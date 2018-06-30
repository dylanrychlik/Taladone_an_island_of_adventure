
package Davenrun;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author The flash
 */
public class InsidecasinoController implements Initializable {

    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    @FXML
    TextArea prompt;
    @FXML
    Button game_room;
    @FXML
    Button lobby;
    @FXML
    Button mangement_center;
    @FXML
    Button Exit;

    public InsidecasinoController() {
        this.prompt = new TextArea();
        this.game_room = new Button();
        this.lobby = new Button();
        this.mangement_center = new Button();
        this.Exit = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          prompt.setPrefHeight(80);

        //prompt.setText(intro);
        prompt.setEditable(false);
    }
    public void game_Room() throws IOException{
      Stage Stage = new Stage();
        Stage.setTitle("Game room");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Gameroom.fxml"));
        Stage.setScene(new Scene(root, 800, 400));
        Stage.show();
        closeWindow();  
    }
    public void lobby() throws IOException{
      Stage Stage = new Stage();
        Stage.setTitle("Hellruns Casino");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Lobby.fxml"));
        Stage.setScene(new Scene(root, 600,600));
        Stage.show();
        closeWindow();    
    }
    public void Management_center() throws IOException{
          Stage Stage = new Stage();
        Stage.setTitle("Management center");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Management_center.fxml"));
        Stage.setScene(new Scene(root,  600, 600));
        Stage.show();
        closeWindow();    
    }
    public void exit() throws IOException{
         Stage Stage = new Stage();
        Stage.setTitle("Hellruns Casino");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Hellrunscasino.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();   
    }
  @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.game_room.getScene().getWindow();
        stage.close();
    }
}
