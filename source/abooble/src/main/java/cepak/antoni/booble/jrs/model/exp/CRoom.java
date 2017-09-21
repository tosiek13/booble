// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model.exp;

import java.util.List;

/**
 * @author pl041antcepa, 14 wrz 2017
 * CRIF IT Solutions Poland
 */
public class CRoom {
    private String roomId;
    private List<CGamester> gamesters;
    
    public String getRoomId() {
        return roomId;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public List<CGamester> getGamesters() {
        return gamesters;
    }
    public void setGamesters(List<CGamester> gamsters) {
        this.gamesters = gamsters;
    }
}
