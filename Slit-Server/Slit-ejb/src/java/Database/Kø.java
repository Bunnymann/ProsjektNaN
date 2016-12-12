/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sindre
 */
@Entity
@Table(name = "k\u00f8")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "K\u00f8.findAll", query = "SELECT k FROM K\u00f8 k"),
    @NamedQuery(name = "K\u00f8.findByInnlevID", query = "SELECT k FROM K\u00f8 k WHERE k.k\u00f8PK.innlevID = :innlevID"),
    @NamedQuery(name = "K\u00f8.findByDato", query = "SELECT k FROM K\u00f8 k WHERE k.k\u00f8PK.dato = :dato")})
public class Kø implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KøPK køPK;

    public Kø() {
    }

    public Kø(KøPK køPK) {
        this.køPK = køPK;
    }

    public Kø(int innlevID, Date dato) {
        this.køPK = new KøPK(innlevID, dato);
    }

    public KøPK getKøPK() {
        return køPK;
    }

    public void setKøPK(KøPK køPK) {
        this.køPK = køPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (køPK != null ? køPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kø)) {
            return false;
        }
        Kø other = (Kø) object;
        if ((this.køPK == null && other.køPK != null) || (this.køPK != null && !this.køPK.equals(other.køPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.K\u00f8[ k\u00f8PK=" + køPK + " ]";
    }

}
