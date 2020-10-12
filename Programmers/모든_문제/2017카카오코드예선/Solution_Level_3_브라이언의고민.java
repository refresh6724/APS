import java.util.ArrayDeque;
import java.util.Random;

public class Solution_Level_3_브라이언의고민 { // 제출일 2020-10-13 06:00

	// test
	public static void main(String[] args) {
//		userTestCase();		
//		userTestCase2();
//		test1();
//		test2();
//		autoTest(); // 반례를 찾다가 자동으로 단어를 생성해 테스트하는 함수를 추가함	
	}

	private static void userTestCase2() {
		System.out.println("위는 valid");
		System.out.println(solution("AaBcCc"));
		System.out.println(solution("aABBBAa"));
		System.out.println(solution("AxAxAxA"));
		System.out.println(solution("dAzBzCd"));
		System.out.println(solution("aHELLOa"));
		System.out.println(solution("HaEaLaLaO"));
		System.out.println(solution("HELLOWORLD"));
		System.out.println(solution("aAbBbBbBbAa"));
		System.out.println(solution("bHaEaLaLaOb"));
		System.out.println(solution("HELLObWORLDb"));
		System.out.println(solution("AAAaBaAbBBBBb"));
		System.out.println(solution("aHELLOabWORLDb"));
		System.out.println(solution("HaELbLOcWOdRLeD"));
		System.out.println(solution("aASBCABabCbSDASD"));
		System.out.println(solution("SpIpGpOpNpGJqOqA"));
		System.out.println(solution("aGbWbFbDakGnWnLk"));
		System.out.println(solution("HaEaLaLaObWORLDb"));
		System.out.println(solution("aAeBeCabABCbcABCc"));
		System.out.println(solution("aAbBbBbBbAacAdBdCc"));
		System.out.println(solution("AaAaAaBaBaBaCCbCbC"));
		System.out.println(solution("aAdBdCabAfBfCbcAeBeCc"));
		System.out.println(solution("zHaEzyLbLyqOcWqxOdRxgLeDg"));
		System.out.println(solution("AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGRvRvRvRvRvR"));
		System.out.println(solution("HaEaLaLaObWORLDbSpIpGpOpNpGJqOqAdGcWcFcDdeGfWfLeoBBoAAAAxAxAxAA"));
		System.out.println("---------------");
		System.out.println("아래는 invalid");
		System.out.println(solution("aCaCa")); // invalid
		System.out.println(solution("aABCabb")); // invalid
		System.out.println(solution("aABCabb")); // invalid
		System.out.println(solution("AxAxAxAx")); // invalid
		System.out.println(solution("asHELLOas")); // invalid
		System.out.println(solution("aABCabABCbcABC")); // invalid
		System.out.println(solution("aAbBbBbBbAabABCb")); // invalid
		System.out.println(solution("aAbBbBbBbAaaABCa")); // invalid
		System.out.println(solution("aAeBeCeabABCbcABCc")); // invalid
		System.out.println(solution("aAbBbBbBbAacAdBdCdc")); // invalid
		System.out.println(solution("aAdBdCabAfBfCbaAeBeCa")); // invalid
	}

