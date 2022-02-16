package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class detailadmin {


    public Button Trailer;
    public Button Description;
    public Button Cast;
    public Button back;
    public TextField trailer;
    public TextField descr;
    public TextField poster;
    public TextField cast;
    public ChoiceBox day;
    public Button update;
    public ChoiceBox num;

    @FXML
    void backtomain(ActionEvent event)throws Exception {
        Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main_window.fxml")));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("main");
        loginstage.setScene(loginScene);
        loginstage.show();
    }


    @FXML
    void opencast(ActionEvent event) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113","sql11418113","a6wHrcIltb");
            Statement input = con.createStatement();

            input.executeUpdate("UPDATE `sql11418113`.`movie` SET `trailer` = '"+cast.getText()+"' WHERE (`idmovie` = '"+num.getValue()+"');");
            con.close();
        }
        catch(Exception e){ System.out.println(e);}

    }

    @FXML
    void opendescription(ActionEvent event) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113","sql11418113","a6wHrcIltb");
            Statement input=con.createStatement();

            input.executeUpdate("UPDATE `sql11418113`.`movie` SET `trailer` = '"+descr.getText()+"' WHERE (`idmovie` = '"+num.getValue()+"');");
            con.close();
        }
        catch(Exception e){ System.out.println(e);}
    }

    @FXML
    void opentrailer(ActionEvent event) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113","sql11418113","a6wHrcIltb");
            Statement input=con.createStatement();

            input.executeUpdate("UPDATE `sql11418113`.`movie` SET `trailer` = '"+trailer.getText()+"' WHERE (`idmovie` = '"+num.getValue()+"');");

            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

    @FXML
    void initialize() {
        assert Trailer != null : "fx:id=\"Trailer\" was not injected: check your FXML file 'moviedetails.fxml'.";
        assert Description != null : "fx:id=\"Description\" was not injected: check your FXML file 'moviedetails.fxml'.";
        assert Cast != null : "fx:id=\"Cast\" was not injected: check your FXML file 'moviedetails.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'moviedetails.fxml'.";

    }

    public void update(ActionEvent event) {
    }
}
