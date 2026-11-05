package com.saketh.wishmessagegenerator.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component("WM")
public class WishMessage {
    @Autowired
    private LocalTime localTime;
    @Value("${app.user.name}")
    private String name;

    public String getWish() {
        int hour = localTime.getHour();
        if (hour >= 4 && hour <= 12) {
            return "Good Morning " + name;
        } else if (hour >= 12 && hour <= 16) {
            return "Good Afternoon " + name;
        } else if (hour >= 16 && hour <= 22) {
            return "Good Evening " + name;
        } else {
            return "Good Night " + name;
        }
    }
}
