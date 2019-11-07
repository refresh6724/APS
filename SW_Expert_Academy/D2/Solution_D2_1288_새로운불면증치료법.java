import java.util.HashSet;
import java.util.Scanner;

public class Solution_D2_1288_새로운불면증치료법 { // 제출일 2019-11-07 19:26 
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			HashSet<Character> set = new HashSet<>();
			set.add('0');
			set.add('1');
			set.add('2');
			set.add('3');
			set.add('4');
			set.add('5');
			set.add('6');
			set.add('7');
			set.add('8');
			set.add('9');
			int N = sc.nextInt();
			int k = 0;
			while (!set.isEmpty()) {
				char[] kN = Integer.toString(++k * N).toCharArray();
				for (int i = 0; i < kN.length; i++) {
					set.remove(kN[i]);
				}
			}
			System.out.printf("#%d %d\n", t, k*N);
		}
	}
}