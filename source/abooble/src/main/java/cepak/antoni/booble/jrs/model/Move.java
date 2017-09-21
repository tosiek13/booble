// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model;

import cepak.antoni.booble.jrs.model.exp.CMove;

/**
 * @author pl041antcepa, 14 wrz 2017
 * CRIF IT Solutions Poland
 */
public class Move {
    private int x;
    private int y;
    private int radius;
    
    public Move() {}
    
    public Move(int y, int x, int radius) {
        this.y = y;
        this.x = x;
        this.radius = radius;
    }
    
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public CMove export() {
        CMove to = new CMove();
        to.setX(this.x);
        to.setY(this.y);
        to.setRadius(this.radius);
        return to;
    }
}
