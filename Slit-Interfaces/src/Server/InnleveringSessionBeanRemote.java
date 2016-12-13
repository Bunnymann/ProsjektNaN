/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.BesvarelseDataModel;
import javax.ejb.Remote;

/**
 *
 * @author Sindre
 */
@Remote
public interface InnleveringSessionBeanRemote {

    BesvarelseDataModel getBesvarelse(int id);

    void createBesvarelse(BesvarelseDataModel m);

    void persist(Object object);

    String testMethod();

    String getInnleveringStudentName(int pk);
}
