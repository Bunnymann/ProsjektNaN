/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication.GUI;

import DataModel.ModulDataModel;
import Framework.ModulManager;
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
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class FXMLModulLærerController implements Initializable {
    
    int modulId;
    
    String modulDesc;
    String  modulTid;
    String  modulMål;
    int  quizID;
    
    //Lager en ny modulManager for å få funksjonene til manageren inn på controllerklasssen.
    ModulManager manager;  
    //Lager en ny HashMap som har alle modulene inni seg
    //Vi bruker Hashmap, for å kunne søke opp på akkurat den modulen du vil ha.
    //Bruker ikke list fordi da vet vi aldri hvilken modul du faktisk får.
    ModulHash m;

    public FXMLModulLærerController() {
        this.m = new ModulHash();
        this.modulDesc = null;
        this.modulId = 0;
        this.modulMål = null;
        this.modulTid = null;
        this.quizID = 0;
        this.manager = new ModulManager();
    
    }

    public int getModulId() {
        return modulId;
    }

    public void setModulId(int modulId) {
        this.modulId = modulId;
    }

    public String getModulDesc() {
        return modulDesc;
    }

    public void setModulDesc(String modulDesc) {
        this.modulDesc = modulDesc;
    }

    public String getModulTid() {
        return modulTid;
    }

    public void setModulTid(String modulTid) {
        this.modulTid = modulTid;
    }

    public String getModulMål() {
        return modulMål;
    }

    public void setModulMål(String modulMål) {
        this.modulMål = modulMål;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }
    
    
    //TextAreaet i GUI på lærer siden, blir funnet så vi kan hente info fra textareat.
    @FXML
    public TextArea modulInfoL;
    
    
    
    //Bytter scene til ModulLærer siden.
        @FXML
    private void moduler(ActionEvent event) throws IOException {
        Parent moduler_parent = FXMLLoader.load(getClass().getResource("FXMLModulLærer.fxml"));
        Scene moduler_scene = new Scene(moduler_parent);
        Stage moduler_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        moduler_stage.hide();
        moduler_stage.setScene(moduler_scene);
        moduler_stage.show();
    }
    
    //Bytter scene til BrukereLærer siden.
     @FXML
    private void brukere (ActionEvent event) throws IOException {
        Parent brukere_parent = FXMLLoader.load(getClass().getResource("FXMLBrukereLærer.fxml"));
        Scene brukere_scene = new Scene(brukere_parent);
        Stage brukere_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        brukere_stage.hide();
        brukere_stage.setScene(brukere_scene);
        brukere_stage.show();
    }
    
    //Bytter scenen til FremgangLærer siden.
     @FXML
    private void fremgang(ActionEvent event) throws IOException {
        Parent fremgang_parent = FXMLLoader.load(getClass().getResource("FXMLFremgangLærer.fxml"));
        Scene fremgang_scene = new Scene(fremgang_parent);
        Stage fremgang_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fremgang_stage.hide();
        fremgang_stage.setScene(fremgang_scene);
        fremgang_stage.show();
    }
    
    //Setter deg tilbake til startsiden for lærer.
    @FXML
    private void startside (ActionEvent event) throws IOException {
        Parent startside_parent = FXMLLoader.load(getClass().getResource("FXMLStartSideLærer.fxml"));
        Scene startside_scene = new Scene(startside_parent);
        Stage startside_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startside_stage.hide();
        startside_stage.setScene(startside_scene);
        startside_stage.show();
       
    }
   
    //Henter informasjonen om modul1 fra Hashmap som skrives ut i TextAreaet.
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
    
    //Henter informasjonen om modul2 fra Hashmap som skrives ut i TextAreaet.
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
    
    //Henter informasjonen om modul3 fra Hashmap som skrives ut i TextAreaet.
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
    
    //Henter informasjonen om modul4 fra Hashmap som skrives ut i TextAreaet.
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
    
    //Henter informasjonen om modul5 fra Hashmap som skrives ut i TextAreaet.
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
    
    //Henter informasjonen om modul6 fra Hashmap som skrives ut i TextAreaet.
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
    
    //Henter informasjonen om modul7 fra Hashmap som skrives ut i TextAreaet.
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
    
    //Henter informasjonen om modul8 fra Hashmap som skrives ut i TextAreaet.
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
    
    //Henter informasjonen om modul9 fra Hashmap som skrives ut i TextAreaet.
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
    
    //Henter informasjonen om modul10 fra Hashmap som skrives ut i TextAreaet.
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
    
    
    //Åpner et popupVindu for lærer, som lærer på krysse ut før han ka gjøre noe videre i programmet.
    @FXML
    private void leggTilModul (ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = new Stage();
        
        root = FXMLLoader.load(getClass().getResource("FXMLModulPopUpLærer.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        
    }
    
    
    //Henter textFeild og textarea fra GUI med Fx:id for å kunne referete til disse når
    //Det skal skrives til databasen.
    @FXML
    public TextField modulIDFelt;
    @FXML
    public TextArea modulDescFelt;
    @FXML
    public TextField modulTidfelt;
    @FXML
    public TextField modulMålFelt;
    @FXML 
    public TextField quizFelt;
   
    //Henter ut det læreren har skrevet om en ny modul, og skrivet dette inn til datanbasen. 
    @FXML 
    private void registrerModul (ActionEvent event) throws IOException {
        setModulDesc(modulDescFelt.getText());
        setModulId(Integer.parseInt(modulIDFelt.getText()));
        setModulMål(modulMålFelt.getText());
        setModulTid(modulTidfelt.getText());
        setQuizID(Integer.parseInt(quizFelt.getText()));
        
        manager.createModul(modulId, modulMål, modulDesc, modulTid,"Modul " + modulId, quizID);
    }
    
    
    //Åpner et popUpvindu for slett modul.
   @FXML 
   private void slettModul (ActionEvent event) throws IOException{
        Stage stage2;
        Parent root2;
        stage2 = new Stage();
        
        root2 = FXMLLoader.load(getClass().getResource("FXMLPopUpSlettModul.fxml"));
        stage2.setScene(new Scene(root2));
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.showAndWait();
   }  
    
   
  /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
     