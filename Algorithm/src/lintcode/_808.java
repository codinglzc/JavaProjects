package lintcode;

import java.util.*;

/**
 * @Description: 808. 影际网络
 * 给一些movie（编号从0开始）的rating和他们的联系关系，联系关系可以传递(a和b有联系，b和c有联系，a和c也认为有联系)。给出每个movie的直
 * 接联系list。再给定一个movie编号为S，找到和S相联系的movie中的rating最高的K个movie（当与S相联系的movie少于K个时，输出所有。输出答
 * 案时可以按照任意次序，注意联系movie并不包括S。）
 * <p>
 * 注意事项：
 * · movie个数 n <= 20000。
 * · 保证编号为0 ~ n-1。（n为movie个数)。
 * · 保证联系的边，2个编号都属于0 ~ n-1。
 * · 保证总边数 m <= 100000。
 * · 保证每个movie的rating都为int范围内的整数，且互不相同。
 * 样例：
 * 1.给出 ratingArray = [10,20,30,40], contactRelationship = [[1,3],[0,2],[1],[0]], S = 0, K = 2，返回[2,3]。
 * <p>
 * 解释：
 * 在contactRelationship中，0号与[1,3]有联系，1号与[0,2]有联系，2号与[1]有联系，3号与[0]有联系。
 * 所以最终和0号movie相联系的有[1,2,3]，按他们的rating从高到低排列为[3,2,1]，所以输出[2,3]。
 * <p>
 * 2. 给出 ratingArray = [10,20,30,40,50,60,70,80,90], contactRelationship = [[1,4,5],[0,2,3],[1,7],[1,6,7],[0],[0],[3],[2,3],[]],
 * S = 5, K = 3, 返回 [6,7,4]。
 * <p>
 * 解释：
 * 在contactRelationship中，0号与[1,4,5]有联系，1号与[0,2,3]有联系，2号与[1,7]有联系，3号与[1,6,7]有联系，4号与[0]有联系，5号与
 * [0]有联系，6号与[3]有联系，7号与[2,3]有联系，8号无任何联系。
 * 最终和5号movie相联系的有[0,1,2,3,4,6,7]，按他们的rating从高到低排列为[7,6,4,3,2,1,0]，注意8号movie不和5号movie相连，
 * 所以它rating最高但是不计入答案。
 * @Author: lc
 * @Date: Created in 2018-04-04
 */
public class _808
{
    /**
     * @param rating: the rating of the movies
     * @param G:      the realtionship of movies
     * @param S:      the begin movie
     * @param K:      top K rating
     * @return: the top k largest rating moive which contact with S
     */
    public int[] topKMovie(int[] rating, int[][] G, int S, int K)
    {
        // Write your code here
        Map<Integer, Integer> relas = new HashMap<>();
        dfs(relas, rating, G, S);
        relas.remove(S);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(relas.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>()
        {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int[] res = new int[K];
        int i = 0;
        for (Map.Entry<Integer, Integer> en : list)
        {
            if (i == K) break;
            res[i++] = en.getKey();
        }
        return res;
    }

    public void dfs(Map<Integer, Integer> relas, int[] rating, int[][] G, int S)
    {
        if (relas.containsKey(S)) return;

        relas.put(S, rating[S]);
        for (int i : G[S])
        {
            dfs(relas, rating, G, i);
        }
    }

    public static void main(String[] args)
    {
        _808 obj = new _808();
        obj.topKMovie(new int[]{10, 20, 30, 40}, new int[][]{{1, 3}, {0, 2}, {1}, {0}}, 0, 2);
    }
}
