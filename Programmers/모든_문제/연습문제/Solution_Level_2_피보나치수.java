public class Solution_Level_2_피보나치수 { // 제출일 2021-08-13 23:29

	static int[] fiv;

	static void fivo() {
		fiv = new int[100001];
		fiv[0] = 0;
		fiv[1] = 1;
		for (int i = 2; i < 100001; i++) {
			fiv[i] = (fiv[i - 1] + fiv[i - 2]) % 1234567;
		}
	}

	public static void main() {
		System.out.println(solution(3)); // 2
		System.out.println(solution(5)); // 5
	}

	public static int solution(int n) {
		fivo();
		return fiv[n];
	}
}
