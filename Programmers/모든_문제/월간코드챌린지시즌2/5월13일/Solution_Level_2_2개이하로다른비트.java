import java.util.Arrays;

public class Solution_Level_2_2개이하로다른비트 { // 제출일 2021-05-15 23:06

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new long[] { 2, 7 }))); // 3, 11
		System.out.println(Arrays.toString(solution(new long[] { 0,1,2,3,4,5,6,7,8,9,10 }))); // 3, 11
	}

	public static long[] solution(long[] numbers) {

		// 예1
		// 2 0010
		// 2보다 크고 비트가 1개 다른 3 0011 이 정답

		// 예2
		// 7 0111
		// 7보다 크고 비트가 2개 다른 11 1011 이 정답

		long[] answer = new long[numbers.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = f(numbers[i]);
		}
		return answer;
	}

	/**
	 * x보다 크고 x와 비트가 1개 또는 2개 다른 수들 중에서 제일 작은 수를 리턴<br>
	 * x의 binary 길이가 n이라고 할 때 리턴값의 범위는 <br>
	 * x < x+(1<<0) <= f(x) <= x+(1<<n) 이다.
	 * 
	 * @param x 양의 정수
	 * @return
	 */
	public static long f(long x) {

		char[] s = Long.toBinaryString(x).toCharArray();
		// 뒷자리부터 0을 찾아서 1로 바꾼 값을 리턴한다
		// 0이 없다면 맨 앞에 1을 추가하고 기존 첫자리를 0으로 바꾼 값을 리턴한다
		for (int i = s.length - 1; i >= 0; i--) {
			if (s[i] == '0') {
				s[i] = '1';
				if(i != s.length-1) {
					s[i+1] = '0';
				}
				return Long.parseLong(String.copyValueOf(s), 2);
			}
		}

		s[0] = '0';
		return Long.parseLong("1" + String.copyValueOf(s), 2);
	}

}
