import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution_Level_2_1차_뉴스클러스터링 {

	// test
	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french")); // 16384
		System.out.println(solution("handshake", "shake hands"));// 65536
		System.out.println(solution("aa1+aa2", "AAAA12"));// 43690
		System.out.println(solution("E=M*C^2", "e=m*c^2"));// 65536
	}

	public static int solution(String str1, String str2) {

		J j = new J(str1.toLowerCase().toCharArray(), str2.toLowerCase().toCharArray());
		return j.score();

	}

	static class J {
		Map<String, Integer> A, B, Intersect, Union;
		double score;

		public J() {
			// TODO Auto-generated constructor stub
		}

		public J(char[] c1, char[] c2) {
			A = new HashMap<>();
			B = new HashMap<>();
			for (int i = 0; i < c1.length - 1; i++) {
				if (Character.isLowerCase(c1[i]) && Character.isLowerCase(c1[i + 1])) {
					String sub = String.copyValueOf(c1, i, 2);
					A.put(sub, A.getOrDefault(sub, 0) + 1);
				}
			}
			for (int i = 0; i < c2.length - 1; i++) {
				if (Character.isLowerCase(c2[i]) && Character.isLowerCase(c2[i + 1])) {
					String sub = String.copyValueOf(c2, i, 2);
					B.put(sub, B.getOrDefault(sub, 0) + 1);
				}
			}
			
			if(A.size() == 0 && B.size() == 0) {
				this.score = 1;
			} else {
				inner();				
			}

		}

		public void inner() {

			Intersect = new HashMap<>();
			Union = new HashMap<>();

			for (Entry<String, Integer> entry : A.entrySet()) {
				Union.put(entry.getKey(), entry.getValue());
			}

			for (Entry<String, Integer> entry : B.entrySet()) {
				Intersect.put(entry.getKey(), Math.min(A.getOrDefault(entry.getKey(), 0), entry.getValue()));
				Union.put(entry.getKey(), Math.max(A.getOrDefault(entry.getKey(), 0), entry.getValue()));
			}

			int intersect = Intersect.values().stream().mapToInt(Integer::intValue).sum();
			int union = Union.values().stream().mapToInt(Integer::intValue).sum();
			score = intersect / (double) union;

		}

		public int score() {
			return (int) (this.score * 65536);
		}

	}

}

// stream 모범답안 programmers 최석현 , 최광순 
/*
class Solution {
    private static final Integer MULTIPLIER = Character.MAX_VALUE + 1;

    public int solution(String str1, String str2) {
        String word1 = str1.toLowerCase();
        String word2 = str2.toLowerCase();

        Map<String, Long> words1 = group(word1);
        Map<String, Long> words2 = group(word2);

        Integer intersection = getIntersection(words1, words2);
        Integer union = getUnion(words1, words2);

        if (intersection.equals(union) && union.equals(0)) {
            return MULTIPLIER;
        }

        return (int) (intersection.doubleValue() / union.doubleValue() * MULTIPLIER);
    }

    private Map<String, Long> group(String word) {
        return IntStream.range(0, word.length() - 1)
                .mapToObj(index -> word.substring(index, index + 2))
                .filter(text -> text.chars().allMatch(character -> Character.isAlphabetic((char) character)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Integer getIntersection(Map<String, Long> words1, Map<String, Long> words2) {
        return words1.entrySet().stream()
                .filter(entry -> words2.containsKey(entry.getKey()))
                .map(entry -> Math.min(entry.getValue(), words2.get(entry.getKey())))
                .mapToInt(Long::intValue)
                .sum();
    }

    private Integer getUnion(Map<String, Long> words1, Map<String, Long> words2) {
        Map<String, Long> copiedWords = new HashMap<>(words2);
        words1.forEach((key, value) -> copiedWords.put(key, Math.max(value, words2.getOrDefault(key, 0L))));

        return copiedWords.values().stream()
                .mapToInt(Long::intValue)
                .sum();

    }
}
*/