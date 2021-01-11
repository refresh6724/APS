public class Main_JO_547_자가진단7 { // 제출일 2021-01-11 22:09

	public static void main(String[] args) throws Exception {

		// 출력
//		2 3 4 5 6
//		3 4 5 6 7
//		4 5 6 7 8
//		5 6 7 8 9
//		6 7 8 9 10​

		StringBuilder sb = new StringBuilder();
		for (int start = 2; start <= 6; start++) {
			sb.append(start);
			for (int plus = 1; plus <= 4; plus++) {
				sb.append(' ').append(start + plus);
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());

	}
}