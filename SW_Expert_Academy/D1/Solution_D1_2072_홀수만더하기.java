import java.util.Scanner;

public class Solution_D1_2072_홀수만더하기 {// 제출일 2019-07-18 15:19

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			//10개의 수를 입력받아 홀수만 더한값을 출력
			int[] arr = new int[10];
			
			int sum = 0;
			for(int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
				if(arr[i]%2 != 0) {
					sum += arr[i];
				}
			}
			System.out.println("#"+t+" "+sum);
			
		}
	}

}
