/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.InnleveringDataModel;
import java.sql.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Sindre
 */
@Remote
public interface InnleveringSessionBeanRemote {
    
    InnleveringDataModel getInnleveringById(int id);

    void createInnlevering(InnleveringDataModel m);

    void persist(Object object);

    String testMethod();

    List<InnleveringDataModel> getAllInnlevering();
    
    InnleveringDataModel getInnlevering(int id);
}
