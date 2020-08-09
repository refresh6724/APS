import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution_Level_4_단어퍼즐 { // 제출일 2020-08-09 23:20
	
	// test
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "ba", "na", "n", "a" }, "banana")); // 3
		System.out.println(solution(new String[] { "app", "ap", "p", "l", "e", "ple", "pp" }, "apple")); // 2
		System.out.println(solution(new String[] { "ba", "an", "nan", "ban", "n" }, "banana")); // -1
	}

	public static int solution(String[] strs, String t) {
		// 단어 조각은 최대 100개
		// 각 단어 조각의 길이는 최대 5
		// 완성 단어의 길이는 최대 2만

		// try_and_error_1();
		// try_and_error_2(strs, t);
		// return try_and_error_3(strs, t);
		return try_and_error_4(strs, t);		
	}

	private static void try_and_error_1() {
		// 입력된 t 문자에서 strs 에 해당되는 문자를 빼서 두개로 divide
		// 각 부분이 만들기가 가능하다면 최솟값을 리턴
		
		// 1번 예제
		// banana , 정렬 "a", "ba", "n", "na"
		// 1-1 
		// b != a 
		// 첫번째 a를 지우고 "b"와 "nana"로 divide
		// "b"를 만들 수 없으므로 fail => answer = -1
		// 두번째 a를 지우고 "ban" 과 "na"로 divide
		// "ban" 을 "ba"와 "n"으로 만들 수 있고
		// "na" 도 만들 수 있다
		// "na"는 "na" 하나와 "n" + "a" 가 있으므로 dp를 써야한다
		// answer => 4
		// 세번째 a를 지우고 "banan" => 4
		// 이 방법은 너무 오래걸린다
		
	}
	private static void try_and_error_2(String[] strs, String t) {
		
		int len = t.length();
		int[][] puzzle = new int[len+1][len+1];
		for (int i = 0; i < len; i++) {
			Arrays.fill(puzzle[i], 20001); // 완성 단어 길이가 최대 2만이므로 불가능한 숫자를 설정
		}
		for (String str : strs) {
			for (int idx = 0; idx + str.length() < len; idx++) {
				if(str.equals(t.substring(idx, idx+str.length()))) {
					// 하나의 단어 조각으로 idx 부터 idx+str.length()-1 까지 채울 수 있다
					puzzle[idx][idx+str.length()] = 1; 
				}
			}
		}					
				
		// 이를 종이에 써보면 다음과 같이 변환되는데
		// |b|a|n|a|n|a|
		//  -1- -1- -1-
		//  0 1 1 1 1 1
		// 최단거리 그래프 문제로 바꿔서
		// 모든 edge의 가중치가 1인 방향 그래프가 되므로
		// 다음과 같이 7 * 7 인접행렬로 쓸 수 있다
		// 
		// \ 0 1 2 3 4 5 6
		// 0 \   1
		// 1   \ 1
		// 2     \ 1 1
		// 3       \ 1
		// 4         \ 1 1
		// 5           \ 1
		// 6             \
		//
		
		// 20000 * 20000 = 4억, 4byte = 약 1GB
		// 시간 초과 & 메모리 초과
		
	}
	
	private static int try_and_error_3(String[] strs, String t) {
		// 음수 가중치가 없으므로 다익스트라 알고리즘을 사용해 0에서 6까지 가는 최단거리를 구하자
		int len = t.length();
		int V = len+1;
		int startIdx = 0;
		List<List<Node>> adj = new ArrayList<List<Node>>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Node>());
		}
		for (String str : strs) {
			for (int idx = 0; idx + str.length() < V; idx++) {
				if(str.equals(t.substring(idx, idx+str.length()))) {
					adj.get(idx).add(new Node(idx+str.length(), 1));
					// 다익스트라가 한 정점에서 모든 정점으로의 최단 거리를 재는 알고리즘이라서 
					// 도달 불가능 점이 있으면 제대로 돌아가지 않는다
				}
				// else {
					// 도달 불가능한 점을 없애기 위해 infinity weight을 추가해준다
					// 이거 추가하는걸로는 모자란듯 
					// 전 경로를 커버하기 위해서는 인접 행렬로 바꿔야하고
					// 20000 * 20000 = 4억, 4byte = 약 1GB
					// 시간 초과 & 메모리 초과
					//adj.get(idx).add(new Node(idx+str.length(), 20001));
				//}
			}
		}
		
		// 도달 불가능한 점을 없애기 위해
		// 위에 추가하면 안되고 0에서 모든 점으로 이어지는 infinity weight을 추가해준다
		for (int i = 0; i < V; i++) {
			adj.get(0).add(new Node(i, 20001));
		}
		
		// 이론적으로는 가능하지만 4번 BFS보다 매우 느리다 
		// 아마 O(n^2) 이었던 것 같은데  시간초과가 나온다
		DijkstraUsingPriorityQueue dpq = new DijkstraUsingPriorityQueue(V);
		dpq.dijkstra(adj, startIdx);
	
		return (dpq.distance[len]>=20000)?-1:dpq.distance[len]; 
	}
	
	private static int try_and_error_4(String[] strs, String t) {
		
		// BFS 방식으로 계산한다면?
		// O(|V|+|E|) V : 최대 2만 , E : 각 조각 최대 길이와 개수 제한으로 약 10만 예상
		
		int len = t.length();
		int V = len+1;
		
		List<List<Node>> adj = new ArrayList<List<Node>>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Node>());
		}
		for (String str : strs) {
			for (int idx = 0; idx + str.length() < V; idx++) {
				if(str.equals(t.substring(idx, idx+str.length()))) {
					adj.get(idx).add(new Node(idx+str.length(), 1));
				} 
			}
		}
		
		// BFS
		int[] distance = new int[V];
		Arrays.fill(distance, -1);
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		distance[0] = 0;
		int arrive = 0;
		while(!q.isEmpty()) {
			arrive = q.poll();
			for (Node node : adj.get(arrive)) {
				int next = node.vertex;
				if(distance[next] == -1) {
					distance[next] = distance[arrive] +1;
					if(next == len) {
						return distance[next];
					}
					q.add(next);
				}
			}
		}		
		return -1;
	}
	
}

