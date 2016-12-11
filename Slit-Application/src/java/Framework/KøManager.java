/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.BesvarelseDataModel;
import DataModel.KøList;
import Server.QueueSessionBeanRemote;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Sindre
 */
public class KøManager {

    private QueueSessionBeanRemote lookupQueueSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (QueueSessionBeanRemote) c.lookup("java:global/Slit-ejb/QueueSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public ArrayList getQueueList() {
        return this.lookupQueueSessionBeanRemote().getQueuePojo().getKøList();
    }

    public BesvarelseDataModel getInnleveringFromList(KøList kL, Integer innID) {
        if (kL.containsInnlevID(kL.getKøList(), innID)) {
            BesvarelseManager bManager = new BesvarelseManager();
            bManager.getInnleveringByID(innID)
        }
    }
}
