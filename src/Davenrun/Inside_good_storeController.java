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
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Inside_good_storeController implements Initializable {
    
    @FXML
    private ComboBox Look;
    @FXML
    private Label Storeactions;
    @FXML
    private Label Interactions;
    @FXML
    private ComboBox<goodItem> buy_gooditem;
    @FXML
    private Button buy_gooditem_submit;
    @FXML
    private ComboBox<goodItem> sell_gooditem;
    @FXML
    private Button sell_gooditem_submit;
    @FXML
    private Button button;
    @FXML
    private Button Player_stats;
    @FXML
    private TextArea stats;
    goodItem item;
    String out = " ";
    static public LinkedList storegooditem = new LinkedList();
    
    goodItem ring = new goodItem("1", "Ring", "Taladones ancient rings of the Northen woods.", 10, 30);
    goodItem apple = new goodItem("2", "Apple", "Fruit", 1, 10);
    goodItem iron = new goodItem("3", "iron", "metal", 0, 15);
    // playergooditem ring = new playergooditem("Ring", "Ring",5,0);
    goodItem necklace = new goodItem("4", "necklace", "ndcklace", 0, 10);
//    

    goodItem ruby = new goodItem("0", "ruby", "Ruby", 0, 10);
    goodItem magicpotion = new goodItem("5", " Potion", "potion", 50, 20);
    goodItem shovel = new goodItem("0", "Shovel", "Shovel", 10, 30);
    
    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    String intro = "Goerge Fordland: Hello and welcome to Fordlands general good store! Feel free to look around and if you need anything, don't hesatate to let me know!";
    Player player;
    @FXML
    private TextArea prompt;
    @FXML
    private Button Hows_bussinse;
    @FXML
    private Button Exit;
    @FXML
    private TextField input;
    
    public Inside_good_storeController() {
        this.prompt = new TextArea();
        this.Storeactions = new Label();
        this.Interactions = new Label();
        this.Hows_bussinse = new Button();
        this.Exit = new Button();
        this.Look = new ComboBox();
        this.button = new Button();
        this.Player_stats = new Button();
        this.buy_gooditem = new ComboBox();
        this.buy_gooditem_submit = new Button();
        this.sell_gooditem = new ComboBox();
        this.sell_gooditem_submit = new Button();
        this.stats = new TextArea();
        this.input = new TextField();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO   
        buy_gooditem.setPrefWidth(150);
        sell_gooditem.setPrefWidth(150);
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
        if (storegooditem.isEmpty()) {
            intionalize();
            
        } else {
            buy_gooditem.getItems().addAll(storegooditem);
        }
        int limit = gooditem.size();
        
        sell_gooditem.getItems().addAll(gooditem);
        
        limit = Armoritem.getSize();
        buy_gooditem.setPromptText("Select item to buy");
        sell_gooditem.setPromptText("Select item to sell");
        try {
            buy_gooditem.setOnAction(e -> {
                
                SelectItemtoBuy(buy_gooditem.getValue().toString());
            });
            sell_gooditem.setOnAction(e -> {
                
                SelectItemtoSell(sell_gooditem.getValue().toString());
            });
        } catch (java.lang.NullPointerException ex) {
            System.out.println("NullPointerException thrown!");
        } catch (Exception ex) {
            System.out.println("Exception thrown!");
        }
        
    }
    
    public void SelectItemtoBuy(String value) {
        try {
            //String ID = buy_weapon.getValue().getID();
            item = new goodItem(buy_gooditem.getValue().getID(), buy_gooditem.getValue().getdescription(), buy_gooditem.getValue().getname(), buy_gooditem.getValue().gethealthrating(), buy_gooditem.getValue().getcost());
            stats.setText("The following Good Item is selected: \n " + item.toString() + "\n \n Select the ''Buy item'' button to buy it.");
            System.out.println(buy_gooditem.getValue().getcost());
            value = item.toString();
            goodItem test = null;
            buy_gooditem.setValue(test);
            buy_gooditem.setPromptText("Select Good item to buy");
        } catch (java.lang.NullPointerException ex) {
            System.out.println("NullPointerException thrown!");
        } catch (Exception ex) {
            buy_gooditem.setPromptText("Select weapon to buy");
            System.out.println("Exception thrown!");
        }
    }
    
    @FXML
    public void SelectItemtoSell(String value) {
        try {
            //String ID = buy_weapon.getValue().getID();
            item = new goodItem(sell_gooditem.getValue().getID(), sell_gooditem.getValue().getdescription(), sell_gooditem.getValue().getname(), sell_gooditem.getValue().gethealthrating(), sell_gooditem.getValue().getcost());
            stats.setText("The following Good Item is selected: \n " + item.toString() + "\n \n Select the ''Sell Item'' button to sell it.");
            System.out.println(sell_gooditem.getValue().getcost());
            value = item.toString();
            goodItem test = null;
            sell_gooditem.setValue(test);
            sell_gooditem.setPromptText("Select item to sell");
        } catch (java.lang.NullPointerException ex) {
            System.out.println("NullPointerException thrown!");
        } catch (Exception ex) {
            sell_gooditem.setPromptText("Select weapon to buy");
            System.out.println("Exception thrown!");
        }
    }
    
    public void BuyItem() {
        
        if (item.getcost() > Player.getbank()) {
            System.out.println("You dont have enough funds!");
            stats.setText("You don't have enough funds!");
        } else {
            
            String rec1 = item.getID();
            storegooditem.remove(item.toString());
            
            for (Iterator<goodItem> iter = storegooditem.iterator(); iter.hasNext();) {
                goodItem data = iter.next();
                if (data.getID() == rec1) {
                    iter.remove();
                }
            }
            System.out.println(storegooditem.size());
            buy_gooditem.getItems().clear();
            buy_gooditem.getItems().addAll(storegooditem);
            
            sell_gooditem.getItems().add(item);
            
            gooditem.addFirst(item);
            Player.addhealth(item.gethealthrating());
            Player.subtractbank(item.getcost());
            stats.setText(item.toString() + " \n Added to your inventory");
            
        }
    }
    
    public void SellItem() {
        
        String rec1 = item.getID();
        System.out.println(rec1);
        
        gooditem.remove(Integer.parseInt(item.getID()));
        
        System.out.println(gooditem.size());
        
        sell_gooditem.getItems().clear();
        
        int limit2 = Weaponitem.getSize();
        
        sell_gooditem.getItems().addAll(gooditem);
        
        buy_gooditem.getItems().add(item);
        storegooditem.addFirst(item);
        Player.addbank(item.getcost());
        stats.setText(item.toString() + " \n removed to your inventory");
        
    }
    
    public void stats() {
        
        player.getPlayer();
        
        String Output = "Player stats are: \n Health: " + player.gethealth() + "\n Bank:" + player.getbank() + "\n Attack damage:" + player.getattackdamage() + "\n Armor" + player.getarmor() + "\n Game level" + player.getJarl_level_count();
        stats.setText(Output);
    }
    
    public void intionalize() {
        storegooditem.addFirst(ruby);
        storegooditem.addLast(ring);
        storegooditem.addLast(apple);
        storegooditem.addLast(iron);
        storegooditem.addLast(necklace);
        
        storegooditem.addLast(magicpotion);
        buy_gooditem.getItems().addAll(storegooditem);
    }
    
    public void Hows_bussinse() throws IOException {
        if (Sidequests[6] == true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Side quest already completed!");
            ButtonType ok = new ButtonType("OK");
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
        } else {
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
}
