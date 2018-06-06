package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 425. 电话号码的字母组合
 * Given a digit string excluded 01, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * 样例：
 * 给定 "23"
 * 返回 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * @Author: lc
 * @Date: Created in 2018/3/14
 */
public class _425
{
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits)
    {
        // write your code here
        String[][] arr = {
                {"a", "b", "c"}
                , {"d", "e", "f"}
                , {"g", "h", "i"}
                , {"j", "k", "l"}
                , {"m", "n", "o"}
                , {"p", "q", "r", "s"}
                , {"t", "u", "v"}
                , {"w", "x", "y", "z"}
        };

        List<String> res = new ArrayList<>();
        if (digits.length() <= 0) return res;
        char[] temp = new char[digits.length()];
        recur(res, arr, digits, temp, 0);
        return res;
    }

    public void recur(List<String> res, String[][] arr, String digits, char[] temp, int index)
    {
        if (index == digits.length())
        {
            res.add(String.valueOf(temp));
            return;
        }

        for (int i = 0; i < arr[digits.charAt(index) - '0' - 2].length; i++)
        {
            temp[index] = arr[digits.charAt(index) - '0' - 2][i].charAt(0);
            recur(res, arr, digits, temp, index + 1);
        }
    }

    public static void main(String[] args)
    {
        _425 obj = new _425();
        obj.letterCombinations("2");
        System.out.println();
    }
}
