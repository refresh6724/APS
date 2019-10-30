import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_5672_Professional_올해의조련사 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			char[] arr = new char[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next().charAt(0);
			}

			int f = 0;
			int e = N - 1;
			sb = new StringBuilder();

			// 테케 
			// 1 8
			// d a a e c b a d
			// 오답
			// d a b c d a a e
			// 정답
			// d a a d a b c e
			
			// 테케 2
			// 1 11
			// a b b a c b a c b b a
			// 오답
			// a b b a a b b c a b c
			// 정답
			// a a b b a b b c a b c
			
			int nextf = 0;
			int nexte = 0;
			while (f < e) {
				if (arr[f] < arr[e]) {
					sb.append(arr[f++]);
					print(1);
				} else if (arr[f] > arr[e]) { // 놓친 점 : 문자가 같을 경우 그 다음 문자가 더 빠른 쪽을 선택해야 한다 // 10개 중 1개 정답
					sb.append(arr[e--]);
					print(2);
				} else { // 두 문자가 같을 경우 달라질 때 까지 1:1비교 이후 한꺼번에 붙이고 비교 // 10개 중 4개 정답
					nextf = f + 1;
					nexte = e - 1;
					boolean same = false;
					
					while (true) { 
						// 모든 조건을 while 문 내부에서 처리할 경우 // 10개 중 6개 정답
						// 조건 분리 후 통과
						if(arr[nextf] != arr[nexte]) {
							break;
						} else {
							if(nextf+1 <= nexte-1) {
								nextf++;
								nexte--;								
							} else {
								same = true;
								break;
							}
						}
					}
					if (!same) { // while문에서 첫번째 조건으로 탈출한 경우
						if(arr[nextf]<arr[nexte]) {
							sb.append(arr[f++]);
						} else {
							sb.append(arr[e--]);
						}						
					} else { // 두번째 조건에서 떨어지는 경우
						sb.append(arr[f++]);						
					}

				}
			}
			sb.append(arr[f]);
			bw.write(String.format("#%d %s\n", tc, sb.toString()));
			bw.flush();
		}

	}

	
	
	private static void print(int idx) {
		//System.out.printf("%d ", idx);
		//System.out.println(sb.toString());
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
