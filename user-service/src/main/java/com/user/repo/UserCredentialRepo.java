package com.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.entity.UserCredential;

@Repository
public interface UserCredentialRepo extends JpaRepository<UserCredential, Integer> {

    @Query(value = "Select c.id from UserCredential c where LOWER(c.userName) = LOWER(:userName) and LOWER(c.password) = LOWER(:password) ")
    public Optional<Integer> signIn(@Param("userName") final String userName, @Param("password") final String password);
}
