package alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-21
 */
public class Main
{
    public static class Point
    {
        public int x;
        public int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public static int distanceOfDP(Point p1, Point p2)
        {
            return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        }
    }

    static int calculate(String[] locations)
    {
        if (locations == null || locations.length <= 0) return 0;

        List<Point> points = new ArrayList<>(locations.length);
        for (String location : locations)
        {
            points.add(new Point(Integer.valueOf(location.split(",")[0]),
                    Integer.valueOf(location.split(",")[1])));
        }

        List<Point> pointsSorted = new ArrayList<>(locations.length);
        int minDis = Integer.MAX_VALUE;
        Point zeroZero = new Point(0,0);
        Point minPoint = null;
        for (int i = 0; i < points.size(); i++)
        {
            int dis = Point.distanceOfDP(zeroZero, points.get(i));
            if (dis < minDis) minPoint = points.get(i);
        }
        pointsSorted.add(minPoint);
        points.remove(minPoint);

        return 0;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while (num-- > 0)
        {
            locations[index++] = scanner.nextLine();
        }

        System.out.println(calculate(locations));
    }
}
