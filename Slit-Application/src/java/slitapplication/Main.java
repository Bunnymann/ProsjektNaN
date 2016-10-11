/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import SlitServer.StudentListRemote;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Sindre
 */
public class Main { // extends Application {

    @EJB
    static StudentListRemote studentList;
    //Parent root;
    //Scene scene;
    //Stage primaryStage;

    /*@Override
    public void start(Stage primaryStage) {
        Parent root = new MainScene();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("SLIT");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     */
    public static void main(String[] args) {
        // test1 before set method is called
        System.out.println(studentList.getTest1());
        studentList.setTest1("Test Satt");
        System.out.println(studentList.getTest1());

        //launch(args);
    }

    public static void printStudentList() {
        List<String> students = studentList.getStudents();
        System.out.println(students);
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
