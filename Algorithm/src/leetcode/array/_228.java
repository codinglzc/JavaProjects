package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 228. Summary Ranges
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * Input: [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * <p>
 * Example 2:
 * Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * @Author: lc
 * @Date: Created in 2017/12/16
 */
public class _228
{
    public List<String> summaryRanges(int[] nums)
    {
        List<String> result = new ArrayList<String>();
        if (nums.length < 1)
            return result;
        int left = nums[0];
        int index = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (index == nums[i] - 1)
                index++;
            else
            {
                if (left == index)
                {
                    result.add(left + "");
                } else
                {
                    result.add(left + "->" + index);
                }
                left = nums[i];
                index = nums[i];
            }

        }
        if (left == index)
            result.add(left + "");
        else
            result.add(left + "->" + index);
        return result;
    }
}