	private static void userTestCase() {
		int i = 10;
		System.out.println(i++ + (solution("a").equals("invalid") ? "" : "false")); 
		System.out.println(i++ + (solution("Aa").equals("invalid") ? "" : "false")); 
		System.out.println(i++ + (solution("aA").equals("invalid") ? "" : "false")); 
		System.out.println(i++ + (solution("aaA").equals("invalid") ? "" : "false"));
		System.out.println(i++ + (solution("AaaA").equals("invalid") ? "" : "false"));
		System.out.println(i++ + (solution("aCaCa").equals("invalid") ? "" : "false"));
		System.out.println(i++ + (solution("AabaA").equals("invalid") ? "" : "false"));
		System.out.println(i++ + (solution("TxTxTxbAb").equals("invalid") ? "" : "false")); 
		System.out.println(i++ + (solution("xAaAbAaAx").equals("invalid") ? "" : "false")); 
		System.out.println(i++ + (solution("xBaCbDbEbAaBx").equals("invalid") ? "" : "false"));
		System.out.println(i++ + (solution("AxAxAxAoBoBoB").equals("invalid") ? "" : "false")); 
		System.out.println(i++ + (solution("baHELLOabWORLD").equals("invalid") ? "" : "false"));
		System.out.println(i++ + (solution("aHELLOa bWORLDb").equals("invalid") ? "" : "false"));
		System.out.println(i++ + (solution("zCzbDzDzDbDcEEEc").equals("invalid") ? "" : "false"));
		System.out.println(i++ + (solution("HaEaLaLaOWaOaRaLaD").equals("invalid") ? "" : "false"));
		System.out.println(i++ + (solution("bTxTxTaTxTbkABaCDk").equals("invalid") ? "" : "false"));

		System.out.println(i++ + solution("aAbBbCbDbEbFacGHIJcKLM")); // ABCDEF GHIJ K L M 
		// solution("♚프☆렌☆즈☆레☆이☆싱♚★사전예약★진행중")); // 프렌즈레이싱 사전예약 진행중
		System.out.println(i++ + solution("aABaCDEbFGHIbJKLMcNOc")); // AB C D E FGHI J K L M NO 
		// solution("$지금$예약시♜이모티콘♜100%※증정※")); // 지금 예약시 이모티콘 100% 증정
		System.out.println(i++ + solution("xABCxDEyFGyHzIzJzK")); // ABC D E FG HIJK 
		// solution("★라이언★카트♨전원♨획@득@기@회")); // 라이언 카트 전원 획득기회

	}

	static int wordCount;
	static char[] cs;
	static Random rand;
	static int range;

	private static void autoTest() {
		wordCount = 5;
		cs = new char[1000];
		rand = new Random();
		range = 4;
		dfs(0, 0, 'a', 0);
	}

	private static void dfs(int dsIdx, int csIdx, char ch, int cnt) {
		if (dsIdx == wordCount) {

			// 변수 추가
			int r = rand.nextInt() % 10 + 10;
			cs[r] = 'z';
			cs[r + (r / 2)] = 'z';

			String a = solution(String.copyValueOf(cs, 0, cnt));
			String b = solution2(String.copyValueOf(cs, 0, cnt));
			if (!a.equals(b)) {
				System.out.println(String.copyValueOf(cs, 0, cnt) + " >> 내 풀이 : " + a + ", 다른 풀이 : " + b);
			}
			return;
		}
		rule0(dsIdx, csIdx, ch, cnt);
		rule1(dsIdx, csIdx, ch, cnt);
		rule2(dsIdx, csIdx, ch, cnt);
		rule3(dsIdx, csIdx, ch, cnt);
	}

	private static void rule3(int dsIdx, int csIdx, char ch, int cnt) {
		cs[csIdx] = ch;
		int x = rand.nextInt() % range + range;
		for (int i = 0; i < x; i++) {
			cs[csIdx + 1 + (i * 2)] = 'X';
			cs[csIdx + 2 + (i * 2)] = (char) (ch + 1);
		}
		cs[csIdx + (x * 2)] = ch;
		dfs(dsIdx + 1, csIdx + (x * 2) + 1, (char) (ch + 2), cnt + (x * 2) + 1);
	}

	private static void rule2(int dsIdx, int csIdx, char ch, int cnt) {
		cs[csIdx] = ch;
		int x = rand.nextInt() % range + range;
		for (int i = 0; i < x; i++) {
			cs[csIdx + 1 + i] = 'X';
		}
		cs[csIdx + 1 + x] = ch;
		dfs(dsIdx + 1, csIdx + 2 + x, (char) (ch + 1), cnt + 2 + x);
	}

	private static void rule1(int dsIdx, int csIdx, char ch, int cnt) {
		int x = rand.nextInt() % range + range;
		for (int i = 0; i < x; i++) {
			cs[csIdx + (i * 2)] = 'X';
			cs[csIdx + (i * 2) + 1] = ch;
		}
		cs[csIdx + (x * 2)] = 'X';
		dfs(dsIdx + 1, csIdx + (x * 2) + 1, (char) (ch + 1), cnt + (x * 2) + 1);
	}

	private static void rule0(int dsIdx, int csIdx, char ch, int cnt) {
		int x = rand.nextInt() % range + range;
		for (int i = 0; i < x; i++) {
			cs[csIdx + i] = 'X';
		}
		dfs(dsIdx + 1, csIdx + x, ch, cnt + x);
	}

