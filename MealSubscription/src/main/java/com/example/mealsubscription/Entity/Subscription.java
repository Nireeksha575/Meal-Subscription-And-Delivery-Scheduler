package com.example.mealsubscription.Entity;

import com.example.mealsubscription.Enum.MealSlot;
import com.example.mealsubscription.Enum.ScheduleType;
import com.example.mealsubscription.Enum.Status;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private MealSlot slot;
    private ScheduleType scheduleType;
    private DayOfWeek dayOfWeek;
    private Status status;
    private LocalDateTime nextDeliveryTime;
    private LocalDateTime created_at;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MealSlot getSlot() {
        return slot;
    }

    public void setSlot(MealSlot slot) {
        this.slot = slot;
    }

    public ScheduleType getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(ScheduleType scheduleType) {
        this.scheduleType = scheduleType;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getNextDeliveryTime() {
        return nextDeliveryTime;
    }

    public void setNextDeliveryTime(LocalDateTime nextDeliveryTime) {
        this.nextDeliveryTime = nextDeliveryTime;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    @PrePersist
    public void setCreated_at() {
        this.created_at = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
