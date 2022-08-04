package com.studyProjectA.ShoppingMall.Repository;

import com.studyProjectA.ShoppingMall.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByID(int id);
}
