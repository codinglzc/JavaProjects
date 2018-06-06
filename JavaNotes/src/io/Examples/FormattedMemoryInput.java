package io.Examples;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * 格式化的内存输入
 */
public class FormattedMemoryInput
{
    public static void main(String[] args) throws IOException
    {
        DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(
                        BufferedInputFile.read("./IO/src/Examples/FormattedMemoryInput.java").getBytes()));
        while (true)
            System.out.print((char) in.readByte());
    }
}
