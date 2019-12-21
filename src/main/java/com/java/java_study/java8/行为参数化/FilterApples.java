package com.java.java_study.java8.行为参数化;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xcxu
 * @Description
 * @Data 2019/12/20 14:31
 **/
public class FilterApples {

    /**
    * @Description: 策略模式(定义一组算法，把它们封装起来成为策略，然后在运行时候选择一个算法，算法族就是ApplePredicate,不同的策略就是AppleHeavyWeightPredicate)
    * @Param:  apples:筛选的对象 p：具体选择的策略
    * @return:
    **/
    public static List<Apple> filterApples(List<Apple> apples,ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (int i = 0; i < apples.size(); i++) {
            if(p.test(apples.get(i))){
                result.add(apples.get(i));
            }
        }
        return result;
    }

    /**
     * 行为参数化
     * @param list 链表
     * @param p 筛选条件
     * @param <T>   索要
     * @return
     */
    public static<T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(p.test(list.get(i))){
                result.add(list.get(i));
            }
        }
        return result;
    }
}
