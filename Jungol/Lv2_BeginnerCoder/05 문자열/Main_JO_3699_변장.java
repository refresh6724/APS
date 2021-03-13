import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_JO_3699_변장 { // 제출일 2021-03-13 23:13

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if (map.containsKey(b)) {
					map.put(b, map.get(b) + 1);
				} else {
					map.put(b, 1);
				}
			}

			int sum = 1;
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				sum *= entry.getValue() + 1;
			}
			sb.append(sum - 1).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}