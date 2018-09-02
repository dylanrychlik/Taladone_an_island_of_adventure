package Davenrun;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
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
import static The_northen_woods.Northen_bridgeController.locations;
import static The_eastern_graveyard.Northen_bridgeController.locations;
import static The_southern_ocean.Northen_bridgeController.locations;
import static The_western_mountain.Northen_bridgeController.locations;
import static Davenrun.OutsidehouseController.Sidequests;


public class InsidehouseController implements Initializable {

    private Player player;

    Taladone_an_island_of_adventure name = new Taladone_an_island_of_adventure();
    Database_connectionController save_state = new Database_connectionController();
    @FXML
    private TextArea prompt;
    @FXML
    private Button Go_outside;
    @FXML
    private Button Sleep;
    @FXML
    private Button exit;

    //  private final OutsidehouseController stage2Controller = new OutsidehouseController();
    String intro = "You wake up in your tiny one room house. You are a simple adventurer of simple tastes. \n Your room has all the essentials to survive everyday life. \n You have a bed to rest your poor head at the end of the day. \n A table to serve food to solve your hunger, a cooking pot to prepare meals, \n a wardrobe to keep cloths and weapons, a piss bucket to perform your necessaries and \n a chest where you keep your items. You lay up in the bed feeling the \n cold pillow as you turn it over. \n It is dawn. Red conquers the skies of Davenrun, for it is a warning. \n You get out of bed and prepare to leave to and prepare for your day!";
    private static final AtomicInteger count = new AtomicInteger(0);
    private int jobID = 0;

    private boolean isFilled;

