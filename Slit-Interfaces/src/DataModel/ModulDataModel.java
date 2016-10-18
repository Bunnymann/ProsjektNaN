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
        return "ModulDataModel{" + "idmodul=" + idmodul + ", moduldesc=" + moduldesc + ", modulname=" + modulname + '}';
    }
    
    
    
    
    
}
