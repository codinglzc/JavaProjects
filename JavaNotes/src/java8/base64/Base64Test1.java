package java8.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

/**
 * @description: Base64 的使用
 * @author: Liu Cong
 * @create: Created at 2018-06-09
 */
public class Base64Test1
{
    public static void main(String[] args)
    {
        try
        {
            // 使用基本编码
            String base64encodedString = Base64.getEncoder().encodeToString("youj?java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串（基本）：" + base64encodedString);

            // 解码
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
            System.out.println("原始字符串：" + new String(base64decodedBytes, "utf-8"));

            // 使用 URL 编码
            base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串（URL）：" + base64encodedString);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 10; i++)
            {
                sb.append(UUID.randomUUID().toString());
            }

            byte[] mimeBytes = sb.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 编码字符串（MIME）：" + mimeEncodedString);
        } catch (UnsupportedEncodingException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
