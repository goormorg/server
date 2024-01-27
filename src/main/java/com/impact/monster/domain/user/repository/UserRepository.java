package com.impact.monster.domain.user.repository;

import com.impact.monster.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndEmail(String email, String name);

    @Query("select u.password " +
            "from User u " +
            "where u.email = :email and u.password = :password")
    String findPasswordByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("select u.password " +
            "from User u " +
            "where u.email = :email")
    String findPasswordByEmail(@Param("email") String email);
}
