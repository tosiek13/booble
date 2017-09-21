// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.repositories;

import java.util.HashMap;
import java.util.Map;

import cepak.antoni.booble.jrs.model.RegisteredUser;

/**
 * @author pl041antcepa, 15 wrz 2017
 * CRIF IT Solutions Poland
 */
public class LoginRepository {
    private static Map<String, RegisteredUser> nickToRegisteredUserMap = new HashMap<>();
    
    static {
        RegisteredUser user = createUser("user", "password");
        nickToRegisteredUserMap.put(user.getNick(), user);
    }

    public RegisteredUser registerUser(String nick, String password) {
        RegisteredUser user = createUser(nick, password);
        nickToRegisteredUserMap.put(user.getNick(), user);
        return user;
       }

    public RegisteredUser getUser(String nick, String password) {
        RegisteredUser user = nickToRegisteredUserMap.get(nick);
        if(password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
    
    public boolean isAvaiable(String nick) {
        RegisteredUser user = nickToRegisteredUserMap.get(nick);
        if(user == null) {
            return true;
        }
        return false;
    }
    
    private static RegisteredUser createUser(String nick, String password) {
        RegisteredUser user = new RegisteredUser();
        user.setNick(nick);
        user.setPassword(password);
        user.setRank(100);
        return user;
    }
}
