package leetcode.array;

/**
 * @Description: 383. Ransom Note
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function
 * that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * 题目要求：
 * 题目叫做Ransom Note，勒索信，刚开始我还没理解这个题目的意思，尤其这个标题，和magazine有啥关系呢？后来仔细想想，才慢慢理解。勒索信，
 * 为了不暴露字迹，就从杂志上搜索各个需要的字母，组成单词来表达的意思。这样来说，题目也就清晰了，判断杂志上的字是否能够组成勒索信需要的那
 * 些字符。这里需要注意的就是杂志上的字符只能被使用一次，不过不用考虑大小写的问题。
 * @Author: lc
 * @Date: Created in 2017/12/26
 */
public class _383
{
    /**
     * 先遍历 magazine，列出其字母表个数，然后在遍历 ransomNote，对每次出现的字符在相应的字母表中减一。
     */
    public boolean canConstruct(String ransomNote, String magazine)
    {
        int[] arr = new int[26]; // 字母表
        for (int i = 0; i < magazine.length(); i++)
        {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++)
        {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
