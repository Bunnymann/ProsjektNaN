/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.BloggDataModel;
import Database.Blogg;
import Database.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sindre
 */
@Stateless
public class BloggSessionBean implements BloggSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-ejbPU")
    private EntityManager em;

    public Blogg getBloggByID(int id) {
        return em.find(Blogg.class, id);
    }

    //brukes for å konvertere et entitetsobjekt til et pojo objekt
    public BloggDataModel convertToPojo(Blogg b) {
        BloggDataModel blogg = new BloggDataModel();
        blogg.setBloggID(b.getBloggID());
        blogg.setBloggLink(b.getBloggLink());
        blogg.setStudentID(b.getBrukerID().getStudentNr());
        return blogg;
    }

    //brukes for å konvertere et DataModel objekt til et entitetsobjekt
    public Blogg convertToEntity(BloggDataModel bm) {
        Blogg blogg = new Blogg();
        blogg.setBloggID(bm.getBloggID());
        blogg.setBloggLink(bm.getBloggLink());
        blogg.setBrukerID(em.find(Student.class, bm.getStudentID()));
        return blogg;
    }

    @Override
    //Opprettet DataModel konverteres og lagres i databasen
    public void createBlogg(BloggDataModel bm) {
        persist(convertToEntity(bm));
    }

    @Override
    //klargjør entitet fra DB for klienten
    public BloggDataModel getBloggPojo(int id) {
        return convertToPojo(em.find(Blogg.class, id));
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
