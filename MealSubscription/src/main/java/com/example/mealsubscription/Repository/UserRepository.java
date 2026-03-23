package com.example.mealsubscription.Repository;

import com.example.mealsubscription.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
