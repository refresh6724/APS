import java.util.Arrays;

public class Solution_Level_2_n제곱배열자르기 {

	public static void main(String[] args) {
		// System.out.println(Arrays.toString(solution(3, 2, 5))); // 3 2 2 3
		System.out.println(Arrays.toString(solution(4, 7, 14))); // 4 3 3 3 4 4 4 4
	}

	public static int[] solution(int n, long left, long right) { 
		/*
		홍희표님의 람다식 정답
		return LongStream.rangeClosed(left, right).mapToInt(value -> (int) (Math.max(value / n, value % n) + 1)).toArray();
		i 행에서 i 열까지 i 값이므로 위치값을 i로 나눠서 몫과 나머지를 비교하여 값을 정한다
		
		idx 	0 1 2 3 4 5 6 7 8 9 10 11
		몫     	0 0 0 0 1 1 1 1 2 2  2  2
		나머지	0 1 2 3 0 1 2 3 0 1  2  3
		max		0 1 2 3 1 1 2 3 2 2  2  3
		max+1	1 2 3 4 2 2 3 4 3 3  3  4		 
		*/
		
		
		// 1. n n 행렬
		// 2. 1행 1열에 1, i행 i열을 i로 채운다
		// 3. 1차원 배열로 바꿔서 left 부터 right까지 잘라 출력
		// 인덱스는 0부터 시작

		// 0 1 2 3 4 5 6 7 8 9 10 11
		// 1 2 3 4 2 2 3 4 3 3 3 4
		// 3/4 = 0번째 0+1 이 0*n ~ 0*(n+1) 인덱스까지
		// 7/4 = 1번쨰 1+1 이 1*n ~ 1*(n+1) 인덱스까지
		// 최대 10만개 출력
		int sr = (int) (left / n); // sr+1 이 sr+1 개
		int er = (int) (right / n); // er+1 이 er+1 개
		int row = er - sr + 1;
		int[][] num = new int[row][n];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < sr + 1 + i; j++) {
				num[i][j] = sr + 1 + i;
			}
			for (int j = sr + 1 + i; j < n; j++) {
				num[i][j] = j + 1;
			}
		}

		for (int i = 0; i < row; i++) {
			// System.out.println(Arrays.toString(num[i]));
		}

		int[] one = Arrays.copyOf(num[0], row * n);
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < n; j++) {
				one[n * i + j] = num[i][j];
			}
		}

		// System.out.println(Arrays.toString(one));

		int start = (int) (left - (long) sr * n);
		int end = (int) (right - (long) sr * n);
		return Arrays.copyOfRange(one, start, end + 1);
	}
}