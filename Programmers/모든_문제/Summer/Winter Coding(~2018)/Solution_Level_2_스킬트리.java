import java.util.HashSet;
import java.util.Set;

public class Solution_Level_2_스킬트리 { // 제출일 2020-09-27 23:13

	// test
	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" })); // 2
	}

	public static int solution(String skill, String[] skill_trees) {
		
		// skill은 26자 이하 중복 문자 없음
		// skill trees는 각 26자 이하 길이 20 이하
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < skill.length(); i++) {
			set.add(skill.charAt(i));		
		}
		int fail = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			int idx = 0;
			for (int j = 0; j < skill_trees[i].length(); j++) {
				if(set.contains(skill_trees[i].charAt(j))){
					if(skill.charAt(idx++) != skill_trees[i].charAt(j)) {
						fail++;
						break;
					}
				}
			}
		}	
		
		return skill_trees.length - fail;
	}

}