import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1161_하노이1 { // 제출일 2021-03-28 19:37

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 하노이의 탑 순서대로 출력
		// 3 // 1번 기둥에 원판 3개가 쌓여있을 때
		// 원판번호 : 이동전 기둥번호 -> 이동후 기둥번호
		// 1 : 1 -> 3 // 1번 원판에 대해 1번 기둥에서 3번 기둥으로 이동
		// 2 : 1 -> 2 // 2번 원판에 대해 1번 기둥에서 2번 기둥으로 이동
		// ...
		// 1 : 1 -> 3 // 1번 원판에 대해 1번 기둥에서 3번 기둥으로 이동

		// n층의 탑에 대해서
		// 1. 1번 기둥에서 2번 기둥으로 n-1층을 옮긴다
		// 2. 1번 기둥에서 3번 기둥으로 n번 원판을 옮긴다
		// 3. 2번 기둥에서 3번 기둥으로 n-1층을 옮긴다

		int n = Integer.parseInt(br.readLine());
		hanoi(n, 1, 2, 3);

		bw.write(sb.toString());
		bw.flush();
	}

	private static void hanoi(int n, int from, int via, int to) {

		if (n == 1) {
			sb.append(String.format("%d : %d -> %d\n", 1, from, to));
			return;
		}

		hanoi(n - 1, from, to, via);
		sb.append(String.format("%d : %d -> %d\n", n, from, to));
		hanoi(n - 1, via, from, to);

	}

}