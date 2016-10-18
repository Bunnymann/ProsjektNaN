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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sindre
 */
@Entity
@Table(name = "modul")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modul.findAll", query = "SELECT m FROM Modul m"),
    @NamedQuery(name = "Modul.findByIdmodul", query = "SELECT m FROM Modul m WHERE m.idmodul = :idmodul"),
    @NamedQuery(name = "Modul.findByModuldesc", query = "SELECT m FROM Modul m WHERE m.moduldesc = :moduldesc"),
    @NamedQuery(name = "Modul.findByModulName", query = "SELECT m FROM Modul m WHERE m.modulName = :modulName")})
public class Modul implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmodul")
    private Integer idmodul;
    @Size(max = 45)
    @Column(name = "moduldesc")
    private String moduldesc;
    @Size(max = 45)
    @Column(name = "modulName")
    private String modulName;

    public Modul() {
    }

    public Modul(Integer idmodul) {
        this.idmodul = idmodul;
    }

    public Integer getIdmodul() {
        return idmodul;
    }

    public void setIdmodul(Integer idmodul) {
        this.idmodul = idmodul;
    }

    public String getModuldesc() {
        return moduldesc;
    }

    public void setModuldesc(String moduldesc) {
        this.moduldesc = moduldesc;
    }

    public String getModulName() {
        return modulName;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodul != null ? idmodul.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modul)) {
            return false;
        }
        Modul other = (Modul) object;
        if ((this.idmodul == null && other.idmodul != null) || (this.idmodul != null && !this.idmodul.equals(other.idmodul))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Modul[ idmodul=" + idmodul + " ]";
    }
    
}
