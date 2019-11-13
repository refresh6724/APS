import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

map 
47MB 	1757ms

No.1  [Good] : 0.123
No.2  [Good] : 0.252
No.3  [Good] : 0.288
No.4  [Good] : 0.452
No.5  [Good] : 0.543
No.6  [RTE]

map -> array 
42MB 	3610ms 	

No.1  [Good] : 0.125
No.2  [Good] : 0.267
No.3  [Good] : 0.516
No.4  [Good] : 0.615
No.5  [Good] : 0.841
No.6  [Good] : 2.042
No.7  [RTE]

count -> in, out 
40MB 	2479ms

No.1  [Good] : 0.134
No.2  [Good] : 0.257
No.3  [Good] : 0.278
No.4  [Good] : 0.384
No.5  [Good] : 0.456
No.6  [Good] : 1.284
No.7  [RTE]

scanner -> buffered reader
18MB 	836ms

No.1  [Good] : 0.087
No.2  [Good] : 0.113
No.3  [Good] : 0.111
No.4  [Good] : 0.142
No.5  [Good] : 0.163
No.6  [Good] : 0.349
No.7  [Good] : 0.603
No.8  [Good] : 0.805
No.9  [Good] : 0.830
No.10 [Good] : 0.837

 */

public class Main_JO_2572_회전초밥_중 { // 제출일 2019-11-13 13:51
	
	static int N; // 초밥접시 300만
	static int d; // 초밥종류 3000
	static int k; // 연속해서 3000
	static int c; // 쿠폰번호 1tod
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
		// 두 가지 조건
		// 1. 쿠폰에 해당하는 초밥이 있는 경우 / 없는 경우
		// 2. 그 초밥을 먹어야 가장 긴 경우 / 아닌 경우
		// 300만 라인이므로 입력과 동시에 누적해서 처리해야하며 
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int max = 0;
		
		// k-1개를 큐에 넣고 가장 마지막에 추가해서 계산
		Queue<Integer> last = new LinkedList<Integer>();
		Queue<Integer> threethousand = new LinkedList<Integer>();
		
		// map 시간 초과
		// 해당 인덱스까지의 숫자 개수 누적 합을 맵에 번호, 개수로 저장한다
		//HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// 
		int[] dd = new int[d+1]; // 초밥의 가짓수에 따라 
		
		
		int num = 0;
		int in = 0;
		int out = 0;
		// k 개를 넣어준다
		for (int i = 0; i < k; i++) {
			in = Integer.parseInt(br.readLine());
			last.add(in);
			threethousand.add(in);			
			
//			if(map.containsKey(num)){
//				map.put(num, map.get(num)+1);
//			} else {
//				map.put(num, 1);
//			}
			
			dd[in]++;			
		}
		
		num = count(dd);
		
		// 먼저 다음 수를 넣고 k 첫수를 빼고 개수를 계산하고 
		for (int i = k; i < N; i++) {
			in = Integer.parseInt(br.readLine());
			threethousand.add(in);
			
//			if(map.containsKey(num)){
//				map.put(num, map.get(num)+1);
//			} else {
//				map.put(num, 1);
//			}
			if(dd[in]++==0) num++;
			
			out = threethousand.poll();
//			if(map.get(num) == 1){
//				map.remove(num);
//			} else {
//				map.put(num, map.get(num)-1);
//			}
			
			if(--dd[out]==0) num--;
			
//			if(map.containsKey(c)) {
//				num = map.size()-1;
//			} else {
//				num = map.size();				
//			}
						
			if(dd[c] != 0) {
				max = num-1>max?num-1:max;		
			} else {
				max = num>max?num:max;	
			}
		}
		
		// 이제 처음 k개를 다시 계산
		for (int i = 0; i < k; i++) {
			in = last.poll();
			threethousand.add(in);
			
//			if(map.containsKey(num)){
//				map.put(num, map.get(num)+1);
//			} else {
//				map.put(num, 1);
//			}
			
			if(dd[in]++==0) num++;
			
			out = threethousand.poll();
//			if(map.get(num) == 1){
//				map.remove(num);
//			} else {
//				map.put(num, map.get(num)-1);
//			}
			
			if(--dd[out]==0) num--;
			
//			if(map.containsKey(c)) {
//				num = map.size()-1;
//			} else {
//				num = map.size();				
//			}
			
			if(dd[c] != 0) {
				max = num-1>max?num-1:max;		
			} else {
				max = num>max?num:max;	
			}		
		}
		
		System.out.println(max+1);
	}


	private static int count(int[] dd) {
		int a = 0;
		for (int i = 1; i <= d; i++) {
			if(dd[i] > 0) a++;
		}
		return a;
	}

}
