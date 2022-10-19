package com.springsecurity.repository;

import com.springsecurity.model.Client_1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSecurityRepository_3 extends JpaRepository<Client_1,Integer> {

    Optional<Client_1> findByClientUsername(String username);


}
