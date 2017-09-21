// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.services;

import cepak.antoni.booble.jrs.model.RegisteredUser;
import cepak.antoni.booble.repositories.LoginRepository;

/**
 * @author pl041antcepa, 15 wrz 2017 CRIF IT Solutions Poland
 */
public class LoginService {
    private static LoginRepository loginRepository = new LoginRepository();

    public RegisteredUser login(String nick, String password) {
        if (loginRepository.isAvaiable(nick)) {
            return loginRepository.registerUser(nick, password);
        }
        return loginRepository.getUser(nick, password);
    }
    
    public boolean login(String nick) {
        if (loginRepository.isAvaiable(nick)) {
            return true;
        }
        return false;
    }
}
