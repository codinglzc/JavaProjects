package lintcode;

/**
 * @Description: 739. 24点
 * 你有 4 张卡片, 每一张上面都有一个 1 到 9 的数字. 你需要判断是否能用运算符 *, /, +, -, (, ) 来计算得到 24
 * <p>
 * 注意事项：
 * 除法运算符 / 是真正的除法, 而不是整数除法. 所以 4 / (1 - 2 / 3) = 12.
 * 所有的运算符位于两个数字之间. 尤其是, 我们不能将 - 当做一个一元运算符. 比如说, 输入为[1, 1, 1, 1], 表达式 - 1 - 1 - 1 - 1 是不允许的
 * 你不能将数字 串联 起来. 比如, 如果输入为 [1, 2, 1, 2], 我们不能写成 12 + 12
 * <p>
 * 样例：
 * 给出 nums = [4, 1, 8, 7], 返回 true // 8 * （7 - 4） * 1 = 24
 * 给出 nums = [1, 1, 1, 2], 返回 false
 * 给出 nums = [3, 3, 8, 8], 返回 true // 8 / ( 3 - 8 / 3) = 24
 * @Author: lc
 * @Date: Created in 2018-04-02
 */
public class _739
{
    /**
     * @param nums: 4 cards
     * @return: whether they could get the value of 24
     */
    public boolean compute24(double[] nums)
    {
        // write your code here
        return dp(nums, 24);
    }

    public boolean dp(double[] nums, double value)
    {
        if (nums.length == 1)
            return nums[0] - value <= 0.00001 && value - nums[0] <= 0.00001;

        double[] newNums = new double[nums.length - 1];
        for (int i = 0; i < nums.length; i++)
        {
            int index = 0;
            for (int j = 0; j < nums.length; j++)
            {
                if (i == j) continue;
                newNums[index++] = nums[j];
            }

            if (dp(newNums, value + nums[i])
                    || dp(newNums, value - nums[i])
                    || dp(newNums, value / nums[i])
                    || dp(newNums, value * nums[i])
                    || dp(newNums, nums[i] / value)
                    || dp(newNums, nums[i] - value))
                return true;
        }
        return false;
    }
}
