public class Solution_Level_1_서울에서김서방찾기 { // 제출일 2021-08-02 23:21

	// test
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "Jane", "Kim" })); // "김서방은 1에 있다"
	}

	public static String solution(String[] seoul) {
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) {
				return String.format("김서방은 %d에 있다", i);
			}
		}
		return "";
	}
}
