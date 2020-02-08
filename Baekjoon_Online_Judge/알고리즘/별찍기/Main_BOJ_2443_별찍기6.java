import java.util.Scanner;

public class Main_BOJ_2443_별찍기6 { // 제출일 2020-02-09 02:05
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int row = n-1; row >= 0; row--) {			
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