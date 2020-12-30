import java.util.Scanner;

public class Main_JO_110_형성평가5 { // 제출일 2020-12-30 23:37

	public static void main(String[] args) {
		System.out.print("yard? ");
		Scanner sc = new Scanner(System.in);
		double b = Double.parseDouble(sc.nextLine());
		System.out.print(b);
		System.out.println(String.format("yard = %.1fcm", b * 91.44));
	}
}