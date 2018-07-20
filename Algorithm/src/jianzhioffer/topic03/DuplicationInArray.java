package jianzhioffer.topic03;

import java.util.Arrays;

/**
 * @description: 面试题3：数组中重复的数字（P.39）
 * 在一个长度为 n 的数组里的所有数字都在 0~n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为 7 的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 * @author: Liu Cong
 * @create: Created at 2018-06-11
 */
public class DuplicationInArray
{
    /**
     * 法1：解决这个问题的一个简单的方法是先把输入的数组排序。从排序的数组中找出重复的数字是一件很容易的事情，只需要从头到尾扫描排序后的
     * 数组就可以了。
     * <p>
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     *
     * @param nums 输入数组
     * @return 如果找到重复数字则返回其中一个；反之返回-1。
     */
    public static int solution1(int[] nums)
    {
        if (nums == null || nums.length <= 0) return -1;
        for (int num : nums) if (num < 0 || num >= nums.length) return -1;

        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == pre) return pre;
            else
            {
                pre = nums[i];
            }
        }
        return -1;
    }

    /**
     * 法2：利用哈希表来解决这个问题。从头到尾按顺序扫描数组的每个数字，每扫描到一个数字的时候，都可以用O(1)的时间来判断哈希表里是否已经
     * 包含了该数字。如果哈希表里还没有这个数字，就把它加入到哈希表。如果哈希表里已经存在该数字了，就找到一个重复的数字。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums 输入数组
     * @return 如果找到重复数字则返回其中一个；反之返回-1。
     */
    public static int solution2(int[] nums)
    {
        if (nums == null || nums.length <= 0) return -1;
        for (int num : nums) if (num < 0 || num >= nums.length) return -1;

        int[] hashTable = new int[nums.length];
        hashTable[0] = -1;
        for (int num : nums)
        {
            if (hashTable[num] == num) return num;
            hashTable[num] = num;
        }
        return -1;
    }

    /**
     * 法3：重排这个数组。从头到尾依次扫描这个数组中的每个数字。当扫描到下标为i的数字时，首先比较这个数字（用 m 表示）是不是等于i。如果
     * 是，则接着扫描下一个数字；如果不是，则再拿它和第 m 个数字进行比较。如果它和第 m 个数字相等，就找到了一个重复的数字（该数字在下标
     * 为 i 和 m 的位置都出现了）；如果它和第 m 个数字不相等，就把第 i 个数字和第 m 个数字交换，把 m 放到属于它的位置。接下来再重复这
     * 比较、交换的过程，直到我们发现一个重复的数字。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 输入数组
     * @return 如果找到重复数字则返回其中一个；反之返回-1。
     */
    public static int solution3(int[] nums)
    {
        if (nums == null || nums.length <= 0) return -1;
        for (int num : nums) if (num < 0 || num >= nums.length) return -1;

        for (int i = 0; i < nums.length; i++)
        {
            while (i != nums[i])
            {
                if (nums[i] == nums[nums[i]]) return nums[i];

                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}