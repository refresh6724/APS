import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main_JO_1053_피보나치 { // 제출일 2021-07-08 23:38

	static Map<Integer, int[]> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		map = new HashMap<Integer, int[]>();
		map.put(0, new int[] { 1, 0, 0, 1 });
		map.put(1, new int[] { 1, 1, 1, 0 });
		int input = Integer.parseInt(br.readLine().trim());
		while (input != -1) {
			sb.append(lastFourOfFib(input)).append('\n');
			input = Integer.parseInt(br.readLine().trim());
		}

		bw.write(sb.toString());
		bw.flush();

	}

	/**
	 * 2행 2열의 행렬에 대해 피보나치의 특징을 이용하여 <br>
	 * F(n+1) F(n) = [1 1 ^ n = [1 1 [1 1 ... [1 1<br>
	 * F(n) F(n-1) = ...1 0] .............1 0] 1 0] ... 1 0] <br>
	 * = X^n = X^(n/2)*X^(n/2)*X(n - n/2*2) // 만약 n이 2의 거듭제곱이 아니라면 1이 남는다<br>
	 * n = 0 이면 1001 로 E 단위행렬이 된다<br>
	 * F(0) = 0, F(1) = 1 <br>
	 * 
	 */
	private static int lastFourOfFib(int input) {
		int[] output = squareMatrix(input);
		return output[1];
	}

	private static int[] squareMatrix(int input) {
		if (map.containsKey(input)) {
			return map.get(input);
		}
		int half = input / 2;
		int half2 = half * 2;
		int[] a = squareMatrix(half);
		int[] b = squareMatrix(half);
		int[] ret = multipleMatrix(a, b);
		if (half2 != input) {
			int[] c = map.get(1);
			ret = multipleMatrix(ret, c);
		}
		map.put(input, ret);
		return ret;
	}

	private static int[] multipleMatrix(int[] a, int[] b) {
		int[] ret = new int[4];
		ret[0] = (a[0] * b[0] + a[1] * b[2]) % 10000;
		ret[1] = (a[0] * b[1] + a[1] * b[3]) % 10000;
		ret[2] = (a[2] * b[0] + a[3] * b[2]) % 10000;
		ret[3] = (a[2] * b[1] + a[3] * b[3]) % 10000;
		return ret;
	}

}