package com.saketh.wishmessagegenerator;

import com.saketh.wishmessagegenerator.sbeans.SeasonFinder;
import com.saketh.wishmessagegenerator.sbeans.WishMessage;
import com.saketh.wishmessagegenerator.sbeans.WishOnWeekOrWeekend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class WishMessageGeneratorApplication {
    @Bean(name = "dt")
    public LocalDate getLocalDate() {
        return LocalDate.now();
    }

    @Bean(name = "lt")
    public LocalTime getTime() {
        return LocalTime.now();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WishMessageGeneratorApplication.class, args);
        SeasonFinder seasonFinder = ctx.getBean("SF", SeasonFinder.class);
        WishMessage wishMessage = ctx.getBean("WM", WishMessage.class);
        WishOnWeekOrWeekend wishOnWeekOrWeekend = ctx.getBean("WW",WishOnWeekOrWeekend.class);
        String season = seasonFinder.getSeason();
        String wish = wishMessage.getWish();
        String weekOrWeekend = wishOnWeekOrWeekend.getMessageOnWeekOrWeekend();
        System.out.println(season);
        System.out.println(wish);
        System.out.println(weekOrWeekend);
        ((ConfigurableApplicationContext) ctx).close();
    }

}
