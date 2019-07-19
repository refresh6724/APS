import java.util.Scanner;

public class Solution_D3_8016_홀수피라미드 { // 제출일 2019-07-19 09:03

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t<=T; t++) {
			long floor = sc.nextLong();
			long N = 2*(floor-1)*(floor-1)+1;
			long K = 2*floor*floor-1;
			System.out.println("#"+t+" "+N+" "+K);
		}
	}

}
