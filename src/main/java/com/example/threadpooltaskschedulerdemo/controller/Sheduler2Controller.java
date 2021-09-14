package com.example.threadpooltaskschedulerdemo.controller;

import com.example.threadpooltaskschedulerdemo.scheduler.ThreadPoolTaskSchedulerDemo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduler2")
public class Sheduler2Controller {

  @Autowired
  private ThreadPoolTaskScheduler taskScheduler;

  @PostMapping("/with-cron-expression")
  public String startCronScheduler(@RequestParam String cronExpression){
    var cronTrigger = new CronTrigger(cronExpression);
    taskScheduler.setBeanName("scheduler2");
    taskScheduler.initialize();
    taskScheduler.schedule(new ThreadPoolTaskSchedulerDemo2(), cronTrigger);
    return "Scheduler-2 with cron expression started";
  }

  @GetMapping("/stop")
  public String stopScheduler(){
    taskScheduler.shutdown();
    return "Scheduler-2 stopped";
  }
}
