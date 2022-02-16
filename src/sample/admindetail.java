package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class admindetail {
    public TextField trailer;
    public DatePicker date;
    public ChoiceBox<String> nump;
    public Button update;
    public TextField cast;
    public TextField poster;
    public TextField descr;
    public TextField name1;

    public void update(ActionEvent event) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113","sql11418113","a6wHrcIltb");
            Statement input = con.createStatement();
                input.executeUpdate("UPDATE `movie` SET `name` = '" + name1.getText() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                input.executeUpdate("UPDATE `movie` SET `desc` = '" + descr.getText() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                input.executeUpdate("UPDATE `movie` SET `cast` = '" + cast.getText() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                input.executeUpdate("UPDATE `movie` SET `trailer` = '" + trailer.getText() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                input.executeUpdate("UPDATE `movie` SET `date` = '" + date.getValue() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                input.executeUpdate("UPDATE `movie` SET `poster` = '" + poster.getText() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                AlertBox.display("success", "all information");
                con.close();
            if(poster.getText().equals(" "))
                AlertBox.display("error", "please put poster link");
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void backtomain(ActionEvent event) throws Exception {
        Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin_main_window.fxml")));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("main");
        loginstage.setScene(loginScene);
        loginstage.show();
    }

    public void opencast(ActionEvent event) {
        if (!cast.getText().isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
                Statement input = con.createStatement();

                input.executeUpdate("UPDATE `cinema`.`movie` SET `cast` = '" + cast.getText() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                AlertBox.display("success", "cast updated");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{AlertBox.display("error","can not be empty");}
    }

    public void opendescription(ActionEvent event) {
        if(!descr.getText().isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
                Statement input = con.createStatement();

                input.executeUpdate("UPDATE `cinema`.`movie` SET `desc` = '" + descr.getText() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                AlertBox.display("success", "description updated");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{AlertBox.display("error","can not be empty");}
    }

    public void opentrailer(ActionEvent event) {
        if(!trailer.getText().isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
                Statement input = con.createStatement();

                input.executeUpdate("UPDATE `cinema`.`movie` SET `trailer` = '" + trailer.getText() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                AlertBox.display("success", "trailer link updated");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {AlertBox.display("error","can not be empty");}
    }

    @FXML
    void initialize() {
        assert trailer != null : "fx:id=\"trailer\" was not injected: check your FXML file 'detailadmin.fxml'.";
        assert descr != null : "fx:id=\"descr\" was not injected: check your FXML file 'detailadmin.fxml'.";
        assert poster != null : "fx:id=\"poster\" was not injected: check your FXML file 'detailadmin.fxml'.";
        assert cast != null : "fx:id=\"cast\" was not injected: check your FXML file 'detailadmin.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'detailadmin.fxml'.";
        nump.setItems(FXCollections.observableArrayList("1", "2"));
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'detailadmin.fxml'.";

    }


    public void nameupdate(ActionEvent actionEvent) {
        if (!name1.getText().isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
                Statement input = con.createStatement();
                input.executeUpdate("UPDATE `movie` SET `name` = '" + name1.getText() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                AlertBox.display("success", "movie name updated");
                con.close();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
        else {AlertBox.display("error","can not be empty");}

    }
    public void openposter(ActionEvent event) {
        if(!poster.getText().isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
                Statement input = con.createStatement();
                input.executeUpdate("UPDATE `movie` SET `poster` = '" + poster.getText() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                AlertBox.display("success", "poster updated");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{AlertBox.display("error","can not be empty");}
    }

    public void updatedate(ActionEvent actionEvent) {
        if(date.getValue()!= null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
                Statement input = con.createStatement();
                input.executeUpdate("UPDATE `movie` SET `date` = '" + date.getValue() + "' WHERE (`idmovie` = '" + nump.getValue() + "');");
                AlertBox.display("success", "date updated");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{AlertBox.display("error","can not be empty");}
    }
}
