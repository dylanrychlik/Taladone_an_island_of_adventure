/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davenrun;

import static Davenrun.Inside_good_storeController.playergooditem;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import static Davenrun.OutsidehouseController.Armoritem;
import static Davenrun.OutsidehouseController.Weaponitem;
import static Davenrun.OutsidehouseController.gooditem;
import static java.util.Collections.list;
import java.util.Iterator;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class InsidearmoryController implements Initializable {

    @FXML
    private ComboBox Look;
    @FXML
    private Button button;
    @FXML
    private Label Storeactions;
    @FXML
    private Label Interactions;
    @FXML
    private ComboBox<Weapon> buy_weapon;
    @FXML
    private Button buy_weapon_submit;
    @FXML
    private ComboBox<Weapon> sell_weapon;
    @FXML
    private Button sell_weapon_submit;
    @FXML
    private TextArea stats;
    Player player;
    String out = " ";
    @FXML
    private TextArea prompt;
    @FXML
    private ComboBox<Armor> buy_armor;
    @FXML
    private Button buy_armor_submit;
    @FXML
    private ComboBox<Armor> sell_armor;
    @FXML
    private Button sell_armor_submit;
    @FXML
    private Button Hows_bussinse;
    @FXML
    private Button John_wariron;
    @FXML
    private Button Legendary_john_war_iron;
    @FXML
    private Button Exit;

    static public LinkedList storeweaponitem = new LinkedList();

    static public LinkedList storearmoritem = new LinkedList();
    Weapon weapon;
    Armor armor;
    Taladone_an_island_of_adventure you = new Taladone_an_island_of_adventure();
    Weapon sword = new Weapon("0", "sword", "sword", 120, 30);
    Weapon sword2 = new Weapon("1", "sword", "sword", 125, 30);
    Weapon sword3 = new Weapon("2", "sword", "sword", 130, 30);
    Weapon sword4 = new Weapon("3", "sword", "sword", 135, 30);
    Weapon sword5 = new Weapon("4", "sword", "sword", 140, 30);

    Weapon ax = new Weapon("5", "ake", "ake", 100, 30);

    Armor plate = new Armor("0", "armor", "armor", 100, 30);
    Armor plate2 = new Armor("1", "armor", "armor", 100, 30);
    Armor plate3 = new Armor("2", "armor", "armor", 100, 30);
    Armor plate4 = new Armor("3", "armor", "armor", 100, 30);
    Armor plate5 = new Armor("4", "armor", "armor", 100, 30);
    Armor shield = new Armor("5", "Armor", "Sheild", 100, 30);

    public InsidearmoryController() {
        this.prompt = new TextArea();
        this.buy_weapon = new ComboBox();
        this.buy_weapon_submit = new Button();
        this.sell_weapon = new ComboBox();
        this.sell_weapon_submit = new Button();
        this.buy_armor = new ComboBox();
        this.buy_armor_submit = new Button();
        this.sell_armor = new ComboBox();
        this.sell_armor_submit = new Button();
        this.Hows_bussinse = new Button();
        this.John_wariron = new Button();
        this.Legendary_john_war_iron = new Button();
        this.Storeactions = new Label();
        this.Interactions = new Label();
        this.Look = new ComboBox();
        this.button = new Button();
        this.stats = new TextArea();
        this.Exit = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (storeweaponitem.isEmpty()) {
            intionalize();

        } else {
            buy_weapon.getItems().addAll(storeweaponitem);
        }
        if (storearmoritem.isEmpty()) {
            intionalize3();

        } else {
            buy_armor.getItems().addAll(storearmoritem);
        }
        int limit2 = Weaponitem.getSize();
        for (int x = 1; x <= limit2; x++) {

            sell_weapon.getItems().addAll(Weaponitem.getInfo(x));
        }
        limit2 = Armoritem.getSize();
        for (int x = 1; x <= limit2; x++) {

            sell_armor.getItems().addAll(Armoritem.getInfo(x));
        }

        buy_weapon.setPromptText("Select weapon to buy");
        sell_weapon.setPromptText("Select weapon to sell");
        buy_armor.setPromptText("Select armor to buy");
        sell_armor.setPromptText("Select armor to sell");

        try {
            buy_weapon.setOnAction(e -> {

                SelectWeapontoBuy(buy_weapon.getValue().toString());
            });
            sell_weapon.setOnAction(e -> {

                SelectWeapontoSell(sell_weapon.getValue().toString());
            });
            buy_armor.setOnAction(e -> {
                SelectArmortoBuy(buy_armor.getValue().toString());
            });
            sell_armor.setOnAction(e -> {
                SelectArmortoSell(sell_armor.getValue().toString());
            });
        } catch (java.lang.NullPointerException ex) {
            System.out.println("NullPointerException thrown!");
        } catch (Exception ex) {
            System.out.println("Exception thrown!");
        }

        prompt.setPrefHeight(20);
        prompt.setPrefWidth(800);
        stats.setPrefWidth(800);
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

    public void SelectWeapontoBuy(String value) {
        try {
            //String ID = buy_weapon.getValue().getID();
            weapon = new Weapon(buy_weapon.getValue().getID(), buy_weapon.getValue().getdescription(), buy_weapon.getValue().getname(), buy_weapon.getValue().gethealthrating(), buy_weapon.getValue().getcost());
            stats.setText("The following Weapon Item is selected: \n " + weapon.toString() + "\n \n Select the ''Buy Weapon'' button to buy it.");
            System.out.println(buy_weapon.getValue().getcost());
            value = weapon.toString();
            Weapon test = null;
            buy_weapon.setValue(test);
            buy_weapon.setPromptText("Select weapon to buy");
        } catch (java.lang.NullPointerException ex) {
            System.out.println("NullPointerException thrown!");
        } catch (Exception ex) {
            buy_weapon.setPromptText("Select weapon to buy");
            System.out.println("Exception thrown!");
        }
    }

    @FXML
    public void SelectWeapontoSell(String value) {
        try {
            //String ID = buy_weapon.getValue().getID();
            weapon = new Weapon(sell_weapon.getValue().getID(), sell_weapon.getValue().getdescription(), sell_weapon.getValue().getname(), sell_weapon.getValue().gethealthrating(), sell_weapon.getValue().getcost());
            stats.setText("The following Weapon Item is selected: \n " + weapon.toString() + "\n \n Select the ''Sell Weapon'' button to sell it.");
            System.out.println(sell_weapon.getValue().getcost());
            value = weapon.toString();
            Weapon test = null;
            sell_weapon.setValue(test);
            sell_weapon.setPromptText("Select weapon to sell");
        } catch (java.lang.NullPointerException ex) {
            System.out.println("NullPointerException thrown!");
        } catch (Exception ex) {
            sell_weapon.setPromptText("Select weapon to buy");
            System.out.println("Exception thrown!");
        }
    }

    public void SelectArmortoBuy(String value) {
        try {
            //String ID = buy_weapon.getValue().getID();
            armor = new Armor(buy_armor.getValue().getID(), buy_armor.getValue().getdescription(), buy_armor.getValue().getname(), buy_armor.getValue().gethealthrating(), buy_armor.getValue().getcost());
            stats.setText("The following Armor Item is selected: \n " + armor.toString() + "\n \n Select the ''Buy Armor'' button to buy it.");
            System.out.println(buy_armor.getValue().getcost());
            value = armor.toString();
            Armor test = null;
            buy_armor.setValue(test);
            buy_armor.setPromptText("Select armor to buy");
        } catch (java.lang.NullPointerException ex) {
            System.out.println("NullPointerException thrown!");
        } catch (Exception ex) {
            buy_armor.setPromptText("Select armor to buy");
            System.out.println("Exception thrown!");
        }
    }

    @FXML
    public void SelectArmortoSell(String value) {
        try {
            //String ID = buy_weapon.getValue().getID();
            armor = new Armor(sell_armor.getValue().getID(), sell_armor.getValue().getdescription(), sell_armor.getValue().getname(), sell_armor.getValue().gethealthrating(), sell_armor.getValue().getcost());
            stats.setText("The following Weapon Item is selected: \n " + armor.toString() + "\n \n Select the ''Sell Armor'' button to sell it.");
            System.out.println(sell_armor.getValue().getcost());
            value = armor.toString();
            Armor test = null;
            sell_armor.setValue(test);
            sell_armor.setPromptText("Select armor to sell");
        } catch (java.lang.NullPointerException ex) {
            System.out.println("NullPointerException thrown!");
        } catch (Exception ex) {
            sell_armor.setPromptText("Select armor to sell");
            System.out.println("Exception thrown!");
        }
    }

    public void BuyWeapon() {

        if (weapon.getcost() > Player.getbank()) {
            System.out.println("You dont have enough funds!");
            stats.setText("You don't have enough funds!");
        } else {

            String rec1 = weapon.getID();
            storeweaponitem.remove(weapon.toString());

            for (Iterator<Weapon> iter = storeweaponitem.iterator(); iter.hasNext();) {
                Weapon data = iter.next();
                if (data.getID() == rec1) {
                    iter.remove();
                }
            }
            System.out.println(storeweaponitem.size());
            buy_weapon.getItems().clear();
            buy_weapon.getItems().addAll(storeweaponitem);

            sell_weapon.getItems().add(weapon);

            Weaponitem.addFirst(weapon);
            Player.addattackdamage(weapon.gethealthrating());
            Player.subtractbank(weapon.getcost());
            stats.setText(weapon.toString() + " \n Added to your inventory");

        }
    }

    public void SellWeapon() {

        String rec1 = weapon.getID();
        System.out.println(rec1);

        Weaponitem.removeMiddle(Integer.parseInt(weapon.getID()));

        System.out.println(storeweaponitem.size());

        sell_weapon.getItems().clear();

        int limit2 = Weaponitem.getSize();
        for (int x = 1; x <= limit2; x++) {
            sell_weapon.getItems().addAll(Weaponitem.getInfo(x));
        }
        buy_weapon.getItems().add(weapon);
        storeweaponitem.addFirst(weapon);
        Player.addbank(weapon.getcost());
        stats.setText(weapon.toString() + " \n removed to your inventory");

    }

    public void BuyArmor() {

        if (armor.getcost() > Player.getbank()) {
            System.out.println("You dont have enough funds!");
            stats.setText("You don't have enough funds!");
        } else {

            String rec1 = armor.getID();
            storearmoritem.remove(armor.toString());

            for (Iterator<Armor> iter = storearmoritem.iterator(); iter.hasNext();) {
                Armor data = iter.next();
                if (data.getID() == rec1) {
                    iter.remove();
                }
            }
            System.out.println(storearmoritem.size());
            buy_armor.getItems().clear();
            buy_armor.getItems().addAll(storearmoritem);

            sell_armor.getItems().add(armor);

            Armoritem.addFirst(armor);
            Player.addactarmor(armor.gethealthrating());
            Player.subtractbank(armor.getcost());
            stats.setText(armor.toString() + " \n Added to your inventory");

        }
    }

    public void SellArmor() {

        String rec1 = armor.getID();
        System.out.println(rec1);

        Armoritem.removeMiddle(Integer.parseInt(armor.getID()));

        System.out.println(storearmoritem.size());

        sell_armor.getItems().clear();

        int limit2 = Armoritem.getSize();
        for (int x = 1; x <= limit2; x++) {
            sell_armor.getItems().addAll(Armoritem.getInfo(x));
        }
        buy_armor.getItems().add(armor);
        storearmoritem.addFirst(armor);
        Player.addbank(armor.getcost());
        stats.setText(armor.toString() + " \n removed to your inventory");

    }

    public void stats() {

        player.getPlayer();

        String Output = "Player stats are: \n Health: " + player.gethealth() + "\n Bank:" + player.getbank() + "\n Attack damage:" + player.getattackdamage() + "\n Armor" + player.getarmor() + "\n Game level" + player.getJarl_level_count();
        stats.setText(Output);
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

    
    

    /* public void doAction2() {

        player.getPlayer();
        Weapon result = new Weapon();
        result.update((Weapon) playerweaponitem.get(Integer.parseInt(input.getText())));

        String deletePrompt = "Item " + playerweaponitem.get(Integer.parseInt(input.getText())) + "is about to be removed from the list.\n" + "Click Yes to remove items. Click No or Cancle to exit";

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
                Weaponitem.addFirst((Weapon) playerweaponitem.get(Integer.parseInt(input.getText())));
                playerweaponitem.remove(Integer.parseInt(input.getText()));
                System.out.println(result.getcost());
                int attackdamage = result.gethealthrating();
                int cost = result.getcost();
                player.setattackdamage(attackdamage);
                player.subtractbank(cost);
                System.out.println("Item successfully removed.");
                System.out.println("Player list size is " + Weaponitem.getSize());
                System.out.println("Store list size is " + playerweaponitem.size());

                System.out.println(player.getbank());
                System.out.println(player.getattackdamage());
                stats.setText("Your bank is now: " + player.getbank() + "\n Your attack damage is now: " + player.getattackdamage());

            }
        } else {

            alert.close();
        }

    }

    public void doAction3() {

        try {
            player.getPlayer();
            Weapon result = new Weapon();
            result.update(Weaponitem.getInfo(Integer.parseInt(input.getText())));

            String deletePrompt = "Item " + Weaponitem.getInfo(Integer.parseInt(input.getText())) + "is about to be removed from the list.\n" + "Click Yes to remove items. Click No or Cancle to exit";

            System.out.println(result.gethealthrating());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(deletePrompt);
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> finalresult = alert.showAndWait();
            if (finalresult.get() == ButtonType.OK) {

                //gooditem.add(playergooditem.get(Integer.parseInt(start.get())));
                playerweaponitem.add(Weaponitem.getInfo(Integer.parseInt(input.getText())));
                Weaponitem.removeMiddle(Integer.parseInt(input.getText()));
                System.out.println(result.getcost());

                int cost = result.getcost();

                player.addbank(cost);
                System.out.println("Item successfully removed.");
                System.out.println("Player list size is " + Weaponitem.getSize());
                System.out.println("Store list size is " + playerweaponitem.size());

                System.out.println(player.getbank());
                System.out.println(player.gethealth());
                stats.setText("Your bank is now: " + player.getbank() + "\n Your attack damage is now: " + player.getattackdamage());

            } else {

                alert.close();
            }

        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Looks like there was an error going back beginning");
            //dialog.setContentText();

        }
    }

    public void doAction4() {

        try {
            player.getPlayer();
            Armor result = new Armor();
            result.update(Armoritem.getInfo(Integer.parseInt(input.getText())));

            String deletePrompt = "Item " + Armoritem.getInfo(Integer.parseInt(input.getText())) + "is about to be removed from the list.\n" + "Click Yes to remove items. Click No or Cancle to exit";

            System.out.println(result.gethealthrating());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(deletePrompt);
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> finalresult = alert.showAndWait();
            if (finalresult.get() == ButtonType.OK) {

                //gooditem.add(playergooditem.get(Integer.parseInt(start.get())));
                playerarmoritem.add(Armoritem.getInfo(Integer.parseInt(input.getText())));
                Armoritem.removeMiddle(Integer.parseInt(input.getText()));
                System.out.println(result.getcost());

                int cost = result.getcost();

                player.addbank(cost);
                System.out.println("Item successfully removed.");
                System.out.println("Player list size is " + Weaponitem.getSize());
                System.out.println("Store list size is " + playerweaponitem.size());

                System.out.println(player.getbank());
                System.out.println(player.gethealth());
                stats.setText("Your bank is now: " + player.getbank() + "\n Your attack damage is now: " + player.getattackdamage());

            } else {

                alert.close();
            }

        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Looks like there was an error going back beginning");
            //dialog.setContentText();

        }
    }

    public void doAction5() {

        try {
            player.getPlayer();
            Armor result = new Armor();
            result.update((Armor) playerarmoritem.get(Integer.parseInt(input.getText())));

            String deletePrompt = "Item " + playerarmoritem.get(Integer.parseInt(input.getText())) + "is about to be removed from the list.\n" + "Click Yes to remove items. Click No or Cancle to exit";

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
                    Armoritem.addFirst((Armor) playerarmoritem.get(Integer.parseInt(input.getText())));
                    playerarmoritem.remove(Integer.parseInt(input.getText()));
                    System.out.println(result.getcost());
                    int attackdamage = result.gethealthrating();
                    int cost = result.getcost();
                    player.setattackdamage(attackdamage);
                    player.subtractbank(cost);
                    System.out.println("Item successfully removed.");
                    System.out.println("Player list size is " + Armoritem.getSize());
                    System.out.println("Store list size is " + playerarmoritem.size());

                    System.out.println(player.getbank());
                    System.out.println(player.getarmor());
                    stats.setText("Your bank is now: " + player.getbank() + "\n Your armor is now: " + player.getarmor());

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
     */
    public void sell_armor() {
        if (Armoritem.getSize() == 0) {
            stats.setText("You have no armor to sell!");

        }

        //JOptionPane.showMessageDialog(null, playergoodlist.toString());
        //promt for range of items to be deleted
        String deletePrompt;
        int x, Next;
        //Prompt for range of items to be removed

        int limit = Armoritem.getSize();
        out = " ";
        for (x = 0; x < limit; x++) {

            out += ((Armor) Armoritem.getInfo(x)).toString() + "\n";
        }

        // Start = Integer.parseInt(JOptionPane.showInputDialog(null, "What position starting from zero from" + goodlist.toString() + "you would like to buy? ", HEADING, JOptionPane.ERROR_MESSAGE));
        // dialog.setContentText("Please type a number from the textarea below to buy a store item.:");
        stats.setText("Please type a number from the textarea below to buy a store item.\n What position starting from zero from you would like to buy?" + out);

    }

    public void intionalize() {
        storeweaponitem.add(sword);

        storeweaponitem.add(sword2);
        storeweaponitem.add(sword3);
        storeweaponitem.add(sword4);
        storeweaponitem.add(sword5);

        buy_weapon.getItems().addAll(storeweaponitem);

    }

    public void intionalize2() {
        storeweaponitem.add(ax);

    }

    public void intionalize3() {
        storearmoritem.add(plate);
        storearmoritem.add(plate2);
        storearmoritem.add(plate3);
        storearmoritem.add(plate4);
        storearmoritem.add(plate5);
        buy_armor.getItems().addAll(storearmoritem);

    }

    public void intionalize4() {
        storearmoritem.add(shield);
    }

    public void Hows_bussinse() {
        String out = " John Wariron: Oh the glory days. I miss them when. When taladone "
                + "was an island of adventure. This was a thriving store and I made a fourtune. Unfourtaly people started getting killed by other people and instead of fighting we all became scared little bitches, and put weapon restriction laws. Now Taladone is packed with evil and harted. Coincidence? I think not! ";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(out);
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void john_war_iron() {
        String out = " That name was used by my father, and my father's fathers and his father before him, who fought in the battle of Hastings.... so I suggest you watch your loose little mouth before you insult my family!";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(out);
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void john_War_iron_legend() {
        String out = "Aye, I am. Before I came to Davenrun, I was a pirate in the Irish Sea. Some creature killed our crew and I swam for 50 miles till I came to Taladone. \n I came to Davenrun and open the Armory during the great Taladone war and became a household name. I sold wepons to both side of the war, some may call it greedy, I call it using your resources. \n After the war, I met my wife and had my Daughter Emily War Iron. I owned this store for over 35 years. While it may not be the Areana or the Casino, it puts a roof over my head and food on the table. And thats all I can ask for.";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(out);
        ButtonType ok = new ButtonType("OK");
        alert.getButtonTypes().setAll(ok);
        alert.showAndWait();
    }

    public void exit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Davenrun/Armory.fxml"));
        Stage Stage = new Stage();
        Stage.setTitle("Armory");
        Stage.setScene(new Scene(root, 1000, 750));
        Stage.show();
        closeWindow();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) this.prompt.getScene().getWindow();
        stage.close();
    }

}
