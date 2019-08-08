import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문1 { // 제출일 2019-08-08 18:44
	/*
	 * 0이상 1000000 백만 미만 수를 나열하여 만든 암호문 기능 1 삽입 ; 
	 * 명령어I x y s 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. 
	 * s는 덧붙일 숫자 I는 Insertion의 약자인듯
	 * 
	 * [입력]	
	 * 첫 번째 줄 : 원본 암호문의 길이 N ( 10 ≤ N ≤ 20 의 정수)
	 * 두 번째 줄 : 원본 암호문
	 * 세 번째 줄 : 명령어의 개수 ( 5 ≤ N ≤ 10 의 정수)
	 * 네 번째 줄 : 명령어
	 * 
	 * [출력] 앞 10개만 
	 */
	static StringBuilder sb;
	public static void main(String[] args) {
		sc.init();
		sb = new StringBuilder();
		for(int t=1; t<=10; t++) {
			sb.append("#").append(t);
			
			int L1 = sc.nextInt();
			//int[] L2 = new int[L1];
			List<Integer> Q2 = new LinkedList<Integer>();
			for (int i = 0; i < L1; i++) {
				//L2[i] = sc.nextInt();
				Q2.add(sc.nextInt());
			}
			// 명령어 개수
			int L3 = sc.nextInt();
			// 입력 I 위치 개수N 숫자1 숫자2 ... 숫자N
			int[] pos = new int[L3];
			int[][] num = new int[L3][];
			for (int i = 0; i < L3; i++) {
				// I 스킵
				sc.next();
				// 포지션 
				pos[i] = sc.nextInt();
				// 개수 N
				int N = sc.nextInt();
				num[i] = new int[N];
				for (int j = 0; j < N; j++) {
					num[i][j] = sc.nextInt();
					Q2.add(pos[i]+j, num[i][j]);
				}
				
			}
			
			for(int k=0; k<10; k++) {
				sb.append(" ").append(Q2.get(k));
			}
			sb.append("\n");
			
		}		
		System.out.println(sb);	
	}
	
	static class sc{
		private static BufferedReader br;
		private static StringTokenizer st;
		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(" ");
		}
		static String readLine() {
			try {
				return br.readLine();
			} catch(IOException e) {}
			return null;
		}
		
		static String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {}				
			} return st.nextToken();
		}
		
		static int nextInt() {
			return Integer.parseInt(next());
		}
		
	}
	
	
	
}
