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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author The flash
 */
public class Inside_innController implements Initializable {
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
public Inside_innController(){
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
    
        alert.setTitle("Miles Fred");
        alert.setContentText("Hello, welcome to wines in. What can I do for you?");
        ButtonType buttonTypeTwo = new ButtonType("What are some rumors around here?");
         
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        
        alert.getButtonTypes().setAll(buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
          if (result.get() == buttonTypeTwo) {
    alert.setHeight(500);
            alert.setContentText("Miles Fred: Did you hear about Hannah Frenchhorn? I hear she is cheating on her husband, with Masiky Helderrun! Do you hear about Ned Arseinton? \n I hear he likes this girl and doesn’t know how to approach her.....poor soul. I think Glen NorthStell is crazy, he says these strange green people did ''Experments'' on him. \n Thats about all I heard about. I hope you have a good day! ");
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
 public void prisoner1(){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hannah FrenchHorn ");
        alert.setContentText(" Hannah Frenchhorn: I can’t belive this is happening! Why did I lose control?");
        ButtonType ok = new ButtonType("What happened?");
        ButtonType exit = new ButtonType("Exit");
        alert.getButtonTypes().setAll(ok,exit);
           
        Optional<ButtonType> result = alert.showAndWait();
    
            if (result.get() == ok) {

            alert.setContentText("My husband left me, I cheated on him with Masiky Helderrum \n but Masiky is so sweet and all my husband does is drink and \n play games at the casino. Girl gets lonely without her man.");
           ok = new ButtonType("OK");
           alert.setHeight(300);
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();

        }
        if (result.get() == exit) {
            alert.setContentText("Well Alright then!");
         ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
 }
  public void prisoner2() throws IOException{
    if (Sidequests[13] == true){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");

        alert.setContentText("Side Quest already completed");
          ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
         else {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ned Anderson");

        alert.setContentText("There is this girl, I really really like her, but I am too scared about what she will say if I ask to marry her. She is so pretty, and I’m just a fool. My father says I lack the socail skills to marry somone like her. I want to prove him and everyone in Davenrun wrong. Can you help me fellow adventurer sir?");

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeTwo = new ButtonType("No");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

           Stage Stage = new Stage();
        Stage.setTitle("The girl");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Girlcave1.fxml"));
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
    public void prisoner3() throws IOException{
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Maskiky Helderhan");
        alert.setContentText(" How was I suppose to know she had a husband? She wanted to sleep with me! I couldn’t help myself");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
        
 }
        public void prisoner4() throws IOException{
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mathew Cone ");
        alert.setContentText(" I love being retired. \n I can drink all day and rest my head until my days are over. \n I did my part to Davenrun. Now I am just waiting for god to take me. ");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
        
 }
       public void prisoner5() throws IOException{
  
         if (Sidequests[1] == true){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");

        alert.setContentText("Side Quest already completed");
          ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
         else {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Glen Northsteel");

        alert.setContentText("I am telling you, they were these green people doing experments on me! Why won’t anyone listen to me!? \n These green people. They attackted me and took to this stange place and did “Experiments to me” I woke up in my bed. \n It happend in the farm just outside of town. Please adventure, can you investigate the farm? \n I will pay you in gold if you can? ");

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeTwo = new ButtonType("No");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

           Stage Stage = new Stage();
        Stage.setTitle("The Aliens");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Attack_aliens1.fxml"));
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
         public void prisoner6() throws IOException{
       if (Sidequests[7] == true){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");

        alert.setContentText("Side Quest already completed");
          ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
         else {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Mathew Cones");

        alert.setContentText("Hello laddy would you like to have a drink with me? ");

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeTwo = new ButtonType("No");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

           Stage Stage = new Stage();
        Stage.setTitle("The Drink");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Havedrink.fxml"));
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
    

