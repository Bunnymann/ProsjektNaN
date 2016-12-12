/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication.GUI;

import DataModel.ModulDataModel;
import Resources.ModulHash;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eier
 */
public class FXMLModulL�rerController implements Initializable {

    ModulHash m;

    public FXMLModulL�rerController() {
        this.m = new ModulHash();
    }
    
    @FXML
    public TextArea modulInfoL;
        
    
    
        @FXML
    private void moduler(ActionEvent event) throws IOException {
        Parent moduler_parent = FXMLLoader.load(getClass().getResource("FXMLModulL�rer.fxml"));
        Scene moduler_scene = new Scene(moduler_parent);
        Stage moduler_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        moduler_stage.hide();
        moduler_stage.setScene(moduler_scene);
        moduler_stage.show();
    }
    
     @FXML
    private void brukere (ActionEvent event) throws IOException {
        Parent brukere_parent = FXMLLoader.load(getClass().getResource("FXMLBrukereL�rer.fxml"));
        Scene brukere_scene = new Scene(brukere_parent);
        Stage brukere_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        brukere_stage.hide();
        brukere_stage.setScene(brukere_scene);
        brukere_stage.show();
    }
    
     @FXML
    private void fremgang(ActionEvent event) throws IOException {
        Parent fremgang_parent = FXMLLoader.load(getClass().getResource("FXMLFremgangL�rer.fxml"));
        Scene fremgang_scene = new Scene(fremgang_parent);
        Stage fremgang_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fremgang_stage.hide();
        fremgang_stage.setScene(fremgang_scene);
        fremgang_stage.show();
    }
    
    @FXML
    private void startside (ActionEvent event) throws IOException {
        Parent startside_parent = FXMLLoader.load(getClass().getResource("FXMLStartSideL�rer.fxml"));
        Scene startside_scene = new Scene(startside_parent);
        Stage startside_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startside_stage.hide();
        startside_stage.setScene(startside_scene);
        startside_stage.show();
       
    }
   
    
    @FXML
    private void modul1 (ActionEvent event) throws IOException {    
        modulInfoL.setText("Her er info om Modul 1");
        modulInfoL.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 1");
        modulInfoL.appendText(modul.getModuldesc());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Kriteriene for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulKriterier());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Fristen for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulFrist());
        
    }
    
    @FXML
    private void modul2 (ActionEvent event) throws IOException {    
        modulInfoL.setText("Her er info om Modul 2");
        modulInfoL.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 2");
        modulInfoL.appendText(modul.getModuldesc());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Kriteriene for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulKriterier());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Fristen for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulFrist());
        
    }
    
    @FXML
    private void modul3 (ActionEvent event) throws IOException {    
        modulInfoL.setText("Her er info om Modul 3");
        modulInfoL.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 3");
        modulInfoL.appendText(modul.getModuldesc());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Kriteriene for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulKriterier());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Fristen for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulFrist());
        
    }
    
    @FXML
    private void modul4 (ActionEvent event) throws IOException {    
        modulInfoL.setText("Her er info om Modul 4");
        modulInfoL.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 4");
        modulInfoL.appendText(modul.getModuldesc());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Kriteriene for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulKriterier());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Fristen for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulFrist());
        
    }
    
    @FXML
    private void modul5 (ActionEvent event) throws IOException {    
        modulInfoL.setText("Her er info om Modul 5");
        modulInfoL.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 5");
        modulInfoL.appendText(modul.getModuldesc());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Kriteriene for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulKriterier());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Fristen for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulFrist());
        
    }
    
    @FXML
    private void modul6 (ActionEvent event) throws IOException {    
        modulInfoL.setText("Her er info om Modul 6");
        modulInfoL.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 6");
        modulInfoL.appendText(modul.getModuldesc());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Kriteriene for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulKriterier());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Fristen for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulFrist());
        
    }
    
    @FXML
    private void modul7 (ActionEvent event) throws IOException {    
        modulInfoL.setText("Her er info om Modul 7");
        modulInfoL.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 7");
        modulInfoL.appendText(modul.getModuldesc());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Kriteriene for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulKriterier());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Fristen for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulFrist());
        
    }
    
    @FXML
    private void modul8 (ActionEvent event) throws IOException {    
        modulInfoL.setText("Her er info om Modul 8");
        modulInfoL.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 8");
        modulInfoL.appendText(modul.getModuldesc());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Kriteriene for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulKriterier());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Fristen for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulFrist());
        
    }
    
    @FXML
    private void modul9 (ActionEvent event) throws IOException {    
        modulInfoL.setText("Her er info om Modul 9");
        modulInfoL.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 9");
        modulInfoL.appendText(modul.getModuldesc());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Kriteriene for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulKriterier());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Fristen for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulFrist());
        
    }
    
    @FXML
    private void modul10 (ActionEvent event) throws IOException {    
        modulInfoL.setText("Her er info om Modul 10");
        modulInfoL.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 10");
        modulInfoL.appendText(modul.getModuldesc());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Kriteriene for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulKriterier());
        modulInfoL.appendText("\n");
        modulInfoL.appendText("\n");
        modulInfoL.appendText("Fristen for modulen er");
        modulInfoL.appendText("\n");
        modulInfoL.appendText(modul.getModulFrist());
        
    }
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
