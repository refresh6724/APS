import java.util.Scanner;

public class Solution_D3_1215_회문1 { // 제출일 2019-07-19 18:48

	static int Answer = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			Answer = 0;
			
			int len = Integer.parseInt(sc.nextLine());
			char[][] map = new char[8][8];
			for(int i=0; i<8; i++) {
				String[] str = new String[8];
				str[i] = sc.nextLine();
				for(int j=0; j<8; j++) {
					map[i][j] = str[i].charAt(j);
				}
			}
			
			// 행 검색
			for(int i=0; i<8; i++) {
				nextRow:
				for(int j=0; j<8; j++) {
					if(j+len>8) break;					
					for(int l=0; l<len/2; l++) {
						if(map[i][j+l] != map[i][j+len-1-l]) continue nextRow;						
					}
					Answer++;
				}
			}
			// 열 검색
			for(int j=0; j<8; j++) {
				nextCol: 
				for (int i = 0; i < 8; i++) {
					if (i + len > 8) break;
					for (int l = 0; l < len / 2; l++) {
						if (map[i+l][j] != map[i+len-1-l][j]) continue nextCol;
					}
					Answer++;
				}
			}
			
			System.out.println("#"+t+" "+Answer);
		}
	}

}
