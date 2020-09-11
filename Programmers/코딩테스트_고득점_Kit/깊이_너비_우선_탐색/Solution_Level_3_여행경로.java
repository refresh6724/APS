import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class Solution_Level_3_여행경로 { // 제출일 2020-09-11 23:26

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } })));
		// [ICN, JFK, HND, IAD]
		System.out.println(Arrays.toString(solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } })));
		// [ICN, ATL, ICN, SFO, ATL, SFO]
	}

	static int len;
	static boolean find;
	static boolean[] used;
	static Deque<String> dq;
	
	public static String[] solution(String[][] tickets) {
		// 조건 1 공항은 알파벳 3글자
		// 조건 2 공항은 3개 이상 1만개 이하
		// 조건 3 주어진 항공권은 모두 사용해야한다
		// 조건 4 가능한 경로가 2개 이상이면 알파벳 순서대로

		// 풀이 전략
		// 주어진 티켓을 사전순으로 정렬

		Arrays.parallelSort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if (o1[0].charAt(0) == o2[0].charAt(0)) {
					if (o1[0].charAt(1) == o2[0].charAt(1)) {
						if (o1[0].charAt(2) == o2[0].charAt(2)) {
							if (o1[1].charAt(0) == o2[1].charAt(0)) {
								if (o1[1].charAt(1) == o2[1].charAt(1)) {
//									if (o1[1].charAt(2) == o2[1].charAt(2)) {
//										return 0;
//									}
									return o1[1].charAt(2) - o2[1].charAt(2);
								}
								return o1[1].charAt(1) - o2[1].charAt(1);
							}
							return o1[1].charAt(0) - o2[1].charAt(0);
						}
						return o1[0].charAt(2) - o2[0].charAt(2);
					}
					return o1[0].charAt(1) - o2[0].charAt(1);
				}
				return o1[0].charAt(0) - o2[0].charAt(0);
			}
		});

		dq = new LinkedList<>();
		dq.add("ICN");
		len = tickets.length;
		find = false;
		used = new boolean[len];		
		dfs(tickets, "ICN", 0);		
		return dq.stream().toArray(String[]::new);
	}

	private static void dfs(String[][] tickets, String now, int cnt) {
		
		if(cnt == len) {
			find = true;
			return;
		}
		
		for (int next = 0; next < tickets.length; next++) {
			if(!used[next] && now.equals(tickets[next][0])) {
				used[next] = true;
				dq.add(tickets[next][1]);
				dfs(tickets, tickets[next][1], cnt+1);
				if(find) {
					return;					
				}
				used[next]= false;
				dq.removeLast();				
			}
		}		
	}
	

}