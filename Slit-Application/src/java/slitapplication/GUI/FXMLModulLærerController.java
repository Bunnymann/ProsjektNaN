/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication.GUI;

import Framework.ModulManager;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eier
 */
public class FXMLModulLærerController implements Initializable {

    ModulManager manager;
        @FXML
    private void moduler(ActionEvent event) throws IOException {
        Parent moduler_parent = FXMLLoader.load(getClass().getResource("FXMLModulLærer.fxml"));
        Scene moduler_scene = new Scene(moduler_parent);
        Stage moduler_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        moduler_stage.hide();
        moduler_stage.setScene(moduler_scene);
        moduler_stage.show();
    }
    
     @FXML
    private void brukere (ActionEvent event) throws IOException {
        Parent brukere_parent = FXMLLoader.load(getClass().getResource("FXMLBrukereLærer.fxml"));
        Scene brukere_scene = new Scene(brukere_parent);
        Stage brukere_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        brukere_stage.hide();
        brukere_stage.setScene(brukere_scene);
        brukere_stage.show();
    }
    
     @FXML
    private void fremgang(ActionEvent event) throws IOException {
        Parent fremgang_parent = FXMLLoader.load(getClass().getResource("FXMLFremgangLærer.fxml"));
        Scene fremgang_scene = new Scene(fremgang_parent);
        Stage fremgang_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fremgang_stage.hide();
        fremgang_stage.setScene(fremgang_scene);
        fremgang_stage.show();
    }
    
    @FXML
    private void startside (ActionEvent event) throws IOException {
        Parent startside_parent = FXMLLoader.load(getClass().getResource("FXMLStartSideLærer.fxml"));
        Scene startside_scene = new Scene(startside_parent);
        Stage startside_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startside_stage.hide();
        startside_stage.setScene(startside_scene);
        startside_stage.show();
        
  
        
    }
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
