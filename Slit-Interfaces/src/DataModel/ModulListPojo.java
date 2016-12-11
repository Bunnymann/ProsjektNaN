/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.util.ArrayList;

/**
 *
 * @author Sindre
 */
public class ModulListPojo implements java.io.Serializable {

    ArrayList modulListPojo;

    public ModulListPojo(ArrayList modulListPojo) {
        this.modulListPojo = modulListPojo;
    }

    public ArrayList getModulListPojo() {
        return modulListPojo;
    }

    public void setModulListPojo(ArrayList modulListPojo) {
        this.modulListPojo = modulListPojo;
    }
}
