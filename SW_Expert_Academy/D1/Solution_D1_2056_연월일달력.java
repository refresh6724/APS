import java.util.Scanner;

public class Solution_D1_2056_연월일달력 { // 제출일 2019-08-01 12:38

	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		String[] strs = new String[T+1];
		int[] arr = new int[T+1];
		for (int i = 1; i <= T; i++) {
			strs[i] = sc.next();
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		for (int t = 1; t <=T; t++) {
			// 연월일을 모두 통과하고 sb에 삽입
			StringBuilder sb2 = new StringBuilder();
			boolean isValid = false;
			int year = arr[t]/10000;
			int month = arr[t]%10000/100;
			int day = arr[t]%100;
			while(arr[t]!=0) {
				if(month == 0 || month>12) break;
				if(month == 2) {
					if(day>28) break;								
				} else if(month == 4 || month == 6 || month == 9 || month == 11) {
					if(day>30) break;								
				} else {
					if(day>31) break;								
				}	
				isValid = true;		
				sb2.append(strs[t]);
				sb2.insert(4, '/').insert(7, '/');
				break;
			}
			
			if(!isValid) sb2.append("-1");
			sb.append("#").append(t).append(" ").append(sb2).append("\n");
		}
		System.out.println(sb);
	}

}
