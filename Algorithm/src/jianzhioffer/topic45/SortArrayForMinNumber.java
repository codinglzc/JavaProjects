package jianzhioffer.topic45;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>
 * 面试题45：把数组排成最小的数（P.227）
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如，输入数组{3,32,321}，则打印出这3个数字能排成的最小数字321323。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-13
 */
public class SortArrayForMinNumber
{
    public static void printMinNumber(Integer[] nums)
    {
        if (nums == null || nums.length <= 0) return;

        Arrays.sort(nums, (o1, o2) ->
        {
            String str12 = String.valueOf(o1) + String.valueOf(o2);
            String str21 = String.valueOf(o2) + String.valueOf(o1);
            if (str12.equals(str21)) return 0;
            for (int i = 0; i < str12.length(); i++)
            {
                if (str12.charAt(i) < str21.charAt(i)) return -1;
                else if (str12.charAt(i) > str21.charAt(i)) return 1;
            }
            return 0;
        });

        for (Integer num : nums)
        {
            System.out.print(num);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        printMinNumber(new Integer[]{3, 32, 321});
    }
}
