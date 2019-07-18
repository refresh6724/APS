import java.util.Scanner;

public class Solution_D1_2068_최대수구하기 { // 제출일 2019-07-18 15:35

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			//10 개의 수를 입력 받아 가장 큰 수 출력
			int max = 0;
			
			for(int i=0; i<10; i++) {
				int temp = sc.nextInt();
				if(temp>max) max = temp;
			}			
			
			System.out.println("#"+t+" "+max);
									
		}
	}
}
