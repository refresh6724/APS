import java.util.HashMap;
import java.util.Scanner;

public class Solution_D4_4261_빠른휴대전화키패드 { // 제출일 2019-11-08 13:26
	static char[] S;
	static int N;
	static HashMap<Character, Character> keypad;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		keypad = new HashMap<>();
		keypad.put('a', '2');
		keypad.put('b', '2');
		keypad.put('c', '2');
		keypad.put('d', '3');
		keypad.put('e', '3');
		keypad.put('f', '3');
		keypad.put('g', '4');
		keypad.put('h', '4');
		keypad.put('i', '4');
		keypad.put('j', '5');
		keypad.put('k', '5');
		keypad.put('l', '5');
		keypad.put('m', '6');
		keypad.put('n', '6');
		keypad.put('o', '6');
		keypad.put('p', '7');
		keypad.put('q', '7');
		keypad.put('r', '7');
		keypad.put('s', '7');
		keypad.put('t', '8');
		keypad.put('u', '8');
		keypad.put('v', '8');
		keypad.put('w', '9');
		keypad.put('x', '9');
		keypad.put('y', '9');
		keypad.put('z', '9');
		
		for (int t = 1; t <= T; t++) {
			S = sc.next().toCharArray();
			int size = S.length;
			N = sc.nextInt();
			answer = 0;
			
			next:
			for (int i = 0; i < N; i++) {
				char[] input = sc.next().toCharArray();
				int len = input.length;
				if(len != size) continue;
				for (int j = 0; j < len; j++) {
					if(keypad.get(input[j]) != S[j]) continue next; 
				}
				answer++;
			}
			// 입력 종료
			
			
			System.out.println(String.format("#%d %d", t,answer));
			
		}
	}

}