	private static void test2() {
		// 단어 둘
		System.out.println("-A B-");
		System.out.println(solution("AB")); // AB
		System.out.println(solution("aAaB")); // A B
		System.out.println(solution("AaBa")); // A B
		System.out.println(solution("aAabBb")); // A B

		// 단어 둘
		System.out.println("-A BB-");
		System.out.println(solution("ABB")); // ABB
		System.out.println(solution("ABcB")); // A BB
		System.out.println(solution("aAaBB")); // A BB
		System.out.println(solution("aAaBcB")); // A BB
		System.out.println(solution("AaBBa")); // A BB
		System.out.println(solution("AaBcBa")); // A BB
		System.out.println(solution("aAabBBb")); // A BB
		System.out.println(solution("aAabBcBb")); // A BB

		// 단어 둘
		System.out.println("-A BBB-");
		System.out.println(solution("ABBB")); // ABBB
		System.out.println(solution("ABcBcB")); // A BBB
		System.out.println(solution("aAaBBB")); // A BBB
		System.out.println(solution("aAaBcBcB")); // A BBB
		System.out.println(solution("AaBBBa")); // A BBB
		System.out.println(solution("AaBcBcBa")); // A BBB
		System.out.println(solution("aAabBBBb")); // A BBB
		System.out.println(solution("aAabBcBcBb")); // A BBB

		// 단어 둘
		System.out.println("-AA B-");
		System.out.println(solution("AAB")); // AAB
		System.out.println(solution("AcAB")); // AA B
		System.out.println(solution("aAAaB")); // AA B
		System.out.println(solution("aAcAaB")); // AA B
		System.out.println(solution("AAaBa")); // AA B
		System.out.println(solution("AcAaBa")); // AA B
		System.out.println(solution("aAAabBb")); // AA B
		System.out.println(solution("aAcAabBb")); // AA B

		// 단어 둘
		System.out.println("-AA BB-");
		System.out.println(solution("AABB")); // AABB
		System.out.println(solution("AABcB")); // AABB
		System.out.println(solution("AcABB")); // AA BB
		System.out.println(solution("AcABdB")); // AA BB
		System.out.println(solution("aAAaBB")); // AA BB
		System.out.println(solution("aAAaBcB")); // AA BB
		System.out.println(solution("aAcAaBB")); // AA BB
		System.out.println(solution("aAcAaBdB")); // AA BB
		System.out.println(solution("AAaBBa")); // AA BB
		System.out.println(solution("AAaBcBa")); // AA BB
		System.out.println(solution("AcAaBBa")); // AA BB
		System.out.println(solution("AcAaBdBa")); // AA BB
		System.out.println(solution("aAAabBBb")); // AA BB
		System.out.println(solution("aAAabBcBb")); // AA BB
		System.out.println(solution("aAcAabBBb")); // AA BB
		System.out.println(solution("aAcAabBdBb")); // AA BB

		// 단어 둘
		System.out.println("-AA BBB-");
		System.out.println(solution("AABBB")); // AABBB
		System.out.println(solution("AABdBdB")); // AABBB
		System.out.println(solution("AcABBB")); // AA BBB
		System.out.println(solution("AcABdBdB")); // AA BBB
		System.out.println(solution("aAAaBBB")); // AA BBB
		System.out.println(solution("aAAaBdBdB")); // AA BBB
		System.out.println(solution("aAcAaBBB")); // AA BBB
		System.out.println(solution("aAcAaBdBdB")); // AA BBB
		System.out.println(solution("AAaBBBa")); // AA BBB
		System.out.println(solution("AAaBdBdBa")); // AA BBB
		System.out.println(solution("AcAaBBBa")); // AA BBB
		System.out.println(solution("AcAaBdBdBa")); // AA BBB
		System.out.println(solution("aAAabBBBb")); // AA BBB
		System.out.println(solution("aAAabBdBdBb")); // AA BBB
		System.out.println(solution("aAcAabBBBb")); // AA BBB
		System.out.println(solution("aAcAabBdBdBb")); // AA BBB

		// 단어 둘
		System.out.println("-AAA B-");
		System.out.println(solution("AAAB")); // AAAB
		System.out.println(solution("AaAaAB")); // AAA B
		System.out.println(solution("aAAAaB")); // AAA B
		System.out.println(solution("bAaAaAbB")); // AAA B

		// 단어 둘
		System.out.println("-AAA BB-");
		System.out.println(solution("AAABB")); // AAABB
		System.out.println(solution("AAABcB")); // AAA BB
		System.out.println(solution("AaAaABB")); // AAA BB
		System.out.println(solution("AaAaABcB")); // AAA BB
		System.out.println(solution("aAAAaBB")); // AAA BB
		System.out.println(solution("aAAAaBcB")); // AAA BB
		System.out.println(solution("bAaAaAbBB")); // AAA BB
		System.out.println(solution("bAaAaAbBcB")); // AAA BB

		// 단어 둘
		System.out.println("-AAA BBB-");
		System.out.println(solution("AAABBB")); // AAABBB
		System.out.println(solution("AAABbBbB")); // AAA BBB
		System.out.println(solution("AAAbBBBb")); // AAA BBB
		System.out.println(solution("AAAbBaBaBb")); // AAA BBB
		System.out.println(solution("AaAaABBB")); // AAA BBB
		System.out.println(solution("AaAaABbBbB")); // AAA BBB
		System.out.println(solution("AaAaAbBBBb")); // AAA BBB
		System.out.println(solution("AaAaAbBcBcBb")); // AAA BBB
		System.out.println(solution("aAAAaBBB")); // AAA BBB
		System.out.println(solution("aAAAaBbBbB")); // AAA BBB
		System.out.println(solution("aAAAabBBBb")); // AAA BBB
		System.out.println(solution("aAAAacBdBdBc")); // AAA BBB
		System.out.println(solution("bAaAaAbBBB")); // AAA BBB
		System.out.println(solution("bAaAaAbBcBcB")); // AAA BBB
		System.out.println(solution("bAaAaAbcBBBc")); // AAA BBB
		System.out.println(solution("bAaAaAbcBdBdBc")); // AAA BBB
	}

