public class Main_JO_536_자가진단1 { // 제출일 2021-01-07 20:56

	public static void main(String[] args) {

		// 1부터 15까지 차례로 출력하는 프로그램을 작성하시오.
		// while문을 이용하세요.
		int a = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(a++);
		while (a < 16) {
			sb.append(' ').append(a++);
		}
		System.out.println(sb.toString());
	}
}