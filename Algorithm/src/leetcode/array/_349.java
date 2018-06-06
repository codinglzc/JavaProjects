package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Description: 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * @Author: lc
 * @Date: Created in 2017/12/12
 */
public class _349
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        // 先把 nums1 里面的元素放到一个无重复元素的 HashSet 中
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++)
        {
            set1.add(nums1[i]);
        }
        List<Integer> intersectionList = new ArrayList<Integer>();
        // 遍历 nums2 寻找交集元素，找到后需要删除 set1 中相应的元素
        for (int i = 0; i < nums2.length; i++)
        {
            if (set1.contains(nums2[i]))
            {
                intersectionList.add(nums2[i]);
                set1.remove(nums2[i]);
            }
        }
        int[] result = new int[intersectionList.size()];
        for (int i = 0; i < intersectionList.size(); i++)
        {
            result[i] = intersectionList.get(i);
        }
        return result;
    }
}
