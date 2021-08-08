import java.util.ArrayList;
import java.util.Arrays;

public class Solution_Level_1_같은숫자는싫어 { // 제출일 2021-08-08 23:07

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 1, 3, 3, 0, 1, 1 }))); // 1, 3, 0, 1
	}

	public static int[] solution(int[] arr) {
		ArrayList<Integer> li = new ArrayList<>();
		li.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				li.add(arr[i]);
			}
		}
		return li.stream().mapToInt(x -> x).toArray();
	}
}
