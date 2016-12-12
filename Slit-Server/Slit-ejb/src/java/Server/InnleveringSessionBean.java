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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marius
 */
@Stateless
public class InnleveringSessionBean implements InnleveringSessionBeanRemote {

    @EJB
    private QueueSessionBeanRemote queueSessionBean;

    @PersistenceContext(unitName = "Slit-ejbPU")
    private EntityManager em;

    @Override
    public BesvarelseDataModel getBesvarelseById(int id) {
        Innlevering besvarelse = em.find(Innlevering.class, id);
        return convertBesvarelse(besvarelse);
    }

    @Override
    public List<BesvarelseDataModel> getBesvarelse() {
        List<BesvarelseDataModel> dataBesvarelse = new ArrayList<BesvarelseDataModel>();

        try {
            Query query = em.createNamedQuery("Module.findAll", Innlevering.class);

            List<Innlevering> besvarelser = query.getResultList();

            for (Innlevering besvarelse : besvarelser) {
                dataBesvarelse.add(this.convertBesvarelse(besvarelse));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataBesvarelse;
    }

    @Override
    public BesvarelseDataModel getBesvarelse(int id) {
        Innlevering besvarelse = em.find(Innlevering.class, id);

        return this.convertBesvarelse(besvarelse);
    }

    public BesvarelseDataModel convertBesvarelse(Innlevering besvarelse) {
        BesvarelseDataModel besvarelseData = new BesvarelseDataModel();
        besvarelseData.setBesvarelseID(besvarelse.getBesvarelseID());
        besvarelseData.setDato(besvarelse.getDato());

        return besvarelseData;
    }

    public Innlevering convertToBesvarelseEntity(BesvarelseDataModel m) {
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
        Innlevering innlev = convertToBesvarelseEntity(m);
        addInnleveringToQueue(innlev);
        persist(innlev);
    }

    @Override
    public String testMethod() {
        return "This is a test";
    }
<<<<<<< HEAD
    
    @Override
=======

>>>>>>> 80d8869ed9b9e522287a2378305bb94f48ef7ddf
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
