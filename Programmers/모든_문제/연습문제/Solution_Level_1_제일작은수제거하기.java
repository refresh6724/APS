import java.util.ArrayList;
import java.util.Arrays;

class Solution_Level_1_제일작은수제거하기 {
	
	public static void main(String[] args) {
		// 가장 작은 수를 제거한 배열을 리턴
		System.out.println(Arrays.toString(solution(new int[] {4,3,2,1})));
		System.out.println(Arrays.toString(solution(new int[] {10})));
	}
	
	
	public static int[] solution(int[] arr) {
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
				minIdx = i;
			}
		}
		ArrayList<Integer> li = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if(i!=minIdx) {
				li.add(arr[i]);
			}
		}
		if(li.size() == 0) {
			return new int[] {-1};
		}
		return li.stream().mapToInt(x->x).toArray();
	}
	
}