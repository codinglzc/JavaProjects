package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 18. 4Sum
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all
 * unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * @Author: lc
 * @Date: Created in 2018/3/5
 */
public class _18
{
    public static List<List<Integer>> fourSum(int[] nums, int target)
    {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (target > 0 && nums[i] > target) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++)
            {
                if (target > 0 && nums[j] > target) break;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right)
                {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target)
                    {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;
                        while (left > j + 1 && left < right && nums[left] == nums[left - 1]) left++;
                        while (right < nums.length - 2 && left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum > target)
                        right--;
                    else
                        left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {5, 5, 3, 5, 1, -5, 1, -2};
        int t = 4;
        _18.fourSum(nums, t);
    }
}
