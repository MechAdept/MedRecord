package com.samsolutions.repository;

import com.samsolutions.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    @Modifying
    @Transactional
    @Query("UPDATE Role r SET r.name = ?2 WHERE r.id = ?1")
    void updateProduct(Long id, String name);

//    Page<Role> getAllById(Pageable pageable);

//    Page<Role> findAllById(Pageable pageable);
}