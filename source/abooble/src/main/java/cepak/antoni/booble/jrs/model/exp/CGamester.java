// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model.exp;

/**
 * @author pl041antcepa, 14 wrz 2017
 * CRIF IT Solutions Poland
 */
public class CGamester {
    private String nick;
    private int points;
    private CMove move;
    
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public CMove getMove() {
        return move;
    }
    public void setMove(CMove move) {
        this.move = move;
    }
}
