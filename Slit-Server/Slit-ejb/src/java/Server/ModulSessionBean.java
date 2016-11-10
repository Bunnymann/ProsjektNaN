/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.ModulDataModel;
import Database.Modul;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sindre
 */
@Stateless
public class ModulSessionBean implements ModulSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-ejbPU")
    private EntityManager em;

    @Override
    public ModulDataModel getModulById(int id) {
        System.out.println("getModulById called");
        Modul modul = em.find(Modul.class, id);
        return convertModul(modul);
    }

    public ModulDataModel convertModul(Modul modul) {
        System.out.println("Converter Called");
        ModulDataModel modulData = new ModulDataModel();
        modulData.setIdmodul(modul.getModulID());
        modulData.setModuldesc(modul.getModulBesk());
        modulData.setModulname(modul.getModulNavn());
        modulData.setModulFrist(modul.getFrist());
        modulData.setModulKriterier(modul.getKriterier());

        return modulData;
    }

    public Modul convertToModulEntity(ModulDataModel m) {
        Modul newModul = new Modul();
        newModul.setModulID(m.getIdmodul());
        newModul.setModulNavn(m.getModulname());
        newModul.setModulBesk(m.getModuldesc());
        newModul.setFrist(m.getModulFrist());
        newModul.setKriterier(m.getModulKriterier());
        return newModul;

    }

    @Override
    public void createModul(int id, String name, String desc, String frist, String kriterier, int quizID) {
        Modul modulEntity = new Modul();

        modulEntity.setModulID(id);
        modulEntity.setModulNavn(name);
        modulEntity.setModulBesk(desc);
        modulEntity.setKriterier(kriterier);
        modulEntity.setFrist(frist);
        //modulEntity.setQuizID(em.find(Quiz.class, quizID));

        persist(modulEntity);
    }

    @Override
    public String testMethod() {
        return "This is a test";
    }

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

}
