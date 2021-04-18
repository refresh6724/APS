import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_4523_Tutorial_STL_Sort_1 { // 제출일 2021-04-18 21:21

	static int n;
	static int[] arr;
	static int a, b;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

	}

	private static void go() {
		Arrays.sort(arr, a, b + 1);
		print();
		Arrays.sort(arr);
		print();
	}

	private static void print() {
		sb.append(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			sb.append(' ').append(arr[i]);
		}
		sb.append('\n');
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(sb.toString());
		bw.flush();
	}

}