/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sindre
 */
@Stateless
public class StudentList implements StudentListRemote {

  
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addStudent() {
        System.out.println("Called add student");
    }

    @Override
    public List getStudents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTest1(String name) {
        System.out.println("Called setTest1");
    }

    @Override
    public String getTest1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int testMethod(int n1, int n2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
