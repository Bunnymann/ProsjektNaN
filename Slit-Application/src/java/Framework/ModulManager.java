/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.ModulDataModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import Server.ModulSessionBeanRemote;

/**
 *
 * @author Sindre
 */
public class ModulManager {
        
    private ModulSessionBeanRemote lookupModulSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (ModulSessionBeanRemote) c.lookup("java:global/Slit-ejb/ModulSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public ModulDataModel getModulById(int id){
        return this.lookupModulSessionBeanRemote().getModulById(id);
    }
    
    public String getModulName(int id){
        return this.lookupModulSessionBeanRemote().getModulById(id).getModulName();
    }
    
    public void createModul(int id, String name, String desc){
        ModulSessionBeanRemote bean = this.lookupModulSessionBeanRemote();
        bean.createModul(id, name, desc);
    }
}
