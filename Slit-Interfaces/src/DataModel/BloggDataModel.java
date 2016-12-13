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
public class BloggDataModel implements java.io.Serializable {

    private Integer bloggID;

    private String bloggLink;

    private String studentID;

    public BloggDataModel() {

    }

    public BloggDataModel(int id, String bloggLink, String studentNr) {
        this.bloggID = id;
        this.bloggLink = bloggLink;
        this.studentID = studentNr;
    }

    public Integer getBloggID() {
        return bloggID;
    }

    public void setBloggID(Integer bloggID) {
        this.bloggID = bloggID;
    }

    public String getBloggLink() {
        return bloggLink;
    }

    public void setBloggLink(String bloggLink) {
        this.bloggLink = bloggLink;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

}
