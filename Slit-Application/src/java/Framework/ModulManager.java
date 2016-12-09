/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.ModulDataModel;
import Server.ModulSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Sindre
 */
public class ModulManager {

    /*private ModulSessionBeanRemote lookupModulSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (ModulSessionBeanRemote) c.lookup("java:global/Slit-ejb/ModulSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }*/
    public ModulDataModel getModul(int id) {
        System.out.println("manager.getModul Called");
        return this.lookupModulSessionBeanRemote().getModulById(id);
    }

    public String getModulName(int id) {
        System.out.println("get Name called");
        return this.lookupModulSessionBeanRemote().getModulById(id).getModulname();

    }

    public void createModul(int id, String name, String desc, String frist, String kriterier, int quizID) {
        ModulSessionBeanRemote bean = this.lookupModulSessionBeanRemote();
        bean.createModul(id, name, desc, frist, kriterier, quizID);
    }

    public String returnTest() {
        return this.lookupModulSessionBeanRemote().testMethod();
    }

    private ModulSessionBeanRemote lookupModulSessionBeanRemote() {
        try {
            System.out.println("Lookup Called");
            Context c = new InitialContext();
            return (ModulSessionBeanRemote) c.lookup("java:global/Slit-ejb/ModulSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public String modulBean(int id){
     return this.lookupModulSessionBeanRemote().getModulById(1).getModuldesc();
    
    }
    
}
