package com.samsolutions.repository;

import com.samsolutions.entity.Role;
import com.samsolutions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE User  u SET u.username = ?2, u.password = ?3, u.roles = ?4 WHERE u.id = ?1")
    void updateUser(Long id, String username, String Password, List<Role> roleList);
}
