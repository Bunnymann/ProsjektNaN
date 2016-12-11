/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.util.HashMap;

/**
 *
 * @author Sindre
 */
public class ModulListPojo implements java.io.Serializable {

    HashMap<String, ModulDataModel> modulMapPojo;

    public ModulListPojo(HashMap modulListPojo) {
        this.modulMapPojo = modulListPojo;
    }

    public HashMap getModulListPojo() {
        return modulMapPojo;
    }

    public void setModulListPojo(HashMap modulMap) {
        this.modulMapPojo = modulMap;
    }
}
