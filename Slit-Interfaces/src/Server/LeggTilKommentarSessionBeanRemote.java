/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.TilbakemeldingDataModel;
import javax.ejb.Remote;

/**
 *
 * @author Ola
 */
@Remote
public interface LeggTilKommentarSessionBeanRemote {
    TilbakemeldingDataModel getTilbakemeldingById (int id);
    
     void leggTilLærerMld(int meldingId, String lærerMld);
     
     void leggTilStatusMld (int meldingId, String statusMld);
     
     void leggTilStudentMld (int meldingId, String studentMld);
     
     void oppretteTb (int meldingId, String lærerMld, String statusMld, String studentMld);
     
     void oppdatereTb (int meldingId, String lærerMld, String statusMld, String studentMld);
}
