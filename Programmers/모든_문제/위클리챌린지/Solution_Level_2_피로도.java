public class Solution_Level_2_피로도 {

	/**
	 * 개수가 8개 밖에 안되서 그냥 dfs 돌려도 ok
	 * 
	 * @param k        현재피로도
	 * @param dungeons [최소 피로도, 소모 피로도] * 최대 8개
	 * @return 최대 던전 수
	 */
	public int solution(int k, int[][] dungeons) {
		int ans = 0;
		int tmp = 0;
		for (int i = 0; i < dungeons.length; i++) {
			if (dungeons[i][0] <= k) {
				tmp = dungeons[i][0];
				dungeons[i][0] = k;
				ans = Math.max(1 + solution(k - dungeons[i][1], dungeons), ans);
				dungeons[i][0] = tmp;
			}
		}
		return ans;
	}

}
