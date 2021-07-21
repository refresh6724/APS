public class Solution_Level_1_하샤드수 { // 제출일 2021-07-21 22:43

	public boolean solution(int x) {
		int y = x;
		int z = 0;
		while (y != 0) {
			z += y % 10;
			y /= 10;
		}
		return (x % z == 0);
	}
}
