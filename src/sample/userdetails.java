package sample;

import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class userdetails {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button mmail;

    @FXML
    private Button mname;

    @FXML
    private Button mnew;

    @FXML
    private Button back;

    @FXML
    private TextField mail;

    @FXML
    private TextField Name;

    @FXML
    private TextField newPass;

    @FXML
    void backtomain(ActionEvent event) throws  Exception{
        Parent loginparent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main_window.fxml")));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("main");
        loginstage.setScene(loginScene);
        loginstage.centerOnScreen();
        loginstage.show();

    }

    @FXML
    void mnew(ActionEvent event) {
        if (!newPass.getText().isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
                Statement input = con.createStatement();
                input.executeUpdate("UPDATE `sql11418113`.`user` SET `name` = '" + newPass.getText() + "' WHERE (`mail` = '" + Controller.uemail + "');");

                con.close();
                AlertBox.display("success", "password changed");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            AlertBox.display("error", "can not be empty");

        }
    }

    @FXML
    void updatemail(ActionEvent event) {
        boolean u = true;
        if(!mail.getText().isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
                Statement input = con.createStatement();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from user");
                while (rs.next())
                    if (rs.getString("mail").equals(mail.getText()))
                        u = false;
                if (u) {
                    input.executeUpdate("UPDATE `sql11418113`.`user` SET `mail` = '" + mail.getText() + "' WHERE (`mail` = '" + Controller.uemail + "');");
                    input.executeUpdate("UPDATE `sql11418113`.`reservation` SET `by` = '" + mail.getText() + "' WHERE (`by` = '" + Controller.uemail + "');");
                    AlertBox.display("success", "changed");
                    Controller.uemail = mail.getText();
                } else {
                    AlertBox.display("error", "email is already registered in the system change the email");
                }
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        else {AlertBox.display("error", "can not be empty");}
    }

    @FXML
    void updatename(ActionEvent event) {
        if(!Name.getText().isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11418113", "sql11418113", "a6wHrcIltb");
                Statement input = con.createStatement();
                input.executeUpdate("UPDATE `sql11418113`.`user` SET `name` = '" + Name.getText() + "' WHERE (`mail` = '" + Controller.uemail + "');");
                Controller.uusername = Name.getText();
                con.close();
                AlertBox.display("success", "changed");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        else {AlertBox.display("error ","can not be empty");}

    }

    @FXML
    void initialize() {
        assert mmail != null : "fx:id=\"mmail\" was not injected: check your FXML file 'userdetail.fxml'.";
        assert mname != null : "fx:id=\"mname\" was not injected: check your FXML file 'userdetail.fxml'.";
        assert mnew != null : "fx:id=\"mnew\" was not injected: check your FXML file 'userdetail.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'userdetail.fxml'.";
        assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'userdetail.fxml'.";
        assert Name != null : "fx:id=\"Name\" was not injected: check your FXML file 'userdetail.fxml'.";
        assert newPass != null : "fx:id=\"newPass\" was not injected: check your FXML file 'userdetail.fxml'.";

    }
}
//    public void updatemail(ActionEvent event) {
//
//    }
//
//    public void updatename(ActionEvent event) {

//    }
//
//    public void mnew(ActionEvent event) {
//
//    }
//
//    public void backtomain(ActionEvent event) throws Exception {
//
//
//    }

