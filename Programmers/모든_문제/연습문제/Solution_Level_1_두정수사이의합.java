public class Solution_Level_1_두정수사이의합 { // 제출일 2021-08-06 23:45

	public long solution(int a, int b) {
		// 수학식
		// 첫수와 끝수를 합하고 전체 길이를 곱한 뒤 2로 나눈다
		int min, max;
		if (a < b) {
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}
		return (long) (max + min) * (max - min + 1) / 2;

	}
}
