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
    public TilbakemeldingDataModel getTilbakemelding(int id) {
        return convertToPojo(em.find(Tilbakemelding.class, id));

    }

    public TilbakemeldingDataModel convertToPojo(Tilbakemelding tilbakemelding) {
        TilbakemeldingDataModel tilbakemeldingData = new TilbakemeldingDataModel();
        tilbakemeldingData.setMeldingID(tilbakemelding.getMeldingID());
        tilbakemeldingData.setStatusMld(tilbakemelding.getStatusMld());
        tilbakemeldingData.setStudentMld(tilbakemelding.getStudentMld());
        tilbakemeldingData.setLærerMld(tilbakemelding.getLærerMld());

        return tilbakemeldingData;
    }

    public Tilbakemelding convertToEntity(TilbakemeldingDataModel tm) {
        Tilbakemelding newTilbakemelding = new Tilbakemelding();
        newTilbakemelding.setMeldingID(tm.getMeldingID());
        newTilbakemelding.setStatusMld(tm.getStatusMld());
        newTilbakemelding.setLærerMld(tm.getLærerMld());
        newTilbakemelding.setStudentMld(tm.getStudentMld());
        return newTilbakemelding;

    }

    @Override
    public void addLærerMld(int meldingId, String lærerMld) {
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();

        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setLærerMld(lærerMld);

        persist(tilbakemeldingEntity);
    }

    @Override
    public void addStatusMld(int meldingId, String statusMld) {
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();

        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setStatusMld(statusMld);

        persist(tilbakemeldingEntity);
    }

    @Override
    public void addStudentMld(int meldingId, String studentMld) {
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();

        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setStudentMld(studentMld);

        persist(tilbakemeldingEntity);
    }

    @Override
    public void createTilbakemelding(int meldingId, String lærerMld, String statusMld, String studentMld) {
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();

        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setLærerMld(lærerMld);
        tilbakemeldingEntity.setStatusMld(statusMld);
        tilbakemeldingEntity.setStudentMld(studentMld);

        persist(tilbakemeldingEntity);
    }

    @Override
    public void updateTilbakemelding(int meldingId, String lærerMld, String statusMld, String studentMld) {
        Tilbakemelding tilbakemeldingEntity = em.find(Tilbakemelding.class, meldingId);

        tilbakemeldingEntity.setLærerMld(lærerMld);
        tilbakemeldingEntity.setStatusMld(statusMld);
        tilbakemeldingEntity.setStudentMld(studentMld);

        persist(tilbakemeldingEntity);
    }

    @Override
    public void connectToInnlevering(int meldingId, int bId) {
        Tilbakemelding tilbakemeldingEntity = em.find(Tilbakemelding.class, meldingId);
        Innlevering innleveringEntity = em.find(Innlevering.class, bId);
        innleveringEntity.setMeldingID(tilbakemeldingEntity);

        persist(tilbakemeldingEntity);
    }

    /*@Override
    public void leggTilBesvarList (int meldingId, int besvarelseId) {
        Tilbakemelding tilbakemeldingEntity = em.find(Tilbakemelding.class, meldingId);
        Innlevering innleveringEntity = em.find(Innlevering.class, besvarelseId);
        List <Innlevering> innlevering = new ArrayList <Innlevering>();
        innlevering.add(meldingId);
    }
     */
    public void persist(Object object) {
        em.persist(object);
    }

}
