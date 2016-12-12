/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.BesvarelseDataModel;
import java.sql.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Sindre
 */
@Remote
public interface InnleveringSessionBeanRemote {
    
    BesvarelseDataModel getBesvarelseById(int id);

    /**
     *
     * @param m data to be added
     */
    void createBesvarelse(BesvarelseDataModel m);

    void persist(Object object);

    String testMethod();

    List<BesvarelseDataModel> getBesvarelse();
    
    BesvarelseDataModel getBesvarelse(int id);
}
