package com.vvieira.app.security.repository;

import com.vvieira.app.security.entity.Usuario;
import com.vvieira.util.structural.GenericRespository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRespository<Usuario,Long> {

    Optional<Usuario> findByUsername(String username);
    Boolean existsByUsername(String username);
    Optional<Usuario> findByEmail(String email);
}
