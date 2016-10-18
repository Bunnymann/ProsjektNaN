/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

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
@Table(name = "bruker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bruker.findAll", query = "SELECT b FROM Bruker b"),
    @NamedQuery(name = "Bruker.findByIdbruker", query = "SELECT b FROM Bruker b WHERE b.idbruker = :idbruker"),
    @NamedQuery(name = "Bruker.findByName", query = "SELECT b FROM Bruker b WHERE b.name = :name"),
    @NamedQuery(name = "Bruker.findByEmail", query = "SELECT b FROM Bruker b WHERE b.email = :email")})
public class Bruker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbruker")
    private Integer idbruker;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;

    public Bruker(int id, String name, String email) {
        this.idbruker = id;
        this.name = name;
        this.email = email;
        
    }

    public Bruker(Integer idbruker) {
        this.idbruker = idbruker;
    }

    public Integer getIdbruker() {
        return idbruker;
    }

    public void setIdbruker(Integer idbruker) {
        this.idbruker = idbruker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbruker != null ? idbruker.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bruker)) {
            return false;
        }
        Bruker other = (Bruker) object;
        if ((this.idbruker == null && other.idbruker != null) || (this.idbruker != null && !this.idbruker.equals(other.idbruker))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SlitServer.Bruker[ idbruker=" + idbruker + " ]";
    }
    
}
