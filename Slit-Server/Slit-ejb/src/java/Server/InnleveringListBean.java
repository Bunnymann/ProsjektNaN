/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.InnleveringDataModel;
import Database.Innlevering;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sindre
 */
@Stateless
public class InnleveringListBean implements InnleveringListBeanRemote {

    @PersistenceContext(unitName = "Slit-ejbPU")
    private EntityManager em;

    
    public List getAllInnlevering(){
       Query query = em.createNamedQuery("Innlevering.findAll");
       List <Innlevering> qList = query.getResultList();
       ArrayList <Innlevering> arrayInn = new ArrayList();
       for (Innlevering innl : qList){
           arrayInn.add(innl);
           return arrayInn;
       }
       return arrayInn;
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
