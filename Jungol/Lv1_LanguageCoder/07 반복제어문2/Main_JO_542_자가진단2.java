public class Main_JO_542_자가진단2 { // 제출일 2021-01-11 22:02

	public static void main(String[] args) throws Exception {

		// 10부터 20까지의 숫자를 차례대로 출력하는 프로그램을 작성하시오.for문을 사용하세요.

		StringBuilder sb = new StringBuilder();
		sb.append(10);
		for (int i = 11; i <= 20; i++) {
			sb.append(' ').append(i);
		}
		System.out.println(sb.toString());

	}
}