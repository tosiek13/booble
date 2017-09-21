// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import cepak.antoni.booble.engine.RoundTimer;
import cepak.antoni.booble.enums.RoomState;
import cepak.antoni.booble.jrs.model.ClientMessage;
import cepak.antoni.booble.jrs.model.Gamester;
import cepak.antoni.booble.jrs.model.MessageTypes;
import cepak.antoni.booble.jrs.model.Move;
import cepak.antoni.booble.jrs.model.Room;
import cepak.antoni.booble.jrs.model.RoomProxy;
import cepak.antoni.booble.jrs.model.ServerMessage;
import cepak.antoni.booble.jrs.model.exp.CServerMessage;
import cepak.antoni.booble.jrs.model.exp.MessageGenerator;

/**
 * @author pl041antcepa, 14 wrz 2017 CRIF IT Solutions Poland
 */
public class RoomsService {
    private static HashMap<String, String> sessionToRoomIdMap = new HashMap<>();
    private static HashMap<String, String> sessionToNickMap = new HashMap<>();
    private static HashMap<String, Room> roomId2RoomMap = new HashMap<>();
    private static int bootRoomId = 0;
    // private static HashMap<String, Set<GamerEndPoint>> roomToEndpointsMap = new HashMap<>();
    private static Timer roundTimer;

    static {
        Room room = createBootRoom();
        roomId2RoomMap.put(room.getRoomId(), room);

        roundTimer = new Timer();
        roundTimer.schedule(new RoundTimer(), 0, 5000);
    }

    // public static void scan() throws IOException, EncodeException {
    // for(Room room: roomId2RoomMap.values()) {
    // Date date = room.getLastRoundStart();
    // if(date != null) {
    // Date currentDate = new Date();
    // long diff = currentDate.getTime() - date.getTime();//as given
    // long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);
    // if(seconds > 5 /*&& room.isSummarySended()*/) {
    // ServerMessage message = MessageGenerator.newRoundMessage();
    // broadcastMessage(room, message);
    // room.setLastRoundStart(currentDate);
    // }
    //
    // } else {
    //
    // }
    //
    // }
    // }

    public ServerMessage getRoomsInfo() {
        List<RoomProxy> rooms = new LinkedList<>();
        for (String roomId : roomId2RoomMap.keySet()) {
            RoomProxy room = new RoomProxy();
            room.setRoomId(roomId);
            room.setParticipantsAmount(roomId2RoomMap.get(roomId).getGamesters().size());
            rooms.add(room);
        }
        ServerMessage response = new ServerMessage();
        response.setMessageType(MessageTypes.ROOMS.enumValue());
        response.setRooms(rooms);
        return response;
    }

    public Room joinRoom(Session session, String roomId) {
        String sessionId = session.getId();
        String currentRoomId = sessionToRoomIdMap.get(sessionId);
        Gamester joiner = null;
        if (currentRoomId == null) {
            joiner = createGamster(session);
        } else {
            // leave if already in
            Room room = getRoom(sessionId);
            joiner = room.getGamster(sessionToNickMap.get(sessionId));
            leaveRoom(session);
        }
        // join room
        sessionToRoomIdMap.put(sessionId, roomId);
        Room room = roomId2RoomMap.get(roomId);
        if (room == null) {
            room = createBootRoom();
        }
        List<Gamester> gamesters = room.getGamesters();
        for (Gamester gamster : gamesters) {
            if (joiner.getNick().equals(gamster.getNick())) {
                return room;
            }
        }
        gamesters.add(joiner);
        return room;
    }

    public static Room createBootRoom(int amountOfBoots) {
        List<Gamester> gamesters = new LinkedList<>();
        for (int i = 0; i < amountOfBoots; i++) {
            Gamester gamester = new Gamester();
            gamester.setNick("boot");
            gamester.setPoints(1000);
            gamester.setBoot(true);
            gamesters.add(gamester);
        }
        String roomId = "Room " + RoomsService.bootRoomId++;

        Room room = new Room();
        room.setRoomId(roomId);
        room.setGamesters(gamesters);
        roomId2RoomMap.put(roomId, room);
        return room;
    }

    private static Room createBootRoom() {
        return createBootRoom(1);
    }

    public ServerMessage sendRoomInfo(Session sesstion, String roomId) {
        ServerMessage response = new ServerMessage();
        response.setMessageType(MessageTypes.JOIN.enumValue());
        response.setRoom(roomId2RoomMap.get(roomId));

        return response;
    }

    public String escapeRoom(Session session) {
        String escaperNick = sessionToNickMap.get(session.getId());
        Room room = getRoom(session.getId());
        List<Gamester> gamesters = room.getGamesters();
        for (Gamester gamester : gamesters) {
            if (escaperNick.equals(gamester.getNick())) {
                gamesters.remove(gamester);
            }
        }

        return room.getRoomId();
    }

    private static void broadcastMessage(Room room, ServerMessage message) throws IOException, EncodeException {
        for (Gamester gamester : room.getGamesters()) {
            if (gamester.isBoot() == false) {
                MessageService.sendMessage(gamester.getSession(), message);
            }
        }
    }

    public Room getRoom(String sessionId) {
        String roomId = sessionToRoomIdMap.get(sessionId);
        return roomId2RoomMap.get(roomId);
    }

    private String getUserNick(String sessionId) {
        if (sessionToNickMap.get(sessionId) != null) {
            return sessionToNickMap.get(sessionId);
        } else {
            return "Annonim: " + sessionId;
        }

    }

    public void addUser(Session session) {
        sessionToNickMap.put(session.getId(), session.getId());
    }

    public Gamester createGamster(Session session) {
        Gamester gamster = new Gamester();
        gamster.setNick(getUserNick(session.getId()));
        gamster.setPoints(1000);
        gamster.setSession(session);
        return gamster;
    }

    public CServerMessage performMove(Session session, ClientMessage message) {
        String nick = getUserNick(session.getId());
        Room room = getRoom(session.getId());
        Gamester gamester = room.getGamster(nick);
        gamester.setMove(new Move(message.getyCenter(), message.getxCenter(), message.getRadius()));
        room.update();
        RoomState state = room.getRoomState();
        switch (state) {
            case READY:
                room.sumUpRound();
                ServerMessage response = MessageGenerator.roundSummary(room);
                CServerMessage serverMessage = response.export();
                room.nextRound();
                return serverMessage;
            default:
                break;
        }
        return null;
    }

    public void leaveRoom(Session session) {
        Room room = getRoom(session.getId());
        sessionToRoomIdMap.remove(session.getId());
        if(room != null) {
            room.removeGamester(getUserNick(session.getId()));
        }
    }
}
