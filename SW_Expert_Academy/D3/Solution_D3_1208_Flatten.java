import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_Flatten { // 제출일 2019-07-18 18:15

	static int[] arr = new int[100]; // 가로길이 100
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 평탄화 = 가장 높은곳과 낮은곳 차이가 1 또는 0
		// 작업횟수에 제한
		// 
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {			
			// 덤프 횟수
			int dump = sc.nextInt();
			// arr 초기화 
			for(int i=0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
			// 정렬
			Arrays.sort(arr);
			int height = -1;
			// 평탄화
			for(int j=0; j<dump; j++) {
				// 평탄화
				arr[99]--;
				arr[0]++;
				int temp=0;
				// 앞부분 바꾸기
				int start=0;
				while(arr[start]>arr[start+1]) {
					temp = arr[start];
					arr[start] = arr[start+1];
					arr[start+1] = temp;
					start++;
				}
				// 뒷부분 바꾸기
				int end = 99;
				while(arr[end-1]>arr[end]) {
					temp = arr[end-1];
					arr[end-1] = arr[end];
					arr[end] = temp;
					end--;
				}
			} // dump end
			height = arr[99] - arr[0];			
			
			//#t highest - lowest
			System.out.println("#"+t+" "+height);
		}	
	}
}
