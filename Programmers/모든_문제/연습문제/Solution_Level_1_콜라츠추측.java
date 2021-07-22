public class Solution_Level_1_콜라츠추측 { // 제출일 2021-07-22 23:03

	// test
	public static void main(String[] args) {
		System.out.println(solution(6)); // 8
		System.out.println(solution(16)); // 4
		System.out.println(solution(626331)); // -1

	}

	public static int solution(int num) {
		int answer = 0;
		long n = num;
		while (answer < 500 && n != 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n *= 3;
				n += 1;
			}
			answer++;
		}
		return (answer == 500) ? -1 : answer;
	}
}
