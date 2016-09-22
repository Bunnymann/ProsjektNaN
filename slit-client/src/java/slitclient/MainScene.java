/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.util.HashSet;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Sindre
 */
public class MainScene extends BorderPane{
    TextArea mainWindow;
    GridPane cGrid;
    HBox hboxBot;
    
    public MainScene(){
        Label mainWindowLabel = new Label("Hovedvindu");    
        mainWindow = new TextArea();
        cGrid = new GridPane();
        VBox vboxV = new VBox();
        VBox vboxH = new VBox();
        HBox hboxTop = new HBox();
        hboxBot = new HBox();
        vboxH.setPadding(new Insets(15, 15, 15, 15));
        vboxV.setPadding(new Insets(15, 15, 15, 15));
        hboxTop.setPadding(new Insets(10, 10, 10, 10));
        hboxTop.setSpacing(20.0);
        Button queue = new Button("Kø");
        Button modul = new Button("Moduler");
        Button bloggButton = new Button("Blogg");
        Button user = new Button("Brukere");
        //Label queueTODO = new Label("KØFUNKSJONENE KOMMER HER!!!!!!!!!");
        hboxTop.getChildren().addAll(queue, modul, bloggButton, user);
        hboxTop.setAlignment(Pos.CENTER);
        //vboxV.setAlignment(Pos.CENTER);
        cGrid.add(mainWindow, 0, 0);
        cGrid.add(mainWindowLabel, 0 , 0);
        //hboxBot.getChildren().add(queueTODO);
        hboxBot.setAlignment(Pos.TOP_CENTER);
        cGrid.setGridLinesVisible(true);
 
        this.setTop(hboxTop);
        this.setLeft(vboxV);
        this.setRight(vboxH);
        this.setCenter(cGrid);
        this.setBottom(hboxBot);
        
        
        user.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle (ActionEvent e) {
                setUserScene();
            }  
        });
        
        bloggButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle (ActionEvent e){
                setSceneBlogg();
                
            }
        });
        
        queue.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle (ActionEvent e){
                setSceneQueue();
        }
    });
        modul.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle (ActionEvent e){
                setSceneModul();
            }
            
        });
    }
    
    public void setUserScene(){
        //TODO Hent visning fra db via ejb
        TableView table = createTable("Elev", "Modul 1", "Modul n...");
        ToolBar userTb = createTb("Legg Til", "Fjern", "Kommenter");
        userTb.prefWidthProperty().bind(hboxBot.widthProperty());
        HBox toolsHbox = new HBox();
        userTb.setPadding(new Insets(10,10,10,10));
        toolsHbox.setAlignment(Pos.CENTER);
        toolsHbox.getChildren().add(userTb);
        this.setBottom(toolsHbox);
        //clear grid before adding new nodes
        cGrid.getChildren().removeAll();
        cGrid.add(table, 0 ,0);
        
    }
    
    public void setSceneBlogg(){
        TableView blogg = createTable("Elev", "Siste Modul", "Link");
        ToolBar bloggTb = createTb("Kommenter", "Velg", "Kontakt");
        bloggTb.prefWidthProperty().bind(hboxBot.widthProperty());
        HBox bloggBox = new HBox();
        bloggBox.getChildren().add(bloggTb);
        bloggTb.setPadding(new Insets(10,10,10,10));
        bloggBox.setAlignment(Pos.CENTER);
        this.setBottom(bloggBox);
        //clear grid before adding new nodes
        cGrid.getChildren().removeAll(); 
        cGrid.add(blogg, 0, 0);
    }
    
    public void setSceneQueue(){
        TableView queue = createTable("Elev", "Modul", "Dato");
        ToolBar queueTb = createTb("Vis", "Kommenter", "Godkjenn");
        cGrid.getChildren().add(queue);
        HBox hboxQueue = new HBox();
        queueTb.setPadding(new Insets(10,10,10,10));
        hboxQueue.getChildren().add(queueTb);
        queueTb.prefWidthProperty().bind(hboxQueue.widthProperty());
        hboxQueue.setAlignment(Pos.CENTER);
        this.setBottom(hboxQueue);
    }
    public void setSceneModul(){
        TableView modul = createTable("Modul", "InfoLink", "Innleverings Dato");
        ToolBar modulTb = createTb("Legg Til Modul", "Sett Innleverings Dato", 
                "Legg til Link");
        cGrid.getChildren().add(modul);
        HBox hboxModul = new HBox();
        modulTb.setPadding(new Insets(10,10,10,10));
        hboxModul.getChildren().add(modulTb);
        modulTb.prefWidthProperty().bind(hboxModul.widthProperty());
        hboxModul.setAlignment(Pos.CENTER);
        this.setBottom(hboxModul);
        
    }
    public TableView createTable(String col1, String col2, String col3 ){
        //TODO bruk et ubestemt antall parametere for generere kolonner 
        TableView table = new TableView();
        TableColumn c1 = new TableColumn(col1);
        TableColumn c2 = new TableColumn(col2);
        TableColumn c3 = new TableColumn(col3);
        table.getColumns().addAll(c1,c2,c3);
        return table;
    }
    
    public ToolBar createTb(String b1, String b2, String b3){
        Button button1 = new Button(b1);
        Button button2 = new Button(b2);
        Button button3 = new Button(b3);
        ToolBar tools = new ToolBar(button1, button2, button3);
        return tools;
        
    }
}
