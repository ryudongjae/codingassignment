import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class XY_distance {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().replaceAll("[()]", "").split(",");
        List<Point> points = new ArrayList<>();
        HashMap<Point, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length; i++){
            points.add(new Point(Integer.parseInt(s[i]),Integer.parseInt(s[i+1])));
            i++;
        }
        int val1 = 0;
        for (int i = 0; i < points.size(); i++){
            for(int j = 0; j < points.size(); j++){
                val1 += distance(points.get(i),points.get(j));
                map.put(points.get(i),val1);

            }
            val1 = 0;
        }
        List<Map.Entry<Point,Integer>> maplist = new LinkedList<>(map.entrySet());
        maplist.sort(Map.Entry.comparingByValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Point, Integer> integerEntry : maplist) {
            sb.append("(");
            sb.append(integerEntry.getKey().x);
            sb.append(",");
            sb.append(integerEntry.getKey().y);
            sb.append(")");
            sb.append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        System.out.print(sb.toString());
    }
    static int distance(Point p1,Point p2) {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    }
    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