	private static void test1() {
		// 단어 하나
		System.out.println("-A-");
		System.out.println(solution("A")); // A
		System.out.println(solution("aAa")); // A

		// 단어 하나
		System.out.println("-AA-");
		System.out.println(solution("AA")); // AA
		System.out.println(solution("AaA")); // AA
		System.out.println(solution("bAaAb")); // AA
		System.out.println(solution("bAAb")); // AA

		// 단어 하나
		System.out.println("-AAA-");
		System.out.println(solution("AAA")); // AAA
		System.out.println(solution("AaAaA")); // AAA
		System.out.println(solution("aAAAa")); // AAA
		System.out.println(solution("bAaAaAb")); // AAA
	}

	static boolean[] visited;
	static char[] c;
	static String ans;

	public static String solution(String sentence) {
		
		if (sentence.contains(" ")) { 
			return "invalid";
		}
		
		// 광고글
		// 규칙 1 특정 단어를 선택하고 글자 사이에 같은 기호를 넣는다
		// 규칙 2 특정 단어를 선택하고 단어 앞뒤에 같은 기호를 넣는다
		// 규칙 3 같은 단어에 규칙 1과 2가 동시에 적용될 수는 있지만 두번이상 적용되지는 않는다
		// 규칙 4 한번 쓰인 기호는 다시 쓰이지 않는다
		// 규칙 5 마지막으로 공백을 제거한다

		// 영문 대소문자 1000자가 입력된다
		// 대문자가 원래 문자
		// 소문자가 특수 기호를 의미한다
		// 변환된 문자열이 입력되면 가능한 원문 중 하나를 리턴한다. 없다면 invalid를 리턴한다

		visited = new boolean[26];
		c = new char[1000];
		ans = "";
		go(sentence, 0, 0);
		return ans.equals("") ? "invalid" : ans;
	}

