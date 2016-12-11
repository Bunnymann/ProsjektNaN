/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.util.Date;

/**
 *
 * @author Sindre
 */
public class KøDatamodel implements java.io.Serializable {

    private Integer innlevID;

    private Date dato;

    public KøDatamodel() {
    }

    public Integer getInnlevID() {
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

}
