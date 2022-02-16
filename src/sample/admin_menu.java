package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class admin_menu {
    public void load_umovie(ActionEvent event) throws Exception {
        Parent loginparent = FXMLLoader.load(getClass().getResource("detailadmin.fxml"));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.setTitle("details");
        loginstage.setScene(loginScene);
        loginstage.show();

    }

    public void logout(ActionEvent actionEvent) throws Exception {
        Controller.uusername=null;
        Controller.uemail=null;
        Controller.a=false;
        Parent loginparent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene loginScene = new Scene(loginparent);
        Stage loginstage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        loginstage.setTitle("Login");
        loginstage.setScene(loginScene);
        loginstage.centerOnScreen();
        loginstage.show();
    }
}
