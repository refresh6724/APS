import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_17615_볼모으기 { // 제출일 2021-03-21 22:23

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// 빨강과 파랑의 무작위 배열(N <= 50만)을 정렬하기
		// 규칙 1. 빨강이나 파랑을 하나'만' 골라서 옮겨야한다 즉 빨강파랑선택 * 왼쪽오른쪽 = 4가지 경우
		// 규칙 2. 다른 색을 한번에 건너뛸 수 있다

		sb.append(sol1()); // JO 18 MB 311 ms BOJ 20252 kb 284 ms
		// sb.append(sol2()); // JO 19MB 345 ms BOJ 20248 kb 256 ms

		bw.write(sb.toString());
		bw.flush();
	}

	private static int sol2() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int red = 0;
		int blue = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'R') {
				red++;
			}
		}
		if (red == len || red == 0) {
			return 0;
		} else {
			blue = len - red;
			int min, cnt, idx;

			min = 500000;
			cnt = 0;
			idx = 0;
			while (arr[idx++] == 'R') {
				cnt++;
			}
			min = Math.min(min, red - cnt);
			cnt = 0;
			idx = len - 1;
			while (arr[idx--] == 'R') {
				cnt++;
			}
			min = Math.min(min, red - cnt);
			cnt = 0;
			idx = 0;
			while (arr[idx++] == 'B') {
				cnt++;
			}
			min = Math.min(min, blue - cnt);
			cnt = 0;
			idx = len - 1;
			while (arr[idx--] == 'B') {
				cnt++;
			}
			min = Math.min(min, blue - cnt);
			return min;
		}
	}

	private static int sol1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 예
		// RBBBRBRRR
		// 레드 왼쪽 4번
		// 레드 오른쪽 2번
		// 블루 왼쪽 4번
		// 블루 오른쪽 4번

		// R 0 // left > right 까지 각 R, B의 개수?
		// B 0
		// RB 0 0 1 1 // 1 0 0 1
		// RBR 1 1 1 1 // 1 1 1 1
		// RBB 0 1 2 0 // 1 1 0 2
		// RBBB 0 1 3 0 // 1 1 0 2
		// BRBB 1 1 2 1 // 1 1 0 2
		// RBBR 1 1 2 2 // 1 1 1 1
		//
		// 그냥 숫자를 세면 4N
		// 좌우에서 가장 많은 길이를 세고 해당 색을 제외하고 계산 N worst 2N
		int len = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int red = 0;
		int blue = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'R') {
				red++;
			}
		}
		// 단색으로 이뤄진 경우
		if (red == len || red == 0) {
			return 0;
		} else {
			blue = len - red;
			int leftLen = 0;
			int rightLen = 0;
			// 첫번째 색깔에 관계없이 색이 달라지는 곳에서 끊기
			for (int i = 0; i < len - 1; i++) {
				if (arr[i] != arr[i + 1]) {
					leftLen = i + 1;
					break;
				}
			}
			// 마지막 색깔에 관계없이 색이 달라지는 곳에서 끊기
			for (int i = len - 1; i >= 1; i--) {
				if (arr[i] != arr[i - 1]) {
					rightLen = len - i;
					break;
				}
			}
			// 이미 정렬된 경우
			if (leftLen + rightLen == len) {
				return 0;
			} else {
				int cnt = 0;
				if (arr[0] == 'R') {
					if (arr[len - 1] == 'R') { // R ... R
						// R이 더 많은 쪽으로 R을 이동하거나 B를 반대로 이동
						cnt = Math.min(blue, red - Math.max(leftLen, rightLen));
					} else { // R ... B
						// 이동해야하는쪽이 더 적은 쪽을 이동
						cnt = Math.min(red - leftLen, blue - rightLen);
					}
				} else {
					if (arr[len - 1] == 'R') { // B ... R
						// 이동해야하는쪽이 더 적은 쪽을 이동
						cnt = Math.min(red - rightLen, blue - leftLen);
					} else { // B ... B
						// B가 더 많은 쪽으로 B를 이동하거나 R을 반대로 이동
						cnt = Math.min(red, blue - Math.max(leftLen, rightLen));
					}
				}
				return cnt;
			}
		}
	}

}