/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.BesvarelseDataModel;
import Server.InnleveringSessionBeanRemote;
import Server.ProgressSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Marius
 */
public class BesvarelseManager {

    private InnleveringSessionBeanRemote lookupInnleveringSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (InnleveringSessionBeanRemote) c.lookup("java:global/Slit-ejb/InnleveringSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void createBesvarelse(BesvarelseDataModel m) {
        this.lookupInnleveringSessionBeanRemote().createBesvarelse(m);
    }

    public BesvarelseDataModel getInnleveringByID(int id) {
        return this.lookupInnleveringSessionBeanRemote().getBesvarelse(id);
    }

    public String getStudentName(int pk) {
        return this.lookupInnleveringSessionBeanRemote().getInnleveringStudentName(pk);
    }

    private ProgressSessionBeanRemote lookupProgressSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (ProgressSessionBeanRemote) c.lookup("java:comp/env/ProgressSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void test1() {
        this.lookupProgressSessionBeanRemote().test1();
    }

}
