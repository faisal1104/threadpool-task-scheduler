package com.example.threadpooltaskschedulerdemo.controller;

import com.example.threadpooltaskschedulerdemo.scheduler.ThreadPoolTaskSchedulerDemo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduler1")
public class Sheduler1Controller {

  @Autowired
  private ThreadPoolTaskScheduler taskScheduler;

  @PostMapping("/with-cron-expression")
  public String startCronScheduler(@RequestParam String cronExpression){
    var cronTrigger = new CronTrigger(cronExpression);
    taskScheduler.initialize();
    taskScheduler.setBeanName("scheduler1");
    taskScheduler.schedule(new ThreadPoolTaskSchedulerDemo1(), cronTrigger);
    return "Scheduler-1 with cron expression started";
  }

  @GetMapping("/stop")
  public String stopScheduler(){
    taskScheduler.shutdown();
    return "stopped 1";
  }
}
