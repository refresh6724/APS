import java.util.Scanner;

public class Solution_D4_1210_Ladder1 { // 제출일 2019-07-24 17:14
	public static int Answer;
	public static int[][] radder;
	public static int X;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			int t = sc.nextInt();
			Answer = 0;
			X = 0;
			radder = new int[100][100];
			for(int row = 0; row<100; row++) {
				for (int col=0; col<100; col++) {
					radder[row][col] = sc.nextInt();
					if(radder[row][col] == 2) X = col;
				}
			}
			
			// 2에서 출발
			// 2에 해당하는 열 찾기 X
			// 99,X 에서 출발
			// row = 0 이면 그 때 col을 반환
			// 만약 좌우에 1이 있다면 그 길로 빠진다
			// 없다면 위로 한칸 올라간다
			
			for(int row=99; row>=0; row--) {
				if(row==0) break;
				// 길이 왼쪽으로 있다면
				if(X-1>=0 && radder[row][X-1] == 1) {
					while(X-1>=0 && radder[row][X-1] == 1) {
						--X;
					}
					continue;
				}				
				// 길이 오른쪽으로 있다면
				while(X+1<100 && radder[row][X+1] == 1) {
					++X;								
				}
			}
			Answer = X;			
			
			System.out.println("#"+t+" "+Answer);
		} // test case 10 end	
	} // main end
} // solution end