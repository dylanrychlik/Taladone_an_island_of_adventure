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
import javafx.scene.control.TextArea;
import java.util.LinkedList;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import static Davenrun.OutsidehouseController.Armoritem;
import static Davenrun.OutsidehouseController.Sidequests;
import static Davenrun.OutsidehouseController.Weaponitem;
import static Davenrun.OutsidehouseController.gooditem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Inside_good_storeController implements Initializable {

    @FXML
    private ComboBox Look;
    @FXML
    private Button button;
    @FXML
    private TextArea stats;
    String out = " ";
    static public LinkedList playergooditem = new LinkedList();
    goodItem ring = new goodItem("1", "Ring", "Taladones ancient rings of the Northen woods. Said to links back to the warriors to carves them from the depths of caves of the northen woods", 10, 30);
    goodItem apple = new goodItem("2", "Apple", "Fruit", 1, 10);
    goodItem iron = new goodItem("3", "iron", "metal", 0, 15);
    // playergooditem ring = new playergooditem("Ring", "Ring",5,0);
    goodItem necklace = new goodItem("4", "necklace", "ndcklace", 0, 10);
//    

    goodItem ruby = new goodItem("0", "ruby", "Ruby", 0, 10);
    goodItem magicpotion = new goodItem("5", " Potion", "potion", 50, 20);
    goodItem shovel = new goodItem("0", "Shovel", "Shovel", 10, 30);

    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    String intro = "Boldman’s arena: Where the Niava go to die and the rich get richer. \n If an adventure like yourself wants to makes quick gold and experience they can go in and fight evil creatures that haunt the island of Taladone. ";
    Player player;
    @FXML
    private TextArea prompt;
    @FXML
    private Button Buy_item;
    @FXML
    private Button Sell_item;
    @FXML
    private Button Hows_bussinse;
    @FXML
    private Button Exit;
    @FXML
    private TextField input;
    @FXML
    private Button button2;
    @FXML
    private Button button3;

    public Inside_good_storeController() {
        this.prompt = new TextArea();
        this.Buy_item = new Button();
        this.Sell_item = new Button();
        this.Hows_bussinse = new Button();
        this.Exit = new Button();
        this.Look = new ComboBox();
        this.button = new Button();
        this.stats = new TextArea();
        this.input = new TextField();
        this.button2 = new Button();
        this.button3 = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO   

        prompt.setPrefSize(850, 50);

        //prompt.setText(intro);
        prompt.setEditable(false);
        player.getPlayer();
        stats.setEditable(false);
        Look.getItems().addAll("Good list", "Weapon list", "Armor list");
        Look.setValue("Look");
        button.setOnAction(event -> {
            //Call a method to determine which item in the list the user has selected
            doAction(Look.getValue().toString()); //Send the selected item to the method
        });

   }

    public void buy_store_item() {

        if (playergooditem.size() == 0) {
            intionalize();

        }

        //JOptionPane.showMessageDialog(null, playergoodlist.toString());
        //promt for range of items to be deleted
        String deletePrompt;
        int x, Next;
        //Prompt for range of items to be removed

        int limit = playergooditem.size();
        for (x = 0; x < limit; x++) {

            out += (playergooditem.get(x)).toString() + "\n";
        }

        // Start = Integer.parseInt(JOptionPane.showInputDialog(null, "What position starting from zero from" + goodlist.toString() + "you would like to buy? ", HEADING, JOptionPane.ERROR_MESSAGE));
        // dialog.setContentText("Please type a number from the textarea below to buy a store item.:");
        stats.setText("Please type a number from the textarea below to buy a store item.\n What position starting from zero from you would like to buy?" + out);

    }

    //Object[] Array = gooditem.toArray();
    //result = Search(Array, start.get());
    public void sell_store_item() {

        if (gooditem.size() == 0) {
            intionalize();

        }

        //JOptionPane.showMessageDialog(null, playergoodlist.toString());
        //promt for range of items to be deleted
        String deletePrompt;
        int x, Next;
        //Prompt for range of items to be removed

        int limit = gooditem.size();
        out = " ";
        for (x = 0; x < limit; x++) {

            out += (gooditem.get(x)).toString() + "\n";
        }

        // Start = Integer.parseInt(JOptionPane.showInputDialog(null, "What position starting from zero from" + goodlist.toString() + "you would like to buy? ", HEADING, JOptionPane.ERROR_MESSAGE));
        // dialog.setContentText("Please type a number from the textarea below to buy a store item.:");
        stats.setText("Please type a number from the textarea below to buy a store item.\n What position starting from zero from you would like to sell?" + out);
    }

    //Object[] Array = gooditem.toArray();
    //result = Search(Array, start.get());
    public void doAction3() {

        try {
            player.getPlayer();
            goodItem result = new goodItem();
            result.update(gooditem.get(Integer.parseInt(input.getText())));

            String deletePrompt = "Item " + gooditem.get(Integer.parseInt(input.getText())) + "is about to be removed from the list.\n" + "Click Yes to remove items. Click No or Cancle to exit";

            System.out.println(result.gethealthrating());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(deletePrompt);
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> finalresult = alert.showAndWait();
            if (finalresult.get() == ButtonType.OK) {

                //gooditem.add(playergooditem.get(Integer.parseInt(start.get())));
                playergooditem.add(gooditem.get(Integer.parseInt(input.getText())));
                gooditem.remove(Integer.parseInt(input.getText()));
                System.out.println(result.getcost());
                
                int cost = result.getcost();
               
                player.addbank(cost);
                System.out.println("Item successfully removed.");
                System.out.println("Player list size is " + gooditem.size());
                System.out.println("Store list size is " + playergooditem.size());

                System.out.println(player.getbank());
                System.out.println(player.gethealth());
                stats.setText("Your bank is now: " + player.getbank() + "\n Your health is now: " + player.gethealth());

            } else {

                alert.close();
            }

        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Looks like there was an error going back beginning");
            //dialog.setContentText();

        }
    }

    public void stats() {

        player.getPlayer();

        String Output = "Player stats are: \n Health: " + player.gethealth() + "\n Bank:" + player.getbank() + "\n Attack damage:" + player.getattackdamage() + "\n Armor" + player.getarmor() + "\n Game level" + player.getJarl_level_count();
        stats.setText(Output);
    }

    public void intionalize() {
        playergooditem.addFirst(ruby);
        playergooditem.addLast(ring);
        playergooditem.addLast(apple);
        playergooditem.addLast(iron);
        playergooditem.addLast(necklace);

        playergooditem.addLast(magicpotion);
    }

    public void intionalize2() {
        playergooditem.add(shovel);

    }

  
    public void Hows_bussinse() throws IOException {
        if (Sidequests[6] == true){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Side quest already completed!");
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Goerge Fordland");

        alert.setContentText("Fordland: Bussiness isn’t like what it use to be. When my father owned this store, it was the biggest bussiness in Davenrun. Now the Casino and the Arena has produced so much wealth that so many people can’t buy stuff from here and most likely bet it at the casino. \n My son who never has a day off can’t even go huntng. He is too busy working. His birthday is coming up and I want to get him some venison. \n Problem is that I’m low on employees and I never have time to hunt either. \n Say if you can hunt a deer for me and get the deer back to me, I will pay you in gold. What do you say? ");

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeTwo = new ButtonType("No");
        ButtonType buttonTypeCancel = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {

           Stage Stage = new Stage();
        Stage.setTitle("The Hunt");
        Parent root = FXMLLoader.load(getClass().getResource("/Side_quests/Attack_deer.fxml"));
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
    
    public void exit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Fordlands_general_good_store.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Fordlands general good store");
   Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.prompt.getScene().getWindow();
        stage.close();
    }

    public void doAction(String listItem) {
        switch (listItem) {
            case "Good list": //Action for this item
                goodlist();
                break;
            case "Weapon list":
                weaponlist();
                break;
            case "Armor list": //Action for this item
                Armorlist();
                break;

            default: //Default action
                break;
        }
    }

    public void goodlist() {

        System.out.println(gooditem.size());
        int limit = gooditem.size();
        String out = " ";
        for (int x = 0; x < limit; x++) {

            out += ((goodItem) gooditem.get(x)).toString() + "\n";
        }
        stats.setText("Your Goods items are \n " + out);
    }

    public void weaponlist() {

        System.out.println(Weaponitem.getSize());
        int limit2 = Weaponitem.getSize();
        String out2 = " ";

        for (int x = 1; x <= limit2; x++) {

            out2 += Weaponitem.getInfo(x).toString() + "\n";
        }
        stats.setText("\n Your Weapon items are \n " + out2);
    }

    public void Armorlist() {

        System.out.println(Armoritem.getSize());
        int limit3 = Armoritem.getSize();
        String out3 = " ";
        for (int x = 1; x <= limit3; x++) {

            out3 += Armoritem.getInfo(x).toString() + "\n";
        }

        stats.setText("\n Your Armor items are in the order  by \n" + out3);
    }

    public void doAction2() {
        try {
            player.getPlayer();
            Playergooditem result = new Playergooditem();
            result.update((goodItem) playergooditem.get(Integer.parseInt(input.getText())));

            String deletePrompt = "Item " + playergooditem.get(Integer.parseInt(input.getText())) + "is about to be removed from the list.\n" + "Click Yes to remove items. Click No or Cancle to exit";

            System.out.println(result.gethealthrating());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(deletePrompt);
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> finalresult = alert.showAndWait();
            if (finalresult.get() == ButtonType.OK) {
                if (result.getcost() > player.getbank()) {

                    stats.setText("You don't have enough money in bank!");

                } else {
                    //gooditem.add(playergooditem.get(Integer.parseInt(start.get())));
                    gooditem.add((goodItem) playergooditem.get(Integer.parseInt(input.getText())));
                    playergooditem.remove(Integer.parseInt(input.getText()));
                    System.out.println(result.getcost());
                    int health = result.gethealthrating();
                    int cost = result.getcost();
                    player.addhealth(health);
                    player.subtractbank(cost);
                    System.out.println("Item successfully removed.");
                    System.out.println("Player list size is " + gooditem.size());
                    System.out.println("Store list size is " + playergooditem.size());

                    System.out.println(player.getbank());
                    System.out.println(player.gethealth());
                    stats.setText("Your bank is now: " + player.getbank() + "\n Your health is now: " + player.gethealth());

                }
            } else {

                alert.close();
            }

        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Looks like there was an error going back beginning");
            //dialog.setContentText();

        }
    }
}
