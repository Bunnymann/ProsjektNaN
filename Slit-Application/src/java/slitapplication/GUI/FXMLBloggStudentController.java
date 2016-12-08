/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication.GUI;

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
public class FXMLBloggStudentController implements Initializable {

    
       @FXML
    private void modulerS(ActionEvent event) throws IOException {
        Parent modulerS_parent = FXMLLoader.load(getClass().getResource("FXMLModulStudent.fxml"));
        Scene modulerS_scene;
           modulerS_scene = new Scene(modulerS_parent);
        Stage modulerS_stage;
           modulerS_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        modulerS_stage.hide();
        modulerS_stage.setScene(modulerS_scene);
        modulerS_stage.show();
    }
    
     @FXML
    private void brukereS(ActionEvent event) throws IOException {
        Parent brukereS_parent = FXMLLoader.load(getClass().getResource("FXMLBrukereStudent.fxml"));
        Scene brukereS_scene;
           brukereS_scene = new Scene(brukereS_parent);
        Stage brukereS_stage;
           brukereS_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        brukereS_stage.hide();
        brukereS_stage.setScene(brukereS_scene);
        brukereS_stage.show();
    }
    
     @FXML
    private void fremgangS(ActionEvent event) throws IOException {
        Parent fremgangS_parent = FXMLLoader.load(getClass().getResource("FXMLFremgangStudent.fxml"));
        Scene fremgangS_scene;
           fremgangS_scene = new Scene(fremgangS_parent);
        Stage fremgangS_stage;
           fremgangS_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fremgangS_stage.hide();
        fremgangS_stage.setScene(fremgangS_scene);
        fremgangS_stage.show();
    }
    
    
    @FXML
    private void bloggS(ActionEvent event) throws IOException {
        Parent bloggS_parent = FXMLLoader.load(getClass().getResource("FXMLBloggStudent.fxml"));
        Scene bloggS_scene;
           bloggS_scene = new Scene(bloggS_parent);
        Stage bloggS_stage;
           bloggS_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        bloggS_stage.hide();
        bloggS_stage.setScene(bloggS_scene);
        bloggS_stage.show();
    }
    
     @FXML
    private void hjem(ActionEvent event) throws IOException {
        Parent hjem_parent = FXMLLoader.load(getClass().getClassLoader().getResource("FXMLStartSideStudent.fxml"));
        Scene hjem_scene;
           hjem_scene = new Scene(hjem_parent);
        Stage hjem_stage;
           hjem_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        hjem_stage.hide();
        hjem_stage.setScene(hjem_scene);
        hjem_stage.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
