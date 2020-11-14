import java.util.Arrays;
import java.util.Comparator;

class Solution_1 {
	
	public static void main(String[] args) {
		// n번째 글자를 기준으로 정렬하기
		System.out.println(Arrays.toString(solution(new String[] {"sun", "bed", "car"},1)));
		System.out.println(Arrays.toString(solution(new String[] {"ccd", "ccc", "cc", "ccb"},1)));
	}
	
	
	public static String[] solution(String[] strings, int n) {
		Arrays.parallelSort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n) == o2.charAt(n)) {
					int idx = 0;
					
					while(idx < o1.length() && idx < o2.length() && o1.charAt(idx) == o2.charAt(idx)) {						
						idx++;
					}					
					
					if(o1.length() == idx) {
						return -1;
					}
					
					if(o2.length() == idx) {
						return 1;
					}
					
					if(o1.charAt(idx) != o2.charAt(idx)) {
						return o1.charAt(idx) - o2.charAt(idx);
					}
					// 완전히 같다면
					return 0;
				}
				return o1.charAt(n) - o2.charAt(n);
			}
		});
		
		return strings;
//		ArrayList<String> li = new ArrayList<>();
//		li.add("ab");
//		li.add("bcd");		
//		return li.toArray(new String[] {});
	}
	
}