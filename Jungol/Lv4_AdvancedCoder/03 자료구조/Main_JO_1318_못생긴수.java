import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main_JO_1318_못생긴수 { // 제출일 2021-07-18 22:38

	static Integer[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine().trim());
		findUgly();
		while (n != 0) {
			sb.append(num[n]).append('\n');
			n = Integer.parseInt(br.readLine().trim());
		}

		bw.write(sb.toString());
		bw.flush();

	}

	private static void findUgly() {
		num = new Integer[1501];
//		num[1] = 1;
//		num[2] = 2;
//		num[3] = 3;
//		num[4] = 4;
//		num[5] = 5;

		Set<Long> set = new HashSet<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(1);
		int n = 0;
		long two, three, five;
		while (++n <= 1500) {
			num[n] = pq.poll();
			two = (long) num[n] << 1;
			three = two + num[n];
			five = three + two;
			if (!set.contains(two) && two < Integer.MAX_VALUE) {
				set.add(two);
				pq.add((int) two);
			}
			if (!set.contains(three) && three < Integer.MAX_VALUE) {
				set.add(three);
				pq.add((int) three);
			}
			if (!set.contains(five) && five < Integer.MAX_VALUE) {
				set.add(five);
				pq.add((int) five);
			}
		}
	}
}