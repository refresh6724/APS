public class Solution_Level_1_1차_다트게임 { // 제출일 2021-08-20 23:03

	// test
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T")); // 37
		System.out.println(solution("1D2S#10S")); // 9
		System.out.println(solution("1D2S0T")); // 3
		System.out.println(solution("1S*2T*3S")); // 23
		System.out.println(solution("1D#2S*3S")); // 5
		System.out.println(solution("1T2D3D#")); // -4
		System.out.println(solution("1D2S3T*")); // 59

	}

	/**
	 * 각 점수는 0에서 10 사이 정수 보너스는 S, D, T 셋 중 하나 옵션은 *이나 # 둘 중 하나이며, 없을 수도 있다
	 * 
	 * @param dartResult 점수 | 보너스 | 옵션으로 이루어진 문자열
	 * @return 세번의 기회에서 얻은 점수 합계
	 */
	public static int solution(String dartResult) {
		int[] score = new int[4];
		char[] cs = dartResult.toCharArray();
		int idx = 0;
		int sidx = 1;
		while (idx < dartResult.length()) {
			int base = cs[idx++] - '0';
			if (base == 1 && cs[idx] == '0') {
				idx++;
				base = 10;
			}
			switch (cs[idx++]) {
			case 'S':
				break;
			case 'D':
				base *= base;
				break;

			case 'T':
				base *= base * base;
				break;
			}

			if (idx != dartResult.length()) {
				switch (cs[idx++]) {
				case '*':
					score[sidx - 1] *= 2;
					base *= 2;
					break;

				case '#':
					base *= -1;
					break;

				default:
					idx--;
				}
			}

			score[sidx++] = base;
		}

		return score[1] + score[2] + score[3];

	}
}
