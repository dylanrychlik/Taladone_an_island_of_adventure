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
public class Guard_centerController implements Initializable {

    @FXML
    private TextArea prompt;
    @FXML
    private Button Bill_rates;
    @FXML
    private Button Ryan_hellgon;
    @FXML
    private Button Victoria_dove;
    @FXML
    private Button Davenrun_guard4;
    @FXML
    private Button Davenrun_guard5;
    @FXML
    private Button Jarls_office;
    @FXML
    private Button Davenrun_Jail;
    @FXML
    private Button Exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prompt.setPrefSize(850, 50);

        //  prompt.setText(intro);
        prompt.setEditable(false);
    }

    public Guard_centerController() {
        this.prompt = new TextArea();
        this.Bill_rates = new Button();
        this.Ryan_hellgon = new Button();
        this.Victoria_dove = new Button();
        this.Davenrun_guard4 = new Button();
        this.Davenrun_guard5 = new Button();
        this.Jarls_office = new Button();
        this.Davenrun_Jail = new Button();
        this.Exit = new Button();
    }

    public void Guard1() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Davenrun Guard");
        alert.setContentText("Davenrun Guard: We protect the city, without us everyone would be dead. You hear me? Dead.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void Guard2() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Davenrun Guard");
        alert.setContentText(" Davenrunrynn Guard: Break the law and you will regret it. The jarl works hard to keep davenrun safe.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Guard3() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Davenrun Guard");
        alert.setContentText(" Davenrun Guard: I am the sargeant who is chage of all the guards of daverun, if there is an issue I answer to one person: The Jarl of Davenrun.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Guard4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Davenrun Guard");
        alert.setContentText(" Davenrun Guard: Yes?");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void Guard5() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Davenrun Guard");
        alert.setContentText(" Davenrun Guard: I’m new here as a Davenrun Gaurd. I hope the Jarl thinks I’m doing a great job");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();

    }

    public void jarls_office() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Jarls office");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Jarlsoffice.fxml"));
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
        closeWindow();
    }

    public void Management_center() throws IOException {
        Stage Stage = new Stage();
        Stage.setTitle("Davenrun Jail");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Davenrun_Jail.fxml"));
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
        closeWindow();
    }

    public void exit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Inside_Jarls_palace.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("jarls palace");
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Bill_rates.getScene().getWindow();
        stage.close();
    }
}
