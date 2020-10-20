public class Solution_Level_1_3진법뒤집기 { // 제출일 2020-10-20 19:47

	// test
	public static void main(String[] args) {
		System.out.println(solution(45)); // 7
		System.out.println(solution(125)); // 229
	}

	public static int solution(int n) {
		return threetoten(tentothree(n));
	}

	private static int threetoten(String tentothree) {
		int ret = 0;
		for (int i = 0; i < tentothree.length(); i++) {
			ret *= 3;
			ret += (tentothree.charAt(i) - '0');
		}
		return ret;
	}

	private static String tentothree(int n) {		
		StringBuilder sb = new StringBuilder();
		int mok = n;
		int nam = 0;
		while(mok != 0) {
			nam = mok%3;
			mok = mok/3;
			sb.append(nam);
		}
		return sb.toString();
	}

}