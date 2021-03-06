/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.BesvarelseDataModel;
import DataModel.K�Datamodel;
import DataModel.K�List;
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
public class K�Manager {

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
        return this.lookupQueueSessionBeanRemote().getQueuePojo().getK�List();
    }

    public BesvarelseDataModel getInnleveringFromList(K�List kL, Integer innID) {
        BesvarelseDataModel bDm = null;
        if (kL.containsInnlevID(kL.getK�List(), innID)) {
            BesvarelseManager bManager = new BesvarelseManager();
            bDm = bManager.getInnleveringByID(innID);
        }
        return bDm;
    }

    public K�List getQueue() {
        return this.lookupQueueSessionBeanRemote().getQueuePojo();

    }

    public K�Datamodel getFromQueue(K�List k�, int id) {
        return this.lookupQueueSessionBeanRemote().getFromQueue(k�, id);
    }

    public void updateQueue(K�Datamodel k�Model) {
        this.lookupQueueSessionBeanRemote().updateK�(k�Model);
    }
}
