package io.Examples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读写随机访问文件
 */
public class UsingRandomAccessFile
{
    static String file = "./IO/src/Examples/rtest.dat";

    static void display() throws IOException
    {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++)
            System.out.println("Value " + i + ": " + rf.readDouble());
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException
    {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++)
        {
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        rf.seek(5 * 8); // 因为double总是8字节长，所以为了用seek()查找第5个双精度值，需要用5*8来产生查找位置。
        rf.writeDouble(47.001);
        rf.close();
        display();
    }
}
