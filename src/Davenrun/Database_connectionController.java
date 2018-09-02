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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class Database_connectionController implements Initializable {
   @FXML
    private Label lblTest;
    @FXML
    private TextArea prompt;
    @FXML
    private Button button1;
    @FXML
    private TextField button2;
    @FXML
    private Button button3;
   
       int player_ID = 0;
        @Override
    public void initialize(URL url, ResourceBundle rb) {
     connect();
        button1.setOnAction(event -> {
         try {
             //Call a method to determine which item in the list the user has selected
             load(button2.getAccessibleText()); //Send the selected item to the method
         } catch (SQLException ex) {
             Logger.getLogger(Database_connectionController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Database_connectionController.class.getName()).log(Level.SEVERE, null, ex);
         }
        });
    }   
   public void Database_connectionController(){
        this.lblTest = new Label();
        this.prompt = new TextArea();
        this.button1 = new Button();
        this.button2 = new TextField();
        this.button3= new Button(); 
   }
   public void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/users/dylan/Desktop/Taladone.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            int ID = 0, Playtime = 0, Side_Quest_ID = 0, Player_ID = 0;
            System.out.println("Connection to SQLite has been established.");
                  String sql = "DELETE FROM Player";
            PreparedStatement statement = conn.prepareStatement(sql);

            String result = " ";

           
           
       statement.executeUpdate();
             /*  while (rs.next()) {
                   ID++;
                Player_ID = rs.getInt("Player_ID");
                Side_Quest_ID = rs.getInt("Side_Quest_ID");
                Playtime = rs.getInt("Playtime");
             
                result = "Player_ID: " + rs.getInt("Player_ID") + " Side_quest_ID: " + rs.getInt("Side_Quest_ID") + " Play time: " + rs.getInt("Playtime") + "\n";
       prompt.appendText(result);
            }
               System.out.println(ID);
          
            
            */
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
    public void show(){
        
    }
    public void load(String Player_ID) throws SQLException, IOException{
         Connection conn = null;
       
            // db parameters
            String url = "jdbc:sqlite:C:/users/dylan/Desktop/Taladone.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
         String sql = "SELECT * FROM Player WHERE Player_ID LIKE %" + button2.getAccessibleText() + "%;";
        PreparedStatement statement = conn.prepareStatement(sql);

        ResultSet rs2 = statement.executeQuery();
  int health = 0, attackdamage = 0, armor = 0, bank = 0, Game_ID = 0, Jarl_level_count = 0;
  String test = "";
          while (rs2.next()) {
        
            player_ID = rs2.getInt("Player_ID");
            Jarl_level_count = rs2.getInt("Jarl_level_count_ID");
            test = rs2.getString("Player_Name");

            health = rs2.getInt("Player_health");
            attackdamage = rs2.getInt("Player_attack_damage");
            armor = rs2.getInt("Player_armor");
            bank = rs2.getInt("Player_bank");

        }
              Player.getPlayer();
Player_ID = button2.getAccessibleText();
        Player.setName(test);
        Player.setbank(bank);
        Player.setATTACKDAMAGE(attackdamage);
        Player.setarmor(armor);
        Player.sethealth(health);
        Player.setlevel(Jarl_level_count);
        JOptionPane.showMessageDialog(null, "Game load sucessful"); 
         Stage Stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Insidehouse.fxml"));
        Stage.setTitle("Insidehouse");
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
       Stage.close();
    }
    
    public void exit(){
        
    }
}
