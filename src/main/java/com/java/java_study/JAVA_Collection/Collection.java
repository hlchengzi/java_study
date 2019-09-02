package com.java.java_study.JAVA_Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xcxu
 * @data 2019/8/28
 **/
public class Collection {

    /**
     * 借用 List 展示 Collection的一些相关操作
     * @param args
     */
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        /**
         * 添加
         */
        list.add("1");
        list.add("1");
        list.add("1");
        List<String> list1 = new ArrayList();
        /**
         * 批量添加
         */
        list1.addAll(list);
        /**
         * 向指定位置添加
         */
        list1.add(1,"list");
        /**
         * 将列表清空
         */
        list1.clear();
        /**
         * 批量删除
         */
        list1.removeAll(list);
        /**
         * 清空改元素或者对应下标的元素
         */
        list1.remove(1);
        /**
         * 判断集合是否为空
         * size().判断集合的大小
         */
        list.isEmpty();
        list.size();
        /**
         * 返回包含此collection中所有的元素的数组，也可以指定返回数组的类型
         */
        list.toArray();
        String[] strings = new String[2];
        list.toArray(strings);
        /**
         * 仅保留list1当中的出现的
         */
        list.retainAll(list1);

    }
    /**
     * 关于List的一些学习
     * List接口的常用实现类有ArrayList和LinkedList
     * List集合代表一个元素有序、可重复的集合，集合中每个元素都有其对应的顺序索引。List集合允许使用重复元素，可以通过索引来访问指定位置的集合元素 。
     * List集合默认按元素的添加顺序设置元素的索引，例如第一个添加的元素索引为0，第二个添加的元素索引为1......
     * List作为Collection接口的子接口，可以使用Collection接口里的全部方法。而且由于List是有序集合，因此List集合里增加了一些根据索引来操作集合元素的方法。
     */
}
