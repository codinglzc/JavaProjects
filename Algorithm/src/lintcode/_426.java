package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 426. 恢复IP地址
 * 给一个由数字组成的字符串。求出其可能恢复为的所有IP地址。
 * <p>
 * 样例：
 * 给出字符串 "25525511135"，所有可能的IP地址为：
 * [
 * "255.255.11.135",
 * "255.255.111.35"
 * ]
 * @Author: lc
 * @Date: Created in 2018/3/14
 */
public class _426
{
    /**
     * @param s: the IP string
     * @return: All possible valid IP addresses
     */
    public List<String> restoreIpAddresses(String s)
    {
        // write your code here
        if (s == null || s.length() < 4) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        String temp = "";
        recur(res, s, 0, 0, temp, s.length());
        return res;
    }

    public void recur(List<String> res, String s, int index, int ip_index, String temp, int len)
    {
        // index为字符串s遍历指针
        // ip_index为ip地址位数
        if (index == len && ip_index == 4)
        {
            res.add(temp);
            return;
        }

        if ((index == len && ip_index < 4) || (index < len && ip_index == 4)) return;

        int value = 0;
        boolean flag = true; // //第一个字符是否为0标志
        while (index < len && flag)
        {
            int curNum = s.charAt(index) - '0';
            if (value == 0 && curNum == 0)
            {
                flag = false;
            }

            value = value * 10 + curNum;
            index++;

            if (value < 256)
            {
                if (ip_index == 3)
                {
                    recur(res, s, index, ip_index + 1, temp + Integer.toString(value), len);
                } else
                {
                    recur(res, s, index, ip_index + 1, temp + Integer.toString(value) + ".", len);
                }
            }
        }
    }
}
