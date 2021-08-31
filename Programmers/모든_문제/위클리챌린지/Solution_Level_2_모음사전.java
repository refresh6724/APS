public class Solution_Level_2_모음사전 { // 제출일 2021-08-31 23:43

	// test
	public static void main(String[] args) {
		System.out.println(solution("EIO")); // 1189
	}

	public static int solution(String word) {
		// 첫글자로 올 수 있는 글자 5
		// a aa aaa aaaa aaaaa aaaae aaaai aaaao aaaau
		// x xx xxx aaae aaaea aaaee aaaei aaaeo aaaeu
		// x xx xxx aaai aaaia aaaie aaaii aaaio aaaiu
		// x xx xxx aaao aaaoa aaaoe aaaoi aaaoo aaaou
		// x xx xxx aaau aaaua aaaue aaaui aaauo aaauu
		// x xx aae aaea aaeaa aaeae aaeai aaeao aaeau
		//
		// a 1 aa 2 auuuu 781
		// e 782 ea 783
		// i 1563 ia 1564
		// o 2344 oa 2345
		// u 3125 ua 3126
		// uuuuu 3905
		//
		// aaae = aaaa + (aaaaa ~ aaaau) 5 * 1 = 5 6
		// aae = aaa + (aaaa ~ aaau) 5 * (1 + 5) = 30 31
		// ae = aa + (aaa ~ aau) 5 * (1 + 5 + 25) = 155 156
		// e = a + (aa ~ au) 5 * (1 + 5 + 25 + 125) = 780 781
		//
		// eio = ei + 31 * 3 + 1
		// ei = e + 156 * 2 + 1
		// e = 781 * 1 + 1
		// eio = 782 + 313 + 94 = 1189

		return calc(word.replace('A', '0').replace('E', '1').replace('I', '2').replace('O', '3').replace('U', '4'));
	}

	static int[] cnt = { 781, 156, 31, 6, 1 };

	private static int calc(String replace) {
		int sum = 0;
		for (int i = 0; i < replace.length(); i++) {
			sum += (replace.charAt(i) - '0') * cnt[i] + 1;
		}
		return sum;
	}
}
