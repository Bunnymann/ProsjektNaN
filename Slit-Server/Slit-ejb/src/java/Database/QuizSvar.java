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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sindre
 */
@Entity
@Table(name = "quiz_svar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuizSvar.findAll", query = "SELECT q FROM QuizSvar q"),
    @NamedQuery(name = "QuizSvar.findBySvarID", query = "SELECT q FROM QuizSvar q WHERE q.svarID = :svarID"),
    @NamedQuery(name = "QuizSvar.findBySvarTekst", query = "SELECT q FROM QuizSvar q WHERE q.svarTekst = :svarTekst"),
    @NamedQuery(name = "QuizSvar.findBySvarStatus", query = "SELECT q FROM QuizSvar q WHERE q.svarStatus = :svarStatus")})
public class QuizSvar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "svarID")
    private Integer svarID;
    @Size(max = 250)
    @Column(name = "svarTekst")
    private String svarTekst;
    @Column(name = "svarStatus")
    private Boolean svarStatus;
    @JoinColumn(name = "spmID", referencedColumnName = "spmID")
    @ManyToOne
    private QuizSpm spmID;

    public QuizSvar() {
    }

    public QuizSvar(Integer svarID) {
        this.svarID = svarID;
    }

    public Integer getSvarID() {
        return svarID;
    }

    public void setSvarID(Integer svarID) {
        this.svarID = svarID;
    }

    public String getSvarTekst() {
        return svarTekst;
    }

    public void setSvarTekst(String svarTekst) {
        this.svarTekst = svarTekst;
    }

    public Boolean getSvarStatus() {
        return svarStatus;
    }

    public void setSvarStatus(Boolean svarStatus) {
        this.svarStatus = svarStatus;
    }

    public QuizSpm getSpmID() {
        return spmID;
    }

    public void setSpmID(QuizSpm spmID) {
        this.spmID = spmID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (svarID != null ? svarID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuizSvar)) {
            return false;
        }
        QuizSvar other = (QuizSvar) object;
        if ((this.svarID == null && other.svarID != null) || (this.svarID != null && !this.svarID.equals(other.svarID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.QuizSvar[ svarID=" + svarID + " ]";
    }

}
