package com.java.java_study.java8.行为参数化;

/**
 * @Author xcxu
 * @Description 继承ApplePredicate实现test方法，选出重的苹果，策略模式(针对filter方法的不同行为)。
 * @Data 2019/12/20 14:10
 **/
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>150;
    }
}
