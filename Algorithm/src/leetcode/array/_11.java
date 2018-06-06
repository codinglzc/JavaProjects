package leetcode.array;

/**
 * @Description: 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines
 * are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * @Author: lc
 * @Date: Created in 2018/3/4
 */
public class _11
{
    public int maxArea(int[] height)
    {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right)
        {
            result = Math.max(result, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return result;
    }
}
