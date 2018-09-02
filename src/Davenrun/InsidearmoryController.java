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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
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
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private TextArea stats;
    Player player;
    String out = " ";
    @FXML
    private TextArea prompt;
    @FXML
    private Button Buy_weapon;
    @FXML
    private Button Sell_weapon;
    @FXML
    private Button Buy_armor;
    @FXML
    private Button sell_armor;
    @FXML
    private Button Hows_bussinse;
    @FXML
    private Button John_wariron;
    @FXML
    private Button Legendary_john_war_iron;
    @FXML
    private TextField input;
    @FXML
    private Button Exit;

    static public LinkedList playerweaponitem = new LinkedList();

    static public LinkedList playerarmoritem = new LinkedList();
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
        this.Buy_weapon = new Button();
        this.Sell_weapon = new Button();
        this.Buy_armor = new Button();
        this.sell_armor = new Button();
        this.Hows_bussinse = new Button();
        this.John_wariron = new Button();
        this.Legendary_john_war_iron = new Button();
        this.input = new TextField();
        this.Look = new ComboBox();
        this.button = new Button();
        this.button2 = new Button();
        this.button3 = new Button();
        this.button4 = new Button();
        this.button5 = new Button();

        this.stats = new TextArea();
        this.Exit = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prompt.setPrefSize(850, 50);

        //prompt.setText(intro);
        prompt.setEditable(false);
        player.getPlayer();
        stats.setEditable(false);
        Look.getItems().addAll("Good list", "Weapon list", "Armor list");
        Look.setValue("Look");
        button5.setOnAction(event -> {
            //Call a method to determine which item in the list the user has selected
            doAction(Look.getValue().toString()); //Send the selected item to the method
        });
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

    public void buy_weapon() {
        if (playerweaponitem.size() == 0) {
            intionalize();

        }

        //JOptionPane.showMessageDialog(null, playergoodlist.toString());
        //promt for range of items to be deleted
        String deletePrompt;
        int x, Next;
        //Prompt for range of items to be removed
        out = " ";
        int limit = playerweaponitem.size();
        for (x = 0; x < limit; x++) {

            out += ((Weapon) playerweaponitem.get(x)).toString() + "\n";
        }

        // Start = Integer.parseInt(JOptionPane.showInputDialog(null, "What position starting from zero from" + goodlist.toString() + "you would like to buy? ", HEADING, JOptionPane.ERROR_MESSAGE));
        // dialog.setContentText("Please type a number from the textarea below to buy a store item.:");
        stats.setText("Please type a number from the textarea below to buy a store item.\n What position starting from zero from you would like to buy?" + out);
    }

    public void buy_armor() {
        if (playerarmoritem.size() == 0) {
            intionalize3();

        }

        //JOptionPane.showMessageDialog(null, playergoodlist.toString());
        //promt for range of items to be deleted
        String deletePrompt;
        int x, Next;
        //Prompt for range of items to be removed

        int limit = playerarmoritem.size();
        out = " ";
        for (x = 0; x < limit; x++) {

            out += ((Armor) playerarmoritem.get(x)).toString() + "\n";
        }

        // Start = Integer.parseInt(JOptionPane.showInputDialog(null, "What position starting from zero from" + goodlist.toString() + "you would like to buy? ", HEADING, JOptionPane.ERROR_MESSAGE));
        // dialog.setContentText("Please type a number from the textarea below to buy a store item.:");
        stats.setText("Please type a number from the textarea below to buy an armor item.\n What position starting from zero from you would like to buy?" + out);
    }

    public void sell_weapons() {
        if (Weaponitem.getSize() == 0) {
            stats.setText("You have no weapons to sell!");

        }

        //JOptionPane.showMessageDialog(null, playergoodlist.toString());
        //promt for range of items to be deleted
        String deletePrompt;
        int x, Next;
        //Prompt for range of items to be removed

        int limit = Weaponitem.getSize();
        out = " ";
        for (x = 1; x <= limit; x++) {

            out += ((Weapon) Weaponitem.getInfo(x)).toString() + "\n";
        }

        // Start = Integer.parseInt(JOptionPane.showInputDialog(null, "What position starting from zero from" + goodlist.toString() + "you would like to buy? ", HEADING, JOptionPane.ERROR_MESSAGE));
        // dialog.setContentText("Please type a number from the textarea below to buy a store item.:");
        stats.setText("Please type a number from the textarea below to buy a store item.\n What position starting from zero from you would like to sell?" + out);
    }

    public void doAction2() {

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
        playerweaponitem.add(sword);

        playerweaponitem.add(sword2);
        playerweaponitem.add(sword3);
        playerweaponitem.add(sword4);
        playerweaponitem.add(sword5);

    }

    public void intionalize2() {
        playerweaponitem.add(ax);

    }

    public void intionalize3() {
        playerarmoritem.add(plate);
        playerarmoritem.add(plate2);
        playerarmoritem.add(plate3);
        playerarmoritem.add(plate4);
        playerarmoritem.add(plate5);

    }

    public void intionalize4() {
        playerarmoritem.add(shield);
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
