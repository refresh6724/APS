import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//_BOJ_1647_도시분할계획
class Node implements Comparable<Node> {
		int s;
		int e;
		int w;
    
        public Node() {
			super();
		}
    
		public Node(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}		
}

public class Main_BOJ_1647_도시분할계획 { // 제출일 2019-10-16 19:19
    
	static int answer;
	static int N;
	static int M;
	
	static PriorityQueue<Node> pq;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		pq = new PriorityQueue<Node>();
        int s = 0;
		int e = 0;
		int w = 0;
		for (int i = 0; i < M; i++) {
            s = sc.nextInt();
            e = sc.nextInt();
            w = sc.nextInt();
			pq.add(new Node(s,e,w));
		}
		parents = new int[N+1];
		for(int i =0; i<=N; i++){
            parents[i] = -1;
        }		
        
		int cnt = 0;		
		while(cnt != N-2) {
			s = pq.peek().s;
			e = pq.peek().e;
			w = pq.poll().w;			
			if(union(s,e)) {
				answer += w;
				cnt++;
			}
		}			
		System.out.println(answer);
	}

	private static boolean union(int s, int e) {
		int aRoot = find(s);
		int bRoot = find(e);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int s) {
		if(parents[s] < 0) return s;
		else return parents[s] = find(parents[s]);
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(" ");
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
