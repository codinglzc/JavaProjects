package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 935. 笛卡尔积
 * 我们采用二维数组setList[][]表示集合数组，其中setList[i]中的每个元素都为整数，且不相同。求集合setList[0],setList[1],...,
 * setList[setList.length - 1]的笛卡尔积。
 * 一般地，集合A和集合B的笛卡尔积A×B = {(x,y)|x∈A∧y∈B}。
 * <p>
 * 注意事项：
 * · 1 <= setList.length <= 5
 * · 1 <= setList[i].length <= 5
 * <p>
 * 样例：
 * 给出 setList = [[1,2,3],[4],[5,6]]，返回 [[1,4,5],[1,4,6],[2,4,5],[2,4,6],[3,4,5],[3,4,6]]。
 * 解释：
 * [1,2,3]和[4]和[5,6]的笛卡尔积为[[1,4,5],[1,4,6],[2,4,5],[2,4,6],[3,4,5],[3,4,6]]
 * <p>
 * 给出 setList = [[1,2,3],[4]]，返回 [[1,4],[2,4],[3,4]]。
 * 解释：
 * [1,2,3]和[4]的笛卡尔积为[[1,4],[2,4],[3,4]]
 * @Author: lc
 * @Date: Created in 2018-04-08
 */
public class _935
{
    /**
     * @param setList: The input set list
     * @return: the cartesian product of the set list
     */
    public List<List<Integer>> getSet(int[][] setList)
    {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(result, setList, temp, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, int[][] setList, List<Integer> temp, int index)
    {
        if (index == setList.length)
        {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < setList[index].length; i++)
        {
            int val = setList[index][i];
            temp.add(val);
            dfs(result, setList, temp, index + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
