// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.services;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import cepak.antoni.booble.jrs.model.Gamester;
import cepak.antoni.booble.jrs.model.Room;
import cepak.antoni.booble.jrs.model.ServerMessage;
import cepak.antoni.booble.jrs.model.exp.CServerMessage;

/**
 * @author pl041antcepa, 14 wrz 2017 CRIF IT Solutions Poland
 */
public class MessageService {
    public static void sendMessage(Session session, ServerMessage message) throws IOException, EncodeException {
        session.getBasicRemote().sendObject(message);
    }

    public static void sendMessage(Session session, CServerMessage message) throws IOException, EncodeException {
        session.getBasicRemote().sendObject(message);
    }

    public static void broadcastMessage(Room room, CServerMessage roundSummary) throws IOException, EncodeException {
        for(Gamester gamester: room.getGamesters()) {
            if(gamester.isBoot() == false) {
                sendMessage(gamester.getSession(), roundSummary);
            }
        }
    }
}
