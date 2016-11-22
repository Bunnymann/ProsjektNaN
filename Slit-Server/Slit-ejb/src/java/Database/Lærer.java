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
@Table(name = "l\u00e6rer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "L\u00e6rer.findAll", query = "SELECT l FROM L\u00e6rer l"),
    @NamedQuery(name = "L\u00e6rer.findByL\u00e6rerNr", query = "SELECT l FROM L\u00e6rer l WHERE l.l\u00e6rerNr = :l\u00e6rerNr"),
    @NamedQuery(name = "L\u00e6rer.findByBrukerID", query = "SELECT l FROM L\u00e6rer l WHERE l.brukerID = :brukerID")})
public class Lærer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "l\u00e6rerNr")
    private String lærerNr;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "brukerID")
    private Integer brukerID;
    @JoinColumn(name = "brukerID", referencedColumnName = "brukerID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Bruker bruker;

    public Lærer() {
    }

    public Lærer(Integer brukerID) {
        this.brukerID = brukerID;
    }

    public String getLærerNr() {
        return lærerNr;
    }

    public void setLærerNr(String lærerNr) {
        this.lærerNr = lærerNr;
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
        if (!(object instanceof Lærer)) {
            return false;
        }
        Lærer other = (Lærer) object;
        if ((this.brukerID == null && other.brukerID != null) || (this.brukerID != null && !this.brukerID.equals(other.brukerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.L\u00e6rer[ brukerID=" + brukerID + " ]";
    }
    
}
