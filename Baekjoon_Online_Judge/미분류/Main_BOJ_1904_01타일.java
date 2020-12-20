import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1904_01타일 { // 제출일 2020-12-20 23:03 // boj jyeokchoi님의 아이디어 : 배열을 저장하지 않고 값 2개만 반복해서 정답을 출력

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 피보나치 수 n번째 수를 15746으로 나눈 나머지
		int n = Integer.parseInt(br.readLine());
		int[] fib = new int[n + 1];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = (fib[i - 1] + fib[i - 2]) % 15746;
		}
		System.out.println(fib[n]);
	}
}
