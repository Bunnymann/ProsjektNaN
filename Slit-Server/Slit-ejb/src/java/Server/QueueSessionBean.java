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

    public Kø convertToKøEntity(KøDatamodel køModel) {
        KøPK køEntityPK = new KøPK();

        køEntityPK.setInnlevID(køModel.getInnlevID());
        køEntityPK.setDato(køModel.getDato());

        Kø køEntity = new Kø(køEntityPK);
        return køEntity;

    }

    public List getQueue() {
        return em.createNamedQuery("Kø.findAll", Kø.class).getResultList();
    }

    @Override
    public KøList getQueuePojo() {
        KøList kLpojo = new KøList();
        List<Kø> køEntityList = getQueue();
        for (Kø k : køEntityList) {
            kLpojo.getKøList().add(this.convertToKøDM(k));
        }
        return kLpojo;
    }

    @Override
    public void updateKø(KøDatamodel kD) {
        em.remove(this.convertToKøEntity(kD));
    }

    @Override
    public KøDatamodel getFromQueue(KøList kø, int id) {
        KøDatamodel result = new KøDatamodel();
        if (kø.containsInnlevID(kø.getKøList(), id)) {
            result = this.convertToKøDM(em.find(Kø.class, id));
        } else {
            System.out.println("Not found");
        }
        return result;

    }

    public void persist(Object object) {
        em.persist(object);
    }

}
