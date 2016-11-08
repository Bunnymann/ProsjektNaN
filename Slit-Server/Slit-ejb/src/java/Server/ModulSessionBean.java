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
    public ModulDataModel getModulById(int id){
        Modul modul = em.find(Modul.class, id);
        return convertModul(modul);
        
    }
    
    

    
    
    public ModulDataModel convertModul(Modul modul){
        ModulDataModel modulData = new ModulDataModel();
        modulData.setIdModul(modul.getIdmodul());
        modulData.setModulDesc(modul.getModuldesc());
        modulData.setModulName(modul.getModulName());
        return modulData;
    }

    public Modul convertToModulEntity(ModulDataModel m){
        Modul newModul = new Modul();
        newModul.setIdmodul(m.getIdModul());
        newModul.setModulName(m.getModulName());
        newModul.setModuldesc(m.getModulDesc());
        return newModul;

    }
    @Override
    public void createModul(int id, String name, String desc){
        Modul modulEntity = new Modul();
        
        modulEntity.setIdmodul(id);
        modulEntity.setModulName(name);
        modulEntity.setModuldesc(desc);
        
        persist(modulEntity);
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    
    
}
