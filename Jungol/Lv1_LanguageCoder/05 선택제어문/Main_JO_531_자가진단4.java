import java.util.Scanner;

public class Main_JO_531_자가진단4 { // 제출일 2021-01-06 23:12

	public static void main(String[] args) {

		// 복싱체급은 몸무게가
		// 50.80kg 이하를 Flyweight,
		// 61.23kg 이하를 Lightweight,
		// 72.57kg 이하를 Middleweight,
		// 88.45kg 이하를 Cruiserweight,
		// 88.45kg 초과를 Heavyweight

		Scanner scan = new Scanner(System.in);
		double w = scan.nextDouble();

		if (w <= 50.80) {
			System.out.println("Flyweight");
		} else if (w <= 61.23) {
			System.out.println("Lightweight");
		} else if (w <= 72.57) {
			System.out.println("Middleweight");
		} else if (w <= 88.45) {
			System.out.println("Cruiserweight");
		} else {
			System.out.println("Heavyweight");
		}
	}
}