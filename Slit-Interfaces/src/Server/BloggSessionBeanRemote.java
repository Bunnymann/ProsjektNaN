/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.BloggDataModel;
import javax.ejb.Remote;

/**
 *
 * @author Sindre
 */
@Remote
public interface BloggSessionBeanRemote {

    void createBlogg(BloggDataModel bm);

    BloggDataModel getBloggPojo(int id);
}
