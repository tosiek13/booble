// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model.exp;

/**
 * @author pl041antcepa, 15 wrz 2017 CRIF IT Solutions Poland
 */
public class CRegisteredUser {
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
}
