/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.KøList;
import javax.ejb.Remote;

/**
 *
 * @author Sindre
 */
@Remote
public interface QueueSessionBeanRemote {

    KøList getQueuePojo();
}
