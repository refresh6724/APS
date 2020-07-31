import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_Level_3_베스트앨범 { // 제출일 2020-08-01 00:51
	public static int[] solution(String[] genres, int[] plays) {

		// 예제
		// genres = [classic, pop, classic, classic, pop]
		// plays = [500, 600, 150, 800, 2500]
		// 0. 장르별로 2개씩
		// 1. 속한 노래가 많이 재생된 장르 pop 3100 classic 1450
		// 2. 장르 내에서 많이 재생된 노래를 먼저 4, 1 => 3, 0
		// 3. 같은 횟수면 고유번호가 낮은 순서로

		// 1. 장르를 훑으면서 재생횟수를 같이 해시맵에 넣는다
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			if (map.containsKey(genres[i])) {
				map.put(genres[i], map.get(genres[i]) + plays[i]);
			} else {
				map.put(genres[i], plays[i]);
			}
		}
		// 2. 맵을 재생 횟수 기준으로 정렬한다 pop 3100 classic 1450
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 2-1. PQ로 만들어 넣는다
		for (Map.Entry val : map.entrySet()) {
			pq.add(new Node(val.getKey().toString(), (int) val.getValue()));
		}
		
		// 3. PQ에서 하나씩 꺼내서 first와 second를 찾아 넣는다
		ArrayList<Integer> li = new ArrayList<>();
		
		int fidx, sidx, first, second, tmp;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			fidx = -1;
			sidx = -1;
			first = 0;
			second = 0;
			for (int i = 0; i < genres.length; i++) {	
				if(genres[i].equals(node.key)) { // String 비교에 ==을 쓰지 않도록 주의하자
					if(plays[i] > first) {
						second = first;
						sidx = fidx;
						first = plays[i];
						fidx = i;				
					} else if(plays[i] > second) {
						second = plays[i];
						sidx = i;
					}
				}
			}
			li.add(fidx);
			if(sidx != -1) {
				li.add(sidx);
			}
		}
		
		int[] answer = new int[li.size()];
		int idx = 0;
		for (int i : li) {
			answer[idx++] = i;
		}

		
		return answer;

	}

	static class Node implements Comparable<Node> {
		String key;
		int value;

		public Node() {
		}

		public Node(String key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return o.value - this.value;
		}
	}
	
	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500})));
	}
}