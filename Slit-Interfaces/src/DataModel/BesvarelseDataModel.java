/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.util.Date;

/**
 *
 * @author Marius
 */
public class BesvarelseDataModel implements java.io.Serializable {

    private Integer besvarelseID;

    private Date dato;

    //private Student brukerID
    private Integer brukerID;

    //private Modul modulID
    private Integer idmodul;

    //private Tilbakemelding meldingID
    private Integer meldingID;

    public BesvarelseDataModel() {
    }

    public BesvarelseDataModel(Integer besvarelseID, Date dato, Integer brukerID, Integer modulID) {
        this.besvarelseID = besvarelseID;
        this.dato = dato;
        this.brukerID = brukerID;
        this.idmodul = modulID;
    }

    //Gettere
    public Integer getBesvarelseID() {
        return besvarelseID;
    }

    public Date getDato() {
        return dato;
    }

    public Integer getBrukerID() {
        return brukerID;
    }

    public Integer getIdmodul() {
        return idmodul;
    }

    public Integer getMeldingID() {
        return meldingID;
    }

    //Settere
    public void setBesvarelseID(Integer besvarelseID) {
        this.besvarelseID = besvarelseID;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public void setBrukerID(Integer brukerID) {
        this.brukerID = brukerID;
    }

    public void setIdmodul(Integer idmodul) {
        this.idmodul = idmodul;
    }

    public void setMeldingID(Integer meldingID) {
        this.meldingID = meldingID;
    }

    @Override
    public String toString() {
        return "BesvarelseDataModel{" + "besvarelseID=" + besvarelseID + ", "
                + "dato=" + dato + ", brukerID=" + brukerID + ", '"
                + "idmodul=" + idmodul + ", meldingID=" + meldingID + '}';
    }

}
