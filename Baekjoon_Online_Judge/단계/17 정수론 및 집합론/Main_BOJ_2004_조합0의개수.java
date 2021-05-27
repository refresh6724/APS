import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_2004_조합0의개수 { // 제출일 2020-12-05 23:38

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// nCm의 0의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int n_m = n - m;
		// 최대 20억 
		// log 2 + 9 = 9.3 = k log 5 = k (1 - log 2) = 0.7 k
		// k = 13.3
		// 5^13 = 1 220 703 125
		
		// 9.3 = t log 2
		// t = 31
		// 2^31 = 2 147 483 648
		int two = 0;
		int five = 0;
		int div = 5;
		for (int f = 1; f < 14; f++, div *= 5) {
			five += n / div;
			five -= m / div;
			five -= n_m / div;
		}
		div = 2;
		for (int t = 1; t < 31; t++, div *= 2) {
			two += n / div;
			two -= m / div;
			two -= n_m / div;
		}

		bw.write(Integer.toString(Math.min(five, two)));
		bw.flush();
	}

}
