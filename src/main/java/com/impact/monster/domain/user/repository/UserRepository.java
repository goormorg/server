package com.impact.monster.domain.user.repository;

import com.impact.monster.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndEmail(String email, String name);

    @Query("select u.password " +
            "from User u " +
            "where u.email = :email")
    String findPasswordByEmail(@Param("email") String email);

    @Query("select new map(u.name as name, u.email as email, u.birth as birth, u.fat as fat, u.gender as gender, " +
            "u.height as height, u.weight as weight, u.phoneNumber as phoneNumber, u.skeletalMuscle as skeletalMuscle, u.target as target) " +
            "from User u " +
            "where u.email = :email")
     Object[] findDetailByEmail(String email);

}
