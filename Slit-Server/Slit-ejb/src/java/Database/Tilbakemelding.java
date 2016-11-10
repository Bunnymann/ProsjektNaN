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
@Table(name = "tilbakemelding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tilbakemelding.findAll", query = "SELECT t FROM Tilbakemelding t"),
    @NamedQuery(name = "Tilbakemelding.findByMeldingID", query = "SELECT t FROM Tilbakemelding t WHERE t.meldingID = :meldingID"),
    @NamedQuery(name = "Tilbakemelding.findByStatusMld", query = "SELECT t FROM Tilbakemelding t WHERE t.statusMld = :statusMld"),
    @NamedQuery(name = "Tilbakemelding.findByStudentMld", query = "SELECT t FROM Tilbakemelding t WHERE t.studentMld = :studentMld"),
    @NamedQuery(name = "Tilbakemelding.findByL\u00e6rerMld", query = "SELECT t FROM Tilbakemelding t WHERE t.l\u00e6rerMld = :l\u00e6rerMld")})
public class Tilbakemelding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "meldingID")
    private Integer meldingID;
    @Size(max = 250)
    @Column(name = "statusMld")
    private String statusMld;
    @Size(max = 250)
    @Column(name = "studentMld")
    private String studentMld;
    @Size(max = 250)
    @Column(name = "l\u00e6rerMld")
    private String lærerMld;
    @OneToMany(mappedBy = "meldingID")
    private List<Besvarelse> innleveringList;

    public Tilbakemelding() {
    }

    public Tilbakemelding(Integer meldingID) {
        this.meldingID = meldingID;
    }

    public Integer getMeldingID() {
        return meldingID;
    }

    public void setMeldingID(Integer meldingID) {
        this.meldingID = meldingID;
    }

    public String getStatusMld() {
        return statusMld;
    }

    public void setStatusMld(String statusMld) {
        this.statusMld = statusMld;
    }

    public String getStudentMld() {
        return studentMld;
    }

    public void setStudentMld(String studentMld) {
        this.studentMld = studentMld;
    }

    public String getLærerMld() {
        return lærerMld;
    }

    public void setLærerMld(String lærerMld) {
        this.lærerMld = lærerMld;
    }

    @XmlTransient
    public List<Besvarelse> getInnleveringList() {
        return innleveringList;
    }

    public void setInnleveringList(List<Besvarelse> innleveringList) {
        this.innleveringList = innleveringList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (meldingID != null ? meldingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tilbakemelding)) {
            return false;
        }
        Tilbakemelding other = (Tilbakemelding) object;
        if ((this.meldingID == null && other.meldingID != null) || (this.meldingID != null && !this.meldingID.equals(other.meldingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Tilbakemelding[ meldingID=" + meldingID + " ]";
    }

}
