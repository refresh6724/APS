import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_Level_1_두개뽑아서더하기 { // 제출일 2020-09-18 23:06

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {2,1,3,4,1 }))); // [2,3,4,5,6,7]
		System.out.println(Arrays.toString(solution(new int[] {5,0,2,7 }))); // [2,5,7,9,12]
	}

	public static int[] solution(int[] numbers) {

		// 서로 다른 인덱스의 수 2개를 뽑아 만들 수 있는 모든 수를 오름차순으로 리턴
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if(i!=j) {
					set.add(numbers[i]+numbers[j]);
				}
			}
		}
		int[] ret = set.stream().mapToInt(x->x).toArray();
		Arrays.parallelSort(ret);
		return ret;		
		
	}

}