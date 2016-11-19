/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.BloggDataModel;
import DataModel.BloggListDataModel;
import Database.Blogg;
import Database.Student;
import java.util.List;
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

    public BloggDataModel convertToPojo(Blogg b) {
        BloggDataModel blogg = new BloggDataModel();
        blogg.setBloggID(b.getBloggID());
        blogg.setBloggLink(b.getBloggLink());
        blogg.setStudentID(b.getBrukerID().getStudentNr());
        return blogg;
    }

    public Blogg convertToEntity(BloggDataModel bm) {
        Blogg blogg = new Blogg();
        blogg.setBloggID(bm.getBloggID());
        blogg.setBloggLink(bm.getBloggLink());
        blogg.setBrukerID(em.find(Student.class, bm.getStudentID()));
        return blogg;
    }

    @Override
    public void createrBlogg(BloggDataModel bm) {
        persist(convertToEntity(bm));
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public void addManyToOne(Blogg b, int id) {
        Student student = em.find(Student.class, id);
        student.getBloggList().add(b);
        persist(student);
    }

    public List setManyToOne(Blogg blogg, int studentID) {
        Student student = em.find(Student.class, studentID);
        List<Blogg> bloggList = student.getBloggList();
        for (Blogg b : bloggList) {
            System.out.println(b.toString());
        }
        bloggList.add(blogg);
        for (Blogg b : bloggList) {
            System.out.println(b.toString());
        }
        return bloggList;
    }

    public BloggListDataModel addToPojoList(int id) {
        Student student = em.find(Student.class, id);
        List<Blogg> sB = student.getBloggList();
        BloggListDataModel list = new BloggListDataModel();
        for (Blogg b : sB) {
            list.getBloggList().add(this.convertToPojo(b));
        }

        return list;

    }
}
