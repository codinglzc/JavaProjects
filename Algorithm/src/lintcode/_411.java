package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 411. 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个二进制的差异。
 * <p>
 * 给定一个非负整数 n ，表示该代码中所有二进制的总数，请找出其格雷编码顺序。一个格雷编码顺序必须以 0 开始，并覆盖所有的 2n 个整数。
 * <p>
 * 注意事项：
 * 对于给定的 n，其格雷编码顺序并不唯一。
 * 根据以上定义， [0,2,3,1] 也是一个有效的格雷编码顺序。
 * <p>
 * 样例：
 * 给定 n = 2， 返回 [0,1,3,2]。其格雷编码顺序为：
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * @Author: lc
 * @Date: Created in 2018/3/13
 */
public class _411
{
    /**
     * @param n: a number
     * @return: Gray code
     */
    public List<Integer> grayCode(int n)
    {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (n == 0)
        {
            res.add(0);
            return res;
        }
        List<Integer> temp = grayCode(n - 1);
        res.addAll(temp);
        for (int i = temp.size() - 1; i >= 0; i--)
        {
            res.add((int) Math.pow(2, n - 1) + temp.get(i));
        }
        return res;
    }
}
