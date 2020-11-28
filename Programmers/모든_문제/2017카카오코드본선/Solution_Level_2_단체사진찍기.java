public class Solution_Level_2_단체사진찍기 { // 제출일 2020-11-28 23:17

	public static void main(String[] args) {
		System.out.println(solution(2, new String[] { "N~F=0", "R~T>2" })); // 3648
		System.out.println(solution(2, new String[] { "M~C<2", "C~M>1" })); // 0
	}

	static final int LEN = 8;
	static String line = "ACFJMNRT";
	static char[] arr = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };

	public static int solution(int n, String[] data) {
		line = "ACFJMNRT";
		arr = new char[] { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
		// 조건 n개 최대 100개
		// 8! (40320)에서 조건 n개 따지기 => 완전탐색?
		int ans = 0;
		do {
			ans++;
			for (int i = 0; i < n; i++) {
				if (!check(data[i])) {
					ans--;
					break;
				}
			}
		} while (nextArr());
		return ans;
	}

	private static boolean check(String string) {
		// 현재 arr가 string 조건을 만족하는지 확인하여 리턴한다
		int i = line.indexOf(string.charAt(0));
		int j = line.indexOf(string.charAt(2));
		int len = Math.abs(i - j) - 1;
		int num = string.charAt(4) - '0';
		switch (string.charAt(3)) {
		case '=':
			if (len != num) {
				return false;
			}
			break;
		case '<':
			if (num == 0) {
				return false;
			}
			if (len >= num) {
				return false;
			}
			break;
		case '>':
			if (num == 6) {
				return false;
			}
			if (len <= num) {
				return false;
			}
			break;
		}
		return true;
	}

	private static boolean nextArr() {
		// 끝에서 부터 오름차순의 마지막을 찾는다
		int last = LEN - 2;
		while (last >= 0) {
			if (arr[last] < arr[last + 1]) {
				break;
			}
			last--;
		}
		// 배열이 내림차순이라면 끝낸다
		if (last < 0) {
			return false;
		}
		// 꺾이는 부분보다 큰 값을 앞에서 찾는다
		int next = LEN - 1;
		for (int i = LEN - 1; i > last; i--) {
			if (arr[i] > arr[last]) {
				next = i;
				break;
			}
		}
		// 찾았다면 서로 바꾸고 뒷부분은 내림차순에서 오름차순으로 만들어준다
		swap(next, last);
		reverse(last + 1, LEN - 1);
		line = String.copyValueOf(arr);
		return true;
	}

	private static void reverse(int i, int j) {
		while (i < j) {
			int tmp = arr[i];
			arr[i++] = arr[j];
			arr[j--] = (char) tmp;
		}
	}

	private static void swap(int next, int last) {
		int tmp = arr[next];
		arr[next] = arr[last];
		arr[last] = (char) tmp;
	}

}