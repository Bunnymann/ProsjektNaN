/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import Server.LeggTilKommentarSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Ola
 */
public class TilbakmeldingManager {

    private LeggTilKommentarSessionBeanRemote lookupLeggTilKommentarSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (LeggTilKommentarSessionBeanRemote) c.lookup("java:comp/env/LeggTilKommentarSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
