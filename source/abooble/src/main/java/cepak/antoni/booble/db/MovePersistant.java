// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.db;

/**
 * @author pl041antcepa, 19 wrz 2017
 * CRIF IT Solutions Poland
 */
public class MovePersistant {
    private int userId;
    private int x;
    private int y;
    private int r;
    private int rankUpdate;
    private Long gameId;
    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
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
    public int getR() {
        return r;
    }
    public void setR(int r) {
        this.r = r;
    }
    public int getRankUpdate() {
        return rankUpdate;
    }
    public void setRankUpdate(int rankUpdate) {
        this.rankUpdate = rankUpdate;
    }
    public Long getGameId() {
        return gameId;
    }
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
