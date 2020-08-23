import java.util.Arrays;
import java.util.Comparator;

public class Solution_Level_3_입국심사 { // 제출일 2020-08-23 23:03

	// test
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] { 7, 10 })); // 28
		System.out.println(solution(6, new int[] { 1000000000, 1000000000 })); // 28
	}

	public static long solution(int n, int[] times) {
		// n 명이 기다리고 있다
		// 기다리는 사람은 10억 이하
		// 심사관은 times 길이만큼 최대 10만 명
		// 각 심사에 걸리는 시간은 10억 이하
		// 모든 사람이 심사를 받을때 걸리는 최솟 시간은?

		Arrays.parallelSort(times);
		long start = 0;
		long end = (long) n * times[times.length - 1]; // 사람들이 가장 많이 오래걸리는 곳에 설 때
		long sum = 0;
		long mid = 0;

		while (start <= end) {
			sum = 0;
			mid = (start + end) / 2;
			for (int i = 0; i < times.length; i++) {
				sum += mid / times[i];
			}
			if (sum >= n) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return end + 1;

	}

}