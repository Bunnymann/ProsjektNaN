/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.TilbakemeldingDataModel;
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
  
    public TilbakemeldingDataModel getTilbakemeldingById(int id) {
        return this.lookupLeggTilKommentarSessionBeanRemote().getTilbakemeldingById(id);
    }
           
    public void leggTilL�rerMld(int meldingId, String l�rerMld) {
        LeggTilKommentarSessionBeanRemote bean = this.lookupLeggTilKommentarSessionBeanRemote();
        bean.leggTilL�rerMld (meldingId, l�rerMld);
    }
    
    public void leggTilStatusMld (int meldingId, String statusMld) {
        LeggTilKommentarSessionBeanRemote bean = this.lookupLeggTilKommentarSessionBeanRemote();
        bean.leggTilStatusMld (meldingId, statusMld);
    }
    
    public void leggTilStudentMld (int meldingId, String studentMld){
        LeggTilKommentarSessionBeanRemote bean = this.lookupLeggTilKommentarSessionBeanRemote();
        bean.leggTilStudentMld(meldingId, studentMld);
    }
    
    public void oppdatereTb (Integer meldingId, String statusMld, String studentMld, String l�rerMld) {
        LeggTilKommentarSessionBeanRemote bean = this.lookupLeggTilKommentarSessionBeanRemote();
        bean.oppdatereTb(meldingId, l�rerMld, statusMld, studentMld);
    }
    
    public void kobleTbTilBesvar (Integer bId, TilbakemeldingDataModel tb) {
        this.lookupLeggTilKommentarSessionBeanRemote().kobleTbTilBesvar(bId, tb);
    }
}
