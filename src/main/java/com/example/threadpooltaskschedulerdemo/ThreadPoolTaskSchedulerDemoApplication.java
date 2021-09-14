package com.example.threadpooltaskschedulerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//reference :
//www.petrikainulainen.net/programming/spring-framework/spring-from-the-trenches-invoking-a-secured-method-from-a-scheduled-job/

@SpringBootApplication
//@EnableWebSecurity
//@EnableScheduling
public class ThreadPoolTaskSchedulerDemoApplication{

  public static void main(String[] args) {
    SpringApplication.run(ThreadPoolTaskSchedulerDemoApplication.class, args);
  }

}