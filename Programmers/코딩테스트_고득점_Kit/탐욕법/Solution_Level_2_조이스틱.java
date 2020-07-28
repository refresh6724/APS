public class Solution_Level_2_조이스틱 { // 제출일 2020-07-28 22:00

	public static int solution(String name) {
//		int answer = 0;
		int UD = 0;
		// 상하 이동 횟수는 고정되어 있다
		// A는 0 B와 Z는 1 C와 Y는 2 ...
		// 이를 그래프로 그려보면 수식을 쉽게 확인할 수 있다.
		// BCDEFGHIJKLMN
		// ZYXWVUTSRQPO
		// B~N까지는 y = x-'A' 를 따라가고
		// O~Z까지는 y = |x-'A'-26| = 26 - (x-'A')이다.

		int len = name.length();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			if (name.charAt(i) >= 'O') {
				arr[i] = 26 - (name.charAt(i) - 'A');
			} else {
				arr[i] = name.charAt(i) - 'A';
			}
		}

		// 이제 name 배열은 3 0 2 2 5 1 6 과 같은 숫자 배열이 되고
		// 좌우 이동 횟수는 첫글자 이후 이동 거리에 달려있다

		int hasA = len; // A가 아닌 알파벳 개수
		for (int i = 0; i < len; i++) {
			if (arr[i] == 0) {
				hasA--; // AAA 면 3에서 3이 빠져 0이 된다
			}
			UD += arr[i];
		}

//		System.out.println("상하 : " + UD);
		
		
		int LR = 0;

		int[] cArr = new int[len << 1];
		for (int i = 0; i < len; i++) {
			cArr[i] = arr[i];
		}
		for (int i = len; i < (len << 1); i++) {
			cArr[i] = arr[i - len];
		}

		// 각 위치에서 출발해 끝날때 까지 좌우로 얼마나 이동하는지 체크
		int[] rDistance = new int[len];
		int[] lDistance = new int[len];
		for (int i = 0; i < len; i++) {
			// 최소 이동거리
			if (i > (len >> 1)) {
				rDistance[i] = len - i;
				lDistance[i] = len - i;
			} else {
				rDistance[i] = i;
				lDistance[i] = i;
			}
			// 추가 거리
			int add = 0;
			int ha = hasA;
			for (int j = i; j < (len << 1); j++, add++) {
				if (cArr[j] != 0) {
					ha--;
				}
				if (ha == 0) {
					if (j == len) {
						add--;
					}
					break;
				}
			}
			rDistance[i] += add;

			add = 0;
			ha = hasA;
			for (int j = len + i; j > 0; j--, add++) {
				if (cArr[j] != 0) {
					ha--;
				}
				if (ha == 0) {
					if (j == len) {
						add--;
					}
					break;
				}
			}
			lDistance[i] += add;

		}
		LR = 100;
		for (int i = 0; i < len; i++) {
			LR = Math.min(LR, rDistance[i]);
			LR = Math.min(LR, lDistance[i]);
		}

//		System.out.println("좌우 : " + LR);
		
		return UD + LR;
	}

//	public static void main(String[] args) {		
//		System.out.println(solution("A")); // 상하 0 좌우 0 정답 0
//		System.out.println(solution("AA")); // 상하 0 좌우 0 정답 0
//		System.out.println(solution("AAA")); // 상하 0 좌우 0 정답 0
//		System.out.println(solution("ZAA")); // 상하 1 좌우 0 정답 1
//		System.out.println(solution("AAZ")); // 상하 1 좌우 1 정답 2		
//		System.out.println(solution("ZZZ")); // 상하 3 좌우 2 정답 5
//		System.out.println(solution("JAN")); // 상하 22 좌우 1 정답 23		
//		System.out.println(solution("AAB")); // 상하 1  좌우 1 정답 2
//		System.out.println(solution("AAAA")); // 상하 0 좌우 0 정답 0		
//		System.out.println(solution("BBABA")); // 상하 3 좌우 3 정답 6
//		System.out.println(solution("BBBAAB")); // 상하 4 좌우 4 정답 8
//		System.out.println(solution("AJAJAA")); // 상하 18  좌우 3 정답 21
//		System.out.println(solution("JEROEN")); // 상하 51 좌우 5 정답 56
//		System.out.println(solution("BBAABBB")); // 상하 5 좌우 5 정답 10
//		System.out.println(solution("BBAABAA")); // 상하  좌우  정답 7
//		System.out.println(solution("BAABAAA")); // 상하 2 좌우 3 정답 5
//		System.out.println(solution("BBAAAAA")); // 상하  좌우  정답 3
//		System.out.println(solution("BBAABAAAA")); // 상하  좌우  정답 7
//		System.out.println(solution("BBBBAAAAB")); // 상하5 좌우5 정답 10
//		System.out.println(solution("BBAABAAAAB")); // 상하  좌우  정답 10
//		System.out.println(solution("BBBBAAAAAB")); // 상하  좌우  정답 10
//		System.out.println(solution("BBBBAAAABA")); // 상하  좌우  정답 12
//		System.out.println(solution("BBBBBBBABB")); // 상하  좌우  정답 18
//		System.out.println(solution("BABABAAAABA")); // 상하 4 좌우 8 정답 12
//		System.out.println(solution("ABAAAAAAABA")); // 상하  좌우  정답 6
//		System.out.println(solution("CANAAAAANAN")); // 상하  좌우  정답 48
//		System.out.println(solution("AABAAAAAAABBB")); // 상하  좌우  정답 11
//		System.out.println(solution("ABABAAAAAAABA")); // 상하  좌우  정답 10
//		System.out.println(solution("JJAJAAAAAAAAAJ")); // 상하  좌우  정답 41
//		System.out.println(solution("AAAAACANAAAAANANAAAAAA")); // 상하  좌우  정답 56		
//	}	

}