package com.example.threadpooltaskschedulerdemo.scheduler;

public class ThreadPoolTaskSchedulerDemo1 implements Runnable {

  static int counter = 1;

  @Override
  public void run() {
    System.out.println("ThreadPoolTaskSchedulerDemo1 is running with counter: "+ counter++);
  }
}
