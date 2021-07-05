import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_JO_2543_타일채우기 { // 제출일 2021-07-05 23:33

	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// nxn 정사각형 바닥을 다음 타일로 채우기
		// 01 20 33 44
		// 11 22 03 40
		// 빈 칸(0) 하나의 위치가 r, c로 주어진다

		int n = Integer.parseInt(br.readLine().trim()); // 2 이상 512 이하, 2의 거듭제곱
		String[] pos = br.readLine().split(" ");
		int r = Integer.parseInt(pos[0]);
		int c = Integer.parseInt(pos[1]);

		map = new int[n][n];
		dfs(r, c, 0, 0, n, 0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	/**
	 * 현재 사이즈는 2의 거듭제곱으로 주어진 면을 4등분하여 보면<br>
	 * 배수구의 위치가 4분면 중 하나에 위치해 있다.<br>
	 * 이는 타일 그림과 같은 형태로서 0이 예제와 같이 2사분면에 있다면 1번 타일이 정중앙 2x2에 오게 된다 <br>
	 * 0의 위치를 찾았다면 해당 사분면만 0이 어디에 있는지 다시 찾게하고<br>
	 * 다른 세 사분면에서는 결정된 1번 타일이 새로운 구멍이 되어 0이 아닌 1을 값으로 가진 size/2의 타일이 된다<br>
	 * 사이즈가 2까지 줄어들면 구멍의 위치에 따라 값을 채워주고 구멍에는 인수로 넘겨받은 tile 값을 넣어준다<br>
	 * 
	 * @param hr   현재 정사각형에서 구멍의 행 위치
	 * @param hc   현재 정사각형에서 구멍의 열 위치
	 * @param sr   현재 정사각형에서 가장 왼쪽 위 칸의 행 위치
	 * @param sc   현재 정사각형에서 가장 왼쪽 위 칸의 열 위치
	 * @param size 정사각형 한 변의 길이
	 * @param tile 구멍에 넣어야 하는 값
	 */
	private static void dfs(int hr, int hc, int sr, int sc, int size, int tile) {
		if (size == 2) {
			if (hr == sr && hc == sc) { // 2사분면
				map[sr][sc] = tile;
				map[sr][sc + 1] = 1;
				map[sr + 1][sc + 1] = 1;
				map[sr + 1][sc] = 1;
			} else if (hr == sr && hc == sc + 1) { // 1사분면
				map[sr][sc] = 2;
				map[sr][sc + 1] = tile;
				map[sr + 1][sc + 1] = 2;
				map[sr + 1][sc] = 2;
			} else if (hr == sr + 1 && hc == sc + 1) { // 4사분면
				map[sr][sc] = 4;
				map[sr][sc + 1] = 4;
				map[sr + 1][sc + 1] = tile;
				map[sr + 1][sc] = 4;
			} else if (hr == sr + 1 && hc == sc) { // 3사분면
				map[sr][sc] = 3;
				map[sr][sc + 1] = 3;
				map[sr + 1][sc + 1] = 3;
				map[sr + 1][sc] = tile;
			}
		}
		// 쪼개기
		else {
			int whereisHole = findHole(hr, hc, sr, sc, size);
			int mr = sr + size / 2;
			int mc = sc + size / 2;
			switch (whereisHole) {
			case 1:
				dfs(hr, hc, sr, mc, size / 2, tile); // 1사분면
				dfs(mr - 1, mc - 1, sr, sc, size / 2, 2); // 2사분면
				dfs(mr, mc - 1, mr, sc, size / 2, 2); // 3사분면
				dfs(mr, mc, mr, mc, size / 2, 2); // 4사분면
				break;
			case 2:
				dfs(mr - 1, mc, sr, mc, size / 2, 1);// 1사분면
				dfs(hr, hc, sr, sc, size / 2, tile); // 2사분면
				dfs(mr, mc - 1, mr, sc, size / 2, 1); // 3사분면
				dfs(mr, mc, mr, mc, size / 2, 1); // 4사분면
				break;
			case 3:
				dfs(mr - 1, mc, sr, mc, size / 2, 3);// 1사분면
				dfs(mr - 1, mc - 1, sr, sc, size / 2, 3); // 2사분면
				dfs(hr, hc, mr, sc, size / 2, tile); // 3사분면
				dfs(mr, mc, mr, mc, size / 2, 3); // 4사분면
				break;
			case 4:
				dfs(mr - 1, mc, sr, mc, size / 2, 4);// 1사분면
				dfs(mr - 1, mc - 1, sr, sc, size / 2, 4); // 2사분면
				dfs(mr, mc - 1, mr, sc, size / 2, 4); // 3사분면
				dfs(hr, hc, mr, mc, size / 2, tile); // 4사분면
				break;
			}
		}

	}

	private static int findHole(int hr, int hc, int sr, int sc, int size) {
		// 홀의 위치가 몇 사분면인지 반환
		if (hr >= sr + size / 2) {
			if (hc >= sc + size / 2)
				return 4;
			else
				return 3;
		} else {
			if (hc >= sc + size / 2)
				return 1;
			else
				return 2;
		}
	}

}
