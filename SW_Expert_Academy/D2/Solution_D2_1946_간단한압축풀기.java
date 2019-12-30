import java.util.Scanner;

public class Solution_D2_1946_간단한압축풀기 { 제출일 2019-12-30 22:13

	public static void main(String[] args) {
		// 
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t=1; t<=T; t++) {
		
			System.out.printf("#%d\n", t);
			
			int N = scan.nextInt(); // 순서쌍의 개수
			char c = null;
			int n = 0;
			int width = 0;
			
			for(int i=0; i<N; i++) {
				c = scan.next().charAt(0);
				n = scan.nextInt();
				while(n-->0) {
					if(width==10) {
						System.out.printf("\n");
						width = 0;
					}
					System.out.printf("%c",c);
					width++;
				}
			}
			System.out.printf("\n");			
		}			
	}
}
