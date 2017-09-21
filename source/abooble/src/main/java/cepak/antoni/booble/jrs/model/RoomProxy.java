// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model;

/**
 * @author pl041antcepa, 13 wrz 2017
 * CRIF IT Solutions Poland
 */
public class RoomProxy {
    private String roomId;
    private int participantsAmount;
    
    public String getRoomId() {
        return roomId;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public int getParticipantsAmount() {
        return participantsAmount;
    }
    public void setParticipantsAmount(int participantsAmount) {
        this.participantsAmount = participantsAmount;
    }
}