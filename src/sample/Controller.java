package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Controller {
    public Button bsignup;

    public Button bforgetPass;
    public TextField iPassword;
    public Button blogin;
    public TextField imail;
    public static  String uemail;
    public static  String uusername;
    public static boolean a = false;

    public void loginuser(ActionEvent event)throws Exception {
        boolean found=false;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113","sql11418113","a6wHrcIltb");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from user");
            while(rs.next())
            {
                System.out.println(iPassword.getText().equals(rs.getString(3)));
                System.out.println(imail.getText().equals(rs.getString(1)));
                if(iPassword.getText().equals(rs.getString(3)))
                    if(imail.getText().equals(rs.getString(1)))
                    {

                        found = true;
                        uemail=rs.getString(1);
                        uusername= rs.getString(2);
                        if(rs.getString(4).equals("true")) {
                            a = true;
                        }
                    }
            }
            con.close(); }catch(Exception e){ System.out.println(e);}
        if (found && a)
        {
            Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin_main_window.fxml")));
            Scene loginScene = new Scene(loginparent);
            Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            loginstage.setTitle("main");
            loginstage.setScene(loginScene);
            loginstage.centerOnScreen();
            loginstage.show();
        }
        else if(found)
        {
            Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main_window.fxml")));
            Scene loginScene = new Scene(loginparent);
            Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            loginstage.setTitle("main");
            loginstage.setScene(loginScene);
            loginstage.centerOnScreen();
            loginstage.show();
        }
        else{
            AlertBox.display("error","wrong password or mail");
            }
    }

    public void loadsignup(ActionEvent event)throws Exception {
        Parent RegisterParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Register.fxml")));
        Scene RegScene= new Scene(RegisterParent);
        Stage Regstage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Regstage.setTitle("Register");
        Regstage.setScene(RegScene);
        Regstage.centerOnScreen();
        Regstage.show();
    }


    public void forgotPassFunction(ActionEvent event) throws IOException {
        Parent RegisterParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("forgetPass.fxml")));
        Scene RegScene= new Scene(RegisterParent);
        Stage Regstage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Regstage.setTitle("retrieve");
        Regstage.setScene(RegScene);
        Regstage.centerOnScreen();
        Regstage.show();
    }
}
