package leetcode.array;

/**
 * @Description: 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place, do not allocate extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @Author: lc
 * @Date: Created in 2017/12/25
 */
public class _31
{
    /**
     * 这道题是给定一个数组和一个排列，求下一个排列。算法上其实没有什么特别的地方，主要的问题是经常不是一见到这个题就能马上理清思路。
     * 下面我们用一个例子来说明，比如排列是(2,3,6,5,4,1)，求下一个排列的基本步骤是这样：
     * 1) 先从后往前找到第一个不是依次增长的数，记录下位置p。比如例子中的3，对应的位置是1;
     * 2) 接下来分两种情况：
     * (1) 如果上面的数字都是依次增长的，那么说明这是最后一个排列，下一个就是第一个，其实把所有数字反转过来即可(比如(6,5,4,3,2,1)下一
     * 个是(1,2,3,4,5,6));
     * (2) 否则，如果p存在，从p开始往后找，找找找，找到第一个比他小的数，然后两个调换位置，比如例子中的4。调换位置后得到(2,4,6,5,3,1)。
     * 最后把p之后的所有数字倒序，比如例子中得到(2,4,1,3,5,6), 这个即是要求的下一个排列。
     */
    public void nextPermutation(int[] nums)
    {
        // 如果 nums 为空或者长度小于等于 1，则直接 return
        if (nums == null || nums.length <= 1)
            return;
        // 假设输入数组为 [2,3,9,7,4,3,3,2,1]
        // 从数组后面往前遍历，找到第一个不是升序（从后往前看）的数，记为 i-1，例子中为 nums[1] = 3;
        int i = nums.length - 1;
        for (; i > 0; i--)
        {
            if (nums[i - 1] < nums[i])
                break;
        }

        // 如果不存在这个 i - 1，即输入的数组已经是非严格降序排列,只需要将整个 nums 数组倒置即可
        if (i < 1)
        {
            inverted(nums, 0, nums.length - 1);
            return;
        }

        // 如果存在这个 i - 1
        // 现在已知 i-1 后面的数是降序（从前往后看）排列，故采用二分法，查找到满足：
        // nums[left] > nums[i - 1] && nums[i - 1] >= nums[left + 1] 的数的索引——left
        int left = i;
        int right = nums.length - 1;
        while (left < right)
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[i - 1] && nums[i - 1] >= nums[mid + 1])
            {
                left = mid;
                break;
            }
            if (nums[i - 1] >= nums[mid])
                right = mid;
            else
                left = mid + 1;
        }
        // 替换 i-1 和 left两个元素
        swap(nums, i - 1, left);
        // 将 i-1 后面的数按升序排列，即只需倒置即可
        inverted(nums, i, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 转置数组中的某个区间
     *
     * @param nums  被转置数组
     * @param left  起始索引
     * @param right 结束索引
     */
    private void inverted(int[] nums, int left, int right)
    {
        while (left < right)
        {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {1,3,2};
        _31 obj = new _31();
        obj.nextPermutation(nums);
    }
}
