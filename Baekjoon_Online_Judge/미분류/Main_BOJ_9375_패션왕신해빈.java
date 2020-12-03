import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main_BOJ_9375_패션왕신해빈 { // 제출일 2020-12-03 22:36 14568 kb 152 ms

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 의상 n개가 의상 이름과 종류로 주어질때
		// 같은 조합이 아닌 경우의 수

		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				String cat = br.readLine().split(" ")[1];
				if (map.containsKey(cat)) {
					map.put(cat, map.get(cat) + 1);
				} else {
					map.put(cat, 1);
				}
			}
			int sum = 1;
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				sum *= (int) entry.getValue() + 1;
			}
			sb.append(sum - 1).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}
