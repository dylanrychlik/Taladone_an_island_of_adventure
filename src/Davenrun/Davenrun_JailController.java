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


public class Davenrun_JailController implements Initializable {
@FXML
    private TextArea prompt;
@FXML
    private Button Davenrun_Guard;
@FXML
    private Button Prisoner1;
@FXML
    private Button Prisoner2;
@FXML
    private Button Prisoner3;

@FXML
    private Button Jarls_office;
@FXML
    private Button Guard_Center;
@FXML
    private Button Exit;

 public Davenrun_JailController(){
     this.prompt = new TextArea();
     this.Davenrun_Guard = new Button();
     this.Prisoner1 = new Button();
     this.Prisoner2 = new Button();
     this.Prisoner3 = new Button();
     this.Jarls_office = new Button();
     this.Guard_Center = new Button();
     this.Exit = new Button();
 }
 public void Davenrun_Guard(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Davenrun Guard");
        alert.setContentText("Davenrun Guard: Watch Yourself Traveler");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
 }
 public void prisoner1(){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Prisoner ");
        alert.setContentText(" Prisoner: I am in for Stealing gold from the casino. I was trying to provide for my family. We were gonna lose our house if we didn’t find a gold. \n I had no job, so I went to the casino and tried to steal, I was caught, now I am here");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
 }
  public void prisoner2(){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Prisoner ");
        alert.setContentText(" Prisoner: I am in for… Murder. In cold blood. In my youth… I had rather anggry temper, I killed a man who was making me very anrgy.\n The jarl at the time let me have life in prison, instead of killing me. I guess I should be thankful. I had time to think, and I am no longer angry. Just waiting for the sweet realize of death.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
 }
    public void prisoner3(){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Prisoner ");
        alert.setContentText(" Prisnor: I tried to kill my cheating and lying husband.. Lets just say things didn’t go over well and now I’m here. Hopefully I get out soon.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
 }
    public void gaurd_Center() throws IOException{
           Stage Stage = new Stage();
        Stage.setTitle("Guard center");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Guard_center.fxml"));
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
        closeWindow();   
    }
    public void jarls_office() throws IOException{
         Stage Stage = new Stage();
        Stage.setTitle("Jarls office");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Jarlsoffice.fxml"));
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
        closeWindow();  
    }
    public void exit() throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Inside_Jarls_palace.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("jarls palace");
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
        closeWindow();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         prompt.setPrefSize(850, 50);

      //  prompt.setText(intro);
        prompt.setEditable(false);
    }    
     @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Davenrun_Guard.getScene().getWindow();
        stage.close();
    }
}
