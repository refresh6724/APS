import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1240_제곱근 { // 제출일 2021-04-12 01:18

	static long n, x;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

//		n = Long.parseLong(br.readLine()); // 2^63-1 이하 양의 정수
//		System.out.println(Integer.MAX_VALUE); // (1L<<31)-1
//		System.out.println(Long.MAX_VALUE); // (1L<<63)-1 
//		im * im = 4611686014132420609
//		n = Long.MAX_VALUE; // 9223372036854775807
//		System.out.println((long)Math.sqrt(9223372036854775807L));
		n = Long.parseUnsignedLong(br.readLine()); // 2^63-1 이하 양의 정수
	}

	private static void go() {
		x = myFunc(n);
	}

	private static long myFunc(long n) {
		// s.q.r.t 단어 사용시 제출 불가
		// 나만의 제곱근 함수를 구현
		long low = Long.parseUnsignedLong("1");
		long high = Long.parseUnsignedLong("4294967295"); // (1L << 32) - 1; // 4294967295
		long mid = Long.divideUnsigned((low + high), 2);
		while (low <= high) {
			int cp = Long.compareUnsigned(mid * mid, n);
			if (cp == 0) {
				return mid;
			} else if (cp < 0) {
				low = mid + 1;
			} else if (cp > 0) {
				high = mid - 1;
			}
			mid = Long.divideUnsigned((low + high), 2);
		}
		return mid;
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(x);
		bw.write(sb.toString());
		bw.flush();
	}

}