/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

/**
 *
 * @author Sindre
 */
public class ModulDataModel implements java.io.Serializable {

    private Integer idmodul;

    private String moduldesc;

    private String modulname;

    private String modulFrist;

    private String modulKriterier;

    private Integer quizID;

    public ModulDataModel() {
    }

    public ModulDataModel(Integer idmodul, String moduldesc, String modulname, String modulFrist, String kriterier, Integer quizID) {
        this.idmodul = idmodul;
        this.moduldesc = moduldesc;
        this.modulname = modulname;
        this.modulFrist = modulFrist;
        this.modulKriterier = kriterier;
        this.quizID = quizID;
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

    public String getModulname() {
        return modulname;
    }

    public void setModulname(String modulname) {
        this.modulname = modulname;
    }

    public String getModulFrist() {
        return modulFrist;
    }

    public void setModulFrist(String modulFrist) {
        this.modulFrist = modulFrist;
    }

    public String getModulKriterier() {
        return modulKriterier;
    }

    public void setModulKriterier(String modulKriterier) {
        this.modulKriterier = modulKriterier;
    }

    public Integer getQuizID() {
        return quizID;
    }

    public void setQuizID(Integer quizID) {
        this.quizID = quizID;
    }

    public Integer getIdModul() {
        return idmodul;
    }

    public void setIdModul(Integer idModul) {
        this.idmodul = idModul;
    }

    public String getModulDesc() {
        return moduldesc;
    }

    public void setModulDesc(String modulDesc) {
        this.moduldesc = modulDesc;
    }

    public String getModulName() {
        return modulname;
    }

    public void setModulName(String modulName) {
        this.modulname = modulName;
    }

    @Override
    public String toString() {
        return "ModulDataModel{" + "idmodul=" + idmodul + ", moduldesc="
                + moduldesc + ", modulname=" + modulname + ", modulKriterier"
                + modulKriterier + ", modulFrist" + modulFrist + '}';
    }

}
