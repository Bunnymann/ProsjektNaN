/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication.GUI;


import DataModel.ModulDataModel;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Framework.ModulManager;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;



/**
 * FXML Controller class
 *
 * @author eier
 */
public class FXMLModulStudentController implements Initializable {

    ModulDataModel modul;
    HashMap<Integer, ModulDataModel> moduler = new HashMap<>();
    
    public void setModul(ModulDataModel m){
        this.modul = m;
    }
    
    //Henter Modulen fra modulmanageren. 
    public ModulDataModel getFromDb(int id){
        ModulManager manager = new ModulManager();
        return manager.getModul(id);
    }
    
    // Setter inn modulene fra arraylisten i modulmanger i Hashmapen moduler. 
    public void settModulerIHashMap(){
        ModulManager manager = new ModulManager();
        this.moduler = manager.getModulList();            
    }
    //henter modul objekter fra Shapmappen og viser den du vil ha. 
    public void hentModulObjekter (int i){
        ModulDataModel funn = moduler.get(i);
    }
    
      
    @FXML
    public TextArea ModulInfo;
        
    
    
    
   
     @FXML
    private void modulerS(ActionEvent event) throws IOException {
        Parent modulerS_parent = FXMLLoader.load(getClass().getResource("FXMLModulStudent.fxml"));
        Scene modulerS_scene = new Scene(modulerS_parent);
        Stage modulerS_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        modulerS_stage.hide();
        modulerS_stage.setScene(modulerS_scene);
        modulerS_stage.show();
    }
    
     @FXML
    private void brukereS(ActionEvent event) throws IOException {
        Parent brukereS_parent = FXMLLoader.load(getClass().getResource("FXMLBrukereStudent.fxml"));
        Scene brukereS_scene = new Scene(brukereS_parent);
        Stage brukereS_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        brukereS_stage.hide();
        brukereS_stage.setScene(brukereS_scene);
        brukereS_stage.show();
    }
    
     @FXML
    private void fremgangS(ActionEvent event) throws IOException {
        Parent fremgangS_parent = FXMLLoader.load(getClass().getResource("FXMLFremgangStudent.fxml"));
        Scene fremgangS_scene = new Scene(fremgangS_parent);
        Stage fremgangS_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fremgangS_stage.hide();
        fremgangS_stage.setScene(fremgangS_scene);
        fremgangS_stage.show();
    }
    
    @FXML
    private void bloggS(ActionEvent event) throws IOException {
        Parent bloggS_parent = FXMLLoader.load(getClass().getResource("FXMLBloggStudent.fxml"));
        Scene bloggS_scene = new Scene(bloggS_parent);
        Stage bloggS_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        bloggS_stage.hide();
        bloggS_stage.setScene(bloggS_scene);
        bloggS_stage.show();
    }
    
    @FXML
    private void startsidestudent(ActionEvent event) throws IOException {
        Parent startsidestudent_parent = FXMLLoader.load(getClass().getResource("FXMLStartSide.fxml"));
        Scene startsidestudent_scene = new Scene(startsidestudent_parent);
        Stage startsidestudent_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startsidestudent_stage.hide();
        startsidestudent_stage.setScene(startsidestudent_scene);
        startsidestudent_stage.show();
    }
        
    
    @FXML
    private void modul1 (ActionEvent event) throws IOException {    
        ModulInfo.setText("Her er info om Modul 1");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(hentModulObjekter(1));
        
     /*   
        setModul(getFromDb(1));
        ModulInfo.appendText("Det du skal gjøre i modulen er: " + modul.getModuldesc());
     */ 
    }
    
 // Sjekker opp hvor mange elemeter er i den nye arraylisten, for å se om de har blitt lagt til. 
/*    @FXML
    private void Test (ActionEvent event) throws IOException { 
        System.out.println(moduler.size());
        settModulerIArrayList();
        System.out.println("New Size: "+ moduler.size());
        
    }
*/
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    
}

