/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplepokerjavafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author dylan
 */
public class SimplePokerJavafx extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
     
        Parent root = FXMLLoader.load(getClass().getResource("PokerUI.fxml"));

        Scene scene = new Scene(root);
       // scene.getStylesheets().add("/simplepokerjavafx/transactionsystemgui.css");
        stage.setScene(scene);
        stage.setTitle("Poker UI");
        stage.show();
    }

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
