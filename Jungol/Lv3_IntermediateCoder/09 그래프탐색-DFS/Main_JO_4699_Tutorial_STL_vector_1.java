import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_JO_4699_Tutorial_STL_vector_1 { // 제출일 2021-04-25 23:13
	// 제한시간 1000 ms 메모리 제한 8 MB
	// 문제대로 풀면 항상 메모리 초과됨 => 그냥 String 통째로 저장

	// d1.in : mem=12540k time=142ms
	// d2.in : mem=12548k time=141ms
	// d3.in : mem=12548k time=144ms
	// d4.in : mem=12548k time=143ms
	// d5.in : mem=23980k time=483ms
	// d6.in : mem=25236k time=446ms
	// d7.in : mem=25236k time=405ms
	// d8.in : mem=25388k time=416ms
	// d9.in : mem=25388k time=446ms
	// d10.in : mem=25388k time=404ms
	// d11.in : mem=25388k time=497ms
	// d12.in : mem=25388k time=436ms
	// d13.in : mem=25388k time=467ms
	// d14.in : mem=25388k time=429ms
	// d15.in : mem=25388k time=447ms
	// d16.in : mem=55200k time=769ms
	// d17.in : mem=55200k time=757ms
	// d18.in : mem=55200k time=719ms
	// d19.in : mem=55200k time=633ms
	// d20.in : mem=93200k time=1111ms

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	static int numOfArr;
	static String[] sli;
	static List<Node> list;
	static StringBuilder sb = new StringBuilder();
	static int[] query;

	static class Node {
		ArrayList<Integer> li;

		public Node() {
			li = new ArrayList<>();
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(li.get(0));
			for (int i = 1; i < li.size(); i++) {
				sb.append(' ').append(li.get(i));
			}
			sb.append('\n');
			return sb.toString();
		}

	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		numOfArr = Integer.parseInt(br.readLine());
		sli = new String[numOfArr];
		for (int i = 0; i < numOfArr; i++) {
			sli[i] = br.readLine();
			sli[i] = sli[i].substring(sli[i].indexOf(" ") + 1);
		}
//		list = new ArrayList<>();
//		for (int i = 0; i < numOfArr; i++) {
//			st = new StringTokenizer(br.readLine());
//			list.add(new Node());
//			int t = Integer.parseInt(st.nextToken());
//			for (int j = 0; j < t; j++) {
//				list.get(i).li.add(Integer.parseInt(st.nextToken()));
//			}
//		}
		st = new StringTokenizer(br.readLine());
		query = new int[numOfArr];
		for (int i = 0; i < query.length; i++) {
			query[i] = Integer.parseInt(st.nextToken());
		}

	}

	private static void go() {
		for (int i = 0; i < query.length; i++) {
//			sb.append(list.get(query[i]).toString());
			sb.append(sli[query[i]]).append('\n');
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
	}

}