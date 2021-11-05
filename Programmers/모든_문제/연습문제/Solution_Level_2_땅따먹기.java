public class Solution_Level_2_땅따먹기 { // 제출일 2021-11-05 23:49

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } }));
	}

	public static int solution(int[][] land) {
		
		// 최대 행 100,000 열은 4열 고정
		// dp
		for (int i = 0; i < land.length-1; i++) {
			int a01 = Math.max(land[i][0], land[i][1]);
			int a02 = Math.max(land[i][0], land[i][2]);
			int a12 = Math.max(land[i][1], land[i][2]);
			int a13 = Math.max(land[i][1], land[i][3]);
			int a23 = Math.max(land[i][2], land[i][3]);
			land[i+1][0] += Math.max(a12, a23);
			land[i+1][1] += Math.max(a02, a23);
			land[i+1][2] += Math.max(a01, a13);
			land[i+1][3] += Math.max(a01, a12);
		}
		int max = 0;
		for (int j = 0; j < 4; j++) {
			max = Math.max(max, land[land.length-1][j]);
		}
		return max;
	}

}