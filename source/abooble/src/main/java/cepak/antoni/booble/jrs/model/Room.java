// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import cepak.antoni.booble.engine.Boot;
import cepak.antoni.booble.engine.PointsEngine;
import cepak.antoni.booble.enums.RoomState;
import cepak.antoni.booble.jrs.model.exp.CGamester;
import cepak.antoni.booble.jrs.model.exp.CRoom;

/**
 * @author pl041antcepa, 14 wrz 2017 CRIF IT Solutions Poland
 */
public class Room {
    private String roomId;
    private List<Gamester> gamesters;
    private Date lastRoundStart;
    private boolean summarySended;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<Gamester> getGamesters() {
        return gamesters;
    }

    public void setGamesters(List<Gamester> gamesters) {
        this.gamesters = gamesters;
    }

    public CRoom export() {
        CRoom to = new CRoom();
        to.setRoomId(this.getRoomId());
        List<CGamester> cgamsters = new LinkedList<>();
        for (Gamester gamester : this.getGamesters()) {
            cgamsters.add(gamester.export());
        }
        to.setGamesters(cgamsters);
        return to;
    }

    public Date getLastRoundStart() {
        return lastRoundStart;
    }

    public void setLastRoundStart(Date lastRoundStart) {
        this.lastRoundStart = lastRoundStart;
    }

    public boolean isSummarySended() {
        return summarySended;
    }

    public void setSummarySended(boolean summarySended) {
        this.summarySended = summarySended;
    }

    public Gamester getGamster(String nick) {
        for (Gamester gamester : gamesters) {
            if (gamester.getNick().equals(nick)) {
                return gamester;
            }
        }
        return null;
    }

    public RoomState getRoomState() {
        for (Gamester gamester : gamesters) {
            if (gamester.isBoot() == false && gamester.getMove() == null) {
                return RoomState.WAITING_FOR_MOVES;
            }
        }
        for (Gamester gamester : gamesters) {
            if (gamester.isBoot() && gamester.getMove() == null) {
                return RoomState.WAITING_FOR_BOOT;
            }
        }
        return RoomState.READY;
    }

    public void update() {
        switch (getRoomState()) {
            case WAITING_FOR_BOOT:
                for (Gamester gamester : gamesters) {
                    if (gamester.getMove() == null) {
                        gamester.setMove(Boot.generateMove());
                    }
                }
                break;
            default:
                break;

        }
    }

    public void nextRound() {
        for (Gamester gamester : gamesters) {
            gamester.setMove(null);
        }
    }

    public List<Gamester> getNonBootUsers() {
        List<Gamester> nonBootGamesters = new LinkedList<>();
        for (Gamester gamester : gamesters) {
            if (gamester.isBoot() == false) {
                nonBootGamesters.add(gamester);
            }
        }
        return nonBootGamesters;
    }

    public Gamester removeGamester(String string) {
        for (Gamester gamester : gamesters) {
            if (gamester.isBoot() == false) {
                if(string.equals(gamester.getNick())) {
                    gamesters.remove(gamester);
                }
            }
        }
        return null;
    }

    public void sumUpRound() {
        PointsEngine.splitPoints(gamesters);
    }
}
