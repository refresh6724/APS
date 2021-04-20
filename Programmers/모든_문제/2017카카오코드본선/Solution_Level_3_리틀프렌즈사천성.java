import java.util.LinkedList;
import java.util.Queue;

public class Solution_Level_3_리틀프렌즈사천성 { // 제출일 2021-04-20 23:30

	// test
	public static void main(String[] args) {
		System.out.println(solution(3, 3, new String[] { "DBA", "C*A", "CDB" })); // "ABCD"
		System.out.println(solution(2, 4, new String[] { "NRYN", "ARYA" })); // "RYAN"
		System.out.println(solution(4, 4, new String[] { ".ZI.", "M.**", "MZU.", ".IU." })); // "MUZI"
		System.out.println(solution(2, 2, new String[] { "AB", "BA" })); // "IMPOSSIBLE"
		System.out.println(solution(2, 52, new String[] { "ABCDEFGHIJKLMNOPQRSTUVWXYZ..........................", "..........................ZYXWVUTSRQPONMLKJIHGFEDCBA" })); // "ZYXWVUTSRQPONMLKJIHGFEDCBA"
	}

	static int sm, sn;
	static char[][] map;
	static int[][] tiles;
	static int cnt;
	static StringBuilder answer;

	/**
	 * 리틀 프렌즈 사천성<br>
	 * 규칙에 따라 타일을 모두 제거할 수 있는지<br>
	 * 가능한 경우 어떤 순서로 제거해야 하는지<br>
	 * 
	 * @param m     1 이상 100 이하
	 * @param n     1 이상 100 이하
	 * @param board 게임판 타일의 정보를 담은 스트링 배열
	 * @return 가능한 순서 또는 불가능
	 */
	public static String solution(int m, int n, String[] board) {

		// . : 빈칸
		// * : 막힌 칸
		// A-Z : 같은 글자로 이루어진 타일은 항상 두 개씩만 존재한다. (단독일 경우? imp)
		// 타일이 없는 입력은 주어지지 않는다

		// step 1
		// 26자 알파벳으로 한정되어 있으므로 A부터 Z까지 위치를 기록하고 매번 연결 가능한지 확인한다

		sm = m;
		sn = n;
		map = new char[sm][sn];
		tiles = new int[26][5];
		cnt = 0;
		answer = new StringBuilder();
		for (int i = 0; i < sm; i++) {
			map[i] = board[i].toCharArray();
			for (int j = 0; j < sn; j++) {
				if (Character.isUpperCase(map[i][j])) {
					saveTileInfo(map[i][j] - 'A', i, j);
				}
			}
		}

		if (tileIsAlone()) {
			return "IMPOSSIBLE";
		}

		boolean found = false;
		while (cnt > 0) {
			for (int x = 0; x < 26; x++) {
				if (tiles[x][0] > 0) {
					if (findPath_3(x)) {
						findX(x);
						found = true;
						break;
					} // else continue;
				}
			}

			if (!found) {
				break;
			}
			found = false;
		}

		return (cnt == 0) ? answer.toString() : "IMPOSSIBLE";
	}

	private static boolean findPath_3(int x) {
		// 2에서 col이 무조건 좌에서 우로 간다는 간단한 제약 추가
		// 가능한 경로는 일자형, ㄱ형, ㄴ형 이다
		// 2와 4는 같거나 2<4 이다
		if (tiles[x][2] == tiles[x][4]) {
			// 1에서 3까지 .만 놓여있는 경우
			if (tiles[x][1] < tiles[x][3]) {
				for (int i = tiles[x][1] + 1; i < tiles[x][3]; i++) {
					if (map[i][tiles[x][2]] != '.') {
						return false;
					}
				}
			} else {
				for (int i = tiles[x][3] + 1; i < tiles[x][1]; i++) {
					if (map[i][tiles[x][2]] != '.') {
						return false;
					}
				}
			}
			return true;
		} else { // 2 < 4
			if (tiles[x][1] == tiles[x][3]) {
				// 2에서 4까지 .만 놓여있는 경우
				for (int i = tiles[x][2] + 1; i < tiles[x][4]; i++) {
					if (map[tiles[x][1]][i] != '.') {
						return false;
					}
				}
				return true;
			}
			// 오른쪽으로 먼저 이동하는 경우 12 -> 14 -> 34
			if (rightFirst(x)) {
				return true;
			}

			// 위, 아래로 먼저 이동하는 경우 12 -> 32 -> 34

			if (tiles[x][1] < tiles[x][3]) { // 아래로
				for (int i = tiles[x][1] + 1; i < tiles[x][3]; i++) {
					if (map[i][tiles[x][2]] != '.') {
						return false;
					}
				}
			} else { // 위로
				for (int i = tiles[x][1] - 1; i > tiles[x][3]; i--) {
					if (map[i][tiles[x][2]] != '.') {
						return false;
					}
				}
			}
			// 오른쪽으로
			for (int i = tiles[x][2]; i < tiles[x][4]; i++) {
				if (map[tiles[x][3]][i] != '.') {
					return false;
				}
			}
			return true;
		}

	}

