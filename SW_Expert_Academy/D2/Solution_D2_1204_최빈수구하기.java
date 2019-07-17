import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기 { // 제출일 2019-07-17 18:14

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t=1; t<=T; t++) {
			int testNum = scan.nextInt();
			int[] scores = new int[101]; // 0이상 100이하 배열 
			for(int i=0; i<1000; i++) {
				int score = scan.nextInt();
				scores[score]++;
			}			
			int nums = 0;
			int most = 0;
			for(int score=0; score<100; score++) {
				// 해당 점수에 대한 사람수가 기존에 가장 많았던 사람수 보다 많으면 바꾼다
				if(scores[score] >= nums) { // 사람수가 같으면 점수가 높은걸로
					nums = scores[score];
					most = score;
				}
			}			
			System.out.printf("#%d %d\n", t, most);
		}
			
	}

}
