package designPatterns.TemplateMethodPattern;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-11
 */
public class Main
{
    public static void main(String[] args)
    {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello, World!");
        AbstractDisplay d3 = new StringDisplay("你好，世界。");

        d1.display();
        d2.display();
        d3.display();
    }
}
