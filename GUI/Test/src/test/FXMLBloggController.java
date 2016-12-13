/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tomma
 */
public class FXMLBloggController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void tilbake(ActionEvent event) throws IOException {
        Parent tilbake_parent = FXMLLoader.load(getClass().getResource("FXMLHomePage.fxml"));
        Scene tilbake_scene = new Scene(tilbake_parent);
        Stage tilbake_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        tilbake_stage.hide();
        tilbake_stage.setScene(tilbake_scene);
        tilbake_stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