	private static void go(String sentence, int idx, int cnt) {
		if (!ans.equals("")) {
			return;
		}
		if (idx == sentence.length()) {
			String s = String.copyValueOf(c, 0, cnt).trim();
			while (s.contains("  ")) {
				s = s.replace("  ", " ");
			}
			ans = s;
			return;
		}
		char now = sentence.charAt(idx);

		// abXXXba => invalid
		// aXbXbXa => XXX
		// aXbXa => XX
		// abXbXbXba => invalid 여야 논리적으로 말이 될 것이다
		// abXba => invalid 그렇지 않다면 한글자의 경우 이 경우 올바른 케이스가 된다
		// bXbXbXb => invalid

		// 현재 단어의 가능성은 규칙0(미적용), 규칙1, 규칙2, 규칙1+2 네가지 경우이다
		// 현재 글자가 소문자인 경우 규칙2와 규칙1+2 두가지 경우만을 생각할 수 있다

		if (Character.isUpperCase(now)) {
			// 규칙 2와 1+2는 else문에서 처리된다

			// 규칙 1
			// XaXaX (5글자 이상) || XaX (딱 3글자)

			// 규칙 0
			// XYZ || X

			// 현재 글자가 마지막 글자인 경우
			if (idx + 1 == sentence.length()) {
				c[cnt] = now;
				go(sentence, idx + 1, cnt + 1);
				return;
			}

			// 다음 글자가 대문자인 경우
			// XYaXXXa
			// XYaXaX
			char next = sentence.charAt(idx + 1);
			if (Character.isUpperCase(next)) {
				c[cnt] = now;
				go(sentence, idx + 1, cnt + 1);
				return;
			} else if (Character.isLowerCase(next)) {
				if (visited[next - 'a']) {
					return;
				}
				// 다음 글자가 소문자인 경우
				// YaXXXa => 다음 글자로
				// Ya => invalid
				c[cnt] = now;
				c[cnt + 1] = ' ';
				go(sentence, idx + 1, cnt + 2);
				if (!ans.equals("")) {
					return;
				}
				// 위 케이스가 아니라면 return 되어돌아온다
				// YaXaXaXa => invalid
				// YaXaXaX => 규칙 1 적용
				// YaXZ => 규칙 1 적용
				// YaXc => 규칙 1 적용
				// YaX => 규칙 1 적용
				// now + (소문자 + 대문자)*n 형태가 아니게 될때까지
				int n = 1;
				c[cnt++] = ' ';
				char first = now;
				c[cnt++] = now;
				char second = next;
				visited[next - 'a'] = true;
				char third = '0';
				while (idx + (n * 2) < sentence.length()) {
					second = sentence.charAt(idx + (n * 2) - 1);
					third = sentence.charAt(idx + (n * 2));
					if (second != next || Character.isLowerCase(third)) {
						break;
					}
					c[cnt++] = third;
					n++;
				}
				c[cnt++] = ' ';
				go(sentence, idx + ((n - 1) * 2) + 1, cnt);
				visited[next - 'a'] = false;
			}
			// 대문자도 소문자도 아니라면
			return;

		} else {
			if (visited[now - 'a']) {
				return;
			}
			// 첫 문자가 소문자라면 규칙2인 경우와 1+2인 경우
			int next = 0;
			for (int i = idx + 1; i < sentence.length(); i++) {
				if (sentence.charAt(i) == now) {
					next = i;
					break;
				}
			}
			if (next == 0) { // 소문자가 단독인 경우 바로 리턴 invalid
				return;
			}
			// idx부터 next까지 다른 소문자가 하나도 없다면 규칙2 있다면 1+2 그 외의 경우 invalid
			if (next != idx + 2) { // aXa 인 경우 바로 규칙 2만 적용됨으로 이동
				if (idx + 2 == sentence.length()) {
					return;
				}
				// aXbXbXa 형태만 허용된다
				char b = sentence.charAt(idx + 2); // 첫번째 b위치
				if (Character.isLowerCase(b)) {
					if (visited[b - 'a']) {
						return;
					}
					// 규칙 1도 적용되는 경우
					// 홀수항은 모두 대문자여야하고
					// 짝수항은 모두 같은 소문자여야 한다
					// aXbXbXa 형태 idx = a, b = b, next = a
					// 0123456
					if ((next - idx) % 2 != 0) {
						return;
					}
					for (int i = 1; i < next - idx; i++) {
						if (i % 2 == 0) { // 짝수항
							if (sentence.charAt(idx + i) != b) {
								return;
							}
						} else { // 홀수항
							if (!Character.isUpperCase(sentence.charAt(idx + i))) {
								return;
							} else {
								c[cnt++] = sentence.charAt(idx + i);
							}
						}
					}
					// 통과했다면 대문자를 모두 sb에 붙여준다
					visited[now - 'a'] = true;
					visited[b - 'a'] = true;
					c[cnt++] = ' ';
					go(sentence, next + 1, cnt);
					visited[now - 'a'] = false;
					visited[b - 'a'] = false;
					return;
				} else {
					// 규칙 2만 적용되는 경우
					// 하나라도 소문자가 있다면 리턴
					for (int i = idx + 1; i < next; i++) {
						if (Character.isLowerCase(sentence.charAt(i))) {
							return;
						}
					}
					// 소문자가 없다면 아래로 내려간다
				}
			}
			if (!Character.isLowerCase(sentence.charAt(idx + 1))) {
				visited[now - 'a'] = true;
				for (int i = idx + 1; i < next; i++) {
					c[cnt++] = sentence.charAt(i);
				}
				c[cnt++] = ' ';
				go(sentence, next + 1, cnt);
				visited[now - 'a'] = false;
			}
		}
	}

