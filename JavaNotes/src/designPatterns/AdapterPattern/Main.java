package designPatterns.AdapterPattern;

import java.io.IOException;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-11
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        ReadPropertiesAdapter adapter = new ReadPropertiesAdapter();
        adapter.loadPropertiesFromFile("test.properties");
        System.out.println(adapter.getProperty("name"));
        adapter.setProperty("name", "Moon");
        adapter.setProperty("age", "23");
        adapter.storePropertiesToFile("test1.properties", "");
    }
}
