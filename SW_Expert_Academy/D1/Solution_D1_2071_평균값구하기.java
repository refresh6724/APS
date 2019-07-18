import java.util.Scanner;

public class Solution_D1_2071_평균값구하기 { // 제출일 2019-07-18 15:25

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			//10개의 수를 입력받아 평균값 출력
			int[] arr = new int[10];
			
			int sum = 0;
			for(int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			double avg = ((double)sum/10);
			System.out.println("#"+t+" "+Math.round(avg));
			
		}
	}

}
