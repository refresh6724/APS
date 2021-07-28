import java.util.Arrays;

public class Solution_Level_1_자연수뒤집어배열로만들기 { // 제출일 2021-07-28 23:44

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(12345)));
	}

	public static int[] solution(long n) {
		char[] arr = Long.toString(n).toCharArray();
		int[] ret = new int[arr.length];
		for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
			ret[i] = arr[j] - '0';
		}
		return ret;
		// return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray()
	}
}
