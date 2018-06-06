package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 * @Author: lc
 * @Date: Created in 2017/12/12
 */
public class _49
{
    /*
     * 关键点是建立大小为26的字母数组
     */
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        // 遍历输入数组
        for (String str : strs)
        {
            // 生命并初始化26个小写字母表
            char[] letters = new char[26];
            for (char c : str.toCharArray())
            {
                letters[c - 'a']++;
            }
            String key = new String(letters);
            if (map.containsKey(key))
            {
                map.get(key).add(str);
            } else
            {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args)
    {
        _49 obj = new _49();
        System.out.println(obj.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
