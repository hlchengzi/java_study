package com.java.java_study.algorithm;

import java.util.Arrays;

/**
 * 最长递增子序列LIS
 * @author xcxu
 * @data 2019/8/29
 **/
public class MaxChildArrayOrder {

    public static int MaxChildArrayOrder(int a[]) {
        int n = a.length;
        //temp[i]代表0...i上最长递增子序列
        int temp[] = new int[n];
        for(int i=0;i<n;i++){
            //初始值都为1
            temp[i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j]&&temp[j]+1>temp[i]){
                    //如果有a[i]比它前面所有的数都大，则temp[i]为它前面的比它小的数的那一个temp+1取得的最大值
                    temp[i] = temp[j]+1;
                }
            }
        }
        int max = temp[0];
        //从temp数组里取出最大的值
        for(int i=1;i<n;i++){
            if(temp[i]>max){
                max = temp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,4,1,5,9,2,6,5};
        Integer result =MaxChildArrayOrder(arr);
        System.out.println(result);
    }
}
