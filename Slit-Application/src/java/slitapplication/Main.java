/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

<<<<<<< HEAD
import Framework.TilbakmeldingManager;
=======
import Framework.K�Manager;
>>>>>>> develop

/**
 *
 * @author Sindre
 */
public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD

        //BesvarelseManager manager = new BesvarelseManager();
        //System.out.println(manager.getModulName(1));
        //System.out.println(manager.testMethod());
        TilbakmeldingManager manager = new TilbakmeldingManager();
        
        manager.kobleTbTilBesvar(6,2);
        
        //System.out.println(manager.getTilbakemeldingById(7).toString());
        //manager.leggTilL�rerMld(7, "Hei p� deg, dette fungerer.");
        //manager.leggTilStudentMld(7, "dette fungerte ogs�");
         //manager.oppretteTb(9, "godkjent fack yeah", "du greide det.", "ubrukelig");

        //BesvarelseManager manager = new BesvarelseManager();
        //Date d1 = Calendar.getInstance().getTime();
        //BesvarelseDataModel test = new BesvarelseDataModel (5,d1,5,2,5);
        
        //manager.createBesvarelse(test);
        //Date d1 = Calendar.getInstance().getTime();
        //BesvarelseDataModel test = new BesvarelseDataModel(5, d1, 5, 2, 5);
        
        //manager.createBesvarelse(test);

=======
        K�Manager manager = new K�Manager();
        System.out.println(manager.getQueueList().get(1).toString());
>>>>>>> develop

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
