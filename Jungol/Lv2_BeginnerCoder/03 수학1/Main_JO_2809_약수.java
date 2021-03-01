import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_JO_2809_약수 { // 제출일 2021-03-01 23:01

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int rtn = (int) (Math.sqrt(n));
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= rtn; i++) {
			if (n % i == 0) {
				set.add(i);
				set.add(n / i);
			}
		}
		int[] arr = set.stream().mapToInt(x -> x).sorted().toArray();
		sb.append(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			sb.append(' ').append(arr[i]);
		}

		bw.write(sb.toString());
		bw.flush();
	}

}