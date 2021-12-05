import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution_Level_2_1차_캐시 {

	// https://programmers.co.kr/learn/courses/30/lessons/17680
	// 다른 사람의 풀이 중에 LinkedHashMap을 사용한 풀이가 깔끔하고 좋음
	// test
	public static void main(String[] args) {
		String[] cities;
		cities = new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
		System.out.println(solution(3, cities)); // 50
		cities = new String[] { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };
		System.out.println(solution(3, cities)); // 21
		cities = new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" };
		System.out.println(solution(2, cities)); // 60
		cities = new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" };
		System.out.println(solution(5, cities)); // 52
		cities = new String[] { "Jeju", "Pangyo", "NewYork", "newyork" };
		System.out.println(solution(2, cities)); // 16
		cities = new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
		System.out.println(solution(0, cities)); // 25
	}

	// LRU (Least Recently Used) 알고리즘
	public static int solution(int cacheSize, String[] cities) {
		if(cacheSize == 0) {
			return cities.length * 5;
		}
		// 캐시에 입력된 순서를 저장할 큐
		Queue<String> q = new LinkedList<>();		
		// 캐시에 입력된 자료를 저장할 맵
		Set<String> set = new HashSet<>();
		
		set.add("city");
		q.add("city");
		int answer = 0;
		for(String city : cities) {
			city = city.toLowerCase();
			if(set.contains(city)) {
				q.remove(city);
				q.add(city);				
				answer++;
			} else {				
				set.add(city);
				q.add(city);
				if(q.size() > cacheSize) {
					set.remove(q.poll());					
				}
				answer += 5;
			}
		}		
		return answer;
	}
}