package com.java.java_study.JAVA_Collection;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author xcxu
 * @data 2019/8/28
 **/


public class TreeSetTest {

    /**
     * TreeSet 四个构造器，底层都是基于TreeMap来实现的，与TreeSet类似的是，两者均是直接调用TreeMap的方法来实现的
     * 排序：
     *      对于数字，字符串，会按照自然顺序进行排序,如test1所示
     *      对于自定义对象：有两种实现方式：1，自然排序
     *                                               1.Student类中实现  Comparable<T>接口
     *                                               2.重写Comparable接口中的Compareto方法
     *                                  2，比较器排序
     *                                               1.单独创建一个比较类，让其继承Comparator<T>接口
     *                                               2.重写Comparator接口中的Compare方法
     *                                               3，在主类当中使用TreeSet(Comparator<? superE> comparator)构造一个新的空 TreeSet，它根据指定比较器进行排序。
     */
    public  static  void  test1(){
        Integer integer=1;
        TreeSet<Integer> ts = new TreeSet();
        TreeSet<String> ts1 = new TreeSet();

        // 创建元素并添加
        int[] list= new int[]{20, 18, 23, 22, 17, 24, 19, 18, 24};
        for (int i:list){
            ts.add(i);
        }

        Iterator<Integer> iterator = ts.iterator();
        while (iterator.hasNext()){
            Integer integer1 = iterator.next();
            System.out.println(integer1 );
        }

        String[] strings= new String[]{"c2","c1","b3","a6","tt7","tt4","h4","mmt","cc2","k1","k9",};
        for (String i:strings){
            ts1.add(i);
        }
        // 遍历
        for (Integer i : ts) {
            System.out.println(i);
        }
        for (String i : ts1) {
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        test1();
    }
}
