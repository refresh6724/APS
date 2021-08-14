import java.util.*;

public class Solution_Level_2_최솟값만들기 { // 제출일 2021-08-14 23:33
	
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int len = A.length;
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += A[i] * B[len - 1 - i];
		}
		return sum;
	}
}