/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sindre
 */
@Entity
@Table(name = "innlevering")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Innlevering.findAll", query = "SELECT i FROM Innlevering i"),
    @NamedQuery(name = "Innlevering.findByInnlevID", query = "SELECT i FROM Innlevering i WHERE i.innlevID = :innlevID"),
    @NamedQuery(name = "Innlevering.findByDato", query = "SELECT i FROM Innlevering i WHERE i.dato = :dato")})
public class Innlevering implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "innlevID")
    private Integer innlevID;
    @Column(name = "dato")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dato;
    @JoinColumn(name = "modulID", referencedColumnName = "modulID")
    @ManyToOne
    private Modul modulID;
    @JoinColumn(name = "brukerID", referencedColumnName = "brukerID")
    @ManyToOne
    private Student brukerID;
    @JoinColumn(name = "meldingID", referencedColumnName = "meldingID")
    @ManyToOne
    private Tilbakemelding meldingID;

    public Innlevering() {
    }

    public Innlevering(Integer innlevID) {
        this.innlevID = innlevID;
    }

    public Integer getInnlevID() {
        return innlevID;
    }

    public void setInnlevID(Integer innlevID) {
        this.innlevID = innlevID;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public Modul getModulID() {
        return modulID;
    }

    public void setModulID(Modul modulID) {
        this.modulID = modulID;
    }

    public Student getBrukerID() {
        return brukerID;
    }

    public void setBrukerID(Student brukerID) {
        this.brukerID = brukerID;
    }

    public Tilbakemelding getMeldingID() {
        return meldingID;
    }

    public void setMeldingID(Tilbakemelding meldingID) {
        this.meldingID = meldingID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (innlevID != null ? innlevID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Innlevering)) {
            return false;
        }
        Innlevering other = (Innlevering) object;
        if ((this.innlevID == null && other.innlevID != null) || (this.innlevID != null && !this.innlevID.equals(other.innlevID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Innlevering[ innlevID=" + innlevID + " ]";
    }

}
