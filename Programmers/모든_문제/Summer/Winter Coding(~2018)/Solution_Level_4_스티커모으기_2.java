public class Solution_Level_4_스티커모으기_2 { // 제출일 2020-10-06 19:43

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 14, 6, 5, 11, 3, 9, 2, 10 }));// 36
		System.out.println(solution(new int[] { 1, 3, 2, 5, 4 }));// 8
		System.out.println(solution(new int[] { 1 }));// 1
		System.out.println(solution(new int[] { 1, 2 }));// 2
		System.out.println(solution(new int[] { 1, 2, 3 }));// 3
		System.out.println(solution(new int[] { 1, 0, 0, 1 }));// 1
		System.out.println(solution(new int[] { 1, 0, 0, 1, 1 }));// 2
		System.out.println(solution(new int[] { 1, 0, 0, 1, 0 }));// 2
		System.out.println(solution(new int[] { 1, 0, 0, 1 }));// 1
		System.out.println(solution(new int[] { 0, 1, 0, 0, 1 }));// 2
	}

	public static int solution(int[] sticker) {

		// 단순 1차원 dp 문제
		// 첫글자를 사용할 경우 마지막 글자를 사용할 수 없다
		// 첫글자를 제외하고 두번째부터 마지막 글자까지 두번 반복 따라서 2n

		int n = sticker.length;
		if (n == 1) {
			return sticker[0];
		} else if (n == 2) {
			return Math.max(sticker[0], sticker[1]);
		} else if (n == 3) {
			return Math.max(sticker[0], Math.max(sticker[1], sticker[2]));
		} else if (n == 4) {
			return Math.max(sticker[0] + sticker[2], sticker[1] + sticker[3]);
		}

		int[] memoO = new int[n];
		int[] memoX = new int[n];
		memoO[0] = sticker[0];
		memoX[0] = 0;
		memoO[1] = memoX[0] + sticker[1];
		memoX[1] = memoO[0];
		memoO[2] = memoX[1] + sticker[2];
		memoX[2] = memoO[1];
		for (int i = 3; i < n - 1; i++) {
			memoO[i] = Math.max(memoO[i - 3], memoX[i - 1]) + sticker[i];
			memoX[i] = memoO[i - 1];
		}

		int max = Math.max(memoO[n - 2], memoX[n - 2]);

		memoO = new int[n];
		memoX = new int[n];
		memoO[1] = sticker[1];
		memoX[1] = 0;
		memoO[2] = memoX[1] + sticker[2];
		memoX[2] = memoO[1];
		memoO[3] = memoX[2] + sticker[3];
		memoX[3] = memoO[2];
		for (int i = 4; i < n; i++) {
			memoO[i] = Math.max(memoO[i - 3], memoX[i - 1]) + sticker[i];
			memoX[i] = memoO[i - 1];
		}

		max = Math.max(max, Math.max(memoO[n - 1], memoX[n - 1]));

		return max;
	}

}