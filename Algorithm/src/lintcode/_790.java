package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 790. 符号串生成器
 * 符号串生成器由两部分组成，开始符号和生成规则集合，
 * 比如对于以下符号串生成器，
 * 开始符合：'S'，生成规则集合：["S -> abc", "S -> aA", "A -> b", "A -> c"]
 * 那么，
 * 符号串 abc 可以被生成，因为 S -> abc。
 * 符号串 ab 可以被生成，因为 S -> aA -> ab。
 * 符号串 ac 可以被生成，因为 S -> aA -> ac。
 * 现在，给你一个符号串生成器，一个符号串，若该符号串可以被生成返回 True，否则返回 False。
 * <p>
 * 注意事项：
 * 我们保证生成规则的左侧为一个大写字母，startSymbol 为一个大写字母，symbolString 为小写字母串。
 * 我们保证 |generator| <= 20, |symbolString| <= 20。
 * 我们保证生成规则集合无左递归，例如不存在这样的["S → Sb", "S → A", "A → Sb"]生成规则集合。
 * <p>
 * 样例：
 * 给出 generator = ["S -> abc", "S -> aA", "A -> b", "A -> c"], startSymbol = S, symbolString = "ac", 返回"True"。
 * <p>
 * 解释：
 * S -> aA -> ac
 * 给出 generator = ["S -> abcd", "S -> A", "A -> abc"], startSymbol = S, symbolString = "abc", 返回 "True"。
 * <p>
 * 解释：
 * S -> A -> abc
 * 给出 generator = ["S -> abc", "S -> aA", "A -> b", "A -> c"], startSymbol = S, symbolString = "a", 返回 "False"。
 * <p>
 * 解释：
 * 不存在 S 经过若干步得到 a。
 * 给出 generator = ["S -> abcd", "S -> A", "A -> abc"], startSymbol = S, symbolString = "ab"，返回 "True"。
 * <p>
 * 解释：
 * 不存在 S 经过若干步得到 ab。
 * @Author: 刘梓聪
 * @Date: Created in 2018/4/3
 */
public class _790
{
    /**
     * @param generator:    Generating set of rules.
     * @param startSymbol:  Start symbol.
     * @param symbolString: Symbol string.
     * @return: Return true if the symbol string can be generated, otherwise return false.
     */
    public boolean canBeGenerated(String[] generator, char startSymbol, String symbolString)
    {
        // Write  your code here.
        Map<String, List<String>> genMap = new HashMap<>();
        for (String s : generator)
        {
            String key = s.substring(0, 1);
            List<String> temp;
            if (genMap.containsKey(key)) temp = genMap.get(key);
            else temp = new ArrayList<>();
            temp.add(s.substring(5));
            genMap.put(key, temp);
        }
        return dfs(genMap, String.valueOf(startSymbol), symbolString);
    }

    public boolean dfs(Map<String, List<String>> genMap, String curStr, String symbolString)
    {
        if (curStr.equals(symbolString)) return true;

        boolean res = false;
        for (int i = 0; i < curStr.length(); i++)
        {
            if (Character.isLowerCase(curStr.charAt(i)))
            {
                if (i >= symbolString.length() || curStr.charAt(i) != symbolString.charAt(i)) return false;
                continue;
            }
            if (!genMap.containsKey(curStr.substring(i, i + 1))) return false;
            for (String str : genMap.get(curStr.substring(i, i + 1)))
            {
                if (res) break;
                res = res || dfs(genMap, curStr.substring(0, i) + str + curStr.substring(i + 1), symbolString);
            }
            if (res) break;
        }
        return res;
    }

    public static void main(String[] args)
    {
        _790 obj = new _790();
        obj.canBeGenerated(new String[]{"S -> abc", "S -> aA", "A -> b", "A -> c"}, 'S', "ac");
    }

}
