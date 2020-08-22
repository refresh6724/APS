import java.util.Arrays;
import java.util.Comparator;

public class Solution_Level_2_H_Index { // 제출일 2020-08-22 22:59

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 0, 6, 1, 5 })); // 3
		System.out.println(solution(new int[] { 31, 66 })); // 2
		System.out.println(solution(new int[] { 4, 4, 4 })); // 3
		System.out.println(solution(new int[] { 1, 8, 9, 10, 11, 12 })); // 5
	}

	public static int solution(int[] citations) {
		// 논문 n편 중 h번 이상 인용된 논문이 h편 이상이고 나머지가 h번 이하로 인용되었다면 h의 최댓값이 H-Index이다.
		// citations의 길이는 1000 이하, 각 인용 횟수는 1만 이하
		// citations가 전부 0일 경우에만 h = 0
		
		// 1 8 9 10 11 12 
		// 6 5 4 3  2  1
		// 길이와 값 중 작은 값을 골라 그 최댓값을 리턴한다		

		Arrays.parallelSort(citations);
		int h = 0;
		boolean allZero = true;
		for (int i = citations.length - 1, j = 1; i >= 0; i--, j++) {
			if (citations[i] != 0) {
				allZero = false;
			}
			if (citations[i] <= j) { // j == citations.length-i // 끝에서부터 길이
				h = Math.max(citations[i], h);
				break;
			} else {
				h = Math.max(h, j);
			}
		}
		if (allZero) {
			return 0;
		}

		return h;

	}

}