import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BOJ_1541_잃어버린괄호 { // 제출일 2020-12-16 23:31 14880 kb 144 ms

	static int[][] min, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 0~9, +, -, 길이 50자
		// 숫자 최대 0~99999, 문자 최대 24개
		// 어떤 연산자부터 처리되는가 brute force
		// 24! = 620448401733239439360000
		// 연산자가 고정되어 있으므로 - 앞을 작게 - 뒤를 크게 만든다
		String exp = br.readLine();
		ArrayList<Integer> num = new ArrayList<>();
		ArrayList<Integer> op = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) >= '0' && exp.charAt(i) <= '9') {
				sb.append(exp.charAt(i));
			} else {
				num.add(Integer.parseInt(sb.toString()));
				op.add((exp.charAt(i) == '+') ? 0 : 1);
				sb = new StringBuilder();
			}
		}
		num.add(Integer.parseInt(sb.toString()));
		int[] n = num.stream().mapToInt(x -> x).toArray();
		int[] o = op.stream().mapToInt(x -> x).toArray();
		int len = n.length;
		min = new int[len][len];
		max = new int[len][len];
		for (int i = 0; i < len; i++) {
			min[i][i] = n[i];
			max[i][i] = n[i];
		}
		int mn = Integer.MAX_VALUE;
		int mx = Integer.MIN_VALUE;
		for (int l = 1; l < len; l++) {
			for (int i = 0; i < len - l; i++) {
				mn = Integer.MAX_VALUE;
				mx = Integer.MIN_VALUE;
				// j번째 연산자에 따라 달라짐
				for (int j = i; j < i + l; j++) {
					if (o[j] == 0) { // + plus
						mn = Math.min(mn, min[i][j] + min[j + 1][i + l]);
						mx = Math.max(mx, max[i][j] + max[j + 1][i + l]);
					} else {
						mn = Math.min(mn, min[i][j] - max[j + 1][i + l]);
						mx = Math.max(mx, max[i][j] - min[j + 1][i + l]);
					}
				}
				min[i][i + l] = mn;
				max[i][i + l] = mx;
			}
		}
		System.out.println(min[0][len - 1]);
	}

}
