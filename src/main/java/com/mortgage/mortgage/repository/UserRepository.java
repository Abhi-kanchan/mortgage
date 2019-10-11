package com.mortgage.mortgage.repository;



import com.mortgage.mortgage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
    User findAllByUserId(Double userId);
    User findByEmail(String email);


}
