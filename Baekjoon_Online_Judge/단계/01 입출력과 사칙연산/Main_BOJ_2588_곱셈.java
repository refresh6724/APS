import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2588_곱셈 { // 제출일 2020-09-07 22:55

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		System.out.println(a*(b%10));
		System.out.println(a*((b%100)/10));
		System.out.println(a*(b/100));
		System.out.println(a*b);
	}

}