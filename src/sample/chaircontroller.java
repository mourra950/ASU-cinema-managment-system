package sample;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.mail.MessagingException;

public class chaircontroller {

    public DatePicker datep;
    public Text dateL;
    String[] M = new String[2];
    String[] L = new String[20];


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox check1;

    @FXML
    private CheckBox check2;

    @FXML
    private CheckBox check3;

    @FXML
    private CheckBox check4;

    @FXML
    private CheckBox check5;

    @FXML
    private CheckBox check6;

    @FXML
    private CheckBox check7;

    @FXML
    private CheckBox check8;

    @FXML
    private CheckBox check9;

    @FXML
    private CheckBox check10;

    @FXML
    private ChoiceBox<String> TimeSLot;

    @FXML
    private ChoiceBox<String> Payment;

    @FXML
    private ChoiceBox<String> Movie;

    @FXML
    void refresh() {
        try {
            if (datep.getValue() != null) {
                if (Movie.getValue() != null) {
                    if (TimeSLot.getValue() != null) {


                            this.check1.setDisable(false);
                            this.check2.setDisable(false);
                            this.check3.setDisable(false);
                            this.check4.setDisable(false);
                            this.check5.setDisable(false);
                            this.check6.setDisable(false);
                            this.check7.setDisable(false);
                            this.check8.setDisable(false);
                            this.check9.setDisable(false);
                            this.check10.setDisable(false);
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from reservation where day='" + datep.getValue() + "' && movie='" + Movie.getValue() + "' && timeslot='" + TimeSLot.getValue() + "'");
                        System.out.println(datep.getValue());
                        while (rs.next()) {
                            if (rs.getString(1).equals("1") && rs.getString(6).equals("true")) {
                                this.check1.setDisable(true);
                            }
                            if (rs.getString(1).equals("2") && rs.getString(6).equals("true")) {
                                this.check2.setDisable(true);
                            }
                            if (rs.getString(1).equals("3") && rs.getString(6).equals("true")) {
                                this.check3.setDisable(true);
                            }
                            if (rs.getString(1).equals("4") && rs.getString(6).equals("true")) {
                                this.check4.setDisable(true);
                            }
                            if (rs.getString(1).equals("5") && rs.getString(6).equals("true")) {
                                this.check5.setDisable(true);
                            }
                            if (rs.getString(1).equals("6") && rs.getString(6).equals("true")) {
                                this.check6.setDisable(true);
                            }
                            if (rs.getString(1).equals("7") && rs.getString(6).equals("true")) {
                                this.check7.setDisable(true);
                            }
                            if (rs.getString(1).equals("8") && rs.getString(6).equals("true")) {
                                this.check8.setDisable(true);
                            }
                            if (rs.getString(1).equals("9") && rs.getString(6).equals("true")) {
                                this.check9.setDisable(true);
                            }
                            if (rs.getString(1).equals("10") && rs.getString(6).equals("true")) {
                                this.check10.setDisable(true);
                            }
                        }
                        con.close();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (int i = 0; i < 2; i++)
            if (M[i].equals(Movie.getValue()))
                dateL.setText(L[i]);

    }



    @FXML
    void initialize() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from movie");
            int i = 0;
            while (rs.next()) {
                M[i] = rs.getString(1);
                L[i] = rs.getString(6);
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);}
            for (int i = 0; i < 2; i++) {
                if (M[i].equals(Movie.getValue()))
                    dateL.setText(String.valueOf(L[i]));

            }
        this.check1.setDisable(true);
        this.check2.setDisable(true);
        this.check3.setDisable(true);
        this.check4.setDisable(true);
        this.check5.setDisable(true);
        this.check6.setDisable(true);
        this.check7.setDisable(true);
        this.check8.setDisable(true);
        this.check9.setDisable(true);
        this.check10.setDisable(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from movie");
            int i = 0;
            while (rs.next()) {

                M[i] = rs.getString(5);
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        assert check1 != null : "fx:id=\"check1\" was not injected: check your FXML file 'chairs.fxml'.";
        assert check2 != null : "fx:id=\"check2\" was not injected: check your FXML file 'chairs.fxml'.";
        assert check3 != null : "fx:id=\"check3\" was not injected: check your FXML file 'chairs.fxml'.";
        assert check4 != null : "fx:id=\"check4\" was not injected: check your FXML file 'chairs.fxml'.";
        assert check5 != null : "fx:id=\"check5\" was not injected: check your FXML file 'chairs.fxml'.";
        assert check6 != null : "fx:id=\"check6\" was not injected: check your FXML file 'chairs.fxml'.";
        assert check7 != null : "fx:id=\"check7\" was not injected: check your FXML file 'chairs.fxml'.";
        assert check8 != null : "fx:id=\"check8\" was not injected: check your FXML file 'chairs.fxml'.";
        assert check9 != null : "fx:id=\"check9\" was not injected: check your FXML file 'chairs.fxml'.";
        assert check10 != null : "fx:id=\"check10\" was not injected: check your FXML file 'chairs.fxml'.";
        TimeSLot.setItems(FXCollections.observableArrayList(" 9 AM ", " 3 PM ", " 7 PM"));
        Payment.setItems(FXCollections.observableArrayList("Visa", "Cash"));
        Movie.setItems(FXCollections.observableArrayList(M));
        datep.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                System.out.println(today);
                System.out.println(date);

                setDisable(empty || date.compareTo(today) < 0);
            }
        });

    }

    public void reserve(ActionEvent event) throws MessagingException {
        boolean C1 = check1.isSelected();
        boolean C2 = check2.isSelected();
        boolean C3 = check3.isSelected();
        boolean C4 = check4.isSelected();
        boolean C5 = check5.isSelected();
        boolean C6 = check6.isSelected();
        boolean C7 = check7.isSelected();
        boolean C8 = check8.isSelected();
        boolean C9 = check9.isSelected();
        boolean C10 = check10.isSelected();
        boolean[] c = {C1, C2, C3, C4, C5, C6, C7, C8, C9, C10};
        if (TimeSLot.getValue() != null && datep.getValue() != null && Movie.getValue() != null) {
            StringBuilder t = new StringBuilder();
            for (int i = 1; i <= 10; i++) {
                if (c[i - 1]) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113","sql11418113","a6wHrcIltb");
                        Statement stmt = con.createStatement();
                        Statement input = con.createStatement();

                        input.executeUpdate("INSERT INTO reservation VALUE ('" + String.valueOf(i) + "','" + Controller.uemail + "','" + datep.getValue() + "','" + TimeSLot.getValue() + "','" + Movie.getValue() + "','" + String.valueOf(c[i - 1]) + "')");
                        t.append(i).append(",");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
            refresh();
            MAIL.send(Controller.uemail, "tickets", "u bought tickets seats " + t.toString() + "  at " + TimeSLot.getValue() + " at " + datep.getValue() + " of movie " + Movie.getValue());
            AlertBox.display("sucess","seats are reserved check your mail");
        } else {
            AlertBox.display("information missing", "sorry you cant reserve you need to fill the form first");
        }
    }

    public void back(ActionEvent event) throws Exception{
        Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main_window.fxml")));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("main");
        loginstage.setScene(loginScene);
        loginstage.show();

    }
}


