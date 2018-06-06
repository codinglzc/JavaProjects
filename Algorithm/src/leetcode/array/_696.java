package leetcode.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: 696. Count Binary Substrings
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 * <p>
 * Substrings that occur multiple times are counted the number of times they occur.
 * <p>
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10",
 * "0011", and "01".
 * <p>
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 * <p>
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * <p>
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 * <p>
 * Note:
 * s.length will be between 1 and 50,000.
 * s will only consist of "0" or "1" characters.
 * @Author: lc
 * @Date: Created in 2017/12/19
 */
public class _696
{
    /**
     * 从 1 开始遍历字符串 s，分别记录 preLength 和 curLength，只要 preLength >= curLength，则满足条件的个数就加一
     */
    public int countBinarySubstrings(String s)
    {
        int result = 0; // 记录满足条件的个数
        int preLength = 0; // 记录前一个值相同的且连续的个数
        int curLength = 1; // 记录当前值相同的且连续的个数
        for (int i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == s.charAt(i - 1))
                curLength++;
            else
            {
                preLength = curLength;
                curLength = 1;
            }
            if (preLength >= curLength)
                result++;
        }
        return result;
    }

    public static class MainClass
    {
        public String stringToString(String input)
        {
            assert input.length() >= 2;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < input.length() - 1; i++)
            {
                char currentChar = input.charAt(i);
                if (currentChar == '\\')
                {
                    char nextChar = input.charAt(i + 1);
                    switch (nextChar)
                    {
                        case '\"':
                            sb.append('\"');
                            break;
                        case '/':
                            sb.append('/');
                            break;
                        case '\\':
                            sb.append('\\');
                            break;
                        case 'b':
                            sb.append('\b');
                            break;
                        case 'f':
                            sb.append('\f');
                            break;
                        case 'r':
                            sb.append('\r');
                            break;
                        case 'n':
                            sb.append('\n');
                            break;
                        case 't':
                            sb.append('\t');
                            break;
                        default:
                            break;
                    }
                    i++;
                } else
                {
                    sb.append(currentChar);
                }
            }
            return sb.toString();
        }

    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null)
        {
            MainClass m = new MainClass();
            String s = m.stringToString(line);

            int ret = new _696().countBinarySubstrings(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
