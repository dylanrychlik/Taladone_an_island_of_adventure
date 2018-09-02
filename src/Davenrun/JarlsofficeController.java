
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Davenrun.EditorController;

import Davenrun.MenuController;
import Davenrun.DataModel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JarlsofficeController implements Initializable {

    static Player you;
    @FXML
    TextArea prompt;
    @FXML

    Button Bill_rates;
    @FXML
    Button Ryan_hellgon;
    @FXML
    Button Victoria_dove;
    @FXML
    Button Game_Room;
    @FXML
    Button Exit;
    
    private DataModel model ;

    public JarlsofficeController() throws IOException {
        this.prompt = new TextArea();
        this.Bill_rates = new Button();
        this.Ryan_hellgon = new Button();
        this.Victoria_dove = new Button();
        this.Game_Room = new Button();

        this.Exit = new Button();
     
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

            prompt.setPrefSize(850, 50);
            
            //prompt.setText(intro);
            prompt.setEditable(false);
            // ensure model is only set once:
           
            
          }

    public void Bill() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Are you here to see the Jarl?");
        ButtonType yes = new ButtonType("YES");
        ButtonType no = new ButtonType("NO");
        ButtonType Cancle = new ButtonType("Cancle");
        alert.getButtonTypes().setAll(yes, no, Cancle);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == yes) {

            alert.setContentText("Right this way then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();

        }
        if (result.get() == no) {

            alert.setContentText("Then leave at once! The Jarl is a busy man");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();

        }
        if (result.get() == Cancle) {
            alert.setContentText("Well Alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
        }
       
    }

    public void Ryan() throws IOException {
            if (Player.getJarl_level_count() == 0){
          Jarl1();
            }
            if (Player.getJarl_level_count() == 2){
          Jarl2(); 
            }
          if (Player.getJarl_level_count() == 4){
              Jarl3(); 
          }
          if (Player.getJarl_level_count() == 6){
              Jarl4(); 
          }
          if (Player.getJarl_level_count() == 8){
              Jarl5();
          }
          if (Player.getJarl_level_count()== 10){
              Jarl6();
          }
          if (Player.getJarl_level_count() >= 11){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        ButtonType Cancle = new ButtonType("Ok");
         alert.setHeaderText("The Jarl of Davenrun");
        alert.setContentText("Jarl: You are the hero of Taladone! I no longer need you!");
         alert.getButtonTypes().setAll(Cancle);
        Optional<ButtonType> result = alert.showAndWait();
          }
           if (Player.getJarl_level_count() == 1 || Player.getJarl_level_count() == 3 || Player.getJarl_level_count() == 5 || Player.getJarl_level_count() == 7){
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        ButtonType Cancle = new ButtonType("Ok");
         alert.setHeaderText("The Jarl of Davenrun");
        alert.setContentText("Jarl: What are you still doing here? Go to the gate and start your adventure!");
         alert.getButtonTypes().setAll(Cancle);
        Optional<ButtonType> result = alert.showAndWait();
          }
    
            if (Player.getJarl_level_count() == 9){
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        ButtonType Cancle = new ButtonType("Ok");
         alert.setHeaderText("The Jarl of Davenrun");
        alert.setContentText("Jarl: What are you still doing here? Go to the church and defeat the evil!");
         alert.getButtonTypes().setAll(Cancle);
        Optional<ButtonType> result = alert.showAndWait();
          }
           
      
    }
    public void Jarl1() {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        ButtonType Cancle = new ButtonType("Cancle");
  ButtonType yes = new ButtonType("I heard you may have some work?");
        ButtonType no = new ButtonType("Adventurer?");
        alert.setHeaderText("The Jarl of Davenrun");
        alert.setContentText("Jarl: Ahhhhhh..... adventurer what brings you here today? ");
         alert.getButtonTypes().setAll(yes, no, Cancle);
        Optional<ButtonType> result = alert.showAndWait();
        
   
      
        if (result.get() == yes) {
            while (true) {
            alert.setHeight(600);
            alert.setContentText("Jarl: Ahhh yes I do. Long ago there was a proficy that an adventure would come to Davenrun and save Taledone from the forces of evil. A man... or woman who sets out to save what Davenrun was founded on… a haven of adventures like your self. \n Taladone is becoming dangours. I don’t have guards to spare the town. That is where you come in adventure. There are diffrent places among Taladone that need to be explored. If you dare take upon the quest.");

            ButtonType yes2 = new ButtonType("What must I do?");
            ButtonType no2 = new ButtonType("That sounds dangourous?");

            alert.getButtonTypes().setAll(yes2, no2);
            Optional<ButtonType> result2 = alert.showAndWait();
            if (result2.get() == yes2) {
                alert.setHeight(600);
                alert.setContentText("Jarl: Go the Taladone Forrest for a start. There are mystroues creatures as well as a dungon that has an evil dragon that is ruling North Taladone.\n I’m afraid the dragon is going to leave the cave and attack the city we will all be doomed. Adventure. \n Go the forrest kill all the evil that haunts it and kill the dragon. If you can do that, I will pay you dearly.");

                ButtonType yes3 = new ButtonType("Yes");
                ButtonType no3 = new ButtonType("No");

                alert.getButtonTypes().setAll(yes3, no3);
                Optional<ButtonType> result3 = alert.showAndWait();

                if (result3.get() == yes3) {
                    alert.setHeight(600);
                    alert.setContentText("Jarl: Go to the gate and start your adventure!");
                
         
                     you.getPlayer();
                     you.setJarl_level_count();
                     System.out.print(you.getJarl_level_count());
                    ButtonType ok = new ButtonType("OK");
                    alert.getButtonTypes().setAll(ok);
                    Optional<ButtonType> new_result = alert.showAndWait();
                      break;
                }
                if (result3.get() == no3) {
                    alert.setHeight(600);
                    alert.setContentText("Jarl: I am here if you change your mind...");
                    ButtonType ok = new ButtonType("OK");
                    alert.getButtonTypes().setAll(ok);
                    Optional<ButtonType> new_result = alert.showAndWait();
                    break;
                    
                   
                }
            }
            if (result2.get() == no2) {
                alert.setHeight(600);
                alert.setContentText("As is the rest of taladone it is I'm afraid. When I was a young boy my father took me on a boat and traveled the Irish sea to this Island, some sort of evil came and made the island worse and worse. \n The creates became increasly difficult and dangerous. Now Taladone is an island of evil and we are in the center of it. I fear if noone stops it soon, we are all going to die....");
                ButtonType ok = new ButtonType("OK");
                alert.getButtonTypes().setAll(ok);
                Optional<ButtonType> new_result = alert.showAndWait();
                continue;
            }

        }
        }
        if (result.get() == no) {
            alert.setHeight(600);
            alert.setContentText("An adventure. A one who comes to the island to fight the forces of evil. \n A man who is wise and has no fear. A man who is brave and bold at the same time. A man who isn’t doesn’t fear death, they welcome it.\n You have those qualities to save Taladone and the rest of the world.");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            result = alert.showAndWait();
           Jarl1();
       

        }
        if (result.get() == Cancle) {
            alert.setHeight(600);
            alert.setContentText("Well Alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
              

        }
            
    }
      public void Jarl2() {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        ButtonType Cancle = new ButtonType("Cancle");
  ButtonType yes = new ButtonType("The Dragon of Taladone is defeated.");
        ButtonType no = new ButtonType("Where is my gold?");
        alert.setHeaderText("The Jarl of Davenrun");
        alert.setContentText("Jarl: Ahhhhhh..... adventurer you have returned.... ");
         alert.getButtonTypes().setAll(yes, no, Cancle);
        Optional<ButtonType> result = alert.showAndWait();
        
   
      
        if (result.get() == yes) {
            while (true) {
            alert.setHeight(600);
            alert.setContentText("Then you must of cross the crossing, did you see them…. The doogieaheads.");

            ButtonType yes2 = new ButtonType("What are they?");
            ButtonType no2 = new ButtonType("I did");

            alert.getButtonTypes().setAll(yes2, no2);
            Optional<ButtonType> result2 = alert.showAndWait();
            if (result2.get() == yes2) {
                alert.setHeight(600);
                alert.setContentText("Headless taladone warriors. And there is more than the one or two you saw I’m afraid. \n I have another quest if you dare choose to ececpt. Go the acient Taladone graveyard. \n Its in the eastern region, you must be quick on your toes \n and fast on your feet for there are haunted creatures that bump the night… and a clue to the evil that haunts Taladone. \n Go there and defeat a pontenial sargeant of the army. \n Oh and I almost forget here is you award young adventurer…");

                ButtonType yes3 = new ButtonType("Yes");
                ButtonType no3 = new ButtonType("No");

                alert.getButtonTypes().setAll(yes3, no3);
                Optional<ButtonType> result3 = alert.showAndWait();

                if (result3.get() == yes3) {
                    
                
         Player.addbank(1000);
                     you.getPlayer();
                     you.setJarl_level_count();
                     System.out.print(you.getJarl_level_count());
                    ButtonType ok = new ButtonType("OK");
                    alert.setHeight(600);
                    alert.setContentText("Jarl: Go to the gate and start your adventure! I almost forget... here is your award... You add 1000 gold. \n Your bank is now " + Player.getbank() );
                    alert.getButtonTypes().setAll(ok);
                    Optional<ButtonType> new_result = alert.showAndWait();
                      break;
                }
                if (result3.get() == no3) {
                    alert.setHeight(600);
                    alert.setContentText("Jarl: I am here if you change your mind...");
                    ButtonType ok = new ButtonType("OK");
                    alert.getButtonTypes().setAll(ok);
                    Optional<ButtonType> new_result = alert.showAndWait();
                    break;
                    
                   
                }
            }
            if (result2.get() == no2) {
                alert.setHeight(600);
                alert.setContentText("Then you know why everyone is afraid. There are acient Taladone warriors, who lost their heads. They are an army that is large enough to take over the entire island, and they have a commander.");
                ButtonType ok = new ButtonType("OK");
                alert.getButtonTypes().setAll(ok);
                Optional<ButtonType> new_result = alert.showAndWait();
                continue;
            }

        }
        }
        if (result.get() == no) {
            alert.setHeight(600);
            alert.setContentText("Paitence adventure. Did you defeat the dragon?");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            result = alert.showAndWait();
           Jarl1();
       

        }
        if (result.get() == Cancle) {
            alert.setHeight(600);
            alert.setContentText("Well Alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
              

        }
             
    }
    
        public void Jarl3() {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        ButtonType Cancle = new ButtonType("Cancle");
  ButtonType yes = new ButtonType("The sargeant was a demon from the pits of hell");
        ButtonType no = new ButtonType("Where is my gold?");
        alert.setHeaderText("The Jarl of Davenrun");
        alert.setContentText("Jarl: Ahhhhhh..... adventurer you have returned.... ");
         alert.getButtonTypes().setAll(yes, no, Cancle);
        Optional<ButtonType> result = alert.showAndWait();
        
   
      
        if (result.get() == yes) {
            while (true) {
            alert.setHeight(600);
            alert.setContentText("Ahhhhhhhh…. The acient demons of Taladone. They lead a group of five doogie heads….. But every leader has a comannder... On top of a mouantin using acient powers…");

            ButtonType yes2 = new ButtonType("What I must do?");
            ButtonType no2 = new ButtonType("Do you want me to venture to the West Taladone mountain?");

            alert.getButtonTypes().setAll(yes2, no2);
            Optional<ButtonType> result2 = alert.showAndWait();
            if (result2.get() == yes2) {
                alert.setHeight(600);
                alert.setContentText("You must go to the sountern ocean and defeat the acient taladone sea creature. He holds an acient wepon and armor and potion that will help you in future battles. \n Afterwards we will deal with the Western Mountain");

                ButtonType yes3 = new ButtonType("Yes");
                ButtonType no3 = new ButtonType("No");

                alert.getButtonTypes().setAll(yes3, no3);
                Optional<ButtonType> result3 = alert.showAndWait();

                if (result3.get() == yes3) {
                     Player.addbank(2000);
                     you.getPlayer();
                     you.setJarl_level_count();
                     System.out.print(you.getJarl_level_count());
                    ButtonType ok = new ButtonType("OK");
                    alert.setHeight(600);
                    alert.setContentText("Jarl: Go to the gate and start your adventure! I almost forget... here is your award... You add 3000 gold. \n Your bank is now " + Player.getbank() );
                    alert.getButtonTypes().setAll(ok);
                    Optional<ButtonType> new_result = alert.showAndWait();
                      break;
                }
                if (result3.get() == no3) {
                    alert.setHeight(600);
                    alert.setContentText("Jarl: I am here if you change your mind...");
                    ButtonType ok = new ButtonType("OK");
                    alert.getButtonTypes().setAll(ok);
                    Optional<ButtonType> new_result = alert.showAndWait();
                    break;
                    
                   
                }
            }
            if (result2.get() == no2) {
                alert.setHeight(600);
                alert.setContentText("No.... not yet... for Taladone's great Southern Ocean, awaits.");
                ButtonType ok = new ButtonType("OK");
                alert.getButtonTypes().setAll(ok);
                Optional<ButtonType> new_result = alert.showAndWait();
                continue;
            }

        }
        }
        if (result.get() == no) {
            alert.setHeight(600);
            alert.setContentText("Paitence adventure. Did you defeat the demon?");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            result = alert.showAndWait();
           Jarl1();
       

        }
        if (result.get() == Cancle) {
            alert.setHeight(600);
            alert.setContentText("Well Alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
              

        }
    }
      public void Jarl4() {
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        ButtonType Cancle = new ButtonType("Cancle");
  ButtonType yes = new ButtonType("I got three 3 wepons, armor, and health potion.");
        ButtonType no = new ButtonType("Where is my gold?");
        alert.setHeaderText("The Jarl of Davenrun");
        alert.setContentText("Then you are ready for the Western Mouantain and defeat the Doogiehead armys general. He is on the moauntain and will find the clue to his commander… the ultimate commander");
         alert.getButtonTypes().setAll(yes, no, Cancle);
        Optional<ButtonType> result = alert.showAndWait();
        
   
      
        if (result.get() == yes) {
         
            alert.setHeight(600);
            alert.setContentText("After you leave, there is no tuning back.. Do you still wish to go?");

                ButtonType yes3 = new ButtonType("Yes");
                ButtonType no3 = new ButtonType("No");

                alert.getButtonTypes().setAll(yes3, no3);
                Optional<ButtonType> result3 = alert.showAndWait();

                if (result3.get() == yes3) {
                     Player.addbank(3000);
                     you.getPlayer();
                     you.setJarl_level_count();
                     System.out.print(you.getJarl_level_count());
                    ButtonType ok = new ButtonType("OK");
                    alert.setHeight(600);
                    alert.setContentText("Jarl: Go to the gate and start your adventure! I almost forget... here is your award... You add 3000 gold. \n Your bank is now " + Player.getbank() );
                    alert.getButtonTypes().setAll(ok);
                    Optional<ButtonType> new_result = alert.showAndWait();
                  
                }
                if (result3.get() == no3) {
                    alert.setHeight(600);
                    alert.setContentText("Jarl: I am here if you change your mind...");
                    ButtonType ok = new ButtonType("OK");
                    alert.getButtonTypes().setAll(ok);
                    Optional<ButtonType> new_result = alert.showAndWait();
                 
                    
                   
                }
            }
          
         if (result.get() == no) {
            alert.setHeight(600);
            alert.setContentText("Paitence adventure. Did you defeat the sea Monster?");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            result = alert.showAndWait();
           Jarl1();
       

        }
        if (result.get() == Cancle) {
            alert.setHeight(600);
            alert.setContentText("Well Alright then!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> new_result = alert.showAndWait();
              

        } 
    }
      public void Jarl5() {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
      
            alert.setHeight(600);
            alert.setContentText("Ahhhhhh…. Adventure you have return. \n The skys of Davenrun have darkened. The end is near…… \n I feel it in my soul….. Go to the Davenrun church…… the door will unlock and the final battle will begin. Go luck adventure adventurer. \n If you say yes, then there is no turning back. Do you still wish to go?");

                ButtonType yes3 = new ButtonType("Yes");
                ButtonType no3 = new ButtonType("No");

                alert.getButtonTypes().setAll(yes3, no3);
                Optional<ButtonType> result3 = alert.showAndWait();

                if (result3.get() == yes3) {
                     Player.addbank(5000);
                     you.getPlayer();
                     you.setJarl_level_count();
                     System.out.print(you.getJarl_level_count());
                    ButtonType ok = new ButtonType("OK");
                    alert.setHeight(600);
                    alert.setContentText("Jarl: Go to the gate and start your adventure! I almost forget... here is your award... You add 5000 gold. \n Your bank is now " + Player.getbank() );
                    alert.getButtonTypes().setAll(ok);
                    Optional<ButtonType> new_result = alert.showAndWait();
                  
                }
                if (result3.get() == no3) {
                    alert.setHeight(600);
                    alert.setContentText("Jarl: I am here if you change your mind...");
                    ButtonType ok = new ButtonType("OK");
                    alert.getButtonTypes().setAll(ok);
                    Optional<ButtonType> new_result = alert.showAndWait();
                 
                    
                   
                }
            }
          
       
    
    
        public void Jarl6() {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
      
            alert.setHeight(600);
            alert.setContentText("Advenuture: " + Player.Getname() + "the Sum of all diobogical is defeated and now we can make Taladone what it used to be a haven of adventure and opprinity.\n I now commdend you…. The hero of Taladone: An island of adcventure. \n Here is your award...");

              
                     Player.addbank(10000);
                     you.getPlayer();
                     you.setJarl_level_count();
                     System.out.print(you.getJarl_level_count());
                    ButtonType ok = new ButtonType("OK");
                    alert.setHeight(600);
                    alert.setContentText("Main Story completed! You add 10000 gold. \n Your bank is now " + Player.getbank() );
                    alert.getButtonTypes().setAll(ok);
                    Optional<ButtonType> new_result = alert.showAndWait();
                  
               
    }
  
    
    
    public void exit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Inside_Jarls_palace.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("jarls palace");
        Stage.setScene(new Scene(root,  600, 400));

        Stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.Exit.getScene().getWindow();
        stage.close();
    }

}
