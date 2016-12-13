/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sindre
 */
public class KøList implements java.io.Serializable {

    private ArrayList<KøDatamodel> køList;

    public KøList() {
        this.køList = new ArrayList();
    }

    public ArrayList getKøList() {
        return køList;
    }

    public void setKøList(ArrayList køList) {
        this.køList = køList;
    }

    public boolean containsInnlevID(List<KøDatamodel> køList, Integer innlevID) {
        for (KøDatamodel k : køList) {
            if (k != null && (k.getInnlevID()).equals(innlevID)) {
                return true;

            }
        }
        return false;
    }

}
