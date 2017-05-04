package com.zl;

import java.util.Scanner;

/**
 * 求数字反转算法
 *
 * @author zl
 * @time 2017.05.03
 */
public class ReverseInteger {
    private static int answer1, answer2;

    public static void main(String[] args) {
        System.out.println("请输入数字：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        answer1 = reverse1(num);//solution1
        answer2 = reverse2(num);//solution2

        System.out.println("solution1 反转后为：" + answer1);
        System.out.println("solution2 反转后为：" + answer2);
    }

    /**
     * solution1
     * 思路：
     * 例如：求 123 的 反转，反转后为 321
     * 1.取所给数的最后一位 3 ，也就是取余，123%10=3，去掉3以后变为 123/10=12
     * 2.每次都取最后一位数，拼接到结果后面，即 3*10+2=32，最后就是32*10+1=321
     *
     * 12345的反转是54321
     * 5*10+4=54 ,  54*10+3=543,   543*10+2=5432 , 5432*10+1=54321
     *
     */
    private static int reverse1(int num) {
        int result = 0;
        while (num != 0) {                                       //若为0，取反则为0，直接返回result = 0
            int tail = num % 10;                                 //每次取最后一位，求余数
            int newResult = result * 10 + tail;                  //之前的结果乘以10，加上新取得的数，就是最新的结果
            if ((newResult - tail) / 10 != result) {             //判断是否越界，整型的范围在-2^31~2^31-1,超出范围则返回0
                                                                 //如果越界，将上一步newResult = result * 10 + tail，转换之后结果会不相等
                return 0;
            }
            result = newResult;
            num = num / 10;                                       //每次去掉最后一位
        }
        return result;
    }

    //solution2，和solution1类似，主要是判断越界不一样
    private static int reverse2(int num) {
        long result = 0;
        while (num != 0) {
            result = result * 10 + num % 10;
            num = num / 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {   //判断越界
                return 0;
            }
        }
        return (int) result;
    }

}