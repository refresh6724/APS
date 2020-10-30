import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2839
 */
public class Main_BOJ_2292_벌집 { // 제출일 2020-10-30 23:31

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 벌집모양의 숫자 배치에서 숫자 n(10억 이하)이 주어질 때 1에서 n까지 가는 최소 거리를 출력(1과 n 포함)

		// 중앙 1
		// 아래방향 2
		// 그리고 시계방향으로 3 4 5 6 7
		// 다시 아래 방향 8
		// 시계방향으로 9 ~ 19

		// 규칙성
		// 1(1) : 1
		// 2 ~ 7(6) : 2
		// 8 ~ 19(12) : 3
		// 20 ~ 37(18) : 4
		// 38 ~ 61(24) : 5
		// 1 다음
		// n 번째 shell 의 시작 숫자는 3n(n-1)+2 원소 개수는 6n개
		int n = Integer.parseInt(br.readLine());
		// sqrt(10억) = 31622.8
		int[] shell = new int[31623];
		shell[1] = 1;
		shell[2] = 2;
		for (int i = 3; i < shell.length; i++) {
			shell[i] = shell[i - 1] + 6 * (i - 2);
		}

		for (int i = 0; i < shell.length; i++) {
			if (n < shell[i]) {
				System.out.println(i - 1);
				break;
			}
		}
	}
}
