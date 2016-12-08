/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import DataModel.BesvarelseDataModel;
import Framework.BesvarelseManager;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Sindre
 */
public class Main {

    
    public static void main(String[] args) {
<<<<<<< HEAD
        //BesvarelseManager manager = new BesvarelseManager();
        //System.out.println(manager.getModulName(1));
        //System.out.println(manager.testMethod());
        TilbakemeldingManager manager = new TilbakemeldingManager();
        System.out.println(manager.)
=======
        BesvarelseManager manager = new BesvarelseManager();
        Date d1 = Calendar.getInstance().getTime();
        BesvarelseDataModel test = new BesvarelseDataModel(5, d1, 5, 2, 5);
        
        manager.createBesvarelse(test);

>>>>>>> develop
    }


    /*public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setRoot(Parent newRoot) {
        this.root = newRoot;
    }

    public void setScene(Scene newScene) {
        this.scene = newScene;
    }

    public void updateScene(Scene newScene) {
        primaryStage.setScene(newScene);
        primaryStage.show();

    }*/

    public Main() {
    }
}
