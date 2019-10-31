import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
// 기존 제출일 2019-10-31 11:38 (풀이시간 11:03~11:38 약 30분)
public class Solution_D0_5658_보물상자비밀번호 { // 수정 제출일 2020-03-01 21:54
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int K;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			String line = br.readLine();
			char[] arr = line.toCharArray();
			HashSet<Integer> set = new HashSet<>();
			int rot = N / 4;
			for (int i = 0; i < rot; i++) {
				set.add(Integer.parseInt(line.substring(0, rot), 16));
				set.add(Integer.parseInt(line.substring(rot, rot * 2), 16));
				set.add(Integer.parseInt(line.substring(rot * 2, rot * 3), 16));
				set.add(Integer.parseInt(line.substring(rot * 3, rot * 4), 16));
				// 회전
				char tmp = arr[0];
				for (int j = 1; j < N; j++) {
					arr[j - 1] = arr[j];
				}
				arr[N - 1] = tmp;
				line = String.valueOf(arr);
			}

			ArrayList<Integer> array = new ArrayList(set);
			Collections.sort(array);

			sb.append("#").append(tc).append(" ").append(array.get(array.size() - K)).append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();

	}

}
