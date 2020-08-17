import java.util.ArrayList;
import java.util.Arrays;

public class Solution_Level_1_모의고사 { // 제출일 2020-08-17 17:21

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 4, 5 }))); // {1}
		System.out.println(Arrays.toString(solution(new int[] { 1, 3, 2, 4, 2 }))); // {1,2,3}
	}

	public static int[] solution(int[] answers) {

		// answer 최대 길이 1만
		// 1번은 12345를 반복, 길이 5
		// 2번은 21232425를 반복, 길이 8
		// 3번은 3311224455를 반복, 길이 10
		
		// 최소공배수 40
		// 1234512345123451234512345123451234512345
		// 2123242521232425212324252123242521232425
		// 3311224455331122445533112244553311224455
		
		int[] a = new int[] {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
		int[] b = new int[] {2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5};
		int[] c = new int[] {3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5};
		
		int idx = 0;
		int s1 = 0;
		int s2 = 0;
		int s3 = 0;
		for (int i = 0; i < answers.length; i++) {
			idx = i % 40;
			if (answers[i] == a[idx]) {
				s1++;
			}
			if (answers[i] == b[idx]) {
				s2++;
			}
			if (answers[i] == c[idx]) {
				s3++;
			}
		}

		int max = Math.max(s1, s2);
		max = Math.max(max, s3);

		ArrayList<Integer> li = new ArrayList<>();
		if (max == s1) {
			li.add(1);
		}
		if (max == s2) {
			li.add(2);
		}
		if (max == s3) {
			li.add(3);
		}
		return li.stream().mapToInt(x -> x).toArray();		
	}
}