/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.BesvarelseDataModel;
import Database.Besvarelse;
import java.sql.Date;
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
    
    @Override
    public BesvarelseDataModel getBesvarelseById(int id) {
        Besvarelse besvarelse = em.find(Besvarelse.class, id);
        return convertBesvarelse(besvarelse);
    }
    
    public BesvarelseDataModel convertBesvarelse(Besvarelse besvarelse) {
        BesvarelseDataModel besvarelseData = new BesvarelseDataModel();
        besvarelseData.setBesvarelseID(besvarelse.getBesvarelseID());
        besvarelseData.setDato(besvarelse.getDato());

        return besvarelseData;
    }
    
    public Besvarelse convertToBesvarelseEntity(BesvarelseDataModel m) {
        Besvarelse newBesvarelse = new Besvarelse();
        newBesvarelse.setBesvarelseID(m.getBesvarelseID());
        newBesvarelse.setDato(m.getDato());
        return newBesvarelse;
    }
    
    public void createBesvarelse(int id, Date dato) {
        Besvarelse besvarelseEntity = new Besvarelse();

        besvarelseEntity.setBesvarelseID(id);
        besvarelseEntity.setDato(dato);

        persist(besvarelseEntity);
    }

    @Override
    public String testMethod() {
        return "This is a test";
    }
    
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void createBesvarelse(int id, String dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}