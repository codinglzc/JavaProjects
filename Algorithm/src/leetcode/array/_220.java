package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 220. Contains Duplicate III
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * @Author: lc
 * @Date: Created in 2018/1/23
 */
public class _220
{
    /**
     * 作为一个后续问题，当然也需要维护一个大小为k的窗口。当t == 0时，它减少到上一个问题，所以我们只是重用该解决方案。
     * <p>
     * 由于现在对被认为是重复的元素值的范围有一个约束，它提醒我们做一个在树数据结构中实现的范围检查，如果使用一个平衡的树结构，
     * 将采取O（LogN）或做一个持续时间的桶检查。我们将在这里讨论使用桶的想法。
     * <p>
     * Bucketing意味着我们将一系列值映射到一个桶。例如，如果桶的大小是3，我们认为0,1,2都映射到同一个桶。但是，如果t == 3，
     * 则（0，3）被视为重复项，但不会映射到同一个存储桶。这很好，因为我们之前和之后都在检查桶。所以，作为一个经验法则，只要
     * 确保桶的大小是合理的，使得具有相同桶的元素立即被认为是重复的，或者重复必须位于相邻桶内。因此，这实际上给了我们一个可
     * 能的桶大小的范围，即t和t + 1。我们只是选择它是t和桶映射为num / t。
     * <p>
     * 另一个复杂的是，负面的整数是允许的。一个简单的num / t只是将所有内容都缩小为0.因此，我们可以重新定位每个元素，
     * 从Integer.MIN_VALUE开始。
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++)
        {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);

            // 重复只会发生在相同桶内或相邻桶内
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;

            if (map.entrySet().size() >= k)
            {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }

            map.put(bucket, remappedNum);
        }
        return false;
    }
}
