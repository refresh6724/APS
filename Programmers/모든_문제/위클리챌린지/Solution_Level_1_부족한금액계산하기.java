public class Solution_Level_1_부족한금액계산하기 { // 제출일 2021-08-04 23:19

	// test
	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4)); // 10
		System.out.println(solution(3, 20, 3)); // 0
	}

	/**
	 * 
	 * @param price 1 이상 2500 이하
	 * @param money 1 이상 10억 이하
	 * @param count 1 이상 2500 이하
	 * @return count번 이용 금액 - money 리턴. 단, 금액이 남으면 0 리턴
	 */
	public static long solution(int price, int money, int count) {
		long answer = (long) price * (count * (count + 1)) / 2;
		answer -= money;
		return (answer >= 0) ? answer : 0;
	}
}
