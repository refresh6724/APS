import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1374_긴자리덧셈뺄셈 { // 제출일 2021-05-07 21:30

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		char[] n = br.readLine().trim().toCharArray();
		char[] m = br.readLine().trim().toCharArray();

		while (!(n[0] == '0' && m[0] == '0')) {

			sb.append(calc(n, m));

			n = br.readLine().trim().toCharArray();
			m = br.readLine().trim().toCharArray();
		}

		bw.write(sb.toString());
		bw.flush();

	}

	/**
	 * 길이 200 이하의 양수 배열 n과 m에 대해 합과 차를 String으로 리턴한다
	 * 
	 * @param n
	 * @param m
	 * @return 합\n차\n
	 */
	private static String calc(char[] n, char[] m) {
		StringBuilder sb = new StringBuilder();

		// 대소 판별은 서로를 빼는 과정에서 알게 된다
		// x1 - x2 < 0 이면 x1 < x2
		// 다른 방법으로는 자릿수를 하나씩 비교하면서 비교하는 방법이 있다
		int[] num = new int[] {};
		switch (nMinusM(n, m)) {
		case 0:
			num = plus(n, m);
			sb.append(toNum(num));
			sb.append(0).append('\n');
			return sb.toString();
		case -1:
			num = plus(m, n);
			sb.append(toNum(num));
			num = diff(m, n);
			break;
		case 1:
			num = plus(n, m);
			sb.append(toNum(num));
			num = diff(n, m);
			break;
		}
		sb.append(toNum(num));
		return sb.toString();
	}

	/**
	 * a의 길이가 항상 b의 길이보다 같거나 크다
	 * 
	 * @param a
	 * @param b
	 * @return a와 같은 길이 또는 a보다 한 칸 큰 배열에 a와 b의 합을 리턴
	 */
	private static int[] plus(char[] a, char[] b) {

		char[] bb = makeSameLen(a.length, b);

		int[] ret = new int[a.length + 1];
		for (int i = 1; i < ret.length; i++) {
			ret[i] = (a[i - 1] - '0') + (bb[i - 1] - '0');
		}

		for (int i = ret.length - 1; i > 0; i--) {
			ret[i - 1] += ret[i] / 10;
			ret[i] %= 10;
		}

		return ret;
	}

	/**
	 * b의 길이를 a와 같게 만든 char 배열을 리턴한다<br>
	 * 추가된 길이만큼 앞에 '0'을 채운다
	 * 
	 * @param alen
	 * @param b
	 * @return 길이가 조정된 char배열
	 */
	private static char[] makeSameLen(int alen, char[] b) {
		char[] ret = new char[alen];
		int gap = alen - b.length;
		for (int i = 0; i < gap; i++) {
			ret[i] = '0';
		}
		for (int i = 0; i < b.length; i++) {
			ret[i + gap] = b[i];
		}
		return ret;
	}

	/**
	 * 길이가 200 이하인 양수 배열이 입력될 때 더 큰 쪽이 어디인지 리턴한다
	 * 
	 * @param n
	 * @param m
	 * @return 0 이면 같은 수 1이면 n이 더 큰 수 -1이면 m이 더 큰 수
	 */
	private static int nMinusM(char[] n, char[] m) {

		if (n.length > m.length) {
			return 1;
		} else if (n.length < m.length) {
			return -1;
		} else {
			for (int i = 0; i < n.length; i++) {
				if (n[i] > m[i]) {
					return 1;
				} else if (n[i] < m[i]) {
					return -1;
				}
			}
		}
		// n과 m이 같은 수일때
		return 0;
	}

	/**
	 * a의 길이가 b의 길이보다 같거나 크고 숫자로 바꾼 값이 a 값이 항상 b 값보다 클 때 그 차이를 int 배열로 리턴
	 * 
	 * @param a
	 * @param b
	 * @return a-b를 int배열로 리턴
	 */
	private static int[] diff(char[] a, char[] b) {

		char[] bb = makeSameLen(a.length, b);
		int[] ret = new int[a.length];
		for (int i = 0; i < ret.length; i++) {
			if (a[i] >= bb[i]) {
				ret[i] = (a[i] - '0') - (bb[i] - '0');
			} else {
				ret[i - 1]--;
				int idx = 1;
				while (ret[i - idx] < 0) {
					ret[i - idx] += 10;
					ret[i - idx - 1]--;
					idx++;
				}
				ret[i] = 10 + (a[i] - '0') - (bb[i] - '0');
			}
		}
		return ret;
	}

	/**
	 * 001234 형태의 num 배열을 1234 String으로 바꿔 리턴한다
	 * 
	 * @param num
	 * @return num배열을 String으로 바꿔 리턴한다
	 */
	private static String toNum(int[] num) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while (num[idx] == 0) {
			idx++;
		}
		for (int i = idx; i < num.length; i++) {
			sb.append(num[i]);
		}
		return sb.append('\n').toString();
	}

}