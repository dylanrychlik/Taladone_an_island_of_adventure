/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package The_eastern_graveyard;

import The_eastern_graveyard.*;
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

/**
 * FXML Controller class
 *
 * @author The flash
 */
public class Inside_Golden_Wine_berry_innController implements Initializable {

    
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
public Inside_Golden_Wine_berry_innController(){
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
             ButtonType buttonTypeOne = new ButtonType("Are you in charge of this inn? ");
        ButtonType buttonTypeTwo = new ButtonType(" How is bussinsee?");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Elbert WineBerry");

        alert.setContentText("I hope I have enough gold for the harvest!");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
               
        Optional<ButtonType> result = alert.showAndWait();
      
      
if (result.get() == buttonTypeOne) {
       
        if (result.get() == buttonTypeOne) {
            alert.setHeight(500);
            alert.setContentText("Elbert WineBerry: I am. We are the only inn outisde the centeral region of the island and for good reason. \n I always have my sword by my side because creature always roam near the inn and damage the outside of it. \n We don't get much for demogrpahics other than adventures or travelers. The northen forrest makes it diffult, but its not nearly as bad as the sout,west,east regionsof the island. Only peoople that go therre arte form the order of the Jarl of davenrun");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                Davenrun_Guard();
            }
        }
        if (result.get () == buttonTypeTwo) {
            alert.setHeight(500);
        alert.setContentText("Elbert WineBerry: Businssee is slow unfourtantly. We only have two guests at the moment at the ost weve seen in months");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        Optional<ButtonType> new_result = alert.showAndWait();
        if (new_result.get() == ok) {
           Davenrun_Guard();
        }
    }

    if (result.get () == buttonTypeCancel) {
            alert.setContentText("Elbert WineBerry: Well alright then!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        Optional<ButtonType> new_result = alert.showAndWait();
    }

}
 }
 public void prisoner1(){
                 ButtonType buttonTypeOne = new ButtonType("Are you an aventure? ");
        ButtonType buttonTypeTwo = new ButtonType(" Where are you from?");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Devin Cardman");

        alert.setContentText("Aye, this golden wineberry warms the blood in the cold times.");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
               
        Optional<ButtonType> result = alert.showAndWait();
      
      
if (result.get() == buttonTypeOne) {
       
        if (result.get() == buttonTypeOne) {
            alert.setHeight(500);
            alert.setContentText("Devin Cardman: No, I am a traveler, I have roam the northen forrest for several years fending off creature that attack, but calling me an advenutre would just be foolish." + "\n I stay in the inn as my home. At least it keeps the inn in bussise it be a damn shame to see it fail." + "\n The inn is the ony safe place outisde the centeral region. I taladone gets better soon.");
                  //  + "// reature always roam near the inn and damage the outside of it. \n We don't get much for demogrpahics other than adventures or travelers. The northen forrest makes it diffult, but its not nearly as bad as the sout,west,east regionsof the island. Only peoople that go therre arte form the order of the Jarl of davenrun");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                Davenrun_Guard();
            }
        }
        if (result.get () == buttonTypeTwo) {
            alert.setHeight(500);
        alert.setContentText("Devin Cardman: Northen irlead. I feel my blood warm from the saying. I have the hornor and the pride of saying so myself. Hopefully the king of england will do something about taladone, but jarl can't do junk about it. ");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        Optional<ButtonType> new_result = alert.showAndWait();
        if (new_result.get() == ok) {
           Davenrun_Guard();
        }
    }

    if (result.get () == buttonTypeCancel) {
            alert.setContentText("Devin Cardman: Well alright then!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        Optional<ButtonType> new_result = alert.showAndWait();
    }

}
 }
  public void prisoner2(){
                ButtonType buttonTypeOne = new ButtonType("Are you an aventure? ");
        ButtonType buttonTypeTwo = new ButtonType(" Where are you from?");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Roland SteelHammar");

        alert.setContentText("Aye, the Dragon of Taladone haunts me in my sleep.");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
               
        Optional<ButtonType> result = alert.showAndWait();
      
      
if (result.get() == buttonTypeOne) {
       
        if (result.get() == buttonTypeOne) {
            alert.setHeight(500);
            alert.setContentText("Roland SteelHammar: I am. I am one of the few honorable ones too. Not influenced by the courruption of davenrun" + "\n I am. I am one of the few honorable ones too. Not influenced by the courruption of davenrun" + "\n All the adventures are older. You seem like an advenure and not one who is influenced by the jarl of davenrun. I hope you go and kill that dragon. The northenforrest would be safe again"); 
                    //\n I stay in the inn as my home. At least it keeps the inn in bussise it be a damn shame to see it fail." + "\n The inn is the ony safe place outisde the centeral region. I taladone gets better soon.");
                  //  + "// reature always roam near the inn and damage the outside of it. \n We don't get much for demogrpahics other than adventures or travelers. The northen forrest makes it diffult, but its not nearly as bad as the sout,west,east regionsof the island. Only peoople that go therre arte form the order of the Jarl of davenrun");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
            if (new_result.get() == ok) {
                Davenrun_Guard();
            }
        }
        if (result.get () == buttonTypeTwo) {
            alert.setHeight(500);
        alert.setContentText("Roland SteelHammar: Far away from this cursed island, thats for damn sure.");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        Optional<ButtonType> new_result = alert.showAndWait();
        if (new_result.get() == ok) {
           Davenrun_Guard();
        }
    }

    if (result.get () == buttonTypeCancel) {
            alert.setContentText("Roland SteelHammar: Well alright then!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        Optional<ButtonType> new_result = alert.showAndWait();
    }

}
 }
    
         public void exit() throws IOException{
                Stage Stage = new Stage();
        Stage.setTitle("Wines Inn");
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Wines_inn.fxml"));
        Stage.setScene(new Scene(root, 1000, 750));
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
    

