import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_Level_3_N으로표현 { // 제출일 2020-08-28 23:20	테스트 4 〉	통과 (35.21ms, 45.7MB)

	// test
	public static void main(String[] args) {
		System.out.println(solution(5, 12)); // 4
		System.out.println(solution(2, 11)); // 3
	}

	public static int solution(int N, int number) {
		// N : 1~9
		// n : 1~32000
		// 나머지 연산 int / int
		// 최솟값이 8보다 크면 -1

		List<Set<Integer>> numbers = new ArrayList<>(9);
		for (int i = 0; i < 9; i++) {
			numbers.add(new HashSet<Integer>());
		}

		numbers.get(1).add(N * 1);
		numbers.get(2).add(N * 11);
		numbers.get(3).add(N * 111);
		numbers.get(4).add(N * 1111);
		numbers.get(5).add(N * 11111);
		numbers.get(6).add(N * 111111);
		numbers.get(7).add(N * 1111111);
		numbers.get(8).add(N * 11111111);

		// N 1개로 이루어진 숫자들로 2개를 만든다
		// N 1개와 2개로 3개를 만든다 ... 
		for (int sum = 2; sum < 9; sum++) {
			for (int left = 1, right = sum - left; left <= right; left++, right--) {
				for (int a : numbers.get(left)) {
					for (int b : numbers.get(right)) {
						numbers.get(sum).add(a + b);
						numbers.get(sum).add(a - b);
						numbers.get(sum).add(b - a);
						numbers.get(sum).add(a * b);
						if (a != 0) {
							numbers.get(sum).add(b / a);
						}
						if (b != 0) {
							numbers.get(sum).add(a / b);
						}
					}
				}
			}
		}

		for (int i = 1; i < 9; i++) {
			for (int find : numbers.get(i)) {
				if (number == find) {
					return i;
				}
			}
		}
		return -1;

	}

}