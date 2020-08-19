import java.util.Arrays;

public class Solution_Level_2_카펫 { // 제출일 2020-08-19 19:06

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2))); // {4,3}
		System.out.println(Arrays.toString(solution(8, 1))); // {3,3}
		System.out.println(Arrays.toString(solution(24, 24))); // {8,6}
	}

	public static int[] solution(int brown, int yellow) {
		// 간단한 수학문제
		// brown = 4 + 2a + 2b
		// yellow = a * b
		int a = 0;
		int b = 0;
		int c = a+b;
		c = (brown-4)/2;
		for (a = c-1; a >= 1; a--) {
			b = c-a;
			if((a*b) == yellow) {
				break;
			}
		}
		return new int[] {a+2,b+2};
	}

}