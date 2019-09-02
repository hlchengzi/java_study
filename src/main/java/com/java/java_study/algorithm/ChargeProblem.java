package com.java.java_study.algorithm;

import java.util.Date;

/**
 * 动态规划，金钱找零问题
 * @author xcxu
 * @data 2019/8/29
 **/
public class ChargeProblem {

    /**
     *
     * @param coinsValues 可用来找零的硬币 coinsValues.length是硬币的种类
     * @param n 待找的零钱
     * @return 最少硬币数目
     */
    public static int charge(int[] coinsValues, int n){
        int[][] c = new int[coinsValues.length + 1][n + 1];

        //特殊情况1
        for(int i = 0; i <= coinsValues.length; i++) {
            c[i][0] = 0;
        }
        for(int i = 0; i <= n; i++) {
            c[0][i] = Integer.MAX_VALUE;
        }


        for(int j_money = 1; j_money <=n; j_money++)
        {

            for(int i_coinKinds = 1; i_coinKinds <= coinsValues.length; i_coinKinds++)
            {
                //特殊情况2，coinsValues数组下标是从0开始的,  c[][]数组下标是从1开始计算的
                if(j_money < coinsValues[i_coinKinds-1])
                {
                    //只能使用 第 1...(i-1)枚中的硬币
                    c[i_coinKinds][j_money] = c[i_coinKinds - 1][j_money];
                    continue;
                }

                //每个问题的选择数目---选其中较小的
                if(c[i_coinKinds - 1][j_money] < (c[i_coinKinds][j_money - coinsValues[i_coinKinds-1]] +1)) {
                    c[i_coinKinds][j_money] = c[i_coinKinds - 1][j_money];
                }
                else {
                    c[i_coinKinds][j_money] = c[i_coinKinds][j_money - coinsValues[i_coinKinds - 1]] + 1;
                }
            }
        }
        System.out.println(coinsValues);
        return c[coinsValues.length][n];
    }

    /**
     * 递归解法
     * 方法简单，但时间复杂度是指数级别的
     * @param m
     * @param n
     * @return
     */
    public static int dp(int[] m, int n)
    {
        //递归出口
        for (int i = 0; i < m.length; i++) {
            if(m[i] == n){
                return 1;
            }
        }
        //因为求最小值，所以这里初始为最大值
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m.length; i++) {
            if (m[i] <= n) {
                ans = Math.min(ans, dp(m,n - m[i]) + 1);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        Date date1 = new Date();
        int[] arr = {1,3,4,7,13,15,24};
        long time1 = System.currentTimeMillis();
        System.out.println("dp:"+dp(arr,50));
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        System.out.println("dp:"+String.valueOf(charge(arr,5000)));
        long time3 = System.currentTimeMillis();
        System.out.println(time3-time2);
    }
}
