package lintcode;

import java.util.Stack;

/**
 * @Description: 575. 表达式展开
 * 给出一个表达式 s，此表达式包括数字，字母以及方括号。在方括号前的数字表示方括号内容的重复次数(括号内的内容可以是字符串或另一个表达式)，
 * 请将这个表达式展开成一个字符串。
 * <p>
 * 样例：
 * S = abc3[a] 返回 abcaaa
 * S = 3[abc] 返回 abcabcabc
 * S = 4[ac]dy 返回 acacacacdy
 * S = 3[2[ad]3[pf]]xyz 返回 adadpfpfpfadadpfpfpfadadpfpfpfxyz
 * @Author: lc
 * @Date: Created in 2018/3/8
 */
public class _575
{
    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s)
    {
        // write your code here
        Stack<Object> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int number = 0;
        for (char c : chars)
        {
            if (c == '[')
            {
                stack.push((Integer) number);
                number = 0;
            } else if (c == ']')
            {
                String str = popStack(stack);
                stack.push(str);
            } else if (c >= '0' && c <= '9')
            {
                number = number * 10 + c - '0';
            } else
            {
                stack.push(String.valueOf(c));
            }
        }
        return popStack(stack);
    }

    public String popStack(Stack<Object> stack)
    {
        String oneStr = "";
        while (!stack.isEmpty() && stack.peek() instanceof String)
        {
            oneStr = (String) stack.pop() + oneStr;
        }
        String res = oneStr;
        if(!stack.isEmpty() && stack.peek() instanceof Integer)
        {
            int count = (int) stack.pop();
            if (count == 0) return "";
            for (int i = 0; i < count - 1; i++)
            {
                res += oneStr;
            }
        }
        return res;
    }
}
