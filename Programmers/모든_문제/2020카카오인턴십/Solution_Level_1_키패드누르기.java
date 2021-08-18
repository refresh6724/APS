public class Solution_Level_1_키패드누르기 { // 제출일 2021-08-18 23:13
	
	static int[][] length = new int[][] { 
			 // 0  1  2  3  4  5  6  7  8  9  *  #
			  { 0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1 } // 0
			, { 4, 0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 5 } // 1
			, { 3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4 } // 2
			, { 4, 2, 1, 0, 3, 2, 1, 4, 3, 2, 5, 3 } // 3
			, { 3, 1, 2, 3, 0, 1, 2, 1, 2, 3, 2, 4 } // 4
			, { 2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3 } // 5
			, { 3, 3, 2, 1, 2, 1, 0, 3, 2, 1, 4, 2 } // 6
			, { 2, 2, 3, 4, 1, 2, 3, 0, 1, 2, 1, 3 } // 7
			, { 1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2 } // 8
			, { 2, 4, 3, 2, 3, 2, 1, 2, 1, 0, 3, 1 } // 9
			, { 1, 3, 4, 5, 2, 3, 4, 1, 2, 3, 0, 2 } // *
			, { 1, 5, 4, 3, 4, 3, 2, 3, 2, 1, 2, 0 } // #
	};

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right")); // LRLLLRLLRRL
		System.out.println(solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left")); // LRLLRRLLLRR
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right")); // LLRLLRLLRL
	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();

		int left = 10; // *
		int right = 11; // #

		for (int number : numbers) {
			if (number == 1 || number == 4 || number == 7) {
				left = number;
				sb.append("L");
			} else if (number == 3 || number == 6 || number == 9) {
				right = number;
				sb.append("R");
			} else {
				if (length[left][number] < length[right][number]) {
					left = number;
					sb.append("L");
				} else if (length[left][number] > length[right][number]) {
					right = number;
					sb.append("R");
				} else {
					if (hand.charAt(0) == 'l') {
						left = number;
						sb.append("L");
					} else {
						right = number;
						sb.append("R");
					}
				}
			}
		}

		return sb.toString();
	}
}
