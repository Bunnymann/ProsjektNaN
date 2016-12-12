/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.ModulDataModel;
import DataModel.ModulListPojo;
import javax.ejb.Remote;

/**
 *
 * @author Sindre
 */
@Remote
public interface ModulSessionBeanRemote {

    ModulDataModel getModulById(int id);

    void createModul(int id, String name, String desc, String frist, String kriterier, int quizID);

    void persist(Object object);

    ModulListPojo getModulResultList();
}
