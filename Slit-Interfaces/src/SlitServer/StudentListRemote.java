/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Sindre
 */
@Remote
public interface StudentListRemote {

    void addStudent(String studentName);

    List getStudents();

    void setTest1(String name);

    String getTest1();

    int testMethod(int n1, int n2);

}
