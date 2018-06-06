package io.Examples;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存输入：
 * 注意read()是以int形式返回下一个字节，因此必须类型转换为char才能正确打印。
 */
public class MemoryInput
{
    public static void main(String[] args) throws IOException
    {
        StringReader sr = new StringReader(BufferedInputFile.read("./IO/src/Examples/MemoryInput.java"));
        int c;
        while ((c = sr.read()) != -1)
            System.out.print((char) c);
    }
}
