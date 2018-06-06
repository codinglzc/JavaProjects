package lintcode;

import java.util.Arrays;

/**
 * @Description: 211. 字符串置换
 * <p>
 * 给定两个字符串，请设计一个方法来判定其中一个字符串是否为另一个字符串的置换。
 * 置换的意思是，通过改变顺序可以使得两个字符串相等。
 * <p>
 * 样例：
 * "abc" 为 "cba" 的置换。
 * "aabc" 不是 "abcc" 的置换。
 * @Author: lc
 * @Date: Created in 2018/3/6
 */
public class _211
{
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public static boolean Permutation(String A, String B)
    {
        char[] chA = A.toCharArray();
        char[] chB = B.toCharArray();
        Arrays.sort(chA);
        Arrays.sort(chB);
        return String.valueOf(chA).equals(String.valueOf(chB));
    }

    public static void main(String[] args)
    {
        System.out.println(_211.Permutation("abcd", "bcad"));
    }
}
