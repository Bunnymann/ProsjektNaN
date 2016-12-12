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
import Resources.ModulHash;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;



/**
 * FXML Controller class
 *
 * @author eier
 */
public class FXMLModulStudentController implements Initializable {

ModulHash m;

    public FXMLModulStudentController() {
        this.m = new ModulHash();
    }


//    
//    public void setModul(ModulDataModel m){
//        this.modul = m;
//    }
//    
//    //Henter Modulen fra modulmanageren. 
//    public ModulDataModel getFromDb(int id){
//        ModulManager manager = new ModulManager();
//        return manager.getModul(id);
//    }
//    
//    // Setter inn modulene fra arraylisten i modulmanger i Hashmapen moduler. 
//    public void settModulerIHashMap(){
//        ModulManager manager = new ModulManager();
//        this.moduler = manager.getModulList();            
//    }
//    //henter modul objekter fra haspmappen og viser den du vil ha. 
//    public ModulDataModel hentModulObjekter (String key){
//        ModulDataModel funn = moduler.get(key);
//        return funn;
//    }
    
      
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
    private void startSideStudent(ActionEvent event) throws IOException {
        Parent startsidestudent_parent = FXMLLoader.load(getClass().getResource("FXMLStartSideStudent.fxml"));
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
        ModulDataModel modul = m.getModulByKey("modul 1");
        ModulInfo.appendText(modul.getModuldesc());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Kriteriene for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulKriterier());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Fristen for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulFrist());
        
    }
    
    @FXML
    private void modul2 (ActionEvent event) throws IOException {    
        ModulInfo.setText("Her er info om Modul 2");
        ModulInfo.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 2");
        ModulInfo.appendText(modul.getModuldesc());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Kriteriene for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulKriterier());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Fristen for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulFrist());
        
    }
    
     @FXML
    private void modul3 (ActionEvent event) throws IOException {    
        ModulInfo.setText("Her er info om Modul 3");
        ModulInfo.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 3");
        ModulInfo.appendText(modul.getModuldesc());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Kriteriene for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulKriterier());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Fristen for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulFrist());
        
    }
    
     @FXML
    private void modul4 (ActionEvent event) throws IOException {    
        ModulInfo.setText("Her er info om Modul 4");
        ModulInfo.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 4");
        ModulInfo.appendText(modul.getModuldesc());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Kriteriene for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulKriterier());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Fristen for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulFrist());
        
    }
    
    
     @FXML
    private void modul5 (ActionEvent event) throws IOException {    
        ModulInfo.setText("Her er info om Modul 5");
        ModulInfo.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 5");
        ModulInfo.appendText(modul.getModuldesc());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Kriteriene for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulKriterier());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Fristen for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulFrist());
        
    }
    
     @FXML
    private void modul6 (ActionEvent event) throws IOException {    
        ModulInfo.setText("Her er info om Modul 6");
        ModulInfo.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 6");
        ModulInfo.appendText(modul.getModuldesc());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Kriteriene for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulKriterier());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Fristen for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulFrist());
        
    }
    
     @FXML
    private void modul7 (ActionEvent event) throws IOException {    
        ModulInfo.setText("Her er info om Modul 7");
        ModulInfo.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 7");
        ModulInfo.appendText(modul.getModuldesc());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Kriteriene for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulKriterier());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Fristen for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulFrist());
        
    }
    
     @FXML
    private void modul8 (ActionEvent event) throws IOException {    
        ModulInfo.setText("Her er info om Modul 8");
        ModulInfo.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 8");
        ModulInfo.appendText(modul.getModuldesc());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Kriteriene for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulKriterier());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Fristen for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulFrist());
        
    }
    
     @FXML
    private void modul9 (ActionEvent event) throws IOException {    
        ModulInfo.setText("Her er info om Modul 9");
        ModulInfo.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 9");
        ModulInfo.appendText(modul.getModuldesc());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Kriteriene for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulKriterier());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Fristen for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulFrist());
        
    }
    
     @FXML
    private void modul10 (ActionEvent event) throws IOException {    
        ModulInfo.setText("Her er info om Modul 10");
        ModulInfo.appendText("\n");
        ModulDataModel modul = m.getModulByKey("modul 10");
        ModulInfo.appendText(modul.getModuldesc());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Kriteriene for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulKriterier());
        ModulInfo.appendText("\n");
        ModulInfo.appendText("\n");
        ModulInfo.appendText("Fristen for modulen er");
        ModulInfo.appendText("\n");
        ModulInfo.appendText(modul.getModulFrist());
        
    }
    
 // Sjekker opp hvor mange elemeter er i den nye arraylisten, for � se om de har blitt lagt til. 
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

