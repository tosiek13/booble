// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model;

import cepak.antoni.booble.jrs.model.exp.CRegisteredUser;

/**
 * @author pl041antcepa, 15 wrz 2017
 * CRIF IT Solutions Poland
 */
public class RegisteredUser {
    private String nick;
    private String password;
    private int rank;
    
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public CRegisteredUser export() {
        CRegisteredUser to = new CRegisteredUser();
        to.setNick(this.nick);
        to.setRank(this.getRank());
        return to;
    }
}
