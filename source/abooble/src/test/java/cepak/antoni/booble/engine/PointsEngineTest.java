// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.engine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cepak.antoni.booble.jrs.model.Gamester;
import cepak.antoni.booble.jrs.model.Move;

/**
 * @author pl041antcepa, 20 wrz 2017 CRIF IT Solutions Poland
 */
public class PointsEngineTest {

    /**
     * Test method for {@link cepak.antoni.booble.engine.PointsEngine#splitPoints(java.util.List)}.
     */
    @Test
    public void testOverlappingOverlaps() {
        //given
        Gamester user = new Gamester();
        user.setMove(new Move(0, 0, 10));
        Gamester user2 = new Gamester();
        user2.setMove(new Move(0, 0, 9));

        //when
        boolean result = PointsEngine.doesFirstOverlap(user, user2);

        //then
        assertTrue(result);
    }
    
    @Test
    public void testOverlappingNoCommonPart() {
        //given
        Gamester user = new Gamester();
        user.setMove(new Move(0, 0, 10));
        Gamester user2 = new Gamester();
        user2.setMove(new Move(0, 0, 9));

        //when
        boolean result = PointsEngine.doesFirstOverlap(user2, user);

        //then
        assertFalse(result);
    }
    
    @Test
    public void testOverlappingNoCommonPart2() {
        //given
        Gamester user = new Gamester();
        user.setMove(new Move(0, 0, 10));
        Gamester user2 = new Gamester();
        user2.setMove(new Move(12, 0, 1));

        //when
        boolean result = PointsEngine.doesFirstOverlap(user2, user);

        //then
        assertFalse(result);
    }
}
