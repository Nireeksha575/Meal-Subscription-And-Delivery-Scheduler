package com.example.mealsubscription.Service;

import com.example.mealsubscription.Config.MealSlotService;
import com.example.mealsubscription.DTO.SubscriptionRequest;
import com.example.mealsubscription.Enum.MealSlot;
import com.example.mealsubscription.Enum.ScheduleType;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class DeliveryTimeService {
    private final MealSlotService service;

    public DeliveryTimeService(MealSlotService service) {
        this.service = service;
    }

    public LocalDateTime calculateNextDelivery(SubscriptionRequest request, MealSlot slot){
      if(request.getScheduleType()== ScheduleType.DAILY){
          return calculateDailyNextDelivery(slot);
      }
      return calculateWeeklyNextDelivery(slot,request.getDayOfWeek());
    }

    private LocalDateTime calculateDailyNextDelivery(MealSlot slot){
        LocalTime slotTime=service.getTime(slot);
        LocalDate currentDate=LocalDate.now();
        LocalTime currentTime=LocalTime.now();

        if(currentTime.isBefore(slotTime)){
            return LocalDateTime.of(currentDate,slotTime);
        }
        return LocalDateTime.of(currentDate.plusDays(1),slotTime);

    }

    private LocalDateTime calculateWeeklyNextDelivery(MealSlot slot, DayOfWeek dayOfWeek){
        LocalTime slotTime=service.getTime(slot);
        LocalDate currentDate=LocalDate.now();
        LocalTime now=LocalTime.now();
        DayOfWeek today=currentDate.getDayOfWeek();

        int daysToAdd=dayOfWeek.getValue()- today.getValue();
        if(daysToAdd==0){
            if(now.isBefore(slotTime)){
                return LocalDateTime.of(currentDate,slotTime);
            }
            else{
                return LocalDateTime.of(currentDate.plusDays(7),slotTime);
            }
        }

        if(daysToAdd<0){
            daysToAdd+=7;
        }

        LocalDate nextDate=currentDate.plusDays(daysToAdd);
        return LocalDateTime.of(nextDate,slotTime);

    }
}
