import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution_D1_2025_N줄덧셈 { // 제출일 2019-11-07 17:07 
	static int sum = 0;
	public static void main(String[] args) { // 1부터 주어진 숫자만큼 더하기		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		IntStream.range(0, N + 1).forEach((value) -> {sum += value;});
		System.out.println(sum);
	}
}
