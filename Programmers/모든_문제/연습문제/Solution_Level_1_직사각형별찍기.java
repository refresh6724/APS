import java.util.Scanner;

public class Solution_Level_1_직사각형별찍기 { // 제출일 2021-07-20 20:57 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
