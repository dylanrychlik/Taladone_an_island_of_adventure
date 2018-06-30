/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davenrun;

import java.io.File;
import java.io.IOException;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataModel {

    
    private final ObjectProperty<Player> currentPerson = new SimpleObjectProperty<>(null);

    public ObjectProperty<Player> currentPersonProperty() {
        return currentPerson ;
    }

    public final Player getCurrentPerson() {
        return currentPersonProperty().get();
    }

    public final void setCurrentPerson(Player person) {
        currentPersonProperty().set(person);
    }

   
    //public void loadData(File file) {
        // mock...
       /* personList.setAll(
                new Player("Jacob", "Smith", "jacob.smith@example.com"),
                new Player("Isabella", "Johnson","isabella.johnson@example.com"), 
                new Player("Ethan", "Williams", "ethan.williams@example.com"), 
                new Player("Emma", "Jones", "emma.jones@example.com"), 
                new Player("Michael", "Brown", "michael.brown@example.com")
        );
    }
    */
    public void loadData(File file) throws IOException {

        // load data from file and store in personList...

    }

    public void saveData(File file) throws IOException {

        // save contents of personList to file ...
    }
}
