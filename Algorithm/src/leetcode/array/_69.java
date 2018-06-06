package leetcode.array;

/**
 * @Description: 69. Sqrt(x)
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * x is guaranteed to be a non-negative integer.
 * <p>
 * <p>
 * Example 1:
 * Input: 4
 * Output: 2
 * <p>
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 * @Author: lc
 * @Date: Created in 2017/12/14
 */
public class _69
{
    public int mySqrt(int x)
    {
        int left = 1;
        int right = x;
        int mid = 0;
        while (left <= right)
        {
            mid = left + (right - left) / 2;
            if (mid == x / mid)
                return mid;
            else if (mid > x / mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }

    public static void main(String[] args)
    {
        _69 obj = new _69();
        System.out.println(obj.mySqrt(2147395599));
    }
}
