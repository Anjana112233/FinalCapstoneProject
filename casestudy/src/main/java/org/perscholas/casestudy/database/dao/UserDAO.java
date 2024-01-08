package org.perscholas.casestudy.database.dao;


import jakarta.transaction.Transactional;
import org.perscholas.casestudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface UserDAO extends JpaRepository<User, Long> {
    public User findByEmailIgnoreCase(String email);


    //for testing
    @Modifying
    @Transactional
    int deleteByEmailIgnoreCase(String firstName);

}

