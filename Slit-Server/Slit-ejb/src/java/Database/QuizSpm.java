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
@Table(name = "quiz_spm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuizSpm.findAll", query = "SELECT q FROM QuizSpm q"),
    @NamedQuery(name = "QuizSpm.findBySpmID", query = "SELECT q FROM QuizSpm q WHERE q.spmID = :spmID"),
    @NamedQuery(name = "QuizSpm.findBySpmTekst", query = "SELECT q FROM QuizSpm q WHERE q.spmTekst = :spmTekst")})
public class QuizSpm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "spmID")
    private Integer spmID;
    @Size(max = 250)
    @Column(name = "spmTekst")
    private String spmTekst;
    @OneToMany(mappedBy = "spmID")
    private List<QuizSvar> quizSvarList;
    @JoinColumn(name = "quizID", referencedColumnName = "quizID")
    @ManyToOne
    private Quiz quizID;

    public QuizSpm() {
    }

    public QuizSpm(Integer spmID) {
        this.spmID = spmID;
    }

    public Integer getSpmID() {
        return spmID;
    }

    public void setSpmID(Integer spmID) {
        this.spmID = spmID;
    }

    public String getSpmTekst() {
        return spmTekst;
    }

    public void setSpmTekst(String spmTekst) {
        this.spmTekst = spmTekst;
    }

    @XmlTransient
    public List<QuizSvar> getQuizSvarList() {
        return quizSvarList;
    }

    public void setQuizSvarList(List<QuizSvar> quizSvarList) {
        this.quizSvarList = quizSvarList;
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
        hash += (spmID != null ? spmID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuizSpm)) {
            return false;
        }
        QuizSpm other = (QuizSpm) object;
        if ((this.spmID == null && other.spmID != null) || (this.spmID != null && !this.spmID.equals(other.spmID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.QuizSpm[ spmID=" + spmID + " ]";
    }

}
