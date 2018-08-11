package string;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-06
 */
public class StringUtils
{
    /**
     * 十六进制字符串转byte数组
     */
    public static byte[] hexStrToByteArray(String str)
    {
        if (str == null)
        {
            return null;
        }
        if (str.length() == 0)
        {
            return new byte[0];
        }
        byte[] byteArray = new byte[str.length() / 2];
        for (int i = 0; i < byteArray.length; i++)
        {
            String subStr = str.substring(2 * i, 2 * i + 2);
            byteArray[i] = ((byte) Integer.parseInt(subStr, 16));
        }
        return byteArray;
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(hexStrToByteArray("11")));
        System.out.println(Arrays.toString(hexStrToByteArray("22")));
        System.out.println(Arrays.toString(hexStrToByteArray("6F")));
        System.out.println(Arrays.toString(hexStrToByteArray("FF")));
    }
}
