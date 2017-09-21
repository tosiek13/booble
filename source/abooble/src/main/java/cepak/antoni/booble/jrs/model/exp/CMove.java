// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model.exp;

/**
 * @author pl041antcepa, 14 wrz 2017
 * CRIF IT Solutions Poland
 */
public class CMove {
    private int x;
    private int y;
    private int radius;
    
    public CMove() {}
    
    public CMove(int y, int x, int radius) {
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
}
