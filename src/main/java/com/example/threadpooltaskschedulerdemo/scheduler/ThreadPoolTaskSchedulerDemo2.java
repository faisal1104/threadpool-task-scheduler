package com.example.threadpooltaskschedulerdemo.scheduler;

public class ThreadPoolTaskSchedulerDemo2 implements Runnable {

  static int counter = 50000;

  @Override
  public void run() {
    System.out.println("ThreadPoolTaskSchedulerDemo2 is running with counter: "+ counter--);
  }
}
