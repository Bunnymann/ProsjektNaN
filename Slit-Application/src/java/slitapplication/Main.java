/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import DataModel.InnleveringDataModel;
import Framework.InnleveringManager;
import java.util.List;

/**
 *
 * @author Sindre
 */
public class Main {

    
    public static void main(String[] args) {
        InnleveringManager manager = new InnleveringManager();
        List<InnleveringDataModel> l1 = manager.findAll();
        for(InnleveringDataModel i : l1){
            System.out.println(i.toString());
        }

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
