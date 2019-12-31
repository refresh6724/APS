import java.util.Scanner;

public class Solution_D2_1948_날짜계산기 { // 제출일 2019-12-31 23:12

	static int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 날짜 두개를 입력받아 두번째 날짜 - 첫번째 날짜 일수 계산
		
		int TC = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= TC; tc++) {
			int a =0,b=0, c=0,d=0;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			
			int days = 0;
			if(a==c) { // 월이 같은 경우
				days = d-b+1;
			}
			else { // 월이 다른 경우
				days += month[a]-b+1;
				for(int i=a+1; i<c; i++) {
					days += month[i];
				}				
				days += d;
			}
			
			System.out.printf("#%d %d\n",tc,days);
		}

	}

}
