import java.util.Scanner;

public class Solution_D0_1952_수영장_Scanner { // 제출일 2019-08-11 23:11 // 23,912 kb 187 ms

	static Scanner sc = new Scanner(System.in);
	static int T;
	static int[] months = new int[12];
	static int d1, m1, m3, y1;
	static int min;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			d1 = sc.nextInt();
			m1 = sc.nextInt();
			m3 = sc.nextInt();
			y1 = sc.nextInt();
			
			for (int i = 0; i < 12; i++) {
				months[i] = sc.nextInt();
			}	
			
			min = y1; // 1년통으로 끊는걸 기준으로
			
			
			// 1일권을 1, 1달권을 2, 3달권을 3 선택으로 하는 dfs
			dfs(0, 0);
			// 이용계획이 없다면 다음달 혹은 3달 뒤로 점프 
			// 12월을 넘으면 그냥 리턴
			
			System.out.printf("#%d %d\n",t,min);
		}
		
	}
	static void dfs(int month, int price) {
		if(month>=12) {
			if(price<min) min = price;
			return;
		}
		
		
		// 1일권 선택시
		dfs(month+1, price + months[month]*d1);
		// 1달권 선택시
		dfs(month+1, price + m1);
		// 3달권 선택시
		dfs(month+3, price + m3);
		
	}
}
