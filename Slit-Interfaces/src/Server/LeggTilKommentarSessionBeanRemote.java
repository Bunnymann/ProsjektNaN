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

    TilbakemeldingDataModel getTilbakemelding(int id);

    void addLærerMld(int meldingId, String lærerMld);

    void addStatusMld(int meldingId, String statusMld);

    void addStudentMld(int meldingId, String studentMld);

    void createTilbakemelding(int meldingId, String lærerMld, String statusMld, String studentMld);

    void updateTilbakemelding(int meldingId, String lærerMld, String statusMld, String studentMld);

    void connectToInnlevering(int meldingId, int bId);
}
