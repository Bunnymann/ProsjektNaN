/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sindre
 */
@Stateless
public class addBrukerBean implements addBrukerBeanRemote {

    @PersistenceContext(unitName = "Slit-ejbPU")
    private EntityManager em;

    
    
    

    @Override
    public void addUser(String name, int id, String email) {
        Bruker bruker = new Bruker(id, name, email);
        em.getTransaction().begin();
        em.persist(bruker);
        em.getTransaction().commit();
        
        
            
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
