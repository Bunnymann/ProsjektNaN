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

    /**
     * henter ut tilbakemeldings objekt ut i fra DB ved hjelp av ID
     *
     * Hentet ut tilbakemeldings objektet. returnerer objektet som ble hentet
     * ut.
     *
     * @param id
     * @return
     */
    public Tilbakemelding getTilbakemeldingById(int id) {
        return em.find(Tilbakemelding.class, id);

    }

    @Override
    public TilbakemeldingDataModel getTilbakemelding(int id) {
        return convertToPojo(em.find(Tilbakemelding.class, id));
    }

    /**
     * Konverterer fra DB objekt til pojo returnere objektet.
     *
     * @param tilbakemelding
     * @return
     */
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

    /**
     * legg til ny lærer melding.
     *
     * @param meldingId
     * @param lærerMld
     */
    @Override
    public void addLærerMld(int meldingId, String lærerMld) {
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();

        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setLærerMld(lærerMld);

        persist(tilbakemeldingEntity);
    }

    /**
     * Legg til ny status melding.
     *
     * @param meldingId
     * @param statusMld
     */
    @Override
    public void addStatusMld(int meldingId, String statusMld) {
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();

        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setStatusMld(statusMld);

        persist(tilbakemeldingEntity);
    }

    /**
     * Legg til ny student melding.
     *
     * @param meldingId
     * @param studentMld
     */
    @Override
    public void addStudentMld(int meldingId, String studentMld) {
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();

        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setStudentMld(studentMld);

        persist(tilbakemeldingEntity);
    }

    /**
     * Opprette et nytt tilbakemeldings objekt.
     *
     * bruke entity manager til å lage et nytt tilbakemeldings objekt. settet
     * meldingId setter lærerMld setter statusMld Setter studentMld returnerer
     * objektet som ble laget.
     *
     * @param meldingId
     * @param lærerMld
     * @param statusMld
     * @param studentMld
     * @return
     */
    @Override
    public void createTilbakemelding(int meldingId, String lærerMld, String statusMld, String studentMld) {
        Tilbakemelding tilbakemeldingEntity = new Tilbakemelding();

        tilbakemeldingEntity.setMeldingID(meldingId);
        tilbakemeldingEntity.setLærerMld(lærerMld);
        tilbakemeldingEntity.setStatusMld(statusMld);
        tilbakemeldingEntity.setStudentMld(studentMld);
        persist(tilbakemeldingEntity);
    }

    /**
     * Oppdaterer et eksisterende tilbakemelings objekt.
     *
     * Henter objektet man vil oppdatere. settet ny lærerMld setter ny statusMld
     * setter ny studentMld lagrer i DB
     *
     * @param meldingId
     * @param lærerMld
     * @param statusMld
     * @param studentMld
     */
    @Override
    public void updateTilbakemelding(int meldingId, String lærerMld, String statusMld, String studentMld) {
        Tilbakemelding tilbakemeldingEntity = em.find(Tilbakemelding.class, meldingId);
        tilbakemeldingEntity.setLærerMld(lærerMld);
        tilbakemeldingEntity.setStatusMld(statusMld);
        tilbakemeldingEntity.setStudentMld(studentMld);

        persist(tilbakemeldingEntity);
    }

    /**
     * Kobler tilbakemelding til et innleverings objekt.
     *
     * Henter innleverings objekter. lager et nytt tilbakemelding objekt legger
     * til tilbakemelding til innlevering. lagrer i DB
     *
     * @param bId
     * @param tb
     */
    @Override
    public void connectToInnlevering(int meldingId, int bId) {
        Tilbakemelding tilbakemeldingEntity = em.find(Tilbakemelding.class, meldingId);
        Innlevering innleveringEntity = em.find(Innlevering.class, bId);
        innleveringEntity.setMeldingID(tilbakemeldingEntity);

        persist(tilbakemeldingEntity);
    }

    public void persist(Object object) {
        em.persist(object);
    }

}
