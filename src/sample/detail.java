package sample;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class detail {

    @FXML
    public ImageView imageM;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Trailer;

    @FXML
    private Button Description;

    @FXML
    private Button Cast;

    @FXML
    private Button Buy;

    @FXML
    private Button back;


    @FXML
    void backtomain(ActionEvent event)throws Exception {
        Parent loginparent = FXMLLoader.load(getClass().getResource("main_window.fxml"));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("main");
        loginstage.setScene(loginScene);
        loginstage.show();
    }

    @FXML
    void buytickets(ActionEvent event)throws Exception {
        Parent loginparent = FXMLLoader.load(getClass().getResource("chairs.fxml"));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("buy tickets");
        loginstage.setScene(loginScene);
        loginstage.show();

    }
    public void load(String L)
    {
        Desktop desktop = java.awt.Desktop.getDesktop();
        try {
            //specify the protocol along with the URL
            URI oURL = new URI(L);
            desktop.browse(oURL);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void opencast(ActionEvent event) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113","sql11418113","a6wHrcIltb");
            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from movie where idmovie='"+mMenu.mpick+"'");
            rs.next();
        load(rs.getString(3));
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
            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from movie where idmovie='"+mMenu.mpick+"'");
            rs.next();
            load(rs.getString(4));
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
            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from movie where idmovie='"+mMenu.mpick+"'");
            rs.next();
            load(rs.getString(2));
            con.close();
        }
        catch(Exception e){ System.out.println(e);}

    }

    @FXML
    void initialize() {
        assert Trailer != null : "fx:id=\"Trailer\" was not injected: check your FXML file 'moviedetails.fxml'.";
        assert Description != null : "fx:id=\"Description\" was not injected: check your FXML file 'moviedetails.fxml'.";
        assert Cast != null : "fx:id=\"Cast\" was not injected: check your FXML file 'moviedetails.fxml'.";
        assert Buy != null : "fx:id=\"Buy\" was not injected: check your FXML file 'moviedetails.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'moviedetails.fxml'.";

    }
}
