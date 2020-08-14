import java.util.PriorityQueue;
import java.util.Stack;

public class Solution_Level_2_큰수만들기 { // 제출일 2020-08-14 00:20

	// test
	public static void main(String[] args) {
		System.out.println(solution("12", 1)); // 2
		System.out.println(solution("767", 2)); // 7
		System.out.println(solution("1924", 2)); // 94
		System.out.println(solution("1231234", 3)); // 3234
		System.out.println(solution("4177252841", 4)); // 775841
	}

	public static String solution(String number, int k) {

		// 어떤 숫자에서 k개의 수를 제거했을때 가장 큰 수 = 이상적으로 내림차순일 경우
		// nCk 경우의 수
		// n : 1 이상 1백만 자리 이하 숫자
		// k : 1 이상 number 자릿수 미만 자연수

		//return try_and_error_1(number, k);// 10번 테케 7500 ms
		//return 다른분의유사답안(number, k); 	// 10번 테케 6300 ms
		return try_and_error_2(number, k); 	// 10번 테케 150 ms
		//return 다른분의모범답안(number, k); 	// 10번 테케 94 ms
	}

	private static String 다른분의모범답안(String number, int k) {
		char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
	}

	private static String try_and_error_2(String number, int k) {

		// 1번에서 중복계산하는 것을 피하기 위해
		// PriorityQueue를 사용하여 그 다음 최댓값까지의 거리를 저장
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Node node;
		StringBuilder sb = new StringBuilder();
		int startIdx = 0;
		int endIdx = 0;
		int pqSize = 0;
		int remove = 0;

		while (k != 0) {
			// 4. 남은 개수와 제거해야할 개수가 같다면 끝낸다
			if (startIdx + k == number.length()) {
				break;
			}
			// 1. 앞에서 k+1개를 pq에 넣는다
			for (; pqSize < k + 1; endIdx++, pqSize++) {
				pq.add(new Node(endIdx, (int) number.charAt(endIdx)));
			}
			// 2. 최댓값 중 가장 앞에 있는 값을 꺼낸다
			// 단 그 위치는 startIdx와 같거나 커야 한다
			do {
				node = pq.poll();
			} while (node.idx < startIdx);

			sb.append((char) node.val);
			// 3. 최댓값 위치 앞의 값을 뺀다, 이후 뺀 만큼 넣어준다
			remove = node.idx - startIdx;
			k -= remove;
			pqSize -= remove + 1;
			startIdx = node.idx + 1;
		}

		if (k == 0) {
			sb.append(number.substring(startIdx));
		}

		return sb.toString();
	}

	static class Node implements Comparable<Node> {
		int idx;
		int val;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int idx, int num) {
			super();
			this.idx = idx;
			this.val = num;
		}

		@Override
		public int compareTo(Node o) {
			// 먼저 값 기준 내림차순 다음 위치 기준 오름차순
			if (o.val == this.val) {
				return this.idx - o.idx;
			} else {
				return o.val - this.val;
			}
		}

		@Override
		public String toString() {
			return "Node [idx=" + idx + ", val=" + (char) val + "]";
		}
	}

	private static String 다른분의유사답안(String number, int k) {

		int bigNumLen = number.length() - k;
		char[] chNumber = number.toCharArray();
		StringBuilder answer = new StringBuilder();

		int maxIndex = 0;
		int endIndex = k + 1;

		for (int i = 0; i < bigNumLen; i++) {
			char max = '0';
			for (int j = maxIndex; j < endIndex; j++) {
				char temp = chNumber[j];
				if (max < temp) {
					max = temp;
					maxIndex = j;
				}
			}

			answer.append(max);
			maxIndex++;
			endIndex++;

			if (maxIndex == endIndex) {
				answer.append(number.substring(maxIndex, number.length() - maxIndex));
				break;
			}
		}

		return answer.toString();

	}

	private static String try_and_error_1(String number, int k) {
		// 최악의 경우
		// 앞에서 1개만 제거되고 다시 k-1개에 대해 중복계산이 이루어진다
		// 1. 오름차순 순서로 되어 있어서 1개씩 제거되는 경우
		// 1111111111112, k=1
		// 2. 내림차순 순서로 되어 있어서 1개씩 제거되는 경우
		// 9999999999991, k=1

		StringBuilder sb = new StringBuilder();
		// 1. 앞에서 k+1 개 중에 가장 큰 수를 찾는다
		int max = 0;
		int maxIdx = -1;
		int startIdx = 0;
		int num = 0;
		while (k != 0) {
			// 2. 남은 개수와 k가 같다면 maxIdx를 number.length로 바꿔준다
			if (startIdx + k == number.length()) {
				maxIdx = number.length();
				break;
			}
			max = 0;
			for (int i = startIdx, j = 0; j <= k; i++, j++) {
				num = (int) number.charAt(i);
				if (num == 9) {
					max = 9;
					maxIdx = i;
					break;
				} else if (max < num) {
					max = num;
					maxIdx = i;
				}
			}
			sb.append((char) max);
			k -= maxIdx - startIdx;
			startIdx = maxIdx + 1;
		}

		for (int i = maxIdx + 1; i < number.length(); i++) {
			sb.append(number.charAt(i));
		}

		return sb.toString();

	}

}