/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sindre
 */
@Entity
@Table(name = "modul")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modul.findAll", query = "SELECT m FROM Modul m"),
    @NamedQuery(name = "Modul.findByModulID", query = "SELECT m FROM Modul m WHERE m.modulID = :modulID"),
    @NamedQuery(name = "Modul.findByModulNavn", query = "SELECT m FROM Modul m WHERE m.modulNavn = :modulNavn"),
    @NamedQuery(name = "Modul.findByModulBesk", query = "SELECT m FROM Modul m WHERE m.modulBesk = :modulBesk"),
    @NamedQuery(name = "Modul.findByFrist", query = "SELECT m FROM Modul m WHERE m.frist = :frist"),
    @NamedQuery(name = "Modul.findByKriterier", query = "SELECT m FROM Modul m WHERE m.kriterier = :kriterier")})
public class Modul implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "modulID")
    private Integer modulID;
    @Size(max = 90)
    @Column(name = "modulNavn")
    private String modulNavn;
    @Size(max = 250)
    @Column(name = "modulBesk")
    private String modulBesk;
    @Size(max = 100)
    @Column(name = "frist")
    private String frist;
    @Size(max = 250)
    @Column(name = "kriterier")
    private String kriterier;
    @OneToMany(mappedBy = "modulID")
    private List<Innlevering> innleveringList;
    @JoinColumn(name = "quizID", referencedColumnName = "quizID")
    @ManyToOne
    private Quiz quizID;

    public Modul() {
        System.out.println("Modul Constructor Called");
    }

    public Modul(Integer modulID) {
        this.modulID = modulID;
    }

    public Integer getModulID() {
        return modulID;
    }

    public void setModulID(Integer modulID) {
        this.modulID = modulID;
    }

    public String getModulNavn() {
        return modulNavn;
    }

    public void setModulNavn(String modulNavn) {
        this.modulNavn = modulNavn;
    }

    public String getModulBesk() {
        return modulBesk;
    }

    public void setModulBesk(String modulBesk) {
        this.modulBesk = modulBesk;
    }

    public String getFrist() {
        return frist;
    }

    public void setFrist(String frist) {
        this.frist = frist;
    }

    public String getKriterier() {
        return kriterier;
    }

    public void setKriterier(String kriterier) {
        this.kriterier = kriterier;
    }

    @XmlTransient
    public List<Innlevering> getInnleveringList() {
        return innleveringList;
    }

    public void setInnleveringList(List<Innlevering> innleveringList) {
        this.innleveringList = innleveringList;
    }

    public Quiz getQuizID() {
        return quizID;
    }

    public void setQuizID(Quiz quizID) {
        this.quizID = quizID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modulID != null ? modulID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modul)) {
            return false;
        }
        Modul other = (Modul) object;
        if ((this.modulID == null && other.modulID != null) || (this.modulID != null && !this.modulID.equals(other.modulID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Modul[ modulID=" + modulID + " ]";
    }

}
