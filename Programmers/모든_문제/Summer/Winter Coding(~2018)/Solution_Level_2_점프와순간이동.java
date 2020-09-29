public class Solution_Level_2_점프와순간이동 { // 제출일 2020-09-29 21:08

	// test
	public static void main(String[] args) {
		System.out.println(solution(5)); // 2
		System.out.println(solution(6)); // 2
		System.out.println(solution(5000)); // 5
	}

	public static int solution(int n) {
		// 한번에 k 칸 점프 또는 지금까지 온 거리 * 2의 위치로 순간이동
		// 점프는 건전지를 1회 사용, 순간이동은 건전지 사용 x
		// n 위치로 이동할 때 건전지 사용량의 최솟값을 구하라

		// 예1
		// 0=>5 사용량 5
		// 0=>1 사용량 1 1=>2=>4, 4=>5 사용량 1 총 2

		// 예2
		// 0=>1=>2=>3=>6

		// 예3
		// 5000 => 2500 => 1250 => 625 =1> 624 => 312 => 156 => 78 => 39 =1> 38 => 19
		// =1> 18=> 9 =1> 8 => 1 =1> 0

		int k = 0;
		while (n != 0) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n--;
				k++;
			}
		}
		return k;
	}
}