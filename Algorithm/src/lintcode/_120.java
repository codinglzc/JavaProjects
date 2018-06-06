package lintcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description: 120. 单词接龙
 * 给出两个单词（start和end）和一个字典，找到从start到end的最短转换序列
 * <p>
 * 比如：
 * 1. 每次只能改变一个字母。
 * 2. 变换过程中的中间单词必须在字典中出现。
 * <p>
 * 注意事项:
 * · 如果没有转换序列则返回0。
 * · 所有单词具有相同的长度。
 * · 所有单词都只包含小写字母。
 * <p>
 * 样例:
 * 给出数据如下：
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 一个最短的变换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog"，
 * 返回它的长度 5
 * <p>
 * 标签：
 * BFS
 * @Author: lc
 * @Date: Created in 2018-04-10
 */
public class _120
{
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict)
    {
        // write your code here
        if (start.equals(end)) return 1;

        dict.add(start);
        dict.add(end);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int result = 1;
        while (!queue.isEmpty())
        {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                String tmp = queue.poll();
                for (int j = 0; j < tmp.length(); j++)
                {
                    for (char k = 'a'; k <= 'z'; k++)
                    {
                        if (tmp.charAt(j) == k) continue;
                        char[] tmpChars = tmp.toCharArray();
                        tmpChars[j] = k;
                        String newStr = String.valueOf(tmpChars);
                        if (!dict.contains(newStr) || visited.contains(newStr)) continue;
                        if (newStr.equals(end)) return result;
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return 0;
    }
}
