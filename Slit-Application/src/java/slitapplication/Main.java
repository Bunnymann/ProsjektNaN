/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;



import Framework.ModulManager;
import javafx.application.Application;
import slitapplication.GUI.GUI;


/**
 *
 * @author Sindre
 */



public class Main {
    

    public static void main(String[] args) {
      Application.launch(GUI.class, args);
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

}

