// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model;

import java.util.LinkedList;
import java.util.List;

import cepak.antoni.booble.jrs.model.exp.CServerMessage;

/**
 * @author pl041antcepa, 13 wrz 2017 CRIF IT Solutions Poland
 */
public class ServerMessage {
    private String messageType;
    private String status;
    private List<RoomProxy> rooms = new LinkedList<>();
    private Room room;
    private RegisteredUser currentUser;

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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public CServerMessage export() {
        CServerMessage to = new CServerMessage();
        to.setMessageType(this.messageType);
        if(this.room != null) {
            to.setRoom(this.room.export());
        }
        if(this.rooms != null) {
            to.setRooms(this.rooms);
        }
        to.setStatus(this.status);
        return to;
    }

    public RegisteredUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(RegisteredUser currentUser) {
        this.currentUser = currentUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
