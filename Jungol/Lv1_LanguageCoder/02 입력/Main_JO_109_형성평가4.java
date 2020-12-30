import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_109_형성평가4 { // 제출일 2020-12-30 23:26

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int sum = a + b + c;
		System.out.println(String.format("sum = %d", sum));
		System.out.println(String.format("avg = %d", (int) (sum / 3)));
	}
}