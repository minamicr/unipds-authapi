package com.minami.unipds_authapi.service;

import com.minami.unipds_authapi.exceptions.InvalidPasswordException;
import com.minami.unipds_authapi.exceptions.InvalidUserException;
import com.minami.unipds_authapi.model.User;
import com.minami.unipds_authapi.repo.UserRepo;
import com.minami.unipds_authapi.security.MyToken;
import com.minami.unipds_authapi.security.TokenUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User addUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User getByUsername(String username) {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new InvalidUserException("Usuário " + username + " não encontrado"));
    }

    @Override
    public MyToken login(User user) {
        User storedUser = userRepo.findByUsername(user.getUsername()).orElseThrow(() -> new InvalidUserException("Usuário " + user.getUsername() + " não encontrado"));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(user.getPassword(), storedUser.getPassword())){
            return TokenUtil.encode(storedUser);
        } else {
            throw new InvalidPasswordException("Unauthorized user");
        }
    }
}
