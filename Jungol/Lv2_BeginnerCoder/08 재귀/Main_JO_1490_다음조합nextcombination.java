import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1490_다음조합nextcombination { // 제출일 2021-04-02 23:40

	static int n, k;
	static int[] arr;
	static StringBuilder ans;

	public static void main(String[] args) throws Exception {
		input();
		nextCombination();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 5 이상 10 이하
		k = Integer.parseInt(st.nextToken()); // 1 이상 N 이하
		arr = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ans = new StringBuilder();
	}

	private static void nextCombination() {
		// 제일 끝 수를 1 올린다
		// 올릴 수 없다면 앞으로 오면서 올릴 수 있는 수를 1 올린다 올렸다면
		// 그 위치부터 끝까지 순서대로 1씩 더해준다
		// 만약 앞으로 오는 idx가 -1에 도착하면 NONE을 출력

		// n은 나올 수 있는 값
		// k는 arr의 길이
		// arr[idx]에서 나올 수 있는 최댓값은 n-k+1+idx
		int idx = k - 1;
		while (idx != -1) {
			// 5 - 오른쪽에서
			if (arr[idx] < n - k + 1 + idx) {
				arr[idx] += 1;
				for (int i = idx + 1; i < arr.length; i++) {
					arr[i] = arr[i - 1] + 1;
				}
				break;
			}
			idx -= 1;
		}
		if (idx == -1) {
			ans.append("NONE");
		} else {
			ans.append(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				ans.append(' ').append(arr[i]);
			}
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(ans.toString());
		bw.flush();
	}
}