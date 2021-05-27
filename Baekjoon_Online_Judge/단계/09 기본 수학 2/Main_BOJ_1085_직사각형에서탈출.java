import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1085
 */
public class Main_BOJ_1085_직사각형에서탈출 { // 제출일 2020-11-08 20:43

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 원점 0, 0과 직사각형 대각선 오른쪽 위의 점 w, h에 대해
		// 점 x, y에서 직사각형에 수선을 그렸을 때 가장 짧은 거리를 출력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		System.out.println(Math.min(Math.min(x, y), Math.min(w - x, h - y)));
	}
}
