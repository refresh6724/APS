import java.util.Arrays;

public class Solution_Level_4_지형편집 { // 제출일 2020-10-07 23:55

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1 } }, 3, 2)); // 0
		System.out.println(solution(new int[][] { { 1, 2 }, { 2, 3 } }, 3, 2)); // 5
		System.out.println(solution(new int[][] { { 4, 4, 3 }, { 3, 2, 2 }, { 2, 1, 0 } }, 5, 3)); // 33
		System.out.println(solution(new int[][] { { 0, 2, 4 }, { 4, 4, 6 }, { 6, 8, 8 } }, 5, 3)); // 66
		System.out.println(solution(new int[][] { { 0, 1 }, { 1, 1000000000 } }, 4, 3)); // 3 000 000 001
		System.out.println(solution(new int[][] { { 0, 1 }, { 1, 1000000000 } }, 32, 30)); // 30 000 000 002
	}

	public static long solution(int[][] land, int P, int Q) {

		// 블록 추가 비용 P 제거 비용 Q
		// land는 N x N 크기의 2차원 배열, N은 1 이상 300 이하
		// 각 원소 크기는 0 이상 10억 이하
		// p,q는 각 1 이상 100 이하

		// 예 1
		// 모든 땅의 높이를 1로 맞추는데 8의 비용, 2로 맞추는데 5의 비용, 3으로 맞추는데 12 비용 => 최솟값 5

		// 시소의 무게 중심 맞추기와 비슷하다
		// 가중치 p,q를 고려하여 최소가 되도록 방정식을 짠다

		int n = land[0].length;
		int nn = n * n;
		int[] num = new int[n * n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				num[idx++] = land[i][j];
			}
		}
		Arrays.parallelSort(num); // 최대 9만개

//		return try_and_error_1(num, P, Q); // 완전탐색 좌우 코스트 비교 정렬 제외 최대 10억번 반복 => 시간 초과 효율성 전체 실패
//		return try_and_error_2(num, P, Q); // 이분탐색 좌우 코스트 비교 정렬 제외 2NlogN => 최대 130 ms
//		return try_and_error_3(num, P, Q); // dp 정렬 제외 N => 최대 70 ms
		return try_and_error_4(num, P, Q); // 수학적 원리 이용 N => 최대 65 ms

	}

	private static long try_and_error_4(int[] num, int P, int Q) {

		// 아직 모르는 최종 결과값에 도달했다고 가정할 때
		// 기존에서 추가해야하는 개수를 X 제거해야하는 개수를 Y라 하자
		// 그 비용은 PX + QY가 된다
		// 해당 비용이 최적이므로 1을 더하거나 빼도 비효율이 발생하게 된다
		// X+x개로 변하게 된다면
		// 비용이 P(X+x) + Q(Y-(N-x)) = PX + px + QY - QN + Qx 가 된다.
		// 변한 비용은 최적 비용보다 무조건 크므로 서로의 차이인 (P+Q)x - QN > 0 식이 성립한다
		// 이 때 x > QN / (P+Q) 이다.

		int x = (Q * num.length) / (P + Q); // 자동으로 내림 적용됨
		int layer = num[x];
		long ans = 0;
		for (int i = 0; i < num.length; i++) {
			if(num[i] < layer) {
				ans += (layer - num[i]) * (long)P; // num[i]가 최대 10억, P가 최대 100 이므로 int 범위 초과
			} else if(num[i] > layer) {
				ans += (num[i] - layer) * (long)Q; 
			}
		}		
		return ans;
	}

	private static long try_and_error_3(int[] num, int P, int Q) {

		long total = 0;
		for (int i = 0; i < num.length; i++) {
			total += num[i];
		}

		long prevUP, nextUP, atl, cost, min; // above the line
		prevUP = nextUP = atl = cost = 0;
		min = Long.MAX_VALUE;
		int sameCheck = -1;
		for (int i = 0; i < num.length; i++) {
			if (sameCheck != num[i]) { // 4분면 그림으로 그리면 이해가 편하다
				nextUP = (long) num[i] * i - prevUP; // i기준으로 좌측 직사각형에서 기존에 채워진 부분을 제외하고 up시켜야 하는 부분 (루프마다 누적되지 않고 새로 계산됨)
				atl = total - prevUP - (long) num[i] * (num.length - i); // 전체에서 이미 채워진 부분과 기준선 이하를 제외한 부분으로 기준선으로 내려야 하는 오른쪽 부분
				cost = nextUP * P + atl * Q;
				if (min > cost) {
					min = cost; // 코스트가 이차함수를 그린다는 것을 이용하여 극점 찾기
				} else { // => 코스트가 계속 내려가다가 올라가는 곳을 index를 한개씩 움직여 찾기
					break;
				}
				sameCheck = num[i];
			}
			prevUP += num[i];
		}
		return min;
	}

	private static long try_and_error_2(int[] num, int P, int Q) {

		int left, mid, right;
		long leftCost = 0;
		long rightCost = 0;

		left = num[0];
		right = num[num.length - 1];

		while (left <= right) {
			mid = (left + right) / 2;

			// 최대 9만번 * 2 * 이분 탐색이므로 log 90000 = 2NlogN
			leftCost = getCost(num, mid, P, Q);
			rightCost = getCost(num, mid + 1, P, Q);

			if (leftCost <= rightCost) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return Math.min(leftCost, rightCost);
	}

	private static long getCost(int[] num, long height, int P, int Q) {
		long cost = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] < height) {
				cost += (height - num[i]) * P;
			} else if (num[i] > height) {
				cost += (num[i] - height) * Q;
			}
		}
		return cost;
	}

	private static long try_and_error_1(int[] num, int P, int Q) {

		int leftIdx = 0;
		int rightIdx = num.length - 1;
		int left = num[leftIdx];
		int right = num[rightIdx];
		int leftCost = 0;
		int rightCost = 0;

		long ans = 0;
		while (left < right) { // 최대 10억번 시행됨 => 시간 초과
			while (left == num[leftIdx + 1]) {
				leftIdx++;
			}

			while (right == num[rightIdx - 1]) {
				rightIdx--;
			}

			leftCost = (leftIdx + 1) * P;
			rightCost = (num.length - rightIdx) * Q;

			if (leftCost < rightCost) {
				left++;
				ans += leftCost;
			} else {
				right--;
				ans += rightCost;
			}
		}
		return ans;
	}

}