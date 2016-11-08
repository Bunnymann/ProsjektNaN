/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import Framework.ModulManager;

/**
 *
 * @author Sindre
 */
public class Main {

    public static void main(String[] args) {
        ModulManager manager = new ModulManager();
        //System.out.println(manager.getModulName(1));
        System.out.println(manager.getModulById(3).getModulname());
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
