package Davenrun;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class InsidehouseController implements Initializable {
private Player player;

    Taladone_an_island_of_adventure name = new Taladone_an_island_of_adventure();
    @FXML
    private TextArea prompt;
    @FXML
    private Button Go_outside;
    @FXML
    private Button Sleep;
    @FXML
    private Button exit;

  //  private final OutsidehouseController stage2Controller = new OutsidehouseController();
    String intro = "You wake up in your tiny one room house. You are a simple adventurer of simple tastes. \n Your room has all the essentials to survive everyday life. \n You have a bed to rest your poor head at the end of the day. \n A table to serve food to solve your hunger, a cooking pot to prepare meals, \n a wardrobe to keep cloths and weapons, a piss bucket to perform your necessaries and \n a chest where you keep your items. You lay up in the bed feeling the \n cold pillow as you turn it over. \n It is dawn. Red conquers the skies of Davenrun, for it is a warning. \n You could either go back to bed or get out of bed to start your day.";

    // InsideHouse intro = new InsideHouse();
    public InsidehouseController() {
        this.prompt = new TextArea();
        this.Go_outside = new Button();
        this.Sleep = new Button();
        this.exit = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        prompt.setText(intro);
        prompt.setEditable(false);

    }

    public void Savegame() throws SQLException, ClassNotFoundException {
     
          Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Driver loaded");

//Connect to a database..   the location of the database, the userid, and the password.
//NOTE:  Please use Userid "root" and password ""   to make it easier to grade.
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Taladone?", "root", "sesame");
        System.out.println("Databse connected");
        Player.getPlayer();
        String sql = "INSERT INTO Player(Jarl_level_count_ID,Player_Name,Player_health ,Player_attack_damage,Player_armor,Player_bank) VALUES ('" + Player.getJarl_level_count() + "','" +  Player.Getname() + "','" + Player.gethealth()+ "','" + Player.getattackdamage() + "','" + Player.getarmor() + "','" + Player.getbank() + "');";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.executeUpdate(sql);
        String sql2 = "INSERT INTO Save(Playtime,Side_Quest_ID) VALUES ('0','0');";
       statement = connection.prepareStatement(sql2);
    statement.executeUpdate(sql2);
    
    JOptionPane.showMessageDialog(null, "Game save successful");
    
    }

    public void Go_Outsidehouse() throws IOException {

        Stage Stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Outsidehouse.fxml"));
        Stage.setTitle("Outside house");
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
        //primaryStage.close();
    }
    public void Exit() throws IOException{
       closeWindow(); 
    Stage primaryStage = new Stage();
       name.start(primaryStage);
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Go_outside.getScene().getWindow();
        stage.close();
    }

}
