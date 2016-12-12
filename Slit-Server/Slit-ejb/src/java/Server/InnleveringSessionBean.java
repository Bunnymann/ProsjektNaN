/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.BesvarelseDataModel;
import Database.Bruker;
import Database.Innlevering;
import Database.Modul;
import Database.Student;
import Database.Tilbakemelding;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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

    @PersistenceContext(unitName = "Slit-ejbPU")
    private EntityManager em;
    
    @Override
    public BesvarelseDataModel getBesvarelseById(int id) {
        Innlevering besvarelse = em.find(Innlevering.class, id);
        return convertBesvarelse(besvarelse);
    }
    
    @Override
    public List<BesvarelseDataModel> getBesvarelse()
    {
        List<BesvarelseDataModel> dataBesvarelse = new ArrayList<BesvarelseDataModel>();
        
        try
        {
            Query query = em.createNamedQuery("Module.findAll", Innlevering.class);
            
            List<Innlevering> besvarelser = query.getResultList();
            
                for(Innlevering besvarelse : besvarelser)
                {
                    dataBesvarelse.add(this.convertBesvarelse(besvarelse));          
                }
        }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return dataBesvarelse;
        }
    
    @Override
    public BesvarelseDataModel getBesvarelse(int id)
    {
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
        newBesvarelse.setMeldingID(em.find(Tilbakemelding.class, m.getMeldingID()));
        return newBesvarelse;
    }
    
    @Override
    public void createBesvarelse(BesvarelseDataModel m) {
        persist(this.convertToBesvarelseEntity(m));
    }

    @Override
    public String testMethod() {
        return "This is a test";
    }
    
    @Override
    public void persist(Object object) {
        em.persist(object);
    }
}