class DijkstraUsingPriorityQueue {
	public int[] distance;
	private Set<Integer> settled;
	private PriorityQueue<Node> pq;
	private int vertices;
	List<List<Node>> adjacencyList;
	
	public DijkstraUsingPriorityQueue() {
	}
	public DijkstraUsingPriorityQueue(int V) {
		this.vertices = V;
		distance = new int[V];
		settled = new HashSet<Integer>();
		pq = new PriorityQueue<Node>(V, new Node());
	}
	
	public void dijkstra(List<List<Node>> adj, int src) {
		this.adjacencyList = adj;
		for (int i = 0; i < vertices; i++) {
			distance[i]= Integer.MAX_VALUE;
		}
		pq.add(new Node(src, 0)); // 0에서 0으로 가는 0 가중치의 노드 추가
		distance[src]= 0;
		while(settled.size() != vertices) {
			int minV = pq.remove().vertex;
			settled.add(minV);
			visitNeighbors(minV);
		}			
	}
	private void visitNeighbors(int minV) {
		int edgeDistance = -1;
		int newDistance = -1;
		
		for(Node node : adjacencyList.get(minV)) {
			if(!settled.contains(node.vertex)) {
				edgeDistance = node.weight;
				newDistance = distance[minV] + edgeDistance;
				
				if(distance[node.vertex] > newDistance) {
					distance[node.vertex] = newDistance;
				}
				
				pq.add(new Node(node.vertex, distance[node.vertex]));
			}
		}			
	}
}

class Node implements Comparator<Node> { 
    public int vertex; 
    public int weight; 
  
    public Node() 
    { 
    } 
  
    public Node(int vertex, int weight) 
    { 
        this.vertex = vertex; 
        this.weight = weight; 
    } 
  
    @Override
    public int compare(Node o1, Node o2) 
    { 
        if (o1.weight < o2.weight) 
            return -1; 
        if (o1.weight > o2.weight) // 오름차순 
            return 1; 
        return 0; // 같으면 바꾸지 않는다
    } 
} 