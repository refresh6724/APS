import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_JO_4524_Tutorial_STL_Sort_2 { // 제출일 2021-04-18 21:29

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

	}

	private static void go() {		
		arr = Arrays
				.stream(arr)
				.boxed()
				.sorted(Comparator.reverseOrder())
				.mapToInt(x->x)
				.toArray();		
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