	/**
	 * 비교용 
	 * 다른 사람의 통과한 답안 아무거나
	 */
	static String solution2(String sentence) {
		try {
			String answer = "";

			ArrayDeque<Character> input = new ArrayDeque<>();
			int[] use = new int[26];
			for (int i = 0; i < sentence.length(); i++) {
				input.add(sentence.charAt(i));
				if (sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z') {
					use[sentence.charAt(i) - 'a']++;
				}
			}

			while (!input.isEmpty()) {
				char firstInput = input.poll();
				ArrayDeque<Character> word = new ArrayDeque<>();

				if (firstInput >= 'a' && firstInput <= 'z') { // 시작값이 소문자
					if (use[firstInput - 'a'] != 2)
						return "invalid";
					if (input.peek() >= 'a' && input.peek() <= 'z')
						return "invalid";
					word.add(input.poll());
					char thirdInput = input.poll();
					if (thirdInput >= 'a' && thirdInput <= 'z' && thirdInput != firstInput) { // 단어 안에 또 소문자가 있는 경우
						for (int i = 1; i < use[thirdInput - 'a']; i++) {
							if (input.peek() >= 'a' && input.peek() <= 'z')
								return "invalid";
							word.add(input.poll());
							if (input.poll() != thirdInput)
								return "invalid";
						}
						if (input.peek() >= 'a' && input.peek() <= 'z')
							return "invalid";
						word.add(input.poll());
						if (input.poll() != firstInput)
							return "invalid";
					} else if (thirdInput != firstInput) { // 앞뒤에만 있는 경우
						word.add(thirdInput);
						while (input.peek() != firstInput) {
							if (input.peek() >= 'a' && input.peek() <= 'z')
								return "invalid";
							word.add(input.poll());
						}
						input.poll();
					}
				} else { // 시작값이 대문자
					word.add(firstInput);
					if (input.isEmpty()) {
						return answer + word.poll();
					}
					char secondInput = input.poll();
					if (secondInput >= 'a' && secondInput <= 'z') {
						if (use[secondInput - 'a'] == 2) {
							input.addFirst(secondInput);
						} else {
							for (int i = 1; i < use[secondInput - 'a']; i++) {
								if (input.peek() >= 'a' && input.peek() <= 'z')
									return "invalid";
								word.add(input.poll());
								if (input.poll() != secondInput)
									return "invalid";
							}
							if (input.peek() >= 'a' && input.peek() <= 'z')
								return "invalid";
							word.add(input.poll());
						}
					} else {
						word.add(secondInput);
						if (input.isEmpty()) {
							return answer + word.poll() + word.poll();
						}
						while (input.peek() >= 'A' && input.peek() <= 'Z') {
							word.add(input.poll());
							if (input.isEmpty())
								break;
						}
						if (!input.isEmpty()) {
							if (use[input.peek() - 'a'] != 2) {
								input.addFirst(word.pollLast());
							}
						}
					}
				}
				while (!word.isEmpty()) {
					answer += word.poll();
				}
				if (!input.isEmpty())
					answer += " ";
			}
			return answer;
		} catch (Exception e) {
			return "invalid";
		}
	}
}