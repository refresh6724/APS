import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1071_약수와배수 { // 제출일 2021-02-28 19:26

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		
		int div = 0;
		int mul = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > m && arr[i] % m == 0) {
				mul += arr[i];
			} else if(arr[i] == m) {
				div += m;
				mul += m;
			} else if(arr[i] < m && m % arr[i] == 0){
				div += arr[i];
			}
		}
		sb.append(div).append('\n').append(mul);

		bw.write(sb.toString());
		bw.flush();
	}

}