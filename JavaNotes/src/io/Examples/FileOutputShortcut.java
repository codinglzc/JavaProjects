package io.Examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 文本文件输出的快捷方式
 */
public class FileOutputShortcut
{
    static String inputFile = "./IO/src/Examples/FileOutputShortcut.java";
    static String outputFile = "./IO/src/Examples/FileOutputShortcut.out";

    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(inputFile)));
        // Here's the shorcut:
        PrintWriter out = new PrintWriter(outputFile);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        System.out.println(BufferedInputFile.read(outputFile));
    }
}
