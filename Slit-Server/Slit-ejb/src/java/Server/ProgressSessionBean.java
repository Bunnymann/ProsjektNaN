/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Database.Innlevering;
import Database.Tilbakemelding;
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
public class ProgressSessionBean implements ProgressSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List getInnleveringForStudent(int bruker) {
        Query query = em.createNamedQuery("SELECT c FROM c WHERE c.brukerID.getBrukerID() = bruker :bruker");
        List<Innlevering> result = query.getResultList();
        return result;
    }

    @Override
    public void test1() {
        List<Innlevering> result = em.find(Tilbakemelding.class, 1).getInnleveringList();
        for (Innlevering i : result) {
            System.out.println(i.getBesvarelseID());
        }
    }
}
