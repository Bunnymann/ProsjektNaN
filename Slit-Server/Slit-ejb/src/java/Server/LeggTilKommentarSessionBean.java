/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;


import DataModel.TilbakemeldingDataModel;
import Database.Tilbakemelding;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 *
 * @author Ola
 */
@Stateless
public class LeggTilKommentarSessionBean implements LeggTilKommentarSessionBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

@PersistenceContext(unitName = "Slit-ejbPU")
private EntityManager em; 

    @Override
    public TilbakemeldingDataModel getTilbakemeldingById (int id){
        Tilbakemelding tilbakemelding = em.find(Tilbakemelding.class, id);
        return convertTilbakemelding (tilbakemelding);
    
}

    public TilbakemeldingDataModel convertTilbakemelding (Tilbakemelding tilbakemelding) {
        TilbakemeldingDataModel tilbakemeldingData = new TilbakemeldingDataModel() ;
        tilbakemeldingData.setMeldingID (tilbakemelding.getMeldingID());
        tilbakemeldingData.setStatusMld (tilbakemelding.getStatusMld());
        tilbakemeldingData.setStudentMld (tilbakemelding.getStudentMld());
        tilbakemeldingData.setLærerMld (tilbakemelding.getLærerMld());
    
        return tilbakemeldingData;
}
    public Tilbakemelding convertToTilbakemeldingEntity(TilbakemeldingDataModel tm){
        Tilbakemelding newTilbakemelding = new Tilbakemelding();
        newTilbakemelding.setMeldingID(tm.getMeldingID());
        newTilbakemelding.setStatusMld(tm.getStatusMld());
        newTilbakemelding.setLærerMld(tm.getLærerMld());
        newTilbakemelding.setStudentMld(tm.getStudentMld());
        return newTilbakemelding;
        
    }
    
    public leggTilLærerMld(int meldingId, String lærerMld); {
    
}
}

