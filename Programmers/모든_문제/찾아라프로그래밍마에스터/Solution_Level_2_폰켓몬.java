import java.util.HashSet;
import java.util.Set;

public class Solution_Level_2_폰켓몬 { // 제출일 2020-09-13 23:06

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 1, 2, 3 })); // 2
		System.out.println(solution(new int[] { 3, 3, 3, 2, 2, 4 })); // 3
		System.out.println(solution(new int[] { 3, 3, 3, 2, 2, 2 })); // 2
	}

	public static int solution(int[] nums) {
		// N마리 중 절반
		// 최대한 다른 종류를 선택하면 몇 종류인가
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		int max = nums.length / 2;

		return (max > set.size()) ? set.size() : max;
	}

}