	private static boolean rightFirst(int x) {
		// 먼저 오른쪽으로 이동
		for (int i = tiles[x][2] + 1; i < tiles[x][4]; i++) {
			if (map[tiles[x][1]][i] != '.') {
				return false;
			}
		}
		// 이후
		if (tiles[x][1] < tiles[x][3]) { // 아래로
			for (int i = tiles[x][1]; i < tiles[x][3]; i++) {
				if (map[i][tiles[x][4]] != '.') {
					return false;
				}
			}
		} else { // 위로
			for (int i = tiles[x][1]; i > tiles[x][3]; i--) {
				if (map[i][tiles[x][4]] != '.') {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean findPath_2_FixedRoute(int x) {
		// 가능한 경로는 일자형, ㄱ형, ㄴ형 이다
		if (tiles[x][1] == tiles[x][3]) {
			// 2에서 4까지 .만 놓여있는 경우
			if (tiles[x][2] < tiles[x][4]) {
				for (int i = tiles[x][2] + 1; i < tiles[x][4]; i++) {
					if (map[tiles[x][1]][i] != '.') {
						return false;
					}
				}
			} else {
				for (int i = tiles[x][4] + 1; i < tiles[x][2]; i++) {
					if (map[tiles[x][1]][i] != '.') {
						return false;
					}
				}
			}
			return true;
		} else if (tiles[x][2] == tiles[x][4]) {
			// 1에서 3까지 .만 놓여있는 경우
			if (tiles[x][1] < tiles[x][3]) {
				for (int i = tiles[x][1] + 1; i < tiles[x][3]; i++) {
					if (map[i][tiles[x][2]] != '.') {
						return false;
					}
				}
			} else {
				for (int i = tiles[x][3] + 1; i < tiles[x][1]; i++) {
					if (map[i][tiles[x][2]] != '.') {
						return false;
					}
				}
			}
			return true;
		} else {

			map[tiles[x][1]][tiles[x][2]] = '.';
			map[tiles[x][3]][tiles[x][4]] = '.';

			if (oneRotPass(x, 0) || oneRotPass(x, 1)) {
				return true;
			}

			map[tiles[x][1]][tiles[x][2]] = (char) ('A' + x);
			map[tiles[x][3]][tiles[x][4]] = (char) ('A' + x);

		}

		return false;
	}

	private static boolean oneRotPass(int x, int route) {
		if (route == 0) { // 12 -> 32 -> 34을 거치는 경로
			if (tiles[x][1] < tiles[x][3]) {
				for (int i = tiles[x][1]; i <= tiles[x][3]; i++) {
					if (map[i][tiles[x][2]] != '.') {
						return false;
					}
				}
			} else {
				for (int i = tiles[x][3]; i <= tiles[x][1]; i++) {
					if (map[i][tiles[x][2]] != '.') {
						return false;
					}
				}
			}

			if (tiles[x][2] < tiles[x][4]) {
				for (int i = tiles[x][2]; i <= tiles[x][4]; i++) {
					if (map[tiles[x][3]][i] != '.') {
						return false;
					}
				}
			} else {
				for (int i = tiles[x][4]; i <= tiles[x][2]; i++) {
					if (map[tiles[x][3]][i] != '.') {
						return false;
					}
				}
			}

			return true;

		} else { // 12 -> 14 -> 34를 거치는 경로

			if (tiles[x][2] < tiles[x][4]) {
				for (int i = tiles[x][2]; i <= tiles[x][4]; i++) {
					if (map[tiles[x][1]][i] != '.') {
						return false;
					}
				}
			} else {
				for (int i = tiles[x][4]; i <= tiles[x][2]; i++) {
					if (map[tiles[x][1]][i] != '.') {
						return false;
					}
				}
			}

			if (tiles[x][1] < tiles[x][3]) {
				for (int i = tiles[x][1]; i <= tiles[x][3]; i++) {
					if (map[i][tiles[x][4]] != '.') {
						return false;
					}
				}
			} else {
				for (int i = tiles[x][3]; i <= tiles[x][1]; i++) {
					if (map[i][tiles[x][4]] != '.') {
						return false;
					}
				}
			}

			return true;

		}
	}

	private static void findX(int x) {
		answer.append((char) ('A' + x));
		map[tiles[x][1]][tiles[x][2]] = '.';
		map[tiles[x][3]][tiles[x][4]] = '.';
		tiles[x][0] -= 2;
		cnt -= 2;
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	private static boolean findPath_1_BFS_TIMEOVER(int x) {
		// 알파벳 x에 대해 bfs로 경로를 찾는다
		// 한번만 꺾는다는 조건에 따라 경로가 세가지로 제한된다
		char wantToFind = (char) ('A' + x);
		Queue<int[]> q = new LinkedList<>(); // int[]는 좌표 r, c, dir, rot로 구성
		visited = new boolean[sm][sn];
		int nr = tiles[x][1];
		int nc = tiles[x][2];
		visited[nr][nc] = true;
		for (int dir = 0; dir < 4; dir++) {
			nr = tiles[x][1] + dr[dir];
			nc = tiles[x][2] + dc[dir];
			if (nr < 0 || nc < 0 || nr >= sm || nc >= sn) {
				continue;
			}
			q.add(new int[] { nr, nc, dir, 0 });
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (!visited[now[0]][now[1]]) {
				visited[now[0]][now[1]] = true;
				if (map[now[0]][now[1]] == '.') {

					for (int dir = 0; dir < 4; dir++) {
						nr = now[0] + dr[dir];
						nc = now[1] + dc[dir];
						if (nr < 0 || nc < 0 || nr >= sm || nc >= sn || visited[nr][nc]) {
							continue;
						}

						if (now[2] != dir && now[3] == 0) { // 경로는 한번만 꺾을 수 있다
							q.add(new int[] { nr, nc, dir, 1 });
						} else if (now[2] == dir) { // 직진
							q.add(new int[] { nr, nc, dir, now[3] });
						}

					}

				} else if (map[now[0]][now[1]] == wantToFind) {
					answer.append(wantToFind);
					map[now[0]][now[1]] = '.';
					map[tiles[x][1]][tiles[x][2]] = '.';
					tiles[x][0] -= 2;
					cnt -= 2;
					return true;
				} // else continue;
			}
		}

		return false;
	}

	private static void saveTileInfo(int x, int i, int j) {
		cnt++;

		tiles[x][0]++;
		if (tiles[x][0] == 1) {
			tiles[x][1] = i;
			tiles[x][2] = j;
		} else {

			// 경우의 수를 줄이기 위하여 항상 좌에서 우로 이동하는 것으로 설정
			if (tiles[x][2] < j) {
				tiles[x][3] = i;
				tiles[x][4] = j;
			} else {
				tiles[x][3] = tiles[x][1];
				tiles[x][4] = tiles[x][2];
				tiles[x][1] = i;
				tiles[x][2] = j;
			}

		}

	}

	private static boolean tileIsAlone() {
		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i][0] == 1) {
				return true;
			}
		}
		return false;
	}
}


// 모범답안 _ 시간은 약간 더 걸리지만 가독성이 좋다

/*
import java.util.*;
class Solution {
    public static String BLANK = ".";
    public static String BLOCK = "*";

    public String solution(int m, int n, String[] board) {
        Board b = initBoard(m, n, board);
        StringBuilder result = new StringBuilder();
        wh: while (!b.getTileMap().isEmpty()) {
            for (Entry<String, List<Tile>> entry : b.getTileMap().entrySet()) {
                String tileStr = entry.getKey();
                if (canConnect(b, tileStr)) {
                    result.append(tileStr);
                    b.removeTile(tileStr);
                    continue wh;
                }
            }
            return "IMPOSSIBLE";
        }
        return result.toString();
    }

    private Board initBoard(int m, int n, String[] board) {
        Board b = new Board(m, n);
        for (int mi = 0; mi < m; mi++) {
            for (int ni = 0; ni < n; ni++) {
                b.addTileInfo(board[mi].substring(ni, ni + 1), mi, ni);
            }
        }
        return b;
    }

    private boolean canConnect(Board b, String tileStr) {
        List<Tile> tiles = b.getTileMap().get(tileStr);
        Tile start = tiles.get(0);
        Tile end = tiles.get(1);
        return isTopEmpty(b, start, end) && isRightEmpty(b, start, end)
            || isBottomEmpty(b, start, end) && isLeftEmpty(b, start, end);
    }

    private boolean isTopEmpty(Board b, Tile start, Tile end) {
        int m = start.getM();
        for (int n = Math.min(start.n, end.n); n <= Math.max(start.n, end.n); n++) {
            if (!b.isBlankOrBlock(m, n, start.getTile())) {
                return false;
            }
        }
        return true;
    }

    private boolean isBottomEmpty(Board b, Tile start, Tile end) {
        int m = end.getM();
        for (int n = Math.min(start.n, end.n); n <= Math.max(start.n, end.n); n++) {
            if (!b.isBlankOrBlock(m, n, start.getTile())) {
                return false;
            }
        }
        return true;
    }

    private boolean isLeftEmpty(Board b, Tile start, Tile end) {
        int n = start.getN();
        for (int m = Math.min(start.m, end.m); m <= Math.max(start.m, end.m); m++) {
            if (!b.isBlankOrBlock(m, n, start.getTile())) {
                return false;
            }
        }
        return true;
    }

    private boolean isRightEmpty(Board b, Tile start, Tile end) {
        int n = end.getN();
        for (int m = Math.min(start.m, end.m); m <= Math.max(start.m, end.m); m++) {
            if (!b.isBlankOrBlock(m, n, start.getTile())) {
                return false;
            }
        }
        return true;
    }

    public static class Board {
        private TreeMap<String, List<Tile>> tileMap = new TreeMap<>();
        private String[][] byCoordArr;

        public Board(int m, int n) {
            byCoordArr = new String[m][n];
        }

        public void addTileInfo(String tileStr, int m, int n) {
            byCoordArr[m][n] = tileStr;
            if (equalsAny(tileStr, BLANK, BLOCK)) {
                return;
            }
            tileMap.computeIfAbsent(tileStr, k -> new ArrayList<>())
                .add(new Tile(tileStr, m, n));
        }

        public void removeTile(String tileStr) {
            for (Tile tile : tileMap.get(tileStr)) {
                byCoordArr[tile.m][tile.n] = BLANK;
            }
            tileMap.remove(tileStr);
        }

        public boolean isBlankOrBlock(int m, int n, String blockStr) {
            return equalsAny(byCoordArr[m][n], BLANK, blockStr);
        }

        public boolean equalsAny(final CharSequence string, final CharSequence... searchStrings) {
            if (null == searchStrings) {
                return false;
            }
            for (final CharSequence next : searchStrings) {
                if (Objects.equals(string, next)) {
                    return true;
                }
            }
            return false;
        }

        public TreeMap<String, List<Tile>> getTileMap() {
            return tileMap;
        }

        public void setTileMap(TreeMap<String, List<Tile>> tileMap) {
            this.tileMap = tileMap;
        }

        public String[][] getByCoordArr() {
            return byCoordArr;
        }

        public void setByCoordArr(String[][] byCoordArr) {
            this.byCoordArr = byCoordArr;
        }
    }

    public static class Tile {
        private String tile;
        private int m;
        private int n;

        private Tile(String tile, int m, int n) {
            super();
            this.tile = tile;
            this.m = m;
            this.n = n;
        }

        public String getTile() {
            return tile;
        }

        public void setTile(String tile) {
            this.tile = tile;
        }

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }
    }
}
*/
