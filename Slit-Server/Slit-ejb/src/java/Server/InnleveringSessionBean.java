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
import Database.Student;
import Database.Tilbakemelding;
import java.sql.Date;
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

    /*
    Henter alle besvarelser fra databasen
    */
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
    
    /*
    Henter en besvarelse fra parameter int id
    @param id - ønsket besvarelse
    @return - returner besvarelsen
    */
    @Override
    public BesvarelseDataModel getBesvarelse(int id) {
        Innlevering besvarelse = em.find(Innlevering.class, id);

        return this.convertBesvarelse(besvarelse);
    }

    /*
    Konverterer en besvarelse fra databasen til et objekt
    @param besvarelse - ønsket besvarelse
    @return - returnerer en besvarelsedatamodel  
    */
    public BesvarelseDataModel convertBesvarelse(Innlevering besvarelse) {
        BesvarelseDataModel besvarelseData = new BesvarelseDataModel();
        besvarelseData.setBesvarelseID(besvarelse.getBesvarelseID());
        besvarelseData.setDato(besvarelse.getDato());

        return besvarelseData;
    }
    
    /*
    Konvereter en besvarelse til databasen
    @param m - en besvarelsedatamodel
    @return - returnerer opprettet besvarelse 
    */
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

    /*
    Finner navnet til studenten som har levert en besvarelse
    @param pk - primærnøkkelen i besvarelsen
    @return - returnerer studentens navn
    */
    @Override
    public String getInnleverigStudentName(int pk) {
        Bruker b = em.find(Innlevering.class, pk).getBrukerID();
        return (b.getForNavn() + " " + b.getEtterNavn());       
    }
    
    /*
    Finner fornavnet, hvilken besvarelse og modul og status på besvarelen
    @param pk - primørnøkkelen i besvarelsen
    @return - returnerer forNavn, besvarelseID, modulID og statusMelding
    */
    @Override
    public String getModulFremdridt(int pk){
        Innlevering i = em.find(Innlevering.class, pk);
        String navn = i.getBrukerID().getForNavn();
        Integer besv = i.getBesvarelseID();
        Integer modul = i.getModulID().getModulID();
        String tm = i.getMeldingID().getStatusMld();
        
        return (navn + " " + besv + " " + modul + " " +  tm);
    } 
            
    /*
    Oppretter en besvarelse
    @param m - besvarelsedatamodel
    */
    @Override
    public void createBesvarelse(BesvarelseDataModel m) {
        Innlevering innlev = convertToBesvarelseEntity(m);
        addInnleveringToQueue(innlev);
        persist(innlev);
    }

    /*
    Test metode
    @returner String
    */
    @Override
    public String testMethod() {
        return "This is a test";
    }
    
    @Override
    public void persist(Object object) {
        em.persist(object);
    }

    /*
    Legger innlevering i kø
    @param inn - innleveringsobjekt
    */
    public void addInnleveringToQueue(Innlevering inn) {
        KøPK kPk = new KøPK();
        kPk.setInnlevID(inn.getBesvarelseID());
        kPk.setDato(inn.getDato());
        Kø kø = new Kø(kPk);
        persist(kø);

    }
}
