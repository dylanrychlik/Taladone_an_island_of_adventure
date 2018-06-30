package DavenrunCrabs;

import java.io.IOException;
import java.lang.Thread;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static jfxcraps.JFXCraps.VERSION;
public class Crabs extends Thread{
    public void Crabs() throws IOException {
       
   Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/DavenrunCrabs/CrapsFXML.fxml"));
        Scene scene = new Scene(root, 1250, 800);
        stage.setResizable(false);
        stage.setTitle("Jay Craps ~ " + VERSION);
        stage.setScene(scene);
        stage.show();
        
      
    }
}


