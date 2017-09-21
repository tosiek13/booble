// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.engine;

import java.util.LinkedList;
import java.util.List;

import cepak.antoni.booble.jrs.model.Gamester;

/**
 * @author pl041antcepa, 18 wrz 2017
 * CRIF IT Solutions Poland
 */
public class PointsEngine {

    public static void splitPoints(List<Gamester> gamesters) {
        for(Gamester gamester: gamesters) {
            List<Gamester> oponents = extractOponents(gamesters, gamester);
            for(Gamester oponent: oponents) {
                if(!separated(gamester, oponent)) {
                    if(doesFirstOverlap(gamester, oponent)) {
                        gamester.setPoints(gamester.getPoints() - 2);
                    } else {
                        gamester.setPoints(gamester.getPoints() + 1);
                    }
                }
            }
        }
    }

    private static List<Gamester> extractOponents(List<Gamester> gamesters, Gamester gamester) {
        List<Gamester> oponents = new LinkedList<>();
        for(Gamester current: gamesters) {
            if(!current.equals(gamester)) {
                oponents.add(current);
            }
        }
        return oponents;
    }
    
    public static boolean doesFirstOverlap(Gamester player, Gamester oponent) {
        double distance_pow2 = Math.pow(getDistance(player, oponent), 2);

        int radius = player.getMove().getRadius();
        int oponent_radius = oponent.getMove().getRadius();
        double value = Math.pow(radius - oponent_radius, 2);
        
        if(value > distance_pow2) {
            if(radius > oponent_radius) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean separated(Gamester player, Gamester oponent) {
        double distance = getDistance(player, oponent);
        int oponent_radius = oponent.getMove().getRadius();
        int radius = player.getMove().getRadius();
        double r_sum = radius + oponent_radius;
        
        if(distance > r_sum) {
            return true;
        }
        return false;
    }

    private static double getDistance(Gamester player, Gamester oponent) {
        int y = player.getMove().getY();
        int x = player.getMove().getX();
        
        int oponent_y = oponent.getMove().getY();
        int oponent_x = oponent.getMove().getX();
        
        return Math.sqrt((y - oponent_y)^2 + (x - oponent_x)^2);
    }
}