    public int Job() {

        jobID = count.incrementAndGet();
        return jobID;
    }

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
        connect();

    }

    public void connect() throws SQLException {
        Connection conn = null;
        // try {
        // db parameters
        String url = "jdbc:sqlite:C:\\Users\\dylan\\Desktop\\Taladone.db";
        // create a connection to the database
        conn = DriverManager.getConnection(url);

        System.out.println("Connection to SQLite has been established.");

        save(url);

        //} catch (SQLException e) {
        //  System.out.println(e.getMessage());
        // } finally {
        // try {
        //  if (conn != null) {
        //   conn.close();
        //  }
        //  } catch (SQLException ex) {
        // System.out.println(ex.getMessage());
        //}
        // }
    }

    public void save(String url) throws SQLException {
       save_table1();
       
    }

    public void save_table1() throws SQLException {
 String url = "jdbc:sqlite:C:\\Users\\dylan\\Desktop\\Taladone.db";
       
            Connection con = DriverManager.getConnection(url);
            String sql = "SELECT * FROM Location";
            con = DriverManager.getConnection(url);
            PreparedStatement statement = con.prepareStatement(sql);

          ResultSet rs2 = statement.executeQuery();
          int i = 0;
          while (rs2.next()){
             i++;
          }
          if (i ==0){
             con = DriverManager.getConnection(url);
            sql = "INSERT INTO Location(Location_ID,Location_name) VALUES (0,'Junction1'),(1,'Junction2'),(2,'Junction3'),"
                    + "(3,'Junction4'),(4,'Junction5'),(5,'Junction6'),(6,'Junction7'),(7,'Junction8'),(8,'Junction9'),(9,'Junction10'),(10,'Junction11'),(11,'Junction12'),"
                    + "(12,'Cave1'),(13,'Cave2'),(14,'Cave3'),(15,'Cave4'),(16,'Cave5'),(17,'Cave6'),(18,'Cave7'),"
                    + "(19,'Cave8'),(20,'Cave9'),(21,'Cave10'),(22,'Dungon'),(23,'Inn'),(24,'House1'),(25,'House2'),"
                    + "(26,'Cabin'),(27,'Crossing'),(28,'Final Boss'),(29,'Crossing1'),(30,'Crossing2');";
            con = DriverManager.getConnection(url);
          statement = con.prepareStatement(sql);

            statement.executeUpdate();
             save_table2();    
          }
          else{
            save_table2();  
          }
       
    }

    public void save_table2() throws SQLException {
        String url = "jdbc:sqlite:C:\\Users\\dylan\\Desktop\\Taladone.db";
        if (jobID == save_state.player_ID) {
            Connection con = DriverManager.getConnection(url);
            String sql = "INSERT INTO Player(Player_ID,Jarl_level_count_ID,Player_Name,Player_health ,Player_attack_damage,Player_armor,Player_bank) VALUES ('" + jobID + "','" + Player.getJarl_level_count() + "','" + Player.Getname() + "','" + Player.gethealth() + "','" + Player.getattackdamage() + "','" + Player.getarmor() + "','" + Player.getbank() + "');";
            con = DriverManager.getConnection(url);
            PreparedStatement statement = con.prepareStatement(sql);

            statement.executeUpdate();
             save_table3();
        } else {
            String sql = "UPDATE Player SET Jarl_level_count = " + Player.getJarl_level_count() + ", Player_Name = " + Player.Getname() + ", Player_health = " + Player.gethealth() + ", Player_attack_damage = " + Player.getattackdamage() + ", Player_armor = " + Player.getarmor() + ", Player_bank = " + Player.getbank() + "WHERE Player_ID =" + save_state.player_ID;
            Connection con = DriverManager.getConnection(url);
            PreparedStatement statement = con.prepareStatement(sql);

            statement.executeUpdate();
             save_table3();
        }
       

    }

    public void save_table3() throws SQLException {
String url = "jdbc:sqlite:C:\\Users\\dylan\\Desktop\\Taladone.db";
       
            Connection con = DriverManager.getConnection(url);
            String sql = "SELECT * FROM Quest";
            con = DriverManager.getConnection(url);
            PreparedStatement statement = con.prepareStatement(sql);

          ResultSet rs2 = statement.executeQuery();
          int i = 0;
          while (rs2.next()){
             i++;
          }
          if (i ==0){
             con = DriverManager.getConnection(url);
            sql = "INSERT INTO Quest(Quest_ID,Quest_name,primary_objective,secondary_objective_1,secondary_objective_2)"
                    + " VALUES (1,'The Northen Woods','Defeat the dragon of Taladone','Clear all 10 caves','Clear the dungeon'),"
                    + "(3,'The Eastern Graveyard','Defeat the Demon of the east','Clear all 10 caves','Clear the dungeon'),"
                     + "(5,'The Southern Ocean','Defeat the Sea Creature','Clear all 10 caves','Clear the dungeon'),"
                     + "(7,'The Western Mountain','Defeat the evil of the mountain','Clear all 10 caves','Clear the dungeon'),"
                     + "(9,'The Final Quest','Defeat evil of the Davenrun Church','none','none');";
                   
            con = DriverManager.getConnection(url);
          statement = con.prepareStatement(sql);

            statement.executeUpdate();
             save_table4();    
          }
          else{
            save_table4();  
          }
    }

    public void save_table4() throws SQLException {
       String url = "jdbc:sqlite:C:\\Users\\dylan\\Desktop\\Taladone.db";
       
            Connection con = DriverManager.getConnection(url);
            String sql = "SELECT * FROM Side_Quests";
            con = DriverManager.getConnection(url);
            PreparedStatement statement = con.prepareStatement(sql);

          ResultSet rs2 = statement.executeQuery();
          int i = 0;
          while (rs2.next()){
             i++;
          }
          if (i ==0){
             con = DriverManager.getConnection(url);
            sql = "INSERT INTO Side_Quests(Side_Quest_ID,Side_Quest_name,Side_quest_primary_objective)"
                    + " VALUES (1,'The aliens','Kill and escape from the aliens'),"
                    + " (2,'The book','Return the book to Nigel Williams'),"
                     + "  (3,'The coyotes','Kill the coyotes haunting the farm'),"
                     + "  (4,'The Cyborg','Kill the cyborg'),"
                     + "  (5,'The deer','Kill the deer'),"
                     + " (6,'The dog','Kill the dog'),"
                     + " (7,'The drink','Make things right from drunken state'),"
                     + " (8,'The man','Save Victoria Dove from the man'),"
                     + "  (9,'The Thief','Confron the thief'),"
                     + " (10,'The stalker','Kill the stalker'),"
                     + " (11,'The raptor','Kill the raptors'),"
                     + " (12,'The dead skull cave','Save the little girls from the cave'),"
                     + "  (13,'The girl ','Help ned win the girl'),"
                     + "  (14,'Bob and Bill','Resolve the conflict between the two brothers'),"
                     + "  (15,'The Date','Go on date with girl');";
                   
            con = DriverManager.getConnection(url);
          statement = con.prepareStatement(sql);

            statement.executeUpdate();
             save_table5();    
          }
          else{
            save_table5();  
          }
    }

    public void save_table5() throws SQLException {
         String url = "jdbc:sqlite:C:\\Users\\dylan\\Desktop\\Taladone.db";
       
          if (jobID == save_state.player_ID) {
            Connection con = DriverManager.getConnection(url);
            String sql = "INSERT INTO Quest_location_mapping(Location_ID,Quest_ID,Location_Completion) VALUES"+
                    "('" + "1" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[0] + "','" +  "'),"+
                    "('" + "2" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[1] + "','" +  "'),"+
                    "('" + "3" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[2] + "','" +  "'),"+
                     "('" + "4" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[3] + "','" +  "'),"+
                     "('" + "5" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[4] + "','" +  "'),"+
                     "('" + "6" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[5] + "','" +  "'),"+
                     "('" + "7" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[6] + "','" +  "'),"+
                     "('" + "8" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[7] + "','" +  "'),"+
                     "('" + "9" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[8] + "','" +  "'),"+
                     "('" + "10" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[9] + "','" +  "'),"+
                     "('" + "11" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[10] + "','" +  "'),"+
                     "('" + "12" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[11] + "','" +  "'),"+
                     "('" + "13" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[12] + "','" +  "'),"+
                     "('" + "14" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[13] + "','" +  "'),"+
                     "('" + "15" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[14] + "','" +  "'),"+
                     "('" + "16" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[15] + "','" +  "'),"+
                     "('" + "17" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[16] + "','" +  "'),"+
                     "('" + "18" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[17] + "','" +  "'),"+
                     "('" + "19" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[18] + "','" +  "'),"+
                     "('" + "20" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[19] + "','" +  "'),"+
                     "('" + "21" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[20] + "','" +  "'),"+
                     "('" + "22" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[21] + "','" +  "'),"+
                     "('" + "23" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[22] + "','" +  "'),"+
                     "('" + "24" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[23] + "','" +  "'),"+
                     "('" + "25" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[24] + "','" +  "'),"+
                     "('" + "26" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[25] + "','" +  "'),"+
                     "('" + "27" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[26] + "','" +  "'),"+
                     "('" + "28" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[27] + "','" +  "'),"+
                     "('" + "29" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[28] + "','" +  "'),"+
                     "('" + "30" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[29] + "','" +  "'),"+
                     "('" + "31" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[30] + "','" +  "'),"+
                   
                    "('" + "1" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[0] + "','" +  "'),"+
                    "('" + "2" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[1] + "','" +  "'),"+
                    "('" + "3" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[2] + "','" +  "'),"+
                     "('" + "4" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[3] + "','" +  "'),"+
                     "('" + "5" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[4] + "','" +  "'),"+
                     "('" + "6" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[5] + "','" +  "'),"+
                     "('" + "7" + "','"+"3" + "','"+The_eastern_graveyard.Northen_bridgeController.locations[6] + "','" +  "'),"+
                     "('" + "8" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[7] + "','" +  "'),"+
                     "('" + "9" + "','"+"3" + "','"+The_eastern_graveyard.Northen_bridgeController.locations[8] + "','" +  "'),"+
                     "('" + "10" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[9] + "','" +  "'),"+
                     "('" + "11" + "','"+"3" + "','"+The_eastern_graveyard.Northen_bridgeController.locations[10] + "','" +  "'),"+
                     "('" + "12" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[11] + "','" +  "'),"+
                     "('" + "13" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[12] + "','" +  "'),"+
                     "('" + "14" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[13] + "','" +  "'),"+
                     "('" + "15" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[14] + "','" +  "'),"+
                     "('" + "16" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[15] + "','" +  "'),"+
                     "('" + "17" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[16] + "','" +  "'),"+
                     "('" + "18" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[17] + "','" +  "'),"+
                     "('" + "19" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[18] + "','" +  "'),"+
                     "('" + "20" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[19] + "','" +  "'),"+
                     "('" + "21" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[20] + "','" +  "'),"+
                     "('" + "22" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[21] + "','" +  "'),"+
                     "('" + "23" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[22] + "','" +  "'),"+
                     "('" + "24" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[23] + "','" +  "'),"+
                     "('" + "25" + "','"+"3" + "','"+The_eastern_graveyard.Northen_bridgeController.locations[24] + "','" +  "'),"+
                     "('" + "26" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[25] + "','" +  "'),"+
                     "('" + "27" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[26] + "','" +  "'),"+
                     "('" + "28" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[27] + "','" +  "'),"+
                     "('" + "29" + "','"+"3" + "','"+The_eastern_graveyard.Northen_bridgeController.locations[28] + "','" +  "'),"+
                     "('" + "30" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[29] + "','" +  "'),"+
                     "('" + "31" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[30] + "','" +  "'),"+
                          
                    "('" + "1" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[0] + "','" +  "'),"+
                    "('" + "2" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[1] + "','" +  "'),"+
                    "('" + "3" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[2] + "','" +  "'),"+
                     "('" + "4" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[3] + "','" +  "'),"+
                     "('" + "5" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[4] + "','" +  "'),"+
                     "('" + "6" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[5] + "','" +  "'),"+
                     "('" + "7" + "','"+"5" + "','"+The_southern_ocean.Northen_bridgeController.locations[6] + "','" +  "'),"+
                     "('" + "8" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[7] + "','" +  "'),"+
                     "('" + "9" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[8] + "','" +  "'),"+
                     "('" + "10" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[9] + "','" +  "'),"+
                     "('" + "11" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[10] + "','" +  "'),"+
                     "('" + "12" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[11] + "','" +  "'),"+
                     "('" + "13" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[12] + "','" +  "'),"+
                     "('" + "14" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[13] + "','" +  "'),"+
                     "('" + "15" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[14] + "','" +  "'),"+
                     "('" + "16" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[15] + "','" +  "'),"+
                     "('" + "17" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[16] + "','" +  "'),"+
                     "('" + "18" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[17] + "','" +  "'),"+
                     "('" + "19" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[18] + "','" +  "'),"+
                     "('" + "20" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[19] + "','" +  "'),"+
                     "('" + "21" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[20] + "','" +  "'),"+
                     "('" + "22" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[21] + "','" +  "'),"+
                     "('" + "23" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[22] + "','" +  "'),"+
                     "('" + "24" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[23] + "','" +  "'),"+
                     "('" + "25" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[24] + "','" +  "'),"+
                     "('" + "26" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[25] + "','" +  "'),"+
                     "('" + "27" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[26] + "','" +  "'),"+
                     "('" + "28" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[27] + "','" +  "'),"+
                     "('" + "29" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[28] + "','" +  "'),"+
                     "('" + "30" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[29] + "','" +  "'),"+
                     "('" + "31" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[30] + "','" +  "'),"+
                          
                    "('" + "1" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[0] + "','" +  "'),"+
                    "('" + "2" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[1] + "','" +  "'),"+
                    "('" + "3" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[2] + "','" +  "'),"+
                     "('" + "4" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[3] + "','" +  "'),"+
                     "('" + "5" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[4] + "','" +  "'),"+
                     "('" + "6" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[5] + "','" +  "'),"+
                     "('" + "7" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[6] + "','" +  "'),"+
                     "('" + "8" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[7] + "','" +  "'),"+
                     "('" + "9" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[8] + "','" +  "'),"+
                     "('" + "10" + "','"+"7" + "','"+The_western_mountain.Northen_bridgeController.locations[9] + "','" +  "'),"+
                     "('" + "11" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[10] + "','" +  "'),"+
                     "('" + "12" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[11] + "','" +  "'),"+
                     "('" + "13" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[12] + "','" +  "'),"+
                     "('" + "14" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[13] + "','" +  "'),"+
                     "('" + "15" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[14] + "','" +  "'),"+
                     "('" + "16" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[15] + "','" +  "'),"+
                     "('" + "17" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[16] + "','" +  "'),"+
                     "('" + "18" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[17] + "','" +  "'),"+
                     "('" + "19" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[18] + "','" +  "'),"+
                     "('" + "20" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[19] + "','" +  "'),"+
                     "('" + "21" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[20] + "','" +  "'),"+
                     "('" + "22" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[21] + "','" +  "'),"+
                     "('" + "23" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[22] + "','" +  "'),"+
                     "('" + "24" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[23] + "','" +  "'),"+
                     "('" + "25" + "','"+"7" + "','"+The_western_mountain.Northen_bridgeController.locations[24] + "','" +  "'),"+
                     "('" + "26" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[25] + "','" +  "'),"+
                     "('" + "27" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[26] + "','" +  "'),"+
                     "('" + "28" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[27] + "','" +  "'),"+
                     "('" + "29" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[28] + "','" +  "'),"+
                     "('" + "30" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[29] + "','" +  "'),"+
                     "('" + "31" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[30] + "','" +  "');";
                   
            con = DriverManager.getConnection(url);
            PreparedStatement statement = con.prepareStatement(sql);

            statement.executeUpdate();
             save_table6();
        } else {
            String sql = "DELETE FROM Quest_location_mapping";
            Connection con = DriverManager.getConnection(url);
            PreparedStatement statement = con.prepareStatement(sql);

            statement.executeUpdate();
           con = DriverManager.getConnection(url);
       sql = "INSERT INTO Quest_location_mapping(Quest_ID,Location_ID,Location_Completion) VALUES"+
                    "('" + "1" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[0] + "','" +  "'),"+
                    "('" + "2" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[1] + "','" +  "'),"+
                    "('" + "3" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[2] + "','" +  "'),"+
                     "('" + "4" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[3] + "','" +  "'),"+
                     "('" + "5" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[4] + "','" +  "'),"+
                     "('" + "6" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[5] + "','" +  "'),"+
                     "('" + "7" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[6] + "','" +  "'),"+
                     "('" + "8" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[7] + "','" +  "'),"+
                     "('" + "9" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[8] + "','" +  "'),"+
                     "('" + "10" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[9] + "','" +  "'),"+
                     "('" + "11" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[10] + "','" +  "'),"+
                     "('" + "12" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[11] + "','" +  "'),"+
                     "('" + "13" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[12] + "','" +  "'),"+
                     "('" + "14" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[13] + "','" +  "'),"+
                     "('" + "15" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[14] + "','" +  "'),"+
                     "('" + "16" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[15] + "','" +  "'),"+
                     "('" + "17" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[16] + "','" +  "'),"+
                     "('" + "18" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[17] + "','" +  "'),"+
                     "('" + "19" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[18] + "','" +  "'),"+
                     "('" + "20" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[19] + "','" +  "'),"+
                     "('" + "21" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[20] + "','" +  "'),"+
                     "('" + "22" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[21] + "','" +  "'),"+
                     "('" + "23" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[22] + "','" +  "'),"+
                     "('" + "24" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[23] + "','" +  "'),"+
                     "('" + "25" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[24] + "','" +  "'),"+
                     "('" + "26" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[25] + "','" +  "'),"+
                     "('" + "27" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[26] + "','" +  "'),"+
                     "('" + "28" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[27] + "','" +  "'),"+
                     "('" + "29" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[28] + "','" +  "'),"+
                     "('" + "30" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[29] + "','" +  "'),"+
                     "('" + "31" + "','"+"1" + "','"+ The_northen_woods.Northen_bridgeController.locations[30] + "','" +  "'),"+
                   
                    "('" + "1" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[0] + "','" +  "'),"+
                    "('" + "2" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[1] + "','" +  "'),"+
                    "('" + "3" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[2] + "','" +  "'),"+
                     "('" + "4" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[3] + "','" +  "'),"+
                     "('" + "5" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[4] + "','" +  "'),"+
                     "('" + "6" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[5] + "','" +  "'),"+
                     "('" + "7" + "','"+"3" + "','"+The_eastern_graveyard.Northen_bridgeController.locations[6] + "','" +  "'),"+
                     "('" + "8" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[7] + "','" +  "'),"+
                     "('" + "9" + "','"+"3" + "','"+The_eastern_graveyard.Northen_bridgeController.locations[8] + "','" +  "'),"+
                     "('" + "10" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[9] + "','" +  "'),"+
                     "('" + "11" + "','"+"3" + "','"+The_eastern_graveyard.Northen_bridgeController.locations[10] + "','" +  "'),"+
                     "('" + "12" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[11] + "','" +  "'),"+
                     "('" + "13" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[12] + "','" +  "'),"+
                     "('" + "14" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[13] + "','" +  "'),"+
                     "('" + "15" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[14] + "','" +  "'),"+
                     "('" + "16" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[15] + "','" +  "'),"+
                     "('" + "17" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[16] + "','" +  "'),"+
                     "('" + "18" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[17] + "','" +  "'),"+
                     "('" + "19" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[18] + "','" +  "'),"+
                     "('" + "20" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[19] + "','" +  "'),"+
                     "('" + "21" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[20] + "','" +  "'),"+
                     "('" + "22" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[21] + "','" +  "'),"+
                     "('" + "23" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[22] + "','" +  "'),"+
                     "('" + "24" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[23] + "','" +  "'),"+
                     "('" + "25" + "','"+"3" + "','"+The_eastern_graveyard.Northen_bridgeController.locations[24] + "','" +  "'),"+
                     "('" + "26" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[25] + "','" +  "'),"+
                     "('" + "27" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[26] + "','" +  "'),"+
                     "('" + "28" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[27] + "','" +  "'),"+
                     "('" + "29" + "','"+"3" + "','"+The_eastern_graveyard.Northen_bridgeController.locations[28] + "','" +  "'),"+
                     "('" + "30" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[29] + "','" +  "'),"+
                     "('" + "31" + "','"+"3" + "','"+ The_eastern_graveyard.Northen_bridgeController.locations[30] + "','" +  "'),"+
                          
                    "('" + "1" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[0] + "','" +  "'),"+
                    "('" + "2" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[1] + "','" +  "'),"+
                    "('" + "3" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[2] + "','" +  "'),"+
                     "('" + "4" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[3] + "','" +  "'),"+
                     "('" + "5" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[4] + "','" +  "'),"+
                     "('" + "6" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[5] + "','" +  "'),"+
                     "('" + "7" + "','"+"5" + "','"+The_southern_ocean.Northen_bridgeController.locations[6] + "','" +  "'),"+
                     "('" + "8" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[7] + "','" +  "'),"+
                     "('" + "9" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[8] + "','" +  "'),"+
                     "('" + "10" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[9] + "','" +  "'),"+
                     "('" + "11" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[10] + "','" +  "'),"+
                     "('" + "12" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[11] + "','" +  "'),"+
                     "('" + "13" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[12] + "','" +  "'),"+
                     "('" + "14" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[13] + "','" +  "'),"+
                     "('" + "15" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[14] + "','" +  "'),"+
                     "('" + "16" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[15] + "','" +  "'),"+
                     "('" + "17" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[16] + "','" +  "'),"+
                     "('" + "18" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[17] + "','" +  "'),"+
                     "('" + "19" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[18] + "','" +  "'),"+
                     "('" + "20" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[19] + "','" +  "'),"+
                     "('" + "21" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[20] + "','" +  "'),"+
                     "('" + "22" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[21] + "','" +  "'),"+
                     "('" + "23" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[22] + "','" +  "'),"+
                     "('" + "24" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[23] + "','" +  "'),"+
                     "('" + "25" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[24] + "','" +  "'),"+
                     "('" + "26" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[25] + "','" +  "'),"+
                     "('" + "27" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[26] + "','" +  "'),"+
                     "('" + "28" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[27] + "','" +  "'),"+
                     "('" + "29" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[28] + "','" +  "'),"+
                     "('" + "30" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[29] + "','" +  "'),"+
                     "('" + "31" + "','"+"5" + "','"+ The_southern_ocean.Northen_bridgeController.locations[30] + "','" +  "'),"+
                          
                    "('" + "1" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[0] + "','" +  "'),"+
                    "('" + "2" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[1] + "','" +  "'),"+
                    "('" + "3" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[2] + "','" +  "'),"+
                     "('" + "4" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[3] + "','" +  "'),"+
                     "('" + "5" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[4] + "','" +  "'),"+
                     "('" + "6" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[5] + "','" +  "'),"+
                     "('" + "7" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[6] + "','" +  "'),"+
                     "('" + "8" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[7] + "','" +  "'),"+
                     "('" + "9" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[8] + "','" +  "'),"+
                     "('" + "10" + "','"+"7" + "','"+The_western_mountain.Northen_bridgeController.locations[9] + "','" +  "'),"+
                     "('" + "11" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[10] + "','" +  "'),"+
                     "('" + "12" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[11] + "','" +  "'),"+
                     "('" + "13" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[12] + "','" +  "'),"+
                     "('" + "14" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[13] + "','" +  "'),"+
                     "('" + "15" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[14] + "','" +  "'),"+
                     "('" + "16" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[15] + "','" +  "'),"+
                     "('" + "17" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[16] + "','" +  "'),"+
                     "('" + "18" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[17] + "','" +  "'),"+
                     "('" + "19" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[18] + "','" +  "'),"+
                     "('" + "20" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[19] + "','" +  "'),"+
                     "('" + "21" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[20] + "','" +  "'),"+
                     "('" + "22" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[21] + "','" +  "'),"+
                     "('" + "23" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[22] + "','" +  "'),"+
                     "('" + "24" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[23] + "','" +  "'),"+
                     "('" + "25" + "','"+"7" + "','"+The_western_mountain.Northen_bridgeController.locations[24] + "','" +  "'),"+
                     "('" + "26" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[25] + "','" +  "'),"+
                     "('" + "27" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[26] + "','" +  "'),"+
                     "('" + "28" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[27] + "','" +  "'),"+
                     "('" + "29" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[28] + "','" +  "'),"+
                     "('" + "30" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[29] + "','" +  "'),"+
                     "('" + "31" + "','"+"7" + "','"+ The_western_mountain.Northen_bridgeController.locations[30] + "','" +  "');";
                   
            con = DriverManager.getConnection(url);
        con.prepareStatement(sql);

            statement.executeUpdate();
               save_table6();
        }
     
    }

    public void save_table6() throws SQLException {
        String url = "jdbc:sqlite:C:\\Users\\dylan\\Desktop\\Taladone.db";
        if (jobID == save_state.player_ID) {
            Connection con = DriverManager.getConnection(url);
            String sql = "INSERT INTO Save(Player_ID,Side_Quest_ID,Side_quest_completion) "
                    + "VALUES ('" + jobID + "','" + "1" + "','" + Davenrun.OutsidehouseController.Sidequests[0] +"'),"+
                    "('" + jobID + "','" + "2" + "','" + Davenrun.OutsidehouseController.Sidequests[1] +"'),"+ 
                     "('" + jobID + "','" + "3" + "','" + Davenrun.OutsidehouseController.Sidequests[2] +"'),"+
                     "('" + jobID + "','" + "4" + "','" + Davenrun.OutsidehouseController.Sidequests[3] +"'),"+
                     "('" + jobID + "','" + "5" + "','" + Davenrun.OutsidehouseController.Sidequests[4] +"'),"+
                     "('" + jobID + "','" + "6" + "','" + Davenrun.OutsidehouseController.Sidequests[5] +"'),"+
                     "('" + jobID + "','" + "7" + "','" + Davenrun.OutsidehouseController.Sidequests[6] +"'),"+
                     "('" + jobID + "','" + "8" + "','" + Davenrun.OutsidehouseController.Sidequests[7] +"'),"+
                     "('" + jobID + "','" + "9" + "','" + Davenrun.OutsidehouseController.Sidequests[8] +"'),"+
                     "('" + jobID + "','" + "10" + "','" + Davenrun.OutsidehouseController.Sidequests[9] +"'),"+
                     "('" + jobID + "','" + "11" + "','" + Davenrun.OutsidehouseController.Sidequests[10] +"'),"+
                     "('" + jobID + "','" + "12" + "','" + Davenrun.OutsidehouseController.Sidequests[11] +"'),"+
                     "('" + jobID + "','" + "13" + "','" + Davenrun.OutsidehouseController.Sidequests[12] +"'),"+
                     "('" + jobID + "','" + "14" + "','" + Davenrun.OutsidehouseController.Sidequests[13] +"'),"+
                     "('" + jobID + "','" + "15" + "','" + Davenrun.OutsidehouseController.Sidequests[14] +"'),";
            con = DriverManager.getConnection(url);
            PreparedStatement statement = con.prepareStatement(sql);

            statement.executeUpdate();
             JOptionPane.showMessageDialog(null, "Game save successful");
        } else {
            String sql = "UPDATE Player SET Side_Quest_ID = 1, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[0]  + "WHERE Player_ID =" + save_state.player_ID;
            Connection con = DriverManager.getConnection(url);
            PreparedStatement statement = con.prepareStatement(sql);

            statement.executeUpdate();
            
             sql = "UPDATE Player SET Side_Quest_ID = 2, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[1]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
        
              sql = "UPDATE Player SET Side_Quest_ID = 3, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[2]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 4, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[3]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 5, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[4]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 6, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[5]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 7, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[6]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 8, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[7]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 9, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[8]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 10, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[9]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 11, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[10]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 12, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[11]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 13, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[12]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 14, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[13]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
              sql = "UPDATE Player SET Side_Quest_ID = 15, Side_quest_completion = " + Davenrun.OutsidehouseController.Sidequests[14]  + "WHERE Player_ID =" + save_state.player_ID;
           con = DriverManager.getConnection(url);
         statement = con.prepareStatement(sql);

            statement.executeUpdate();
          JOptionPane.showMessageDialog(null, "Game save successful");
        }
       
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

    public void Exit() throws IOException, SQLException {
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
