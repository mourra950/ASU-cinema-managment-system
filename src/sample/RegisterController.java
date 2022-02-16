package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Objects;

public class RegisterController {
    public TextField sUsername;
    public PasswordField sPass;
    public PasswordField sPasse;
    public Button sConfirm;
    public TextField smail;

    public void SignUpUser(ActionEvent event) {
        boolean P = false;
        boolean u = true;
        String name = sUsername.getText();
        String mail = smail.getText();
        String pass = sPass.getText();
        if (pass.equals(sPasse.getText())) {

            P = true;
        }
        if (!smail.getText().isEmpty() || !sPass.getText().isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from user");
                while (rs.next())
                    if (rs.getString("mail").equals(mail))
                        u = false;

                try {
                    if (P && u) {
                        PreparedStatement input = con.prepareStatement("INSERT INTO user VALUE('" + mail + "','" + name + "','" + pass + "',false)");
                        input.executeUpdate();
                        con.close();
                        Parent RegisterParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
                        Scene RegScene = new Scene(RegisterParent);
                        Stage Regstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Regstage.setTitle("login");
                        Regstage.setScene(RegScene);
                        Regstage.show();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            AlertBox.display("error", "cannot be empty");
        }
    }


    public void gologin(ActionEvent event)throws Exception {
        Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("main");
        loginstage.setScene(loginScene);
        loginstage.show();
    }
}
