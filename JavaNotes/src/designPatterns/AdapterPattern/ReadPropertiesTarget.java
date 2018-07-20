package designPatterns.AdapterPattern;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-11
 */
public interface ReadPropertiesTarget
{
    void loadPropertiesFromFile(String str) throws IOException;

    void storePropertiesToFile(String str, String comments) throws IOException;

    String getProperty(String key);

    void setProperty(String key, String val);
}
