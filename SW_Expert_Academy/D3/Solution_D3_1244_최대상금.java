import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 기존 제출일 2019-08-19 01:30 테스트케이스 추가로 Fail
// 수정 제출일 2020-06-16 23:34 20,072 kb 107 ms
public class Solution_D3_1244_최대상금 { 

	static int[] value;
	static int maxExchange, answer, len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			String[] val = br.readLine().split(" ");
			len = val[0].length();
			value = new int[len];
			for (int i = 0; i < len; i++) {
				value[i] = val[0].charAt(i) - '0';
			}
			maxExchange = Integer.parseInt(val[1]);
			answer = 0;

			dfs(0, 0);
			while (answer == 0) {
				// 남은 change 횟수에 따라 다음과 같이 처리한다
				if (maxExchange % 2 == 0) { // 0이라면 더 이상 변경할 수 없고
					// 2 이상이라면 다시 원상태로 돌아온다
					answer = getValue();
					break;
				}
				// 홀수라면 value에 같은 값이 있는지 확인하고
				// 있다면 그냥 리턴 없다면 마지막 두개의 위치만 한번 바꿔준다
				if (!hasSame()) {
					swap(len - 2, len - 1);
				}
				answer = getValue();
				break;
			}
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static int getValue() {
		int ret = 0;
		for (int i = len - 1, j = 1; i >= 0; i--, j *= 10) {
			ret += value[i] * j;
		}
		return ret;
	}

	private static boolean hasSame() {
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (value[i] == value[j]) {
					return true;
				}
			}
		}
		return false;
	}

	static void dfs(int index, int count) {
		if (count == maxExchange) {
			answer = Integer.max(answer, getValue());
			return;
		}
		for (int i = index; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (value[i] <= value[j]) {
					swap(i, j);
					dfs(i, count + 1);
					swap(i, j);
				}
			}
		}

	}

	static void swap(int i, int j) {
		int temp = value[i];
		value[i] = value[j];
		value[j] = temp;

	}
}
