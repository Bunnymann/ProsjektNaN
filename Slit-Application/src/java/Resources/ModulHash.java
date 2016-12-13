/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import DataModel.ModulDataModel;
import Framework.ModulManager;
import java.util.HashMap;

/**
 *
 * @author eier
 */
public class ModulHash {
    
    static ModulManager manager = new ModulManager();
    
    static HashMap <String, ModulDataModel> modules = manager.getModulList();
    
    public static HashMap<String, ModulDataModel> getModules() {
        return modules;
    }

    public static void setModules(HashMap<String, ModulDataModel> modules) {
        ModulHash.modules = modules;
    }
    
    public ModulDataModel getModulByKey(String key){
        return modules.get(key);
    }
    
}
