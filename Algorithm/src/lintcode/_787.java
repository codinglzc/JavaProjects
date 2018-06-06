package lintcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description: 787. 迷宫
 * 在迷宫中有一个球，里面有空的空间和墙壁。球可以通过滚上，下，左或右移动，
 * 但它不会停止滚动直到撞到墙上。当球停止时，它可以选择下一个方向。
 * <p>
 * 给定球的起始位置，目的地和迷宫，确定球是否可以停在终点。
 * <p>
 * 迷宫由二维数组表示。1表示墙和0表示空的空间。你可以假设迷宫的边界都是墙。开始和目标坐标用行和列索引表示。
 * <p>
 * 注意事项：
 * 1.在迷宫中只有一个球和一个目的地。
 * 2.球和目的地都存在于一个空的空间中，它们最初不会处于相同的位置。
 * 3.给定的迷宫不包含边框(比如图片中的红色矩形)，但是你可以假设迷宫的边界都是墙。
 * 5.迷宫中至少有2个空的空间，迷宫的宽度和高度都不会超过100。
 * <p>
 * 样例：
 * 给定:
 * 由二维数组表示的迷宫。
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * 开始坐标(rowStart, colStart) = (0,4)
 * 目的坐标(rowDest, colDest)= (4,4)
 * 返回:true
 * @Author: lc
 * @Date: Created in 2018-04-17
 */
public class _787
{
    /**
     * @param maze:        the maze
     * @param start:       the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination)
    {
        // write your code here
        int row = maze.length;
        int col = maze[0].length;

        Set<String> isVisit = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int[] rowStep = {-1, 1, 0, 0};
        int[] colStep = {0, 0, -1, 1};

        isVisit.add(start[0] + "," + start[1]);
        q.offer(start[0] + "," + start[1]);

        while (!q.isEmpty())
        {
            String[] cur = q.poll().split(",");
            for (int i = 0; i < 4; i++)
            {
                int newX = Integer.valueOf(cur[0]);
                int newY = Integer.valueOf(cur[1]);
                while (true)
                {
                    newX += rowStep[i];
                    newY += colStep[i];

                    if (newX < 0 || newX >= row || newY < 0 || newY >= col || maze[newX][newY] == 1)
                    {
                        newX -= rowStep[i];
                        newY -= colStep[i];

                        if (newX == destination[0] && newY == destination[1])
                            return true;

                        if (isVisit.add(newX + "," + newY))
                            q.offer(newX + "," + newY);

                        break;
                    }
                }
            }
        }

        return false;
    }
}
