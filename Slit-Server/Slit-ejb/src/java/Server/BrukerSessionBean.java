/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.BrukerDataModel;
import Database.Bruker;
import Database.Lærer;
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

    public Bruker getBrukerByID(int id) {
        Bruker bruker = em.find(Bruker.class, id);
        return bruker;
    }

    public BrukerDataModel convertToPojo(Bruker b) {
        BrukerDataModel bDm = new BrukerDataModel();
        bDm.setBrukerID(b.getBrukerID());
        bDm.setForNavn(b.getForNavn());
        bDm.setEtterNavn(b.getEtterNavn());
        bDm.setEmail(b.getEmail());
        bDm.setTlfNr(b.getTlfNr());
        // sjekker om entitetobjektet er lærer eller student
        if (b.getStudent() != null) {
            bDm.setStudentID(b.getStudent().getStudentNr());

        }
        if (b.getStudent() == null && b.getLærer() != null) {
            bDm.setLærerID(b.getLærer().getLærerNr());
        }
        return bDm;
    }

    public Bruker convertToEntity(BrukerDataModel b) {
        Bruker bruker = new Bruker();
        bruker.setBrukerID(b.getBrukerID());
        bruker.setForNavn(b.getForNavn());
        bruker.setEmail(b.getEmail());
        bruker.setPassord(b.getPassord());
        // Sjekker om BrukerdDataModel objektet inneholder en student id eller en lærer id
        if (b.getStudentID() != null) {
            bruker.setStudent(em.find(Student.class, b.getStudentID()));
        }
        if (b.getStudentID() == null && b.getLærerID() != null) {
            bruker.setLærer(em.find(Lærer.class, b.getLærerID()));
        }
        return bruker;
    }

    @Override
    public void createBruker(BrukerDataModel b) {
        persist(convertToEntity(b));
    }

    @Override
    public BrukerDataModel getBruker(int id) {
        return convertToPojo(getBrukerByID(id));

    }

    public void persist(Object object) {
        em.persist(object);
    }

}
