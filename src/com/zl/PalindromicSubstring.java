package com.zl;

import java.util.Scanner;

/**
 * 求字符串最长回文算法
 *
 * @author zl
 * @time 2017.05.03
 */
public class PalindromicSubstring {
    private static String answer;
    private static int lo, maxlen;

    public static void main(String[] args) {
        System.out.println("请输入字符串：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        answer = longestPalindromicSubstring(str);

        System.out.println("最长回文为：" + answer);
    }

    private static String longestPalindromicSubstring(String str) {
        int len = str.length();
        if (len < 2) {
            return str;
        }

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(str, i, i);
            extendPalindrome(str, i, i + 1);
        }
        return str.substring(lo, lo + maxlen);
    }

    private static void extendPalindrome(String str, int j, int k) {
        while (j >= 0 && k < str.length() && str.charAt(j) == str.charAt(k)) {
            j--;
            k++;
        }
        if (maxlen < k - j - 1) {
            lo = j + 1;
            maxlen = k - j - 1;
        }
    }
}
