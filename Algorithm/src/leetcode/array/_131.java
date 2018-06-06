package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 131. Palindrome Partitioning
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * @Author: lc
 * @Date: Created in 2017/12/20
 */
public class _131
{
    /**
     * 【思路】
     * 本题考查回溯算法。从下标0开始遍历字符串，一旦在下标 i 找到回文子字符串，那么就把下标从 0 到 i 的子字符串加入temp中，
     * 继续从下标 i 接着往下找，一旦curIndex等于字符串长度，那么就把temp加入到result中。如果一直到最后都没找到回文子字符串，那么就进行剪枝：
     */
    public List<List<String>> partition(String s)
    {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        dfs(s, 0, temp, result);
        return result;
    }

    /**
     * 深度优先搜索
     */
    private void dfs(String s, int curIndex, List<String> temp, List<List<String>> result)
    {
        if (curIndex == s.length())
        {
            result.add(new ArrayList<String>(temp));
            return;
        }
        for (int i = curIndex + 1; i <= s.length(); i++)
        {
            String prefix = s.substring(curIndex, i);
            if (!isPrlindrome(prefix))  //剪枝
                continue;
            temp.add(prefix);
            dfs(s, i, temp, result);
            temp.remove(temp.size() - 1); // 每当 dfs 返回之后，退回上一个节点
        }
    }

    /**
     * 判断字符串是否为回文数
     */
    private boolean isPrlindrome(String s)
    {
        int left = 0;
        int right = s.length() - 1;
        while (left < right)
        {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args)
    {
        _131 obj = new _131();
        obj.partition("aabbaa").forEach(System.out::println);
    }
}
