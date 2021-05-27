import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_10996_별찍기21 { // 제출일 2020-02-28 19:01

	public static void main(String[] args) throws IOException {
		SeparateTestClass stc = new SeparateTestClass();
		stc.solution();
	}
}

class SeparateTestClass {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n;

	public void solution() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine().trim());

		// n/2 + 1번
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ((n + 1) >> 1); i++) {
			sb.append('*').append(' ');
		}
		String a = sb.toString().trim();

		// n/2 번
		sb = new StringBuilder();
		for (int i = 0; i < (n >> 1); i++) {
			sb.append(' ').append('*');
		}
		String b = sb.toString();

		// n번
		sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(a).append("\n").append(b).append("\n");
		}

		System.out.println(sb.toString());
	}
}