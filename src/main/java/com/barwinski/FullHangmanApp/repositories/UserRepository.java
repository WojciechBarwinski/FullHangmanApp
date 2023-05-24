package com.barwinski.FullHangmanApp.repositories;


import com.barwinski.FullHangmanApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String userName);
}
