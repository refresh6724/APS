import java.util.Scanner;

public class Main_BOJ_2442_별찍기5 { // 제출일 2020-02-09 02:01
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < n; row++) {			
			for (int col = 0; col < n<<1; col++) {
				if(col>=(n-1-row) && col <=(n-1+row)) {
					sb.append("*");
				} else if(col < (n-1-row)) {
					sb.append(" ");
				}				
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}