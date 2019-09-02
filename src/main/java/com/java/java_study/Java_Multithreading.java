package com.java.java_study;

import java.util.concurrent.ExecutorService;

/**
 * @author xcxu
 * @data 2019/8/28
 **/
public class Java_Multithreading {

    /**
     * 创建线程的三种方式：
     * 1，创建Thread
     * Thread类本质上是实现了Runnable接口的一个实例，代表一个线程的实例。启动线程的唯一方法就是通过Thread类的start()实例方法。
     * start()方法是一个native方法，它将启动一个新线程，并执行run()方法。
     * 这种方式实现多线程很简单，通过自己的类直接extend Thread，并复写run()方法，就可以启动新线程并执行自己定义的run()方法。
     * 2，实现Runnable接口创建线程
     * 如果自己的类已经extends另一个类，就无法直接extends Thread，此时，可以实现一个Runnable接口，然后实现run
     * 3，实现Callable接口通过FutureTask包装器来创建Thread线程
     * callable接口和runnable方法一样，
     * 4，使用ExecutorService、Callable、Future实现有返回结果的线程
     */



}
