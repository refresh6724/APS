import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_515_자가진단7 { // 제출일 2020-12-31 22:30

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(String.format("%d * %d = %d", a,b,a*b));
		System.out.println(String.format("%d / %d = %d", a,b,a/b));
	}
}