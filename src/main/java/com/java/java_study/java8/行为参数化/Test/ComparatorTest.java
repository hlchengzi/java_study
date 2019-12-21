package com.java.java_study.java8.行为参数化.Test;

import com.java.java_study.java8.行为参数化.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description  用Comparator排序
 * @Data 2019/12/21 19:52
 * @Author xcxu
 **/
public class ComparatorTest {
    public static void main(String[] args) {

        /**
         * List里面自带一个sort方法，也可以使用Collections.sort。sort的行为可以用java.util.Comparator对象参数化
         * public interface Comparator<T>{
         *  public int compare(T o1,T o2);
         * }
         */
        List<Apple> appleList = new ArrayList<>();
        for (int i = 0; i < 1000 ; i++) {
            int w = (int)(Math.random()*(300-1+1));
            appleList.add(Apple.builder().weight(w).color(i%3==0?"Green":"Red").build());
        }
        /**
         * 匿名表达式
         */
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight()-o2.getWeight();
            }
        });
        /**
         * lambda表达式
         */
        appleList.sort((Apple a,Apple b)->{
            return a.getWeight()-b.getWeight();
        });

        for (Apple a:appleList) {
            System.out.println(a);
        }


    }
}
