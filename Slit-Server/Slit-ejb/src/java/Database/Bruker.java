/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sindre
 */
@Entity
@Table(name = "bruker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bruker.findAll", query = "SELECT b FROM Bruker b"),
    @NamedQuery(name = "Bruker.findByBrukerID", query = "SELECT b FROM Bruker b WHERE b.brukerID = :brukerID"),
    @NamedQuery(name = "Bruker.findByForNavn", query = "SELECT b FROM Bruker b WHERE b.forNavn = :forNavn"),
    @NamedQuery(name = "Bruker.findByEtterNavn", query = "SELECT b FROM Bruker b WHERE b.etterNavn = :etterNavn"),
    @NamedQuery(name = "Bruker.findByEmail", query = "SELECT b FROM Bruker b WHERE b.email = :email"),
    @NamedQuery(name = "Bruker.findByPassord", query = "SELECT b FROM Bruker b WHERE b.passord = :passord"),
    @NamedQuery(name = "Bruker.findByTlfNr", query = "SELECT b FROM Bruker b WHERE b.tlfNr = :tlfNr")})
public class Bruker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "brukerID")
    private Integer brukerID;
    @Size(max = 30)
    @Column(name = "forNavn")
    private String forNavn;
    @Size(max = 30)
    @Column(name = "etterNavn")
    private String etterNavn;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 90)
    @Column(name = "email")
    private String email;
    @Size(max = 90)
    @Column(name = "passord")
    private String passord;
    @Size(max = 8)
    @Column(name = "tlfNr")
    private String tlfNr;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bruker")
    private Student student;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bruker")
    private Lærer lærer;

    public Bruker() {
    }

    public Bruker(Integer brukerID) {
        this.brukerID = brukerID;
    }

    public Integer getBrukerID() {
        return brukerID;
    }

    public void setBrukerID(Integer brukerID) {
        this.brukerID = brukerID;
    }

    public String getForNavn() {
        return forNavn;
    }

    public void setForNavn(String forNavn) {
        this.forNavn = forNavn;
    }

    public String getEtterNavn() {
        return etterNavn;
    }

    public void setEtterNavn(String etterNavn) {
        this.etterNavn = etterNavn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lærer getLærer() {
        return lærer;
    }

    public void setLærer(Lærer lærer) {
        this.lærer = lærer;
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
        if (!(object instanceof Bruker)) {
            return false;
        }
        Bruker other = (Bruker) object;
        if ((this.brukerID == null && other.brukerID != null) || (this.brukerID != null && !this.brukerID.equals(other.brukerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Bruker[ brukerID=" + brukerID + " ]";
    }

}
