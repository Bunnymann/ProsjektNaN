/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.KøDatamodel;
import DataModel.KøList;
import Database.Kø;
import Database.KøPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sindre
 */
@Stateless
public class QueueSessionBean implements QueueSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-ejbPU")
    private EntityManager em;

    public KøDatamodel convertToKøDM(Kø k) {
        KøDatamodel kDm = new KøDatamodel();
        KøPK kP = k.getKøPK();
        kDm.setInnlevID(kP.getInnlevID());
        kDm.setDato(kP.getDato());

        return kDm;

    }

    public List getQueue() {
        List queueList = em.createNamedQuery("Kø.findAll", Kø.class).getResultList();
        return queueList;
    }

    @Override
    public KøList getQueuePojo() {
        KøList kLpojo = new KøList();
        ArrayList<KøDatamodel> kD = new ArrayList();
        List<Kø> køEntityList = getQueue();
        System.out.println(køEntityList.iterator().next().toString());
        for (Kø k : køEntityList) {
            System.out.print(k);
            kD.add(this.convertToKøDM(k));
        }
        kLpojo.setKøList(kD);
        return kLpojo;
    }

    public void persist(Object object) {
        em.persist(object);
    }

}
