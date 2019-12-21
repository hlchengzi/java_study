package com.java.java_study.java8.行为参数化.Test;

import com.java.java_study.java8.行为参数化.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xcxu
 * @Description  策略
 * @Data 2019/12/20 14:41
 * @补充： 多种行为一个参数，当把新的行为传递filterApples的时候需要声请写几个ApplePredicate的接口，然后实例几个只会使用一次的该对象
 **/
public class Test {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        for (int i = 0; i < 1000 ; i++) {
            int w = (int)(Math.random()*(300-1+1));
            appleList.add(Apple.builder().weight(w).color(i%3==0?"Green":"Red").build());
        }

        /**
         * 筛选出符合体重的苹果
         */
        ApplePredicate applePredicate = new AppleHeavyWeightPredicate();
        List<Apple> resultWeight = FilterApples.filterApples(appleList,applePredicate);
        System.out.println(resultWeight.size());

        /**
         * 筛选出符合体重颜色的苹果
         * 使用的是匿名内部类，没有显示的实现接口创建类，而是在使用的时候直接创建
         */
        ApplePredicate appleGreenColorPredicate = new AppleGreenColorPredicate();
        List<Apple> resultGreen = FilterApples.filterApples(appleList,appleGreenColorPredicate);
        System.out.println(resultGreen.size());

        List<Apple> resultGreenWeight = FilterApples.filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("Green") && apple.getWeight()>150;
            }
        });
        System.out.println(resultGreenWeight.size());

        /**
         * 使用lambda表达式
         */
        List<Apple>  listApple = FilterApples.filterApples(appleList,(Apple a)->"Red".equals(a.getColor()) && a.getWeight()>150);
        System.out.println(listApple.size());

        /**
         * 将List类型抽象化
         */
        List<Apple> redApple = FilterApples.filter(appleList,(Apple a)->"Red".equals(a.getColor()) && a.getWeight() > 150);
        System.out.println(redApple.size());

        /**
         *
         */
    }
}
