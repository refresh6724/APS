import java.util.ArrayList;
import java.util.Arrays;

public class Solution_Level_3_110옮기기 {// 제출일 2021-05-15 23:07

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "1110", "100111100", "0111111010" })));
		// "1101", "100110110", "0110110111"
//		System.out.println(Arrays.toString(solution(new String[] { "110110110" })));
//		System.out.println(Arrays.toString(solution(new String[] { "1101", "1001", "1111" })));

//		String[] testcase = makeTC(6);
//		String[] output = solution(testcase);
//		for (int i = 0; i < output.length; i++) {
//			if(!testcase[i].equals(output[i])) {
//				System.out.println(String.format("input : %s output : %s\n", testcase[i], output[i]));
//			}
//		}

//		char[] a = new char[100000];

		// 110으로 끝까지 채우는 경우
		// 100만 개
		// cnt 333333
		// 394 ms
//		Arrays.fill(a, '0');
//		for (int i = 0; i < a.length - 1; i += 3) {
//			a[i] = '1';
//			a[i + 1] = '1';
//		}
		
		// 111100 으로 while문이 계속 반복되도록 채우는 경우
		
		// 1만 개
		// cnt 3333
		// 437 ms
		
		// 10만 개 
		// cnt 33333
		// 28,201 ms
		
		// 100만 개
		// 시간 초과
		
//		Arrays.fill(a, 0, 66666, '1');
//		Arrays.fill(a, 66666, 100000, '0');
//		
//		String[] b = new String[1];
//		b[0] = String.copyValueOf(a);
//		long start = System.currentTimeMillis();
//		System.out.println(Arrays.toString(solution(b)));
//		System.out.println("cnt " + cnt);
//		long end = System.currentTimeMillis();
//		System.out.println(end - start);
		
	}

	static int cnt;
	static ArrayList<String> tc;

	private static String[] makeTC(int len) {
		tc = new ArrayList<>(1 << len);
		char[] arr = new char[len];
		Arrays.fill(arr, '0');
		dfs(0, len, arr);
		return tc.stream().toArray(String[]::new);
	}

	private static void dfs(int i, int len, char[] arr) {
		if (i == len) {
			tc.add(String.copyValueOf(arr));
			return;
		}

		dfs(i + 1, len, arr);
		arr[i] = '1';
		dfs(i + 1, len, arr);
		arr[i] = '0';

	}

	public static String[] solution(String[] s) {
		String[] answer = new String[s.length];
		for (int i = 0; i < answer.length; i++) {
			if (s[i].length() < 4) {
				answer[i] = s[i];
			} else {
				answer[i] = run(s[i]);
			}
		}
		return answer;
	}

	private static String run(String a) {
		cnt = 0;
		
//		while (a.contains("110")) {
//			// replace에 내가 알지 못하는 작동 기전이 있다
//			a = a.replaceAll("110", "X");
//			for (int i = 0; i < a.length(); i++) {
//				if (a.charAt(i) == 'X') {
//					cnt++;
//				}
//			}
//			a = a.replaceAll("X", "");
//		}
//		if (cnt == 0) {
//			return a;
//		}
		
		// 110 찾기 개선
		StringBuilder sb = new StringBuilder();
		int one = 0;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '1') {
				one++;
			} else {
				if(one >= 2) {
					cnt++;
					one -= 2;
				} else {
					for (int j = 0; j < one; j++) {
						sb.append('1');
					}
					sb.append('0');
					one = 0;
				}
			}
		}
		for (int j = 0; j < one; j++) {
			sb.append('1');
		}		
		if (cnt == 0) {
			return a;
		}
		a = sb.toString();

		boolean find = false;
		sb = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			if (subIsMoreThan110Ver2(a.substring(i, Math.min(i + 3, a.length())))) {
				find = true;
				sb.append(a.substring(0, i));
				for (int j = 0; j < cnt; j++) {
					sb.append("110");
				}
				sb.append(a.substring(i));
				break;
			}
		}
		if (!find) {
			sb.append(a);
			for (int j = 0; j < cnt; j++) {
				sb.append("110");
			}
		}
		return sb.toString();
	}

	private static boolean subIsMoreThan110Ver2(String sub) {
		if (sub.length() == 1 && sub.equals("1")) {
			return true;
		}
		if (sub.length() == 2 && sub.equals("11")) {
			return true;
		}
		if (sub.length() == 3 && sub.equals("111")) {
			return true;
		}
		return false;
	}
}
