public class Solution_Level_1_최소직사각형 {

	// test
	public static void main(String[] args) {
		int[][] sizes;
		
		sizes = new int[][] {
			{60, 50}, {30, 70}, {60, 30}, {80, 40}
		};
		System.out.println(solution(sizes)); // 4000
		sizes = new int[][] {
			{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}
		};
		System.out.println(solution(sizes)); // 120
		sizes = new int[][] {
			{14, 4}, {19, 6},{ 6, 16},{ 18, 7},{ 7, 11}
		};
		System.out.println(solution(sizes)); // 133
	}


	public static int solution(int[][] sizes) {
        int lmax = 0;
        int rmax = 0;
        
        for(int[] size : sizes) {
        	if(size[0] < size[1]) {
        		lmax = Math.max(lmax, size[1]);
        		rmax = Math.max(rmax, size[0]);
        	} else {
        		lmax = Math.max(lmax, size[0]);
        		rmax = Math.max(rmax, size[1]);
        	}
        }
        
        return lmax*rmax;
    }

}
