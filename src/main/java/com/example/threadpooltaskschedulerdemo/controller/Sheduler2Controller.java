package com.example.threadpooltaskschedulerdemo.controller;

import com.example.threadpooltaskschedulerdemo.scheduler.ThreadPoolTaskSchedulerDemo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduler2")
public class Sheduler2Controller {

  @Autowired private ThreadPoolTaskScheduler taskScheduler;

  @PostMapping("/with-cron-expression")
  public String startCronScheduler(@RequestParam String cronExpression) {
    var cronTrigger = new CronTrigger(cronExpression);

    // boolen isDaemon is used to block multiple scheduler of a single instance
    if (taskScheduler.isDaemon()) return "Scheduler-2 is already running.";

    taskScheduler.setBeanName("scheduler2");
    taskScheduler.initialize();
    taskScheduler.setDaemon(true);
    taskScheduler.schedule(new ThreadPoolTaskSchedulerDemo2(), cronTrigger);
    System.out.println(taskScheduler.isDaemon());
    return "Scheduler-2 with cron expression started";
  }

  @GetMapping("/stop")
  public String stopScheduler() {
    if (!taskScheduler.isDaemon()) return "Scheduler-2 is not started yet";
    taskScheduler.shutdown();
    return "Scheduler-2 stopped";
  }
}
