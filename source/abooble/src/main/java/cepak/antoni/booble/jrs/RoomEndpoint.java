package cepak.antoni.booble.jrs;

import java.io.IOException;
import java.sql.SQLException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import cepak.antoni.booble.db.MoveRepository;
import cepak.antoni.booble.jrs.coders.CServerMessageEncoder;
import cepak.antoni.booble.jrs.coders.ClientMessageDecoder;
import cepak.antoni.booble.jrs.coders.ClientMessageEncoder;
import cepak.antoni.booble.jrs.coders.ServerMessageDecoder;
import cepak.antoni.booble.jrs.coders.ServerMessageEncoder;
import cepak.antoni.booble.jrs.model.ClientMessage;
import cepak.antoni.booble.jrs.model.MessageTypes;
import cepak.antoni.booble.jrs.model.RegisteredUser;
import cepak.antoni.booble.jrs.model.Room;
import cepak.antoni.booble.jrs.model.ServerMessage;
import cepak.antoni.booble.jrs.model.Status;
import cepak.antoni.booble.jrs.model.exp.CServerMessage;
import cepak.antoni.booble.jrs.model.exp.MessageGenerator;
import cepak.antoni.booble.services.LoginService;
import cepak.antoni.booble.services.MessageService;
import cepak.antoni.booble.services.RoomsService;

/**
 * @author pl041antcepa, 20 wrz 2017
 * CRIF IT Solutions Poland
 */
@ServerEndpoint(value = "/room", decoders = { ClientMessageDecoder.class, ServerMessageDecoder.class }, encoders = { ClientMessageEncoder.class,
        ServerMessageEncoder.class, CServerMessageEncoder.class })
public class RoomEndpoint {
    private RoomsService roomService = new RoomsService();
    private LoginService loginService = new LoginService();

    @OnOpen
    public void onOpen(Session session) {
        roomService.addUser(session);
    }

    @OnMessage
    public void onMessage(Session session, ClientMessage message) throws IOException, EncodeException, SQLException {
        String sessionID = session.getId();

        MessageTypes.parse(message.getMessageType());
        message.getMessageType();
        switch (MessageTypes.parse(message.getMessageType())) {
            case NEW_ROOM:
                Room genRoom = RoomsService.createBootRoom(message.getPlayersAmount());
                roomService.joinRoom(session, genRoom.getRoomId());
                ServerMessage resp = MessageGenerator.roomInfoMessage(genRoom);
                MessageService.sendMessage(session, resp);
                break;
            case JOIN:
                String joinerRoomId = message.getRoomId();
                Room room = roomService.joinRoom(session, joinerRoomId);
                ServerMessage response = MessageGenerator.roomInfoMessage(room);
                MessageService.sendMessage(session, response);
                break;
            case INFO:
                break;
            case CREATE_OBJECT:
                break;
            case ROOMS:
                ServerMessage roomsInfoResponse = roomService.getRoomsInfo();
                MessageService.sendMessage(session, roomsInfoResponse);
                break;
            case MOVE:
                CServerMessage roundSummary = roomService.performMove(session, message);
                if (roundSummary != null) {
                    Room currentRoom = roomService.getRoom(sessionID);
                    MessageService.broadcastMessage(currentRoom, roundSummary);
                    MessageService.sendMessage(session, roundSummary);
                    MoveRepository.insert(roundSummary);
                }
                break;
            case LOGIN:
                boolean loggedOn = loginService.login(message.getNick());
                MessageGenerator.userLogged(loggedOn);
                break;
            case LEAVE_ROOM:
                roomService.leaveRoom(session);
                ServerMessage leftRoomAnswer =  MessageGenerator.leftRoom(Status.OK);
                MessageService.sendMessage(session, leftRoomAnswer);
                break;
            default:
                break;
        }
    }

    @OnClose
    public void onClose(Session session) {
        roomService.leaveRoom(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        roomService.leaveRoom(session);
    }
}