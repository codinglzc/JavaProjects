package designPatterns.TemplateMethodPattern;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-11
 */
public class StringDisplay extends AbstractDisplay
{
    private String str;
    private int width;

    public StringDisplay(String str)
    {
        this.str = str;
        this.width = str.getBytes().length;
    }

    @Override
    public void open()
    {
        printLine();
    }

    @Override
    public void print()
    {
        System.out.println("|" + str + "|");
    }

    @Override
    public void close()
    {
        printLine();
    }

    private void printLine()
    {
        System.out.print("+");
        for (int i = 0; i < width; i++)
        {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
