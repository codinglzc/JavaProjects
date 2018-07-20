package designPatterns.AdapterPattern;

import java.io.*;
import java.util.Properties;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-11
 */
public class ReadPropertiesAdapter implements ReadPropertiesTarget
{
    private Properties properties = new Properties(); // Adaptee: 被适配的API

    @Override
    public void loadPropertiesFromFile(String str) throws IOException
    {
        properties.load(new BufferedReader(new FileReader(new File(str))));
    }

    @Override
    public void storePropertiesToFile(String str, String comments) throws IOException
    {
        properties.store(new BufferedWriter(new FileWriter(str)), comments);
    }

    @Override
    public String getProperty(String key)
    {
        return properties.getProperty(key);
    }

    @Override
    public void setProperty(String key, String val)
    {
        properties.setProperty(key, val);
    }
}
