import java.util.Arrays;

public class Solution_Level_1_완주하지못한선수 { // 제출일 2020-07-29 23:12 
    public String solution(String[] participant, String[] completion) {
                
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        String answer = "";
        boolean find = false;
		for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				answer = participant[i];
				find = true;
				break;
			}
		}
		if (!find)
			answer = participant[completion.length];
        return answer;
    }
}