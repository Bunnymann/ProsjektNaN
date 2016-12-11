/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;


import DataModel.TilbakemeldingDataModel;
import Database.Innlevering;
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
    
    @Override
    public void leggTilLærerMld(int meldingId, String lærerMld) {
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();
        
        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setLærerMld(lærerMld);
        
        persist(tilbakemeldingEntity);
    }

    @Override
    public void leggTilStatusMld (int meldingId, String statusMld) {
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();
        
        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setStatusMld(statusMld);
        
        persist (tilbakemeldingEntity);
    }
    
    @Override
    public void leggTilStudentMld (int meldingId, String studentMld){
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();
        
        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setStudentMld(studentMld);
        
        persist (tilbakemeldingEntity);
    }
    
    @Override
    public void oppretteTb (int meldingId, String lærerMld, String statusMld, String studentMld) {
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();
        
        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setLærerMld(lærerMld);
        tilbakemeldingEntity.setStatusMld(statusMld);
        tilbakemeldingEntity.setStudentMld(studentMld);
        
        persist (tilbakemeldingEntity);
    }
    
    @Override
    public void oppdatereTb (int meldingId, String lærerMld, String statusMld, String studentMld) {
        Tilbakemelding tilbakemeldingEntity  = em.find(Tilbakemelding.class, meldingId);
 
            tilbakemeldingEntity.setLærerMld(lærerMld);
            tilbakemeldingEntity.setStatusMld(statusMld);
            tilbakemeldingEntity.setStudentMld(studentMld);
            
        persist (tilbakemeldingEntity);
    }
    
    @Override
    public void kobleTbTilBesvar (int meldingId, int bId) {
        Tilbakemelding tilbakemeldingEntity = em.find(Tilbakemelding.class, meldingId);
        Innlevering innleveringEntity = em.find(Innlevering.class, bId);
        innleveringEntity.setMeldingID(tilbakemeldingEntity);
     
        persist (tilbakemeldingEntity);
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
}

