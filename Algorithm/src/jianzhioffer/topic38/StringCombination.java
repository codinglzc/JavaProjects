package jianzhioffer.topic38;

import java.util.*;

/**
 * <p>
 * 扩展：求字符的所有组合。
 * 例如，输入三个字符a、b、c，则它们的组合有a、b、c、ab、ac、bc、abc。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-12
 */
public class StringCombination
{
    /**
     * 解法一
     * 优点：可扩展性高，只需要修改少许代码就可以解决全排列和全组合问题。
     * 缺点：空间利用率不高
     */
    public static Set<String> combination(char[] chars)
    {
        if (chars == null) return null;

        Set<String> strSet = new HashSet<>();
        for (int i = 1; i <= chars.length; i++)
        {
            combination(chars, strSet, i, 0);
        }
        return strSet;
    }

    private static void combination(char[] chars, Set<String> strSet, int num, int index)
    {
        if (index >= num)
        {
            char[] cs = new char[num];
            System.arraycopy(chars, 0, cs, 0, num);
            Arrays.sort(cs);
            strSet.add(String.valueOf(cs));
            return;
        }

        for (int i = index; i < chars.length; i++)
        {
            swap(chars, index, i);
            combination(chars, strSet, num, index + 1);
            swap(chars, index, i);
        }
    }

    private static void swap(char[] chars, int m, int n)
    {
        char tmp = chars[m];
        chars[m] = chars[n];
        chars[n] = tmp;
    }

    /**
     * 解法二
     * 思路：从m个元素中任取n个的元素为一个组合。全组合是从m个元素中任取x(0<x<=m)个元素所有的可能性。比如abc的全组合有，a,b,c,ab,ac,bc,abc七种。
     * 对于n个元素的集合，最终组合的结果数是2^n-1。可以这样思考，每个元素都可以用0表示不取，用1表示取该元素，每个元素都有2种可能，总的可能数有2^n，而一个都不取没有意义，所以要减1.
     * 一位代表一个元素（字符），使用移位运算。
     */
    public static List<String> combination2(char[] chars)
    {
        if (chars == null) return null;

        List<String> stringList = new ArrayList<>();
        int len = chars.length;
        int nbit = 1 << len;
        for (int i = 1; i < nbit; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++)
            {
                if (((1<<j) & i) != 0)
                    sb.append(chars[j]);
            }
            stringList.add(sb.toString());
        }
        return stringList;
    }

    public static void main(String[] args)
    {
        combination(new char[]{'a', 'b', 'c'}).forEach(c -> System.out.print(c + " "));
        System.out.println();

        combination2(new char[]{'a', 'b', 'c'}).forEach(c -> System.out.print(c + " "));
        System.out.println();
    }
}
