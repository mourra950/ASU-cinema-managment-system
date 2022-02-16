package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.util.Objects;

public class mMenu {
    public Button button1;
    public Button button2;
    public static int mpick;
    public Button mmail;
    public Button mname;
    public Button mnew;
    public Button back;
    public TextField mail;
    public TextField Name;
    public TextField newPass;
    public ImageView test_image;
    public ImageView test_image1;
    public Text hello;
    public Text rec;

    public void loadupdateinfo(ActionEvent event) throws Exception {
        Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("userdetail.fxml")));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("update info");
        loginstage.setScene(loginScene);
        loginstage.centerOnScreen();
        loginstage.show();

    }

    public void loadchairs(ActionEvent event) throws Exception {
        Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chairs.fxml")));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("chair");
        loginstage.setScene(loginScene);
        loginstage.centerOnScreen();
        loginstage.show();
    }

    public void loadcreatorpage(ActionEvent event) {
    }

    public void loaddetails1(ActionEvent event) throws Exception {
        mpick=1;
        Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("moviedetails.fxml")));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("movie details");
        loginstage.setScene(loginScene);
        loginstage.centerOnScreen();
        loginstage.show();
    }

    public void loaddetails2(ActionEvent event) throws Exception {
        mpick=2;
        Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("moviedetails.fxml")));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("movie details");
        loginstage.setScene(loginScene);
        loginstage.centerOnScreen();
        loginstage.show();
    }



    @FXML
    void initialize() throws IOException {
        int[] R = {0,0};
        String[] M = new String[2];
        String[] N = new String[2];

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113","sql11418113","a6wHrcIltb");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from movie");
            int i=0 ;
            while(rs.next())
            {
                N[i]= rs.getString(5);
                M[i]=rs.getString(7);
                i++;
                System.out.println(rs.getString(7));
            }
            con.close();
        }catch(Exception e){ System.out.println(e);
        }

        URL url1 = new URL(M[0]);
        URLConnection conn = url1.openConnection();
        InputStream in = conn.getInputStream();
        Image image = new Image(in);
        //Creating the image view
        test_image.setImage(image);
        URL url2 = new URL(M[1]);
        URLConnection conn2 = url2.openConnection();
        InputStream in2 = conn2.getInputStream();
        Image image2 = new Image(in2);
        test_image1.setImage(image2);



        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113","sql11418113","a6wHrcIltb");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from reservation");
            int i=0 ;
            while(rs.next())
            {
                if(rs.getString(5).equals(N[0]))
                {
                    R[0]++;
                }
                else if (rs.getString(5).equals(N[1]))
                {
                    R[1]++;
                }
                i++;
            }
            con.close();
        }catch(Exception e){ System.out.println(e);
        }
        if(R[0]<R[1])
            rec.setText("the movie is the most popular " + N[1]);
        else
            rec.setText("the movie is the most popular " + N[0]);
        hello.setText("hello " + Controller.uusername);
    }

    public void loadlocation(ActionEvent event) {
        Desktop desktop = java.awt.Desktop.getDesktop();
        try {
            URI oURL = new URI("https://goo.gl/maps/TiaJysXFDkEJnSzo7");
            desktop.browse(oURL);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    public void logout(ActionEvent actionEvent) throws Exception {
        Controller.uusername=null;
        Controller.uemail=null;
        Controller.a=false;
        Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        loginstage.setTitle("Login");
        loginstage.setScene(loginScene);
        loginstage.centerOnScreen();
        loginstage.show();
    }

}
