package leetcode.array;

/**
 * @Description: 66. Plus One
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * @Author: lc
 * @Date: Created in 2018/1/17
 */
public class _66
{
    public int[] plusOne(int[] digits)
    {
        int i = digits.length - 1;
        for (; i >= 0; i--)
        {
            if (digits[i] < 9)
            {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
