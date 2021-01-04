import java.io.IOException;

public class Main_JO_119_형성평가4 { // 제출일 2021-01-04 23:16

	public static void main(String[] args) throws IOException {
		java.util.Calendar cal = java.util.Calendar.getInstance();

		int a = 0;
		a = cal.get(java.util.Calendar.YEAR) - 1900; // ---① 2021 - 1900 = 121
		// System.out.println(cal.get(java.util.Calendar.YEAR) - 1900);
		a += cal.get(java.util.Calendar.MONTH); // ---② 121 += 0
		// System.out.println(cal.get(java.util.Calendar.MONTH)); // 1 월은 0
		a += cal.get(java.util.Calendar.DATE); // 121 += 4
		// System.out.println(cal.get(java.util.Calendar.DATE));
		System.out.printf("%d %d %d ", 0, 121, 125); // ---③ //① ② ③에서의 a값을 1, 2, 3자리에 각각 써 넣는다.
	}

}