public class Main_BOJ_15596_정수N개의합 { // 제출일 2020-10-10 23:07

	// 클래스 이름 Test
	// 함수 이름 long sum(int[] a)
	// a : 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
	// 리턴값 : a에 포함되어 있는 정수 n개의 합 long
	
	public static void main(String[] args) {
		// 아래 Test class
	}
}

class Test {
	long sum(int[] a) {
		long ans = 0;
		for (int i = 0; i < a.length; i++) {
			ans += a[i];
		}
		return ans;
	}
}