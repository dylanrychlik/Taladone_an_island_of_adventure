package Davenrun;

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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Inside_boldmans_areanaController implements Initializable {

    //String intro = "Boldman’s arena: Where the niava go to die and the rich get richer. \n If an adventure like yourself wants to makes quick gold and experience they can go in and fight evil creatures that haunt the island of Taladone. ";
    @FXML
    private TextArea prompt;
    @FXML
    private Button spider;
    @FXML
    private Button Skelaton;
    @FXML
    private Button Zombie;
    @FXML
    private Button Snake;
    @FXML
    private Button Raptor;

    public Inside_boldmans_areanaController() {
        this.prompt = new TextArea();
        this.spider = new Button();
        this.Skelaton = new Button();
        this.Zombie = new Button();
        this.Snake = new Button();
        this.Raptor = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prompt.setPrefSize(150, 30);

        prompt.setEditable(false);
    }

    public void attackspider() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Prompt");

        alert.setContentText("How many?");

        ButtonType buttonTypeOne = new ButtonType("One");
        ButtonType buttonTypeTwo = new ButtonType("Three");
        ButtonType buttonTypeCancel = new ButtonType("Five");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Attackspider.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Spider");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();

        }
        if (result.get() == buttonTypeTwo) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Attackspider2.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Spider");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();

        }
        if (result.get() == buttonTypeCancel) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Attackspider3.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Spider");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();
        }

    }

    public void attack_skelaton() throws IOException {
  Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Prompt");

        alert.setContentText("How many?");

        ButtonType buttonTypeOne = new ButtonType("One");
        ButtonType buttonTypeTwo = new ButtonType("Three");
        ButtonType buttonTypeCancel = new ButtonType("Five");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/AttackSkelaton.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Skelaton");
            Stage.setScene(new Scene(root, 800, 800));
            closeWindow();
            Stage.show();

        }
        if (result.get() == buttonTypeTwo) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/AttackSkelaton2.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Skelaton");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();

        }
        if (result.get() == buttonTypeCancel) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/AttackSkelaton3.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Skelaton");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();
        }

    }

    public void attack_Zombie() throws IOException {
  Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Prompt");

        alert.setContentText("How many?");

        ButtonType buttonTypeOne = new ButtonType("One");
        ButtonType buttonTypeTwo = new ButtonType("Three");
        ButtonType buttonTypeCancel = new ButtonType("Five");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/AttackZombie.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Zombie");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();

        }
        if (result.get() == buttonTypeTwo) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/AttackZombie2.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Zombie");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();

        }
        if (result.get() == buttonTypeCancel) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Attackzombie3.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Zombie");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();
        }
    }

    public void attack_snake() throws IOException {
  Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Prompt");

        alert.setContentText("How many?");

        ButtonType buttonTypeOne = new ButtonType("One");
        ButtonType buttonTypeTwo = new ButtonType("Three");
        ButtonType buttonTypeCancel = new ButtonType("Five");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/AttackSnake.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Snake");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();

        }
        if (result.get() == buttonTypeTwo) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Attacksnake2.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Snake");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();

        }
        if (result.get() == buttonTypeCancel) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Attacksnake3.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Snake");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();
        }
    }

    public void attack_Raptor() throws IOException {
Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Prompt");

        alert.setContentText("How many?");

        ButtonType buttonTypeOne = new ButtonType("One");
        ButtonType buttonTypeTwo = new ButtonType("Three");
        ButtonType buttonTypeCancel = new ButtonType("Five");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Attackraptor.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Raptor");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();

        }
        if (result.get() == buttonTypeTwo) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Attackraptor2.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Raptor");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();

        }
        if (result.get() == buttonTypeCancel) {

            Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Attackraptor3.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Raptor");
            Stage.setScene(new Scene(root,800, 800));
            closeWindow();
            Stage.show();
        }
    }
    public void Exit() throws IOException{
      Stage Stage = new Stage();
        Stage.setTitle("Boldsman_areana");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Boldsman_areana.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));

        Stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {   
        Stage stage = (Stage) this.prompt.getScene().getWindow();
        stage.close();
    }

}
