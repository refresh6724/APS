package keeping;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_9778_카드게임 { // 제출일 2020-04-18 23:40
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int n;
	static int[] cards;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			// 블랙잭 게임 시뮬레이션
			// 2~9까지 각 4장 32장
			// 10 16장
			// 11 4장
			// 합이 52장

			n = Integer.parseInt(br.readLine());

			cards = new int[12]; // 11이하 카드의 수
			Arrays.fill(cards, 4);
			cards[0] = 0;
			cards[1] = 0;
			cards[10] = 16;

			int hand = 0;

			for (int i = 0; i < n; i++) {
				int card = Integer.parseInt(br.readLine());
				hand += card;
				cards[card]--;
			}
			
			
			if(hand < 11) {
				sb.append("#").append(tc).append(" GAZUA").append("\n");
				continue;
			} else if (hand > 19) {
				sb.append("#").append(tc).append(" STOP").append("\n");
				continue;
			}
			
			int pivot = 22 - hand; // 내 핸드에 10을 들고 있으면 12를 더 뽑으면 진다 따라서 
			int left = 0; // 12의 왼쪽을 뽑으면 21이하가 된다
			for (int i = 0; i < pivot; i++) {
				left += cards[i];
			}
			int right = 52 - n - left;
			if (left <= right) {
				// 뽑은 모든 카드의 가치 합이 21보다 크게 = 21초과 22 이상이 되는 경우의 수가 많거나 같은 경우 STOP
				sb.append("#").append(tc).append(" STOP").append("\n");
			} else {
				// 위 경우가 일어날 가능성이 적은 경우 GAZUA
				sb.append("#").append(tc).append(" GAZUA").append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();

	}

}
