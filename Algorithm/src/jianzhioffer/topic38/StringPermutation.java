package jianzhioffer.topic38;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 面试题38：字符串的排列（P.197）全排列问题
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如，输入字符串 abc，则打印出由字符 a,b,c所能排列出来的所有字符串 abc、acb、bac、bca、cab和cba。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-12
 */
public class StringPermutation
{
    public static void permutation(String str)
    {
        if (str == null) return;


        List<String> stringList = new ArrayList<>();
        permutation(str, stringList, 0);

        stringList.forEach(System.out::println);
    }

    private static void permutation(String str, List<String> stringList, int index)
    {
        if (index >= str.length())
        {
            stringList.add(str);
            return;
        }

        for (int i = index; i < str.length(); i++)
        {
            str = swap(str, index, i);
            permutation(str, stringList, index + 1);
            str = swap(str, index, i);
        }
    }

    private static String swap(String str, int m, int n)
    {
        char[] chars = str.toCharArray();
        char tmp = chars[m];
        chars[m] = chars[n];
        chars[n] = tmp;
        return String.valueOf(chars);
    }

    public static void main(String[] args)
    {
        permutation("abc");
        permutation("a");
        permutation("");
        permutation(null);
    }
}
