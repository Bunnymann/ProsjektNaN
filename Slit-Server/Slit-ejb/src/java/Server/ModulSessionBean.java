/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.ModulDataModel;
import DataModel.ModulListPojo;
import Database.Modul;
import java.util.HashMap;
import java.util.List;
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

    public Modul getModulById(int id) {
        return em.find(Modul.class, id);
    }

    public ModulDataModel convertToPojo(Modul modul) {
        System.out.println("Converter Called");
        ModulDataModel modulData = new ModulDataModel();
        modulData.setIdmodul(modul.getModulID());
        modulData.setModuldesc(modul.getModulBesk());
        modulData.setModulname(modul.getModulNavn());
        modulData.setModulFrist(modul.getFrist());
        modulData.setModulKriterier(modul.getKriterier());

        return modulData;
    }

    public Modul convertToEntity(ModulDataModel m) {
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
        System.out.println("Create modul called");
        modulEntity.setModulID(id);
        modulEntity.setModulNavn(name);
        modulEntity.setModulBesk(desc);
        modulEntity.setKriterier(kriterier);
        modulEntity.setFrist(frist);
        //modulEntity.setQuizID(em.find(Quiz.class, quizID));

        persist(modulEntity);
        System.out.println("Modul Persisted");
    }

    @Override
    public ModulDataModel getModul(int id) {
        return convertToPojo(getModulById(id));
    }

    @Override
    //konverterer liste med resultater fra databasen til pojo objekter
    public ModulListPojo getModulResultList() {
        List<Modul> modulList = em.createNamedQuery("Modul.findAll", Modul.class).getResultList();
        HashMap<String, ModulDataModel> modulePojoMap = new HashMap();
        for (Modul m : modulList) {
            ModulDataModel mD = convertToPojo(m);
            modulePojoMap.put(mD.getModulname(), mD);
        }
        ModulListPojo mapPojo = new ModulListPojo(modulePojoMap);
        return mapPojo;

    }

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

}
