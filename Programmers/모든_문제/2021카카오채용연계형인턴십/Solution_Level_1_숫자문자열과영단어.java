// 2021년 05월 08일 카카오 2021년 여름방학 인턴십 코딩테스트
public class Solution_Level_1_숫자문자열과영단어 { // 제출일 2021-07-11 22:49

	// test
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight")); // 1478
		System.out.println(solution("23four5six7")); // 234567
		System.out.println(solution("2three45sixseven")); // 234567
		System.out.println(solution("123")); // 123
	}

	/**
	 * 영단어로 쓰여진 숫자를 0-9로 바꿔서 리턴하기
	 * @param s 길이 1 이상 50 이하, 제로 또는 0으로 시작하는 경우는 없음
	 * @return 1 이상 20억 이하 정수
	 */
	public static int solution(String s) {

		StringBuilder sb = new StringBuilder();

		// zero ze
		// one on
		// two tw
		// three th
		// four fo
		// five fi
		// six si
		// seven se
		// eight ei
		// nine ni

		for (int i = 0; i < s.length();) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				sb.append(s.charAt(i++));
			} else {
				switch (s.charAt(i)) {
				case 'z':
					sb.append(0);
					i += 4;
					break;
				case 'o':
					sb.append(1);
					i += 3;
					break;
				case 't':
					if (s.charAt(i + 1) == 'w') {
						sb.append(2);
						i += 3;
					} else {
						sb.append(3);
						i += 5;
					}
					break;
				case 'f':
					if (s.charAt(i + 1) == 'o') {
						sb.append(4);
						i += 4;
					} else {
						sb.append(5);
						i += 4;
					}
					break;
				case 's':
					if (s.charAt(i + 1) == 'i') {
						sb.append(6);
						i += 3;
					} else {
						sb.append(7);
						i += 5;
					}
					break;
				case 'e':
					sb.append(8);
					i += 5;
					break;
				case 'n':
					sb.append(9);
					i += 4;
					break;
				}
			}
		}

		return Integer.parseInt(sb.toString());

	}

}
