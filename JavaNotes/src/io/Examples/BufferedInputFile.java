package io.Examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 缓冲输入文件：读一个文件内容
 */
public class BufferedInputFile
{
    public static String read(String filename) throws IOException
    {
        // Reading input by lines:
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null)
        {
            sb.append(s + "\n");
        }
        br.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println(read("./IO/src/Examples/BufferedInputFile.java"));
    }
}
