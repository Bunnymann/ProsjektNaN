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
@Table(name = "blogg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blogg.findAll", query = "SELECT b FROM Blogg b"),
    @NamedQuery(name = "Blogg.findByBloggID", query = "SELECT b FROM Blogg b WHERE b.bloggID = :bloggID"),
    @NamedQuery(name = "Blogg.findByBloggLink", query = "SELECT b FROM Blogg b WHERE b.bloggLink = :bloggLink")})
public class Blogg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bloggID")
    private Integer bloggID;
    @Size(max = 150)
    @Column(name = "bloggLink")
    private String bloggLink;
    @JoinColumn(name = "brukerID", referencedColumnName = "brukerID")
    @ManyToOne
    private Student brukerID;

    public Blogg() {
    }

    public Blogg(Integer bloggID) {
        this.bloggID = bloggID;
    }

    public Integer getBloggID() {
        return bloggID;
    }

    public void setBloggID(Integer bloggID) {
        this.bloggID = bloggID;
    }

    public String getBloggLink() {
        return bloggLink;
    }

    public void setBloggLink(String bloggLink) {
        this.bloggLink = bloggLink;
    }

    public Student getBrukerID() {
        return brukerID;
    }

    public void setBrukerID(Student brukerID) {
        this.brukerID = brukerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bloggID != null ? bloggID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blogg)) {
            return false;
        }
        Blogg other = (Blogg) object;
        if ((this.bloggID == null && other.bloggID != null) || (this.bloggID != null && !this.bloggID.equals(other.bloggID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Blogg[ bloggID=" + bloggID + " ]";
    }

}
