/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Sindre
 */
public class UserScene extends BorderPane {

    private HBox userHboxBot;
    private ToolBar userTb;
    private TableView userTable;
    private GridPane userGrid;

    public UserScene() {
        //TODO Hent visning fra db via ejb
        userTable = MainScene.createTable("Elev", "Modul 1", "Modul n...");
        userTb = MainScene.createTb("Legg Til", "Fjern", "Kommenter");
        userTb.prefWidthProperty().bind(userHboxBot.widthProperty());
        HBox toolsHbox = new HBox();
        userTb.setPadding(new Insets(10, 10, 10, 10));
        toolsHbox.setAlignment(Pos.CENTER);
        toolsHbox.getChildren().add(userTb);
        this.setBottom(toolsHbox);
        //clear grid before adding new nodes
        this.userGrid = new GridPane();
        userGrid.getChildren().removeAll();
        userGrid.add(userTable, 0, 0);
    }

}
