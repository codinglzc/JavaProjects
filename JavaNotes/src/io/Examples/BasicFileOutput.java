package io.Examples;

import java.io.*;

/**
 * 基本的文件输出
 */
public class BasicFileOutput
{
    static String inputFile = "./IO/src/Examples/BasicFileOutput.java";
    static String outputFile = "./IO/src/Examples/BasicFileOutput.output";

    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(inputFile)));
        // 1. 创建一个与指定文件连接的FileWriter
        // 2. 我们通常会用BufferedWriter将其包装起来用以缓冲输出（缓冲往往能显著地增加IO操作的性能）
        // 3. 为了提供格式化机制，用PrintWriter来装饰
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close(); // 如果不调close(),就会发现缓冲区内容不会被flush和clear.
        System.out.println(BufferedInputFile.read(outputFile));
    }
}
