// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model.exp;

import cepak.antoni.booble.jrs.model.MessageTypes;
import cepak.antoni.booble.jrs.model.RegisteredUser;
import cepak.antoni.booble.jrs.model.Room;
import cepak.antoni.booble.jrs.model.ServerMessage;
import cepak.antoni.booble.jrs.model.Status;

/**
 * @author pl041antcepa, 14 wrz 2017
 * CRIF IT Solutions Poland
 */
public class MessageGenerator {
    public static ServerMessage roomInfoMessage(Room room) {
        ServerMessage response = new ServerMessage();
        
        response.setMessageType(MessageTypes.ROOM_INFO.enumValue());
        response.setRoom(room);
        
        return response;
    }
    
    public static ServerMessage newRoundMessage() {
        ServerMessage message = new ServerMessage();
        message.setMessageType(MessageTypes.NEW_ROUND.enumValue());
        return message;
    }
    
    public static ServerMessage roundSummary(Room room) {
        ServerMessage message = new ServerMessage();
        message.setMessageType(MessageTypes.ROUND_SUMMARY.enumValue());
        message.setRoom(room);
        return message;
    }

    public static ServerMessage userLogged(RegisteredUser user) {
        ServerMessage message = new ServerMessage();
        message.setMessageType(MessageTypes.LOGIN.enumValue());
        message.setCurrentUser(user);
        return message;
    }
    
    public static ServerMessage leftRoom(Status status) {
        ServerMessage message = new ServerMessage();
        message.setMessageType(MessageTypes.LEAVE_ROOM.enumValue());
        message.setStatus(status.enumValue());
        return message;
    }

	public static ServerMessage userLogged(boolean loggedOn) {
		ServerMessage message = new ServerMessage();
        message.setMessageType(MessageTypes.LOGIN.enumValue());
        if(loggedOn) {
        	message.setStatus(Status.OK.enumValue());
        } else {
        	message.setStatus(Status.ERROR.enumValue());
        }
        return message;
	}
}
