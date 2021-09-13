import java.util.Arrays;

public class Solution_Level_2_이진변환반복하기 { // 제출일 2020-11-15 23:45

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("110010101001"))); // 3,8
		System.out.println(Arrays.toString(solution("01110")));// 3,3
		System.out.println(Arrays.toString(solution("1111111")));// 4,1
		System.out.println(Arrays.toString(solution("1")));// 0,0
		System.out.println(Arrays.toString(solution("10")));// 1,1
		System.out.println(Arrays.toString(solution("11")));// 2,1
	}

	public static int[] solution(String s) {

		// 0을 제거
		// 길이를 2진법으로 표시
		// 1이 될때까지 변환 횟수와 제거된 0의 개수를 리턴
		int change = 0;
		int zero = 0;
		int one = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				zero++;
			} else {
				one++;
			}
		}

		while (one != 1) {
			change++;
			String x = Integer.toBinaryString(one);
			one = 0;
			for (int j = 0; j < x.length(); j++) {
				if (x.charAt(j) == '0') {
					zero++;
				} else {
					one++;
				}
			}
		}
		if(zero != 0) {
			change++;
		}
		return new int[] { change, zero };
	}

}