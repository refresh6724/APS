public class Solution_Level_3_멀리뛰기 {

	// test
	public static void main(String[] args) {
		System.out.println(solution(1)); // 1
		System.out.println(solution(2)); // 2
		System.out.println(solution(3)); // 3
		System.out.println(solution(4)); // 5
	}
	
	static final int MOD = 1234567;

	public static long solution(int n) {
        int[] num = new int[n+1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i < num.length; i++) {
			num[i] = num[i-1] + num[i-2];
			num[i] %= MOD;
		}
        return num[n];
    }
}