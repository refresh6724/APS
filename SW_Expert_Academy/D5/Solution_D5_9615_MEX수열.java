import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// ref.
// Lessons in Play: An Introduction to Combinatorial Game Theory
// By Michael Albert, Richard Nowakowski, David Wolfe
// chapter 7 impartial games
public class Solution_D5_9615_MEX수열 { // 제출일 2020-03-09 06:09
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // N
			int K = Integer.parseInt(st.nextToken()); // K
			int ans = 0; // ans

			if (K > N) { // K > N
				ans = 0;
			} else { // K < N

				// 1. 시간 초과
//				while(N%K != 0) {
//					N -= (N/K)+1;
//					sb.append("N : ").append(N).append(" repeat : ").append(repeat++).append("\n");
//				}				

				// 2. 반복을 나머지 연산으로 대체
				while (N % K != 0) {
					int mok = N / K; // mok
					int sub = N - (K * mok); // sub
					mok++;
					if (sub % mok == 0) {
						N = N - mok * (sub / mok); // 버림 때문에 약분하면 안된다
//						sb.append("N : ").append(N).append(" repeat : ").append(repeat++).append("\n");
						break;
					} else {
						N = N - mok * (sub / mok + 1);
//						sb.append("N : ").append(N).append(" repeat : ").append(repeat++).append("\n");
					}
				}

				ans = N / K;

			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}

}
