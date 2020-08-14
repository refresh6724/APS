import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution_Level_2_구명보트 { // 제출일 2020-08-14 13:53

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 70, 50, 80, 50 }, 100)); // 3
		System.out.println(solution(new int[] { 70, 80, 50 }, 100)); // 3
	}

	public static int solution(int[] people, int limit) {
		// 보트 하나에 최대 2명
		// 사람수 최대 5만
		// 무게 최소 40 최대 240
		// 보트 무게 제한 40 ~ 240

		return try_and_error_1(people, limit);
	}

	private static int try_and_error_1(int[] people, int limit) {
		Arrays.parallelSort(people);
		int ret = 0;

		// 무거운거부터 넣고 작은걸 넣을 수 있으면 넣고 안되면 넘어가고
		int left = 0;
		int right = people.length - 1;

		while (left <= right) {
			ret++;
			if (people[right] + people[left] <= limit) {
				right--;
				left++;
			} else {
				right--;
			}
		}

		return ret;
	}

}