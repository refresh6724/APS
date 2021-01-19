import java.util.Scanner;

public class Main_JO_160_형성평가1 { // 제출일 2021-01-19 23:24

	public static void main(String[] args) {

		// 승지는 주사위 놀이를 하다가
		// 주사위를 10번 던져서 각 숫자가 몇 번씩 나왔는지 알아보려고 한다.
		// 한번 던질 때마다 나온 주사위의 숫자를 입력받아서
		// 각 숫자가 몇 번씩 나왔는지 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int[] dice = new int[7];
		for (int i = 0; i < 10; i++) {
			dice[sc.nextInt()]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 7; i++) {
			sb.append(String.format("%d : %d\n", i, dice[i]));
		}
		System.out.println(sb.toString());

	}

}