// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs;

import java.io.IOException;
import java.sql.SQLException;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import org.junit.Test;

import cepak.antoni.booble.jrs.model.ClientMessage;
import cepak.antoni.booble.jrs.model.MessageTypes;

/**
 * @author pl041antcepa, 20 wrz 2017
 * CRIF IT Solutions Poland
 */
public class RoomEndpointTest {
    RoomEndpoint roomEndpoint = new RoomEndpoint();
    
    
    @Test
    public void test() throws IOException, EncodeException, SQLException {
        Session session = new MockSession();
        ClientMessage message = new ClientMessage();
        message.setMessageType(MessageTypes.JOIN.enumValue());
        message.setRoomId("Room0");
        
        roomEndpoint.onMessage(session, message);
    }
}
