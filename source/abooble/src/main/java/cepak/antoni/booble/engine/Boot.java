// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.engine;

import java.util.Random;

import cepak.antoni.booble.jrs.model.Move;

/**
 * @author pl041antcepa, 14 wrz 2017
 * CRIF IT Solutions Poland
 */
public class Boot {
    private static Random generator = new Random();
    
    public static Move generateMove() {
        int x = generator.nextInt(800);
        int y = generator.nextInt(450);
        int r = generator.nextInt(100);
        
        return new Move(y, x, r);
    }
}
