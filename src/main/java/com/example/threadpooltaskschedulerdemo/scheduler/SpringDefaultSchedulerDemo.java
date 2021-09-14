package com.example.threadpooltaskschedulerdemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringDefaultSchedulerDemo {

  //Need to add @EnableScheduling annotation
  @Scheduled(cron = "0 0/1 * * * ?") // Fires after every 1 minute
  public void  printMyName(){
    System.out.println("");
  }
}
