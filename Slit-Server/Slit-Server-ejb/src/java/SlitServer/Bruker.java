/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sindre
 */
@Entity
@Table
public class Bruker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int userId;
    private String userName;
    private String deg;

    public Bruker(int userId, String userName, String deg) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.deg = deg;

    }

    public Bruker() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "Bruker{" + "userId=" + userId + ", userName=" + userName + ", deg=" + deg + '}';
    }

}
