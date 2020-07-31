package com.bida.springHomeWork.demo.repository;

import com.bida.springHomeWork.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String email);

    @Modifying
    @Transactional
    @Query(value = "update users\n" +
            "set user_role = 'ADMINISTRATOR'\n" +
            "where id = :id",
    nativeQuery = true
    )
    public void changeUserRoleToAdministrator(Long id);

    @Modifying
    @Transactional
    @Query(value = "update users\n" +
            "set user_role = 'USER'\n" +
            "where id = :id",
            nativeQuery = true
    )
    public void changeUserRoleToUser(Long id);
}
