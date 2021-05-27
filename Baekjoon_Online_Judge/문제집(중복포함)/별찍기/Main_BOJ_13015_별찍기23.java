import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_13015_별찍기23 { // 제출일 2020-02-29 23:28

	public static void main(String[] args) throws IOException {
		SeparateClass stc = new SeparateClass();
		stc.solution();
	}
}

class SeparateClass {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n, m, a, b, c, d;
	StringBuilder sb = new StringBuilder();

	public void solution() throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		m = n - 1;

		a = 0;
		b = m;
		d = m << 2;
		c = d - m;

		sb = new StringBuilder();

		// 첫번째 줄
		for (int i = a; i <= b; i++) {
			sb.append('*');
		}
		for (int i = n; i < c; i++) {
			sb.append(' ');
		}
		for (int i = c; i <= d; i++) {
			sb.append('*');
		}
		sb.append("\n");

		// 두번째부터 n-1줄까지
		for (int i = 1; i < m; i++) {
			a++;
			b++;
			c--;
			d--;
			for (int j = 0; j < a; j++) {
				sb.append(' ');
			}
			sb.append('*');
			for (int j = a + 1; j < b; j++) {
				sb.append(' ');
			}
			sb.append('*');
			for (int j = b + 1; j < c; j++) {
				sb.append(' ');
			}
			sb.append('*');
			for (int j = c + 1; j < d; j++) {
				sb.append(' ');
			}
			sb.append('*').append("\n");

		}

		a++;
		b++;
		c--;
		d--;

		for (int i = 0; i < a; i++) {
			sb.append(' ');
		}
		sb.append('*');
		for (int i = a + 1; i < b; i++) {
			sb.append(' ');
		}
		sb.append('*');
		for (int i = c + 1; i < d; i++) {
			sb.append(' ');
		}
		sb.append('*').append("\n");

		// 두번째부터 n-1줄까지
		for (int i = 1; i < m; i++) {
			a--;
			b--;
			c++;
			d++;
			for (int j = 0; j < a; j++) {
				sb.append(' ');
			}
			sb.append('*');
			for (int j = a + 1; j < b; j++) {
				sb.append(' ');
			}
			sb.append('*');
			for (int j = b + 1; j < c; j++) {
				sb.append(' ');
			}
			sb.append('*');
			for (int j = c + 1; j < d; j++) {
				sb.append(' ');
			}
			sb.append('*').append("\n");
		}

		a--;
		b--;
		c++;
		d++;
		// 마지막 줄
		for (int i = a; i <= b; i++) {
			sb.append('*');
		}
		for (int i = n; i < c; i++) {
			sb.append(' ');
		}
		for (int i = c; i <= d; i++) {
			sb.append('*');
		}
		sb.append("\n");

		System.out.print(sb.toString());
	}

}
