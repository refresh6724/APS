public class Solution_Level_2_큰수만들기 { // 제출일 2020-08-13 23:05

	/*
	 * 테스트케이스 10번에서 7초가 넘게 걸린다
	 */
	
	public static String solution(String number, int k) {

		// 어떤 숫자에서 k개의 수를 제거했을때 가장 큰 수 = 이상적으로 내림차순일 경우
		// nCk 경우의 수
		// n : 1 이상 1백만 자리 이하 숫자
		// k : 1 이상 number 자릿수 미만 자연수
				
		StringBuilder sb = new StringBuilder();
		// 1. 앞에서 k+1 개 중에 가장 큰 수를 찾는다
		int max = 0;
		int maxIdx = -1;
		int startIdx = 0;
		int num = 0;
		while(k != 0) {
			// 남은 개수와 k가 같다면 maxIdx를 number.length로 바꿔준다
			if(startIdx + k == number.length()) {
				maxIdx = number.length();
				break;
			}
			max = 0;			
			for (int i = startIdx, j = 0; j <= k ; i++, j++) {
				num = (int) number.charAt(i);
				if(num == 9) {
					max = 9;
					maxIdx = i;
					break;
				}else if(max < num) {
					max = num;
					maxIdx = i;
				}
			}
			sb.append((char)max);
			k -= maxIdx-startIdx;
			startIdx = maxIdx+1;
		}
		
		for (int i = maxIdx+1; i < number.length(); i++) {
			sb.append(number.charAt(i));
		}
				
		return sb.toString();
	}

}