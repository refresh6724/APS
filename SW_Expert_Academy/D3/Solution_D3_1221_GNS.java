import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution_D3_1221_GNS { // 제출일 2020-06-08 23:21 36,264 kb 170 ms

	static HashMap<String, Integer> map = new HashMap<>();
	static String[] rev = new String[10];

	public static void main(String[] args) throws Exception {

		rev[0] = "ZRO";
		rev[1] = "ONE";
		rev[2] = "TWO";
		rev[3] = "THR";
		rev[4] = "FOR";
		rev[5] = "FIV";
		rev[6] = "SIX";
		rev[7] = "SVN";
		rev[8] = "EGT";
		rev[9] = "NIN";

		for (int i = 0; i < 10; i++) {
			map.put(rev[i], i);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
//		Scanner sc = new Scanner(System.in);
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken()).append('\n'); // #tc
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				arr[i] = map.get(st.nextToken());
			}
			Arrays.sort(arr);
			for (int i = 0; i < n - 1; i++) {
				sb.append(rev[arr[i]]).append(' ');
			}
			sb.append(rev[arr[n - 1]]).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
