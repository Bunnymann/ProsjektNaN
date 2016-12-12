/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import Framework.ModulManager;
import java.util.HashMap;


/**
 *
 * @author Sindre
 */
public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
        BesvarelseManager manager = new BesvarelseManager();
        Date d1 = Calendar.getInstance().getTime();
        BesvarelseDataModel test = new BesvarelseDataModel(5, d1, 5, 2, 5);
        
        manager.testMethod();
=======
>>>>>>> 80d8869ed9b9e522287a2378305bb94f48ef7ddf

        ModulManager m = new ModulManager();
        HashMap modulMap = m.getModulList();
        System.out.println(modulMap.entrySet());
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
