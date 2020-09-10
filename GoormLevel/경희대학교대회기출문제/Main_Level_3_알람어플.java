import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_Level_3_알람어플 { // 제출일 2020-09-10 16:33
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 최대 5000자의 문자열 s에 대해 부분 문자열 중 사전순으로 k(1~10)번째 문자를 출력
		String input = br.readLine();
		// k 제한으로 정답의 최대 길이가 10자이므로 각 문자 위치에 대해 10번씩 확인하게 된다
		int k = Integer.parseInt(br.readLine());

		// 1. brute-force
		// 끝 위치에서는 최대 길이를 모두 확인할 수 없으므로 50000 개 미만의 부분 문자열이 생성되고
		// 5만개를 단순히 정렬한 뒤 k번째를 출력하면 ok

		// 2. abc 사전 순서대로 부분 문자열의 개수를 계산하여 정렬
		char abc = 'a';
		Set<String> set = new HashSet<>();
		while (set.size() < k) {
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == abc) {
					for (int j = 1; j <= 10 && i + j <= input.length(); j++) {
						set.add(input.substring(i, i + j));
					}
				}
			}
			abc++;
		}

		String[] arr = set.stream().toArray(String[]::new);
		Arrays.parallelSort(arr);
		System.out.println(arr[k-1]);
	}
}