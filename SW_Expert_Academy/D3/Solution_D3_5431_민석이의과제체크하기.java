import java.util.Scanner;

public class Solution_D3_5431_민석이의과제체크하기 { // 제출일 2019-07-18 17:34

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수
		int T = sc.nextInt(); // 2
		for(int t=1; t<=T; t++) {
			// 전체 수강생 수
			int student = sc.nextInt(); // 5 명
			// 과제를 제출한 수강생 수
			int OK = sc.nextInt(); // 3 명
			// 제출 여부
			boolean[] report = new boolean[student];
			for(int i=0; i<student; i++) {
				report[i] = false; // 지역변수 수동 초기화				
			}
			for(int i=0; i<OK; i++) {				
				int temp = sc.nextInt(); // 2 5 3
				report[temp-1] = true;
			}			
			System.out.print("#"+t);
			for(int i=1; i<=student; i++) {
				if(report[i-1] == false) {
					System.out.print(" "+i);
				}			
			}
			System.out.println();
		}		
	}
}
