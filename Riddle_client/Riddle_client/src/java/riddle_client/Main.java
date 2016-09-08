/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riddle_client;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Sindre
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Quiz");
        BorderPane border = new BorderPane();
        VBox vbox = new VBox();
        border.setBottom(vbox);
        vbox.setPadding(new Insets(12, 12, 12, 15));
        vbox.setSpacing(15);
        GridPane cGrid = new GridPane();
        cGrid.setAlignment(Pos.CENTER);
        border.setCenter(cGrid);
        Scene scene = new Scene(border, 300, 275);
        final ToggleGroup group = new ToggleGroup();
   
        RadioButton rb1 = new RadioButton();
        RadioButton rb2 = new RadioButton();
        RadioButton rb3 = new RadioButton();
        
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
        
        Label title = new Label("Spørsmål");
        Text question = new Text();
        cGrid.add(question, 1, 1);
        cGrid.setGridLinesVisible(true);
        vbox.alignmentProperty();
        cGrid.add(title, 0, 0 ,2, 1);
       
        vbox.getChildren().addAll(rb1, rb2, rb3);
        vbox.setAlignment(Pos.CENTER);
        Button check = new Button("Check Answer");
        Button newQ = new Button ("New Question");
        vbox.getChildren().addAll(check, newQ);
        
        Text answer = new Text(); 
        Label aLabel = new Label("Answer:");
        cGrid.add(aLabel, 0, 3);
        cGrid.add(answer, 1, 3);
        
        
        
                
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public Stage loggedIn(){
        Stage stage2 = new Stage();
        stage2.setTitle("Logged In");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return stage2;
       
    }
        
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
