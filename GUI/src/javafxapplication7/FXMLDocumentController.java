/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

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
 *
 * @author Tomma
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void Logginn(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLStartSideStudent.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage Logginn_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Logginn_stage.hide();
        Logginn_stage.setScene(home_page_scene);
        Logginn_stage.show();
    }
    
    @FXML
    private void lærer(ActionEvent event) throws IOException {
        Parent lærer_parent = FXMLLoader.load(getClass().getResource("FXMLStartSideLærer.fxml"));
        Scene lærer_scene = new Scene(lærer_parent);
        Stage lærer_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        lærer_stage.hide();
        lærer_stage.setScene(lærer_scene);
        lærer_stage.show();
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
