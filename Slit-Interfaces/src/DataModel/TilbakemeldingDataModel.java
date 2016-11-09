/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

/**
 *
 * @author Ola
 */
public class TilbakemeldingDataModel implements java.io.Serializable {
    
    private Integer meldingID;
    
    private String statusMld;
    
    private String studentMld;
    
    private String lærerMld;
      
    public TilbakemeldingDataModel() {
    }

    public TilbakemeldingDataModel(Integer meldingID, String statusMld, String studentMld, String lærerMld) {
        this.meldingID = meldingID;
        this.statusMld = statusMld;
        this.studentMld = studentMld;
        this.lærerMld = lærerMld;
    }

    public Integer getMeldingID() {
        return meldingID;
    }

    public String getStatusMld() {
        return statusMld;
    }

    public String getStudentMld() {
        return studentMld;
    }

    public String getLærerMld() {
        return lærerMld;
    }

    public void setMeldingID(Integer meldingID) {
        this.meldingID = meldingID;
    }

    public void setStatusMld(String statusMld) {
        this.statusMld = statusMld;
    }

    public void setStudentMld(String studentMld) {
        this.studentMld = studentMld;
    }

    public void setLærerMld(String lærerMld) {
        this.lærerMld = lærerMld;
    }
   

    @Override
    public String toString() {
        return "TilbakemeldingDataModel{" + "meldingID=" + meldingID + 
                ", statusMld=" + statusMld + ", studentMld=" + studentMld + 
                ", l\u00e6rerMld=" + lærerMld + '}';
    }
}

