import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Main_JO_2275_음료수자판기 { // 제출일 2021-06-11 06:44

	static int n, ans;
	static Map<Integer, Integer> line;
	static int[] sumofnsquare;
	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine()); // 자판기가 있는 좌표의 수 1 이상 200 이하
		ans = 0;
		line = new ConcurrentHashMap<>();
		getn2();
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken()); // 위치 -1백만에서 1백만
			int num = Integer.parseInt(st.nextToken()); // 개수 총합 최대 200개
			if (num == 1) {
				line.put(pos, 1);
			} else {
				q.add(new int[] { pos, num });
			}
		}
	}

	static void getn2() {
		sumofnsquare = new int[101];
		for (int i = 1; i < 101; i++) {
			sumofnsquare[i] = sumofnsquare[i - 1] + i * i; // (i*(i+1)*(2*i+1)) / 6
		}
//		System.out.println(sumofnsquare[100]); // 338350
//		System.out.println(sumofnsquare[200]); // 2686700
	}

	// 한 자리에 위치한 수로부터 퍼져나가는 이동횟수
	// 0,1 : 0
	// 2,3 : 1
	// 4,5 : 1 + (1+2+1) = 5
	// 5 => 131 => 11111
	// 6,7 : 1 + (1+2+1) + (1+2+3+2+1) = 15
	// 7 => 151 => 11311 => 1111111
	// 8,9 : 1 + (1+2+1) + (1+2+3+2+1) + (1+2+3+4+3+2+1) = 31
	// 2n,2n+1 : sigma n^2

	// 2 이상의 값을 갖는 위치를 매번 주변으로 나눈다
	private static void go() {
		int idx, val;
		boolean even;
		while (!q.isEmpty()) {
			while (!q.isEmpty()) {
				idx = q.peek()[0];
				val = q.poll()[1];
				even = (val % 2 == 0);
				val >>= 1;
				ans += sumofnsquare[val];
				for (int i = idx - val; i <= idx + val; i++) {
					line.put(i, line.getOrDefault(i, 0) + 1);
				}
				if (even) {
					line.put(idx, line.get(idx) - 1);
				}
			}

			// 배열 => 2백만번 검색을 반복 => 시간 초과
			// 해시맵 => 있는 개수만큼만 반복
			// 아래 두 식을 합칠 때 일반 HashMap인 경우 ConcurrentModification 예외 발생
			line.forEach((k, v) -> {
				if (v > 1) {
					q.add(new int[] { k, v });
					line.put(k, 0);
				}
			});
//			line.entrySet().removeIf(e -> e.getValue() > 1);
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}