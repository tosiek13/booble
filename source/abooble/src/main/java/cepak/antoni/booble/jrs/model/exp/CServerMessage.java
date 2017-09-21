// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model.exp;

import java.util.LinkedList;
import java.util.List;

import cepak.antoni.booble.jrs.model.RoomProxy;

/**
 * @author pl041antcepa, 14 wrz 2017
 * CRIF IT Solutions Poland
 */
public class CServerMessage {
    private String messageType;
    private String status;
    private List<RoomProxy> rooms = new LinkedList<>();
    private CRoom room;
    
    public String getMessageType() {
        return messageType;
    }
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    public List<RoomProxy> getRooms() {
        return rooms;
    }
    public void setRooms(List<RoomProxy> rooms) {
        this.rooms = rooms;
    }
    public CRoom getRoom() {
        return room;
    }
    public void setRoom(CRoom room) {
        this.room = room;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
