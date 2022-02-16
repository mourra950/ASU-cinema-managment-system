package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Objects;

public class forgotPass {
    public Button SmyPass;
    public TextField femail;
    public String ffp;

    public void Sendmypass(ActionEvent e) throws Exception {
        boolean found = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113","sql11418113","a6wHrcIltb");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                if (femail.getText().equals(rs.getString(1))) {
                    found = true;
                    ffp =rs.getString(3);
                }

            }
            if(found)
            {
                MAIL.send(femail.getText(),"your password",ffp);
                    Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
                    Scene loginScene = new Scene(loginparent);
                    Stage loginstage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    loginstage.setTitle("main");
                    loginstage.setScene(loginScene);
                    loginstage.show();
                }
            else
            {
                AlertBox.display("error","wrong mailadress");
            }
            con.close();
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }


    }
}
