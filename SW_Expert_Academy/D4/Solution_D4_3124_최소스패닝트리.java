import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
 
 
class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        if(this.cost < o.cost)
            return -1;
        else if(this.cost == o.cost)
            return 0;
        else
            return 1;
    }
}
public class Solution_D4_3124_최소스패닝트리 { // 제출일 2019-08-29 09:17
    public static int[] parent;
    public static ArrayList<Edge> edgeList;
     
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y)
            parent[y] = x;
    }
     
    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return true;
        else return false;
    }
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
    public static void main(String[] args) throws Exception {
        sc.init();
        // 테스트케이스
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            int v = sc.nextInt();
            int e = sc.nextInt();
             
            edgeList = new ArrayList<Edge>();
            for(int i = 0; i < e; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int cost = sc.nextInt();
                edgeList.add(new Edge(v1,v2,cost));
            }
             
            parent = new int[v+1];
            for(int i = 1; i <= v; i++) {
                parent[i] = i;
            }
             
            Collections.sort(edgeList);
             
            long sum = 0;
            for(int i = 0; i < edgeList.size(); i++) {
                Edge edge = edgeList.get(i);
                if(!isSameParent(edge.v1, edge.v2)) {
                    sum += edge.cost;
                    union(edge.v1, edge.v2);
                }
            }
             
            bw.write(String.format("#%d %d\n", tc, sum));
            bw.flush();
        }
         
         
    }   
    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;
 
        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }
 
        static String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
            }
            return null;
        }
 
        static String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
 
        }
 
        static int nextInt() {
            return Integer.parseInt(next());
        }
 
        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}