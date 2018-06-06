package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 750. 传送门 (BFS)
 * Chell是Valve Corporation开发的Portal视频游戏系列中的主角。
 * 一天，她掉进了一个迷宫。迷宫可以看作是一个大小为n x m二维字符数组。它有4种房间。'S'代表Chell从哪开始（只有一个起点）。'E'代表迷宫的
 * 出口（当chell抵达时，她将离开迷宫，该题目可能会有多个出口）。'*'代表这个房间Chell可以经过。'#'代表一堵墙，Chell不能经过墙。
 * 她可以每次上下左右移动到达一个房间，花费一分钟时间，但是不能到达墙。
 * 现在，你能告诉我她最少需要多少时间离开这个迷宫吗？
 * 如果她不能离开，返回-1
 * <p>
 * 注意事项：
 * 我们保证迷宫的大小为 n x m,满足1<=n<=200,1<=m<=200 .
 * 这里有且只有一个'S'，保证有一个以上的'E'。
 * <p>
 * 样例
 * 给出
 * [
 * ['S','E','*'],
 * ['*','*','*'],
 * ['*','*','*']
 * ]
 * ,返回 1。
 * 解释：
 * Chell 从(0,0) 走到(0,1)，花费1分钟。
 * <p>
 * 给出
 * [
 * ['S','#','#'],
 * ['#','*,'#'],
 * ['#','*','*'],
 * ['#','*','E']
 * ]
 * ,返回 -1。
 * 解释：
 * Chell 不能离开迷宫。
 * <p>
 * 给出
 * [
 * ['S','*','E'],
 * ['*','*','*'],
 * ['#','*','*'],
 * ['#','#','E']
 * ]
 * ，返回 2。
 * 解释：
 * 第一步：Chell 从(0,0)移动到(0,1)。
 * 第二步：Chell 从(0,1)移动到(0,2)。
 * （Chell也可以走到(3,2)那个出口，但是花费时间为5，所以走到（0,2）的出口更优）
 * <p>
 * 给出
 * [
 * ['E','*','#'],
 * ['#','*','#'],
 * ['#','*','*'],
 * ['#','#','S']
 * ]
 * ，返回 5。
 * 解释：
 * 第一步：Chell 从(0,0)移动到(0,1)。
 * 第二步：Chell 从(0,1)移动到(1,1)。
 * 第三步：Chell 从(1,1)移动到(2,1)。
 * 第四步：Chell 从(2,1)移动到(2,2)。
 * 第五步：Chell 从(2,2)移动到(3,2)。
 * @Author: lc
 * @Date: Created in 2018-04-16
 */
public class _750
{
    class Node
    {
        int x, y, step;

        Node(int x, int y, int step)
        {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public int Portal(char[][] Maze)
    {
        int row = Maze.length;
        int col = Maze[0].length;
        Queue<Node> q = new LinkedList<>();
        int[][] steps = new int[row][col];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                steps[i][j] = Integer.MAX_VALUE;
                if (Maze[i][j] == 'S')
                {
                    q.offer(new Node(i, j, 0));
                    steps[i][j] = 0;
                }
            }
        }

        int[] mx = {-1, 1, 0, 0};
        int[] my = {0, 0, -1, 1};
        while (!q.isEmpty())
        {
            Node tmp = q.poll();
            for (int i = 0; i < 4; i++)
            {
                int newX = tmp.x + mx[i];
                int newY = tmp.y + my[i];
                int newStep = tmp.step + 1;

                if (newX < 0 || newX >= row || newY < 0 || newY >= col || Maze[newX][newY] == '#')
                    continue;

                if (steps[newX][newY] <= newStep)
                    continue;

                if (Maze[newX][newY] == 'E')
                    return newStep;

                steps[newX][newY] = newStep;
                Node newNode = new Node(newX, newY, newStep);
                q.offer(newNode);
            }
        }

        return -1;
    }
}
