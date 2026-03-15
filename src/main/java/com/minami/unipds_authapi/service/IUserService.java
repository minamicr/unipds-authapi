package com.minami.unipds_authapi.service;

import com.minami.unipds_authapi.model.User;
import com.minami.unipds_authapi.security.MyToken;

public interface IUserService {
    User addUser(User user);
    User getByUsername(String username);
    MyToken login(User user);
}
