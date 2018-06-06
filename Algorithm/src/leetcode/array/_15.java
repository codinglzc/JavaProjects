package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @Author: lc
 * @Date: Created in 2018/3/4
 */
public class _15
{
    public static List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int m = 0; m < nums.length; m++)
        {
            if (nums[m] > 0) break;
            if (m > 0 && nums[m] == nums[m - 1]) continue;
            int l = m + 1, r = nums.length - 1;
            while (l < r)
            {
                int sum = nums[l] + nums[r] + nums[m];
                if (sum == 0)
                {
                    List<Integer> oneList = new ArrayList<>();
                    oneList.add(nums[m]);
                    oneList.add(nums[l]);
                    oneList.add(nums[r]);
                    result.add(oneList);
                    l++;
                    r--;
                    while (l < r && l > 0 && nums[l] == nums[l - 1]) l++;
                    while (l < r && r < nums.length - 1 && nums[r] == nums[r + 1]) r++;
                } else if (sum > 0)
                {
                    r--;
                } else
                {
                    l++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        _15.threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6});
    }
}
