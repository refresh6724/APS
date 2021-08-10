public class Solution_Level_1_2016년 { // 제출일 2021-08-10 23:40

	static int[] days = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static String[] day = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

	// test
	public static void main(String[] args) {
		System.out.println(solution(5, 24)); // "TUE"
	}

	public static String solution(int a, int b) {
		// 1, 1은 FRI
		int cnt = 4;
		for (int month = 1; month < a; month++) {
			cnt += days[month];
		}
		cnt += b;
		return day[cnt % 7];
	}
}
