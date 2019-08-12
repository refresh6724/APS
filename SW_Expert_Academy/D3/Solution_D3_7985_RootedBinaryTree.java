import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_7985_RootedBinaryTree { // 제출일 2019-08-13 02:25

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	static StringTokenizer st = null; 	
	static StringBuilder sb = new StringBuilder();
	static String[] str = new String[1025];
	static int[] num = new int[1025];
	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc);
			int K = Integer.parseInt(br.readLine());
			// 1<<K -1개 원소
			str = br.readLine().split(" ");
//			System.out.println(Arrays.toString(str));
			for (int i = 1; i < (1<<K); i++) {
				num[i] = Integer.parseInt(str[i-1]);
			}
//			System.out.println(Arrays.toString(num));
			
			// 재귀 형태
			// 1<<i -1번째일때 \n을 하나씩 넣어야함		
			
			// 1<<(K-1) -1 번째 인덱스를 출력
			// 해당 인덱스를 큐에 삽입 
			// 엔터
			// 큐를 꺼내고 좌, 우 출력
			// 다시 출력후 큐 삽입
			
			// ... 해당 인덱스에서 좌로 1만큼 우로 1만큼 k-(k-1)만큼
			Queue<Integer> queue = new LinkedList<>();
			int idx = (1<<(K-1));//0은 쓰지 않는다
			sb.append(" ").append(num[idx]).append("\n");
			queue.add(idx);
			int k = K-1;
			int print = 0;
			while(!queue.isEmpty() && k!=0) {
				idx = queue.poll();
				
				sb.append(num[idx-(1<<(k-1))]).append(" "); // 4-3+2
				queue.add(idx-(1<<(k-1)));
				print++;
				
				sb.append(num[idx+(1<<(k-1))]).append(" ");			
				queue.add(idx+(1<<(k-1)));		
				print++;
				
				if(print == 1<<(K-k)) {
					k--;					
					print = 0;
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
