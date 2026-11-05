package com.saketh.wishmessagegenerator.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component("SF")
public class SeasonFinder {
    @Autowired
    private LocalDate ldate;
    public String getSeason()
    {
        int month = ldate.getMonthValue();
        if(month>=3&&month<=6)
        {
            return "Summer Season";
        }
        else if (month>=7 && month<=10)
        {
            return "Rainy Season";
        }
        else {
            return "Winter Season";
        }
    }
}
