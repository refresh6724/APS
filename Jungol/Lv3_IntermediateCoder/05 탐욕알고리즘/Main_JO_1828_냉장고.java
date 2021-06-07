import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1828_냉장고 { // 제출일 2021-06-07 23:42

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine()); // 1이상 100이하 화학물질의 개수
		int[][] temp = new int[n][2];
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			temp[i][0] = Integer.parseInt(st.nextToken()); // -270 이상 10000이하 범위이내의 두 값
			temp[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(temp, (o1, o2) -> o2[0] - o1[0]); // low 온도가 높은 것부터 정렬

		int refrig = 0;
		int low = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				low = temp[i][0];
				for (int j = i + 1; j < n; j++) {
					if (!visited[j] && temp[j][0] <= low && temp[j][1] >= low) {
						visited[j] = true;
					}
				}
				refrig++;
			}
		}
		bw.write(String.format("%d", refrig));
		bw.flush();
	}
}