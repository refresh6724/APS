import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_JO_1031_빙고 { // 제출일 2021-03-16 23:16

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 5x5 판
		// 11이면 row1, col1, cross1 증가
		// 숫자 -> 5개 -> 5개 -> 2개 리스트 확인
		// 리스트에 있으면 1증가 5가 되면 bingo 증가
		// bingo가 3이면 cnt 출력

		int[][] arr = new int[5][5];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		LinkedList<Integer>[] row = new LinkedList[5];
		LinkedList<Integer>[] col = new LinkedList[5];
		LinkedList<Integer>[] cross = new LinkedList[2];

		for (int i = 0; i < 5; i++) {
			row[i] = new LinkedList<Integer>();
			col[i] = new LinkedList<Integer>();
		}
		cross[0] = new LinkedList<Integer>();
		cross[1] = new LinkedList<Integer>();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				row[i].add(arr[i][j]);
				col[i].add(arr[j][i]);
			}
			cross[0].add(arr[i][i]);
			cross[1].add(arr[i][4 - i]);
		}

		int bingo = 0;
		int cnt = 0;
		int[] check = new int[12];
		boolean find = false;
		for (int i = 0; i < 5 && !find; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5 && !find; j++) {
				int num = Integer.parseInt(st.nextToken());
				cnt++;
				for (int k = 0; k < 5 && !find; k++) {
					for (int idx = 0; idx < row[k].size(); idx++) {
						if (num == row[k].get(idx)) {
							find = true;
							row[k].remove(idx);
							check[k]++;
							if (check[k] == 5) {
								bingo++;
							}
							break;
						}
					}
				}
				find = false;
				for (int k = 0; k < 5 && !find; k++) {
					for (int idx = 0; idx < col[k].size(); idx++) {
						if (num == col[k].get(idx)) {
							find = true;
							col[k].remove(idx);
							check[5 + k]++;
							if (check[5 + k] == 5) {
								bingo++;
							}
							break;
						}
					}
				}
				find = false;
				for (int k = 0; k < 2 && !find; k++) {
					for (int idx = 0; idx < cross[k].size(); idx++) {
						if (num == cross[k].get(idx)) {
							// find = true;
							// 중앙 교차
							cross[k].remove(idx);
							check[10 + k]++;
							if (check[10 + k] == 5) {
								bingo++;
							}
							break;
						}
					}
				}
				find = false;
				if (bingo >= 3) {
					find = true;
					sb.append(cnt);
					break;
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}