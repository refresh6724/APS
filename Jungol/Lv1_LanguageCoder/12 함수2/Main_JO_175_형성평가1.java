import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_JO_175_형성평가1 { // 제출일 2021-01-23 21:53

	static int n;
	static ArrayList<Integer> li;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		// 정수 N을 입력받고 다시 N개의 정수를 입력받아 내림차순으로 정렬하여 출력하는 프로그램을 작성하시오.
		// (1 ≤ N ≤ 15, 입력과 출력, 정렬은 모두 함수를 이용할 것)

		input();
		reverse_sort();
		print();
	}

	private static void print() throws Exception {
		for (int i : li) {
			sb.append(i).append(' ');
		}
		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static void reverse_sort() {
		Collections.sort(li, Collections.reverseOrder());
	}

	private static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		li = new ArrayList<Integer>(n);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}
	}

}