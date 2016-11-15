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
public class FXMLLærerController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void moduler(ActionEvent event) throws IOException {
        Parent moduler_parent = FXMLLoader.load(getClass().getResource("FXMLLærerModuler.fxml"));
        Scene moduler_scene = new Scene(moduler_parent);
        Stage moduler_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        moduler_stage.hide();
        moduler_stage.setScene(moduler_scene);
        moduler_stage.show();
    }
    
    @FXML
    private void fremdrift(ActionEvent event) throws IOException {
        Parent fremdrift_parent = FXMLLoader.load(getClass().getResource("FXMLLærerFremdrift.fxml"));
        Scene fremdrift_scene = new Scene(fremdrift_parent);
        Stage fremdrift_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fremdrift_stage.hide();
        fremdrift_stage.setScene(fremdrift_scene);
        fremdrift_stage.show();
    }
    
    @FXML
    private void loggUt(ActionEvent event) throws IOException {
        Parent loggUt_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene loggUt_scene = new Scene(loggUt_parent);
        Stage loggUt_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loggUt_stage.hide();
        loggUt_stage.setScene(loggUt_scene);
        loggUt_stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
