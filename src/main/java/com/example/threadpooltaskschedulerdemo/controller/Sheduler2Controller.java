package com.example.threadpooltaskschedulerdemo.controller;

import com.example.threadpooltaskschedulerdemo.scheduler.ThreadPoolTaskSchedulerDemo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/scheduler2")
public class Sheduler2Controller {

  @Autowired
  private ThreadPoolTaskScheduler taskScheduler;

  @PostMapping("/with-cron-expression")
  public String startCronSceduler(@RequestParam String cronExpression){
    var cronTrigger = new CronTrigger(cronExpression);
    taskScheduler.initialize();
    taskScheduler.setBeanName("scheduler2");
    taskScheduler.schedule(new ThreadPoolTaskSchedulerDemo2(), cronTrigger);
    return "Scheduler-2 with cron expression started";
  }

  @GetMapping("/stop")
  public String stopSceduler(){
    taskScheduler.shutdown();
    return "stopped 2";
  }
}
