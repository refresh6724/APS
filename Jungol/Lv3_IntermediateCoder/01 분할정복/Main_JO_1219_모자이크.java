import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1219_모자이크 { // 제출일 2021-04-13 23:40

	static int row, col, papers, wrong, minH;
	static int[] p;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken()); // 1백만 이하
		col = Integer.parseInt(st.nextToken()); // 1백만 이하
		papers = Integer.parseInt(br.readLine()); // 100 이하
		wrong = Integer.parseInt(br.readLine()); // 1천 이하
		minH = 0; // 첫번째 조건에 따라 모든 색종이 크기는 같다
		p = new int[wrong];
		for (int i = 0; i < wrong; i++) {
			st = new StringTokenizer(br.readLine());
			minH = Math.max(minH, Integer.parseInt(st.nextToken()));
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.parallelSort(p);
	}

	private static void go() {

		if (cover(minH)) {
			return;
		}

		int low = minH;
		minH = 1000000;
		int high = row;
		int mid = (low + high) / 2;
		while (low <= high) {
			// mid 크기 색종이 papers 개로 덮기가 가능하면 minH를 mid로 바꾸고 더 작은 것을 테스트
			if (cover(mid)) {
				minH = Math.min(minH, mid);
				high = mid - 1;
			} else { // 불가능하면 low를 올려 테스트
				low = mid + 1;
			}
			mid = (low + high) / 2;
		}
	}

	private static boolean cover(int mid) {
		int cnt = 1;
		int left = p[0];
		int right = left + mid - 1;
		int idx = 0;
		// p 에 대해서 mid 크기의 색종이가 덮으면 다음 색종이로
		while (cnt <= papers) {
			while (p[idx] <= right) {
				if (++idx == wrong) {
					return true;
				}
			}
			if (idx == wrong) {
				break;
			}
			left = p[idx];
			right = left + mid - 1;
			cnt++;
		}
		return false;
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(minH);
		bw.write(sb.toString());
		bw.flush();
	}

}