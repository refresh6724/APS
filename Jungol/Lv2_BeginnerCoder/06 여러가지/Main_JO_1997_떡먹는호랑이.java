import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1997_떡먹는호랑이 { // 제출일 2021-03-17 23:01

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] arr = new int[30];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 2] + arr[i - 1];
		}

		// 1 1 2 3 5 8 13 ...
		// 오늘 준 숫자 k 날짜 d
		// 첫날 a
		// 둘쨋날 b
		// 3 a+b
		// 4 b+(a+b)=a+2b
		// 5 (a+b)+(b+a+b)=2a+3b
		// 6 (a+2b)+(2a+3b)=3a+5b
		// 7 (2a+3b)+(3a+5b)=5a+8b
		// d일 = arr[d-3] * a + arr[d-2] * b

		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 6 41
		// 3a + 5b = 41
		// 41/5 = 8 ... 1, 1/3 = 0 ... 1 몫이 0이라 불성립
		// 41/5 = 7 ... 6, 6/3 = 2 ... 0 => 2, 7
		int mok = k / arr[d - 2];
		int nam = k % arr[d - 2];
		for (int i = 0; i < mok; i++) {
			if (nam != 0 && nam / arr[d - 3] != 0 && nam % arr[d - 3] == 0) {
				sb.append(nam / arr[d - 3]).append('\n');
				sb.append(mok).append('\n');
				break;
			}
			mok -= 1;
			nam += arr[d - 2];
		}

		bw.write(sb.toString());
		bw.flush();
	}

}