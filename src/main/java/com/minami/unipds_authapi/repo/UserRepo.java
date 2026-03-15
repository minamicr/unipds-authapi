package com.minami.unipds_authapi.repo;

import com.minami.unipds_authapi.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepo extends ListCrudRepository<User, Integer> {
    public Optional<User> findByUsername(String username);
}
