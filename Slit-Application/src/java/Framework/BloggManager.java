/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.BloggDataModel;
import Server.BloggSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Sindre
 */
public class BloggManager {

    public void creatBlogg(int bloggID, String bloggLink, String studentNr) {
        BloggDataModel bm = new BloggDataModel();
        bm.fixObject(bloggID, bloggLink, studentNr);
        this.lookupBloggSessionBeanRemote().createrBlogg(bm);
    }

    private BloggSessionBeanRemote lookupBloggSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (BloggSessionBeanRemote) c.lookup("java:global/Slit-ejb/BloggSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
