package leetcode.array;

/**
 * @Description: 258. Add Digits
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * <p>
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * @Author: lc
 * @Date: Created in 2017/12/20
 */
public class _258
{
    /**
     * 找规律，列出 1-30 的结果，可以发现，每 9 个一循环
     */
    public int addDigits(int num)
    {
        return 1 + (num - 1) % 9;
    }
}
