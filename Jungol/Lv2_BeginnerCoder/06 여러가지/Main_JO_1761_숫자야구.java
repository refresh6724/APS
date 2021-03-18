import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_JO_1761_숫자야구 { // 제출일 2021-03-19 01:49

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 111~999를 먼저 저장한다
		ArrayList<Integer> li = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) {			
			for (int j = 1; j <= 9; j++) {
				if(i==j) {
					continue;
				}
				for (int k = 1; k <= 9; k++) {
					if(i==k || j==k) {
						continue;
					}
					li.add(i * 100 + j * 10 + k);
				}
			}
		}

		int n = Integer.parseInt(br.readLine().trim());
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			int h = line.charAt(0) - '0';
			int t = line.charAt(1) - '0';
			int o = line.charAt(2) - '0';
			for (int idx = 0; idx < li.size(); idx++) {
				//
				strike = 0;
				ball = 0;
				int cand = li.get(idx);
				int a = cand / 100;
				int b = (cand % 100) / 10;
				int c = cand % 10;
				if (a == h) {
					strike++;
				} else if (a == t || a == o) {
					ball++;
				}
				if (b == t) {
					strike++;
				} else if (b == h || b == o) {
					ball++;
				}
				if (c == o) {
					strike++;
				} else if (c == h || c == t) {
					ball++;
				}

				if (strike != line.charAt(4) - '0' || ball != line.charAt(6) - '0') {
					li.remove(idx);
					idx--;
				}
			}
		}
		sb.append(li.size());

		bw.write(sb.toString());
		bw.flush();
	}

}