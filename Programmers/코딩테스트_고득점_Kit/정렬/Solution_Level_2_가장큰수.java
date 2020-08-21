import java.util.Arrays;
import java.util.Comparator;

public class Solution_Level_2_가장큰수 { // 제출일 2020-08-21 22:22 

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 6, 10, 2 })); // 6210
		System.out.println(solution(new int[] { 3, 30, 34, 5, 9 })); // 9534330
		System.out.println(solution(new int[] { 0, 0, 0, 0 })); // 0
		System.out.println(solution(new int[] { 40, 403 })); //  40403 > 40340
		System.out.println(solution(new int[] { 41, 415 })); //  41541 > 41415	
	}

	public static String solution(int[] numbers) {

		// numbers 길이는 10만 이하
		// 각 원소 크기는 0 이상 1천 이하

		// 정렬 순서는
		// 9 99 98 97 ...
		// 89 8 88 87 ...
		// ...
		// 45 4 44 43 ...
		// 34 3 33 32 ...
		// 23 2 22 21 ...
		// 12 1 11 10 ...
		
		boolean allZero = true;
		for(int i : numbers) {
			if(i != 0) {
				allZero = false;
				break;
			}
		}
		if(allZero) {
			return "0";
		}

		int[] arrDesc = Arrays.stream(numbers).boxed().sorted(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// return o2-o1; // 단순 내림차순
				// 각 원소는 최대 1천
				// 1000은 0을 제외하고 가장 마지막 순위이다.
				if (o1 < 10) {
					o1 = o1 * 1111;
				} else if (o1 < 100) { // 19라면 1919
					o1 = o1 * 100 + o1;
				} else if (o1 < 1000) { // 415 면 4154
					o1 = o1 * 10 + (o1 / 100);
				}

				if (o2 < 10) {
					o2 = o2 * 1111;
				} else if (o2 < 100) {
					o2 = o2 * 100 + o2;
				} else if (o2 < 1000) {
					o2 = o2 * 10 + (o2 / 100);
				}

				// 자릿수를 둘다 4자리로 맞춰주고 내림차순 정렬
				return o2 - o1;
			}
		}).mapToInt(Integer::intValue).toArray();

		StringBuilder sb = new StringBuilder();
		for (int i : arrDesc) {
			sb.append(i);
		}
		return sb.toString();
	}

}