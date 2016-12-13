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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sindre
 */
@Entity
@Table(name = "quiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quiz.findAll", query = "SELECT q FROM Quiz q"),
    @NamedQuery(name = "Quiz.findByQuizID", query = "SELECT q FROM Quiz q WHERE q.quizID = :quizID"),
    @NamedQuery(name = "Quiz.findByAntSpm", query = "SELECT q FROM Quiz q WHERE q.antSpm = :antSpm")})
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "quizID")
    private Integer quizID;
    @Column(name = "antSpm")
    private Integer antSpm;
    @OneToMany(mappedBy = "quizID")
    private List<QuizSpm> quizSpmList;
    @OneToMany(mappedBy = "quizID")
    private List<Modul> modulList;

    public Quiz() {
    }

    public Quiz(Integer quizID) {
        this.quizID = quizID;
    }

    public Integer getQuizID() {
        return quizID;
    }

    public void setQuizID(Integer quizID) {
        this.quizID = quizID;
    }

    public Integer getAntSpm() {
        return antSpm;
    }

    public void setAntSpm(Integer antSpm) {
        this.antSpm = antSpm;
    }

    @XmlTransient
    public List<QuizSpm> getQuizSpmList() {
        return quizSpmList;
    }

    public void setQuizSpmList(List<QuizSpm> quizSpmList) {
        this.quizSpmList = quizSpmList;
    }

    @XmlTransient
    public List<Modul> getModulList() {
        return modulList;
    }

    public void setModulList(List<Modul> modulList) {
        this.modulList = modulList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quizID != null ? quizID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.quizID == null && other.quizID != null) || (this.quizID != null && !this.quizID.equals(other.quizID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Quiz[ quizID=" + quizID + " ]";
    }

}
