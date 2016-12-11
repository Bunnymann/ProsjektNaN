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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sindre
 */
@Embeddable
public class KøPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "innlevID")
    private int innlevID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dato")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dato;

    public KøPK() {
    }

    public KøPK(int innlevID, Date dato) {
        this.innlevID = innlevID;
        this.dato = dato;
    }

    public int getInnlevID() {
        return innlevID;
    }

    public void setInnlevID(int innlevID) {
        this.innlevID = innlevID;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) innlevID;
        hash += (dato != null ? dato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KøPK)) {
            return false;
        }
        KøPK other = (KøPK) object;
        if (this.innlevID != other.innlevID) {
            return false;
        }
        if ((this.dato == null && other.dato != null) || (this.dato != null && !this.dato.equals(other.dato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.K\u00f8PK[ innlevID=" + innlevID + ", dato=" + dato + " ]";
    }

}
