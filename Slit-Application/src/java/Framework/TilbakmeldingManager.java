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
        return this.lookupLeggTilKommentarSessionBeanRemote().getTilbakemelding(id);
    }

    public void leggTilLærerMld(int meldingId, String lærerMld) {
        LeggTilKommentarSessionBeanRemote bean = this.lookupLeggTilKommentarSessionBeanRemote();
        bean.addLærerMld(meldingId, lærerMld);
    }

    public void leggTilStatusMld(int meldingId, String statusMld) {
        LeggTilKommentarSessionBeanRemote bean = this.lookupLeggTilKommentarSessionBeanRemote();
        bean.addStatusMld(meldingId, statusMld);
    }

    public void leggTilStudentMld(int meldingId, String studentMld) {
        LeggTilKommentarSessionBeanRemote bean = this.lookupLeggTilKommentarSessionBeanRemote();
        bean.addStudentMld(meldingId, studentMld);
    }

    public void oppdatereTb(Integer meldingId, String statusMld, String studentMld, String lærerMld) {
        LeggTilKommentarSessionBeanRemote bean = this.lookupLeggTilKommentarSessionBeanRemote();
        bean.updateTilbakemelding(meldingId, lærerMld, statusMld, studentMld);
    }

    public void kobleTbTilBesvar(Integer bId, int tb) {
        this.lookupLeggTilKommentarSessionBeanRemote().connectToInnlevering(bId, tb);
    }
}
