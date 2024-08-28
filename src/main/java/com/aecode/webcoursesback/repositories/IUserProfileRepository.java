package com.aecode.webcoursesback.repositories;

import com.aecode.webcoursesback.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserProfileRepository extends JpaRepository<UserProfile, Integer> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UserProfile u WHERE u.email = :email")
    boolean existsByProfile_email(@Param("email") String email);
    //Buscar user por email or user
    @Query("SELECT u FROM UserProfile u WHERE u.email = ?1 OR u.username = ?2")
    UserProfile findByEmailOrUsername(String email, String username);
}
