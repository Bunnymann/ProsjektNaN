/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.BesvarelseDataModel;
import Database.Bruker;
import Database.Innlevering;
import Database.Kø;
import Database.KøPK;
import Database.Modul;
import Database.Tilbakemelding;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marius
 */
@Stateless
public class InnleveringSessionBean implements InnleveringSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-ejbPU")
    private EntityManager em;

    public Innlevering getBesvarelseById(int id) {
        return em.find(Innlevering.class, id);

    }

    @Override
    public BesvarelseDataModel getBesvarelse(int id) {
        return convertToPojo(getBesvarelseById(id));
    }

    public BesvarelseDataModel convertToPojo(Innlevering besvarelse) {
        BesvarelseDataModel besvarelseData = new BesvarelseDataModel();
        besvarelseData.setBesvarelseID(besvarelse.getBesvarelseID());
        besvarelseData.setDato(besvarelse.getDato());

        return besvarelseData;
    }

    public Innlevering convertToEntity(BesvarelseDataModel m) {
        Innlevering newBesvarelse = new Innlevering();
        newBesvarelse.setBesvarelseID(m.getBesvarelseID());
        newBesvarelse.setDato(m.getDato());
        newBesvarelse.setBrukerID(em.find(Bruker.class, m.getBrukerID()));
        newBesvarelse.setModulID(em.find(Modul.class, m.getIdmodul()));
        if (m.getMeldingID() != null) {
            newBesvarelse.setMeldingID(em.find(Tilbakemelding.class, m.getMeldingID()));
        }
        return newBesvarelse;
    }

    @Override
    public void createBesvarelse(BesvarelseDataModel m) {
        Innlevering innlev = convertToEntity(m);
        addInnleveringToQueue(innlev);
        persist(innlev);
    }

    @Override
    public String testMethod() {
        return "This is a test";
    }

    @Override
    public String getInnleveringStudentName(int pk) {
        return em.find(Innlevering.class, pk).getMeldingID().getStatusMld();
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public void addInnleveringToQueue(Innlevering inn) {
        KøPK kPk = new KøPK();
        kPk.setInnlevID(inn.getBesvarelseID());
        kPk.setDato(inn.getDato());
        Kø kø = new Kø(kPk);
        persist(kø);

    }
}
