import java.util.Scanner;

public class Main_BOJ_2445_별찍기8 { // 제출일 2020-02-15 23:09
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = n<<1;
				
		
		String[] s = new String[max];
		
		for (int row = 1; row <= n;row++) {
			StringBuilder sb = new StringBuilder();
			for (int col = 1; col < max+1; col++) {
				if(row>=col || max-row < col) {
					sb.append("*");				
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
			s[row] = sb.toString();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n ; i++) {
			sb.append(s[i]);
		}
		for (int i = n-1; i >= 1; i--) {
			sb.append(s[i]);
		}
		System.out.println(sb.toString());
		
	}
}