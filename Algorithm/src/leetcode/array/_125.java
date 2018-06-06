package leetcode.array;

/**
 * @Description: 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * @Author: lc
 * @Date: Created in 2017/12/19
 */
public class _125
{
    /**
     * 回文字符串验证
     * 注意：只考虑字母和数字，且不区分字母大小写
     */
    public boolean isPalindrome(String s)
    {
        s = s.toLowerCase().trim().replaceAll("[^a-z0-9]", "");
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;
        while (left < right)
        {
            if (c[left++] != c[right--])
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        _125 obj = new _125();
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = "0P";
        System.out.println(obj.isPalindrome(s1));
        System.out.println(obj.isPalindrome(s2));
        System.out.println(obj.isPalindrome(s3));
    }
}
