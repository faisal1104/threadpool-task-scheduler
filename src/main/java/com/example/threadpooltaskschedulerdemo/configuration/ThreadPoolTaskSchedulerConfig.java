package com.example.threadpooltaskschedulerdemo.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;


@Configuration
public class ThreadPoolTaskSchedulerConfig {

  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
    var threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    threadPoolTaskScheduler.setPoolSize(5);
    threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
    return threadPoolTaskScheduler;
  }
}
