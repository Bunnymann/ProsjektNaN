/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sindre
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentNr", query = "SELECT s FROM Student s WHERE s.studentNr = :studentNr"),
    @NamedQuery(name = "Student.findByBrukerID", query = "SELECT s FROM Student s WHERE s.brukerID = :brukerID")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "studentNr")
    private String studentNr;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "brukerID")
    private Integer brukerID;
    @JoinColumn(name = "brukerID", referencedColumnName = "brukerID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Bruker bruker;

    public Student() {
    }

    public Student(Integer brukerID) {
        this.brukerID = brukerID;
    }

    public String getStudentNr() {
        return studentNr;
    }

    public void setStudentNr(String studentNr) {
        this.studentNr = studentNr;
    }

    public Integer getBrukerID() {
        return brukerID;
    }

    public void setBrukerID(Integer brukerID) {
        this.brukerID = brukerID;
    }

    public Bruker getBruker() {
        return bruker;
    }

    public void setBruker(Bruker bruker) {
        this.bruker = bruker;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brukerID != null ? brukerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.brukerID == null && other.brukerID != null) || (this.brukerID != null && !this.brukerID.equals(other.brukerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Student[ brukerID=" + brukerID + " ]";
    }
    
}
