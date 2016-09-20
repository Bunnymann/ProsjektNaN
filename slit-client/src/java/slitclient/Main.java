/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sindre
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        Parent root = new MainScene();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("SLIT");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        public static void main(String[] args) {
        launch(args);
    }
        
}