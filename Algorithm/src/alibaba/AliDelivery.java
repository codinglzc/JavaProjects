package alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * 如图，某物流派送员p，需要给a、b、c、d4个快递点派送包裹，请问派送员需要选择什么的路线，才能完成最短路程的派送。
 * 假设如图派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离
 * 就是4。随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-30
 */
public class AliDelivery
{
    private static final Point START = new Point(0, 0);
    private static int minPath = Integer.MAX_VALUE;

    /**
     * 节点类
     */
    public static class Point
    {
        int x; // x坐标
        int y; // y坐标
        boolean visited; // 是否被访问过（回溯时需要还原）

        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
            this.visited = false;
        }

        /**
         * 计算两个节点之间的路径
         *
         * @param p1 节点1
         * @param p2 节点2
         * @return 路径长度
         */
        static int getDistanceBetweenDoublePoints(Point p1, Point p2)
        {
            return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        }
    }

    /**
     * DFS 回朔法
     *
     * @param start  起始节点
     * @param points 节点集
     * @param path   当前路径长度
     * @param index  节点集索引
     * @return 最小路径长度
     */
    private static int calculateMinPath1(Point start, List<Point> points, int path, int index)
    {
        if (index >= points.size())
        {
            minPath = Math.min(minPath, path + Point.getDistanceBetweenDoublePoints(start, START));
            return minPath;
        }
        for (int i = 0; i < points.size(); i++)
        {
            if (!points.get(i).visited)
            {
                int tmpDistance = Point.getDistanceBetweenDoublePoints(start, points.get(i));
                path += tmpDistance;
                if (path < minPath)
                {
                    points.get(i).visited = true;
                    calculateMinPath1(points.get(i), points, path, index + 1);
                }
                path -= tmpDistance;
                points.get(i).visited = false;
            }
        }
        return minPath;
    }

    /**
     * 先求包含所有节点的最小矩形的周长（即经过所有点的最小路径）C；
     * 然后再求所有节点中离原点最近的路径 dis；
     * 最后 C + dis * 2 为所求结果。
     *
     * @param points 节点集合
     * @return 最小路径长度
     */
    private static int calculateMinPath2(List<Point> points)
    {
        int path = 0;
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE; // 最小矩形的长度范围
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE; // 最小矩形的高度范围
        int minDisOfPoints = Integer.MAX_VALUE; //  离原点最近的路径
        for (Point point : points)
        {
            if (point.x < minX) minX = point.x;
            if (point.x > maxX) maxX = point.x;
            if (point.y < minY) minY = point.y;
            if (point.y > maxY) maxY = point.y;
            if (Point.getDistanceBetweenDoublePoints(START, point) < minDisOfPoints)
                minDisOfPoints = Point.getDistanceBetweenDoublePoints(START, point);
        }
        // 最小矩形周长 + 离原点最近的路径 * 2
        path += (maxX - minX + maxY - minY) * 2 + minDisOfPoints * 2;
        return path;
    }

    /**
     * 主函数入口
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine().trim());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            String[] point = sc.nextLine().trim().split(",");
            points.add(new Point(Integer.valueOf(point[0]), Integer.valueOf(point[1])));
        }

        long start = System.currentTimeMillis();
        System.out.println("回朔法：" + calculateMinPath1(START, points, 0, 0));
        long end = System.currentTimeMillis();
        System.out.println("耗时(ms)：" + (end - start));

        start = System.currentTimeMillis();
        System.out.println("O(n)的方法：" + calculateMinPath2(points));
        end = System.currentTimeMillis();
        System.out.println("耗时(ms)：" + (end - start));
    }
}
