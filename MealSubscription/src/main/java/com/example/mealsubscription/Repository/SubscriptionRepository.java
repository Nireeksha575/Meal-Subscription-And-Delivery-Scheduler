package com.example.mealsubscription.Repository;

import com.example.mealsubscription.Entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
}
