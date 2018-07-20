package jianzhioffer.topic05;

/**
 * @description: 测试用例
 * @author: Liu Cong
 * @create: Created at 2018-06-13
 */
public class Main
{
    public static void main(String[] args)
    {
        char[] chars = new char[]{' ', 'H', 'e', 'l', 'l', 'o', ' ', ' ', 'W', 'o', 'r', 'l', 'd', ' ', '\0', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x',};
        System.out.println(chars);
        ReplaceSpaces.solution(chars);
        System.out.println(chars);

        chars = new char[]{'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd', '\0'};
        System.out.println(chars);
        ReplaceSpaces.solution(chars);
        System.out.println(chars);

        ReplaceSpaces.solution(null);

        chars = new char[]{'\0'};
        ReplaceSpaces.solution(chars);
        System.out.println(chars);
    }
}
