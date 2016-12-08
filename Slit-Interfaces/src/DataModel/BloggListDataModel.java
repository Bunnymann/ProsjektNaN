/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.util.List;

/**
 *
 * @author Sindre
 */
public class BloggListDataModel implements java.io.Serializable {

    private List<BloggDataModel> bloggList;

    public List<BloggDataModel> getBloggList() {
        return bloggList;
    }

    public void setBloggList(List<BloggDataModel> bloggList) {
        this.bloggList = bloggList;
    }

    public void addToList(BloggDataModel bm) {
        this.bloggList.add(bm);
    }

}
