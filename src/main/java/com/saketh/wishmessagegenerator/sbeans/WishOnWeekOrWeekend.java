package com.saketh.wishmessagegenerator.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component("WW")
public class WishOnWeekOrWeekend {
    @Autowired
    private LocalDate localDate;
    @Value("${app.user.name}")
    private String name;
    public String getMessageOnWeekOrWeekend()
    {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        if (dayOfWeek==DayOfWeek.SATURDAY || dayOfWeek==DayOfWeek.SUNDAY)
        {
            return "Enjoy your weekend " +name;
        }
        else{
            return "Happy working hours "+name;
        }
    }
}
