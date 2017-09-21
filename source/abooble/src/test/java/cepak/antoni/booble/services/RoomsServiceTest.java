// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.services;

import javax.websocket.Session;

import org.junit.Test;

import cepak.antoni.booble.jrs.model.Gamester;
import junit.framework.TestCase;

/**
 * @author pl041antcepa, 14 wrz 2017 CRIF IT Solutions Poland
 */
public class RoomsServiceTest extends TestCase {
    private RoomsService roomService = new RoomsService();

    @Test
    public void testPrintProviderReportResponse() {
        Session session = null;
        
        Gamester gamester = new Gamester();
        gamester.setNick("nick1");
        gamester.setPoints(100);
        gamester.setSession(session);

        Gamester gamester2 = new Gamester();
        gamester2.setNick("nick1");

        Gamester gamester3 = new Gamester();
        gamester3.setNick("nick2");

//        roomService.joinRoom(gamester, "1", "room1");
//        roomService.joinRoom(gamester2, "2", "room1");
//        roomService.joinRoom(gamester3, "3", "room1");
//
//        assertEquals(2, roomService.getRoom("1").getGamesters().size());
    }
}