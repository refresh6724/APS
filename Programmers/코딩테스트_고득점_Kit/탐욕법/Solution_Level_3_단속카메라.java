import java.util.Arrays;
import java.util.Comparator;

public class Solution_Level_3_단속카메라 { // 제출일 2020-08-16 14:15

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } })); // 2
	}

	public static int solution(int[][] routes) {

		return try_and_error_1(routes);
	}

	private static int try_and_error_1(int[][] routes) {
		
		// 1. 정렬
		
		Arrays.sort(routes, new Comparator<int[]>() {			
			@Override
			public int compare(int[] o1, int[] o2) {				
				// 종료 지점 오름차순
				// 시작 지점 오름차순
				if(o1[1] == o2[1]) {
					return o1[0]-o2[0];
				} else {
					return o1[1]-o2[1];
				}			
			}
		});
		
		// 2. 앞에서부터 하나씩 카메라 삽입
		
		int camera = 0;
		int camIdx = -30001;
		
		for (int i = 0; i < routes.length; i++) {
			if(routes[i][0] > camIdx) {
				camera++;
				camIdx = routes[i][1];
			} 			
		}
		return camera;
	}

}