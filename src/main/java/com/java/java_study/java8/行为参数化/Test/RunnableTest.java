package com.java.java_study.java8.行为参数化.Test;

/**
 * @Description 使用 Runnable
 * @Data 2019/12/21 21:01
 * @Author xcxu
 **/
public class RunnableTest {

    /**
     * Runnable创建多线程，可以在Thread类中作为实现。创建线程，线程当中所执行的代码
     * t1 匿名内部类实现
     * t2 Lambda表达式创建
     */
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    });
    Thread t2 =new Thread(()->System.out.println(Thread.currentThread().getName()));
}
