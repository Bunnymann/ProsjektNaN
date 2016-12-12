/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import DataModel.TilbakemeldingDataModel;
import Framework.TilbakmeldingManager;


/**
 *
 * @author Sindre
 */
public class Main {

    public static void main(String[] args) {

        
        TilbakmeldingManager tb1 = new TilbakmeldingManager();
        TilbakemeldingDataModel tb = new TilbakemeldingDataModel(7,"Jallamekk", "Godkjent", "ballefrans");
        tb1.kobleTbTilBesvar(1, tb);
        
        
        
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
