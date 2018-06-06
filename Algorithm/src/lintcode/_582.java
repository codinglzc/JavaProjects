package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 582. 单词拆分II
 * 给一字串s和单词的字典dict,在字串中增加空格来构建一个句子，并且所有单词都来自字典。
 * 返回所有有可能的句子。
 * <p>
 * 样例：
 * 给一字串lintcode,字典为["de", "ding", "co", "code", "lint"]
 * 则结果为["lint code", "lint co de"]。
 * @Author: lc
 * @Date: Created in 2018/3/16
 */
public class _582
{
    /*
     * 此种方法只会有92%数据通过测试，后面的会超时。
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict)
    {
        // write your code here
        List<String> res = new ArrayList<>();

        Set<String> w_set = new HashSet<>();
        for (String str : wordDict)
        {
            for (char c : str.toCharArray())
            {
                w_set.add(String.valueOf(c));
            }
        }
        //Set<String> s_set = new HashSet<>();
        for (char c : s.toCharArray())
        {
            //s_set.add(String.valueOf(c));
            if (!w_set.contains(String.valueOf(c))) return res;
        }

        recur(s, wordDict, res, "", 0);
        return res;
    }

    public void recur(String s, Set<String> wordDict, List<String> res, String temp, int index)
    {
        if (temp.replace(" ", "").equals(s))
        {
            res.add(new String(temp));
            return;
        }

        for (int i = index + 1; i <= s.length(); i++)
        {
            String sub = s.substring(index, i);
            if (!wordDict.contains(sub)) continue;

            String pre = temp;
            if (temp.length() == 0)
            {
                temp += sub;
            } else
            {
                temp += " " + sub;
            }

            recur(s, wordDict, res, temp, i);

            temp = pre;
        }
    }

    public static void main(String[] args)
    {
        _582 obj = new _582();
        Set<String> wordDict = new HashSet<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa");
        obj.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", wordDict);
    }
}
