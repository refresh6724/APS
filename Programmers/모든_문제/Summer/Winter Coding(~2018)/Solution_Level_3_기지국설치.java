public class Solution_Level_3_기지국설치 { // 제출일 2020-10-02 23:29

	// test
	public static void main(String[] args) {
		System.out.println(solution(11, new int[] {4,11}, 1)); // 3
		System.out.println(solution(16, new int[] {9}, 2)); // 3
	}

	public static int solution(int n, int[] stations, int w) {
		
		// n : 2억 이하
		// stations : 이미 설치된 장소는 1만곳 이하, 오름차순 정렬
		// w : 각 범위는 1만 이하
		
		// 예1
		// 1,2,3-4-5,6,7,8,9,10-11 
		// 커버를 위해 2, 7, 9 설치
		
		// 1만곳 x 좌우(2곳)
		int pl, pr, nl, nr, len, cover, ans;
		pl = pr = nl = nr = len = ans = 0;
		cover = (w<<1) + 1;
		pr = 1;
				
		for(int station : stations) {
			nl = station - w;
			nr = station + w;
			
			if(pr < nl) {
				len = nl - pr;
				ans += (len/cover) + ((len%cover==0)?0:1);				
			} 
			
			pl = nl;
			pr = nr+1;
		}
		
		if(pr <= n) {
			len = n - nr;
			ans += (len/cover) + ((len%cover==0)?0:1);
		}
		
		return ans;
	}
}