package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 653. 添加运算符
 * 给定一个仅包含数字 0 - 9 的字符串和一个目标值，返回在数字之间添加了`二元`运算符(不是一元)`+`, `-` 或 `*` 之后所有能得到目标值的情况。
 * <p>
 * 样例：
 * "123", 6 -> ["1+2+3", "1*2*3"]
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00",  0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 * @Author: lc
 * @Date: Created in 2018/3/8
 */
public class _653
{
    /*
     * @param num: a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */

    public List<String> res = new ArrayList<>();

    public List<String> addOperators(String num, int target)
    {
        // write your code here
        DFS(num, target, "", 0, 0);
        return res;
    }

    public void DFS(String num, int target, String temp, long curRes, long preNum)
    {
        if (curRes == target && num.length() == 0)
        {
            String exp = new String(temp);
            res.add(exp);
            return;
        }

        for (int i = 1; i <= num.length(); i++)
        {
            String curStr = num.substring(0, i);

            if (curStr.length() > 1 && curStr.startsWith("0")) return;

            String newStr = num.substring(i);
            long curNum = Long.parseLong(curStr);

            if (temp == "")
            {
                DFS(newStr, target, curStr, curNum, curNum);
            } else
            {
                DFS(newStr, target, temp + "+" + curStr, curRes + curNum, curNum);
                DFS(newStr, target, temp + "-" + curStr, curRes - curNum, -curNum);
                DFS(newStr, target, temp + "*" + curStr, curRes - preNum + preNum * curNum, preNum * curNum);
            }
        }
    }
}
