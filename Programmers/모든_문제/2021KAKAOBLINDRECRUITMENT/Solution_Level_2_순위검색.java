import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution_Level_2_순위검색 {
	
	// https://programmers.co.kr/learn/courses/30/lessons/72412
	// 프로그래머스 다른 사람의 풀이 중 SonDongGyu 님의 풀이를 보았을 때 더 빠르게 바꿀 수 있는 개선점이 2개 보인다 
	// 현재 코드에서 char를 그대로 쓰지 않고 '-' 역시 무시하고 0,1,2로 바꾸는 것이 첫번째
	// 다음은 map을 사용하지 않고 ArrayList<>[][][][] 배열을 사용하는 것이 두번째로 
	// 두 가지를 모두 적용하면 현재 평균 850ms인 효율성 테스트 시간이 절반으로 줄어들 것이다. 

	// test
	public static void main(String[] args) {
		String[] info = {
				  "java 		backend 		junior 		pizza 	150"
				, "python 		frontend 		senior 		chicken 210"
				, "python 		frontend 		senior 		chicken 150"
				, "cpp 			backend 		senior 		pizza 	260"
				, "java 		backend 		junior 		chicken 80"
				, "python		backend 		senior 		chicken 50" 
		};
		String[] query = { 
				  "java 	and backend 	and junior 	and pizza 	100"
				, "python 	and frontend 	and senior 	and chicken 200"
				, "cpp 		and - 			and senior 	and pizza 	250"
				, "- 		and backend 	and senior 	and - 		150"
				, "- 		and - 			and - 		and chicken 100"
				, "- 		and - 			and - 		and - 		150" 
		};
		System.out.println(Arrays.toString(solution(info, query))); // 1,1,1,1,2,4

	}
	
	static StringBuilder sb;
	static String key;
	
	public static int[] solution(String[] info, String[] query) {
		Map<String, List<Integer>> scores = new HashMap<>();		
		char[] k1 = {'j', 'p', 'c', '-'};
		char[] k2 = {'b', 'f', '-'};
		char[] k3 = {'j', 's', '-'};
		char[] k4 = {'p', 'c', '-'};
		for(char c1 : k1) {
			for (char c2 : k2) {
				for (char c3 : k3) {
					for(char c4 : k4) {
						sb = new StringBuilder();
						key = sb.append(c1).append(c2).append(c3).append(c4).toString();
						scores.put(key, new ArrayList<Integer>());
					}
				}
			}
		}
		
		for (String i : info) {
			sb = new StringBuilder();
			String[] ii = i.split(" ");
			
			addScoreToCombination(scores, new char[] {ii[0].charAt(0), '-'}
										, new char[] {ii[1].charAt(0), '-'}
										, new char[] {ii[2].charAt(0), '-'}
										, new char[] {ii[3].charAt(0), '-'}
										, Integer.parseInt(ii[4]));			
			
		}
		// 4*3*3*3 = 108개 * 정렬 n log n
		scores.forEach((k,v) ->  {
			Collections.sort(v, Collections.reverseOrder());
		});
		
		int[] ret = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			RegexCondition rc = new RegexCondition(query[i]);
			ret[i] = binarySearch(scores.get(rc.key), rc.score);
		}
		return ret;	
	}

	// 10만 * log n
	private static int binarySearch(List<Integer> list, int score) {
		
		if(list.size() == 0) {
			return 0;
		}
		int left = 0;
		int right = list.size() - 1;  
		if(score <= list.get(right)) {
			return list.size(); 
		}
		
		while(left < right) {
			int mid = (left + right)/2;
			if(list.get(mid) < score) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
		
	}

	// 5만 * 100회 = 500만
	private static void addScoreToCombination(Map<String, List<Integer>> scores, char[] k1, char[] k2, char[] k3, char[] k4, int score) {		
		for (char c1 : k1) {
			for (char c2 : k2) {
				for (char c3 : k3) {
					for (char c4 : k4) {
						sb = new StringBuilder();
						key = sb.append(c1).append(c2).append(c3).append(c4).toString();
						scores.get(key).add(score);
					}
				}
			}
		}
	}
	
	static class RegexCondition {
		String key;
		int score;
		
		public RegexCondition() {
			// TODO Auto-generated constructor stub
		}
		
		public RegexCondition(String query) {
			String[] columns = query.split(" ");
			StringBuilder sb = new StringBuilder();
			sb.append(columns[0].charAt(0));
			sb.append(columns[2].charAt(0));
			sb.append(columns[4].charAt(0));
			sb.append(columns[6].charAt(0));
			this.key = sb.toString();
			this.score = Integer.parseInt(columns[7]);			
		}
	}
	
}

class SecondTry_TimeOver {

	// 5만 * 10만 = 50억 ... 시간 초과
	public static int[] solution(String[] info, String[] query) {
		List<Applicant> apply = new LinkedList<>();
		for (String i : info) {
			apply.add(new Applicant(i));
		}
		int[] ret = new int[query.length];
		for (int i=0; i<query.length;i++) {
			RegexCondition rc = new RegexCondition(query[i]);
			ret[i]= apply.parallelStream().filter(x -> x.key.matches(rc.key)).filter(x -> x.score >= rc.score).mapToInt(x->1).sum();
		}
		return ret;		
		
	}
	
	static class Applicant{
		String key;
		int score;
		
		public Applicant() {
			// TODO Auto-generated constructor stub
		}
		public Applicant(String info) {
			String[] infos = info.split(" ");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 4; i++) {
				sb.append(infos[i].charAt(0));
			}
			this.key = sb.toString();
			this.score = Integer.parseInt(infos[4]);
		}
	}
	
	static class RegexCondition {
		String key;
		int score;
		
		public RegexCondition() {
			// TODO Auto-generated constructor stub
		}
		
		public RegexCondition(String query) {
			String[] columns = query.split(" ");
			StringBuilder sb = new StringBuilder();
			sb.append(columns[0].charAt(0));
			sb.append(columns[2].charAt(0));
			sb.append(columns[4].charAt(0));
			sb.append(columns[6].charAt(0));
			this.key = sb.toString().replace('-', '.');
			this.score = Integer.parseInt(columns[7]);			
		}
	}
}

class FirstTry_TimeOver {
	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			String[] condition = query[i].split(" ");
			answer[i] = Arrays.stream(info).filter(k -> compare(k.split(" "), condition)).mapToInt(x -> 1).sum();
		}
		return answer;
	}

	private static boolean compare(String[] k, String[] c) {
		if (c[0].equals("-") || k[0].equals(c[0])) {
			if (c[2].equals("-") || k[1].equals(c[2])) {
				if (c[4].equals("-") || k[2].equals(c[4])) {
					if (c[6].equals("-") || k[3].equals(c[6])) {
						if (Integer.parseInt(k[4]) >= Integer.parseInt(c[7])) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}