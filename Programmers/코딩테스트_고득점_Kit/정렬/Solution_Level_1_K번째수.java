import java.util.ArrayList;
import java.util.Arrays;

public class Solution_Level_1_K번째수 { // 제출일 2020-08-20 21:05

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1, 5, 2, 6, 3, 7, 4},new int[][] {{2,5,3},{4,4,1},{1,7,3}}))); // {5,6,3}
	}

	public static int[] solution(int[] array, int[][] commands) {

		ArrayList<Integer> ret = new ArrayList<>();
		int[] arr;
		for (int i = 0; i < commands.length; i++) {
			arr = array.clone();
			Arrays.parallelSort(arr, commands[i][0] - 1, commands[i][1]);
			ret.add(arr[commands[i][0] + commands[i][2] - 2]);
		}
		return ret.stream().mapToInt(x -> x).toArray();
	}

}