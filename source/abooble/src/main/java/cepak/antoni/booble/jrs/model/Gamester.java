// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model;

import javax.websocket.Session;

import cepak.antoni.booble.jrs.model.exp.CGamester;
import cepak.antoni.booble.jrs.model.exp.CMove;

/**
 * @author pl041antcepa, 14 wrz 2017
 * CRIF IT Solutions Poland
 */
public class Gamester {
    private String nick;
    private int points;
    private Session session;
    private Move move;
    private boolean boot;
    
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    
    public Session getSession() {
        return session;
    }
    public void setSession(Session session) {
        this.session = session;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj instanceof Gamester) {
            Gamester gamster = (Gamester) obj;
            return this.getNick().equals(gamster.getNick());
        }
        return false;
    }
    
    public CGamester export() {
        CGamester to = new CGamester();
        to.setNick(this.nick);
        to.setPoints(this.points);
        if(this.move != null) {
            CMove move = this.move.export();
            to.setMove(move);
        }
        return to;
    }
    public Move getMove() {
        return move;
    }
    public void setMove(Move move) {
        this.move = move;
    }
    public boolean isBoot() {
        return boot;
    }
    public void setBoot(boolean boot) {
        this.boot = boot;
    }
}
