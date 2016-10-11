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

    private List<String> students;
    private String test1;

    public StudentList() {

        test1 = "NotNamed";

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void addStudent(String studentName) {

        students.add(studentName);
    }

    @Override
    public List<String> getStudents() {
        return students;

    }

    @Override
    public void setTest1(String name) {
        this.test1 = name;
    }

    @Override
    public String getTest1() {
        return test1;
    }

    @Override
    public int testMethod(int n1, int n2) {
        int n3 = n1 + n2;
        return n3;
    }

}
