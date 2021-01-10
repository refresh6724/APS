import java.util.Scanner;

public class Main_JO_138_형성평가9 { // 제출일 2021-01-10 23:20

	public static void main(String[] args) throws Exception {

		// 4
		// (1, 1) (1, 2) (1, 3) (1, 4)
		// (2, 1) (2, 2) (2, 3) (2, 4)
		// (3, 1) (3, 2) (3, 3) (3, 4)
		// (4, 1) (4, 2) (4, 3) (4, 4)

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= a; i++) {
			sb.append('(').append(i).append(", 1)");
			for (int j = 2; j <= a; j++) {
				sb.append(' ').append('(').append(i).append(", ").append(j).append(')');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}