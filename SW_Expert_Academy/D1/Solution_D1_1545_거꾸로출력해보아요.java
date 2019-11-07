import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution_D1_1545_거꾸로출력해보아요 { // 제출일 2019-11-07 15:46 
	public static void main(String[] args) {
		// 주어진 숫자부터 거꾸로 0까지
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		IntStream.range(-N, 1).forEach((value) -> {
			System.out.printf("%d ", -value);
		}); // 주의) 반복문에 비해 느리고 무거워 코드길이, 메모리 사용량, 실행시간 기준 꼴찌를 기록하였다
	}
}
