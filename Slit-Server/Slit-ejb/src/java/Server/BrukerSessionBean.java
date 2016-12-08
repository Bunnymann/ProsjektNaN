/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.BrukerDataModel;
import Database.Bruker;
import Database.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sindre
 */
@Stateless
public class BrukerSessionBean implements BrukerSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Bruker getBrukerByID(int id) {
        Bruker bruker = em.find(Bruker.class, id);
        return bruker;
    }

    public BrukerDataModel convertToBrukerPojo(Bruker b) {
        BrukerDataModel bDm = new BrukerDataModel();
        bDm.setBrukerID(b.getBrukerID());
        bDm.setForNavn(b.getForNavn());
        bDm.setEtterNavn(b.getEtterNavn());
        bDm.setEmail(b.getEmail());
        bDm.setTlfNr(b.getTlfNr());
        if (b.getStudent() != null) {
            bDm.setStudentID(b.getStudent().getStudentNr());

        }
        if (b.getStudent() == null && b.getLærer() != null) {
            bDm.setLærerID(b.getLærer().getLærerNr());
        }
        return bDm;
    }

    @Override
    public BrukerDataModel getBruker(int id) {
        return convertToBrukerPojo(getBrukerByID(id));

    }

    public void updateBruker(int id, int sId) {
        Bruker b = em.find(Bruker.class, id);
        b.setStudent(em.find(Student.class, sId));
        b.

    }

    public void persist(Object object) {
        em.persist(object);
    }

}
