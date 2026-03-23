package com.example.mealsubscription.Exceptions;

public class SubscriptionAlreadyExists extends RuntimeException{
    public SubscriptionAlreadyExists(String message) {
        super(message);
    }
}
