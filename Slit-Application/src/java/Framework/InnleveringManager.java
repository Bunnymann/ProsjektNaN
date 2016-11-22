/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.InnleveringDataModel;
import Server.InnleveringSessionBeanRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Marius
 */
public class InnleveringManager {

    private InnleveringSessionBeanRemote lookupInnleveringSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (InnleveringSessionBeanRemote) c.lookup("java:global/Slit-ejb/InnleveringSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public void createInnlevering(InnleveringDataModel m)
    {
        this.lookupInnleveringSessionBeanRemote().createInnlevering(m);
    }
    
    public String testMethod(){
        return this.lookupInnleveringSessionBeanRemote().testMethod();
    }
    
    public List<InnleveringDataModel> findAll(){
        return this.lookupInnleveringSessionBeanRemote().getAllInnlevering();
    }
    
    
    
    
}
