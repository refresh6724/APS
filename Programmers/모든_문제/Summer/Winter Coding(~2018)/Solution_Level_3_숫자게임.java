import java.util.Arrays;

public class Solution_Level_3_숫자게임 { // 제출일 2020-10-03 19:29

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 5, 1, 3, 7 }, new int[] { 2, 2, 6, 8 })); // 3
		System.out.println(solution(new int[] { 2, 2, 2, 2 }, new int[] { 1, 1, 1, 1 })); // 0
	}

	public static int solution(int[] A, int[] B) {
		// 최대 10만개 비교
		// 각 원소 최대 10억
		// B 최대 아웃풋

		// 정렬하고
		// b의 가장 큰 값이 a의 가장 큰 값보다 크다면 정답에 하나를 추가
		// 아니라면 a를 다운

		Arrays.parallelSort(A);
		Arrays.parallelSort(B);
		int n = A.length - 1;
		int a = 0;
		int b = 0;
		int ans = 0;
		for (int i = n; i >= 0 && n >= 0; i--) {
			a = A[i];
			b = B[n];
			if (b > a) {
				ans++;
				n--;
			}
		}
		return ans;
	}
}