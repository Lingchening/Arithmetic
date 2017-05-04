package com.zl;

import java.util.Scanner;

/**
 * 判断是否回文数算法
 *
 * @author zl
 * @time 2017.05.04
 */
public class PalindromeNumber {
    private static boolean answer;

    public static void main(String[] args) {
        System.out.println("请输入数字：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        answer = isPalindrome(num);

        System.out.println("是否为回文：" + answer);
    }

    private static boolean isPalindrome(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) {      //负数因为符号的原因，严格来说不算回文，所以排除，如果最后一位是0，回文要0开头，就不是数，故返回false
            return false;
        }
        int sum = 0;
        while (num > sum) {                               //回文只需要取一半就可以判断
            sum = sum * 10 + num % 10;                    //数的取反
            num = num / 10;
        }
        return (num == sum) || (num == sum / 10);           //例如，输入1234321，则num=123，sum=1234，结果为true
                                                            //或者123321，num=123,sum=123,故使用(num == sum) || (num == sum / 10)判断
    }
}
