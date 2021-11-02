public class Solution_Level_2_다음큰숫자 { // 제출일 2021-11-02 23:07

	// test
	public static void main(String[] args) {
		System.out.println(solution(78)); // 83
		System.out.println(solution(15)); // 23
	}

	// n은 1백만 이하의 자연수
	// 이진수로 변환했을때 1의 개수가 같으면서 보다 큰 수 중 가장 가까운 수
	public static int solution(int n) {
		String binary = "0".concat(Integer.toBinaryString(n));
		// 오른쪽에서 시작해 가장 처음 만나는 01을 10으로 만들고 해당 위치 오른쪽의 1을 모두 오른쪽으로 몰아준다
		// 
		int lastIdx = binary.lastIndexOf("01");
		char[] arr = binary.toCharArray();
		arr[lastIdx++] = '1';
		arr[lastIdx++] = '0';
		int zero = 0;
		for (int i = lastIdx; i < arr.length; i++) {
			if (arr[i] == '0') {
				zero += 1;
			}
		}
		for (int i = lastIdx; i < lastIdx + zero; i++) {
			arr[i] = '0';
		}
		for (int i = lastIdx + zero; i < arr.length; i++) {
			arr[i] = '1';
		}
		return Integer.parseInt(String.copyValueOf(arr), 2);
	}

}